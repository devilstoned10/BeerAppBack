package com.crudapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.dao.BeerDAO;
import com.crudapp.model.Beer;
import com.crudapp.service.BeerService;

@Service
public class BeerServiceImpl implements BeerService {

	@Autowired
	private BeerDAO beerDao;
	
	public List<Beer> getBeerList() {
		return beerDao.getAllBeers();
	}

	public void saveBeer(Beer beer) {
		beerDao.addBeer(beer);
	}

	public Beer updateBeer(Beer beer) {
		return beerDao.updateBeer(beer);
	}

	public void deleteBeer(Beer beer) {
		beerDao.deleteBeer(beer);
	}

}
