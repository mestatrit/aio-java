package com.cdpc.aio.ams.web.service;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdpc.aio.ams.web.po.TblSysSysfun;


/**
 * 生成xml辅助类
 * 
 * @author evin.liu
 *
 */
public class MenuXmlBuilder {

	private static Logger log = LoggerFactory.getLogger(MenuXmlBuilder.class);

	/**
	 * 将指定的菜单列表对象转换为xml字符串
	 * @param list
	 * @return
	 */
	public static String buildMenuXml(List<TblSysSysfun> list) {
		if(list == null || list.size() == 0){
			log.warn("list is null or empty");
			return new String("");
		}
		
		Document doc = DocumentHelper.createDocument();
		Element menu = doc.addElement("menu");
		TblSysSysfun tmp = null;
		String xmlString = "";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				tmp = (TblSysSysfun) list.get(i);
				Element function = menu.addElement("function");
				// id
				Element id = function.addElement("id");
				id.setText(tmp.getSfFunctionId() == null ? "" : tmp.getSfFunctionId().trim());
				// parent_id
				Element parent = function.addElement("parent");
				parent.setText(tmp.getSfParentId() == null ? "" : tmp.getSfParentId().trim());
				// name
				Element name = function.addElement("name");
				name.setText(tmp.getSfFunctionName() == null ? "" : tmp.getSfFunctionName().trim());
				// url
				Element url = function.addElement("url");
				url.setText(tmp.getSfTargetUrl() == null ? "" : tmp.getSfTargetUrl().trim());
				// right
				Element right = function.addElement("right");
				right.setText("1");
			}
			xmlString = doc.asXML();
		}
		return xmlString;
	}

}