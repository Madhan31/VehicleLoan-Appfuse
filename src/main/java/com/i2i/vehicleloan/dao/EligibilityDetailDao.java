package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;

/**
 * Dao class which has methods for adding user eligibility details into database.
 * 
 * @author Madhan
 * 
 * @since 2016-09-06
 */
public interface EligibilityDetailDao extends GenericDao<EligibilityDetail, Long> {
    
    /**
	 * To insert a eligibility details into table using session.
	 * 
     * @param eligibilityDetail
     * 		Its a object from service method.
     * @return
     * 		Returns true or false to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    boolean insertEligibilityDetail(EligibilityDetail eligibilityDetail) throws DatabaseException;   
    
    /**
	 * To retrieve all the eligibility detail by using user ID.
	 *  
     * @param eligibilityDetail
     * 		Its a value from service method.
     * @return
     * 		Returns list of object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
    List<EligibilityDetail> retrieveEligibilityDetailsByUserId(int userId) throws DatabaseException; 
    
    /**
     * To retrieve the eligibility detail by using vehicle model ID.
     * 
     * @param paymentId
     *     It is the value from service to to get a specific detail from database.
     * @return
     *     It return a object to service method
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    EligibilityDetail retrieveEligibilityDetail(int vehicleModelId) throws DatabaseException;
}
