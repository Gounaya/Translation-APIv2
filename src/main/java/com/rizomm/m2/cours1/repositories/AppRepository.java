package com.rizomm.m2.cours1.repositories;

import com.rizomm.m2.cours1.entities.App;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends CrudRepository<App, Integer> {

}
