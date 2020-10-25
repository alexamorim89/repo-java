package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		VendedorDAO vendedorDAO = DAOFactory.createVendedorDAO();
		
		System.out.println("=== TEST 1: vendedor findById =====");
		Vendedor vendedor = vendedorDAO.findById(3);		
		System.out.println(vendedor);
		
		System.out.println("\n=== TEST 2: vendedor findByDepartment =====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDAO.findByDepartment(departamento);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: vendedor findAll =====");
		list = vendedorDAO.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: vendedor insert =====");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDAO.insert(novoVendedor);
		System.out.println("Inserido! Novo id = " + novoVendedor.getId());
		
		System.out.println("\n=== TEST 5: vendedor update =====");
		vendedor = vendedorDAO.findById(6);
		vendedor.setNome("Martha Waine");
		vendedorDAO.update(vendedor);
		System.out.println("Update completo");
		
		System.out.println("\n=== TEST 6: vendedor delete =====");
		System.out.println("Insira a id para excluir o teste: ");
		int id = sc.nextInt();
		vendedorDAO.deleteById(id);
		System.out.println("Delete completado");
		
		sc.close();
	}

}
