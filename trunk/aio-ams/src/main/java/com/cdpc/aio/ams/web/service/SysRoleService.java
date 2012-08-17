package com.cdpc.aio.ams.web.service;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.exception.PersistenceException;
import com.cdpc.aio.ams.common.interfaces.BaseService;
import com.cdpc.aio.ams.common.interfaces.BaseSysRoleService;
import com.cdpc.aio.ams.common.interfaces.PageQuery;
import com.cdpc.aio.ams.web.dao.TblSysRolfunDAO;
import com.cdpc.aio.ams.web.dao.TblSysSysrolDAO;
import com.cdpc.aio.ams.web.po.TblSysRolfun;
import com.cdpc.aio.ams.web.po.TblSysSysrol;

@Service
public class SysRoleService implements BaseService, BaseSysRoleService {

	private static Logger log = LoggerFactory.getLogger(SysRoleService.class);

	@Autowired
	private TblSysSysrolDAO tblSysSysrolDAO;
	@Autowired
	private TblSysRolfunDAO tblSysRolfunDAO;

	/**
	 * 分页查询系统角色
	 * 
	 * @param pageQuery
	 * @return
	 */
	public PageQuery<TblSysSysrol> pageQuery(PageQuery<TblSysSysrol> pageQuery) throws AppException {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-pageQuery------------------------");

		if (pageQuery == null) {
			log.debug("pageQuery is null");
			pageQuery = new PageQuery<TblSysSysrol>();
		}
		try {
			return tblSysSysrolDAO.pageQuery(pageQuery);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("分页查询记录出错");
		}
	}

	/**
	 * 保存系统角色信息
	 * 
	 * @param tblSysSysrol
	 * @param rolefuns
	 * @throws AppException
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(TblSysSysrol tblSysSysrol, List<TblSysRolfun> rolefuns) throws Exception {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-save------------------------");

		tblSysSysrolDAO.save(tblSysSysrol);
		tblSysRolfunDAO.saveOrUpdateAll(rolefuns);
	}

	/**
	 * 更新系统角色信息
	 * 
	 * @param tblSysSysrol
	 * @throws AppException
	 * @throws PersistenceException 
	 */
	@Transactional(rollbackFor = Exception.class)
	public void update(TblSysSysrol tblSysSysrol, List<TblSysRolfun> rolefuns) throws Exception {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-update------------------------");

		tblSysSysrolDAO.update(tblSysSysrol);
		tblSysSysrolDAO.bulkUpdate("delete TblSysRolfun t where t.rfRoleId=?", tblSysSysrol.getSrRoleId());
		tblSysRolfunDAO.saveOrUpdateAll(rolefuns);
	}

	/**
	 * 根据记录id<物理主键>删除记录
	 * 
	 * @param id
	 * @throws AppException
	 */
	public void deleteSysRoleByid(String id) throws Exception {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-deleteSysRoleByid------------------------");

		if (StringUtils.isEmpty(id)) {
			throw new InvalidParameterException("参数<id>不合法");
		} else {
			String roleid = queryById(id).getSrRoleId();
			
			tblSysSysrolDAO.bulkUpdate("delete TblSysSysrol t where t.srId=?", Long.parseLong(id));
			tblSysRolfunDAO.bulkUpdate("delete TblSysRolfun t where t.rfRoleId=?", roleid);
		}
	}

	/**
	 * 根据记录id<物理主键>查询
	 * 
	 * @param id
	 * @return
	 */
	public TblSysSysrol queryById(String id) throws AppException {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-queryById------------------------");

		if (StringUtils.isEmpty(id)) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			Long lid = Long.parseLong(id);
			return tblSysSysrolDAO.idEq(lid);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("查询记录出错");
		}
	}

	/**
	 * 根据记录id<物理主键>查询
	 * 
	 * @param id
	 * @return
	 */
	public TblSysSysrol queryById(Long id) throws AppException {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-queryById------------------------");

		if (id == null) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			return tblSysSysrolDAO.idEq(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("查询记录出错");
		}
	}

	/**
	 * 判断角色是否已经存在
	 * 
	 * @param roleid
	 * @return
	 * @throws AppException
	 */
	public boolean isRoleExists(String roleid) throws AppException {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-isRoleIdExists------------------------");

		TblSysSysrol ret = null;
		if (StringUtils.isEmpty(roleid)) {
			throw new InvalidParameterException("参数<roleid>不合法");
		} else {
			try {
				ret = tblSysSysrolDAO.searchByHQL("from TblSysSysrol t where t.srRoleId=?", roleid);
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询角色" + roleid + "出错");
			}
		}

		if (ret != null && ret.getSrRoleId().equals(roleid)) {
			return true;
		}

		return false;
	}

	/**
	 * 根据角色代码查询角色权限
	 * 
	 * @param roleId
	 * @return
	 */
	public Set<String> queryFunctionsByRoleId(String roleId) throws AppException {
		log.debug("-----------------Service-SysRoleService------------------------");
		log.debug("-----------------Method-queryFunctionsByRoleId------------------------");

		List<TblSysRolfun> rets = null;
		if (StringUtils.isEmpty(roleId)) {
			throw new InvalidParameterException("参数<roleId>不合法");
		} else {
			try {
				rets = tblSysRolfunDAO.searchListByHQL("from TblSysRolfun t where t.rfRoleId=?", roleId);
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询角色权限" + roleId + "出错");
			}
		}

		Set<String> funSet = new HashSet<String>();
		for (TblSysRolfun t : rets) {
			funSet.add(t.getRfFunctionId());
		}
		return funSet;
	}

	@Override
	public List getAll() {
		return tblSysSysrolDAO.searchAll();
	}

	public TblSysSysrolDAO getTblSysSysrolDAO() {
		return tblSysSysrolDAO;
	}

	public void setTblSysSysrolDAO(TblSysSysrolDAO tblSysSysrolDAO) {
		this.tblSysSysrolDAO = tblSysSysrolDAO;
	}

	public TblSysRolfunDAO getTblSysRolfunDAO() {
		return tblSysRolfunDAO;
	}

	public void setTblSysRolfunDAO(TblSysRolfunDAO tblSysRolfunDAO) {
		this.tblSysRolfunDAO = tblSysRolfunDAO;
	}

}
