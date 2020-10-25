package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = DB.getConnection();
		DB.closeConnection();

	}

}
