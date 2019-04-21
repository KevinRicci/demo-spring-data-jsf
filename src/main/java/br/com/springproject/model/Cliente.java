package br.com.springproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id @GeneratedValue
	private Integer id;
	
	private String nome;
	
	@JoinColumn
	@ManyToOne
	private Estado estado;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cliente", fetch=FetchType.EAGER)
	private List<Contato> contatos = new ArrayList<>(); 
	
	public Cliente(String nome) {
		this.nome = nome;
	}
}