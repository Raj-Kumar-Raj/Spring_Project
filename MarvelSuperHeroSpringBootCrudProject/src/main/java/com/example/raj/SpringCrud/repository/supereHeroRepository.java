package com.example.raj.SpringCrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.raj.SpringCrud.models.Charcters;
@Repository
public interface supereHeroRepository extends JpaRepository<Charcters,Integer>{

}
