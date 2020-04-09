package br.com.gurgelmix.gko.repository;


import br.com.gurgelmix.gko.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByNome(String nome);


}
