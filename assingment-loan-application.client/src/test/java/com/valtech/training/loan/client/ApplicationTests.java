package com.valtech.training.loan.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.valtech.training.loan.webservices.LoanServiceWS;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

	@Autowired
    private LoanServiceWS loanServiceWS;

	@Test
    void testApplyLoanSuccess() {
        // Test applying for a loan with valid parameters
        String response = loanServiceWS.applyLoan(
            "Sarthak", 
            "jsdbckjb", 
            "Gift city", 
            790, 
            75000, 
            100000
        );
        
        assertNotNull(response, "Response should not be null");
//     
//        System.out.println("Apply Loan Success Response: " + response);
    }
//
//    @Test
//    void testApplyLoanInvalidCibil() {
//        // Test applying for a loan with a low CIBIL score
//        String response = loanServiceWS.applyLoan(
//            "Badal", 
//            "qshgdlug", 
//            "gift city", 
//            600, 
//            50000, 
//            80000
//        );
//
//        assertNotNull(response, "Response should not be null");
//        
//        System.out.println("Apply Loan Failure Response (Low CIBIL): " + response);
//    }
//
//    @Test
//    void testProcessLoanApproved() {
//       
//        String response = loanService.processLoan(1L); 
//        assertNotNull(response, "Response should not be null");
//        
//        System.out.println("Process Loan Approved Response: " + response);
//    }
//

     

}
