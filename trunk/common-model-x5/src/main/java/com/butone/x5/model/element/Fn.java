package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlTransient;


/**
 * 函数申明,参数个数、顺序、类型必须与静态类方法个数类型相同
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Fn extends MultiLanguage {
	@XmlAttribute
	String name;
	/**
	 * codeModel下的静态类方法
	 */
	@XmlAttribute
	String code;
	/**
	 * code的ClassPath
	 */
	@XmlAttribute(name = "code-model")
	String codeModel;
	@XmlAttribute
	String category;
	/**
	 * List,String,Integer,Boolean,Float,DateTime,Date,Time,Decimal,Blob,Text
	 */
	@XmlAttribute
	String type;
	@XmlElement(name = "parameter")
	List<Parameter> parameterList = new ArrayList<Parameter>();
	
	@XmlTransient
	String help;
	
	@XmlAttribute(name = "butone:editor")
	String editor;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeModel() {
		return codeModel;
	}

	public void setCodeModel(String codeModel) {
		this.codeModel = codeModel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Parameter> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<Parameter> parameterList) {
		this.parameterList = parameterList;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
}
