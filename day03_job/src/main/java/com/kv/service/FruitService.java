package com.kv.service;

import java.util.List;

import com.kv.po.Fruit;

public interface FruitService {
	// 保存
	public int save(Fruit f);

	// 批处理保存
	public int saves(List<Fruit> f);

	//根据时间范围查询fruit
	public List<Fruit> getListByDate();

}
