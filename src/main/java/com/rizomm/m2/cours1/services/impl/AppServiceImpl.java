package com.rizomm.m2.cours1.services.impl;

import com.rizomm.m2.cours1.entities.App;
import com.rizomm.m2.cours1.repositories.AppRepository;
import com.rizomm.m2.cours1.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service of Application
 */
@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppRepository appRepository;

    @Override
    public App createApp(App app) {
        return appRepository.save(app);
    }

    public List<App> findAll(){
        return (List<App>) appRepository.findAll();
    }

}
