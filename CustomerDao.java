package com.project.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Customer;


@Repository
public class CustomerDao {
	@Autowired
	SessionFactory sf;

	public CustomerDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}
//	--------------------------------------------------------------------
	public String insertCustomer(Customer customer) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
//		insert ,update,delete -> you need to use Transaction
		session.save(customer);  // insert the customer data in database
		tr.commit();
		session.close();
		return "Customer inserted sucessfully"; 
	}
//	--------------------------------------------------------------------
	public List<Customer> getCustomerList() {
		Session session=sf.openSession();
		List<Customer> list=session.createQuery("from Customer").list();
		return list;
		
	}
//	--------------------------------------------------------------------
	public Customer getCustomerById(int id) {
//		get->it will return null ifobject not found in db
//		load->it will retirn objectNotfoundException if object not found in db
		Session session=sf.openSession();
//		Customer customer=session.load(Customer.class,id);
		Customer customer = session.load(Customer.class, id);
		return customer;
	}
	
	public String updateCustomer(Customer customer) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(customer);
		tr.commit();
		return "Custommer updated Successfully";
	}
	
	public String deleteCustomer(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
//		Customer customer=getCustomerById(id);
		Customer customer=session.get(Customer.class, id);
		session.delete(customer);
		tr.commit();
		return "Customer deleted Successfully";
	}

	public String insertCustomerlist(List<Customer> customerlist) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
//		insert ,update,delete -> you need to use Transaction
		for(Customer customer:customerlist) {
			session.save(customer);  // insert the customer data in database
		}
		tr.commit();
		session.close();
		return "List of Customer inserted sucessfully"; 
	}
	
	public List<Customer> getByFirstname(String firstn_ame){
		Session session=sf.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.firstn_ame =:firstn_ame",Customer.class);
		customers.setParameter("firstn_ame",firstn_ame);
		List<Customer> list=customers.list();
		return list;
	}
	
	public List<Customer> getByLastname(String last_name){
		Session session=sf.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.last_name =:last_name",Customer.class);
		customers.setParameter("last_name",last_name);
		List<Customer> list=customers.list();
		return list;
	}
	
	public List<Customer> getByAge(int age){
		Session session=sf.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.age =:age",Customer.class);
		customers.setParameter("age",age);
		List<Customer> list=customers.list();
		return list;
	}
	
	public List<Customer> getByLessthanAge(int age){
		Session session=sf.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.age <:age",Customer.class);
		customers.setParameter("age",age);
		List<Customer> list=customers.list();
		return list;
	}
	
	public List<Customer> getByMorethanAge(int age,String last_name){
		Session session=sf.openSession();
		Query<Customer> customers=session.createQuery("from Customer c where c.age >:age & c.last_name=last_name",Customer.class);
		customers.setParameter("age",age);
		List<Customer> list=customers.list();
		return list;
	}
	
}
