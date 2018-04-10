package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 流程任务属性值列表
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskRelationValue {
	@XmlElement(name = "item")
	List<TaskRelation> taskRelationList = new ArrayList<TaskRelation>();

	public List<TaskRelation> getTaskRelationList() {
		return taskRelationList;
	}

	public void setTaskRelationList(List<TaskRelation> taskRelationList) {
		this.taskRelationList = taskRelationList;
	}
	
	public TaskRelation findTaskRelation(String relation){
		for(TaskRelation tr : taskRelationList){
			if(relation.equals(tr.getRelation())){
				return tr;
			}
		}
		return null;
	}
	
	public void setRelationValue(String relation,String value){
		TaskRelation tr = this.findTaskRelation(relation);
		if(value==null){
			if(tr!=null){
				this.taskRelationList.remove(tr);
			}
		}else{
			if(tr==null){
				tr = new TaskRelation();
				tr.setRelation(relation);
				this.taskRelationList.add(tr);
			}
			tr.setText(value);
		}
	}
	
}
