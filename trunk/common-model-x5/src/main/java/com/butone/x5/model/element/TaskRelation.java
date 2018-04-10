package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.butone.xml.XmlAttrValueXmlAdapter;

/**
 * 流程任务属性值列表 ，不同的规则使用的TaskRelation不同，需特别注意
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskRelation {
	@XmlAttribute
	String relation;

	/**
	 * java表达式 任务标题 支持表达式格式
	 */
	@XmlValue
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	String text;

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
