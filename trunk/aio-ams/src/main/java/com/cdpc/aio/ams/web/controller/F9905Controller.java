package com.cdpc.aio.ams.web.controller;

import java.util.ArrayList;
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
import com.cdpc.aio.ams.web.dao.TblSysSysrolCriterions;
import com.cdpc.aio.ams.web.dao.TblSysSysrolOrders;
import com.cdpc.aio.ams.web.po.TblSysRolfun;
import com.cdpc.aio.ams.web.po.TblSysSysrol;
import com.cdpc.aio.ams.web.service.SysRoleService;
import com.cdpc.aio.ams.web.vo.F9905InObject;
import com.cdpc.aio.ams.web.vo.F9905OutObject;

/**
 * 
 * 功能代码：9905
 * 功能名称：系统角色管理
 * 
 * @author evin.liu
 *
 */
@Controller
public class F9905Controller extends BaseController {

	private static Logger log = LoggerFactory.getLogger(F9905Controller.class);

	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping("/f9905.do")
	public String gotoSearchPage(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-gotoSearchPage------------------------");

		// 跳转到系统角色首页
		return "redirect:/f9905-s-1.do";
	}

	/**
	 * 首次分页查询
	 */
	@RequestMapping("/f9905-s-1")
	public String pageSearchFirst(F9905InObject f9905InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-pageSearchFirst------------------------");

		// 组装查询条件
		TblSysSysrolCriterions tblSysSysrolCriterions = new TblSysSysrolCriterions();
		if (StringUtils.isNotEmpty(f9905InObject.getSrRoleId())) {
			tblSysSysrolCriterions.srRoleIdEq(f9905InObject.getSrRoleId());
		}
		if (StringUtils.isNotEmpty(f9905InObject.getSrRoleName())) {
			tblSysSysrolCriterions.srRoleNameEq(f9905InObject.getSrRoleName());
		}
		// 组装排序条件
		TblSysSysrolOrders tblSysSysrolOrders = new TblSysSysrolOrders();
		tblSysSysrolOrders.srRoleIdAsc();

		// 组装PageQuery
		PageQuery<TblSysSysrol> pageQuery = new PageQuery<TblSysSysrol>();
		pageQuery.setCriterionList(tblSysSysrolCriterions.list());
		pageQuery.setOrderList(tblSysSysrolOrders.list());

		pageQuery = sysRoleService.pageQuery(pageQuery);

		PageUtils<TblSysSysrol> pageUtils = new PageUtils<TblSysSysrol>();
		pageUtils.setPageQuery(request, pageQuery);

		return "pages/f9905-j-0";
	}

	/**
	 * 后续分页查询
	 */
	@RequestMapping("/f9905-s-2")
	public String pageSearchSecond(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-pageSearchSecond------------------------");

		PageUtils<TblSysSysrol> pageUtils = new PageUtils<TblSysSysrol>();
		PageQuery<TblSysSysrol> pageQuery = pageUtils.getPageQuery(request);
		pageQuery = sysRoleService.pageQuery(pageQuery);
		pageUtils.setPageQuery(request, pageQuery);

		return "pages/f9905-j-0";
	}

	@RequestMapping("/f9905-s-3")
	public String gotoInsertPage(HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-gotoInsertPage------------------------");

		// 跳转到新增页面
		return "pages/f9905-j-3";
	}

	/**
	 * 新增系统角色
	 * 
	 * @param f9905InObject
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9905-s-4")
	public void insert(F9905InObject f9905InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-insert------------------------");

		F9905OutObject f9905OutObject = new F9905OutObject();

		// 验证roleid是否已经重复
		String roleid = f9905InObject.getSrRoleId();
		try {
			if (sysRoleService.isRoleExists(roleid)) {
				f9905OutObject.setErrorMessage("您要新增的角色已经存在.");
				super.ajaxOutJson(f9905OutObject, response);
				return;
			}
		} catch (Exception e) {
			log.error("系统出错");
			e.printStackTrace();

			f9905OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9905OutObject, response);
			return;
		}

		// 准备数据
		TblSysSysrol tblSysSysrol = new TblSysSysrol();
		try {
			BeanUtils.copyProperties(tblSysSysrol, f9905InObject);
		} catch (Exception e) {
			log.error("复制属性出错");
			e.printStackTrace();

			f9905OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9905OutObject, response);
			return;
		}

		tblSysSysrol.setSrLstModiUserId(SystemUtils.getCurrentUserId(request));
		tblSysSysrol.setSrLstModiDate(new Date());

		// 整理权限
		List<TblSysRolfun> rolefuns = new ArrayList<TblSysRolfun>();
		List<String> checkedRights = f9905InObject.getCheckedRights();
		if(checkedRights != null) {
			for (int i = 0; i < checkedRights.size(); i++) {
				String funid = checkedRights.get(i);
				TblSysRolfun t = new TblSysRolfun();
				t.setRfRoleId(f9905InObject.getSrRoleId());
				t.setRfFunctionId(funid);
				rolefuns.add(t);
			}
		}

		// 保存
		try {
			sysRoleService.save(tblSysSysrol, rolefuns);
		} catch (Exception e) {
			log.error("保存出错");
			e.printStackTrace();

			f9905OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9905OutObject, response);
			return;
		}

		f9905OutObject.setSaveSuccess(true);
		super.ajaxOutJson(f9905OutObject, response);
	}

	/**
	 * 查看详细信息
	 * 
	 * @param f9905InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9905-s-5")
	public String viewDetail(F9905InObject f9905InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-f9905Controller------------------------");
		log.debug("-----------------Method-viewDetail------------------------");

		// 检查数据
		List<String> mids = f9905InObject.getMid();
		if (mids == null || mids.size() == 0) {
			throw new AppException("要查询的系统角色ID为空.");
		}
		String mid = mids.get(0);
		if (StringUtils.isEmpty(mid)) {
			throw new AppException("要查询的系统角色ID为空.");
		}

		// 准备要查看的数据
		TblSysSysrol tblSysSysrol = sysRoleService.queryById(mid);
		F9905OutObject f9905OutObject = new F9905OutObject();
		f9905OutObject.setTblSysSysrol(tblSysSysrol);
		PageDataUtils.saveData2Request(request, "f9905OutObject", f9905OutObject);

		return "pages/f9905-j-5";
	}

	/**
	 * 删除
	 * 
	 * @param f9905InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9905-s-6")
	public String delete(F9905InObject f9905InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-delete------------------------");

		// 删除及批量删除
		List<String> mids = f9905InObject.getMid();
		if (mids == null || mids.size() == 0) {
			throw new AppException("要删除的系统角色ID为空.");
		}
		for (int i = 0; i < mids.size(); i++) {
			String mid = mids.get(i);
			sysRoleService.deleteSysRoleByid(mid);
		}
		return "forward:f9905-s-2.do";
	}

	/**
	 * 跳转编辑页面
	 * 
	 * @param f9905InObject
	 * @param request
	 * @param response
	 * @return
	 * @throws AppException
	 */
	@RequestMapping("/f9905-s-7")
	public String gotoEditPage(F9905InObject f9905InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9905Controller------------------------");
		log.debug("-----------------Method-gotoEditPage------------------------");

		// 准备数据
		List<String> mids = f9905InObject.getMid();
		if (mids == null || mids.size() == 0) {
			throw new AppException("要查询的系统角色ID为空.");
		}
		String mid = mids.get(0);

		// 查询要编辑记录数据
		TblSysSysrol tblSysSysrol = sysRoleService.queryById(mid);
		F9905OutObject f9905OutObject = new F9905OutObject();
		f9905OutObject.setTblSysSysrol(tblSysSysrol);
		PageDataUtils.saveData2Request(request, "f9905OutObject", f9905OutObject);
		return "pages/f9905-j-7";
	}

	/**
	 * 编辑保存
	 * 
	 * @param f9905InObject
	 * @param request
	 * @param response
	 * @throws AppException
	 */
	@RequestMapping("/f9905-s-8")
	public void edit(F9905InObject f9905InObject, HttpServletRequest request, HttpServletResponse response) throws AppException {
		log.debug("-----------------Controller-F9904Controller------------------------");
		log.debug("-----------------Method-edit------------------------");

		F9905OutObject f9905OutObject = new F9905OutObject();

		// 准备数据
		TblSysSysrol tblSysSysrolNew = new TblSysSysrol();
		tblSysSysrolNew = sysRoleService.queryById(f9905InObject.getSrId().toString());
		try {
			BeanUtils.copyProperties(tblSysSysrolNew, f9905InObject);
		} catch (Exception e) {
			log.error("copyProperties error.");
			e.printStackTrace();

			f9905OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9905OutObject, response);
			return;
		}

		tblSysSysrolNew.setSrLstModiUserId(SystemUtils.getCurrentUserId(request));
		tblSysSysrolNew.setSrLstModiDate(new Date());

		// 整理权限
		List<TblSysRolfun> rolefuns = new ArrayList<TblSysRolfun>();
		List<String> checkedRights = f9905InObject.getCheckedRights();
		if(checkedRights != null) {
			for (int i = 0; i < checkedRights.size(); i++) {
				String funid = checkedRights.get(i);
				TblSysRolfun t = new TblSysRolfun();
				t.setRfRoleId(f9905InObject.getSrRoleId());
				t.setRfFunctionId(funid);
				rolefuns.add(t);
			}
		}

		// 更新记录
		try {
			sysRoleService.update(tblSysSysrolNew, rolefuns);
		} catch (Exception e) {
			log.error("update error.");
			e.printStackTrace();

			f9905OutObject.setErrorMessage(e.getMessage());
			super.ajaxOutJson(f9905OutObject, response);
			return;
		}

		f9905OutObject.setEditSuccess(true);
		super.ajaxOutJson(f9905OutObject, response);
	}

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
}
