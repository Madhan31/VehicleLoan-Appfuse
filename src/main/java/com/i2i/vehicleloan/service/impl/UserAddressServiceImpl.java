package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.UserAddressDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.UserAddress;
import com.i2i.vehicleloan.service.UserAddressService;
import com.i2i.vehicleloan.util.ValidationUtil;

/**
 * <p>
 * Address detail service class which has methods for adding,address details.
 * It contain all the business logic operation of address detail class.
 * </p> 
 * 
 * @author Madhan
 *
 * @since 2016-09-06
 */
@Service("userAddress")
public class UserAddressServiceImpl extends GenericManagerImpl<UserAddress, Long> implements UserAddressService {
    
    @Autowired
    UserAddressDao userAddressDao;

    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public UserAddressServiceImpl(UserAddressDao userAddressDao) {
        super(userAddressDao);
        this.userAddressDao = userAddressDao;
    }
    
    public UserAddressServiceImpl() { }
    
    /**
     * Call address detail dao for add new address detail.
     * 
     * @param address
     *     Get address detail object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.      
     */
    public void addAddress(UserAddress userAddress) throws DatabaseException {
        /*if (!ValidationUtil.isNumeric(String.valueOf(userAddress.getPincode()))) {
            throw new DatabaseException("Kindly Enter valid pincode...");
        }*/
        userAddressDao.insertAddress(userAddress);
    }
    
    /**
     * Call address detail dao for add new address detail.
     * 
     * @param address
     *     Get address detail object from controller. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public UserAddress retrieveAddressByUserId(int userId) throws DatabaseException {
        int sizeCount = 1;
        List<UserAddress> addresses = userAddressDao.retrieveAddressesByUserId(userId);
        int listSize = addresses.size();
        for (UserAddress address : addresses) {
            if (listSize == sizeCount) {
                return address;
            } else {
                sizeCount++;
            }
        }
        return null;         
    }    
}
