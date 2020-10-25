package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartamentoDAO;
import model.entities.Departamento;

public class Program2 {
	public static void main(String[] args) {
		
		DepartamentoDAO departamentoDAO = DAOFactory.createDepartamentoDAO();
		
		System.out.println("=== TEST 1: departamento findById =====");
		Departamento departamento = departamentoDAO.findById(3);
		System.out.println(departamento);
		
		System.out.println("\n=== TEST 2: departamento findAll =====");
		List<Departamento> list = departamentoDAO.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: departamento insert =====");
		Departamento novoDepartamento = new Departamento(null, "DTESTE");
		departamentoDAO.insert(novoDepartamento);
		System.out.println("Inserido! Novo id = " + novoDepartamento.getId());
		
		System.out.println("\n=== TEST 4: departamento update =====");
		departamento = departamentoDAO.findById(6);
		departamento.setNome("DEPARTAMENTO ATUALIZADO");
		departamentoDAO.update(departamento);
		System.out.println("Update completo");
		
		System.out.println("\n=== TEST 5: departamento delete =====");
		departamentoDAO.deleteById(7);
		System.out.println("Delete completado");
		
	}
}
