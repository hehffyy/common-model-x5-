package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * Table模型的索引
 * @author Administrator
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Index {
	public static final String TYPE_NORMAL = "NORMAL";
	public static final String TYPE_UNIQUE = "UNIQUE";
	public static final String SPLIT_FIELDS = ",";
	@XmlAttribute
	String name;
	@XmlAttribute
	String type;
	/**
	 * 多个字段逗号分隔
	 */
	@XmlAttribute(required = true)
	String fields;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}

}
