 package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DBIntegrityException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null ;
		
		try {
			conn = DB.getConnection();
			
			StringBuilder query = new StringBuilder();
			query.append("DELETE FROM department ");
			query.append("WHERE ");
			query.append("Id = ?");			
			st = conn.prepareStatement(query.toString());
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DBIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
