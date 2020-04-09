package br.com.gurgelmix.gko.business;

import br.com.gurgelmix.gko.model.Curse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CurseBussiness {
    List<Curse> findAll(Pageable pageable);
    Curse findById(int id);
    Curse createCurse(Curse p) ;
    Curse updateCurse(int id, Curse p);
    void deleteCurse(int id);
    Page<Curse> listapaginada(Pageable pageable);

}
