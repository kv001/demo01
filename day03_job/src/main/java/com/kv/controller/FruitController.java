package com.kv.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.taskdefs.Sleep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kv.po.Fruit;
import com.kv.po.FruitVo;
import com.kv.service.FruitService;
import com.kv.utils.CatFruitUtils;

@Controller
public class FruitController {

	@Autowired
	private FruitService fruitService;

	@RequestMapping("/savefruit")
	public void saveFruit(FruitVo f) {
		
		for (int i = 1; i <= 10; i++) {

			String url = "http://www.xinfadi.com.cn/marketanalysis/2/list/" + i
					+ ".shtml?prodname="+f.getName()+"&begintime=" +f.getBegindate() + "&endtime=" + f.getEnddate() + "";
			
			String html = CatFruitUtils.getUrlString(url);
			
			List<Fruit> list = CatFruitUtils.parseHtml(html);

			fruitService.saves(list);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

	@RequestMapping("/getList")
	@ResponseBody
	public List<Fruit> getList() {
		List<Fruit> list = new ArrayList<Fruit>();
		list = fruitService.getListByDate();
		return list;
	}

}
