package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 环节基类
 * 
 * @author Administrator
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Activity extends MultiLanguage {

	@XmlAttribute
	String name;

	@XmlElement(name = "listener")
	List<Listener> listenerList = new ArrayList<Listener>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Listener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<Listener> listenerList) {
		this.listenerList = listenerList;
	}

	// *************************扩展属性****************************
	/**
	 * guid用于设计器对应FlowAct
	 */
	@XmlAttribute
	String guid;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

}
