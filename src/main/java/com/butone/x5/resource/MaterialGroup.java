package com.butone.x5.resource;

 
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="materialGroup", propOrder ={"name","kind","conditiongroup","materialGroup","material" })
public class MaterialGroup {
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String kind;
	
	@XmlElement(required=true)
	private String conditiongroup;
	
	@XmlElementWrapper
	private ArrayList<MaterialGroup>  materialGroup;
	
	@XmlElementWrapper
	private ArrayList<Material>  material;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getConditiongroup() {
		return conditiongroup;
	}

	public void setConditiongroup(String conditiongroup) {
		this.conditiongroup = conditiongroup;
	}

 

	public ArrayList<MaterialGroup> getMaterialGroup() {
		return materialGroup;
	}

	public void setMaterialGroup(ArrayList<MaterialGroup> materialGroup) {
		this.materialGroup = materialGroup;
	}

	public ArrayList<Material> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<Material> material) {
		this.material = material;
	}

 

 
 
	

}
