package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.butone.model.enums.DataType;

/**
 * 本地中申明的关系对象，可以被概念引用。relation的DataType、
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Relation extends MultiLanguage {
	@XmlTransient
	String name;
	@XmlAttribute(name = "data-type")
	String dataType;
	@XmlAttribute(name = "inverse-of")
	String inverseOf;
	@XmlAttribute(name = "default-value-expr")
	String defaultValueExpr;
	@XmlAttribute
	Integer size;
	@XmlAttribute
	Integer scale;
	@XmlAttribute(name = "single-valued")
	Boolean singleValued = true;
	@XmlAttribute
	Boolean required;
	@XmlAttribute
	Boolean unique;

	public Relation() {

	}

	public Relation(String name, DataType dataType, Integer size, Integer scale) {
		this.name = name;
		this.dataType = dataType.toString();
		this.size = size;
		this.scale = scale;
	}

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getInverseOf() {
		return inverseOf;
	}

	public void setInverseOf(String inverseOf) {
		this.inverseOf = inverseOf;
	}

	public String getDefaultValueExpr() {
		return defaultValueExpr;
	}

	public void setDefaultValueExpr(String defaultValueExpr) {
		this.defaultValueExpr = defaultValueExpr;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public Boolean getSingleValued() {
		return singleValued;
	}

	public void setSingleValued(Boolean singleValued) {
		this.singleValued = singleValued;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getUnique() {
		return unique;
	}

	public void setUnique(Boolean unique) {
		this.unique = unique;
	}

	/************************* 扩展属性 *************************/

	// /**
	// * 任务中心字段
	// */
	// @XmlAttribute(namespace = "http://www.butone.com")
	// boolean taskField;
	//
	// public Boolean getTaskField() {
	// return taskField;
	// }
	//
	// public void setTaskField(Boolean taskField) {
	// this.taskField = taskField;
	// }
	//
	// @XmlAttribute(namespace = "http://www.butone.com")
	// boolean queryField;
	//
	// public Boolean getQueryField() {
	// return queryField;
	// }
	//
	// public void setQueryField(Boolean queryField) {
	// this.queryField = queryField;
	// }

}
