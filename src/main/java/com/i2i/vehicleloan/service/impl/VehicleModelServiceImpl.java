package com.i2i.vehicleloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.vehicleloan.dao.VehicleModelDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.VehicleModel;
import com.i2i.vehicleloan.service.VehicleModelService;

@Service("vehicleModelService")
public class VehicleModelServiceImpl extends GenericManagerImpl<VehicleModel, Long> implements VehicleModelService {
    
    @Autowired
    VehicleModelDao vehicleModelDao;
    
    /**
     * Constructor that sets the entity to Vehicle.class.
     */    
    public VehicleModelServiceImpl(VehicleModelDao vehicleModelDao) {
        super(vehicleModelDao);
        this.vehicleModelDao = vehicleModelDao;
    }    
    
    public VehicleModelServiceImpl() { }
    
    /**
     * Call vehicle dao for add new vehicle detail.
     *
     * @param vehicle
     *     Get the vehicle object from controller.
     * @return
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */        
    @Override
    public void saveVehicleModel(VehicleModel vehicleModel) throws DatabaseException { 
        vehicleModelDao.saveVehicleModel(vehicleModel);
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
     */      
    @Override
    public void removeVehicleModel(int vehicleModelId) throws DatabaseException {
        vehicleModelDao.removeVehicleModel(vehicleModelId);
    }
    
    /**
     * Retrieve all the vehicle details.
     * 
     * @return
     *     It return list of vehicle object to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */     
    @Override
    public List<VehicleModel> retrieveAllVehicleModel() throws DatabaseException {
        return vehicleModelDao.retrieveAllVehicleModel();
    }
    
    /**
     * Retrieve all the vehicle model details by vehicle id.
     * 
     * @param vehicleId
     *     Get vehicle id from controller for retrieve all the vehicle model detail.  
     * @return
     *     It return list of vehicle model object to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws DatabaseException {
        return vehicleModelDao.getVehicleModelsByVehicleId(vehicleId);
    }
    
    /**
     * Retrieve particular vehicle model detail by vehicle id.
     * 
     * @param vehicleModelId
     *     Get vehicle id from controller for retrieve a vehicle model detail.  
     * @return
     *     It return a retrieve vehicle model object to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.  
     */
    public VehicleModel getVehicleModelById(int vehicleModelId) throws DatabaseException {
        return vehicleModelDao.getVehicleModelById(vehicleModelId);
    }               
}
