package br.com.facef.info.repository;

import br.com.facef.info.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {

    List<Class> findByNome(String nome);


}
