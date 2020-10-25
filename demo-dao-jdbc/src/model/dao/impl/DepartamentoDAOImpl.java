package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.DepartamentoDAO;
import model.entities.Departamento;

public class DepartamentoDAOImpl implements DepartamentoDAO {
	
	private Connection conn;
	
	public DepartamentoDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Departamento departamento) {
		PreparedStatement st = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO department ");
			query.append("(Name) VALUES (?)");
			st = conn.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, departamento.getNome());
			
			int rowsAffected = st.executeUpdate();
			conn.commit();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					departamento.setId(id);
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
	public void update(Departamento departamento) {
		PreparedStatement st = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("UPDATE department ");
			query.append("SET Name = ? ");
			query.append("WHERE Id = ?");
			st = conn.prepareStatement(query.toString());
			
			st.setString(1, departamento.getNome());
			st.setInt(2, departamento.getId());
			
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
			st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			
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
	public Departamento findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String query = "SELECT Id, Name FROM department WHERE Id = ?";
			st = conn.prepareStatement(query);
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento departamento = instanciaDepartamento(rs);
				return departamento;
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
	public List<Departamento> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			StringBuilder query = new StringBuilder();
			query.append("SELECT Id, Name FROM department ");
			query.append("ORDER BY Id");
			st = conn.prepareStatement(query.toString());
			
			rs = st.executeQuery();
			
			List<Departamento> list = new ArrayList<Departamento>();
			while (rs.next()) {
				Departamento departamento = instanciaDepartamento(rs);
				list.add(departamento);
			}			
			return list;
		
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	
	private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId(rs.getInt("Id"));
		departamento.setNome(rs.getString("Name"));
		return departamento;
	}

}
