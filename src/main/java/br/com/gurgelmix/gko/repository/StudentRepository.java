package br.com.gurgelmix.gko.repository;

import br.com.gurgelmix.gko.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNomeContains(String nome);


}
