package com.butone.x5.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


/**
 * 模块配置，use/include设置 1)流程下的model.config.m 默认应用
 * /业务+system/data、/业务+system/logic/action、/业务+system/loigc/code<br>
 * 2)本体下的model.config.m 默认引用/system/logic/fn、包含/system/ontology(非流程及查询应该可以引用)<br>
 * 3)action的model.config.m 默认引用/system/logic/action、/业务/data<br>
 * 4)code的model.config.m 默认引用/system/logic/code<br>
 * 5)data的model.config.m 默认包含/业务/ontology<br>
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelCfg {
	@XmlElement(name = "include")
	List<String> includeList = new ArrayList<String>();
	@XmlElement(name = "use")
	List<String> useList = new ArrayList<String>();

	public List<String> getIncludeList() {
		return includeList;
	}

	public void setIncludeList(List<String> includeList) {
		this.includeList = includeList;
	}

	public List<String> getUseList() {
		return useList;
	}

	public void setUseList(List<String> useList) {
		this.useList = useList;
	}
}
