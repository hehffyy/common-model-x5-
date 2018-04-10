package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 动作定义，这个是UI调用的入口点
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Action extends MultiLanguage {
	@XmlAttribute
	String name;
	/**
	 * 对于全局的业务动作，不需要声明引用，只要对业务动作模块可见即可，就可以调用这个业务 动作。<br>
	 * 当前提供的所有业务流程操作，都是全局的业务动作。
	 */
	@XmlAttribute
	boolean global;
	@XmlAttribute(name = "log-enabled")
	boolean logEnabled;
	@XmlAttribute
	String procedure;
	@XmlElement(name = "permission")
	List<Permission> permissionList = new ArrayList<Permission>();
	@XmlElement(name = "private")
	List<Private> privateList = new ArrayList<Private>();
	@XmlElement(name = "protected")
	List<Protected> protectedList = new ArrayList<Protected>();
	@XmlElement(name = "public")
	List<Public> publicList = new ArrayList<Public>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public boolean isLogEnabled() {
		return logEnabled;
	}

	public void setLogEnabled(boolean logEnabled) {
		this.logEnabled = logEnabled;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public List<Private> getPrivateList() {
		return privateList;
	}

	public void setPrivateList(List<Private> privateList) {
		this.privateList = privateList;
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

	/**
	 * 添加公共参数
	 * 
	 * @param name
	 * @param type
	 * @param value
	 * @return
	 */
	public Public addPublicParameter(String name, String type, String value,
			boolean re) {
		Public param = new Public();
		param.setName(name);
		param.setType(type);
		param.setValue(value);
		if (re)
			param.setRequired(true);
		this.getPublicList().add(param);
		return param;
	}

	/**
	 * 添加私有参数
	 * 
	 * @param name
	 * @param type
	 * @param value
	 * @return
	 */
	public Private addPrivateParameter(String name, String type, String value) {
		Private param = new Private();
		param.setName(name);
		param.setType(type);
		param.setValue(value);
		this.getPrivateList().add(param);
		return param;
	}

	/**
	 * 添加权限参数
	 * 
	 * @param name
	 * @param type
	 * @param value
	 * @param re
	 * @return
	 */
	public Permission addPermissionParameter(String name, String type,
			String value) {
		Permission param = new Permission();
		param.setName(name);
		param.setType(type);
		param.setValue(value);
		this.getPermissionList().add(param);
		return param;
	}

	/**
	 * 添加权限保护参数
	 * 
	 * @param name
	 * @param type
	 * @param value
	 * @return
	 */
	public Protected addProtectedParameter(String name, String type,
			String value) {
		Protected param = new Protected();
		param.setName(name);
		param.setType(type);
		param.setValue(value);
		this.getProtectedList().add(param);
		return param;
	}

	public ParameterType findParameter(String name) {
		for (ParameterType param : this.permissionList) {
			if (param.getName().equals(name))
				return param;
		}

		for (ParameterType param : this.privateList) {
			if (param.getName().equals(name))
				return param;
		}

		for (ParameterType param : this.protectedList) {
			if (param.getName().equals(name))
				return param;
		}

		for (ParameterType param : this.publicList) {
			if (param.getName().equals(name))
				return param;
		}

		return null;
	}

	@XmlAttribute(namespace = "http://www.butone.com")
	String signDataFields;

	public String getSignDataFields() {
		return signDataFields;
	}

	public void setSignDataFields(String signDataFields) {
		this.signDataFields = signDataFields;
	}

}
