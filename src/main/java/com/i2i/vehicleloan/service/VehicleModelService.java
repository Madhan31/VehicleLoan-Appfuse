package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.VehicleModel;

/**
 * <p>
 * Vehicle service class which has methods for adding, removing, retrieve vehicle details.
 * It contain all the business logic operation of vehicle class.
 * </p> 
 * 
 * @author madhan
 *
 * @since 2016-09-06
 */
public interface VehicleModelService extends GenericManager<VehicleModel, Long> {
    
    /**
     * Call vehicle dao for add new vehicle detail.
     *
     * @param vehicle
	 *     Get the vehicle object from controller.
     * @return
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */	
    void saveVehicleModel(VehicleModel vehicleModel) throws DatabaseException;
    
    /**
     * Call vehicle dao for remove vehicle detail.
     * 
     * @param vehicleId
	 *     Get vehicle id from controller to remove detail of specified vehicle. 
     * @return
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.       
     */    
    void removeVehicleModel(int userId) throws DatabaseException;
    
    /**
     * Retrieve all the vehicle details.
     * 
     * @return
     *     It return list of vehicle object to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */     
    List<VehicleModel> retrieveAllVehicleModel() throws DatabaseException;
    
    /**
     * Retrieve all the vehicle model details by vehicle id.
     * 
     * @param vehicleId
     *     Get vehicle id from controller for retrieve all the vehicle model detail.  
     * @return
     *     It return list of vehicle model object to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
	public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws DatabaseException;
	
	/**
	 * Retrieve particular vehicle model detail by vehicle id.
	 * 
	 * @param vehicleModelId
     *     Get vehicle id from controller for retrieve a vehicle model detail.  
	 * @return
	 *     It return a retrieve vehicle model object to controller.
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
	 */
	public VehicleModel getVehicleModelById(int vehicleModelId) throws DatabaseException;
}
