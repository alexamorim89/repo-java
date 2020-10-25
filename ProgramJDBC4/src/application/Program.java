 package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null ;
		
		try {
			conn = DB.getConnection();
			
			StringBuilder query = new StringBuilder();
			query.append("UPDATE seller ");
			query.append("SET BaseSalary = BaseSalary + ? ");
			query.append("WHERE ");
			query.append("(DepartmentId = ?)");			
			st = conn.prepareStatement(query.toString());
			
			st.setDouble(1, 100.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();		
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
