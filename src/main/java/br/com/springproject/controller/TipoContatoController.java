package br.com.springproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springproject.model.TipoContato;
import br.com.springproject.repository.TipoContatoRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class TipoContatoController {
	
	@Autowired
	private TipoContatoRepository repository;
	
	@Getter @Setter
	private List<TipoContato> list;
	
	@PostConstruct
	public void init() {
		setList(repository.findAll());
	}
}
