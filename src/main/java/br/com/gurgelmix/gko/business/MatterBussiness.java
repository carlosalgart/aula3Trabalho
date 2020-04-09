package br.com.gurgelmix.gko.business;

import br.com.gurgelmix.gko.model.Matter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MatterBussiness {
    List<Matter> findAll(Pageable pageable);
    Matter findById(int id);
    Matter createMatter(Matter m) ;
    Matter updateMatter(int id, Matter m);
    void deleteMatter(int id);
    Page<Matter> listapaginada(Pageable pageable);

}
