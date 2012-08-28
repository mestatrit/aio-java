package com.cdpc.aio.web.po;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author evin.liu
 */
public class TblSysUsrinf implements Serializable {

	private java.lang.Long uiId;
	private java.lang.String uiUserId;
	private java.lang.String uiUserPwd;
	private java.lang.String uiLstIpAddress;
	private java.lang.String uiLstUserLoginTime;
	private java.lang.String uiCurLogStats;
	private java.lang.String uiLstModiUserId;
	private java.lang.String uiLstModiDate;

	public TblSysUsrinf() {
	}

	public TblSysUsrinf(java.lang.Long uiId) {
		this.uiId = uiId;
	}

	public void setUiId(java.lang.Long value) {
		this.uiId = value;
	}

	public java.lang.Long getUiId() {
		return this.uiId;
	}

	public java.lang.String getUiUserId() {
		return this.uiUserId;
	}

	public void setUiUserId(java.lang.String value) {
		this.uiUserId = value;
	}

	public java.lang.String getUiUserPwd() {
		return this.uiUserPwd;
	}

	public void setUiUserPwd(java.lang.String value) {
		this.uiUserPwd = value;
	}

	public java.lang.String getUiLstIpAddress() {
		return this.uiLstIpAddress;
	}

	public void setUiLstIpAddress(java.lang.String value) {
		this.uiLstIpAddress = value;
	}


	public java.lang.String getUiLstUserLoginTime() {
		return uiLstUserLoginTime;
	}

	public void setUiLstUserLoginTime(java.lang.String uiLstUserLoginTime) {
		this.uiLstUserLoginTime = uiLstUserLoginTime;
	}

	public java.lang.String getUiCurLogStats() {
		return this.uiCurLogStats;
	}

	public void setUiCurLogStats(java.lang.String value) {
		this.uiCurLogStats = value;
	}

	public java.lang.String getUiLstModiUserId() {
		return this.uiLstModiUserId;
	}

	public void setUiLstModiUserId(java.lang.String value) {
		this.uiLstModiUserId = value;
	}

	public java.lang.String getUiLstModiDate() {
		return uiLstModiDate;
	}

	public void setUiLstModiDate(java.lang.String uiLstModiDate) {
		this.uiLstModiDate = uiLstModiDate;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("UiId", getUiId()).append("UiUserId", getUiUserId()).append("UiUserPwd", getUiUserPwd()).append("UiLstIpAddress", getUiLstIpAddress()).append("UiLstUserLoginTime", getUiLstUserLoginTime()).append("UiCurLogStats", getUiCurLogStats()).append("UiLstModiUserId", getUiLstModiUserId()).append("UiLstModiDate", getUiLstModiDate()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getUiId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TblSysUsrinf == false)
			return false;
		if (this == obj)
			return true;
		TblSysUsrinf other = (TblSysUsrinf) obj;
		return new EqualsBuilder().append(getUiId(), other.getUiId()).isEquals();
	}
}
