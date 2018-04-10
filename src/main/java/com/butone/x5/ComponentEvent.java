package com.butone.x5;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.butone.javascript.JsonFunction;

@XmlAccessorType(XmlAccessType.FIELD)
public class ComponentEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2051414268221998193L;
	@XmlAttribute
	private String name;
	// @XmlAttribute
	// private String value;
	@XmlElement
	private JsonFunction jsonFunction;

	public String getName() {
		return name;
	}

	// public String getValue() {
	// return value;
	// }

	public JsonFunction getJsonFunction() {
		return jsonFunction;
	}
}
