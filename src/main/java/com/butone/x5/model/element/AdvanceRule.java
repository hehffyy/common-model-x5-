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
 * 流转规则，核心关注任务分支与合并，支持特事特办，支持自定义流转窗，支持强批
 * 
 */
@XmlRootElement(name = "advance-rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdvanceRule {
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	@XmlAttribute
	String condition;

	/**
	 * 流转确认
	 */
	@XmlAttribute(name = "dialog-enabled")
	boolean dialogEnabled = true;
	/**
	 * 是否保存数据
	 */
	@XmlAttribute(name = "save-enabled")
	boolean saveEnabled = true;
	/**
	 * 允许跳转
	 */
	@XmlAttribute(name = "jump-enabled")
	boolean jumpEnabled;
	/**
	 * 自定义流转窗体="grid"
	 */
	@XmlAttribute(name = "customized-enabled")
	boolean customizedEnabled;
	/**
	 * 自定义类型 表格grid、图形graph
	 */

	@XmlAttribute(name = "customized-type")
	String customizedType;
	/**
	 * 强制流转
	 */
	@XmlAttribute(name = "ignore-execute-mode")
	boolean ignoreExecuteMode;
	/**
	 * 第一种是经过了AND分支，第二种则是某个活动环节的执行规则任务分配模式被设置为独立分配。<br>
	 * 任务等待就是定义当前待办任务流转时，是否需要等待其他有可能流入当前活动环节的待办任务。<BR>
	 * 任务等待会造成当前环节的下一步活动环节同时收到多条待办任务。<BR>
	 */
	@XmlAttribute(name = "task-wait")
	boolean taskWait;
	/**
	 * 任务等待模式 多任务 twmMultiple、单任务 twmSingle
	 */
	@XmlAttribute(name = "task-wait-mode")
	String taskWaitMode;

	/**
	 * 任务合并是要以任务等待为基础的，如果已经没有可能流入当前环节的待办任务了，<BR>
	 * 那就把当前待办任务和其他已经结束但没有流转的待办任务一起流转，后续每个活动环节<BR>
	 * 只会收到一条待办任务。
	 */
	@XmlAttribute(name = "task-join")
	boolean taskJoin;
	/**
	 * 任务合并 多任务 tjmMultiple、单任务 tjmSingle
	 */
	@XmlAttribute(name = "task-join-mode")
	String taskJoinMode;

	/**
	 * 任务分支环节用于配置当自动计算结果不严格是可以手工指定待办任务发生分支的环节。
	 * 
	 * 
	 */
	@XmlAttribute(name = "fork-activity")
	String forkActivity;

	/**
	 * 分支目的
	 */
	@XmlElement(name = "to")
	List<To> toList = new ArrayList<To>();

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

	public boolean isJumpEnabled() {
		return jumpEnabled;
	}

	public void setJumpEnabled(boolean jumpEnabled) {
		this.jumpEnabled = jumpEnabled;
	}

	public boolean isCustomizedEnabled() {
		return customizedEnabled;
	}

	public void setCustomizedEnabled(boolean customizedEnabled) {
		this.customizedEnabled = customizedEnabled;
	}

	public String getCustomizedType() {
		return customizedType;
	}

	public void setCustomizedType(String customizedType) {
		this.customizedType = customizedType;
	}

	public boolean isIgnoreExecuteMode() {
		return ignoreExecuteMode;
	}

	public void setIgnoreExecuteMode(boolean ignoreExecuteMode) {
		this.ignoreExecuteMode = ignoreExecuteMode;
	}

	public boolean isTaskWait() {
		return taskWait;
	}

	public void setTaskWait(boolean taskWait) {
		this.taskWait = taskWait;
	}

	public String getTaskWaitMode() {
		return taskWaitMode;
	}

	public void setTaskWaitMode(String taskWaitMode) {
		this.taskWaitMode = taskWaitMode;
	}

	public boolean isTaskJoin() {
		return taskJoin;
	}

	public void setTaskJoin(boolean taskJoin) {
		this.taskJoin = taskJoin;
	}

	public String getTaskJoinMode() {
		return taskJoinMode;
	}

	public void setTaskJoinMode(String taskJoinMode) {
		this.taskJoinMode = taskJoinMode;
	}

	public String getForkActivity() {
		return forkActivity;
	}

	public void setForkActivity(String forkActivity) {
		this.forkActivity = forkActivity;
	}

	public List<To> getToList() {
		if (toList == null)
			toList = new ArrayList<To>();
		return toList;
	}

	public void setToList(List<To> toList) {
		this.toList = toList;
	}
}
