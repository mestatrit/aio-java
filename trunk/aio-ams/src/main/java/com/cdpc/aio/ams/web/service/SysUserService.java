package com.cdpc.aio.ams.web.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.interfaces.BaseService;
import com.cdpc.aio.ams.common.interfaces.BaseSysUserService;
import com.cdpc.aio.ams.common.interfaces.PageQuery;
import com.cdpc.aio.ams.common.util.SystemUser;
import com.cdpc.aio.ams.web.dao.TblSysSysfunDAO;
import com.cdpc.aio.ams.web.dao.TblSysUsrinfDAO;
import com.cdpc.aio.ams.web.dao.TblSysUsrrolDAO;
import com.cdpc.aio.ams.web.po.TblSysSysfun;
import com.cdpc.aio.ams.web.po.TblSysUsrinf;
import com.cdpc.aio.ams.web.po.TblSysUsrrol;

@Service
public class SysUserService implements BaseService, BaseSysUserService {
	
	private Logger log = LoggerFactory.getLogger(SysUserService.class);
	
	@Autowired
	private TblSysUsrinfDAO tblSysUsrinfDAO;
	@Autowired
	private TblSysUsrrolDAO tblSysUsrrolDAO;
	@Autowired
	private TblSysSysfunDAO tblSysSysfunDAO;
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	public TblSysUsrinf loadUserByUsername(String username) {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-loadUserByUsername------------------------");
		
		List<TblSysUsrinf> tblSysUsrinfs = tblSysUsrinfDAO.searchByCriteria(Restrictions.eq("uiUserId", username));
		if(tblSysUsrinfs != null && tblSysUsrinfs.size() >= 1){
			return tblSysUsrinfs.get(0);
		}
		return null;
	}
	
	/**
	 * 根据用户姓名加载用户具有的权限功能
	 * @param username
	 * @return
	 */
	@Override
	public List<TblSysSysfun> loadUserFunctionsByUsername(String username) {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-loadUserFunctionsByUsername------------------------");
		
		List<TblSysSysfun> userfuns = new ArrayList<TblSysSysfun>();
		userfuns = tblSysSysfunDAO.searchListByHQL("select distinct sf from TblSysUsrrol ur,TblSysRolfun rf,TblSysSysfun sf where ur.urUserId=? and ur.urRoleId=rf.rfRoleId and rf.rfFunctionId=sf.sfFunctionId order by sf.sfParentId asc, sf.sfFunctionId asc", username);
		return userfuns;
	}
	
	/**
	 * 修改用户状态
	 * @param systemUser
	 * @param request
	 * @param status
	 */
	public void changeUserStatus(SystemUser systemUser, HttpServletRequest request, String status) {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-changeUserStatus------------------------");
		
		TblSysUsrinf currentUser = systemUser.getTblSysUsrinf();
		currentUser.setUiCurLogStats(status);
		currentUser.setUiLstIpAddress(request.getRemoteAddr());
		currentUser.setUiLstUserLoginTime(new Date());
			
		tblSysUsrinfDAO.update(currentUser);
		
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
	
	/**
	 * 分页查询系统用户
	 * @param pageQuery
	 * @return
	 */
	public PageQuery<TblSysUsrinf> pageQuery(PageQuery<TblSysUsrinf> pageQuery) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-pageQuery------------------------");
		
		if(pageQuery == null) {
			log.debug("pageQuery is null");	
			pageQuery = new PageQuery<TblSysUsrinf>();
		}
		try {
			return tblSysUsrinfDAO.pageQuery(pageQuery);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("分页查询记录出错");
		}
	}
	
	/**
	 * 保存系统用户及角色信息
	 * @param tblSysUsrinf
	 * @param f9906InObject
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public void save(TblSysUsrinf tblSysUsrinf, TblSysUsrrol tblSysUsrrol) throws Exception {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-save------------------------");
		
		tblSysUsrinfDAO.save(tblSysUsrinf);
		tblSysUsrrolDAO.save(tblSysUsrrol);
	}
	
	/**
	 * 更新系统用户信息
	 * @param tblSysUsrinf
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public void update(TblSysUsrinf tblSysUsrinf, TblSysUsrrol tblSysUsrrol) throws Exception {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-update------------------------");
		
		tblSysUsrinfDAO.update(tblSysUsrinf);
		tblSysUsrrolDAO.update(tblSysUsrrol);
	}
	
	/**
	 * 根据记录id<物理主键>删除记录
	 * @param id
	 * @throws AppException
	 */
	public void deleteSysUserByid(String id) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-deleteSysUserByid------------------------");
		
		if(StringUtils.isEmpty(id)) { 
			throw new InvalidParameterException("参数<id>不合法");
		}else {
			try {
				tblSysUsrinfDAO.bulkUpdate("delete TblSysUsrinf t where t.uiId=" + id);
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("删除用户" + id + "出错");
			}
		}
	}
	
	/**
	 * 根据记录id<物理主键>查询
	 * @param id
	 * @return
	 */
	public TblSysUsrinf queryById(String id) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-queryById------------------------");
		
		if(StringUtils.isEmpty(id)) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			Long lid = Long.parseLong(id);
			return tblSysUsrinfDAO.idEq(lid);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("查询记录出错");
		}
	}
	
	/**
	 * 根据记录id<物理主键>查询
	 * @param id
	 * @return
	 */
	public TblSysUsrinf queryById(Long id) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-queryById------------------------");
		
		if(id == null) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			return tblSysUsrinfDAO.idEq(id);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("查询记录出错");
		}
	}
	
	/**
	 * 根据记录用户id<逻辑主键>删除记录
	 * @param id
	 * @throws AppException
	 */
	@Transactional(rollbackFor=Exception.class)
	public void deleteSysUserAndRoleByUserid(String userid) throws Exception {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-deleteSysUserAndRoleByUserid------------------------");
		
		if(StringUtils.isEmpty(userid)) { 
			throw new InvalidParameterException("参数<userid>不合法");
		}else {
			tblSysUsrinfDAO.bulkUpdate("delete TblSysUsrinf t where t.uiUserId=?", userid);
			tblSysUsrrolDAO.bulkUpdate("delete TblSysUsrrol t where t.urUserId=?", userid);
		}
	}
	
	/**
	 * 根据记录用户id<逻辑主键>查询用户角色
	 * @param id
	 * @throws AppException
	 */
	public List<TblSysUsrrol> queryUserRoleByUserId(String userid) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-queryUserRoleByUserId------------------------");
		
		if(StringUtils.isEmpty(userid)) { 
			throw new InvalidParameterException("参数<userid>不合法");
		}else {
			try {
				return tblSysUsrrolDAO.searchByCriteria(Restrictions.eq("urUserId", userid));
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询用户" + userid + "角色出错");
			}
		}
	}
	
	/**
	 * 根据记录用户id<逻辑主键>查询用户角色
	 * @param id
	 * @throws AppException
	 */
	public TblSysUsrrol queryUniqueRoleByUserId(String userid) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-queryUserRoleByUserId------------------------");
		
		if(StringUtils.isEmpty(userid)) { 
			throw new InvalidParameterException("参数<userid>不合法");
		}else {
			try {
				List<TblSysUsrrol> roles = tblSysUsrrolDAO.searchByCriteria(Restrictions.eq("urUserId", userid));
				if(roles == null || roles.size() == 0) {
					return null;
				} else {
					return roles.get(0);
				}
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询用户" + userid + "角色出错");
			}
		}
	}
	
	public void changeUserPasswd(TblSysUsrinf tblSysUsrinf) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-changeUserPasswd------------------------");
		try {
			tblSysUsrinfDAO.update(tblSysUsrinf);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("修改用户" + tblSysUsrinf.getUiUserId() + "密码出错");
		}
	}

	@Override
	public List getAll() {
		return tblSysUsrinfDAO.searchAll();
	}
	
}
