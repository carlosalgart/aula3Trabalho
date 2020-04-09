package br.com.gurgelmix.gko.controller;


import br.com.gurgelmix.gko.business.TeacherBussiness;
import br.com.gurgelmix.gko.exception.Response;
import br.com.gurgelmix.gko.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping(value="/listarPagina")
    public List<Teacher> getAllTeachers(@RequestParam(defaultValue = "0", required = false) Integer pageNumber) {
        Pageable paging = PageRequest.of(pageNumber, 10);//, Sort.by("nome").descending());
        Page<Teacher> pagedResult = teacherBussiness.listapaginada(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Teacher>();
        }
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
