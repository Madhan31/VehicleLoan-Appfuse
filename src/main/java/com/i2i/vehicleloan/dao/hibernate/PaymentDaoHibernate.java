package com.i2i.vehicleloan.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.PaymentDao;
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
@Repository("paymentDao")
@Transactional
public class PaymentDaoHibernate extends GenericDaoHibernate<Payment, Long> implements PaymentDao {
    
    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public PaymentDaoHibernate() {
        super(Payment.class);
    }
    
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
    public void addPayment(Payment payment) throws DatabaseException {
        try {
            getSession().save(payment);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in payment", exp);
        }
    }
    
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
    public Payment retrievePayment(int paymentId) throws DatabaseException {
        try {
            Payment payment = (Payment) getSession().get(Payment.class, paymentId);
            return payment;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exp);
        }
    }
    
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
    public List<Payment> retrievePaymentsByLoanId(int loanId) throws DatabaseException {
        try {
            List<Payment> payments = getSession().createQuery("from Payment where loan_id = '"+loanId+"'").list();
            return payments;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exp);
        }
    }     
}
