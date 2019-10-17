package com.rizomm.m2.cours1.repositories;

import com.rizomm.m2.cours1.entities.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransRepository extends JpaRepository<Translation, Integer> {
}
