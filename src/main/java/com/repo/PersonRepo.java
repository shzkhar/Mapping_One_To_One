package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.PersonEntity;

@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Integer>{

}
