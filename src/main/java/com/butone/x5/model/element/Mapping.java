package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


/**
 * Mapping模型，本体与物理表映射
 * 
 * @author Administrator
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Mapping {
	@XmlAttribute
	String concept;
	/**
	 * 一个owner-table + 多个relation-table
	 */
	@XmlElement(name = "table")
	List<Table> tableList = new ArrayList<Table>();

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	/**
	 * 添加Table
	 * 
	 * @param table
	 */
	public void addTable(Table table) {
		this.tableList.add(table);
	}

	public Table findTable(String name) {
		Iterator<Table> i = this.tableList.iterator();
		while (i.hasNext()) {
			Table t = i.next();
			if (name.equals(t.getName())) {
				return t;
			}
		}
		return null;
	}

}
