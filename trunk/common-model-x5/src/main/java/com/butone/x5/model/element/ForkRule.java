package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.butone.xml.XmlAttrValueXmlAdapter;

/**
 * 分支规则
 * 
 */
@XmlRootElement(name = "fork-rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForkRule {
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute
	String condition;
	@XmlElement(name = "optional")
	List<Optional> optionalList = new ArrayList<Optional>();
	// *************************扩展属性*************************
	@XmlAttribute(namespace = "http://www.butone.com")
	String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Optional> getOptionalList() {
		return optionalList;
	}

	public void setOptionalList(List<Optional> optionalList) {
		this.optionalList = optionalList;
	}
}
