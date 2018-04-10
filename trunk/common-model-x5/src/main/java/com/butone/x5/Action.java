package com.butone.x5;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.butone.xml.CDATAXmlAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Action implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7015229094232080773L;
	@XmlAttribute(namespace = "http://www.w3.org/2001/xml-events")
	private String event;
	@XmlElement(namespace = "http://www.justep.com/xforms")
	@XmlJavaTypeAdapter(type = String.class, value = CDATAXmlAdapter.class)
	private String script;

	public Action() {

	}

	public Action(String event, String segment) {
		this.event = event;
		this.setScript(segment);
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public void appendScript(String script) {
		this.script = this.script == null ? script
				: (this.script + "\n" + script);
	}
}
