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
import com.cdpc.aio.ams.web.dao.TblSysSysfunCriterions;
import com.cdpc.aio.ams.web.dao.TblSysSysfunOrders;
import com.cdpc.aio.ams.web.po.TblSysSysfun;
import com.cdpc.aio.ams.web.service.SysFuncService;
import com.cdpc.aio.ams.web.vo.F9904InObject;
import com.cdpc.aio.ams.web.vo.F9904OutObject;

/**
 * 
 * 功能点9904控制器
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9904Controller extends BaseController {

	private static Logger log = LoggerFactory.getLogger(F9904Controller.class);
	
	@Autowired
	private SysFuncService sysFuncService;
	
	@RequestMapping("/f9904.do")
	public String gotoSearchPage(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-gotoSystemFunctionPage------------------------");
		
		// 跳转到系统功能首页
		return "pages/f9904-j-0";
	}
	
	/**
	 * 首次分页查询
	 */
	@RequestMapping("/f9904-s-1")
	public String pageSearchFirst(F9904InObject f9904InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-pageSearchFirst------------------------");
		
		// 组装查询条件
		TblSysSysfunCriterions tblSysSysfunCriterions = new TblSysSysfunCriterions();
		if(StringUtils.isNotEmpty(f9904InObject.getSfFunctionId())) { 
			tblSysSysfunCriterions.sfFunctionIdEq(f9904InObject.getSfFunctionId());
		}
		if(StringUtils.isNotEmpty(f9904InObject.getSfFunctionName())) {
			tblSysSysfunCriterions.sfFunctionNameEq(f9904InObject.getSfFunctionName());
		}
		// 组装排序条件
		TblSysSysfunOrders tblSysSysfunOrders = new TblSysSysfunOrders();
		tblSysSysfunOrders.sfFunctionIdAsc();
		
		// 组装PageQuery
		PageQuery<TblSysSysfun> pageQuery = new PageQuery<TblSysSysfun>();
		pageQuery.setCriterionList(tblSysSysfunCriterions.list());
		pageQuery.setOrderList(tblSysSysfunOrders.list());
		
		pageQuery = sysFuncService.pageQuery(pageQuery);
		
		PageUtils<TblSysSysfun> pageUtils = new PageUtils<TblSysSysfun>();
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9904-j-1";
	}
	
	/**
	 * 后续分页查询
	 */
	@RequestMapping("/f9904-s-2")
	public String pageSearchSecond(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-pageSearchSecond------------------------");
		
		PageUtils<TblSysSysfun> pageUtils = new PageUtils<TblSysSysfun>();
		PageQuery<TblSysSysfun> pageQuery = pageUtils.getPageQuery(request);
		pageQuery = sysFuncService.pageQuery(pageQuery);
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9904-j-1";
	}
	
	@RequestMapping("/f9904-s-3")
	public String gotoInsertPage(HttpServletRequest request, HttpServletResponse response) throws AppException{
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-gotoInsertPage------------------------");
		
		// 跳转到新增页面
		return "pages/f9904-j-3";
	}
	
	/**
	 * 新增系统功能
	 */
	@RequestMapping("/f9904-s-4")
	public void insert(F9904InObject f9904InObject,HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-insert------------------------");
		
		F9904OutObject f9904OutObject = new F9904OutObject();
		
		// 准备数据
		TblSysSysfun tblSysSysfun = new TblSysSysfun();
		try {
			BeanUtils.copyProperties(tblSysSysfun, f9904InObject);
		} catch (Exception e) {
			log.error("复制属性出错");
			e.printStackTrace();
			
			f9904OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9904OutObject, response);
			return;
		}
		tblSysSysfun.setSfLstModiUserId(SystemUtils.getCurrentUserId(request));
		tblSysSysfun.setSfLstModiDate(new Date());
		
		// 验证功能代码是否重复
		TblSysSysfun t = sysFuncService.queryByFunctionId(tblSysSysfun.getSfFunctionId());
		if(t != null) {
			log.error("记录已存在，功能代码重复.");
			
			f9904OutObject.setErrorMessage("记录已存在，功能代码重复.");
			super.ajaxOutJson(f9904OutObject, response);
			return;
		}
		
		// 保存
		try {
			sysFuncService.save(tblSysSysfun);
		} catch(Exception e) {
			log.error("保存系统功能出错");
			e.printStackTrace();
			
			f9904OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9904OutObject, response);
			return;
		}
		
		// 成功返回
		f9904OutObject.setSaveSuccess(true);
		super.ajaxOutJson(f9904OutObject, response);
	}
	
	/**
	 * 查看系统功能详细信息
	 * @param f9904InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9904-s-5")
	public String viewDetail(F9904InObject f9904InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-viewDetail------------------------");
		
		F9904OutObject f9904OutObject = new F9904OutObject();
		
		// 准备要查看的数据
		List<String> mids = f9904InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要查询的功能代码为空.");
		}
		String sfId = mids.get(0);
		if(StringUtils.isEmpty(sfId)) {
			throw new AppException("要查询的功能代码为空.");
		}
		TblSysSysfun tblSysSysfun = sysFuncService.queryById(sfId);
		
		// 成功返回
		f9904OutObject.setTblSysSysfun(tblSysSysfun);
		PageDataUtils.saveData2Request(request, "f9904OutObject", f9904OutObject);
		return "pages/f9904-j-5";
	}
	
	/**
	 * 删除及批量删除功能记录
	 * @param f9904InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9904-s-6")
	public String delete(F9904InObject f9904InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-delete------------------------");
		
		// 删除选定记录
		List<String> mids = f9904InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要删除的功能代码为空.");
		}
		for(int i=0; i< mids.size(); i++) {
			String mid = mids.get(i);
			sysFuncService.deleteById(mid);
		}
		return "forward:f9904-s-2.do";
	}
	
	/**
	 * 转到编辑系统功能信息页面
	 * @param f9904InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9904-s-7")
	public String gotoEditPage(F9904InObject f9904InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-gotoEditPage------------------------");
		
		F9904OutObject f9904OutObject = new F9904OutObject();
		
		// 查询要编辑的数据
		List<String> mids = f9904InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要查询的功能代码为空.");
		}
		String sfId = mids.get(0);
		TblSysSysfun tblSysSysfun = sysFuncService.queryById(sfId);
		
		//成功返回
		f9904OutObject.setTblSysSysfun(tblSysSysfun);
		PageDataUtils.saveData2Request(request, "f9904OutObject", f9904OutObject);
		return "pages/f9904-j-7";
	}
	
	/**
	 * 编辑系统功能信息
	 * @param f9904InObject
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9904-s-8")
	public void edit(F9904InObject f9904InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-edit------------------------");
		
		F9904OutObject f9904OutObject = new F9904OutObject();
		
		// 准备数据
		TblSysSysfun tblSysSysfunNew = new TblSysSysfun();
		tblSysSysfunNew = sysFuncService.queryById(f9904InObject.getSfId());
		try {
			BeanUtils.copyProperties(tblSysSysfunNew, f9904InObject);
		} catch (Exception e) {
			log.error("编辑系统功能出错");
			e.printStackTrace();
			
			f9904OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9904OutObject, response);
			return;
		}
		tblSysSysfunNew.setSfLstModiUserId(SystemUtils.getCurrentUserId(request));
		tblSysSysfunNew.setSfLstModiDate(new Date());
		
		// 更新
		try {
			sysFuncService.update(tblSysSysfunNew);
		} catch(Exception e) {
			log.error("更新系统功能出错");
			
			f9904OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9904OutObject, response);
			return;
		}
		
		// 成功返回
		f9904OutObject.setEditSuccess(true);
		super.ajaxOutJson(f9904OutObject, response);
	}
	
	public SysFuncService getSysFuncService() {
		return sysFuncService;
	}

	public void setSysFuncService(SysFuncService sysFuncService) {
		this.sysFuncService = sysFuncService;
	}
	
}