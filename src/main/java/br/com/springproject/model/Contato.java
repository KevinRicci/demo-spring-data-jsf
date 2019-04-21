package br.com.springproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
	@Id @GeneratedValue
	private Integer id;
	
	private String descricao;
	
	@JoinColumn
	@ManyToOne
	private Cliente cliente;
	
	@JoinColumn
	@ManyToOne(fetch=FetchType.EAGER)
	private TipoContato tipoContato;
}
