package br.com.facef.info.business.impl;


import br.com.facef.info.business.CurseBussiness;
import br.com.facef.info.model.Curse;
import br.com.facef.info.repository.CurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurseBussinessImpl implements CurseBussiness {

    private CurseRepository curseRepository;

    @Autowired
    public CurseBussinessImpl(CurseRepository curseRepository){
        this.curseRepository = curseRepository;
    }

    @Override
    public List<Curse> findAll(Pageable pageable) {
        return curseRepository.findAll(pageable).getContent();
    }

    @Override
    public Curse findById(int id) {
        return curseRepository.findById(id).get();
    }


    @Override
    public Curse createCurse(Curse p) {
        return curseRepository.save(p);
    }

    @Override
    public Curse updateCurse(int id, Curse p) {
        Curse curse = curseRepository.findById(id).get();
        curse.setNome(p.getNome());
        return curseRepository.saveAndFlush(curse);
    }

    @Override
    public void deleteCurse(int id) {
        Curse curse = curseRepository.findById(id).get();
        curseRepository.delete(curse);
    }

    @Override
    public Page<Curse> listapaginada(Pageable pageable) {
        return curseRepository.findAll(pageable);
    }

}
