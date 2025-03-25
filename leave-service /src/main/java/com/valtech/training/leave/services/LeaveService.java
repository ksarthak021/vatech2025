package com.valtech.training.leave.services;

import java.util.List;

import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

public interface LeaveService {

	List<LeaveMasterVO> getAllLeaveMaster();

	LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo);

	LeaveMasterVO getLeaveMaster(long employeeId);

	List<LeaveVO> getAllLeaves();

	LeaveVO getLeaves(long id);

	LeaveVO saveOrUpdateLeave(LeaveVO vo);

	List<LeaveVO> getLeavesByEmployee(long emp);

	LeaveVO update(LeaveVO vo, long id);

	LeaveVO applyLeave(LeaveVO vo);

	LeaveVO approveLeave(ApproveLeaveVO vo);

	EmployeeVO getManager(long employeeId);

}