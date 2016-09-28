package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Payment;

/**
 * <p>
 * Payment service interface which has methods for adding, retrieve payment details.
 * It contain all the business logic operation of payment class.
 * </p> 
 * 
 * @author madhan
 *
 * @since 2016-09-06
 */
public interface PaymentService extends GenericManager<Payment, Long> {
	
    /**
     * Call payment dao for add new payment detail.
     * 
	 * @param payment
     *     Get the payment object from controller.
     * @return
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.   
     */
    String addPayment(Payment payment) throws DatabaseException;
	
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param paymentId
     *     Get payment id from controller for retrieve particular payment detail.
     * @return
     *     It return the payment object to controller.   
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.  
     */
    Payment retrievePayment(int paymentId) throws DatabaseException;
	
    /**
     * Call payment dao for retrieve particular payment detail.
     * 
     * @return
     *     It return the payment object to controller.   
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    List<Payment> retrievePaymentsByLoanId(int loanId) throws DatabaseException;
}
