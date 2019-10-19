package br.com.facef.info.repository;

import br.com.facef.info.model.Class;
import br.com.facef.info.model.Matter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatterRepository extends JpaRepository<Matter, Integer> {

    List<Matter> findByNome(String nome);


}
