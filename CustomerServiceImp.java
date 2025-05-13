package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dao.CustomerDao;
import com.project.entity.Customer;
@Service
public class CustomerServiceImp implements CustomerService {
	
	CustomerDao customerDao;
	public CustomerServiceImp(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	
	@Override
	public String insertCustomer(Customer customer) {
		return customerDao.insertCustomer(customer);
	}


	@Override
	public List<Customer> getCustomerList() {
		List<Customer> list=customerDao.getCustomerList();
		return list;
	}


	@Override
	public Customer getCustomerById(int id) {
		Customer customer= customerDao.getCustomerById(id);
		return customer;
	}


	@Override
	public String updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}


	@Override
	public String deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}
	
	@Override
	public String insertCustomerlist(List<Customer> customerlist) {
		return customerDao.insertCustomerlist(customerlist);
	}


	@Override
	public List<Customer> getByFirstname(String firstn_ame) {
		
		return customerDao.getByFirstname(firstn_ame);
	}
	
	@Override
	public List<Customer> getByLastname(String last_name) {
		
		return customerDao.getByLastname(last_name);
	}
	
	@Override
	public List<Customer> getByAge(int age) {
		
		return customerDao.getByAge(age);
	}
	@Override
	public List<Customer> getByLessthanAge(int age) {
		
		return customerDao.getByLessthanAge(age);
	}
	
	@Override
	public List<Customer> getByMorethanAge(int age,String last_name) {
		
		return customerDao.getByMorethanAge(age,last_name);
	}
	
}
