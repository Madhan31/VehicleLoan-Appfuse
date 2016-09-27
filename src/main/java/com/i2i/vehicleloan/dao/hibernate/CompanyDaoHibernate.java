package com.i2i.vehicleloan.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.CompanyDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;

/**
 * Dao class which has methods for adding, retrieve, remove company details in database.
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
@Repository("companyDao")
@Transactional
public class CompanyDaoHibernate extends GenericDaoHibernate<Company, Long> implements CompanyDao {
	
    /**
     * Constructor that sets the entity to User.class.
     */
    public CompanyDaoHibernate() {
        super(Company.class);
    }	
	
    /**
     * Retrieve all company details from database and returns to service method. 
     * 
     * @return
     * 		Returns company list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public List<Company> retrieveCompanies() throws DatabaseException {
        Session session = getSession();
        try {
            List<Company> companies = session.createQuery("from Company").list();
            return companies;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cant retrieve companies Kindly check your input and try again...\n", exp);
        } 
    }	
    
    /**
     * To add the company detail into database by using session.
     * 
     * @param company
     *     Its object from service method.It contains company detail.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void addCompany(Company company) throws DatabaseException {
        try {
        	getSession().save(company);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in company", exp);
        } 
    }
    
    /**
     * To remove the company detail from database by using the company id.
     * 
     * @param companyId
     *     Get company id from service to fetch the particular comapny detail want to remove. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void removeCompany(int companyId) throws DatabaseException {    	
        Session session = getSession();
        try {
            Company company = (Company) session.load(Company.class, companyId);
            session.delete(company);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in remove the vehicle details in company", exp);
        } 
    }	
}
