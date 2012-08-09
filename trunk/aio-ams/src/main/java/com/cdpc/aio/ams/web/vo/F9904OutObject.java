package com.cdpc.aio.ams.web.vo;

import com.cdpc.aio.ams.web.po.TblSysSysfun;


public class F9904OutObject {

	// 保存成功标记
	private boolean saveSuccess = false;
	// 编辑成功标记
	private boolean editSuccess = false;
	// 错误消息
	private String errorMessage = null;

	private TblSysSysfun tblSysSysfun = null;

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

	public TblSysSysfun getTblSysSysfun() {
		return tblSysSysfun;
	}

	public void setTblSysSysfun(TblSysSysfun tblSysSysfun) {
		this.tblSysSysfun = tblSysSysfun;
	}

}
