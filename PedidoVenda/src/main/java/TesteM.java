import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.TipoPessoa;

public class TesteM {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Cliente cliente1 = new Cliente(null, "fulano", "fulano@gmail.com", "123.123.123-12");
		cliente1.setTipo(TipoPessoa.FISICA);
		
		Cliente cliente2 = new Cliente(null, "ciclano", "ciclano@gmail,com", "111-111-11-11");
		cliente2.setTipo(TipoPessoa.FISICA);
		
		Endereco endereco2 = new Endereco(null, "222", null, "RIO DE JANEIRO", "RJ", "00000-000");
		endereco2.setLogradouro("Rua dos cajueiros");
				
		endereco2.setCliente(cliente2);
		cliente2.getEnderecos().add(endereco2);
		
		manager.persist(cliente2);
		
		tx.commit();
	}
	
}
