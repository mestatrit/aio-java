package com.cdpc.aio.web.po;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author evin.liu
 */
public class TblSysLogrec implements Serializable {

	private java.lang.Long lrId;
	private java.lang.String lrUsername;
	private java.lang.String lrLogindate;
	private java.lang.String lrLoginip;

	public TblSysLogrec() {
	}

	public TblSysLogrec(java.lang.Long lrId) {
		this.lrId = lrId;
	}

	public void setLrId(java.lang.Long value) {
		this.lrId = value;
	}

	public java.lang.Long getLrId() {
		return this.lrId;
	}

	public java.lang.String getLrUsername() {
		return this.lrUsername;
	}

	public void setLrUsername(java.lang.String value) {
		this.lrUsername = value;
	}

	public java.lang.String getLrLogindate() {
		return this.lrLogindate;
	}

	public void setLrLogindate(java.lang.String value) {
		this.lrLogindate = value;
	}

	public java.lang.String getLrLoginip() {
		return this.lrLoginip;
	}

	public void setLrLoginip(java.lang.String value) {
		this.lrLoginip = value;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("LrId", getLrId()).append("LrUsername", getLrUsername()).append("LrLogindate", getLrLogindate()).append("LrLoginip", getLrLoginip()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLrId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TblSysLogrec == false)
			return false;
		if (this == obj)
			return true;
		TblSysLogrec other = (TblSysLogrec) obj;
		return new EqualsBuilder().append(getLrId(), other.getLrId()).isEquals();
	}
}
