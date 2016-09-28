package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;

/**
 * CompanyDao interface which has methods for adding, retrieve, remove company details in database.
 * 
 * @author madhan
 *
 * @since 2016-09-06
 */
public interface CompanyDao extends GenericDao<Company, Long> {
	
    /**
     * Retrieve all company details from database and returns to service method. 
     * 
     * @return
     * 		Returns company list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    List<Company> retrieveCompanies() throws DatabaseException;
    
    /**
     * To add the company detail into database by using session.
     * 
     * @param company
     *     Its object from service method.It contains company detail.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    void addCompany(Company company) throws DatabaseException;
    
    /**
     * To remove the company detail from database by using the company id.
     * 
     * @param companyId
     *     Get company id from service to fetch the particular comapny detail want to remove. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    void removeCompany(int companyId) throws DatabaseException;
}
