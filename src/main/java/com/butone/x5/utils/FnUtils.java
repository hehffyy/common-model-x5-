package com.butone.x5.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.butone.utils.FileUtils;
import com.butone.x5.model.element.Fn;
import com.butone.x5.model.element.Model;
import com.butone.xml.JaxbUtils;

/**
 * 函数支持类，用于解析系统提供的Java表达式函数。<br>
 * 在Stuido开发fn后应将fn的模型和xdoc文件拷贝到resources/fn下
 */
public class FnUtils {
	private final static String suffix_ModelFile = "fn.m";

	public static void main(String[] a) {
		String s = "	@param {String} cocnept 概念名      ";
		String[] ss = s.split(" ");
		System.out.println(ss.length);
		// List<Fn> l = new ArrayList<Fn>();
		// try {
		// // parseFn(new
		// //
		// File("D:\\X5.2.5_dev\\X5.2.5\\model\\BIZ\\system\\logic\\fn\\data.fn.m"),l);
		// // l = getDefalutFns();
		// for (Fn fn : l) {
		// System.out.println(fn.getName());
		// System.out.println(fn.getEditor());
		// System.out.println(fn.getHelp());
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * 获得指定目录下fn.m文件中定义的Fn模型对象
	 * 
	 * @param path
	 * @param includeChildren
	 * @return
	 * @throws ParserConfigurationException
	 * @throws JAXBException
	 */
	public static List<Fn> getAllModelFn(String path, boolean includeChildren)
			throws Exception {
		List<Fn> result = new ArrayList<Fn>();
		File[] fnFiles = FileUtils.getFiles(path, "*." + suffix_ModelFile,
				includeChildren);
		for (File file : fnFiles) {
			try {
				parseFn(file, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 解析Fn.m文件获得Java表达式函数模型对象
	 * 
	 * @param fnFile
	 * @param fns
	 * @throws JAXBException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void parseFn(File fnFile, List<Fn> fns) throws Exception {
		InputStream in = new FileInputStream(fnFile);
		try {
			File helpFile = new File(fnFile.getAbsolutePath() + ".xdoc");
			HashMap<String, String> helps = new HashMap<String, String>();
			if (helpFile.exists()) {
				readFnHelp(helpFile, helps);
			}

			Model model = (Model) JaxbUtils.unMarshal(in, "utf-8", Model.class);

			for (Fn fn : model.getFnList()) {
				fn.setHelp(helps.get(fn.getName()));
				fns.add(fn);
			}
		} finally {
			if (in != null)
				in.close();
		}

	}

	private static void readFnHelp(File file, HashMap<String, String> helps)
			throws IOException {
		FileInputStream f = new FileInputStream(file);
		try {
			// DataInputStream dr = new DataInputStream(f);

			BufferedReader dr = new BufferedReader(new InputStreamReader(f,
					"UTF-8"));
			String line = null;
			String name = null;
			StringBuffer help = null;
			while ((line = dr.readLine()) != null) {
				if (line.indexOf("/**") >= 0) {
					name = null;
					help = new StringBuffer();
				} else if (line.indexOf("@name") >= 0) {
					name = line.substring(line.indexOf("@name") + 6);
					if (name.indexOf(".") > 0) {
						name = name.substring(name.indexOf(".") + 1);
					}
				} else if (line.indexOf("@description") >= 0) {
					help.append(line.replace("@description", "描述：")).append(
							"\n");
				} else if (line.indexOf("@returns") >= 0) {
					help.append(line.replace("@returns", "返回值：")).append("\n");
				} else if (line.indexOf("@example") >= 0) {
					help.append(line.replace("@example", "案例：")).append("\n");
				} else if (line.indexOf("@param") >= 0) {
					// @param {String} cocnept 概念名
					help.append(line.replace("@param", "参数：")).append("\n");
				} else if (line.indexOf("*/") >= 0) {
					if (name != null) {
						helps.put(name, help.toString());
					}
				} else if (help != null) {
					help.append(line).append("\n");
				}

			}
		} finally {
			if (f != null)
				f.close();
		}

	}
}
