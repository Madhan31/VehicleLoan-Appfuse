package com.i2i.vehicleloan.service;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.UserAddress;

/**
 * <p>
 * Address detail service interface which has methods for adding,address details.
 * It contain all the business logic operation of address detail class.
 * </p> 
 * 
 * @author Madhan
 *
 * @since 2016-09-06
 */
public interface UserAddressService extends GenericManager<UserAddress, Long> {
	
    /**
     * Call address detail dao for add new address detail.
     * 
     * @param address
     *     Get address detail object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.     
     */
    void addAddress(UserAddress UserAddress) throws DatabaseException;
	
    /**
     * Call address detail dao for add new address detail.
     * 
     * @param address
     *     Get address detail object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    UserAddress retrieveAddressByUserId(int userId) throws DatabaseException;
}
