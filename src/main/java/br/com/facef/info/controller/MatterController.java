package br.com.facef.info.controller;

import br.com.facef.info.business.ClassBussiness;
import br.com.facef.info.business.MatterBussiness;
import br.com.facef.info.exception.Response;
import br.com.facef.info.model.Class;
import br.com.facef.info.model.Matter;
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
@RequestMapping("/v1/materias")
public class MatterController {

    private MatterBussiness matterBussiness;

    @Autowired
    public MatterController(MatterBussiness matterBussiness){
        this.matterBussiness = matterBussiness;
    }

    @GetMapping(value ="/listarTodos")
    public ResponseEntity<?> findAll(@PageableDefault(size=10)Pageable pageable){
        return ResponseEntity.ok(matterBussiness.findAll(pageable));
    }

    @GetMapping(value="/listarPagina")
    public List<Matter> getAllMatters(@RequestParam(defaultValue = "0", required = false) Integer pageNumber) {
        Pageable paging = PageRequest.of(pageNumber, 10);//, Sort.by("nome").descending());
        Page<Matter> pagedResult = matterBussiness.listapaginada(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Matter>();
        }
    }

    @GetMapping(value = "/buscarMateriaPorId/{id}")
    public ResponseEntity<?> findBy(@PathVariable int id){
        Matter matter = matterBussiness.findById(id);
        if (matter == null){
            new Response("Materia não encontrado no id " + id);
        }
        return ResponseEntity.ok(matterBussiness.findById(id));
    }

    @PostMapping(value ="/criarMateria")
    public ResponseEntity<Matter> post(@RequestBody Matter matter){
        return ResponseEntity.status(HttpStatus.CREATED).body(matterBussiness.createMatter(matter));
    }

    @PutMapping(value = "/atualizarMateria/{id}")
    public ResponseEntity<Matter> put(@PathVariable("id") int id, @RequestBody Matter matter){
        return ResponseEntity.status(HttpStatus.OK).body(matterBussiness.updateMatter(id, matter));
    }

    @DeleteMapping(value ="/apagarClasse/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        matterBussiness.deleteMatter(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + " excluido com sucesso");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List <Matter>> find(Pageable pageable){
        return ResponseEntity.ok().body(matterBussiness.findAll(pageable));
    }

}
