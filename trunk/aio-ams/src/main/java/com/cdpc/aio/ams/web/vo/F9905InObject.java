package com.cdpc.aio.ams.web.vo;

import java.util.List;

public class F9905InObject {
	
	private java.lang.Long srId;
	private java.lang.String srRoleId;
	private java.lang.String srRoleName;
	private java.lang.String srLstModiUserId;
	private java.util.Date srLstModiDate;
	
	private List<String> mid;
	
	private List<String> checkedRights;

	public java.lang.Long getSrId() {
		return srId;
	}

	public void setSrId(java.lang.Long srId) {
		this.srId = srId;
	}

	public java.lang.String getSrRoleId() {
		return srRoleId;
	}

	public void setSrRoleId(java.lang.String srRoleId) {
		this.srRoleId = srRoleId;
	}

	public java.lang.String getSrRoleName() {
		return srRoleName;
	}

	public void setSrRoleName(java.lang.String srRoleName) {
		this.srRoleName = srRoleName;
	}

	public java.lang.String getSrLstModiUserId() {
		return srLstModiUserId;
	}

	public void setSrLstModiUserId(java.lang.String srLstModiUserId) {
		this.srLstModiUserId = srLstModiUserId;
	}

	public java.util.Date getSrLstModiDate() {
		return srLstModiDate;
	}

	public void setSrLstModiDate(java.util.Date srLstModiDate) {
		this.srLstModiDate = srLstModiDate;
	}

	public List<String> getMid() {
		return mid;
	}

	public void setMid(List<String> mid) {
		this.mid = mid;
	}

	public List<String> getCheckedRights() {
		return checkedRights;
	}

	public void setCheckedRights(List<String> checkedRights) {
		this.checkedRights = checkedRights;
	}
}
