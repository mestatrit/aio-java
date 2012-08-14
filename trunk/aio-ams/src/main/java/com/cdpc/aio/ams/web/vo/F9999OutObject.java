package com.cdpc.aio.ams.web.vo;

public class F9999OutObject {

	// 编辑成功标记
	private boolean editSuccess = false;
	// 错误消息
	private String errorMessage = null;

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

}
