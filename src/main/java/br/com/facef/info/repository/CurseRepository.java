package br.com.facef.info.repository;

import br.com.facef.info.model.Curse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurseRepository extends JpaRepository<Curse, Integer> {

    List<Curse> findByNome(String nome);


}
