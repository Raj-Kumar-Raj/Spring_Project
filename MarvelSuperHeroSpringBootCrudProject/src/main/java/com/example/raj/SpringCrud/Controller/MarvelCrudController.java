package com.example.raj.SpringCrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.raj.SpringCrud.models.Charcters;
import com.example.raj.SpringCrudj.service.CRUDservice;
@RestController
public class MarvelCrudController {
	@Autowired
	CRUDservice crudservice;
// CRUD
	// create API endpost 
@PostMapping(path="create")
public void createSuperHero(@RequestBody Charcters superhero) {
	crudservice.createSuperHero(superhero);
}
// rerad api end point 
//localost:8080/read?id=1
	@GetMapping("read")
	public Charcters readsuperherobyId(@RequestParam(name="id")int val) {
		return crudservice.readsuperherobyId(val);
	}
	// update 
	@PutMapping("update")
	public void updateSuperHeroHumanName(@RequestBody Charcters superhero,int id ) {
		crudservice.updateSuperHeroHumanName(superhero,id);
	}
	
	@DeleteMapping("delete")
	public void deleteSuperHero(@RequestParam (name = "id")int id) {
		crudservice.deleteSuperHero(id);
	}
}
