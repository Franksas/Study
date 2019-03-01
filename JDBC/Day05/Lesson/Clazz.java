package com.ychs.bean;

import java.io.Serializable;

/**
 * 班级的实体类
 * @author asus
 *
 */
public class Clazz implements Serializable{
	//班级编号
	private int id;
	//班级名称
	private String cname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", cname=" + cname + "]";
	}



}
