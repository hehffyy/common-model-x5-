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
 * 合并规则
 */

@XmlRootElement(name="join-rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class JoinRule {
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute
	String condition;
	/**
	 * 合并模式 preempt抢占 join合并<BR>
	 * 抢占指的是在AND合并所有的必选输入中只要有其中一条待办任务流入AND合并，<BR>
	 * 则AND合并就可以通行流入下一环节同时把所有尚未流入AND合并的待办任务都取消<BR>
	 */
	@XmlAttribute(name = "join-mode")
	String joinMode;
	/**
	 * 分支环节<BR>
	 */
	@XmlAttribute(name = "fork-activity")
	String forkactivity;
	@XmlElement(name = "optional")
	List<Optional> optionalList = new ArrayList<Optional>();
	
	//*************************扩展属性*************************
	@XmlAttribute(namespace="http://www.butone.com")
	String label;
	
	public String getForkactivity() {
		return forkactivity;
	}

	public void setForkactivity(String forkactivity) {
		this.forkactivity = forkactivity;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCondition() {
//		String dcode = null;
//		try {
//			dcode = new String(StringUtils.base64Decode(condition),"utf-8");
//		} catch (Exception e) {
			return condition;
//		}
//		return dcode;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getJoinMode() {
		return joinMode;
	}

	public void setJoinMode(String joinMode) {
		this.joinMode = joinMode;
	}

	public List<Optional> getOptionalList() {
		return optionalList;
	}

	public void setOptionalList(List<Optional> optionalList) {
		this.optionalList = optionalList;
	}
}
