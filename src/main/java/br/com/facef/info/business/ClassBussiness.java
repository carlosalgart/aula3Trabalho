package br.com.facef.info.business;

import br.com.facef.info.model.Class;
import br.com.facef.info.model.Curse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClassBussiness {
    List<Class> findAll(Pageable pageable);
    Class findById(int id);
    Class createClass(Class p) ;
    Class updateClass(int id, Class p);
    void deleteClass(int id);

}
