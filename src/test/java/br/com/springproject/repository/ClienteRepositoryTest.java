package br.com.springproject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.springproject.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,replace=Replace.NONE)
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Test
	public void testSalvar() {
		Cliente cli = new Cliente("João");
		Cliente cliSalvo = clienteRepository.save(cli);
		assertThat(cliSalvo.getId() != null);
	}
	
	@Test
	public void testBuscarPorEmail() {
		Cliente cliente = new Cliente("Robson");
		entityManager.persist(cliente);
		
	}
	
	@Test
	public void testBuscarTodos() {
		Cliente cliente1 = new Cliente("Marcos");
		Cliente cliente2 = new Cliente("Lucas");
		entityManager.persist(cliente1);
		entityManager.persist(cliente2);
		
		List<Cliente> list = clienteRepository.buscarTodos();
		assertThat(list.get(0).getNome().equals("Marcos"));
		assertThat(list.get(1).getNome().equals("Lucas"));
	}
}
