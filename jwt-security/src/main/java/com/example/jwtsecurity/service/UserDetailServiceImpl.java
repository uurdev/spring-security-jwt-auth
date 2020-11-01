package com.example.jwtsecurity.service;

import com.example.jwtsecurity.model.Customer;
import com.example.jwtsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(s);
        if (customer != null) {
            //customer not have permissions
            return new User(customer.getUsername(), customer.getPassword(), Collections.emptyList());
        } else {
            throw new UsernameNotFoundException("Not found : " + s);
        }
    }
}
