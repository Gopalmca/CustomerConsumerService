package com.pk.customer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.customer.consumer.model.CustomerConsumerAuditLog;

@Repository("consumerCustRepository")
public interface CustomerConsumerServiceRepository extends JpaRepository<CustomerConsumerAuditLog, Long> {

}
