package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 模型文件
 * interceptor.config.m,db.config.m,mapping.m,action.action.m,action.procedure.m<BR>
 * ontology.m,process.procedure.m,process.process.m
 * listener.m.listener.m,listener.m.procedure.m,
 */
@XmlRootElement(name = "model")
@XmlAccessorType(XmlAccessType.FIELD)
public class Model extends MultiLanguage {
	// public final static String XMLNAMESPACE = "http://www.justep.com/model";
	// @XmlTransient
	// String name;

	// @XmlAttribute
	// String xmlns = XMLNAMESPACE;
	@XmlElement(name = "include")
	List<String> includeList = new ArrayList<String>();
	@XmlElement(name = "use")
	List<String> useList = new ArrayList<String>();
	@XmlElement(name = "relation")
	List<Relation> relationList = new ArrayList<Relation>();
	@XmlElement(name = "concept")
	List<Concept> conceptList = new ArrayList<Concept>();
	@XmlElement(name = "mapping")
	List<Mapping> mappingList = new ArrayList<Mapping>();
	@XmlElement(name = "procedure")
	List<Procedure> procedureList = new ArrayList<Procedure>();
	@XmlElement(name = "process")
	List<com.butone.x5.model.element.ProcessExt> processList = new ArrayList<com.butone.x5.model.element.ProcessExt>();
	@XmlElement(name = "action")
	List<Action> actionList = new ArrayList<Action>();
	@XmlElement(name = "fn")
	List<Fn> fnList = new ArrayList<Fn>();
	@XmlElement(name = "config")
	List<Config> configList = new ArrayList<Config>();
	@XmlElement(name = "store")
	List<Store> storeList = new ArrayList<Store>();
	@XmlElement(name = "listener")
	List<Listener> listenerList = new ArrayList<Listener>();

	public Model() {

	}

	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }

	// public String getXmlns() {
	// return xmlns;
	// }
	//
	// public void setXmlns(String xmlns) {
	// this.xmlns = xmlns;
	// }

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

	public boolean containsUse(String url) {
		for (String use : this.useList) {
			if (use.equals(url))
				return true;
		}
		return false;
	}

	public List<Relation> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<Relation> relationList) {
		this.relationList = relationList;
	}

	public List<Concept> getConceptList() {
		return conceptList;
	}

	public void setConceptList(List<Concept> conceptList) {
		this.conceptList = conceptList;
	}

	public List<Mapping> getMappingList() {
		return mappingList;
	}

	public void setMappingList(List<Mapping> mappingList) {
		this.mappingList = mappingList;
	}

	public List<Procedure> getProcedureList() {
		return procedureList;
	}

	public void setProcedureList(List<Procedure> procedureList) {
		this.procedureList = procedureList;
	}

	public List<com.butone.x5.model.element.ProcessExt> getProcessList() {
		return processList;
	}

	public void setProcessList(
			List<com.butone.x5.model.element.ProcessExt> processList) {
		this.processList = processList;
	}

	public List<Action> getActionList() {
		return actionList;
	}

	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}

	public boolean containsAction(String actionName) {
		for (Action action : this.actionList) {
			if (action.getName().equals(actionName))
				return true;
		}
		return false;
	}

	public List<Fn> getFnList() {
		return fnList;
	}

	public void setFnList(List<Fn> fnList) {
		this.fnList = fnList;
	}

	public List<Config> getConfigList() {
		return configList;
	}

	public void setConfigList(List<Config> configList) {
		this.configList = configList;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

	public List<Listener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<Listener> listenerList) {
		this.listenerList = listenerList;
	}

	/**
	 * 查找概念
	 * 
	 * @param name
	 * @return
	 */
	public Concept findConcept(String name) {
		Iterator<Concept> i = this.getConceptList().iterator();
		while (i.hasNext()) {
			Concept c = i.next();
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * 查找Relation
	 * 
	 * @param name
	 * @return
	 */
	public Relation findRelation(String name) {
		Iterator<Relation> i = this.getRelationList().iterator();
		while (i.hasNext()) {
			Relation r = i.next();
			if (r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}

	/**
	 * 查找映射
	 * 
	 * @param concept
	 * @return
	 */
	public Mapping findMapping(String concept) {
		Iterator<Mapping> i = this.getMappingList().iterator();
		while (i.hasNext()) {
			Mapping m = i.next();
			if (m.getConcept().equals(concept)) {
				return m;
			}
			i.next();
		}
		return null;
	}

	public boolean hasUse(String model) {
		return this.useList.contains(model);
	}

	public boolean hasInclude(String model) {
		return this.includeList.contains(model);
	}
}
