package com.cdpc.aio.ams.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
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
import com.cdpc.aio.ams.web.dao.TblSysBulletinCriterions;
import com.cdpc.aio.ams.web.dao.TblSysBulletinOrders;
import com.cdpc.aio.ams.web.po.TblSysBulletin;
import com.cdpc.aio.ams.web.service.SysBulletinService;
import com.cdpc.aio.ams.web.vo.F9908InObject;
import com.cdpc.aio.ams.web.vo.F9908OutObject;

/**
 * 
 * 功能代码：9908 
 * 功能名称：系统公告信息管理
 * 
 * @author evin.liu
 * 
 */
@Controller
public class F9908Controller extends BaseController {

	private static Logger log = LoggerFactory.getLogger(F9908Controller.class);

	@Autowired
	private SysBulletinService sysBulletinService;

	@RequestMapping("/f9908.do")
	public String gotoSearchPage(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9907Controller------------------------");
		log.debug("-----------------Method-gotoSearchPage------------------------");

		// 跳转到系统公告首页
		return "redirect:/f9908-s-1.do";
	}
	
	/**
	 * 首次分页查询
	 */
	@RequestMapping("/f9908-s-1")
	public String pageSearchFirst(F9908InObject f9908InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9908Controller------------------------");
		log.debug("-----------------Method-pageSearchFirst------------------------");
		
		// 组装查询条件
		TblSysBulletinCriterions tblSysBulletinCriterions = new TblSysBulletinCriterions();
		if(StringUtils.isNotEmpty(f9908InObject.getBtTitle())) { 
			tblSysBulletinCriterions.btTitleEq(f9908InObject.getBtTitle());
		}
		
		// 组装排序条件
		TblSysBulletinOrders tblSysBulletinOrders = new TblSysBulletinOrders();
		tblSysBulletinOrders.btCreateDateDesc();
		
		// 组装PageQuery
		PageQuery<TblSysBulletin> pageQuery = new PageQuery<TblSysBulletin>();
		pageQuery.setCriterionList(tblSysBulletinCriterions.list());
		pageQuery.setOrderList(tblSysBulletinOrders.list());
		
		pageQuery = sysBulletinService.pageQuery(pageQuery);
		
		PageUtils<TblSysBulletin> pageUtils = new PageUtils<TblSysBulletin>();
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9908-j-0";
	}
	
	/**
	 * 后续分页查询
	 */
	@RequestMapping("/f9908-s-2")
	public String pageSearchSecond(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9908Controller------------------------");
		log.debug("-----------------Method-pageSearchSecond------------------------");
		
		PageUtils<TblSysBulletin> pageUtils = new PageUtils<TblSysBulletin>();
		PageQuery<TblSysBulletin> pageQuery = pageUtils.getPageQuery(request);
		pageQuery = sysBulletinService.pageQuery(pageQuery);
		pageUtils.setPageQuery(request, pageQuery);
		
		return "pages/f9908-j-0";
	}
	
	@RequestMapping("/f9908-s-3")
	public String gotoInsertPage(HttpServletRequest request, HttpServletResponse response) throws AppException{
		log.debug("-----------------Controller-F9908Controller------------------------");
		log.debug("-----------------Method-gotoInsertPage------------------------");
		
		// 跳转到新增页面
		return "pages/f9908-j-3";
	}
	
	/**
	 * 新增系统公告
	 */
	@RequestMapping("/f9908-s-4")
	public void insert(F9908InObject f9908InObject,HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9908Controller------------------------");
		log.debug("-----------------Method-insert------------------------");
		
		F9908OutObject f9908OutObject = new F9908OutObject();
		
		// 准备数据
		TblSysBulletin tblSysBulletin = new TblSysBulletin();
		try {
			BeanUtils.copyProperties(tblSysBulletin, f9908InObject);
		} catch (Exception e) {
			log.error("复制属性出错");
			e.printStackTrace();
			
			f9908OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9908OutObject, response);
			return;
		}
		
		tblSysBulletin.setBtCreateDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		tblSysBulletin.setBtLstModiDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		tblSysBulletin.setBtLstModiUserId(SystemUtils.getCurrentUserId(request));
		
		// 保存
		try {
			sysBulletinService.save(tblSysBulletin);
		} catch(Exception e) {
			log.error("保存出错");
			e.printStackTrace();
			
			f9908OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9908OutObject, response);
			return;
		}
		
		f9908OutObject.setSaveSuccess(true);
		super.ajaxOutJson(f9908OutObject, response);
	}
	
	/**
	 * 查看详细信息
	 */
	@RequestMapping("/f9908-s-5")
	public String viewDetail(F9908InObject f9908InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9908Controller------------------------");
		log.debug("-----------------Method-viewDetail------------------------");
		
		// 检查数据
		List<String> mids = f9908InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要查询的系统公告ID为空.");
		}
		String mid = mids.get(0);
		if(StringUtils.isEmpty(mid)) {
			throw new AppException("要查询的系统公告ID为空.");
		}
		
		// 准备要查看的数据
		TblSysBulletin tblSysBulletin = sysBulletinService.queryById(mid);
		F9908OutObject f9908OutObject = new F9908OutObject();
		f9908OutObject.setTblSysBulletin(tblSysBulletin);
		PageDataUtils.saveData2Request(request, "f9908OutObject", f9908OutObject);
		
		return "pages/f9908-j-5";
	}
	
	@RequestMapping("/f9908-s-6")
	public String delete(F9908InObject f9908InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9908Controller------------------------");
		log.debug("-----------------Method-delete------------------------");
		
		// 删除及批量删除
		List<String> mids = f9908InObject.getMid();
		if(mids == null || mids.size() == 0) {
			throw new AppException("要删除的选项框代码为空.");
		}
		for(int i=0; i< mids.size(); i++) {
			String mid = mids.get(i);
			sysBulletinService.deleteSysBulletinByid(mid);
		}
		return "forward:f9908-s-2.do";
	}

	public SysBulletinService getSysBulletinService() {
		return sysBulletinService;
	}

	public void setSysBulletinService(SysBulletinService sysBulletinService) {
		this.sysBulletinService = sysBulletinService;
	}

}
