package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 静态环节，可用于通知任务的处理窗口
 * 
 * @author Administrator
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class StaticActivity extends Activity {

	@XmlElement(name = "has-action")
	List<HasAction> hasActionList = new ArrayList<HasAction>();

	@XmlElement(name = "listener")
	List<Listener> listenerList = new ArrayList<Listener>();

	public List<HasAction> getHasActionList() {
		return hasActionList;
	}

	public void setHasActionList(List<HasAction> hasActionList) {
		this.hasActionList = hasActionList;
	}

	public List<Listener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<Listener> listenerList) {
		this.listenerList = listenerList;
	}

	/**
	 * 扩展属性 编码字段
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String codeFields;

	public String getCodeFields() {
		return codeFields;
	}

	public void setCodeFields(String codeFields) {
		this.codeFields = codeFields;
	}

	/**
	 * 主控概念
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String controlTable;

	public String getControlTable() {
		return controlTable;
	}

	public void setControlTable(String tableName) {
		this.controlTable = tableName;
	}

	@XmlElement(name = "forms", namespace = "http://www.butone.com")
	ListType forms = new ListType();

	public ListType getForms() {
		return forms;
	}

	public Listener findActionListener(String action, String event,
			String handler) {
		for (Listener l : this.listenerList) {
			if (action.equals(l.getAction()) && event.equals(l.getEvent())
					&& handler.equals(l.getHandler()))
				return l;
		}
		return null;
	}

}
