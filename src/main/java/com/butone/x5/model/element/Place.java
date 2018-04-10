package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 启动、结束、XOR环节，启动默认has-token = "init"
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Place extends Activity {
	@XmlElement(name = "has-token")
	List<HasToken> hasTokenList = new ArrayList<HasToken>();

	public List<HasToken> getHasTokenList() {
		return hasTokenList;
	}

	public void setHasTokenList(List<HasToken> hasTokenList) {
		this.hasTokenList = hasTokenList;
	}
}
