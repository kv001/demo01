package com.kv.po;

import java.sql.Date;

/**
 * @author Administrator 水果
 *
 */
public class Fruit {

	private int id;
	private String name;
	private double min;
	private double avg;
	private double max;
	private String stand;
	private String unit;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", min=" + min + ", avg=" + avg + ", max=" + max + ", stand="
				+ stand + ", unit=" + unit + "]";
	}

}
