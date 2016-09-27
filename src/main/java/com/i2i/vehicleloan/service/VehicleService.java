package com.i2i.vehicleloan.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Role;
import com.i2i.vehicleloan.model.Vehicle;
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
public interface VehicleService extends GenericManager<Vehicle, Long> {
	
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
    public List<Vehicle> retrieveVehicles() throws DatabaseException;
    
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
    public String addVehicle(Vehicle vehicle) throws DatabaseException;
    
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
    public String removeVehicle(int vehicleId) throws DatabaseException;
}
