 package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class ProgramSolucao1 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null ;
		
		try {
			conn = DB.getConnection();
			
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO seller ");
			query.append("(Name, Email, BirthDate, BaseSalary, DepartmentId) ");
			query.append("VALUES ");
			query.append("(?, ?, ?, ?, ?)");			
			st = conn.prepareStatement(query.toString());
			
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();		
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
