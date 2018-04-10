package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 本体模型中的概念定义，实际传送到前台页面的数据结构，可以理解为一个“视图”<br>
 * 多对多映射实例：<br>
 * Student(ID)、Teacher(ID)、StudentTeacher(StudentId, TeacherId)<br>
 * Student有多个老师，老师有多个学生<br>
 * Student Mapping中<br>
 * StudentTeacher.Key = StudentId 表示StudentTeacher表中那个对应Student.Key<br>
 * StudentTeacher.Item = {field=TeacherId
 * relation=Teachers}表示StudentTeacher那个字段对应到Student.Teachers<br>
 * Student.Teachers 数据类型 Teacher 非单值<br>
 * 1)查询学生select * from Student<br>
 * 2)通过RealtionTable的Key定义查询关系表<br>
 * select teacherID from StudentTeacher where studentId= Student.ID<br>
 * 3)因为teacherID 直接映射为Teacher对象，如果未指定，这里应该是String<br>
 * select * from Teacher where Id= teacherID<br>
 */

@XmlRootElement(name = "concept")
@XmlAccessorType(XmlAccessType.FIELD)
public class Concept extends MultiLanguage {
	// String displayRelation;
	// List<KeyRelation> keyRelationList = new ArrayList<KeyRelation>();
	@XmlAttribute
	String name;
	/**
	 * 主键默认值
	 */
	@XmlAttribute(name = "default-value-expr")
	String defaultValueExpr;
	/**
	 * 多个主键使用冒号分隔
	 */
	@XmlAttribute
	String keys;
	@XmlElement(name = "has-relation")
	List<HasRelation> hasRelationList = new ArrayList<HasRelation>();

	public Concept() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultValueExpr() {
		return defaultValueExpr;
	}

	public void setDefaultValueExpr(String defaultValueExpr) {
		this.defaultValueExpr = defaultValueExpr;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public List<HasRelation> getHasRelationList() {
		return hasRelationList;
	}

	public void setHasRelationList(List<HasRelation> hasRelationList) {
		this.hasRelationList = hasRelationList;
	}

	/**
	 * 添加关系
	 * 
	 * @param r
	 */
	public void addHasRelation(HasRelation r) {
		this.hasRelationList.add(r);
	}

	public HasRelation getHasRelation(String name) {
		Iterator<HasRelation> i = this.hasRelationList.iterator();
		while (i.hasNext()) {
			HasRelation r = i.next();
			if (r.getRelation().equals(name)) {
				return r;
			}
		}
		return null;
	}

	/*********************************** 扩展属性 *******************************/

}
