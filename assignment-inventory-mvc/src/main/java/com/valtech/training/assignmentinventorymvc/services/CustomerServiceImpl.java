package com.valtech.training.assignmentinventorymvc.entities.services;

import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignmentinventorymvc.entities.Customer;
import com.valtech.training.assignmentinventorymvc.repos.CustomerRepo;
import com.valtech.training.assignmentinventorymvc.vos.CustomerVO;
 

 
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	@Override
	public CustomerVO saveCustomer(CustomerVO cvo) {
		Customer c = customerRepo.save(cvo.to());
		return CustomerVO.from(c);
	}
	@Override
	public CustomerVO updateCustomer(int id,CustomerVO cvo) {
		Customer c = customerRepo.getReferenceById(id);
		cvo.updateTo(id,c);
		return CustomerVO.from(c);
	}
	@Override
	public CustomerVO getCustomer(int id) {
		Customer c = customerRepo.getReferenceById(id);
		return CustomerVO.from(c);
	}
	@Override
	public List<CustomerVO> getAllCustomer(){
		return customerRepo.findAll().stream().map(c -> CustomerVO.from(c)).collect(Collectors.toList());
	}
	}