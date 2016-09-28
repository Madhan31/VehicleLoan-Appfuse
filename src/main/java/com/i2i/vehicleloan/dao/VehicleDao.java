package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Vehicle;

/**
 * VehicleDao inteface which has methods for adding, removing, retrieving vehicle detail into database.
 * 
 * @author madhan
 *
 * @since 2016-09-06
 */
public interface VehicleDao extends GenericDao<Vehicle, Long> {
    
    /**
     * Retrieve all vehicles from database and returns to service method. 
     * 
     * @return
     * 	   Returns vehicle list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    List<Vehicle> retrieveVehicles() throws DatabaseException;
    
    /**
     * To add the vehicle detail into database by using session.
     * 
     * @param vehicle
     *     Its object from service method.It contains the vehicle detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    void addVehicle(Vehicle vehicle) throws DatabaseException;
    
    /**
     * To remove the vehicle detail from database by using session.
     * 
     * @param vehicleId
     *     Get vehicle id from service to fetch the vehicle detail want to remove.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    void removeVehicle(int vehicleId) throws DatabaseException;
}   
