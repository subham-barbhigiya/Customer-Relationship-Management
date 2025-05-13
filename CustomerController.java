package com.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Customer;
import com.project.service.CustomerService;
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	CustomerService custiomerService;
	public CustomerController(CustomerService custiomerService) {
		super();
		this.custiomerService = custiomerService;
	}
//	--------1-----INSERT CUSTOMER RESTAPI----------------------------------------
	
	@PostMapping("/insert")
	public String insertCustomer(@RequestBody Customer customer) {
		String msg=custiomerService.insertCustomer(customer);
		return msg;
	}
//	---------2-----GET ALL CUSTOMER RESTAPI------------------------------------
	@GetMapping("/getcustomer")
	public List<Customer> getCustomerList(){
		List<Customer> list=custiomerService.getCustomerList();
		return list;
	}
//	---------3-----GET CUSTOMER BY ID RESTAPI-------------------------------------
	@GetMapping("/id/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Customer customer=custiomerService.getCustomerById(id);
		return customer;
	}
	
//	--------4------UPDATE CUSTOMER RESTAPI---------------------------------------
	@PutMapping("/updatecustomer")
	public String updateCustomer(@RequestBody Customer customer) {
		return custiomerService.updateCustomer(customer);
	}
//	---------5-----DELETE CUSTOMER BY ID RESTAPI-----------------------------------
	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return custiomerService.deleteCustomer(id);
	}
//	---------6-----INSERT MULTIPLE CUSTOMER RESTAPI--------------------------------
	@PostMapping("/insertcustomerlist")
	public String insertCustomelist(@RequestBody List<Customer> customerlist) {
		String msg=custiomerService.insertCustomerlist(customerlist);
		return msg;
	}
//	---------7-----CUSTOMER GET BY FIRSTNAME---------------------------------------
	@GetMapping("/firstname/{firstn_ame}")
	public List<Customer> getByFirstname(@PathVariable String firstn_ame){
		return custiomerService.getByFirstname(firstn_ame);
		
	}
//	---------8-----CUSTOMER GET BY LASTNAME---------------------------------------
	@GetMapping("/lastname/{last_name}")
	public List<Customer> getByLastname(@PathVariable String last_name){
		return custiomerService.getByLastname(last_name);
		
	}
//	----------9-----CUSTOMER GET BY AGE-------------------------------------------
	@GetMapping("/age/{age}")
	public List<Customer> getByAge(@PathVariable int age){
		return custiomerService.getByAge(age);
	}
//	-----------10-----CUSTOMER GET BY AGE ACCORDING TO LESSTHAN CONDITION-----------
	@GetMapping("/lessthanage/{age}")
	public List<Customer> getByLessthanAge(@PathVariable int age){
		return custiomerService.getByLessthanAge(age);
	}
//	-----------11------CUSTOMER GET BY AGE ACCORDING TO MORE THAN CONDITION----------
	
	@GetMapping("/morethanage/{age}/{last_name}")
	public List<Customer> getByMorethanAge(@PathVariable int age,@PathVariable String last_name){
		return custiomerService.getByMorethanAge(age,last_name);
	}
}



