package com.cdpc.aio.ams.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.exception.PersistenceException;
import com.cdpc.aio.ams.common.interfaces.BaseService;
import com.cdpc.aio.ams.common.util.SystemUser;
import com.cdpc.aio.ams.web.cache.CacheFactory;
import com.cdpc.aio.ams.web.dao.TblSysRolfunDAO;
import com.cdpc.aio.ams.web.dao.TblSysUsrinfDAO;
import com.cdpc.aio.ams.web.dao.TblSysUsrrolDAO;
import com.cdpc.aio.ams.web.po.TblSysRolfun;
import com.cdpc.aio.ams.web.po.TblSysSysfun;
import com.cdpc.aio.ams.web.po.TblSysUsrinf;
import com.cdpc.aio.ams.web.po.TblSysUsrrol;

@Service
public class SysUserService implements BaseService {
	
	private Logger log = LoggerFactory.getLogger(SysUserService.class);
	
	@Autowired
	private TblSysUsrinfDAO tblSysUsrinfDAO;
	@Autowired
	private TblSysUsrrolDAO tblSysUsrrolDAO;
	@Autowired
	private TblSysRolfunDAO tblSysRolfunDAO;
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	public TblSysUsrinf loadUserByUsername(String username) {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-loadUserByUsername------------------------");
		
		List<TblSysUsrinf> tblSysUsrinfs = tblSysUsrinfDAO.searchByCriteria(Restrictions.eq("uiUserId", username));
		TblSysUsrinf tblSysUsrinf = null;
		if(tblSysUsrinfs != null && tblSysUsrinfs.size() >= 1){
			tblSysUsrinf = tblSysUsrinfs.get(0);
		}
		return tblSysUsrinf;
	}
	
	/**
	 * 根据用户姓名加载用户具有的权限功能
	 * @param username
	 * @return
	 */
	public List<TblSysSysfun> loadUserFunctionsByUsername(String username) {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-loadUserFunctionsByUsername------------------------");
		
		Map<String,TblSysSysfun> sysfunMap = CacheFactory.getSysFunCache().getSysfunMap();;
		List<TblSysSysfun> userfuns = new ArrayList<TblSysSysfun>();
		List<TblSysUsrrol> userroles = tblSysUsrrolDAO.searchByCriteria(Restrictions.eq("urUserId", username));
		for(TblSysUsrrol  tblSysUsrrol : userroles) {
			String roleid = tblSysUsrrol.getUrRoleId();
			List<TblSysRolfun> tblSysRolfuns = tblSysRolfunDAO.searchByCriteria(Restrictions.eq("rfRoleId", roleid));
			for(TblSysRolfun tblSysRolfun : tblSysRolfuns) {
				TblSysSysfun sysfun = sysfunMap.get(tblSysRolfun.getRfFunctionId());
				userfuns.add(sysfun);
			}
		}
		return userfuns;
	}
	
	/**
	 * 修改用户状态
	 * @param systemUser
	 * @param request
	 * @param status
	 * @throws AppException 
	 */
	public void changeUserStatus(SystemUser systemUser, HttpServletRequest request, String status) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-changeUserStatus------------------------");
		
		TblSysUsrinf currentUser = systemUser.getTblSysUsrinf();
		currentUser.setUiCurLogStats(status);
		currentUser.setUiLstIpAddress(request.getRemoteAddr());
		currentUser.setUiLstUserLoginTime(new Date());
		try {
			tblSysUsrinfDAO.update(currentUser);
		} catch (PersistenceException e) {
			log.error("修改用户状态异常" + e.getMessage());
			e.printStackTrace();
			throw new AppException("修改用户状态异常");
		}
	}
	
	/**
	 * 获取用户有权限的一级菜单
	 * @param systemUser
	 * @return
	 */
	public List<TblSysSysfun> getUserFirstLevelMenu(SystemUser systemUser) {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-getUserFirstLevelMenu------------------------");
		
		List<TblSysSysfun> userfuns = systemUser.getUserfuns();
		List<TblSysSysfun> firstLevelMenu = new ArrayList<TblSysSysfun>();
		for(TblSysSysfun userfun : userfuns) {
			if(userfun != null && userfun.getSfParentId() != null && Constants.TOP_MENU_ID.equals(userfun.getSfParentId())) {
				if(Constants.MENU_FLAG_ON.equals(userfun.getSfMenuFlag())) {
					firstLevelMenu.add(userfun);
				}
			}
		}
		return firstLevelMenu;
	}

	public List getAll() {
		return tblSysUsrinfDAO.searchAll();
	}
	
}
