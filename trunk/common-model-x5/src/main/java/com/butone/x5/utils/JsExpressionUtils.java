package com.butone.x5.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.butone.x5.model.JsExpression;
import com.butone.x5.model.JsExpression.Catalog;

/**
 * JavaScript工具，设计器应先同步服务器上的JavaScript配置文件
 * 
 */
public class JsExpressionUtils {
	private static final String XPATH_FUNC_CATALOG = "//config/xpath/funcs";
	private static final String XPATH_OPERATOR_CATALOG = "//config/xpath/operators";

	private static Document getXmlDocument(String fileName) {
		InputStream is = null;
		try {
			is = new FileInputStream(new File(fileName));
			//
			SAXReader sAXReader = new SAXReader();
			sAXReader.setValidation(false);
			sAXReader
					.setFeature(
							"http://apache.org/xml/features/nonvalidating/load-dtd-grammar",
							false);
			sAXReader
					.setFeature(
							"http://apache.org/xml/features/nonvalidating/load-external-dtd",
							false);
			sAXReader.setEncoding("utf-8");
			return sAXReader.read(is);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] a) {
		List<Catalog> l;
		try {
			l = getJsFuncCatalogs("");
			for (Catalog c : l) {
				System.out.println(c.name + " " + c.text);

				for (JsExpression jsExp : c.items) {

					System.out.println("\t" + jsExp.name + " " + jsExp.text);

				}

			}

			//
			l = getJsOperatorCatalogs("");
			for (Catalog c : l) {

				System.out.println(c.name + " " + c.text);

				for (JsExpression jsExp : c.items) {

					System.out.println("\t" + jsExp.name + " " + jsExp.text);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Catalog> getJsFuncCatalogs(String fileName)
			throws Exception {
		Document doc = JsExpressionUtils.getXmlDocument(fileName);
		List<Catalog> result = new ArrayList<Catalog>();
		// <funcs> 元素
		Element funcs = (Element) doc.getRootElement().selectSingleNode(
				XPATH_FUNC_CATALOG);

		if (funcs != null) {

			// <funcs>--><item> 元素集合
			@SuppressWarnings("unchecked")
			Iterator<Element> i = funcs.selectNodes("item").iterator();

			while (i.hasNext()) {

				// <funcs>--><item> 元素
				Element catalogNode = (Element) i.next();

				Catalog catalog = new Catalog(
						catalogNode.attributeValue("name"),
						catalogNode.attributeValue("text"));

				result.add(catalog);

				// <funcs>--><item>--><item> 元素集合
				@SuppressWarnings("unchecked")
				Iterator<Element> j = catalogNode.selectNodes("item")
						.iterator();

				while (j.hasNext()) {

					// <funcs>--><item>--><item> 元素
					Element funcNode = j.next();

					catalog.items.add(new JsExpression(funcNode
							.attributeValue("name"), funcNode
							.attributeValue("text")));

				}

			}

		}

		return result;

	}

	public static List<Catalog> getJsOperatorCatalogs(String fileName)
			throws Exception {

		Document doc = JsExpressionUtils.getXmlDocument(fileName);

		List<Catalog> result = new ArrayList<Catalog>();

		// <operators> 元素
		Element funcs = (Element) doc.getRootElement().selectSingleNode(
				XPATH_OPERATOR_CATALOG);

		if (funcs != null) {

			// <operators>--><item> 元素集合
			@SuppressWarnings("unchecked")
			Iterator<Element> i = funcs.selectNodes("item").iterator();

			while (i.hasNext()) {

				// <operators>--><item> 元素
				Element catalogNode = (Element) i.next();

				Catalog catalog = new Catalog(
						catalogNode.attributeValue("name"),
						catalogNode.attributeValue("text"));

				result.add(catalog);

				// <operators>--><item>--><item> 元素集合
				@SuppressWarnings("unchecked")
				Iterator<Element> j = catalogNode.selectNodes("item")
						.iterator();

				while (j.hasNext()) {

					// <operators>--><item>--><item> 元素
					Element funcNode = j.next();

					catalog.items.add(new JsExpression(funcNode
							.attributeValue("name"), funcNode
							.attributeValue("text")));

				}

			}

		}

		return result;

	}

}
