package model.dao;

import db.DB;
import model.dao.impl.DepartamentoDAOImpl;
import model.dao.impl.VendedorDAOImpl;

public class DAOFactory {
	
	public static VendedorDAO createVendedorDAO() {
		return new VendedorDAOImpl(DB.getConnection());
	}

	public static DepartamentoDAO createDepartamentoDAO() {
		return new DepartamentoDAOImpl(DB.getConnection());
	}
}
