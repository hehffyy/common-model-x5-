package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * 公共参数类型，可以接受前台传入值
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Public extends ParameterType {
	@XmlAttribute
	Boolean required;

	public Boolean isRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}
}
