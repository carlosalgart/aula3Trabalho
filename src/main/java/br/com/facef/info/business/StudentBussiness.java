package br.com.facef.info.business;

import br.com.facef.info.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface StudentBussiness {
    List<Student> findAll(Pageable pageable);
    Student findById(int id);
    Student createStudent(Student p) ;
    Student updateStudent(int id, Student p);
    void deleteStudent(int id);
    Page<Student> listapaginada(Pageable pageable);
    List<Student> findByNome(String nome);
}
