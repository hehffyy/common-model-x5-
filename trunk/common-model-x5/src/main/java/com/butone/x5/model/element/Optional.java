package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * 分支环节选项
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Optional {
	@XmlAttribute
	String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
