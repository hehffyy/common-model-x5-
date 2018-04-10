package com.butone.x5.model.element;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapType {
	@XmlElementWrapper(name = "map",namespace="http://www.justep.com/xbiz#")
	@XmlElement(name = "item")
	List<Entry> items = new ArrayList<Entry>();

	public List<Entry> getItems() {
		return items;
	}

	public void setItems(List<Entry> items) {
		this.items = items;
	}

	public void addItem(String key, String value) {
		Entry item = new Entry();
		item.setKey(key);
		item.getSimple().setValue(value);
		items.add(item);
	}

	public void addItem(String key, String type, String value) {
		Entry item = new Entry();
		item.setKey(key);
		item.getSimple().setType(type);
		item.getSimple().setValue(value);
		items.add(item);
	}

	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Entry {
		@XmlAttribute
		String key;
		Simple simple = new Simple();

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Simple getSimple() {
			return simple;
		}

		public void setSimple(Simple simple) {
			this.simple = simple;
		}

	}
}
