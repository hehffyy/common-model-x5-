package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Mapping中的表定义
 * 
 * @author Administrator
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {
	public final static String Type_ownerTable = "owner-table";
	public final static String Type_friendTable = "friend-table";
	public final static String Type_relationTable = "relation-table";

	@XmlAttribute
	String name;
	@XmlAttribute
	String type;
	Discriminator discriminator;
	/**
	 * type为owner-table时表示本表的主键列
	 * type为relation-table是表示本表的那个列对应主表的主键
	 */
	@XmlElement
	Key key;
	@XmlElement(name = "item")
	/**
	 * type为owner-table时表示本表的列与概念关系的映射
	 * type为relation-table时表示关联取出那一列到主表的关系，这个关系如果是另外的概念会级联查询
	 */
	List<FieldMapping> fieldMappingList = new ArrayList<FieldMapping>();
	@XmlElement(name = "index")
	List<Index> indexList = new ArrayList<Index>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Discriminator getDiscriminator() {
		return discriminator;
	}

	public void setDiscriminator(Discriminator discriminator) {
		this.discriminator = discriminator;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public List<FieldMapping> getFieldMappingList() {
		return fieldMappingList;
	}

	public void setFieldMappingList(List<FieldMapping> fieldMappingList) {
		this.fieldMappingList = fieldMappingList;
	}

	public List<Index> getIndexList() {
		return indexList;
	}

	public void setIndexList(List<Index> indexList) {
		this.indexList = indexList;
	}
	
	public FieldMapping addFieldMapping(String field,String relation,String dataType){
		FieldMapping item = findFieldMapping(field);
		if(item==null){
			item = new FieldMapping();
			item.setField(field);
			item.setRelation(relation);
			item.setType(dataType);
			this.fieldMappingList.add(item);
		}
		return item;
	}
	
	public FieldMapping findFieldMapping(String name){
		Iterator<FieldMapping> i =fieldMappingList.iterator();
		while(i.hasNext()){
			FieldMapping item = i.next();
			if(item.getField().equals(name)){
				return item;
			}
		}
		return null;
	}
	
}
