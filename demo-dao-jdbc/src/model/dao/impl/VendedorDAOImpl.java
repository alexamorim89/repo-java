package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DBException;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDAOImpl implements VendedorDAO {
	
	Connection conn = null;
	
	public VendedorDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Vendedor vendedor) {
		PreparedStatement st = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO seller ");
			query.append("(Name, Email, BirthDate, BaseSalary, DepartmentId) ");
			query.append("VALUES ");
			query.append("(?, ?, ?, ?, ?)");
			st = conn.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, vendedor.getNome());
			st.setString(2, vendedor.getEmail());
			st.setDate(3,   new java.sql.Date(vendedor.getDataNascimento().getTime()));
			st.setDouble(4, vendedor.getSalarioBase());
			st.setInt(5, vendedor.getDepartamento().getId());
			
			int rowsAffected = st.executeUpdate();
			conn.commit();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					vendedor.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DBException("Erro inesperado! Nenhuma linha afetada!");
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transação revertida! Causado por: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("Erro ao tentar rollback! Causado por:" + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
		}		
	}

	@Override
	public void update(Vendedor vendedor) {
		PreparedStatement st = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("UPDATE seller ");
			query.append("SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? ");
			query.append("WHERE Id = ?");
			st = conn.prepareStatement(query.toString());
			
			st.setString(1, vendedor.getNome());
			st.setString(2, vendedor.getEmail());
			st.setDate(3,   new java.sql.Date(vendedor.getDataNascimento().getTime()));
			st.setDouble(4, vendedor.getSalarioBase());
			st.setInt(5, vendedor.getDepartamento().getId());
			st.setInt(6, vendedor.getId());
			
			st.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transação revertida! Causado por:" + e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("Erro ao tentar rollback! Causado por:" +  e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transação revertida! Causado por:" + e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("Erro ao tentar rollback! Causado por:" +  e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
		}		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("SELECT seller.*,department.Name as DepName ");
			query.append("FROM seller INNER JOIN department ");
			query.append("ON seller.DepartmentId = department.Id ");
			query.append("WHERE seller.Id = ? ");
			st = conn.prepareStatement(query.toString());
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento departamento = instanciaDepartamento(rs);				
				Vendedor vendedor = instanciaVendedor(rs, departamento);
				
				return vendedor;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}		
	}


	@Override
	public List<Vendedor> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("SELECT seller.*,department.Name as DepName ");
			query.append("FROM seller INNER JOIN department ");
			query.append("ON seller.DepartmentId = department.Id ");
			query.append("ORDER BY Name ");			
			st = conn.prepareStatement(query.toString());
			
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<Integer, Departamento>();
			
			while (rs.next()) {
				Departamento departamento = map.get(rs.getInt("DepartmentId"));
				
				if (departamento == null) {
					departamento = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), departamento);
				}
				Vendedor vendedor = instanciaVendedor(rs, departamento);
				list.add(vendedor);
				
			}
			
			return list;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public List<Vendedor> findByDepartment(Departamento departmento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("SELECT seller.*,department.Name as DepName ");
			query.append("FROM seller INNER JOIN department ");
			query.append("ON seller.DepartmentId = department.Id ");
			query.append("WHERE DepartmentId = ? ");
			query.append("ORDER BY Name ");			
			st = conn.prepareStatement(query.toString());
			
			st.setInt(1, departmento.getId());
			
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<Integer, Departamento>();
			
			while (rs.next()) {
				Departamento departamento = map.get(rs.getInt("DepartmentId"));
				
				if (departamento == null) {
					departamento = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), departamento);
				}
				Vendedor vendedor = instanciaVendedor(rs, departamento);
				list.add(vendedor);
				
			}
			
			return list;
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}		
	}

	private Vendedor instanciaVendedor(ResultSet rs, Departamento departamento) throws SQLException {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(rs.getInt("Id"));
		vendedor.setNome(rs.getString("Name"));
		vendedor.setEmail(rs.getString("Email"));
		vendedor.setDataNascimento(rs.getDate("BirthDate"));
		vendedor.setSalarioBase(rs.getDouble("BaseSalary"));
		vendedor.setDepartamento(departamento);
		return vendedor;
	}
	
	private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId(rs.getInt("DepartmentId"));
		departamento.setNome(rs.getString("DepName"));
		return departamento;
	}
	
}