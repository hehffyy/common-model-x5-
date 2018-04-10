package com.butone.x5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlValue;

import com.butone.javascript.JsonFunction;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class ActivityTemplet implements Serializable {

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class CssRef implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8166887893007913786L;
		@XmlValue
		String ref;
		@XmlAttribute
		String name;

		public String getRef() {
			return ref;
		}

		public void setRef(String ref) {
			this.ref = ref;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class JavaScript implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4770652058642923409L;
		@XmlValue
		String src;
		@XmlAttribute
		String name;

		public String getSrc() {
			return src;
		}

		public void setSrc(String src) {
			this.src = src;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class WindowJSSegment implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3236051129182552082L;
		@XmlValue
		String segment;
		@XmlAttribute
		boolean prev;
		@XmlAttribute
		boolean constructor;

		public String getSegment() {
			return segment;
		}

		public void setSegment(String semgent) {
			this.segment = semgent;
		}

		public boolean isPrev() {
			return prev;
		}

		public void setPrev(boolean prev) {
			this.prev = prev;
		}

		public boolean isConstructor() {
			return constructor;
		}

		public void setConstructor(boolean constructor) {
			this.constructor = constructor;
		}

	}

	private static final long serialVersionUID = -3616530953563292606L;

	@XmlAttribute
	String dataModelId;

	@XmlAttribute
	String templetURL;

	/**
	 * 表单上主控数据ID
	 */
	@XmlAttribute
	String controlData;

	/**
	 * 表单上主控数据概念名
	 */
	@XmlAttribute
	String controlTable;

	@XmlElementWrapper(name = "formDefaultDatas")
	@XmlElement(name = "data")
	List<String> defaultDatas = new ArrayList<String>();

	// /**
	// * 环节脚本Src
	// */
	// @XmlElementWrapper(name = "activityJavaScript")
	// @XmlElement(name = "scr")
	// List<String> activityJavaScript;

	/**
	 * 是否为环节业务数据对象
	 */
	@XmlAttribute
	boolean createBizDataForActivity;

	// *****************************表单**********************************//
	/**
	 * 环节表单脚本URL
	 */
	@XmlElementWrapper(name = "formJavaScript")
	@XmlElement(name = "src")
	List<JavaScript> formJavaScript = new ArrayList<JavaScript>();

	@XmlElementWrapper(name = "formCssRef")
	@XmlElement(name = "href")
	List<CssRef> formCssRef = new ArrayList<CssRef>();

	/**
	 * 环节表单脚本函数
	 */
	@XmlElementWrapper(name = "formJsonFunctions")
	@XmlElement(name = "jsonFunction")
	List<JsonFunction> formJsonFunction;

	/**
	 * 表单model动作
	 */
	@XmlElementWrapper(name = "formModelActions")
	@XmlElement(name = "action", namespace = "http://www.justep.com/xforms")
	List<Action> formModelActions;

	/**
	 * 环节表单组件(默认创建在rootViewer上的非可视化组件)
	 */
	@XmlElement
	String formTempletComponent;

	/**
	 * 是否为环节表单生成业务数据对象
	 */
	@XmlAttribute
	boolean createBizDataForForm;

	/**
	 * 环节脚本
	 */
	@XmlElementWrapper(name = "activityWindowScriptSegments")
	@XmlElement(name = "javaScriptSegment")
	List<WindowJSSegment> activityWindowScriptSegment = new ArrayList<WindowJSSegment>();

	/**
	 * 表单脚本
	 */
	@XmlElementWrapper(name = "activityFormScriptSegments")
	@XmlElement(name = "javaScriptSegment")
	List<WindowJSSegment> activityFormScriptSegment = new ArrayList<WindowJSSegment>();

	@XmlElementWrapper(name = "componentEventTemplets")
	@XmlElement(name = "component")
	List<ComponentEventTemplet> componentEventTemplets = new ArrayList<ComponentEventTemplet>();

	@XmlElement
	String desc;

	/**
	 * 扩展的回调方法名
	 */
	@XmlAttribute
	String extendCallback;

	public String getExtendCallback() {
		return extendCallback;
	}

	public String getDataModelId() {
		return dataModelId;
	}

	public void setDataModelId(String dataModelId) {
		this.dataModelId = dataModelId;
	}

	public String getTempletURL() {
		return templetURL;
	}

	public void setTempletURL(String templetURL) {
		this.templetURL = templetURL;
	}

	public String getControlData() {
		return controlData;
	}

	public void setControlData(String controlData) {
		this.controlData = controlData;
	}

	public String getControlTable() {
		return controlTable;
	}

	public void setControlTable(String controlTable) {
		this.controlTable = controlTable;
	}

	public List<String> getDefaultDatas() {
		return defaultDatas;
	}

	public List<Action> getFormModelActions() {
		if (formModelActions == null) {
			formModelActions = new ArrayList<Action>();
		}
		return formModelActions;
	}

	public void setFormModelActions(List<Action> formModelActions) {
		this.formModelActions = formModelActions;
	}

	// public List<String> getActivityJavaScript() {
	// if (activityJavaScript == null)
	// activityJavaScript = new ArrayList<String>();
	// return activityJavaScript;
	// }

	public List<JavaScript> getFormJavaScript() {
		return formJavaScript;
	}

	public List<CssRef> getFormCssRef() {
		return formCssRef;
	}

	public String getFormTempletComponent() {
		return formTempletComponent;
	}

	// public void setActivityJavaScript(List<String> activityJavaScript) {
	// this.activityJavaScript = activityJavaScript;
	// }

	public void setFormJavaScript(List<JavaScript> formJavaScript) {
		this.formJavaScript = formJavaScript;
	}

	public void setFormTempletComponent(String formTempletComponent) {
		this.formTempletComponent = formTempletComponent;
	}

	public List<JsonFunction> getFormJsonFunction() {
		if (formJsonFunction == null)
			formJsonFunction = new ArrayList<JsonFunction>();
		return formJsonFunction;
	}

	public void setFormJsonFunction(List<JsonFunction> formJsonFunction) {
		this.formJsonFunction = formJsonFunction;
	}

	public List<WindowJSSegment> getActivityWindowScriptSegment() {
		return activityWindowScriptSegment;
	}

	public List<WindowJSSegment> getActivityFormScriptSegment() {
		return activityFormScriptSegment;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isCreateBizDataForActivity() {
		return createBizDataForActivity;
	}

	public void setCreateBizDataForActivity(boolean createBizDataForActivity) {
		this.createBizDataForActivity = createBizDataForActivity;
	}

	public List<ComponentEventTemplet> getComponentEventTemplets() {
		return componentEventTemplets;
	}

	public Action findFormModelAction(String eventName) {
		if (formModelActions == null)
			return null;
		for (Action action : formModelActions) {
			if (action.getEvent().equals(eventName))
				return action;
		}
		return null;
	}

	/**
	 * 
	 * 查找组件事件代码模板
	 * 
	 * @param componentClassName
	 * @return
	 */
	public ComponentEventTemplet findComponentEventTemplet(
			String componentClassName) {
		for (ComponentEventTemplet et : this.getComponentEventTemplets()) {
			if (et.getClassName().equals(componentClassName)) {
				return et;
			}
		}
		return null;
	}
}
