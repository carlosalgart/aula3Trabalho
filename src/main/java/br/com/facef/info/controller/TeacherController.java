package br.com.facef.info.controller;

import br.com.facef.info.business.StudentBussiness;
import br.com.facef.info.business.TeacherBussiness;
import br.com.facef.info.exception.Response;
import br.com.facef.info.model.Student;
import br.com.facef.info.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/professores")
public class TeacherController {

    private TeacherBussiness teacherBussiness;

    @Autowired
    public TeacherController(TeacherBussiness teacherBussiness){
        this.teacherBussiness = teacherBussiness;
    }

    @GetMapping(value ="/listarTodos")
    public ResponseEntity<?> findAll(@PageableDefault(size=10)Pageable pageable){
        return ResponseEntity.ok(teacherBussiness.findAll(pageable));
    }

    @GetMapping(value = "/buscarProfessorPorId/{id}")
    public ResponseEntity<?> findBy(@PathVariable int id){
        Teacher teacher = teacherBussiness.findById(id);
        if (teacher == null){
            new Response("Professor não encontrado no id " + id);
        }
        return ResponseEntity.ok(teacherBussiness.findById(id));
    }

    @PostMapping(value ="/criarProfessor")
    public ResponseEntity<Teacher> post(@RequestBody Teacher teacher){
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherBussiness.createTeacher(teacher));
    }

    @PutMapping(value = "/atualizarProfessor/{id}")
    public ResponseEntity<Teacher> put(@PathVariable("id") int id, @RequestBody Teacher teacher){
        return ResponseEntity.status(HttpStatus.OK).body(teacherBussiness.updateTeacher(id, teacher));
    }

    @DeleteMapping(value ="/apagarProfessor/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        teacherBussiness.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + " excluido com sucesso");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List <Teacher>> find(Pageable pageable){
        return ResponseEntity.ok().body(teacherBussiness.findAll(pageable));
    }

}
