package br.com.facef.info.business.impl;


import br.com.facef.info.business.ClassBussiness;

import br.com.facef.info.model.Class;

import br.com.facef.info.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassBussinessImpl implements ClassBussiness {

    private ClassRepository classRepository;

    @Autowired
    public ClassBussinessImpl(ClassRepository classRepository){
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> findAll(Pageable pageable) {
        return classRepository.findAll(pageable).getContent();
    }

    @Override
    public Class findById(int id) {
        return classRepository.findById(id).get();
    }


    @Override
    public Class createClass(Class p) {
        return classRepository.save(p);
    }

    @Override
    public Class updateClass(int id, Class p) {
        Class aClass = classRepository.findById(id).get();
        aClass.setNome(p.getNome());
        return classRepository.saveAndFlush(aClass);
    }

    @Override
    public void deleteClass(int id) {
        Class aClass = classRepository.findById(id).get();
        classRepository.delete(aClass);
    }

    @Override
    public Page<Class> listapaginada(Pageable pageable) {
        return classRepository.findAll(pageable);
    }


}
