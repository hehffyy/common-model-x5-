package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


/**
 * 条件环节，红绿灯效果
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ConditionActivity extends Activity implements HasCondition{

	@XmlAttribute
	String condition;
	@XmlElement(name = "input")
	List<Input> inputList = new ArrayList<Input>();
	@XmlElement(name = "output")
	List<Output> outputList = new ArrayList<Output>();
	@XmlElement(name = "listener")
	List<Listener> listenerList = new ArrayList<Listener>();

	// @XmlElement(name = "has-action")
	// List<HasAction> hasActionList = new ArrayList<HasAction>();

	@Override
	public String getCondition() {
		return condition;
	}

	@Override
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Input> getInputList() {
		return inputList;
	}

	public void setInputList(List<Input> inputList) {
		this.inputList = inputList;
	}

	public List<Output> getOutputList() {
		return outputList;
	}

	public void setOutputList(List<Output> outputList) {
		this.outputList = outputList;
	}

	public List<Listener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<Listener> listenerList) {
		this.listenerList = listenerList;
	}
	// public List<HasAction> getHasActionList() {
	// return hasActionList;
	// }
	//
	// public void setHasActionList(List<HasAction> hasActionList) {
	// this.hasActionList = hasActionList;
	// }

}
