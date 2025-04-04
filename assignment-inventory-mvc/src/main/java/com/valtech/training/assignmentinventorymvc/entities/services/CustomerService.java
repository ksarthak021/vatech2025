package com.valtech.training.assignmentinventorymvc.entities.services;

import java.util.List;

import com.valtech.training.assignmentinventorymvc.vos.CustomerVO;

public interface CustomerService {
	 
	CustomerVO saveCustomer(CustomerVO cvo);
	 
	CustomerVO updateCustomer(int id, CustomerVO cvo);
	 
	CustomerVO getCustomer(int id);
	 
	List<CustomerVO> getAllCustomer();
 
}
