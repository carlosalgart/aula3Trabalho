package br.com.gurgelmix.gko.business.impl;


import br.com.gurgelmix.gko.business.MatterBussiness;
import br.com.gurgelmix.gko.model.Matter;
import br.com.gurgelmix.gko.repository.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatterBussinessImpl implements MatterBussiness {

    private MatterRepository matterRepository;

    @Autowired
    public MatterBussinessImpl(MatterRepository matterRepository){
        this.matterRepository = matterRepository;
    }

    @Override
    public List<Matter> findAll(Pageable pageable) {
        return matterRepository.findAll(pageable).getContent();
    }

    @Override
    public Matter findById(int id) {
        return matterRepository.findById(id).get();
    }


    @Override
    public Matter createMatter(Matter m) {
        return matterRepository.save(m);
    }

    @Override
    public Matter updateMatter(int id, Matter p) {
        Matter matter = matterRepository.findById(id).get();
        matter.setNome(p.getNome());
        return matterRepository.saveAndFlush(matter);
    }

    @Override
    public void deleteMatter(int id) {
        Matter matter = matterRepository.findById(id).get();
        matterRepository.delete(matter);
    }

    @Override
    public Page<Matter> listapaginada(Pageable pageable) {
        return matterRepository.findAll(pageable);
    }

}
