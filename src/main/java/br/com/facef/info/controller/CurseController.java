package br.com.facef.info.controller;

import br.com.facef.info.business.CurseBussiness;
import br.com.facef.info.business.TeacherBussiness;
import br.com.facef.info.exception.Response;
import br.com.facef.info.model.Curse;
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
@RequestMapping("/v1/cursos")
public class CurseController {

    private CurseBussiness curseBussiness;

    @Autowired
    public CurseController(CurseBussiness curseBussiness){
        this.curseBussiness = curseBussiness;
    }

    @GetMapping(value ="/listarTodos")
    public ResponseEntity<?> findAll(@PageableDefault(size=10)Pageable pageable){
        return ResponseEntity.ok(curseBussiness.findAll(pageable));
    }

    @GetMapping(value = "/buscarCursoPorId/{id}")
    public ResponseEntity<?> findBy(@PathVariable int id){
        Curse curse = curseBussiness.findById(id);
        if (curse == null){
            new Response("Professor não encontrado no id " + id);
        }
        return ResponseEntity.ok(curseBussiness.findById(id));
    }

    @PostMapping(value ="/criarCruso")
    public ResponseEntity<Curse> post(@RequestBody Curse curse){
        return ResponseEntity.status(HttpStatus.CREATED).body(curseBussiness.createCurse(curse));
    }

    @PutMapping(value = "/atualizarCurso/{id}")
    public ResponseEntity<Curse> put(@PathVariable("id") int id, @RequestBody Curse curse){
        return ResponseEntity.status(HttpStatus.OK).body(curseBussiness.updateCurse(id, curse));
    }

    @DeleteMapping(value ="/apagarCurso/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        curseBussiness.deleteCurse(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + " excluido com sucesso");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List <Curse>> find(Pageable pageable){
        return ResponseEntity.ok().body(curseBussiness.findAll(pageable));
    }

}
