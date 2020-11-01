package com.example.jwtsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTaskId;

    private String taskDetail;

    public Long getCustomerTaskId() {
        return customerTaskId;
    }

    public void setCustomerTaskId(Long customerTaskId) {
        this.customerTaskId = customerTaskId;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }
}
