package com.rizomm.m2.cours1.services;

import com.rizomm.m2.cours1.entities.App;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppService {
    App createApp(App app);
    List<App> findAll();
}
