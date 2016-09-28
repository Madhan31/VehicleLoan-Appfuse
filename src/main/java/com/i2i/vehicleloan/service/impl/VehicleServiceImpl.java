package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.VehicleDao;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Vehicle;
import com.i2i.vehicleloan.service.VehicleService;
import com.i2i.vehicleloan.util.ValidationUtil;

/**
 * <p>
 * Vehicle service class which has methods for adding, removing, retrieve vehicle details.
 * It contain all the business logic operation of vehicle class.
 * </p> 
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
@Service("vehicleService")
public class VehicleServiceImpl extends GenericManagerImpl<Vehicle, Long> implements VehicleService {
	
	@Autowired
    VehicleDao vehicleDao;

    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public VehicleServiceImpl(VehicleDao vehicleDao) {
        super(vehicleDao);
        this.vehicleDao = vehicleDao;
    }
    
    public VehicleServiceImpl () { }
	
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
    public List<Vehicle> retrieveVehicles() throws DatabaseException {
        return vehicleDao.retrieveVehicles();		
    }
    
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
    public String addVehicle(Vehicle vehicle) throws DatabaseException {
        vehicleDao.addVehicle(vehicle);
        return "Vehicle details added successfully";
    }
    
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
    public String removeVehicle(int vehicleId) throws DatabaseException {
    	if (ValidationUtil.isNumeric(String.valueOf(vehicleId))) {
            vehicleDao.removeVehicle(vehicleId);
            return "Vehicle details deleted successfully";
        }
    	throw new DatabaseException("Please enter number only");
    }
}
