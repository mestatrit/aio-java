package com.cdpc.aio.web.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdpc.aio.common.interfaces.BaseDAO;
import com.cdpc.aio.web.po.TblSysUsrinf;

/**
 * @author evin.liu
 */
public class TblSysUsrinfDAO extends BaseDAO<TblSysUsrinf> {

	private Logger log = LoggerFactory.getLogger(TblSysUsrinfDAO.class);

	/**
	 * 根据用户姓名查询用户信息
	 * @param username
	 * @return
	 */
	public TblSysUsrinf searchByUserName(String username) {
		if (StringUtils.isEmpty(username)) {
			log.error("searchByUserName username can not be null or ''...");
			throw new IllegalArgumentException("username can not be null or blank or spaces");
		}

		List<TblSysUsrinf> tblSysUsrinfs = searchByCriteria(Restrictions.eq("uiUserId", username));
		return (tblSysUsrinfs == null || tblSysUsrinfs.size() == 0) ? null : tblSysUsrinfs.get(0);
	}
	
	

}
