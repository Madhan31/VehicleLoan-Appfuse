package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.LoanDetailDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;
import com.i2i.vehicleloan.model.LoanDetail;
import com.i2i.vehicleloan.service.LoanDetailService;

/**
 * <p>
 * Loan detail service class which has methods for adding, retrieve loan detail details.
 * It contain all the business logic operation of loan detail class.
 * </p> 
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
@Service("loanDetailService")
public class LoanDetailServiceImpl extends GenericManagerImpl<Company, Long> implements LoanDetailService {

    private LoanDetailDao loanDetailDao;
    
    @Autowired
    public LoanDetailServiceImpl(LoanDetailDao loanDetailDao) {
        this.loanDetailDao = loanDetailDao;
    }    
    
    /**
     * Call loan detail dao for add new loan detail.
     * 
     * @param loanDetail
     *     Get loan detail object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.   
     */
    public void addLoanDetail(LoanDetail loanDetail) throws DatabaseException {
        loanDetailDao.addLoanDetail(loanDetail);
    }
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id form controller for retrieve particular loan detail.
     * @return
     *     Return the object of retrieve exist loan detail to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public LoanDetail retrieveLatestLoanDetail() throws DatabaseException {
        return retrieveLatestLoanDetailFromList(loanDetailDao.retrieveLoanDetails());
    }    
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id form controller for retrieve particular loan detail.
     * @return
     *     Return the object of retrieve exist loan detail to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public LoanDetail retrieveLoanDetailByLoanId(int loanId) throws DatabaseException {
        return retrieveLatestLoanDetailFromList(loanDetailDao.retrieveLoanDetailsByLoanId(loanId));
    }      
    
    /**
     * Retrieve all the loan details from database to controller method.
     *   
     * @param userId
     *     Get the userId from controller.
     * @return
     *     It return list of object to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application. 
     */
    public LoanDetail retrieveLoanDetailByUserId(Long userId)throws DatabaseException {
        return retrieveLatestLoanDetailFromList(loanDetailDao.retrieveLoanDetailByUserId(userId));
    }
    
    /**
     * This method retrieve final object from given list.
     * @param loanDetails
     *         Contains list of loan details. 
     * @return
     *         Returns loan detail object.
     */
    private LoanDetail retrieveLatestLoanDetailFromList(List<LoanDetail> loanDetails) {
        int sizeCount = 1;
        int listSize = loanDetails.size();
        for (LoanDetail loanDetail :loanDetails) {
            if (listSize == sizeCount) {
                return loanDetail;
            } else {
                sizeCount++;
            }
        }
        return null;        
    }
}
