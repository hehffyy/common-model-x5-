package com.butone.x5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class ComponentEventTemplet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1946237023803761033L;
	@XmlAttribute
	private String className;
	@XmlElementWrapper(name = "events")
	@XmlElement(name = "event")
	private List<ComponentEvent> events = new ArrayList<ComponentEvent>();

	public String getClassName() {
		return className;
	}

	public List<ComponentEvent> getEvents() {
		return events;
	}
}
