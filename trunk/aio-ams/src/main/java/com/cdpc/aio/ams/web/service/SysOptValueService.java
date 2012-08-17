package com.cdpc.aio.ams.web.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.interfaces.BaseService;
import com.cdpc.aio.ams.common.interfaces.BaseSysOptValueService;
import com.cdpc.aio.ams.common.interfaces.PageQuery;
import com.cdpc.aio.ams.web.dao.TblSysOptvalCriterions;
import com.cdpc.aio.ams.web.dao.TblSysOptvalDAO;
import com.cdpc.aio.ams.web.po.TblSysOptval;

@Service
public class SysOptValueService implements BaseService, BaseSysOptValueService {

	private static Logger log = LoggerFactory.getLogger(SysOptValueService.class);
	
	@Autowired
	private TblSysOptvalDAO tblSysOptvalDAO;
	
	/**
	 * 分页查询系统选项框
	 * @param pageQuery
	 * @return
	 */
	public PageQuery<TblSysOptval> pageQuery(PageQuery<TblSysOptval> pageQuery) throws AppException {
		log.debug("-----------------Service-SysOptValueService------------------------");
		log.debug("-----------------Method-pageQuery------------------------");
		
		if(pageQuery == null) {
			log.debug("pageQuery is null");	
			pageQuery = new PageQuery<TblSysOptval>();
		}
		try {
			return tblSysOptvalDAO.pageQuery(pageQuery);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("分页查询记录出错");
		}
	}
	
	/**
	 * 保存系统选项框
	 * @param tblSysOptval
	 * @throws AppException
	 */
	public void save(TblSysOptval tblSysOptval) throws AppException {
		log.debug("-----------------Service-SysOptValueService------------------------");
		log.debug("-----------------Method-save------------------------");
		
		try {
			tblSysOptvalDAO.save(tblSysOptval);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("保存记录出错");
		}
	}
	
	/**
	 * 更新系统选项框
	 * @param tblSysOptval
	 * @throws AppException
	 */
	public void update(TblSysOptval tblSysOptval) throws AppException {
		log.debug("-----------------Service-SysOptValueService------------------------");
		log.debug("-----------------Method-update------------------------");
		
		try {
			tblSysOptvalDAO.update(tblSysOptval);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("更新记录出错");
		}
	}
	
	/**
	 * 根据记录id<物理主键>删除记录
	 * @param id
	 * @throws AppException
	 */
	public void deleteSysOptByid(String id) throws AppException {
		log.debug("-----------------Service-SysOptValueService------------------------");
		log.debug("-----------------Method-deleteSysOptByid------------------------");
		
		if(StringUtils.isEmpty(id)) { 
			throw new InvalidParameterException("参数<id>不合法");
		}else {
			try {
				tblSysOptvalDAO.bulkUpdate("delete TblSysOptval t where t.ovId=?", Long.parseLong(id));
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("删除功能" + id + "出错");
			}
		}
	}
	
	/**
	 * 根据表名、列名查询选项列表
	 * @param ovTblName
	 * @param ovColName
	 * @return
	 */
	public List<TblSysOptval> queryByTblOrColName(String ovTblName, String ovColName) throws AppException {
		log.debug("-----------------Service-SysOptValueService------------------------");
		log.debug("-----------------Method-queryByTblColName------------------------");
		
		if(StringUtils.isEmpty(ovTblName) || StringUtils.isEmpty(ovColName)) { 
			throw new InvalidParameterException("参数<ovTblName or ovColName>不合法");
		} else {
			
			TblSysOptvalCriterions tblSysOptvalCriterions = new TblSysOptvalCriterions();
			if(StringUtils.isNotEmpty(ovTblName)) { 
				tblSysOptvalCriterions.ovTblNameEq(ovTblName);
			}
			if(StringUtils.isNotEmpty(ovColName)) { 
				tblSysOptvalCriterions.ovColNameEq(ovColName);
			}
			try {
				List <TblSysOptval> tblSysOptvals= tblSysOptvalDAO.searchByCriteria(tblSysOptvalCriterions.list());
				return tblSysOptvals;
			} catch(Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("查询记录出错");
			}
		}
	}
	
	/**
	 * 根据记录id<物理主键>查询
	 * @param id
	 * @return
	 */
	public TblSysOptval queryById(String id) throws AppException {
		log.debug("-----------------Service-SysOptValueService------------------------");
		log.debug("-----------------Method-queryById------------------------");
		
		if(StringUtils.isEmpty(id)) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			Long lid = Long.parseLong(id);
			return tblSysOptvalDAO.idEq(lid);
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
	public TblSysOptval queryById(Long id) throws AppException {
		log.debug("-----------------Service-SysOptValueService------------------------");
		log.debug("-----------------Method-queryById------------------------");
		
		if(id == null) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			return tblSysOptvalDAO.idEq(id);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("查询记录出错");
		}
	}
	
	public List getAll() {
		return tblSysOptvalDAO.searchAll();
	}

	public TblSysOptvalDAO getTblSysOptvalDAO() {
		return tblSysOptvalDAO;
	}

	public void setTblSysOptvalDAO(TblSysOptvalDAO tblSysOptvalDAO) {
		this.tblSysOptvalDAO = tblSysOptvalDAO;
	}
	
}
