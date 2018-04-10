package com.butone.x5.model;

import java.util.ArrayList;
import java.util.List;

public class JsExpression {
	
	public String name;
	public String text;

	public JsExpression() {
	}
	public JsExpression(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public static class Catalog {
		
		public String name;
		public String text;
		
		public List<JsExpression> items = new ArrayList<JsExpression>();
		
		public Catalog(String name, String text) {
			this.name = name;
			this.text = text;
		}
		
		public Catalog() {
			
		}
		
	}

}
