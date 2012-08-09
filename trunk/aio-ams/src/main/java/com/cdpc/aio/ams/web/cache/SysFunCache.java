package com.cdpc.aio.ams.web.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdpc.aio.ams.common.util.SpringUtil;
import com.cdpc.aio.ams.web.dao.TblSysSysfunDAO;
import com.cdpc.aio.ams.web.po.TblSysSysfun;

/**
 * 
 * 缓存系统中所有的功能选项
 * 
 * @author evin.liu
 *
 */
public class SysFunCache {
	
	private static TblSysSysfunDAO tblSysSysfunDAO = null;
	
	private static Map<String, TblSysSysfun> sysfunMap = null;
	
	public void initSysFunMap() {
		// 惰性初始化
		if(tblSysSysfunDAO == null) {
			tblSysSysfunDAO = (TblSysSysfunDAO)SpringUtil.getBean("tblSysSysfunDAO");
		}
		// 惰性初始化
		if(sysfunMap == null) {
			sysfunMap = new HashMap<String, TblSysSysfun>();
			List<TblSysSysfun> all= tblSysSysfunDAO.searchAll();
			for(TblSysSysfun sysfun : all) {
				sysfunMap.put(sysfun.getSfFunctionId(), sysfun);
			}
		}
	}
	
	public void updateCache() {
		// to-do by evin.liu 更新缓存数据
		// 设计思路 使用后台线程，定期更新cache中的数据
	}

	public Map<String, TblSysSysfun> getSysfunMap() {
		return sysfunMap;
	}
	
}
