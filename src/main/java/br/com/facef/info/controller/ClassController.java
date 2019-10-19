package br.com.facef.info.controller;

import br.com.facef.info.business.ClassBussiness;
import br.com.facef.info.business.CurseBussiness;
import br.com.facef.info.exception.Response;
import br.com.facef.info.model.Class;
import br.com.facef.info.model.Curse;
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
@RequestMapping("/v1/classes")
public class ClassController {

    private ClassBussiness classBussiness;

    @Autowired
    public ClassController(ClassBussiness classBussiness){
        this.classBussiness = classBussiness;
    }

    @GetMapping(value ="/listarTodos")
    public ResponseEntity<?> findAll(@PageableDefault(size=10)Pageable pageable){
        return ResponseEntity.ok(classBussiness.findAll(pageable));
    }

    @GetMapping(value="/listarPagina")
    public List<Class> getAllClass(@RequestParam(defaultValue = "0", required = false) Integer pageNumber) {
        Pageable paging = PageRequest.of(pageNumber, 10);//, Sort.by("nome").descending());
        Page<Class> pagedResult = classBussiness.listapaginada(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Class>();
        }
    }

    @GetMapping(value = "/buscarClassePorId/{id}")
    public ResponseEntity<?> findBy(@PathVariable int id){
        Class aClass = classBussiness.findById(id);
        if (aClass == null){
            new Response("Classe não encontrado no id " + id);
        }
        return ResponseEntity.ok(classBussiness.findById(id));
    }

    @PostMapping(value ="/criarClasse")
    public ResponseEntity<Class> post(@RequestBody Class aClass){
        return ResponseEntity.status(HttpStatus.CREATED).body(classBussiness.createClass(aClass));
    }

    @PutMapping(value = "/atualizarClasse/{id}")
    public ResponseEntity<Class> put(@PathVariable("id") int id, @RequestBody Class aClass){
        return ResponseEntity.status(HttpStatus.OK).body(classBussiness.updateClass(id, aClass));
    }

    @DeleteMapping(value ="/apagarClasse/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        classBussiness.deleteClass(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + " excluido com sucesso");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List <Class>> find(Pageable pageable){
        return ResponseEntity.ok().body(classBussiness.findAll(pageable));
    }

}
