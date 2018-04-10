package com.butone.x5;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "windowTemplet")
@XmlAccessorType(XmlAccessType.FIELD)
public class WindowTemplet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3177398388338593979L;
	/**
	 * 模板名称
	 */
	@XmlAttribute
	String name;

	@XmlAttribute
	String fileName;

	@XmlAttribute
	String checkerClass;

	/**
	 * 流程功能
	 */
	BusinessActivityTemplet businessActivityTemplet;
	/**
	 * 非流程功能
	 */
	StaticActivityTemplet staticActivityTemplet;

	/**
	 * 查询功能
	 */
	QueryActivityTemplet queryActivityTemplet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BusinessActivityTemplet getBusinessActivityTemplet() {
		return businessActivityTemplet;
	}

	public void setBusinessActivityTemplet(
			BusinessActivityTemplet businessActivityTemplet) {
		this.businessActivityTemplet = businessActivityTemplet;
	}

	public StaticActivityTemplet getStaticActivityTemplet() {
		return staticActivityTemplet;
	}

	public void setStaticActivityTemplet(
			StaticActivityTemplet staticActivityTemplet) {
		this.staticActivityTemplet = staticActivityTemplet;
	}

	public QueryActivityTemplet getQueryActivityTemplet() {
		return queryActivityTemplet;
	}

	public void setQueryActivityTemplet(
			QueryActivityTemplet queryActivityTemplet) {
		this.queryActivityTemplet = queryActivityTemplet;
	}

	public String getCheckerClass() {
		return checkerClass;
	}

}
