package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * Table模型中的主键
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Key {
	/**
	 * 多个字段逗号分隔
	 */
	@XmlAttribute
	String field;

	@XmlAttribute
	String type;
	
	public Key(String field,String type) {
		this.field = field;
		this.type = type;
	}
	
	public Key() {
		
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
