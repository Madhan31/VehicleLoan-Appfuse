package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Payment;

/**
 * Dao class which has methods for adding, retrieving user payment detail into database.
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
public interface PaymentDao extends GenericDao<Payment, Long> {
    
    /**
     * To add the payment detail into database by using session.
     * 
     * @param payment
     *     Its object from service method.It contains the payment detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    void addPayment(Payment payment) throws DatabaseException;
    
    /**
     * Retrieve payment detail by using payment id from database and returns to service method. 
     * 
     * @param paymentId
     *     Get loan id from service to fetch the payment detail want to retrieve. 
     * @return
     *     It return retrieve of payment detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    Payment retrievePayment(int paymentId) throws DatabaseException;
    
    /**
     * Retrieve all payment detail by using userId from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetchn all the loan detail want to retrieve. 
     * @return
     *     It return list of loan object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    List<Payment> retrievePaymentsByLoanId(int loanId) throws DatabaseException;    
}
