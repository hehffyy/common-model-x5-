package com.butone.x5.model.element;

import java.math.BigDecimal;
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
 * 活动环节
 */
@XmlRootElement(name = "business-activity")
@XmlAccessorType(XmlAccessType.FIELD)
public class BusinessActivity extends StaticActivity implements HasCondition {
	public static final String TYPE = "businessActivity";

	@XmlAttribute
	@XmlJavaTypeAdapter(XmlAttrValueXmlAdapter.class)
	String condition;
	/**
	 * 输入环节,用于绘制流程图
	 */
	@XmlElement(name = "input")
	List<Input> inputList = new ArrayList<Input>();
	/**
	 * 输出环节,用于绘制流程图
	 */
	@XmlElement(name = "output")
	List<Output> outputList = new ArrayList<Output>();
	/**
	 * 执行规则
	 */
	@XmlElement(name = "execute-rule")
	List<ExecuteRule> executeRuleList = new ArrayList<ExecuteRule>();
	/**
	 * 流转规则
	 */
	@XmlElement(name = "advance-rule")
	List<AdvanceRule> advanceRuleList = new ArrayList<AdvanceRule>();
	/**
	 * 回退规则
	 */
	@XmlElement(name = "back-rule")
	List<BackRule> backRuleList = new ArrayList<BackRule>();
	/**
	 * 通知规则
	 */
	@XmlElement(name = "notice-rule")
	List<NoticeRule> noticeRuleList = new ArrayList<NoticeRule>();
	/**
	 * 移交规则
	 */
	@XmlElement(name = "transfer-rule")
	List<TransferRule> transferRuleList = new ArrayList<TransferRule>();

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

	public List<ExecuteRule> getExecuteRuleList() {
		return executeRuleList;
	}

	public void setExecuteRuleList(List<ExecuteRule> executeRuleList) {
		this.executeRuleList = executeRuleList;
	}

	public List<AdvanceRule> getAdvanceRuleList() {
		return advanceRuleList;
	}

	public void setAdvanceRuleList(List<AdvanceRule> advanceRuleList) {
		this.advanceRuleList = advanceRuleList;
	}

	public List<BackRule> getBackRuleList() {
		return backRuleList;
	}

	public void setBackRuleList(List<BackRule> backRuleList) {
		this.backRuleList = backRuleList;
	}

	public List<NoticeRule> getNoticeRuleList() {
		return noticeRuleList;
	}

	public void setNoticeRuleList(List<NoticeRule> noticeRuleList) {
		this.noticeRuleList = noticeRuleList;
	}

	public List<TransferRule> getTransferRuleList() {
		return transferRuleList;
	}

	public void setTransferRuleList(List<TransferRule> transferRuleList) {
		this.transferRuleList = transferRuleList;
	}

	// *************************扩展属性****************************
	/**
	 * 是否流程协作接收环节
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	Boolean isCoopReceiver;

	public Boolean getIsCoopReceiver() {
		return isCoopReceiver;
	}

	public void setIsCoopReceiver(Boolean isCoopReceiver) {
		this.isCoopReceiver = isCoopReceiver;
	}

	/**
	 * 业务协同流程环节特有，记录流程协作（机构间）的入口流程，当业务协同流转后，启动该流程。例如启动区县建设用地的审批业务。
	 * eg:{process:'/demo/mydemo/process/yw1/yw1Process'}
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String approveEntryProcess;
	/**
	 * 环节分组
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String group;
	@XmlAttribute(namespace = "http://www.butone.com")
	BigDecimal limitDays;
	@XmlAttribute(namespace = "http://www.butone.com")
	String limitKind;
	@XmlAttribute(namespace = "http://www.butone.com")
	String limitDateExpr;
	@XmlElement(namespace = "http://www.butone.com")
	private ListType logicPlugins;
	@XmlElement(namespace = "http://www.butone.com")
	private ListType uiLogicPlugins;
	@XmlElement(namespace = "http://www.butone.com")
	private ListType bizRules;
	@XmlElement(namespace = "http://www.butone.com")
	private ListType bizOperations;
	/**
	 * 业务操作的数据表单URL
	 */
	@XmlElement(namespace = "http://www.butone.com")
	private MapType bizOperationForms;

	/**
	 * 批量操作选项
	 */
	@XmlElement(namespace = "http://www.butone.com")
	private MapType batchOperationOption;

	/**
	 * 是否多个转发规则
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	private Boolean multiTransferRule;

	/**
	 * 禁止流转后取回
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	private Boolean forbidWithdraw;

	/**
	 * 移动端是否启用
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	private Boolean mobileEnable;

	/**
	 * 异步批转
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	private Boolean asyncAdvance;

	public String getApproveEntryProcess() {
		return approveEntryProcess;
	}

	public void setApproveEntryProcess(String approveEntryProcess) {
		this.approveEntryProcess = approveEntryProcess;
	}

	public ListType getBizOperations() {
		if (bizOperations == null)
			bizOperations = new ListType();
		return bizOperations;
	}

	public void setBizOperations(ListType bizOperations) {
		this.bizOperations = bizOperations;
	}

	public ListType getBizRules() {
		if (bizRules == null)
			bizRules = new ListType();
		return bizRules;
	}

	public void setBizRules(ListType bizRules) {
		this.bizRules = bizRules;
	}

	public ListType getLogicPlugins() {
		if (logicPlugins == null)
			logicPlugins = new ListType();
		return logicPlugins;
	}

	public void setLogicPlugins(ListType logicPlugins) {
		this.logicPlugins = logicPlugins;
	}

	public ListType getUiLogicPlugins() {

		if (uiLogicPlugins == null)
			uiLogicPlugins = new ListType();
		return uiLogicPlugins;
	}

	public void setUiLogicPlugins(ListType uiLogicPlugins) {
		this.uiLogicPlugins = uiLogicPlugins;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public BigDecimal getLimitDays() {
		return limitDays;
	}

	public void setLimitDays(BigDecimal limitDays) {
		this.limitDays = limitDays;
	}

	public String getLimitKind() {
		return limitKind;
	}

	public void setLimitKind(String limitKind) {
		this.limitKind = limitKind;
	}

	public String getLimitDateExpr() {
		return limitDateExpr;
	}

	public void setLimitDateExpr(String limitDateExpr) {
		this.limitDateExpr = limitDateExpr;
	}

	public Boolean getMultiTransferRule() {
		return multiTransferRule;
	}

	public void setMultiTransferRule(Boolean multiTransferRule) {
		this.multiTransferRule = multiTransferRule;
	}

	public MapType getBizOperationForms() {
		return bizOperationForms;
	}

	public void setBizOperationForms(MapType bizOperationForms) {
		this.bizOperationForms = bizOperationForms;
	}

	public MapType getBatchOperationOption() {
		return batchOperationOption;
	}

	public void setBatchOperationOption(MapType batchOperationOption) {
		this.batchOperationOption = batchOperationOption;
	}

	public Boolean getForbidWithdraw() {
		return forbidWithdraw;
	}

	public void setForbidWithdraw(Boolean forbidWithdraw) {
		this.forbidWithdraw = forbidWithdraw;
	}

	public Boolean getAsyncAdvance() {
		return asyncAdvance;
	}

	public void setAsyncAdvance(Boolean asyncAdvance) {
		this.asyncAdvance = asyncAdvance;
	}

	public Boolean getMobileEnable() {
		return mobileEnable;
	}

	public void setMobileEnable(Boolean mobileEnable) {
		this.mobileEnable = mobileEnable;
	}

}
