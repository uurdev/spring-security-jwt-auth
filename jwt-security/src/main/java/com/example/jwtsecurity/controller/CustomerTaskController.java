package com.example.jwtsecurity.controller;

import com.example.jwtsecurity.model.Customer;
import com.example.jwtsecurity.model.CustomerTask;
import com.example.jwtsecurity.repository.CustomerTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerTaskController {

    @Autowired
    private CustomerTaskRepository customerTaskRepository;


    @RequestMapping(value = "/new/task", method = RequestMethod.POST)
    public void createNewTask(@RequestBody CustomerTask customerTask) {
        customerTaskRepository.save(customerTask);
    }

    @GetMapping(value = "/get/all")
    public List<CustomerTask> getAllCustomerTask() {
        return customerTaskRepository.findAll();
    }
}
