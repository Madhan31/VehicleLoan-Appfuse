package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.CompanyDao;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;
import com.i2i.vehicleloan.service.CompanyService;
import com.i2i.vehicleloan.util.ValidationUtil;

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
@Service("companyService")
public class CompanyServiceImpl extends GenericManagerImpl<Company, Long> implements CompanyService {

    CompanyDao companyDao;
    
    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
	
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
    public List<Company> retrieveCompanies() throws DatabaseException {
        return companyDao.retrieveCompanies();		
    }	
    
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
    public String addCompany(Company company) throws DatabaseException {
    	companyDao.addCompany(company);
        return "Company details added successfully";
    }
    
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
    public String removeCompany(int companyId) throws DatabaseException {
        if (!ValidationUtil.isNumeric(String.valueOf(companyId))) {
            throw new DatabaseException("Kindly Enter valid comapny id...");
        }
        companyDao.removeCompany(companyId);
        return "Company details deleted successfully";
    }    
}
