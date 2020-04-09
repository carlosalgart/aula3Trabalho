package br.com.gurgelmix.gko.repository;

import br.com.gurgelmix.gko.model.Matter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatterRepository extends JpaRepository<Matter, Integer> {

    List<Matter> findByNome(String nome);


}
