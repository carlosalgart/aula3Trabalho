package br.com.gurgelmix.gko.business;

import br.com.gurgelmix.gko.model.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClassBussiness {
    List<Class> findAll(Pageable pageable);
    Class findById(int id);
    Class createClass(Class p) ;
    Class updateClass(int id, Class p);
    void deleteClass(int id);
    Page<Class> listapaginada(Pageable pageable);
}
