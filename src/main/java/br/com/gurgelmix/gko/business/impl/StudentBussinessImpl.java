package br.com.gurgelmix.gko.business.impl;

import br.com.gurgelmix.gko.business.StudentBussiness;
import br.com.gurgelmix.gko.model.Student;
import br.com.gurgelmix.gko.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBussinessImpl implements StudentBussiness {

    private StudentRepository studentRepository;

    @Autowired
    public StudentBussinessImpl(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> findByNome(String nome) {
        return studentRepository.findByNomeContains(nome);
    }


    @Override
    public Student createStudent(Student p) {
        return studentRepository.save(p);
    }

    @Override
    public Student updateStudent(int id, Student p) {
        Student student = studentRepository.findById(id).get();
        student.setNome(p.getNome());
        student.setCpf(p.getCpf());
        student.setDataNascimento(p.getDataNascimento());
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }

    @Override
    public Page<Student> listapaginada(Pageable pageable) {
       return studentRepository.findAll(pageable);
    }


}
