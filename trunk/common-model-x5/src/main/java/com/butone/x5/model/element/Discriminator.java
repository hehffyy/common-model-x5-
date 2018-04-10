package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * Table模型中的鉴定列用于一个物理表对应多个本体，例如字典表，按字典项对应多个本体
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Discriminator {
	@XmlAttribute
	String field;

	@XmlAttribute
	String value;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
