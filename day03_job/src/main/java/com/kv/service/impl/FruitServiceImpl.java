package com.kv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kv.dao.FruitDao;
import com.kv.po.Fruit;
import com.kv.service.FruitService;

@Service
public class FruitServiceImpl implements FruitService {
	
	@Autowired
	private FruitDao fruitDao;

	@Override
	public int save(Fruit f) {
		return fruitDao.save(f);
	}

	@Override
	public int saves(List<Fruit> f) {
		return fruitDao.saves(f);
	}

	@Override
	public List<Fruit> getListByDate() {
		return fruitDao.getListByDate();
	}

}
