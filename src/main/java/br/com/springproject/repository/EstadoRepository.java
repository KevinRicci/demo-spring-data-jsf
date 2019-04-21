package br.com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.springproject.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

	@Query("select e from Estado e where e.id=:id")
	public Estado encontrePeloId(@Param("id") Integer id);
}
