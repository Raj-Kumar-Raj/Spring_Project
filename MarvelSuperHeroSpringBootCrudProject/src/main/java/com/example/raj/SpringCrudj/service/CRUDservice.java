package com.example.raj.SpringCrudj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.raj.SpringCrud.models.Charcters;
import com.example.raj.SpringCrud.repository.supereHeroRepository;
@Service
public class CRUDservice {
	@Autowired
      supereHeroRepository superherorepository;
	public void createSuperHero(Charcters character ) {
		superherorepository.save(character);
	}
	public Charcters readsuperherobyId(int val) {
		return superherorepository.findById(val).get() ;
		// TODO Auto-generated method stub
		
	}
	public void updateSuperHeroHumanName(@RequestParam Charcters superhero, @RequestParam (name="id")int id ) {
		// TODO Auto-generated method stub
		Charcters superherotobeupdated= readsuperherobyId(id);
		superherotobeupdated.setHumanName(superhero.getHumanName());
		
		superherorepository.save(superherotobeupdated);
	}
	public void deleteSuperHero(int id) {
		// TODO Auto-generated method stub
		superherorepository.deleteById(id);
	}
	
	
}
