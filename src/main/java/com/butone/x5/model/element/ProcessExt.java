package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 业务流程
 */
@XmlRootElement(name = "process")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessExt extends MultiLanguage {
	@XmlAttribute
	String name;
	@XmlAttribute
	String start;
	@XmlAttribute
	String end;
	@XmlAttribute
	String kind = "system";
	@XmlElement(name = "token")
	List<Token> tokenList = new ArrayList<Token>();
	@XmlElement(name = "has-action")
	List<HasAction> hasActionList = new ArrayList<HasAction>();
	@XmlElement(name = "listener")
	List<Listener> listenerList = new ArrayList<Listener>();
	/**
	 * 启动规则
	 */
	@XmlElement(name = "start-rule")
	List<StartRule> startRuleList = new ArrayList<StartRule>();
	/**
	 * 通知规则，触发事件 abortProcess作废、finishProcess办结
	 */
	@XmlElement(name = "notice-rule")
	List<NoticeRule> noticeRuleList = new ArrayList<NoticeRule>();
	/**
	 * 开始、结束、XOR 环节
	 */
	@XmlElement(name = "place")
	List<Place> placeList = new ArrayList<Place>();
	@XmlElement(name = "business-activity")
	List<BusinessActivity> businessActivityList = new ArrayList<BusinessActivity>();
	@XmlElement(name = "condition-activity")
	List<ConditionActivity> conditionActivityList = new ArrayList<ConditionActivity>();
	@XmlElement(name = "auto-activity")
	List<AutoActivity> autoActivityList = new ArrayList<AutoActivity>();
	@XmlElement(name = "and-activity")
	List<AndActivity> andActivityList = new ArrayList<AndActivity>();
	@XmlElement(name = "if-else-activity")
	List<IfElseActivity> ifElseActivityList = new ArrayList<IfElseActivity>();
	@XmlElement(name = "static-activity")
	List<StaticActivity> staticActivityList = new ArrayList<StaticActivity>();
	@XmlElement(name = "arc")
	List<Arc> actList = new ArrayList<Arc>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<Token> getTokenList() {
		return tokenList;
	}

	public void setTokenList(List<Token> tokenList) {
		this.tokenList = tokenList;
	}

	public List<HasAction> getHasActionList() {
		return hasActionList;
	}

	public HasAction addHasAction(String actionName) {
		if (!containsHasAction(actionName)) {
			HasAction action = new HasAction();
			action.setAction(actionName);
			hasActionList.add(action);
			return action;
		}
		return null;
	}

	public void setHasActionList(List<HasAction> hasActionList) {
		this.hasActionList = hasActionList;
	}

	public boolean containsHasAction(String actionName) {
		for (HasAction hasAction : hasActionList) {
			if (hasAction.getAction().equals(actionName))
				return true;
		}
		return false;
	}

	public boolean containsListener(String actionName, String event,
			String handler) {
		for (Listener listener : listenerList) {
			if (listener.getAction().equals(actionName)
					&& listener.getEvent().equals(event)
					&& listener.getHandler().equals(handler))
				return true;
		}
		return false;
	}

	public List<Listener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<Listener> listenerList) {
		this.listenerList = listenerList;
	}

	public List<StartRule> getStartRuleList() {
		return startRuleList;
	}

	public void setStartRuleList(List<StartRule> startRuleList) {
		this.startRuleList = startRuleList;
	}

	public List<NoticeRule> getNoticeRuleList() {
		return noticeRuleList;
	}

	public void setNoticeRuleList(List<NoticeRule> noticeRuleList) {
		this.noticeRuleList = noticeRuleList;
	}

	public List<Place> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<Place> placeList) {
		this.placeList = placeList;
	}

	public List<StaticActivity> getStaticActivityList() {
		return staticActivityList;
	}

	public void setStaticActivityList(List<StaticActivity> staticActivityList) {
		this.staticActivityList = staticActivityList;
	}

	public List<BusinessActivity> getBusinessActivityList() {
		return businessActivityList;
	}

	public void setBusinessActivityList(
			List<BusinessActivity> businessActivityList) {
		this.businessActivityList = businessActivityList;
	}

	public List<ConditionActivity> getConditionActivityList() {
		return conditionActivityList;
	}

	public void setConditionActivityList(
			List<ConditionActivity> conditionActivityList) {
		this.conditionActivityList = conditionActivityList;
	}

	public List<Arc> getActList() {
		return actList;
	}

	public void setActList(List<Arc> actList) {
		this.actList = actList;
	}

	public List<AutoActivity> getAutoActivityList() {
		return autoActivityList;
	}

	public void setAutoActivityList(List<AutoActivity> autoActivityList) {
		this.autoActivityList = autoActivityList;
	}

	public List<AndActivity> getAndActivityList() {
		return andActivityList;
	}

	public void setAndActivityList(List<AndActivity> andActivityList) {
		this.andActivityList = andActivityList;
	}

	public List<IfElseActivity> getIfElseActivityList() {
		return ifElseActivityList;
	}

	public void setIfElseActivityList(List<IfElseActivity> ifElseActivityList) {
		this.ifElseActivityList = ifElseActivityList;
	}

	public List<Activity> getAllActivities() {
		List<Activity> l = new ArrayList<Activity>();
		l.addAll(this.getAndActivityList());
		l.addAll(this.getAutoActivityList());
		l.addAll(this.getBusinessActivityList());
		l.addAll(this.getConditionActivityList());
		l.addAll(this.getIfElseActivityList());
		l.addAll(this.getPlaceList());
		return l;
	}

	public Activity findActivityByName(String name) {
		Iterator<Activity> i = getAllActivities().iterator();
		while (i.hasNext()) {
			Activity a = i.next();
			if (name.equals(a.getName()))
				return a;
		}
		return null;
	}

	public void removeActivity(Activity act) {
		if (act instanceof AndActivity) {
			this.getAndActivityList().remove(act);
		} else if (act instanceof AutoActivity) {
			this.getAutoActivityList().remove(act);
		} else if (act instanceof BusinessActivity) {
			this.getBusinessActivityList().remove(act);
		} else if (act instanceof ConditionActivity) {
			this.getConditionActivityList().remove(act);
		} else if (act instanceof IfElseActivity) {
			this.getIfElseActivityList().remove(act);
		} else if (act instanceof Place) {
			this.getPlaceList().remove(act);
		}
	}

	public boolean isFlowEntry(String actName) {
		if (this.getStart() == null)
			return false;
		for (BusinessActivity activity : this.getBusinessActivityList())
			if (activity.getName().equals(actName))
				for (Input input : activity.getInputList())
					if (input.getUnit().equals(this.getStart()))
						return true;
		return false;
	}

	/*********************************** 扩展属性 *******************************/
	/**
	 * 是否业务协同
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	Boolean isBizCoop;

	/**
	 * 机构级别
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String orgLevel;

	/**
	 * 业务编号
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String bizId;

	/**
	 * 业务名称
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String bizName;

	/**
	 * 业务协同流程图的入口信息，整个业务协同的入口流程。记录“我”属于业务协作的哪个环节。<br>
	 * eg:{process:
	 * '/demo/mydemo/process/bizCoop/bizCoopProcess',activity:'businessActivity1
	 * ' }<br>
	 * 用于从指定环节启动业务协同。
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	String coopProcess;

	/**
	 * 普通流程，如果是流程间协作，是否包含接收环节（发送后等待接收的环节）。如果为true，那么流程批转后，会检查目标环节是否是接收环节。
	 * 如果是接收环节，且数据尚未到达，那么挂起流程。
	 */
	@XmlAttribute(namespace = "http://www.butone.com")
	Boolean includeReceivers;

	@XmlAttribute
	String guid;
	@XmlAttribute(namespace = "http://www.butone.com")
	String bizKind;
	@XmlElement(name = "codeDefines", namespace = "http://www.butone.com")
	MapType codeDefines = new MapType();
	@XmlAttribute(namespace = "http://www.butone.com")
	Integer limitDays;
	@XmlAttribute(namespace = "http://www.butone.com")
	String limitKind;
	@XmlAttribute(namespace = "http://www.butone.com")
	Boolean silenceFinish;
	@XmlAttribute(namespace = "http://www.butone.com")
	Boolean oldExecutorDialog;
	@XmlAttribute(namespace = "http://www.butone.com")
	String finishKind;
	@XmlAttribute(namespace = "http://www.butone.com")
	String flowViewActivity;
	@XmlAttribute(namespace = "http://www.butone.com")
	String limitDateExpr;
	@XmlAttribute(namespace = "http://www.butone.com")
	String limitStartDateExpr;
	@XmlAttribute(namespace = "http://www.butone.com")
	String limitEffectActivity;
	@XmlElement(namespace = "http://www.butone.com")
	MapType activityGroup = new MapType();

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getFlowViewActivity() {
		return flowViewActivity;
	}

	public void setFlowViewActivity(String flowViewActivity) {
		this.flowViewActivity = flowViewActivity;
	}

	public Boolean getIsBizCoop() {
		return isBizCoop;
	}

	public void setIsBizCoop(Boolean isBizCoop) {
		this.isBizCoop = isBizCoop;
	}

	public String getCoopProcess() {
		return coopProcess;
	}

	public void setCoopProcess(String coopProcess) {
		this.coopProcess = coopProcess;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	public Boolean getIncludeReceivers() {
		return includeReceivers;
	}

	public void setIncludeReceivers(Boolean includeReceivers) {
		this.includeReceivers = includeReceivers;
	}

	public String getBizKind() {
		return bizKind;
	}

	public void setBizKind(String bizKind) {
		this.bizKind = bizKind;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public MapType getCodeDefines() {
		return codeDefines;
	}

	public void setCodeDefines(MapType codeDefines) {
		this.codeDefines = codeDefines;
	}

	public Integer getLimitDays() {
		return limitDays;
	}

	public void setLimitDays(Integer limitDays) {
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

	public String getLimitStartDateExpr() {
		return limitStartDateExpr;
	}

	public void setLimitStartDateExpr(String limitStartDateExpr) {
		this.limitStartDateExpr = limitStartDateExpr;
	}

	public String getLimitEffectActivity() {
		return limitEffectActivity;
	}

	public void setLimitEffectActivity(String limitEffectActivity) {
		this.limitEffectActivity = limitEffectActivity;
	}

	public MapType getActivityGroup() {
		return activityGroup;
	}

	public void setActivityGroup(MapType activityGroup) {
		this.activityGroup = activityGroup;
	}

	public Boolean getSilenceFinish() {
		return silenceFinish;
	}

	public void setSilenceFinish(Boolean silenceFinish) {
		this.silenceFinish = silenceFinish;
	}
	
	public Boolean getOldExecutorDialog() {
		return oldExecutorDialog;
	}

	public void setOldExecutorDialog(Boolean oldExecutorDialog) {
		this.oldExecutorDialog = oldExecutorDialog;
	}

	public String getFinishKind() {
		return finishKind;
	}

	public void setFinishKind(String finishKind) {
		this.finishKind = finishKind;
	}

}
