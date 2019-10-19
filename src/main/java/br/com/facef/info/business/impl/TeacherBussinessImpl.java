package br.com.facef.info.business.impl;


import br.com.facef.info.business.TeacherBussiness;

import br.com.facef.info.model.Teacher;
import br.com.facef.info.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherBussinessImpl implements TeacherBussiness {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherBussinessImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable).getContent();
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id).get();
    }


    @Override
    public Teacher createTeacher(Teacher p) {
        return teacherRepository.save(p);
    }

    @Override
    public Teacher updateTeacher(int id, Teacher p) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacher.setNome(p.getNome());
        teacher.setCpf(p.getCpf());
        teacher.setDataNascimento(p.getDataNascimento());
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherRepository.delete(teacher);
    }


}
