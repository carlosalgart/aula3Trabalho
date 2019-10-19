package br.com.facef.info.business;

import br.com.facef.info.model.Curse;
import br.com.facef.info.model.Teacher;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CurseBussiness {
    List<Curse> findAll(Pageable pageable);
    Curse findById(int id);
    Curse createCurse(Curse p) ;
    Curse updateCurse(int id, Curse p);
    void deleteCurse(int id);

}
