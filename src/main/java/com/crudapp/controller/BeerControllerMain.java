package com.crudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.model.Beer;
import com.crudapp.service.BeerService;

@RestController
public class BeerControllerMain {

	@Autowired
	private BeerService service;
	
	@GetMapping(path = "/list")
	public List<Beer> getBeers() {
		return service.getBeerList();
	}
	
	@PostMapping(path = "/add")
	public void addBeer(@RequestBody Beer beer) {
		service.saveBeer(beer);
	}
	
	@PutMapping(path = "/update/{id}")
	@ResponseBody
	public Beer updateBeer(@PathVariable long id, @RequestBody Beer beer) {
		return service.updateBeer(beer);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteBeer(@PathVariable long id, @RequestBody Beer beer) {
		service.deleteBeer(beer);
	}
}
