package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 移交规则，执行者范围默认 findOrgUnitsHasCActivity('', false)，task-assign-mode="together"
 * taskRelationValue默认包括sLimitTime、sName<br>
 * sExecuteMode(执行模式 抢占temPreempt,顺序temSequential,同时temSimultaneous)
 * taskAssignMode共同分配时有效<br>
 * sPreemptMode(抢占时机 处理时tpmExecute 打开时tpmOpen) sExecuteMode = temPreempt是有效<br>
 * 
 */
@XmlRootElement(name = "transfer-rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferRule extends ProcessRule {

	/**
	 * 移交确认
	 */
	@XmlAttribute(name = "dialog-enabled")
	boolean dialogEnabled = true;
	/**
	 * 是否保存数据
	 */
	@XmlAttribute(name = "save-enabled")
	boolean saveEnabled = true;

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

	// *********************属性转译*************************
	public boolean isFlowToFront() {
		TaskRelation tr = taskRelationValue.findTaskRelation("sExecuteMode2");
		return tr != null && "'flowToFront'".equals(tr.getText());
	}

	public void setFlowToFront(boolean value) {
		if (value) {
			taskRelationValue.setRelationValue("sExecuteMode2",
					"'flowToFront'");
		} else {
			taskRelationValue.setRelationValue("sExecuteMode2", null);
		}
	}

	public String getExecuteMode() {
		TaskRelation r = taskRelationValue.findTaskRelation("sExecuteMode");
		if (r != null)
			return r.getText();
		return null;
	}

	public void setExecuteMode(String value) {
		if ("".equals(value))
			value = null;
		taskRelationValue.setRelationValue("sExecuteMode", value);
	}

	public String getPreemptMode() {
		TaskRelation r = taskRelationValue.findTaskRelation("sPreemptMode");
		if (r != null)
			return r.getText();
		return null;
	}

	public void setPreemptMode(String value) {
		if ("".equals(value))
			value = null;
		taskRelationValue.setRelationValue("sPreemptMode", value);
	}
}
