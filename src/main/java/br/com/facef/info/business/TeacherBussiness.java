package br.com.facef.info.business;

import br.com.facef.info.model.Teacher;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherBussiness {
    List<Teacher> findAll(Pageable pageable);
    Teacher findById(int id);
    Teacher createTeacher(Teacher p) ;
    Teacher updateTeacher(int id, Teacher p);
    void deleteTeacher(int id);

}
