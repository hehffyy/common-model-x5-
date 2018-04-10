package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.butone.xml.XmlAttrValueXmlAdapter;

/**
 * 退回规则
 * 
 * @author Administrator
 * 
 */
@XmlRootElement(name = "back-rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class BackRule {
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute
	String condition;
	/**
	 * 回退确认
	 */
	@XmlAttribute(name = "dialog-enabled")
	boolean dialogEnabled = true;
	/**
	 * 是否保存数据
	 */
	@XmlAttribute(name = "save-enabled")
	boolean saveEnabled = false;

	/**
	 * 强制退回
	 */
	@XmlAttribute(name = "ignore-execute-mode")
	boolean ignoreExecuteMode = false;

	/**
	 * 回退范围：all,prev-activity,specified,start,prev-task <BR>
	 * 所有前序环节、前序环节、指定环节(列表)、首环节、前序人(谁来的退给谁)
	 */
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute(name = "back-range")
	String backRange;

	/**
	 * 返回方式 flowToFront,flowToFrontOrAgain,flowToAgain<原路> 原路返回、重新流转、原路返回或重新流转
	 */
	@XmlAttribute(name = "then-flow-mode")
	String thenFlowMode;

	/**
	 * 回退的指定环节
	 */
	@XmlElement(name = "to")
	List<To> toList = new ArrayList<To>();

	public String getCondition() {
		// String dcode = null;
		// try {
		// dcode = new String(StringUtils.base64Decode(condition),"utf-8");
		// } catch (Exception e) {
		return condition;
		// }
		// return dcode;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean isDialogEnabled() {
		return dialogEnabled;
	}

	public void setDialogEnabled(boolean dialogEnabled) {
		this.dialogEnabled = dialogEnabled;
	}

	public boolean isSaveEnabled() {
		return saveEnabled;
	}

	public void setSaveEnabled(boolean saveEnabled) {
		this.saveEnabled = saveEnabled;
	}

	public boolean isIgnoreExecuteMode() {
		return ignoreExecuteMode;
	}

	public void setIgnoreExecuteMode(boolean ignoreExecuteMode) {
		this.ignoreExecuteMode = ignoreExecuteMode;
	}

	public String getBackRange() {
		return backRange;
	}

	public void setBackRange(String backRange) {
		this.backRange = backRange;
	}

	public String getThenFlowMode() {
		return thenFlowMode;
	}

	public void setThenFlowMode(String thenFlowMode) {
		this.thenFlowMode = thenFlowMode;
	}

	public List<To> getToList() {
		return toList;
	}

	public void setToList(List<To> toList) {
		this.toList = toList;
	}

	// *************************扩展属性*************************
	@XmlAttribute(namespace = "http://www.butone.com")
	String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
