/*
 * @(#)StaffServicesImpl	Jun 10, 2008
 *
 * Copyright 2008 FIRMLINK, All rights reserved.
 * FIRMLINK PROPRIETARY/CONFIDENTIAL. 
 */
package cn.org.pomer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author yulinlin
 * 
 */
@MappedSuperclass
public abstract class BaseEntity implements Comparable, Serializable {

	protected Long id;

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public int hashCode() {
		return super.hashCode();
	}

	public int compareTo(Object obj) {
		int compare = -1;

		if (obj == null)
			compare = -1;
		else if (this == obj)
			compare = 0;
		else if (!(obj instanceof BaseEntity))
			compare = -1;
		else if (!this.getClass().equals(obj.getClass()))
			compare = -1;
		else {
			BaseEntity castObj = (BaseEntity) obj;

			CompareToBuilder builder = new CompareToBuilder();

			builder.append(this.getId(), castObj.getId());

			compare = builder.toComparison();
		}

		return compare;
	}

	public boolean equals(Object obj) {
		boolean isEqual = false;

		if (obj == null) {
			isEqual = false;
		} else if (this == obj) {
			isEqual = true;
		} else if (!(obj instanceof BaseEntity)) {
			isEqual = false;
		} else if (!this.getClass().equals(obj.getClass())) {
			isEqual = false;
		} else {
			BaseEntity castObj = (BaseEntity) obj;

			EqualsBuilder builder = new EqualsBuilder();

			builder.append(this.getId(), castObj.getId());

			isEqual = builder.isEquals();
		}

		return isEqual;
	}
}
