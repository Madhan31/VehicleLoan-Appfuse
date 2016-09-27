package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;

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
public interface EligibilityDetailService extends GenericManager<EligibilityDetail, Long> {
	
    /**
	 * Calls eligibility dao methods to add eligibility details.
	 *  
     * @param employee
     * 		Its a object from controller method
     * @return
     * 		Returns true or false to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */   
    boolean addEligibilityDetail(EligibilityDetail eligibilityDetail) throws DatabaseException;
    
    /**
	 * Calls eligibility dao methods to retrieve eligibility details.
	 *  
     * @param employee
     * 		Its a object from controller method
     * @return
     * 		Returns true or false to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */   
    List<EligibilityDetail> retrieveEligibilityDetailsByUserId(int userId) throws DatabaseException;
    
    /**
     * Calls eligibility dao methods to retrieve eligibility details.
     * 
     * @param vehicleModelId
     *     It get the value from vehicle model service for checking whether the vehicle model have any loan or not.
     * @return
     *     It return true or false to the vehicle model service.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    boolean isVehicleModelExist(int vehicleModelId) throws DatabaseException;
}
