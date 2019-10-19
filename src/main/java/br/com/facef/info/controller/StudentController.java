package br.com.facef.info.controller;

import br.com.facef.info.business.StudentBussiness;
import br.com.facef.info.exception.Response;
import br.com.facef.info.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
public class StudentController {

    private StudentBussiness studentBussiness;

    @Autowired
    public StudentController(StudentBussiness studentBussiness){
        this.studentBussiness = studentBussiness;
    }

    @GetMapping(value ="/listarTodos")
    public ResponseEntity<?> findAll(@PageableDefault(size=10)Pageable pageable){
        return ResponseEntity.ok(studentBussiness.findAll(pageable));
    }

    @GetMapping(value="/listarPagina")
    public List<Student> getAllStudents(@RequestParam(defaultValue = "0", required = false) Integer pageNumber) {
        Pageable paging = PageRequest.of(pageNumber, 10);//, Sort.by("nome").descending());
        Page<Student> pagedResult = studentBussiness.listapaginada(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Student>();
        }
    }

    @GetMapping(value = "/buscarAlunoPorId/{id}")
    public ResponseEntity<?> findBy(@PathVariable int id){
        Student student = studentBussiness.findById(id);
        if (student == null){
            new Response("Aluno não encontrado no id " + id);
        }
        return ResponseEntity.ok(studentBussiness.findById(id));
    }

    @GetMapping(value = "/buscarAlunoPorNome/{nome}")
    public ResponseEntity<?> findByNome(@PathVariable String nome){
        List<Student> students = studentBussiness.findByNome(nome);
        if (students == null){
            new Response("Aluno não encontrado no nome " + nome);
        }
        return ResponseEntity.ok(studentBussiness.findByNome(nome));
    }


    @PostMapping(value ="/criarAluno")
    public ResponseEntity<Student> post(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentBussiness.createStudent(student));
    }

    @PutMapping(value = "/atualizarAluno/{id}")
    public ResponseEntity<Student> put(@PathVariable("id") int id, @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK).body(studentBussiness.updateStudent(id, student));
    }

    @DeleteMapping(value ="/apagarAluno/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        studentBussiness.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + " excluido com sucesso");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List <Student>> find(Pageable pageable){
        return ResponseEntity.ok().body(studentBussiness.findAll(pageable));
    }

}
