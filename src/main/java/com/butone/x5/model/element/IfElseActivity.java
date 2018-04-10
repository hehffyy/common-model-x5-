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
 * 条件分支环节，2条分支，true或者flase
 * 
 * @author Administrator
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class IfElseActivity extends Activity implements HasCondition{
	@XmlElement(name = "input")
	List<Input> inputList = new ArrayList<Input>();

	@XmlElement(name = "false-output")
	Output falseOutput;

	@XmlElement(name = "true-output")
	Output trueOutput;

	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute
	String condition;

	@XmlElement(name = "listener")
	List<Listener> listenerList = new ArrayList<Listener>();

	public List<Input> getInputList() {
		return inputList;
	}

	public void setInputList(List<Input> inputList) {
		this.inputList = inputList;
	}

	public Output getFalseOutput() {
		return falseOutput;
	}

	public void setFalseOutput(Output falseOutput) {
		this.falseOutput = falseOutput;
	}

	public Output getTrueOutput() {
		return trueOutput;
	}

	public void setTrueOutput(Output trueOutput) {
		this.trueOutput = trueOutput;
	}

	@Override
	public String getCondition() {
		return condition;
	}

	@Override
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Listener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<Listener> listenerList) {
		this.listenerList = listenerList;
	}

}
