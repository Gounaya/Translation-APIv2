package com.rizomm.m2.cours1.services;

import com.rizomm.m2.cours1.entities.Translation;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TransService {
    Translation createTranslation(Translation tr);
    List<Translation> getAllTranslation();

}

