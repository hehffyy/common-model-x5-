package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * 关系的树属性，通过具有树属性的关系，可以建立概念的树形图
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Tree {
	@XmlAttribute(name = "path-relation")
	String pathRelation;
	@XmlAttribute(name = "path-seperator")
	String pathSeperator = "/";

	public Tree() {

	}

	public Tree(String pathRelation, String pathSeperator) {

	}

	public String getPathRelation() {
		return pathRelation;
	}

	public void setPathRelation(String pathRelation) {
		this.pathRelation = pathRelation;
	}

}
