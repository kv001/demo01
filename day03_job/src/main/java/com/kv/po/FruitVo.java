package com.kv.po;

public class FruitVo {

	String name;
	String begindate;
	String enddate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "FruitVo [name=" + name + ", begindate=" + begindate + ", enddate=" + enddate + "]";
	}

}
