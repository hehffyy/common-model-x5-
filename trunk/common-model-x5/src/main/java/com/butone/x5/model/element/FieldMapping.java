package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * Table模型中的字段映射，概念的关系名与物理字段间的对照关系
 * @author Administrator
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class FieldMapping {
	@XmlAttribute
	String relation;

	@XmlAttribute
	String field;

	@XmlAttribute
	String type;

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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
