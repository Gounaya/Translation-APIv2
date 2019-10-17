package com.rizomm.m2.cours1.services.impl;

import com.rizomm.m2.cours1.entities.Entry;
import com.rizomm.m2.cours1.entities.Translation;
import com.rizomm.m2.cours1.repositories.EntryRepository;
import com.rizomm.m2.cours1.repositories.TransRepository;
import com.rizomm.m2.cours1.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service of Entry
 */
@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private TransRepository transRepository;

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Entry updateEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    @Override
    public Optional<Entry> getEntry(Integer id1, Integer id2) {
        return entryRepository.findById(id2);
    }

    @Override
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @Override
    public void deleteEntry(Integer id1, Integer id2) {
        entryRepository.deleteById(id2);
    }


    /*
    int ui=0;
    @Override
    public void deleteEntry(Integer id1, Integer id2) {
        List<Entry> listEntry = new ArrayList<>();
        if(transRepository.findById(id1).isPresent()){
            Translation translationExist = transRepository.findById(id1).get();
            for(int i=0; i<translationExist.getEntries().size(); i++){
                if(translationExist.getEntries().get(i).getId().equals(id2)){
                    //entryRepository.delete(translationExist.getEntries().get(i));
                    entryRepository.deleteById(i);
                    //transRepository.findById(id1).get().getEntries().get(id2);
                }
                if(!translationExist.getEntries().get(i).getId().equals(id2)){
                    listEntry.add(translationExist.getEntries().get(i));
                    transRepository.findById(id1).get().setEntries(listEntry);
                }

            }
        }
    }
    */
}
