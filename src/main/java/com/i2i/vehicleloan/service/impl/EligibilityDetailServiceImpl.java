package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.EligibilityDetailDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;
import com.i2i.vehicleloan.service.EligibilityDetailService;
import com.i2i.vehicleloan.util.ValidationUtil;

/**
 * <p>
 * Eligibility detail service class which has methods for adding eligibility details.
 * It contain all the business logic operation of eligibility detail class.
 * </p>  
 * 
 * @author Madhan
 *
 * @since 2016-09-06
 */
@Service("eligibilityDetailService")
public class EligibilityDetailServiceImpl extends GenericManagerImpl<EligibilityDetail, Long> implements EligibilityDetailService {
    
    @Autowired
    private EligibilityDetailDao eligibilityDetailDao;

    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public EligibilityDetailServiceImpl(EligibilityDetailDao eligibilityDetailDao) {
        super(eligibilityDetailDao);
        this.eligibilityDetailDao = eligibilityDetailDao;
    }
    
    public EligibilityDetailServiceImpl() { }
    
    /**
     * Calls eligibility dao methods to add eligibility details.
     *  
     * @param employee
     *         Its a object from controller method
     * @return
     *         Returns true or false to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.  
     */   
    public boolean addEligibilityDetail(EligibilityDetail eligibilityDetail) throws DatabaseException {
        if (!ValidationUtil.isNumeric(String.valueOf(eligibilityDetail.getSalary()))) {
            throw new DatabaseException("Kindly Enter only numbers...");
        }        
        if (eligibilityDetail.getSalary() < 10000) {
            throw new DatabaseException("Salary must be greater than 10000");
        }
        if (!ValidationUtil.isNumeric(String.valueOf(eligibilityDetail.getDownPayment()))) {
            throw new DatabaseException("Kindly Enter only numbers...");
        }         
        if (eligibilityDetail.getDownPayment() < 10000) {
            throw new DatabaseException("Downpayment must be greater than 10000");
        }
        return eligibilityDetailDao.insertEligibilityDetail(eligibilityDetail);
    }
    
    /**
     * Calls eligibility dao methods to retrieve eligibility details.
     *  
     * @param employee
     *         Its a object from controller method
     * @return
     *         Returns true or false to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */   
    public List<EligibilityDetail> retrieveEligibilityDetailsByUserId(int userId) throws DatabaseException {
        return eligibilityDetailDao.retrieveEligibilityDetailsByUserId(userId);
    }   
    
    /**
     * Calls eligibility dao methods to retrieve eligibility details.
     * 
     * @param vehicleModelId
     *     It get the value from vehicle model service for checking whether the vehicle model have any loan or not.
     * @return
     *     It return true or false to the vehicle model service.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public boolean isVehicleModelExist(int vehicleModelId) throws DatabaseException {
        //if (loanService.isLoanExistByEligibilityDetailId(eligibilityDetailDao.retrieveEligibilityDetail(vehicleModelId).getId())) {
            return true;
        //}
        //return false;
    }
}
