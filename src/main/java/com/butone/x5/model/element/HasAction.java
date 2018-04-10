package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 流程Action即业务动作
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class HasAction {
	@XmlAttribute(name = "log-enabled")
	boolean logEnabled;

	@XmlAttribute
	String action;

	/**
	 * 声明访问权限，取值范围{public, protected}<br>
	 * public 表示不需要授权就可以访问 protected表示当前指定的action必须经过授权才可以访问。
	 */
	@XmlAttribute(name = "access-permission")
	String accessPermission = "public";
	/**
	 * 参数节点：只允许对public和protected的参数进行重新定义。
	 */
	@XmlElement(name = "protected")
	List<Protected> protectedList = new ArrayList<Protected>();
	@XmlElement(name = "public")
	List<Public> publicList = new ArrayList<Public>();

	public boolean isLogEnabled() {
		return logEnabled;
	}

	public void setLogEnabled(boolean logEnabled) {
		this.logEnabled = logEnabled;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAccessPermission() {
		return accessPermission;
	}

	public void setAccessPermission(String accessPermission) {
		this.accessPermission = accessPermission;
	}

	public List<Protected> getProtectedList() {
		return protectedList;
	}

	public void setProtectedList(List<Protected> protectedList) {
		this.protectedList = protectedList;
	}

	public List<Public> getPublicList() {
		return publicList;
	}

	public void setPublicList(List<Public> publicList) {
		this.publicList = publicList;
	}

}
