package com.project.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Customer;

public interface CustomerService {

	public String insertCustomer(Customer customer);
	public List<Customer> getCustomerList();
	public Customer getCustomerById(int id) ;
	public String updateCustomer(Customer customer);
	public String deleteCustomer(int id);
	public String insertCustomerlist(List<Customer> customerlist);
	public List<Customer> getByFirstname(String firstn_ame);
	public List<Customer> getByLastname(String last_name);
	public List<Customer> getByAge(int age);
	public List<Customer> getByLessthanAge(int age);
	public List<Customer> getByMorethanAge(int age,String last_name);
}
