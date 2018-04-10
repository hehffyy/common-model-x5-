package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


/**
 * 配置文件，例如模块应用的数据库db.config.m、系统级的拦截器interceptor.config.m
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Config {
	@XmlAttribute
	String name;

	@XmlAttribute
	String value;

	@XmlElement(name = "item")
	List<Item> itemList = new ArrayList<Item>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}
