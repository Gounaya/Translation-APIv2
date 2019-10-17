package com.rizomm.m2.cours1.services.impl;

import com.rizomm.m2.cours1.entities.Translation;
import com.rizomm.m2.cours1.repositories.TransRepository;
import com.rizomm.m2.cours1.services.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service of Translation
 */
@Service
public class TransServiceImpl implements TransService {

    @Autowired
    private TransRepository transRepository;


    @Override
    public Translation createTranslation(Translation tr) {
        tr.setId(null);
        return transRepository.save(tr);
    }

    @Override
    public List<Translation> getAllTranslation(){
        return transRepository.findAll();
    }

}
