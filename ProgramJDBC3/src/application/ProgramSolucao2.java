package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class ProgramSolucao2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO department (Name) ");
			query.append("VALUES ('D1'),('D2') ");
			
			st = conn.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = st.executeUpdate();			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done: id: " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}  finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}		
	}
}
