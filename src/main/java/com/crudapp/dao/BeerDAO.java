package com.crudapp.dao;

import java.util.List;

import com.crudapp.model.Beer;

public interface BeerDAO {

	public List<Beer> getAllBeers();

	public int addBeer(Beer beer);

	public Beer updateBeer(Beer beer);

	public int deleteBeer(Beer beer);
}
