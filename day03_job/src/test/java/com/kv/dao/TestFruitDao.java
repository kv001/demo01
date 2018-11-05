package com.kv.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kv.po.Fruit;

public class TestFruitDao {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		FruitDao dao = context.getBean(FruitDao.class);

		Fruit f = new Fruit();
		f.setName("国产香蕉");
		f.setMin(3.00);
		f.setAvg(3.25);
		f.setMax(3.50);
		f.setStand("香蕉类");
		f.setUnit("斤");

		int i = dao.save(f);
		if(i>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}

}
