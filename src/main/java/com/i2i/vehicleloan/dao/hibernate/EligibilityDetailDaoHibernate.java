package com.i2i.vehicleloan.dao.hibernate;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.EligibilityDetailDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;

/**
 * Dao class which has methods for adding user eligibility details into database.
 * 
 * @author Madhan
 * 
 * @since 2016-09-06
 */
@Repository("eligibilityDetailDao")
@Transactional
public class EligibilityDetailDaoHibernate extends GenericDaoHibernate<EligibilityDetail, Long> implements EligibilityDetailDao {
    
    /**
     * Constructor that sets the entity to User.class.
     */
    public EligibilityDetailDaoHibernate() {
        super(EligibilityDetail.class);
    }    
    
    /**
     * To insert a eligibility details into table using session.
     * 
     * @param eligibilityDetail
     * 		Its a object from service method.
     * @return
     * 		Returns true or false to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public boolean insertEligibilityDetail(EligibilityDetail eligibilityDetail) throws DatabaseException {
        try {
            getSession().saveOrUpdate(eligibilityDetail);
            return true;
        } catch (HibernateException exp) {
        	throw new DatabaseException("Oops...Cant add eligibilityDetail Kindly check your input and try again...\n", exp);            
        }
    }    
    
    /**
     * To retrieve all the eligibility detail by using user ID.
     *  
     * @param eligibilityDetail
     * 		Its a value from service method.
     * @return
     * 		Returns list of object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application. 
     */
    public EligibilityDetail retrieveEligibilityDetailsByUserId(int userId) throws DatabaseException {
        try {
            //List<EligibilityDetail> eligibilityDetails = getSession().createQuery("from EligibilityDetail where user_id="+userId).list();
            EligibilityDetail eligibilityDetails = (EligibilityDetail) getSession().get(EligibilityDetail.class, userId);
            return eligibilityDetails;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrieving the eligibility details", exp);
        }
    }  
    
    /**
     * To retrieve the eligibility detail by using vehicle model ID.
     * 
     * @param paymentId
     *     It is the value from service to to get a specific detail from database.
     * @return
     *     It return a object to service method
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public EligibilityDetail retrieveEligibilityDetail(int vehicleModelId) throws DatabaseException {
        try {
            EligibilityDetail eligibilityDetail = (EligibilityDetail) getSession().createQuery("from EligibilityDetail where vehicle_model_id = '"+vehicleModelId+"'");            
            return eligibilityDetail;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the eligibility details in payment", exp);
        }
    }
}
