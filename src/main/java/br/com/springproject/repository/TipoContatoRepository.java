package br.com.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.springproject.model.TipoContato;

@Repository
public interface TipoContatoRepository extends JpaRepository<TipoContato, Integer>{
	
	@Query("select tipo from TipoContato tipo")
	public List<TipoContato> buscarTodos();
	
	@Query("select tipo from TipoContato tipo where tipo.id=:id")
	public TipoContato buscarPorId(@Param("id") Integer id);
}
