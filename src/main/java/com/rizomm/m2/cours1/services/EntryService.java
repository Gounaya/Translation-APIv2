package com.rizomm.m2.cours1.services;

import com.rizomm.m2.cours1.entities.Entry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface EntryService {
    Entry updateEntry(Entry entry);
    Optional<Entry> getEntry(Integer id1, Integer id2);
    List<Entry> getAllEntries();
    void deleteEntry(Integer id1, Integer id2);
}
