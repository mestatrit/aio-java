package com.cdpc.aio.ams.web.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.interfaces.BaseService;
import com.cdpc.aio.ams.common.interfaces.BaseSysFuncService;
import com.cdpc.aio.ams.common.interfaces.PageQuery;
import com.cdpc.aio.ams.common.util.SystemUser;
import com.cdpc.aio.ams.web.dao.TblSysSysfunDAO;
import com.cdpc.aio.ams.web.po.TblSysSysfun;

@Service
public class SysFuncService implements BaseService , BaseSysFuncService {
	
	private static Logger log = LoggerFactory.getLogger(SysFuncService.class);
	
	@Autowired
	private TblSysSysfunDAO tblSysSysfunDAO;
	
	/**
	 * 分页查询系统功能
	 * @param tblSysSysfun
	 * @return
	 */
	public PageQuery<TblSysSysfun> pageQuery(PageQuery<TblSysSysfun> pageQuery) throws AppException {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-pageQueryTblSysSysfun------------------------");
		
		if(pageQuery == null) {
			log.debug("pageQuery is null");	
			pageQuery = new PageQuery<TblSysSysfun>();
		}
		try {
			return tblSysSysfunDAO.pageQuery(pageQuery);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("分页查询记录出错");
		}
	}
	
	/**
	 * 保存系统功能
	 * @param tblSysSysfun
	 * @throws AppException
	 */
	public void save(TblSysSysfun tblSysSysfun) throws AppException {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-save------------------------");
		
		try {
			tblSysSysfunDAO.save(tblSysSysfun);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("保存出错");
		}
	}
	
	/**
	 * 更新系统功能
	 * @param tblSysSysfun
	 * @throws AppException
	 */
	public void update(TblSysSysfun tblSysSysfun) throws AppException {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-update------------------------");
		
		try {
			tblSysSysfunDAO.update(tblSysSysfun);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("更新出错");
		}
	}
	
	/**
	 * 根据记录代码<物理主键>删除记录
	 * @param sfId
	 */
	public void deleteById(String sfId) throws AppException {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-deleteById------------------------");
		
		if(StringUtils.isEmpty(sfId)) { 
			throw new InvalidParameterException("参数<sfId>不合法");
		}else {
			try {
				tblSysSysfunDAO.bulkUpdate("delete TblSysSysfun t where t.sfId=" + sfId);
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("删除系统功能记录" + sfId + "出错");
			}
		}
	}
	
	/**
	 * 根据功能id<逻辑主键>查询系统功能
	 * @param fid
	 * @return
	 */
	public TblSysSysfun queryByFunctionId(String fid) throws AppException {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-queryById------------------------");
		
		if(StringUtils.isEmpty(fid)) { 
			throw new InvalidParameterException("参数<fid>不合法");
		}else {
			try {
				List<TblSysSysfun> tblSysSysfuns= tblSysSysfunDAO.sfFunctionIdEq(fid);
				if(tblSysSysfuns == null || tblSysSysfuns.size() == 0) {
					return null;
				} else {
					return tblSysSysfuns.get(0);
				}
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询记录出错");
			}
		}
	}
	
	/**
	 * 根据记录id<物理主键>查询系统功能
	 * @param id
	 * @return
	 */
	public TblSysSysfun queryById(Long id) throws AppException {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-queryById------------------------");
		
		if(id == null) { 
			throw new InvalidParameterException("参数<id>不合法");
		}else {
			try {
				TblSysSysfun tblSysSysfun= tblSysSysfunDAO.idEq(id);
				return tblSysSysfun;
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询记录出错");
			}
		}
	}
	
	/**
	 * 根据记录id<物理主键>查询系统功能
	 * @param sid
	 * @return
	 */
	public TblSysSysfun queryById(String sid) throws AppException {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-queryById------------------------");
		
		if(StringUtils.isEmpty(sid)) { 
			throw new InvalidParameterException("参数<sid>不合法");
		}else {
			try {
				Long lid = Long.parseLong(sid);
				TblSysSysfun tblSysSysfuns= tblSysSysfunDAO.idEq(lid);
				return tblSysSysfuns;
			} catch(NumberFormatException e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("记录id转换为Long类型出错");
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询数据库异常");
			}
		}
	}
	
	/**
	 * 生成用户具有权限的菜单XML
	 * @param systemUser
	 * @param parentFunctionId
	 * @return
	 */
	public String selectMenuXml(SystemUser systemUser, String parentFunctionId) {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-selectMenuXml------------------------");
		
		String menuXml = null;
		List<TblSysSysfun> menulist = selectMenuList(systemUser, parentFunctionId);
		if(menulist != null && menulist.size() != 0) {
			menuXml = MenuXmlBuilder.buildMenuXml(menulist);
		}
		if(menuXml == null) { 
			menuXml = "";
		}
		return menuXml;
	}
	
	/**
	 * 查询用户拥有权限的Menu列表
	 * @param systemUser
	 * @param parentFunctionId
	 * @return
	 */
	public List<TblSysSysfun> selectMenuList(SystemUser systemUser, String parentFunctionId) {
		log.debug("-----------------Service-SysFuncService------------------------");
		log.debug("-----------------Method-selectMenuList------------------------");
		
		if(systemUser == null || parentFunctionId == null) {
			log.warn("sysUser or parentFunctionId is null");
			return null;
		}
		if(StringUtils.isEmpty(parentFunctionId)) {
			log.warn("parentFunctionId is empty");
			return null;
		}
		List<TblSysSysfun> resultList = new ArrayList<TblSysSysfun>();
		List<TblSysSysfun> userfuns = systemUser.getUserfuns();
		for(TblSysSysfun userfun : userfuns) {
			if(userfun != null && Constants.MENU_FLAG_ON.equals(userfun.getSfMenuFlag())) {
				if(userfun != null && userfun.getSfParentId() != null) {
					if(parentFunctionId.equals(userfun.getSfParentId())) {
						resultList.add(userfun);
					}
				}
			}
		}
		return resultList;
	}
	
	public List getAll() {
		return tblSysSysfunDAO.searchAll();
	}

	public TblSysSysfunDAO getTblSysSysfunDAO() {
		return tblSysSysfunDAO;
	}

	public void setTblSysSysfunDAO(TblSysSysfunDAO tblSysSysfunDAO) {
		this.tblSysSysfunDAO = tblSysSysfunDAO;
	}
	
}
