package br.com.gurgelmix.gko.repository;

import br.com.gurgelmix.gko.model.Curse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurseRepository extends JpaRepository<Curse, Integer> {

    List<Curse> findByNome(String nome);


}
