package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Mapping模型中用于描述哪些表(本体)需要存储到数据库
 * 
 * @author Administrator
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Store {
	@XmlAttribute
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Store() {

	}

	public Store(String name) {
		this.name = name;
	}
}
