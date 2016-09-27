package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.VehicleModel;

/**
 * <p>
 * Loan service class which has methods for adding, retrieve loan details.
 * It contain all the business logic operation of loan class.
 * </p> 
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
public interface LoanService extends GenericManager<Loan, Long> {
    
    /**
     * Call loan dao for add new loan detail.
     * 
     * @param loan
     *     Get loan object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    void addLoan(Loan loan) throws DatabaseException;
    
    /**
     * Call loan detail dao for remove loan detail.
     * 
     * @param loanId
     *     Get loan id from controller.
     * @return
     *    It return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.     
     */
    String removeLoan(int loanId) throws DatabaseException;
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id from controller.
     * @return
     *    It return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
    Loan retrieveLoan(int loanId) throws DatabaseException;
    
    /**
     * Retrieve all the loan from database to controller method.
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
    List<Loan> retrieveLoansByUserId(int userId) throws DatabaseException;
    
    /**
     * Retrieve all the loan from database to controller method.
     * 
     * @return
     *     It return list of object to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
    public List<Loan> retreiveAllLoans() throws DatabaseException;
    
    /**
     * Check whether the loan detail exist or not.
     * 
     * @param loanId
     *     Get the loan id from controller.
     * @return
     *     It return true or false to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    boolean isLoanExist(int loanId) throws DatabaseException;
    
    /**
     * Check whether any loan are avaliable for that specific eligibility detail id.
     * 
     * @param eligibilityDetailId
     *     Get the loan id from eligibility detail service.
     * @return
     *     It return true or false to eligibility detail service.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    boolean isLoanExistByEligibilityDetailId(int eligibilityDetailId) throws DatabaseException;
    /**
     * Here calculate the loan amount user want from the down payment.
     * 
     * @param eligibilityDetail
     *     Get the eligibility object from controller.
     * @param vehicleModel
     *     Get the vehicle model object from controller.
     * @return
     *     It return the value to controller.
     */
    int calculateLoanAmount(EligibilityDetail eligibilityDetail,VehicleModel vehicleModel);
    
    /**
     * Here calculate the emi amount based on user selected emi period.
     * 
     * @param loanPeriod
     *     Get the loan period from cotroller.
     * @param loanAmount
     *     Get the loan amount from cotroller.
     * @return
     *     It return the value to controller.
     */
    float getEmiDetails(int loanPeriod, int loanAmount);
    
    /**
     * Here calculate the processing fees amount based on user selected emi period.
     * 
     * @param loanPeriod
     *     Get the loan period from cotroller.
     * @param loanAmount
     *     Get the loan amount from cotroller.
     * @return
     *     It return the value to controller.
     */
    float getProcessingFees(int loanPeriod, int loanAmount);
    
    /**
     * Here calculate the documentation charge amount based on user selected emi period.
     * 
     * @param loanPeriod
     *     Get the loan period from cotroller.
     * @param loanAmount
     *     Get the loan amount from cotroller.
     * @return
     *     It return the value to controller.
     */
    float getDocumentationCharges(int loanPeriod, int loanAmount); 
}
