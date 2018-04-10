package com.butone.x5.resource;

import java.io.Serializable;

public class ResourceInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3431728651508070608L;
	/**
	 * 资源类型：fn、uiExpCfg
	 */
	private String kind;
	/**
	 * 资源目录，例如x5sys、bizsys
	 */
	private String catalog;
	
	/**
	 * 资源uri
	 */
	private String uri;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

}
