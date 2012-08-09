package com.cdpc.aio.ams.web.vo;

import java.util.Date;
import java.util.List;

public class F9904InObject {

	private Long sfId;
	private String sfFunctionId;
	private String sfParentId;
	private String sfFunctionName;
	private String sfTargetUrl;
	private String sfBtnUrl;
	private Integer sfSortFlag;
	private String sfDescription;
	private String sfMenuFlag;
	private String sfBtnFlag;
	private String sfExecutbale;
	private String sfLstModiUserId;
	private Date sfLstModiDate;

	private List<String> mid;

	public Long getSfId() {
		return sfId;
	}

	public void setSfId(Long sfId) {
		this.sfId = sfId;
	}

	public String getSfFunctionId() {
		return sfFunctionId;
	}

	public void setSfFunctionId(String sfFunctionId) {
		this.sfFunctionId = sfFunctionId;
	}

	public String getSfParentId() {
		return sfParentId;
	}

	public void setSfParentId(String sfParentId) {
		this.sfParentId = sfParentId;
	}

	public String getSfFunctionName() {
		return sfFunctionName;
	}

	public void setSfFunctionName(String sfFunctionName) {
		this.sfFunctionName = sfFunctionName;
	}

	public String getSfTargetUrl() {
		return sfTargetUrl;
	}

	public void setSfTargetUrl(String sfTargetUrl) {
		this.sfTargetUrl = sfTargetUrl;
	}

	public String getSfBtnUrl() {
		return sfBtnUrl;
	}

	public void setSfBtnUrl(String sfBtnUrl) {
		this.sfBtnUrl = sfBtnUrl;
	}

	public Integer getSfSortFlag() {
		return sfSortFlag;
	}

	public void setSfSortFlag(Integer sfSortFlag) {
		this.sfSortFlag = sfSortFlag;
	}

	public String getSfDescription() {
		return sfDescription;
	}

	public void setSfDescription(String sfDescription) {
		this.sfDescription = sfDescription;
	}

	public String getSfMenuFlag() {
		return sfMenuFlag;
	}

	public void setSfMenuFlag(String sfMenuFlag) {
		this.sfMenuFlag = sfMenuFlag;
	}

	public String getSfBtnFlag() {
		return sfBtnFlag;
	}

	public void setSfBtnFlag(String sfBtnFlag) {
		this.sfBtnFlag = sfBtnFlag;
	}

	public String getSfExecutbale() {
		return sfExecutbale;
	}

	public void setSfExecutbale(String sfExecutbale) {
		this.sfExecutbale = sfExecutbale;
	}

	public String getSfLstModiUserId() {
		return sfLstModiUserId;
	}

	public void setSfLstModiUserId(String sfLstModiUserId) {
		this.sfLstModiUserId = sfLstModiUserId;
	}

	public Date getSfLstModiDate() {
		return sfLstModiDate;
	}

	public void setSfLstModiDate(Date sfLstModiDate) {
		this.sfLstModiDate = sfLstModiDate;
	}

	public List<String> getMid() {
		return mid;
	}

	public void setMid(List<String> mid) {
		this.mid = mid;
	}

}
