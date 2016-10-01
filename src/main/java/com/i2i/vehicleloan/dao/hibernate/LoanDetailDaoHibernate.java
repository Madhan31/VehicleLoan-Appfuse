package com.i2i.vehicleloan.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.LoanDetailDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.LoanDetail;

/**
 * Dao class which has methods for adding, retrieving user loan detail into database.
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
@Repository("loanDetailDao")
@Transactional
public class LoanDetailDaoHibernate extends GenericDaoHibernate<LoanDetail, Long> implements LoanDetailDao {
    
    /**
     * Constructor that sets the entity to User.class.
     */
    public LoanDetailDaoHibernate() {
        super(LoanDetail.class);
    }
    
    /**
     * To add the loan detail into database by using session.
     * 
     * @param loanDetail
     *     Its object from service method.It contains the loan detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addLoanDetail(LoanDetail loanDetail) throws DatabaseException {
        Session session = getSession();
        try {
            session.save(loanDetail);
        } catch (HibernateException exp) {
            throw new  DatabaseException("Error occured in add the values in loan detail", exp);
        }
    }
    
    /**
     * Retrieve all loan detail from database and returns to service method. 
     * 
     * @return
     *     It return list of loan object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<LoanDetail> retrieveLoanDetails() throws DatabaseException {
        Session session = getSession();
        try {
            List<LoanDetail> loanDetail = session.createQuery("from LoanDetail").list();
            return loanDetail;
        } catch (HibernateException exp) {
            throw new  DatabaseException("Error occured in retrive the loan details in loan", exp);
        } 
    }    
    
    /**
     * Retrieve all loan detail by using loan id from database and returns to service method. 
     * 
     * @param loanId
     *     Get loan id from service to fetch all the loan detail want to retrieve. 
     * @return
     *     It return retrieve list of loan detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.  
     */
    public List<LoanDetail> retrieveLoanDetailsByLoanId(int loanId) throws DatabaseException {
        Session session = getSession();
        try {
            List<LoanDetail> loanDetail = session.createQuery("from LoanDetail where loan_id = '"+loanId+"'").list();
            return loanDetail;
        } catch (HibernateException exp) {
            throw new  DatabaseException("Error occured in retrive the loan details in loan", exp);
        } 
    } 
    
    /**
     * Retrieve all loan detail by using user id from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetch all the loan detail want to retrieve. 
     * @return
     *     It return retrieve list of loan detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<LoanDetail> retrieveLoanDetailByUserId(Long userId) throws DatabaseException {
        Session session = getSession();
        try {
            List<LoanDetail> loanDetails = session.createQuery("from LoanDetail where user_id = "+userId).list();
            return loanDetails;
        } catch (HibernateException exception) {
            throw new  DatabaseException("Error occured in retrive the loan details in loan", exception);
        }
    } 
}
