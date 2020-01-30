package com.crudapp.service;

import java.util.List;

import com.crudapp.model.Beer;

public interface BeerService {

	public List<Beer> getBeerList();
	
	public void saveBeer(Beer beer);
	
	public Beer updateBeer(Beer beer);
	
	public void deleteBeer(Beer beer);
}
