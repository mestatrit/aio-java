package com.cdpc.aio.ams.web.vo;

import com.cdpc.aio.ams.web.po.TblSysBulletin;

public class F9908OutObject {
	// 保存成功标记
	private boolean saveSuccess = false;
	// 编辑成功标记
	private boolean editSuccess = false;
	// 错误消息
	private String errorMessage = null;
	
	private TblSysBulletin tblSysBulletin = null;

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

	public TblSysBulletin getTblSysBulletin() {
		return tblSysBulletin;
	}

	public void setTblSysBulletin(TblSysBulletin tblSysBulletin) {
		this.tblSysBulletin = tblSysBulletin;
	}
}
