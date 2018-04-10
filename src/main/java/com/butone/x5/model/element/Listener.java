package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * 监听器，起步王杰建议不要太多，有性能问题 1)流程、环节的流程操作事件，生成流程同名 流程.java、流程.procedure.m，同时<br>
 * 在流程.process.m中描述监听。此时action为触发这个事件的action 2)监听自定义的action
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Listener {

	/**
	 * 监听的目标
	 */
	@XmlAttribute
	String action;

	/**
	 * 监听点(before、after)
	 */
	@XmlAttribute(required = true)
	String event;

	/**
	 * 处理句柄
	 */
	@XmlAttribute
	String handler;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	@XmlAttribute(namespace = "http://www.butone.com")
	String pluginUrls;

	public String getPluginUrls() {
		return pluginUrls;
	}

	public void setPluginUrls(String pluginUrls) {
		this.pluginUrls = pluginUrls;
	}

}
