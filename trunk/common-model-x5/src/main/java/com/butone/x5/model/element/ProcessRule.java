package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.butone.xml.XmlAttrValueXmlAdapter;

/**
 * 基础过你则,taskRelationValue
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessRule {

	@XmlAttribute
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	String condition;

	@XmlElement(name = "task-relation-value")
	TaskRelationValue taskRelationValue = new TaskRelationValue();

	// *************************扩展属性*************************
	@XmlAttribute(namespace = "http://www.butone.com")
	String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public TaskRelationValue getTaskRelationValue() {
		return taskRelationValue;
	}

	public void setTaskRelationValue(TaskRelationValue taskRelationValue) {
		this.taskRelationValue = taskRelationValue;
	}

	/**
	 * 任务标题
	 */
	public String getName() {
		TaskRelation r = taskRelationValue.findTaskRelation("sName");
		if (r != null)
			return r.getText();
		return null;
	}

	public void setName(String value) {
		taskRelationValue.setRelationValue("sName", value);
	}

}
