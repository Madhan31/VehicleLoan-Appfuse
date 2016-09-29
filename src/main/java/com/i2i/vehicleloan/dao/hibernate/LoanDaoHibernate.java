package com.i2i.vehicleloan.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.LoanDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Loan;

/**
 * Dao class which has methods for adding, removing, retrieving user loan details into database.
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
@Repository("loanDao")
@Transactional
public class LoanDaoHibernate extends GenericDaoHibernate<Loan, Long> implements LoanDao {
    
    /**
     * Constructor that sets the entity to User.class.
     */
    public LoanDaoHibernate() {
        super(Loan.class);
    } 
    
    /**
     * To add the loan detail into database by using session.
     * 
     * @param loan
     *     Its object from service method.It contains the loan detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addLoan(Loan loan) throws DatabaseException {
        try {
            getSession().save(loan);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in loan", exp);
        }
    }
    
    /**
     * To remove the loan detail from database by using the loan id.
     * 
     * @param loanId
     *     Get loan id from service to fetch the particular loan detail want to remove. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void removeLoan(int loanId) throws DatabaseException {
        try {
            Session session = getSession();
            Loan loan = (Loan) session.load(Loan.class, loanId);
            session.delete(loan);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in remove the loan details in loan", exp);
        }
    }
    
    /**
     * Retrieve loan detail from database and returns to service method. 
     * 
     * @param loanId
     *     Get loan id from service to fetch the particular loan detail want to retrieve. 
     * @return
     *    It return loan object to service.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public Loan retrieveLoan(int loanId) throws DatabaseException {
        try {
            Loan loan = (Loan) getSession().get(Loan.class, loanId);
            return loan;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the loan details in loan", exp);
        }
    } 
    
    /**
     * Retrieve all loan detail by using userId from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetchn all the loan detail want to retrieve. 
     * @return
     *     It return list of loan object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Loan> retrieveLoansByUserId(Long userId) throws DatabaseException {
        try {
            List<Loan> loans = getSession().createQuery("from Loan where user_id = '"+userId+"'").list();
            return loans;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the loan details in loan", exp);
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
    public List<Loan> retreieveAllLoans() throws DatabaseException {
        try {
            List<Loan> loans = getSession().createQuery("from Loan").list();
            return loans;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occur in retrive all loan details in loan", exp);
        }
     }
    
    /**
     * To retrieve the loan detail by using eligibility detail ID.
     * 
     * @param eligibilityDetailId
     *     It is the value from service to to get a specific detail from database.
     * @return
     *     It return a object to service method
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public Loan retrieveLoanByEligibilityDetailId(int eligibilityDetailId) throws DatabaseException {
        try {
            Loan loan = (Loan) getSession().createQuery("from loan where eligibility_detail_id = '"+eligibilityDetailId+"'");
            return loan;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exp);
        }
    }
}
