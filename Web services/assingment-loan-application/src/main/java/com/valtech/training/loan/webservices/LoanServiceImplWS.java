package com.valtech.training.loan.webservices;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.loan.entities.Loan;
import com.valtech.training.loan.repos.LoanRepo;
import com.valtech.training.loan.services.LoanService;

@WebService(endpointInterface = "com.valtech.training.loan.webservices.LoanServiceWS", name = "LoanService", portName = "LoanServicePort")
public class LoanServiceImplWS implements LoanServiceWS {

	@Autowired
	private LoanRepo loanRepo;

	private LoanService loanService;

	public LoanServiceImplWS(LoanService loanservice) {
		this.loanService = loanservice;
	}

	@Override
	public String applyLoan(String name, String panCard, String address, int cibilScore, double income,
			double assetValue) {
		Loan loanApplication = new Loan();
		loanApplication.setName(name);
		loanApplication.setPancard(panCard);
		loanApplication.setAddress(address);
		loanApplication.setCibil(cibilScore);
		loanApplication.setIncome(income);
		loanApplication.setAssestValue(assetValue);
		loanApplication.setStatus("Pending");
		loanRepo.save(loanApplication);
		return String.valueOf(loanApplication.getId());

	}

	@Override
	public String processLoan(Long id) {
		Loan loanApplication = loanRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not Found!!!"));
		double approvedAmount = 0;
		if (loanApplication.getCibil() < 600) {
			loanApplication.setStatus("REJECTED!!");
			loanRepo.save(loanApplication);
			return "Low Cibil score";
		} else if (loanApplication.getCibil() < 750) {
			loanApplication.setStatus("REJECTED!!");
			loanRepo.save(loanApplication);
			return "Loan rejected , apply after some time";

		} else if (loanApplication.getCibil() < 900) {
			approvedAmount = 0.75 * loanApplication.getAssestValue();
			loanApplication.setApprovedAmount(approvedAmount);

			loanApplication.setStatus("APPROVED!!");
			loanRepo.save(loanApplication);

		}
		return "Approved Amount " + approvedAmount;
	}

}
