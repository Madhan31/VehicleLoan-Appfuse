package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.LoanDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.VehicleModel;
import com.i2i.vehicleloan.service.LoanService;

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
@Service("loanService")
public class LoanServiceImpl extends GenericManagerImpl<Loan, Long> implements LoanService {

    @Autowired
    private LoanDao loanDao;

    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public LoanServiceImpl(LoanDao loanDao) {
        super(loanDao);
        this.loanDao = loanDao;
    }
    
    public LoanServiceImpl() { }
    
    /**
     * Call loan dao for add new loan detail.
     * 
     * @param loan
     *     Get loan object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addLoan(Loan loan) throws DatabaseException {
        loanDao.addLoan(loan);
    }
    
    /**
     * Call loan detail dao for remove loan detail.
     * 
     * @param loanId
     *     Get loan id from controller.
     * @return
     *    It return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.  
     */
    public String removeLoan(int loanId) throws DatabaseException {
        if (isLoanExist(loanId)) {
            loanDao.removeLoan(loanId); 
            return "Loan deleted successfully"; 
        }
        return "Loan not exist";
    }
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id from controller.
     * @return
     *    It return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public Loan retrieveLoan(int loanId) throws DatabaseException {
        return loanDao.retrieveLoan(loanId);
    }
    
    /**
     * Retrieve all the loan from database to controller method.
     * 
     * @param userId
     *     Get the userId from controller.
     * @return
     *     It return list of object to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application. 
     */
    public List<Loan> retrieveLoansByUserId(int userId) throws DatabaseException {
        return loanDao.retrieveLoansByUserId(userId);
    }
    
    /**
     * Retrieve all the loan from database to controller method.
     * 
     * @return
     *     It return list of object to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Loan> retreiveAllLoans() throws DatabaseException {
        return loanDao.retreieveAllLoans();
    }
    
    /**
     * Check whether the loan detail exist or not.
     * 
     * @param loanId
     *     Get the loan id from controller.
     * @return
     *     It return true or false to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.   
     */
    public boolean isLoanExist(int loanId) throws DatabaseException {
        return (null != retrieveLoan(loanId));
    }
    
    /**
     * Check whether any loan are avaliable for that specific eligibility detail id.
     * 
     * @param eligibilityDetailId
     *     Get the loan id from eligibility detail service.
     * @return
     *     It return true or false to eligibility detail service.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public boolean isLoanExistByEligibilityDetailId(int eligibilityDetailId) throws DatabaseException {
        return (null != loanDao.retrieveLoanByEligibilityDetailId(eligibilityDetailId));
    }
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
    public int calculateLoanAmount(EligibilityDetail eligibilityDetail,VehicleModel vehicleModel) {
        return (vehicleModel.getPrice() - eligibilityDetail.getDownPayment());
    }
    
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
    public float getEmiDetails(int loanPeriod, int loanAmount) {
        if (loanPeriod == 12) {    // Here 12 indicates emi period 
            return (loanAmount + loanAmount * 10/100)/loanPeriod;
        }
        if (loanPeriod == 24) {    // Here 24 indicates emi period
            return (loanAmount + loanAmount * 15/100)/loanPeriod;
        }
        if (loanPeriod == 36) {    // Here 36 indicates emi period
            return (loanAmount + loanAmount * 18/100)/loanPeriod;
        }
        return 0;        
    }
    
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
    public float getProcessingFees(int loanPeriod, int loanAmount) {
        if (loanPeriod == 12) {    // Here 12 indicates emi period 
            return (loanAmount * 1/100);
        }
        if (loanPeriod == 24) {    // Here 24 indicates emi period 
            return (loanAmount * 2/100);
        }
        if (loanPeriod == 36) {    // Here 36 indicates emi period 
            return (loanAmount * 3/100);
        }
        return 0;        
    }
    
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
    public float getDocumentationCharges(int loanPeriod, int loanAmount) {
        if (loanPeriod == 12) {    // Here 12 indicates emi period 
            return (loanAmount * 3/100);
        }
        if (loanPeriod == 24) {    // Here 24 indicates emi period 
            return (loanAmount * 2/100);
        }
        if (loanPeriod == 36) {    // Here 36 indicates emi period 
            return (loanAmount * 1/100);
        }
        return 0;         
    }    
}
