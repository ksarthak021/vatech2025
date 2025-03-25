package com.valtech.training.leave.vos;

import com.valtech.training.leave.entities.LeaveMaster;

public record LeaveMasterVO (long id,int casualLeave,int sickLeave,int otherLeave,long employeeId){
	
	public LeaveMaster to() {
		return new LeaveMaster(id, casualLeave, sickLeave, otherLeave,employeeId);
	}
	
	public static LeaveMasterVO from(LeaveMaster lm) {
		return new LeaveMasterVO(lm.getId(), lm.getCasualLeaves(),
				lm.getSickLeaves(), lm.getOtherLeaves(),lm.getEmployeeId());
	}
	
}
