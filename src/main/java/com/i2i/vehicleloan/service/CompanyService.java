package com.i2i.vehicleloan.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;
import com.i2i.vehicleloan.model.Vehicle;

/**
 * <p>
 * Company service class which has methods for adding, removing, retrieve company details.
 * It contain all the business logic operation of company class.
 * </p>
 *    
 * @author vicky
 *
 * @since 2016-09-06
 */
public interface CompanyService extends GenericManager<Company, Long> {
	
    /**
     * Retrieve all the company details from database to controller method
     * 
     * @return 
     *     It returns list object to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    List<Company> retrieveCompanies() throws DatabaseException;
    
    /**
     * Call company dao for add the new company detail.
     * 
     * @param company
     *     Its object from a controller
     * @return 
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    String addCompany(Company company) throws DatabaseException;
    
    /**
     * Call company dao for remove the company detail.
     * 
     * @param companyId
     *     Get company id from controller.
     * @return 
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    String removeCompany(int companyId) throws DatabaseException;  
}
