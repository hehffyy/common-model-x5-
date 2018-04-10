package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * 流程令牌，当前只有启动环节包含name为init的令牌
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Token {
	@XmlAttribute
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
