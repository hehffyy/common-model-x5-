package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * Place引用的令牌，启动环节默认token = "init"
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class HasToken {
	@XmlAttribute
	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
