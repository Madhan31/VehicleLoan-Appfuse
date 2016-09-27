package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;
import com.i2i.vehicleloan.model.LoanDetail;

/**
 * Dao class which has methods for adding, retrieving user loan detail into database.
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
public interface LoanDetailDao extends GenericDao<LoanDetail, Long> {
    
    /**
     * To add the loan detail into database by using session.
     * 
     * @param loanDetail
     *     Its object from service method.It contains the loan detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void addLoanDetail(LoanDetail loanDetail) throws DatabaseException;
    
    /**
     * Retrieve all loan detail from database and returns to service method. 
     * 
     * @return
     *     It return list of loan object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file. 
     */
    public List<LoanDetail> retrieveLoanDetails() throws DatabaseException;
    
    /**
     * Retrieve all loan detail by using loan id from database and returns to service method. 
     * 
     * @param loanId
     *     Get loan id from service to fetch all the loan detail want to retrieve. 
     * @return
     *     It return retrieve list of loan detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
    public List<LoanDetail> retrieveLoanDetailsByLoanId(int loanId) throws DatabaseException;
    
    /**
     * Retrieve all loan detail by using user id from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetch all the loan detail want to retrieve. 
     * @return
     *     It return retrieve list of loan detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file. 
     */
    public List<LoanDetail> retrieveLoanDetailByUserId(int userId) throws DatabaseException;
}
