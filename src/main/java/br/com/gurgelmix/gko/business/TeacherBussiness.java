package br.com.gurgelmix.gko.business;


import br.com.gurgelmix.gko.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherBussiness {
    List<Teacher> findAll(Pageable pageable);
    Teacher findById(int id);
    Teacher createTeacher(Teacher p) ;
    Teacher updateTeacher(int id, Teacher p);
    void deleteTeacher(int id);
    Page<Teacher> listapaginada(Pageable pageable);

}
