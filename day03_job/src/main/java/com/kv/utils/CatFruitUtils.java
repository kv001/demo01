package com.kv.utils;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kv.po.Fruit;

public class CatFruitUtils {
	
	/*public static void main(String[] args) {
		
		String html = getUrlString("http://www.xinfadi.com.cn/marketanalysis/2/list/1.shtml");
		
		List<Fruit> list = parseHtml(html);
		for (Fruit fruit : list) {
			System.out.println(fruit);
		}
	}*/
	

	/**
	 * httpclient抓取制定网址的源码
	 */
	public static String getUrlString(String url) {
		String html = null;
		CloseableHttpClient client = HttpClients.createDefault();

		HttpGet get = new HttpGet(url);

		try {
			CloseableHttpResponse response = client.execute(get);
			int code = response.getStatusLine().getStatusCode();
			System.out.println("状态码:" + code);
			if (code == 200) {
				HttpEntity entity = response.getEntity();
				html = EntityUtils.toString(entity, "utf-8");

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html;
	}
	
	/**
	 * jsoup解析制定html字符串，生成Fruit对象 集合
	 */
	public static List<Fruit> parseHtml(String html){
		
		List<Fruit> list = new ArrayList<Fruit>();
		
		Document doc = Jsoup.parse(html);
		
		Element table = doc.select("table[class=hq_table]").first();
		
		Elements trs = table.select("tr");
		
		for(int i = 1;i<trs.size();i++){
			
			Fruit fruit = new Fruit();
			Elements tds = trs.get(i).select("td");
			
			fruit.setName(tds.get(0).text());
			fruit.setMin(Double.parseDouble(tds.get(1).text()));
			fruit.setAvg(Double.parseDouble(tds.get(2).text()));
			fruit.setMax(Double.parseDouble(tds.get(3).text()));
			fruit.setStand(tds.get(4).text());
			fruit.setUnit(tds.get(5).text());
			Date date = Date.valueOf(tds.get(6).text());
			fruit.setDate(date);
			list.add(fruit);
		}
		
		return list;
		
	}

}
