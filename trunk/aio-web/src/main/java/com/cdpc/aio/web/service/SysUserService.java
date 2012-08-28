package com.cdpc.aio.web.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdpc.aio.common.exception.AppException;
import com.cdpc.aio.common.exception.PersistenceException;
import com.cdpc.aio.common.interfaces.BaseService;
import com.cdpc.aio.common.util.SystemUser;
import com.cdpc.aio.web.dao.TblSysLogrecDAO;
import com.cdpc.aio.web.dao.TblSysUsrinfDAO;
import com.cdpc.aio.web.po.TblSysLogrec;
import com.cdpc.aio.web.po.TblSysUsrinf;

@Service
public class SysUserService implements BaseService {

	private Logger log = LoggerFactory.getLogger(SysUserService.class);

	@Autowired
	private TblSysUsrinfDAO tblSysUsrinfDAO;
	@Autowired
	private TblSysLogrecDAO tblSysLogrecDAO;

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	public TblSysUsrinf loadUserByUsername(String username) {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-loadUserByUsername------------------------");

		TblSysUsrinf tblSysUsrinf = tblSysUsrinfDAO.searchByUserName(username);
		
		return tblSysUsrinf;
	}

	/**
	 * 修改用户状态
	 * 
	 * @param systemUser
	 * @param request
	 * @param status
	 * @throws AppException
	 */
	public void changeUserStatus(SystemUser systemUser, HttpServletRequest request, String status) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-changeUserStatus------------------------");

		String username = systemUser.getUsername();
		TblSysUsrinf currentUser = tblSysUsrinfDAO.searchByUserName(username);
		currentUser.setUiCurLogStats(status);
		currentUser.setUiLstIpAddress(request.getRemoteAddr());
		currentUser.setUiLstUserLoginTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		try {
			tblSysUsrinfDAO.update(currentUser);
		} catch (PersistenceException e) {
			log.error("修改用户状态异常" + e.getMessage());
			e.printStackTrace();
			throw new AppException("修改用户状态异常");
		}
	}

	@Override
	public List getAll() {
		return tblSysUsrinfDAO.searchAll();
	}
	
	/**
	 * 保存登录日志
	 * @param tblSysLogrec
	 * @throws AppException
	 */
	public void saveLoginLog(String lrUsername, String lrLogindate, String lrLoginip) throws AppException {
		log.debug("-----------------Service-SysUserService------------------------");
		log.debug("-----------------Method-saveLoginLog------------------------");
		
		TblSysLogrec tblSysLogrec = new TblSysLogrec();
		tblSysLogrec.setLrId(tblSysLogrecDAO.findNextSequenceVal("SEQ_TBL_SYS_LOGREC_LR_ID"));
		tblSysLogrec.setLrUsername(lrUsername);
		tblSysLogrec.setLrLogindate(lrLogindate);
		tblSysLogrec.setLrLoginip(lrLoginip);
		
		try {
			tblSysLogrecDAO.save(tblSysLogrec);
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new AppException("记录用户登录日志出错");
		}
	}

	public TblSysUsrinfDAO getTblSysUsrinfDAO() {
		return tblSysUsrinfDAO;
	}

	public void setTblSysUsrinfDAO(TblSysUsrinfDAO tblSysUsrinfDAO) {
		this.tblSysUsrinfDAO = tblSysUsrinfDAO;
	}

	public TblSysLogrecDAO getTblSysLogrecDAO() {
		return tblSysLogrecDAO;
	}

	public void setTblSysLogrecDAO(TblSysLogrecDAO tblSysLogrecDAO) {
		this.tblSysLogrecDAO = tblSysLogrecDAO;
	}

}
