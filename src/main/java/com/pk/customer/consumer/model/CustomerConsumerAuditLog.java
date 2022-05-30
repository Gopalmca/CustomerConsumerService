package com.pk.customer.consumer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "CONSUMER_CUST_AUDIT")
@EntityListeners(AuditingEntityListener.class)
public class CustomerConsumerAuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer consumerCustAuditId;

	private String customerId;

	 @Column(columnDefinition = "TEXT")
	private String customerPayload;

	@CreatedDate
	private Date createDate;
	@LastModifiedDate
	private Date lastModifiedDate;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String modifiedBy;

	public Integer getConsumerCustAuditId() {
		return consumerCustAuditId;
	}

	public void setConsumerCustAuditId(Integer consumerCustAuditId) {
		this.consumerCustAuditId = consumerCustAuditId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPayload() {
		return customerPayload;
	}

	public void setCustomerPayload(String customerPayload) {
		this.customerPayload = customerPayload;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
