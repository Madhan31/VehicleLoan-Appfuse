package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.PaymentDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.LoanDetail;
import com.i2i.vehicleloan.model.Payment;
import com.i2i.vehicleloan.service.LoanDetailService;
import com.i2i.vehicleloan.service.LoanService;
import com.i2i.vehicleloan.service.PaymentService;
import com.i2i.vehicleloan.util.ValidationUtil;

/**
 * <p>
 * Payment service class which has methods for adding, retrieve payment details.
 * It contain all the business logic operation of payment class.
 * </p> 
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
@Service("paymentService")
public class PaymentServiceImpl extends GenericManagerImpl<Payment, Long> implements PaymentService {
   
    private PaymentDao paymentDao;
    private LoanDetailService loanDetailService;
    private LoanService loanService;      

    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao, LoanDetailService loanDetailService, LoanService loanService) {
        super(paymentDao);
        this.paymentDao = paymentDao;
        this.loanDetailService = loanDetailService;
        this.loanService = loanService;
    }
    
    public PaymentServiceImpl() { }   
       
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
    public String addPayment(Payment payment) throws DatabaseException {
        if (!ValidationUtil.isNumeric(String.valueOf(payment.getLoan().getLoanId()))) {
            throw new DatabaseException("Kindly Enter valid number...");
        }            
        if (!ValidationUtil.isNumeric(String.valueOf(payment.getPaymentAmount()))) {
            throw new DatabaseException("Kindly Enter only numbers...");
        }         
        paymentDao.addPayment(payment);
        Loan loan = loanService.retrieveLoan(payment.getLoan().getLoanId());
        if (null == loanDetailService.retrieveLoanDetailByLoanId(payment.getLoan().getLoanId())) {
            int balanceEmi = ((loan.getLoanPeriod()) - 1);
            int balanceAmount = (loan.getLoanAmount() - payment.getPaymentAmount());
            loanDetailService.addLoanDetail(new LoanDetail(balanceAmount, balanceEmi, loan, payment, loan.getUser()));
            return "Successfully paided";
        }
        LoanDetail loanDetail = loanDetailService.retrieveLoanDetailByLoanId(payment.getLoan().getLoanId());
        int balanceEmi = (loanDetail.getBalanceEmi() - 1);
        int balanceAmount = (loanDetail.getBalanceAmount() - payment.getPaymentAmount());
        loanDetailService.addLoanDetail(new LoanDetail(balanceAmount, balanceEmi, loan, payment, loan.getUser()));
        return "Successfully paided";
    }
       
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
    public Payment retrievePayment(int paymentId) throws DatabaseException {
        return paymentDao.retrievePayment(paymentId);
    }
       
    /**
      * Call payment dao for retrieve particular payment detail.
      * 
      * @return
      *     It return the payment object to controller.   
      * @throws DatabaseException
      *     It handle all the custom exception in vehicle loan application.
      */
    public List<Payment> retrievePaymentsByLoanId(int loanId) throws DatabaseException {
        return paymentDao.retrievePaymentsByLoanId(loanId);
    }       
}
