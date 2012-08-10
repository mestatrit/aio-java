package com.cdpc.aio.ams.web.vo;

import com.cdpc.aio.ams.web.po.TblSysUsrinf;

public class F9906OutObject {

	// 保存成功标记
	private boolean saveSuccess = false;
	// 编辑成功标记
	private boolean editSuccess = false;
	// 错误消息
	private String errorMessage = null;

	private TblSysUsrinf tblSysUsrinf = null;
	
	private String userRole = null;

	public boolean isSaveSuccess() {
		return saveSuccess;
	}

	public void setSaveSuccess(boolean saveSuccess) {
		this.saveSuccess = saveSuccess;
	}

	public boolean isEditSuccess() {
		return editSuccess;
	}

	public void setEditSuccess(boolean editSuccess) {
		this.editSuccess = editSuccess;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public TblSysUsrinf getTblSysUsrinf() {
		return tblSysUsrinf;
	}

	public void setTblSysUsrinf(TblSysUsrinf tblSysUsrinf) {
		this.tblSysUsrinf = tblSysUsrinf;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
