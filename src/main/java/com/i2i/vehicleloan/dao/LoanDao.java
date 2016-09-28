package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Loan;

/**
 * LoanDao interface which has methods for adding, removing, retrieving user loan details into database.
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
public interface LoanDao extends GenericDao<Loan, Long> {
    
    /**
     * To add the loan detail into database by using session.
     * 
     * @param loan
     *     Its object from service method.It contains the loan detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    void addLoan(Loan loan) throws DatabaseException;
    
    /**
     * To remove the loan detail from database by using the loan id.
     * 
     * @param loanId
     *     Get loan id from service to fetch the particular loan detail want to remove. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    void removeLoan(int loanId) throws DatabaseException;
    
    /**
     * Retrieve loan detail from database and returns to service method. 
     * 
     * @param loanId
     *     Get loan id from service to fetch the particular loan detail want to retrieve. 
     * @return
     *    It return loan object to service.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    Loan retrieveLoan(int loanId) throws DatabaseException;
    
    /**
     * Retrieve all loan detail by using userId from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetchn all the loan detail want to retrieve. 
     * @return
     *     It return list of loan object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    List<Loan> retrieveLoansByUserId(int userId) throws DatabaseException;
    
    /**
     * Retrieve all loan detail from database and returns to service method. 
     * 
     * @return
     *     It return list of loan object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    List<Loan> retreieveAllLoans() throws DatabaseException;
    
    /**
     * To retrieve the loan detail by using eligibility detail ID.
     * 
     * @param eligibilityDetailId
     *     It is the value from service to to get a specific detail from database.
     * @return
     *     It return a object to service method
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    Loan retrieveLoanByEligibilityDetailId(int eligibilityDetailId) throws DatabaseException;
}
