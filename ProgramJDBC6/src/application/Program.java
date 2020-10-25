 package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null ;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			
			StringBuilder query = new StringBuilder();
			query.append("DELETE FROM department ");
			query.append("WHERE ");
			query.append("Id = ?");			
			st = conn.prepareStatement(query.toString());
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

			//int x = 1;
			//if (x < 2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("rows1 = " + rows1);
			System.out.println("rows2 = " + rows2);
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transação revertida! Causado por: " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new DBException("Erro ao tentar reverter! Causado por: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
