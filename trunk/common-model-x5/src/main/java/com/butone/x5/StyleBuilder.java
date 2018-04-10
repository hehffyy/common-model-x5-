package com.butone.x5;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.butone.model.utils.ValueHelper;

public class StyleBuilder {

	Map<String, String> styles = new HashMap<String, String>();

	public StyleBuilder() {
	}

	public StyleBuilder(String style) {
		this.load(style);
	}

	public void parse(JSONObject obj) {
		if (obj.containsKey("left"))
			setLeft(obj.getString("left"));
		if (obj.containsKey("top"))
			setTop(obj.getString("top"));
		if (obj.containsKey("width"))
			setWidth(obj.getString("width"));
		if (obj.containsKey("height"))
			setHeight(obj.getString("height"));
		if (obj.containsKey("backgroundColor"))
			setBackgroundColor(obj.getString("backgroundColor"));
	}

	public String getTop() {
		return getStyle("top");
	}

	public void setTop(String top) {
		styles.put("top", top);
	}

	public String getLeft() {
		return getStyle("left");
	}

	public void setLeft(String left) {
		styles.put("left", left);
	}

	public String getHeight() {
		return getStyle("height");
	}

	public void setHeight(String height) {
		styles.put("height", height);
	}

	public String getWidth() {
		return getStyle("width");
	}

	public void setWidth(String width) {
		styles.put("width", width);
	}

	public String getBackgroundColor() {
		return getStyle("background-color");
	}

	public void setBackgroundColor(String backgroundColor) {
		styles.put("background-color", backgroundColor);
	}

	public String getDisplay() {
		return getStyle("display");
	}

	public void setDisplay(String display) {
		styles.put("display", display);
	}

	public String getPosition() {
		return getStyle("position");
	}

	public void setPosition(String position) {
		styles.put("position", position);
	}

	private Method getStyleSetMethod(String styleName) {
		Method[] methods = this.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().equalsIgnoreCase("set" + styleName)) {
				return m;
			}
		}
		return null;
	}

	public StyleBuilder load(String style) {
		if (ValueHelper.isEmpty(style))
			return this;
		if (style.startsWith("{")) {
			JSONObject json = JSON.parseObject(style);
			for (String name : json.keySet()) {
				Method m = getStyleSetMethod(name);
				if (m != null) {
					try {
						m.invoke(this, json.getString(name));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					styles.put(name.toLowerCase(), json.getString(name));
				}
			}
		} else {
			String[] arrs = style.split(";");
			for (String str : arrs)
				if (str.indexOf(":") > 0) {
					String[] fmts = str.split(":");
					Method m = getStyleSetMethod(fmts[0].trim());
					if (m != null) {
						try {
							m.invoke(this, fmts.length > 1 ? fmts[1].trim()
									: null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						styles.put(fmts[0].trim().toLowerCase(), fmts[1].trim());
					}

				}
		}
		return this;
	}

	public String getStyle(String name) {
		return styles.get(name.toLowerCase());
	}

	public String setStyle(String name, String value) {
		return styles.put(name.toLowerCase(), value);
	}

	public static void main(String[] args) {
		System.out.println(parseInt("20pxpxpx"));
	}

	private static Integer parseInt(String value) {
		while (value.length() > 0
				&& (value.endsWith("p") || value.endsWith("x"))) {
			value = value.substring(0, value.length() - 1);
		}
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<String> i = styles.keySet().iterator();
		while (i.hasNext()) {
			String name = i.next();
			String value = styles.get(name);
			if (!ValueHelper.isEmpty(value)) {
				if (name.toLowerCase().matches("left|top|height|width")) {
					value = value.trim().toLowerCase();
					if (!value.endsWith("%")) {
						Integer num = parseInt(value);
						if (num != null)
							value = parseInt(value) + "px";
						else
							continue;
					}
				}
				sb.append(name + ":" + value + ";");
			}
		}
		return sb.toString();
	}

	public StyleBuilder merge(String style) {
		StyleBuilder other = new StyleBuilder(style);
		this.styles.putAll(other.styles);
		return this;
	}
}
