package br.com.facef.info.business;

import br.com.facef.info.model.Class;
import br.com.facef.info.model.Matter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MatterBussiness {
    List<Matter> findAll(Pageable pageable);
    Matter findById(int id);
    Matter createMatter(Matter m) ;
    Matter updateMatter(int id, Matter m);
    void deleteMatter(int id);

}
