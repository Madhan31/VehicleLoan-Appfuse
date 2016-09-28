package com.i2i.vehicleloan.dao;

import java.util.List;

import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.VehicleModel;
/**
 * VehicleModelDao interface which has methods for adding, removing, retrieving vehicle Model detail into database.
 * 
 * @author madhan
 *
 * @since 2016-09-06
 */
public interface VehicleModelDao extends GenericDao<VehicleModel, Long> {
    
    /**
     * To add the vehicle detail into database by using session.
     * 
     * @param vehicle
     *     Its object from service method.It contains the vehicle detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */	
    void saveVehicleModel(VehicleModel vehicleModel) throws DatabaseException;
    
    /**
     * To remove the vehicle detail from database by using session.
     * 
     * @param vehicleId
     *     Get vehicle id from service to fetch the vehicle detail want to remove.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */    
    void removeVehicleModel(int vehicleModelId) throws DatabaseException;
    
    /**
     * Retrieve all vehicles from database and returns to service method. 
     * 
     * @return
     * 	   Returns vehicle list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application. 
     */    
    List<VehicleModel> retrieveAllVehicleModel() throws DatabaseException;
    
    /**
     * Retrieve vehicle model detail from database and returns to service method.
     *  
     * @param vehicleModelId
     *     Get vehicle model id from service to fetch the vehicle detail want to retrieve.
     * @return
     *     It return the vehicle model object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public VehicleModel getVehicleModelById(int vehicleModelId) throws DatabaseException; 
    
    /**
     * Retrieve all vehicle model detail by using vehicle id from database and returns to service method. 
     * 
     * @param vehicleId
     *     Get vehicle id from service to fetch all the vehicle detail want to retrieve. 
     * @return
     *     It return retrieve list of vehicle detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws DatabaseException; 
}
