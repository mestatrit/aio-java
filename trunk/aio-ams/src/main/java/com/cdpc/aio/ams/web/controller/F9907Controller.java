package com.cdpc.aio.ams.web.controller;

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
import com.cdpc.aio.ams.web.dao.TblSysOptvalCriterions;
import com.cdpc.aio.ams.web.dao.TblSysOptvalOrders;
import com.cdpc.aio.ams.web.po.TblSysOptval;
import com.cdpc.aio.ams.web.service.SysOptValueService;
import com.cdpc.aio.ams.web.vo.F9907InObject;
import com.cdpc.aio.ams.web.vo.F9907OutObject;

/**
 * 
 * 功能点9907控制器
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9907Controller extends BaseController {

	private static Logger log = LoggerFactory.getLogger(F9907Controller.class);
	
	@Autowired
	private SysOptValueService sysOptValueService;
	
	@RequestMapping("/f9907.do")
	public String gotoSearchPage(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-gotoSearchPage------------------------");
		
		// 跳转到系统选项框管理首页
		return "pages/f9907-j-0";
	}
	
	/**
	 * 首次分页查询
	 */
	@RequestMapping("/f9907-s-1")
	public String pageSearchFirst(F9907InObject f9907InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-pageSearchFirst------------------------");
		
		// 组装查询条件
		TblSysOptvalCriterions tblSysOptvalCriterions = new TblSysOptvalCriterions();
		if(StringUtils.isNotEmpty(f9907InObject.getOvTblName())) { 
			tblSysOptvalCriterions.ovTblNameEq(f9907InObject.getOvTblName());
		}
		if(StringUtils.isNotEmpty(f9907InObject.getOvColName())) { 
			tblSysOptvalCriterions.ovColNameEq(f9907InObject.getOvColName());
		}
		if(StringUtils.isNotEmpty(f9907InObject.getOvOptLabel())) { 
			tblSysOptvalCriterions.ovOptLabelEq(f9907InObject.getOvOptLabel());
		}
		if(StringUtils.isNotEmpty(f9907InObject.getOvOptValue())) { 
			tblSysOptvalCriterions.ovOptValueEq(f9907InObject.getOvOptValue());
		}
		// 组装排序条件
		TblSysOptvalOrders tblSysOptvalOrders = new TblSysOptvalOrders();
		tblSysOptvalOrders.ovOptValueAsc();
		
		// 组装PageQuery
		PageQuery<TblSysOptval> pageQuery = new PageQuery<TblSysOptval>();
		pageQuery.setCriterionList(tblSysOptvalCriterions.list());
		pageQuery.setOrderList(tblSysOptvalOrders.list());
		
		pageQuery = sysOptValueService.pageQuery(pageQuery);
		
		PageUtils<TblSysOptval> pageUtils = new PageUtils<TblSysOptval>();
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9907-j-1";
	}
	
	/**
	 * 后续分页查询
	 */
	@RequestMapping("/f9907-s-2")
	public String pageSearchSecond(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-pageSearchSecond------------------------");
		
		PageUtils<TblSysOptval> pageUtils = new PageUtils<TblSysOptval>();
		PageQuery<TblSysOptval> pageQuery = pageUtils.getPageQuery(request);
		pageQuery = sysOptValueService.pageQuery(pageQuery);
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9907-j-1";
	}
	
	@RequestMapping("/f9907-s-3")
	public String gotoInsertPage(HttpServletRequest request, HttpServletResponse response) throws AppException{
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-gotoInsertPage------------------------");
		
		// 跳转到新增页面
		return "pages/f9907-j-3";
	}
	
	/**
	 * 新增选项框
	 * @param f9907InObject
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9907-s-4")
	public void insert(F9907InObject f9907InObject,HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-insert------------------------");
		
		F9907OutObject f9907OutObject = new F9907OutObject();
		
		// 准备数据
		TblSysOptval tblSysOptval = new TblSysOptval();
		try {
			BeanUtils.copyProperties(tblSysOptval, f9907InObject);
		} catch (Exception e) {
			log.error("复制属性出错");
			e.printStackTrace();
			
			f9907OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9907OutObject, response);
			return;
		}
		
		// 保存
		try {
			sysOptValueService.save(tblSysOptval);
		} catch(Exception e) {
			log.error("保存出错");
			e.printStackTrace();
			
			f9907OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9907OutObject, response);
			return;
		}
		
		f9907OutObject.setSaveSuccess(true);
		super.ajaxOutJson(f9907OutObject, response);
	}
	
	/**
	 * 查看详细信息
	 * @param f9907InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9907-s-5")
	public String viewDetail(F9907InObject f9907InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-viewDetail------------------------");
		
		// 检查数据
		List<String> mids = f9907InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要查询的选项框ID为空.");
		}
		String mid = mids.get(0);
		if(StringUtils.isEmpty(mid)) {
			throw new AppException("要查询的选项框ID为空.");
		}
		
		// 准备要查看的数据
		TblSysOptval tblSysOptval = sysOptValueService.queryById(mid);
		F9907OutObject f9907OutObject = new F9907OutObject();
		f9907OutObject.setTblSysOptval(tblSysOptval);
		PageDataUtils.saveData2Request(request, "f9907OutObject", f9907OutObject);
		
		return "pages/f9907-j-5";
	}
	
	/**
	 * 删除
	 * @param f9907InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9907-s-6")
	public String delete(F9907InObject f9907InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-delete------------------------");
		
		// 删除及批量删除
		List<String> mids = f9907InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要删除的选项框代码为空.");
		}
		for(int i=0; i< mids.size(); i++) {
			String mid = mids.get(i);
			sysOptValueService.deleteSysOptByid(mid);
		}
		return "forward:f9907-s-2.do";
	}
	
	/**
	 * 跳转编辑页面
	 * @param f9907InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9907-s-7")
	public String gotoEditPage(F9907InObject f9907InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-gotoEditPage------------------------");
		
		//准备数据 
		List<String> mids = f9907InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要查询的选项框代码为空.");
		}
		String mid = mids.get(0);
		
		// 查询要编辑记录数据
		TblSysOptval tblSysOptval = sysOptValueService.queryById(mid);
		F9907OutObject f9907OutObject = new F9907OutObject();
		f9907OutObject.setTblSysOptval(tblSysOptval);
		PageDataUtils.saveData2Request(request, "f9907OutObject", f9907OutObject);
		return "pages/f9907-j-7";
	}
	
	/**
	 * 编辑保存
	 * @param f9907InObject
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9907-s-8")
	public void edit(F9907InObject f9907InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-edit------------------------");
		
		F9907OutObject f9907OutObject = new F9907OutObject();
		
		// 准备数据
		TblSysOptval tblSysOptvalNew = new TblSysOptval();
		tblSysOptvalNew = sysOptValueService.queryById(f9907InObject.getOvId().toString());
		try {
			BeanUtils.copyProperties(tblSysOptvalNew, f9907InObject);
		} catch (Exception e) {
			log.error("copyProperties error.");
			e.printStackTrace();
			
			f9907OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9907OutObject, response);
			return;
		}
		
		// 更新记录
		try {
			sysOptValueService.update(tblSysOptvalNew);
		} catch(Exception e) {
			log.error("update error.");
			e.printStackTrace();
			
			f9907OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9907OutObject, response);
			return;
		}
		
		f9907OutObject.setEditSuccess(true);
		super.ajaxOutJson(f9907OutObject, response);
	}

	public SysOptValueService getSysOptValueService() {
		return sysOptValueService;
	}

	public void setSysOptValueService(SysOptValueService sysOptValueService) {
		this.sysOptValueService = sysOptValueService;
	}
	
}
