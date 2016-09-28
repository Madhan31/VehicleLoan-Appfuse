package com.i2i.vehicleloan.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.UserAddressDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.UserAddress;

/**
 * Dao class which has methods for adding address details in database.
 * 
 * @author Madhan
 *
 * @since 2016-09-06
 */
@Repository("userAddressDao")
@Transactional
public class UserAddressDaoHibernate extends GenericDaoHibernate<UserAddress, Long> implements UserAddressDao {
	
    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public UserAddressDaoHibernate() {
        super(UserAddress.class);
    }
	
    /**
     * To add the address detail into database by using session.
     * 
     * @param address
     *     Its object from service method.It contains the adddress detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
	public void insertAddress(UserAddress userAddress) throws DatabaseException {
        try {
            getSession().save(userAddress);
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cannot add address kindly check your input and try again...\n", exp);    
        } 		
	}
	
    /**
     * To add the address detail into database by using session.
     * 
     * @param address
     *     Its object from service method.It contains the adddress detail of user.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
	public List<UserAddress> retrieveAddressesByUserId(int userId) throws DatabaseException {
        try {
            List<UserAddress> addresses = getSession().createQuery("from Address where user_id="+userId).list();
            return addresses;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cannot retrieve address kindly check your input and try again...\n", exp);    
        }		
	}	
}
