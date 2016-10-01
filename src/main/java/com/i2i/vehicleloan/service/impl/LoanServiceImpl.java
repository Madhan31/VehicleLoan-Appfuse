package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.Constants;
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
 * @author vicky
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
    public List<Loan> retrieveLoansByUserId(Long userId) throws DatabaseException {
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
     * Here calculates the emi amount based on user selected loan period.
     * 
     * @param loanPeriod
     *     Get the loan period from controller.
     * @param loanAmount
     *     Get the loan amount from controller.
     * @return
     *     It return the emi value to the controller.
     */
    public float getEmiDetails(int loanPeriod, int loanAmount) {
        return (loanAmount + loanAmount * Constants.INTEREST_RATE/Constants.CENT_PERCENT * loanPeriod * Constants.INTEREST_ON_LOANPERIOD)/loanPeriod;    
    }
    
    /**
     * Here calculates the processing fees amount based on user selected loan period.
     * 
     * @param loanPeriod
     *     Get the loan period from controller.
     * @param loanAmount
     *     Get the loan amount from controller.
     * @return
     *     It return the processing fees to controller.
     */
    public float getProcessingFees(int loanPeriod, int loanAmount) {
        return ((loanAmount * loanPeriod) * Constants.PROCESSING_FEES);     
    }
    
    /**
     * Here calculates the documentation charge amount based on user selected loan period.
     * 
     * @param loanPeriod
     *     Get the loan period from controller.
     * @param loanAmount
     *     Get the loan amount from controller.
     * @return
     *     It return the documentation charges to controller.
     */
    public float getDocumentationCharges(int loanPeriod, int loanAmount) {
        return (loanAmount / loanPeriod * Constants.DOCUMENTATION_CHARGES);        
    }    
}
