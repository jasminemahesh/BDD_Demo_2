package com.hcl.bdd.dao;

import java.util.List;

import com.hcl.bdd.domain.Customer;

public interface CustomerDao {

    /**
     * Create Customer
     * 
     * @param customer
     * @return
     */
    public abstract int createCustomer(Customer customer);

    public abstract Customer getCustomerById(int customerId);

    public abstract List<Customer> listCustomers();

}