package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 自动环节
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AutoActivity extends StaticActivity implements HasCondition {
	@XmlAttribute
	String condition = "true";
	@XmlElement(name = "input")
	List<Input> inputList = new ArrayList<Input>();
	@XmlElement(name = "output")
	List<Output> outputList = new ArrayList<Output>();

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

}
