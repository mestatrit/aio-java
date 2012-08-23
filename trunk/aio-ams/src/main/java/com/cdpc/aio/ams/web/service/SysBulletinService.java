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
import com.cdpc.aio.ams.common.interfaces.PageQuery;
import com.cdpc.aio.ams.web.dao.TblSysBulletinDAO;
import com.cdpc.aio.ams.web.po.TblSysBulletin;

@Service
public class SysBulletinService implements BaseService {

	private Logger log = LoggerFactory.getLogger(SysBulletinService.class);

	@Autowired
	private TblSysBulletinDAO tblSysBulletinDAO;

	/**
	 * 分页查询系统公告
	 * 
	 * @param pageQuery
	 * @return
	 * @throws AppException
	 */
	public PageQuery<TblSysBulletin> pageQuery(PageQuery<TblSysBulletin> pageQuery) throws AppException {
		log.debug("-----------------Service-SysBulletinService------------------------");
		log.debug("-----------------Method-pageQuery------------------------");

		if (pageQuery == null) {
			log.debug("pageQuery is null");
			pageQuery = new PageQuery<TblSysBulletin>();
		}
		try {
			return tblSysBulletinDAO.pageQuery(pageQuery);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("分页查询记录出错");
		}
	}

	/**
	 * 保存系统公告信息
	 * 
	 * @param tblSysBulletin
	 * @throws AppException
	 */
	public void save(TblSysBulletin tblSysBulletin) throws AppException {
		log.debug("-----------------Service-SysBulletinService------------------------");
		log.debug("-----------------Method-save------------------------");

		try {
			tblSysBulletinDAO.save(tblSysBulletin);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("保存记录出错");
		}
	}

	/**
	 * 更新系统公告信息
	 * 
	 * @param tblSysBulletin
	 * @throws AppException
	 */
	public void update(TblSysBulletin tblSysBulletin) throws AppException {
		log.debug("-----------------Service-SysBulletinService------------------------");
		log.debug("-----------------Method-update------------------------");

		try {
			tblSysBulletinDAO.update(tblSysBulletin);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("更新记录出错");
		}
	}

	/**
	 * 根据记录id<物理主键>删除记录
	 * 
	 * @param id
	 * @throws AppException
	 */
	public void deleteSysBulletinByid(String id) throws AppException {
		log.debug("-----------------Service-SysBulletinService------------------------");
		log.debug("-----------------Method-deleteSysBulletinByid------------------------");

		if (StringUtils.isEmpty(id)) {
			throw new InvalidParameterException("参数<id>不合法");
		} else {
			try {
				tblSysBulletinDAO.bulkUpdate("delete TblSysBulletin t where t.btId=?", Long.parseLong(id));
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
				throw new AppException("删除公告" + id + "出错");
			}
		}
	}

	/**
	 * 根据记录id<物理主键>查询
	 * 
	 * @param id
	 * @return
	 */
	public TblSysBulletin queryById(String id) throws AppException {
		log.debug("-----------------Service-SysBulletinService------------------------");
		log.debug("-----------------Method-queryById------------------------");

		if (StringUtils.isEmpty(id)) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			Long lid = Long.parseLong(id);
			return tblSysBulletinDAO.idEq(lid);
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
	public TblSysBulletin queryById(Long id) throws AppException {
		log.debug("-----------------Service-SysBulletinService------------------------");
		log.debug("-----------------Method-queryById------------------------");

		if (id == null) {
			throw new InvalidParameterException("参数<id>不合法");
		}
		try {
			return tblSysBulletinDAO.idEq(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("查询记录出错");
		}
	}
	
	/**
	 * 用户登录后可见的系统公告
	 * @return
	 */
	public List<TblSysBulletin> queryLoginBulletins() throws AppException {
		log.debug("-----------------Service-SysBulletinService------------------------");
		log.debug("-----------------Method-queryLoginBulletins------------------------");
		
		try {
			return tblSysBulletinDAO.searchListByHQL("from TblSysBulletin t order by btCreateDate desc, btLstModiDate desc", new Object[]{}, 0, 5);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("查询系统公告出错");
		}
	}

	@Override
	public List getAll() {
		return null;
	}

	public TblSysBulletinDAO getTblSysBulletinDAO() {
		return tblSysBulletinDAO;
	}

	public void setTblSysBulletinDAO(TblSysBulletinDAO tblSysBulletinDAO) {
		this.tblSysBulletinDAO = tblSysBulletinDAO;
	}

}
