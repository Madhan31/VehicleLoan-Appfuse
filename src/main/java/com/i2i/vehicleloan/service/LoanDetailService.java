package com.i2i.vehicleloan.service;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.LoanDetail;

/**
 * <p>
 * Loan detail service class which has methods for adding, retrieve loan detail details.
 * It contain all the business logic operation of loan detail class.
 * </p> 
 * 
 *  @author vicky
 *
 * @since 2016-09-06
 */
@WebService
@Path("/loanDetails")
public interface LoanDetailService {
    
    /**
     * Call loan detail dao for add new loan detail.
     * 
     * @param loanDetail
     *     Get loan detail object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.     
     */
    void addLoanDetail(LoanDetail loanDetail) throws DatabaseException;
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id form controller for retrieve particular loan detail.
     * @return
     *     Return the object of retrieve exist loan detail to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    LoanDetail retrieveLatestLoanDetail() throws DatabaseException;
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id form controller for retrieve particular loan detail.
     * @return
     *     Return the object of retrieve exist loan detail to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    public LoanDetail retrieveLoanDetailByLoanId(int loanId) throws DatabaseException;
    
    /**
     * Retrieve all the loan details from database to controller method.
     *   
     * @param userId
     *     Get the userId from controller.
     * @return
     *     It return list of object to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    public LoanDetail retrieveLoanDetailByUserId(int userId)throws DatabaseException;
}
