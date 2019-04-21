package br.com.springproject.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springproject.model.Estado;
import br.com.springproject.repository.EstadoRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class EstadoController {

	@Autowired
	private EstadoRepository repository;
	
	@Getter @Setter
	private List<Estado> list;
	
	@PostConstruct
	public void init() {
		setList(repository.findAll());
	}
}
