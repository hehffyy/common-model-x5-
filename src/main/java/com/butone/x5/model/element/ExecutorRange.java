package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.butone.xml.XmlAttrValueXmlAdapter;

/**
 * 任务执行者范围，如果最大的接收者可选范围和默认选择接收者一样的或者不需要流转对话框时，<br>
 * 就把执行者表达式和执行者范围表达式设置成一样就可以避免重复组织机构表达式计算造成速度慢。
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ExecutorRange {
	/**
	 * 执行者范围，最大的可选范围
	 */
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute(name = "range-expr")
	String rangeExpr="";

	/**
	 * 默认执行者
	 */
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute(name = "default-expr")
	String defaultExpr = "";

	/**
	 * 执行者类型 DPT、POS、PSM 部门、岗位(角色？)、人员
	 */
	@XmlElement(name = "kind")
	List<String> kindList = new ArrayList<String>();

	public String getRangeExpr() {
		return rangeExpr;
	}

	public void setRangeExpr(String rangeExpr) {
		this.rangeExpr = rangeExpr;
	}

	public String getDefaultExpr() {
//		String dcode = null;
//		try {
//			dcode = new String(StringUtils.base64Decode(defaultExpr));
//		} catch (Exception e) {
//			return defaultExpr;
//		}
//		return dcode;
		return defaultExpr;
	}

	public void setDefaultExpr(String defaultExpr) {
		this.defaultExpr = defaultExpr;
	}

	public List<String> getKindList() {
		if (kindList == null) {
			kindList = new ArrayList<String>();
		}
		return kindList;
	}

	public void setKindList(List<String> kindList) {
		this.kindList = kindList;
	}
}
