package com.butone.x5.model.element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 执行规则，任务分配模式默认together， 首环节默认生效条件 isStartingProcess()，执行规则
 * currentPersonMember2()，打开时抢占、<br>
 * 其他环节默认生效条件 findOrgUnitsHasCActivity('', false) 授权当前环节
 * taskRelationValue默认包括sLimitTime、sName<br>
 * sExecuteMode2(打开后自动流转'advanceWhenOpen')<br>
 * sExecuteMode(执行模式 抢占temPreempt,顺序temSequential,同时temSimultaneous)
 * taskAssignMode共同分配时有效<br>
 * sPreemptMode(抢占时机 处理时tpmExecute 打开时tpmOpen) sExecuteMode = temPreempt是有效<br>
 */

@XmlRootElement(name = "execute-rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecuteRule extends ProcessRule {

	/**
	 * 任务协作模式，together 共同分配，singleness独立分配。singleness为默认值<br>
	 * 共同分配就是给所有执行者生成一条待办任务，那么只有等所有执行者都处理完成<br>
	 * 或被其中一个执行者抢占处理完成后此待办任务才算结束，才可以进行流转回退等操作。<br>
	 * 独立分配就是给每个执行者都生成一条待办任务，它们各自独立互不影响。每个执行者都<br>
	 * 可以把自己的结束待办任务处理完成后进行流转和回退等操作。
	 */
	@XmlAttribute(name = "task-assign-mode")
	String taskAssignMode;

	@XmlElement(name = "executor-range")
	ExecutorRange executorRange = new ExecutorRange();

	/**
	 * 任务分配模式
	 * 
	 * @return
	 */
	public String getTaskAssignMode() {
		return taskAssignMode;
	}

	public void setTaskAssignMode(String taskAssignMode) {
		this.taskAssignMode = taskAssignMode;
	}

	/**
	 * 执行者范围
	 * 
	 * @return
	 */
	public ExecutorRange getExecutorRange() {
		return executorRange;
	}

	public void setExecutorRange(ExecutorRange executorRange) {
		this.executorRange = executorRange;
	}

	// *********************属性转译*************************
	/**
	 * 打开后自动流转
	 */
	public boolean isAdvanceWhenOpen() {
		TaskRelation tr = taskRelationValue.findTaskRelation("sExecuteMode2");
		return tr != null && "'advanceWhenOpen'".equals(tr.getText());
	}

	public void setAdvanceWhenOpen(boolean value) {
		if (value) {
			taskRelationValue.setRelationValue("sExecuteMode2",
					"'advanceWhenOpen'");
		} else {
			taskRelationValue.setRelationValue("sExecuteMode2", null);
		}
	}

	/**
	 * 任务标题
	 */
	public String getName() {
		TaskRelation r = taskRelationValue.findTaskRelation("sName");
		if (r != null)
			return r.getText();
		return null;
	}

	public void setName(String value) {
		taskRelationValue.setRelationValue("sName", value);
	}

	/**
	 * 限制时间
	 */
	public String getLimitTime() {
		TaskRelation r = taskRelationValue.findTaskRelation("sLimitTime");
		if (r != null)
			return r.getText();
		return null;
	}

	public void setLimitTime(String value) {
		taskRelationValue.setRelationValue("sLimitTime", value);
	}

	/**
	 * 执行模式
	 * 
	 * @return
	 */
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

	/**
	 * 抢占模式
	 * 
	 * @return
	 */
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
