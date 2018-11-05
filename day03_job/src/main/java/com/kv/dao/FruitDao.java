package com.kv.dao;

import java.util.List;

import com.kv.po.Fruit;

public interface FruitDao {
	
	// 保存
	public int save(Fruit f);
	
	//批处理保存
	public int saves(List<Fruit> list);
	
	//根据时间范围查询fruit
	public List<Fruit> getListByDate();

}
