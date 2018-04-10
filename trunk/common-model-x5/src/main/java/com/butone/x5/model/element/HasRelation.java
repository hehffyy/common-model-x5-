package com.butone.x5.model.element;

import java.util.Iterator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.butone.model.enums.DataType;

/**
 * 概念包含的关系。生成物理表时字段特性以hasRelation为准，如果hasRelation未设置，取relation。
 * 
 * @author Administrator
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class HasRelation extends MultiLanguage {
	@XmlAttribute
	String relation;
	/**
	 * 整体部分关系，用于表示两个概念之间的关联关系，它的取值范围是
	 * {composition，aggregation}，composition表示组合，当删除关系所在的本体时，同
	 * 时删除关系指向的本体。aggregation表示聚合，当删除关系所在的本体时，置空关系 的互逆关系
	 */
	@XmlAttribute(name = "whole-part")
	String wholePart;
	/**
	 * 表示关系在此概念中的别名
	 */
	@XmlAttribute(name = "local-name")
	String localName;
	@XmlElement
	Tree tree;

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

	public HasRelation() {
		super();
	}

	public HasRelation(String relation, DataType dataType, Integer size,
			Integer scale) {
		this.relation = relation;
		this.dataType = dataType.toString();
		this.size = size;
		this.scale = scale;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
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

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public Boolean isSingleValued() {
		return singleValued;
	}

	public void setSingleValued(Boolean singleValued) {
		this.singleValued = singleValued;
	}

	public Boolean isRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean isUnique() {
		return unique;
	}

	public void setUnique(Boolean unique) {
		this.unique = unique;
	}

	public String getWholePart() {
		return wholePart;
	}

	public void setWholePart(String wholePart) {
		this.wholePart = wholePart;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public Relation cloneRelation() {
		Relation r = new Relation();
		r.setName(this.relation);
		r.setDataType(this.dataType);
		r.setDefaultValueExpr(this.defaultValueExpr);
		r.setInverseOf(this.inverseOf);
		Iterator<Label> i = this.getLabels().iterator();
		while (i.hasNext()) {
			Label l = i.next();
			r.getLabels().add(new Label(l.getLanguage(), l.getText()));
		}
		r.setRequired(this.required);
		r.setScale(this.scale);
		r.setSingleValued(this.singleValued);
		r.setSize(this.size);
		r.setUnique(this.unique);
		return r;
	}

//	/**
//	 * 任务中心字段
//	 */
//	@XmlAttribute(namespace = "http://www.butone.com")
//	boolean taskField;
//
//	public Boolean getTaskField() {
//		return taskField;
//	}
//
//	public void setTaskField(Boolean taskField) {
//		this.taskField = taskField;
//	}
//
//	@XmlAttribute(namespace = "http://www.butone.com")
//	boolean queryField;
//
//	public Boolean getQueryField() {
//		return queryField;
//	}
//
//	public void setQueryField(Boolean queryField) {
//		this.queryField = queryField;
//	}

	/**
	 * 扩展属性 编码字段
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String codeDef;

	public String getCodeDef() {
		return codeDef;
	}

	public void setCodeDef(String codeDef) {
		this.codeDef = codeDef;
	}

	/**
	 * 扩展属性 单位类型
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String unitType;

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	@XmlAttribute(namespace = "http://www.butone.com")
	String orgSelectExtInfo;

	public String getOrgSelectExtInfo() {
		return orgSelectExtInfo;
	}

	public void setOrgSelectExtInfo(String orgSelectExtInfo) {
		this.orgSelectExtInfo = orgSelectExtInfo;
	}

}
