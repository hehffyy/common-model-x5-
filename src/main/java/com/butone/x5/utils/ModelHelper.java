package com.butone.x5.utils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.butone.model.Flow;
import com.butone.model.FlowAct;
import com.butone.utils.StringUtils;
import com.butone.x5.model.element.AdvanceRule;
import com.butone.x5.model.element.AndActivity;
import com.butone.x5.model.element.BackRule;
import com.butone.x5.model.element.BusinessActivity;
import com.butone.x5.model.element.ExecuteRule;
import com.butone.x5.model.element.ForkRule;
import com.butone.x5.model.element.JoinRule;
import com.butone.x5.model.element.NoticeRule;
import com.butone.x5.model.element.TransferRule;
import com.butone.xml.JaxbUtils;

@XmlRootElement(name = "model")
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelHelper {

	public static void main(String[] aaa) {
		try {
			// FileInputStream in = new FileInputStream(
			// new File(
			// "D:\\X5.2.5_dev\\X5.2.5-JHZHJG\\"
			// +
			// "model\\BIZ\\landspvs\\LandStatus\\LandStatusAnly\\ontology\\LandStatusAnly.ontology.m"));
			// ModelHelper model = (ModelHelper) JaxbUtils.unMarshal(in,
			// "utf-8",
			// ModelHelper.class);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 执行规则
	 */
	@XmlElement(name = "execute-rule")
	List<ExecuteRule> executeRuleList = new ArrayList<ExecuteRule>();
	/**
	 * 流转规则
	 */
	@XmlElement(name = "advance-rule")
	List<AdvanceRule> advanceRuleList = new ArrayList<AdvanceRule>();
	/**
	 * 回退规则
	 */
	@XmlElement(name = "back-rule")
	List<BackRule> backRuleList = new ArrayList<BackRule>();
	/**
	 * 通知规则
	 */
	@XmlElement(name = "notice-rule")
	List<NoticeRule> noticeRuleList = new ArrayList<NoticeRule>();
	/**
	 * 移交规则
	 */
	@XmlElement(name = "transfer-rule")
	List<TransferRule> transferRuleList = new ArrayList<TransferRule>();

	/**
	 * 移交规则
	 */
	@XmlElement(name = "join-rule")
	List<JoinRule> joinRuleList = new ArrayList<JoinRule>();

	/**
	 * 移交规则
	 */
	@XmlElement(name = "fork-rule")
	List<ForkRule> forkRuleList = new ArrayList<ForkRule>();

	public static String getExecuteRule(BusinessActivity activity) {
		ModelHelper model = new ModelHelper();
		model.setExecuteRuleList(activity.getExecuteRuleList());
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					JaxbUtils.marshal(model, "utf-8", // ModelHelper.PreFixMapper,
							ModelHelper.class));
			SAXReader reader = new SAXReader(new DocumentFactory());
			Map<String, String> map = new HashMap<String, String>();
			map.put("m", "http://www.justep.com/model");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			StringBuffer sb = new StringBuffer();
			Document doc = reader.read(in);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("m:model/m:execute-rule");
			for (Object node : nodes) {
				sb.append("    ").append(((Node) node).asXML()).append("\n");
			}

			return StringUtils.StringConvert.replaceAll(sb.toString(),
					"xmlns=\"http://www.justep.com/model\"", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<AdvanceRule> getAdvanceRuleList() {
		return advanceRuleList;
	}

	public static String getAdvanceRule(BusinessActivity activity) {
		ModelHelper model = new ModelHelper();
		model.setAdvanceRuleList(activity.getAdvanceRuleList());
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					JaxbUtils.marshal(model, "utf-8", // ModelHelper.PreFixMapper,
							ModelHelper.class));
			SAXReader reader = new SAXReader(new DocumentFactory());
			Map<String, String> map = new HashMap<String, String>();
			map.put("m", "http://www.justep.com/model");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			StringBuffer sb = new StringBuffer();
			Document doc = reader.read(in);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("m:model/m:advance-rule");
			for (Object node : nodes) {
				sb.append("    ").append(((Node) node).asXML()).append("\n");
			}

			return StringUtils.StringConvert.replaceAll(sb.toString(),
					"xmlns=\"http://www.justep.com/model\"", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getJoinRule(AndActivity activity) {
		ModelHelper model = new ModelHelper();
		model.setJoinRuleList(activity.getJoinRuleList());
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					JaxbUtils.marshal(model, "utf-8", // ModelHelper.PreFixMapper,
							ModelHelper.class));
			SAXReader reader = new SAXReader(new DocumentFactory());
			Map<String, String> map = new HashMap<String, String>();
			map.put("m", "http://www.justep.com/model");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			StringBuffer sb = new StringBuffer();
			Document doc = reader.read(in);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("m:model/m:join-rule");
			for (Object node : nodes) {
				sb.append("    ").append(((Node) node).asXML()).append("\n");
			}

			return StringUtils.StringConvert.replaceAll(sb.toString(),
					"xmlns=\"http://www.justep.com/model\"", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getForkRule(AndActivity activity) {
		ModelHelper model = new ModelHelper();
		model.setForkRuleList(activity.getForkRuleList());
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					JaxbUtils.marshal(model, "utf-8", // ModelHelper.PreFixMapper,
							ModelHelper.class));
			SAXReader reader = new SAXReader(new DocumentFactory());
			Map<String, String> map = new HashMap<String, String>();
			map.put("m", "http://www.justep.com/model");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			StringBuffer sb = new StringBuffer();
			Document doc = reader.read(in);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("m:model/m:fork-rule");
			for (Object node : nodes) {
				sb.append("    ").append(((Node) node).asXML()).append("\n");
			}

			return StringUtils.StringConvert.replaceAll(sb.toString(),
					"xmlns=\"http://www.justep.com/model\"", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<JoinRule> getJoinRuleList() {
		return joinRuleList;
	}

	public void setJoinRuleList(List<JoinRule> joinRuleList) {
		this.joinRuleList = joinRuleList;
	}

	public List<ForkRule> getForkRuleList() {
		return forkRuleList;
	}

	public void setForkRuleList(List<ForkRule> forkRuleList) {
		this.forkRuleList = forkRuleList;
	}

	public List<BackRule> getBackRuleList() {
		return backRuleList;
	}

	public static String getBackRule(BusinessActivity activity) {
		ModelHelper model = new ModelHelper();
		model.setBackRuleList(activity.getBackRuleList());
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					JaxbUtils.marshal(model, "utf-8", // ModelHelper.PreFixMapper,
							ModelHelper.class));
			SAXReader reader = new SAXReader(new DocumentFactory());
			Map<String, String> map = new HashMap<String, String>();
			map.put("m", "http://www.justep.com/model");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			StringBuffer sb = new StringBuffer();
			Document doc = reader.read(in);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("m:model/m:back-rule");
			for (Object node : nodes) {
				sb.append("    ").append(((Node) node).asXML()).append("\n");
			}

			return StringUtils.StringConvert.replaceAll(sb.toString(),
					"xmlns=\"http://www.justep.com/model\"", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<NoticeRule> getNoticeRuleList() {
		return noticeRuleList;
	}

	public static String getNoticeRule(BusinessActivity activity) {
		ModelHelper model = new ModelHelper();
		model.setNoticeRuleList(activity.getNoticeRuleList());
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					JaxbUtils.marshal(model, "utf-8", // ModelHelper.PreFixMapper,
							ModelHelper.class));
			SAXReader reader = new SAXReader(new DocumentFactory());
			Map<String, String> map = new HashMap<String, String>();
			map.put("m", "http://www.justep.com/model");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			StringBuffer sb = new StringBuffer();
			Document doc = reader.read(in);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("m:model/m:notice-rule");
			for (Object node : nodes) {
				sb.append("    ").append(((Node) node).asXML()).append("\n");
			}

			return StringUtils.StringConvert.replaceAll(sb.toString(),
					"xmlns=\"http://www.justep.com/model\"", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<TransferRule> getTransferRuleList() {
		return transferRuleList;
	}

	public static String getTransferRule(BusinessActivity activity) {
		ModelHelper model = new ModelHelper();
		model.setTransferRuleList(activity.getTransferRuleList());
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					JaxbUtils.marshal(model, "utf-8", // ModelHelper.PreFixMapper,
							ModelHelper.class));
			SAXReader reader = new SAXReader(new DocumentFactory());
			Map<String, String> map = new HashMap<String, String>();
			map.put("m", "http://www.justep.com/model");
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			StringBuffer sb = new StringBuffer();
			Document doc = reader.read(in);
			@SuppressWarnings("unchecked")
			List<Node> nodes = doc.selectNodes("m:model/m:transfer-rule");
			for (Object node : nodes) {
				sb.append("    ").append(((Node) node).asXML()).append("\n");
			}

			return StringUtils.StringConvert.replaceAll(sb.toString(),
					"xmlns=\"http://www.justep.com/model\"", "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setAdvanceRuleList(List<AdvanceRule> advanceRuleList) {
		this.advanceRuleList = advanceRuleList;
	}

	public void setBackRuleList(List<BackRule> backRuleList) {
		this.backRuleList = backRuleList;
	}

	public void setNoticeRuleList(List<NoticeRule> noticeRuleList) {
		this.noticeRuleList = noticeRuleList;
	}

	public void setTransferRuleList(List<TransferRule> transferRuleList) {
		this.transferRuleList = transferRuleList;
	}

	private static void fixedProcessProperties(Element p, Flow flow) {
		// name
		Node attr = p.attribute("name");
		if (attr == null)
			attr = p.addAttribute("name", flow.getName());
		else
			((Attribute) attr).setValue(flow.getName());
		// guid
		attr = p.attribute("guid");
		if (attr == null)
			attr = p.addAttribute("guid", flow.getGuid());
		else
			((Attribute) attr).setValue(flow.getGuid());
		// label
		Node label = p.selectSingleNode("m:label");
		if (label == null) {
			label = p.addElement("label");
			attr = ((Element) label).attribute("language");
			if (attr == null) {
				attr = ((Element) label).addAttribute("language", "zh_CN");
			}
		}
		label.setText(flow.getDispName());
	}

	// private static void fixStaticActivityProperties(Element activity,
	// FlowAct act) {
	// // name
	// Node attr = activity.attribute("name");
	// if (attr == null)
	// attr = activity.addAttribute("name", act.getName());
	// else
	// ((Attribute) attr).setValue(act.getName());
	//
	// // label
	// Node label = activity.selectSingleNode("label");
	// if (label == null) {
	// label = activity.addElement("label");
	// attr = ((Element) label).attribute("language");
	// if (attr == null) {
	// attr = ((Element) label).addAttribute("language", "zh_CN");
	// }
	// }
	// label.setText(act.getDispName());
	//
	// }

	/**
	 * 流程图上的环节不能修改名称，因为diagram中引用了。
	 * 
	 * @param activity
	 * @param act
	 */
	private static void fixBusinessActivityProperties(Element activity,
			FlowAct act) {
		// label
		Node label = activity.selectSingleNode("m:label");
		if (label == null) {
			label = activity.addElement("label");
			Node attr = ((Element) label).attribute("language");
			if (attr == null) {
				attr = ((Element) label).addAttribute("language", "zh_CN");
			}
		}
		label.setText(act.getDispName());
	}

	/**
	 * 比较Flow中的ProcessModel和Flow属性，修复ProcessModel中porcess、business-activity
	 * 中文名。返回Flow中缺失的business-activity及修复后的process
	 */
	public static Map<Element, List<Element>> checkFlowProcessModel(Flow flow)
			throws Exception {

		String modelText = "<model xmlns:butone=\"http://www.butone.com\" xmlns=\"http://www.justep.com/model\">\n"
				+ (flow.getModel() == null ? "<process></process>" : flow
						.getModel()) + "\n</model>";
		ByteArrayInputStream in = new ByteArrayInputStream(
				modelText.getBytes("utf-8"));

		SAXReader reader = new SAXReader(new DocumentFactory());
		Map<String, String> map = new HashMap<String, String>();
		map.put("m", "http://www.justep.com/model");
		reader.getDocumentFactory().setXPathNamespaceURIs(map);

		Document doc = reader.read(in);
		Element p = (Element) doc.selectSingleNode("m:model/m:process");
		fixedProcessProperties(p, flow);

		List<Element> activities = new ArrayList<Element>();
		@SuppressWarnings("rawtypes")
		List nodes = doc.selectNodes("//m:model/m:process/m:business-activity");
		for (Object node : nodes) {
			Element activity = (Element) node;
			String guid = activity.attributeValue("guid");
			FlowAct act = flow.findActivityByGuid(guid);
			if (act == null) {
				act = flow.findActivityByName(activity.attributeValue("name"));
				if (act != null) {
					Attribute attr = activity.attribute("guid");
					attr.setValue(act.getGuid());
				} else
					activities.add(activity);
			} else
				fixBusinessActivityProperties(activity, act);
		}
		Map<Element, List<Element>> ret = new HashMap<Element, List<Element>>();
		ret.put(p, activities);
		return ret;
	}

	public List<ExecuteRule> getExecuteRuleList() {
		return executeRuleList;
	}

	public void setExecuteRuleList(List<ExecuteRule> executeRuleList) {
		this.executeRuleList = executeRuleList;
	}
}
