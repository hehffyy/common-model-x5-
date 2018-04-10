package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


/**
 * 执行过程，定义过程对应的静态类方法。参数个数、顺序、类型必须与静态类方法个数类型相同
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Procedure extends MultiLanguage {
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
	@XmlElement(name = "parameter")
	List<Parameter> parameterList = new ArrayList<Parameter>();
}
