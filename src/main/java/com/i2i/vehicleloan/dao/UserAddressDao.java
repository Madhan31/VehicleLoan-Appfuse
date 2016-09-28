package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.UserAddress;

/**
 * Dao class which has methods for adding address details in database.
 * 
 * @author Madhan
 *
 * @since 2016-09-06
 */
public interface UserAddressDao extends GenericDao<UserAddress, Long> {
	
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
	void insertAddress(UserAddress UserAddress) throws DatabaseException;
	
    /**
     * To add the address detail into database by using session.
     * 
     * @param address
     *     Its object from service method.It contains the adddress detail of user.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
	List<UserAddress> retrieveAddressesByUserId(int userId) throws DatabaseException;
}
