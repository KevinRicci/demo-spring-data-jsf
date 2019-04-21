package br.com.springproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springproject.model.Cliente;
import br.com.springproject.model.Contato;
import br.com.springproject.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Getter @Setter
	private Cliente cliente = new Cliente();
	
	@Getter @Setter
	private Contato contato = new Contato();
	
	@Getter @Setter
	private List<Cliente> list;

	@Getter @Setter
	private boolean modoEdicao = false;
	
	@PostConstruct
	public void init() {
		setList(clienteRepository.findAll());
	}
	
	public void excluir(Cliente c) {
		clienteRepository.delete(c);
		list.remove(c);
	}
	
	public void editar(Cliente c) {
		setCliente(c);
		setModoEdicao(true);
	}
	
	public void cancelar() {
		cliente = new Cliente();
		setModoEdicao(false);
	}
	
	public void salvar() {
		clienteRepository.save(cliente); 
		if(!modoEdicao) {
			list.add(cliente); //pode salvar o mesmo objeto pois ele foi salvo pelo jpa, e o jpa retorna o objeto persistido
		}
		cliente = new Cliente();
		setModoEdicao(false);
	}
	
	public void adicionarContato() {
		this.contato.setCliente(cliente);
		
	    cliente.getContatos().add(contato);
		this.contato = new Contato();
	}
	
	public void excluirContato(Contato c) {
		cliente.getContatos().remove(c);
	}
}
