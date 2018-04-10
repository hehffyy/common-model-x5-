package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListType {
	@XmlElementWrapper(name = "list", namespace = "http://www.justep.com/xbiz#")
	@XmlElement(name = "simple")
	List<Simple> simples = new ArrayList<Simple>();

	public List<Simple> getSimples() {
		return simples;
	}

	public void setSimples(List<Simple> simples) {
		this.simples = simples;
	}

	public void addSimple(String value) {
		Simple e = new Simple();
		e.setValue(value);
		simples.add(e);
	}

	public void addSimple(String type, String value) {
		Simple e = new Simple();
		e.setType(type);
		e.setValue(value);
		simples.add(e);
	}

}
