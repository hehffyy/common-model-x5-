package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 并联分支环节
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AndActivity extends Activity implements HasCondition {
	@XmlAttribute
	String condition;
	@XmlElement(name = "input")
	List<Input> inputList = new ArrayList<Input>();
	@XmlElement(name = "output")
	List<Output> outputList = new ArrayList<Output>();
	@XmlElement(name = "fork-rule")
	List<ForkRule> forkRuleList = new ArrayList<ForkRule>();
	@XmlElement(name = "join-rule")
	List<JoinRule> joinRuleList = new ArrayList<JoinRule>();
	@XmlElement(name = "listener")
	List<Listener> listenerList = new ArrayList<Listener>();

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

	public List<ForkRule> getForkRuleList() {
		return forkRuleList;
	}

	public void setForkRuleList(List<ForkRule> forkRuleList) {
		this.forkRuleList = forkRuleList;
	}

	public List<JoinRule> getJoinRuleList() {
		return joinRuleList;
	}

	public void setJoinRuleList(List<JoinRule> joinRuleList) {
		this.joinRuleList = joinRuleList;
	}

	public List<Listener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<Listener> listenerList) {
		this.listenerList = listenerList;
	}

}
