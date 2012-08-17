package com.cdpc.aio.ams.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdpc.aio.ams.common.exception.AppException;
import com.cdpc.aio.ams.common.interfaces.BaseController;
import com.cdpc.aio.ams.common.interfaces.PageQuery;
import com.cdpc.aio.ams.common.util.PageDataUtils;
import com.cdpc.aio.ams.common.util.PageUtils;
import com.cdpc.aio.ams.common.util.SystemUtils;
import com.cdpc.aio.ams.web.dao.TblSysUsrinfCriterions;
import com.cdpc.aio.ams.web.dao.TblSysUsrinfOrders;
import com.cdpc.aio.ams.web.po.TblSysUsrinf;
import com.cdpc.aio.ams.web.po.TblSysUsrrol;
import com.cdpc.aio.ams.web.service.SysUserService;
import com.cdpc.aio.ams.web.vo.F9906InObject;
import com.cdpc.aio.ams.web.vo.F9906OutObject;

/**
 * 
 * 功能代码：9906
 * 功能名称：系统用户管理
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9906Controller extends BaseController {

	private static Logger log = LoggerFactory.getLogger(F9906Controller.class);
	
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/f9906.do")
	public String gotoSystemUser(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-gotoSystemUser------------------------");
		
		// 跳转到系统用户首页
		return "redirect:/f9906-s-1.do";
	}
	
	/**
	 * 首次分页查询
	 */
	@RequestMapping("/f9906-s-1")
	public String pageSearchFirst(F9906InObject f9906InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9906Controller------------------------");
		log.debug("-----------------Method-pageSearchFirst------------------------");
		
		// 组装查询条件
		TblSysUsrinfCriterions tblSysUsrinfCriterions = new TblSysUsrinfCriterions();
		if(StringUtils.isNotEmpty(f9906InObject.getUiUserId())) { 
			tblSysUsrinfCriterions.uiUserIdEq(f9906InObject.getUiUserId());
		}
		
		// 组装排序条件
		TblSysUsrinfOrders tblSysUsrinfOrders = new TblSysUsrinfOrders();
		tblSysUsrinfOrders.uiUserIdAsc();
		
		// 组装PageQuery
		PageQuery<TblSysUsrinf> pageQuery = new PageQuery<TblSysUsrinf>();
		pageQuery.setCriterionList(tblSysUsrinfCriterions.list());
		pageQuery.setOrderList(tblSysUsrinfOrders.list());
		
		pageQuery = sysUserService.pageQuery(pageQuery);
		
		PageUtils<TblSysUsrinf> pageUtils = new PageUtils<TblSysUsrinf>();
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9906-j-0";
	}
	
	/**
	 * 后续分页查询
	 */
	@RequestMapping("/f9906-s-2")
	public String pageSearchSecond(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9906Controller------------------------");
		log.debug("-----------------Method-pageSearchSecond------------------------");
		
		PageUtils<TblSysUsrinf> pageUtils = new PageUtils<TblSysUsrinf>();
		PageQuery<TblSysUsrinf> pageQuery = pageUtils.getPageQuery(request);
		pageQuery = sysUserService.pageQuery(pageQuery);
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9906-j-0";
	}
	
	@RequestMapping("/f9906-s-3")
	public String gotoInsertPage(HttpServletRequest request, HttpServletResponse response) throws AppException{
		log.debug("-----------------Controller-F9906Controller------------------------");
		log.debug("-----------------Method-gotoInsertPage------------------------");
		
		// 跳转到新增页面
		return "pages/f9906-j-3";
	}
	
	/**
	 * 新增系统用户
	 * @param f9906InObject
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9906-s-4")
	public void insert(F9906InObject f9906InObject,HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9906Controller------------------------");
		log.debug("-----------------Method-insert------------------------");
		
		F9906OutObject f9906OutObject = new F9906OutObject();
		
		// 准备数据
		TblSysUsrinf tblSysUsrinf = new TblSysUsrinf();
		TblSysUsrrol tblSysUsrrol = new TblSysUsrrol();
		try {
			BeanUtils.copyProperties(tblSysUsrinf, f9906InObject);
		} catch (Exception e) {
			log.error("复制属性出错");
			e.printStackTrace();
			
			f9906OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9906OutObject, response);
			return;
		}
		
		tblSysUsrinf.setUiCurLogStats("0");
		tblSysUsrinf.setUiLstModiUserId(SystemUtils.getCurrentUserId(request));
		tblSysUsrinf.setUiLstModiDate(new Date());
		
		tblSysUsrrol.setUrUserId(f9906InObject.getUiUserId());
		tblSysUsrrol.setUrRoleId(f9906InObject.getUserRoleId());
		
		// 保存
		try {
			sysUserService.save(tblSysUsrinf, tblSysUsrrol);
		} catch(Exception e) {
			log.error("保存出错");
			e.printStackTrace();
			
			f9906OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9906OutObject, response);
			return;
		}
		
		f9906OutObject.setSaveSuccess(true);
		super.ajaxOutJson(f9906OutObject, response);
	}
	
	/**
	 * 查看详细信息
	 * @param f9906InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9906-s-5")
	public String viewDetail(F9906InObject f9906InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9906Controller------------------------");
		log.debug("-----------------Method-viewDetail------------------------");
		
		// 检查数据
		List<String> mids = f9906InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要查询的选项框ID为空.");
		}
		String mid = mids.get(0);
		if(StringUtils.isEmpty(mid)) {
			throw new AppException("要查询的选项框ID为空.");
		}
		
		// 准备要查看的数据
		TblSysUsrinf tblSysUsrinf = sysUserService.queryById(mid);
		F9906OutObject f9906OutObject = new F9906OutObject();
		f9906OutObject.setTblSysUsrinf(tblSysUsrinf);
		
		List<TblSysUsrrol> tblSysUsrrols = sysUserService.queryUserRoleByUserId(tblSysUsrinf.getUiUserId());
		f9906OutObject.setUserRole(tblSysUsrrols.get(0).getUrRoleId());
		
		PageDataUtils.saveData2Request(request, "f9906OutObject", f9906OutObject);
		
		return "pages/f9906-j-5";
	}
	
	/**
	 * 删除用户及用户角色信息
	 * @param f9906InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9906-s-6")
	public String delete(F9906InObject f9906InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9906Controller------------------------");
		log.debug("-----------------Method-delete------------------------");
		
		// 删除及批量删除
		List<String> mids = f9906InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要删除的系统用户代码为空.");
		}
		for(int i=0; i< mids.size(); i++) {
			String mid = mids.get(i);
			TblSysUsrinf tblSysUsrinf = sysUserService.queryById(mid);
			try {
				sysUserService.deleteSysUserAndRoleByUserid(tblSysUsrinf.getUiUserId());
			} catch (Exception e) {
				e.printStackTrace();
				throw new AppException("删除系统用户[" + tblSysUsrinf.getUiUserId() + "]出错");
			}
		}
		return "forward:f9906-s-2.do";
	}
	
	/**
	 * 跳转编辑页面
	 * @param f9906InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9906-s-7")
	public String gotoEditPage(F9906InObject f9906InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9906Controller------------------------");
		log.debug("-----------------Method-gotoEditPage------------------------");
		
		//准备数据 
		List<String> mids = f9906InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要编辑的系统用户代码为空.");
		}
		String mid = mids.get(0);
		
		// 查询要编辑记录数据
		TblSysUsrinf tblSysUsrinf = sysUserService.queryById(mid);
		F9906OutObject f9906OutObject = new F9906OutObject();
		f9906OutObject.setTblSysUsrinf(tblSysUsrinf);
		
		List<TblSysUsrrol> tblSysUsrrols = sysUserService.queryUserRoleByUserId(tblSysUsrinf.getUiUserId());
		f9906OutObject.setUserRole(tblSysUsrrols.get(0).getUrRoleId());
		
		PageDataUtils.saveData2Request(request, "f9906OutObject", f9906OutObject);
		return "pages/f9906-j-7";
	}

	/**
	 * 编辑保存
	 * @param f9906InObject
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9906-s-8")
	public void edit(F9906InObject f9906InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-edit------------------------");
		
		F9906OutObject f9906OutObject = new F9906OutObject();
		
		// 准备数据
		TblSysUsrinf tblSysUsrinfNew = new TblSysUsrinf();
		TblSysUsrrol tblSysUsrrol = new TblSysUsrrol();
		
		tblSysUsrinfNew = sysUserService.queryById(f9906InObject.getUiId().toString());
		tblSysUsrrol = sysUserService.queryUniqueRoleByUserId(f9906InObject.getUiUserId());
		
		tblSysUsrinfNew.setUiUserPwd(f9906InObject.getUiUserPwd());
		tblSysUsrinfNew.setUiLstModiUserId(SystemUtils.getCurrentUserId(request));
		tblSysUsrinfNew.setUiLstModiDate(new Date());
		
		tblSysUsrrol.setUrRoleId(f9906InObject.getUserRoleId());
		
		// 更新记录
		try {
			sysUserService.update(tblSysUsrinfNew, tblSysUsrrol);
		} catch(Exception e) {
			log.error("update error.");
			e.printStackTrace();
			
			f9906OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9906OutObject, response);
			return;
		}
		
		f9906OutObject.setEditSuccess(true);
		super.ajaxOutJson(f9906OutObject, response);
	}
	
	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
}
