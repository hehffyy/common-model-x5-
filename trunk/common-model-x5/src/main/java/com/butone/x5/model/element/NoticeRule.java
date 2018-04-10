package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * 流程通知规则，任务分配模式默认singleness taskRelationValue默认包括sLimitTime、sName<BR>
 * sEURL(处理页面)<BR>
 * sExecuteMode2 打开后自动结束 'finishWhenOpen'<BR>
 * whenToUnit 流程通知规则无此属性
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class NoticeRule extends ProcessRule {

	/**
	 * 任务协作模式，together 共同分配，singleness独立分配。singleness为默认值<br>
	 * 共同分配就是给所有执行者生成一条待办任务，那么只有等所有执行者都处理完成<br>
	 * 或被其中一个执行者抢占处理完成后此待办任务才算结束，才可以进行流转回退等操作。<br>
	 * 独立分配就是给每个执行者都生成一条待办任务，它们各自独立互不影响。每个执行者都<br>
	 * 可以把自己的结束待办任务处理完成后进行流转和回退等操作。
	 */
	@XmlAttribute(name = "task-assign-Mode")
	String taskAssignMode;

	@XmlElement(name = "executor-range")
	ExecutorRange executorRange = new ExecutorRange();

	/**
	 * 通知确认
	 */
	@XmlAttribute(name = "dialog-enabled")
	boolean dialogEnabled;
	/**
	 * 是否需要保存
	 */
	@XmlAttribute(name = "save-enabled")
	boolean saveEnabled;

	/**
	 * 流入到指定环节时通知
	 */
	@XmlAttribute(name = "when-to-unit")
	String whenToUnit;

	/**
	 * 通知时机,流程(abortProcess,finishProcess),环节(advanceProcess,backProcess)
	 */
	@XmlElement(name = "occasion")
	List<String> occasionList = new ArrayList<String>();

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

	public String getWhenToUnit() {
		return whenToUnit;
	}

	public void setWhenToUnit(String whenToUnit) {
		this.whenToUnit = whenToUnit;
	}

	public List<String> getOccasionList() {
		return occasionList;
	}

	public void setOccasionList(List<String> occasionList) {
		this.occasionList = occasionList;
	}

	public String getTaskAssignMode() {
		return taskAssignMode;
	}

	public void setTaskAssignMode(String taskAssignMode) {
		this.taskAssignMode = taskAssignMode;
	}

	public ExecutorRange getExecutorRange() {
		return executorRange;
	}

	public void setExecutorRange(ExecutorRange executorRange) {
		this.executorRange = executorRange;
	}

}
