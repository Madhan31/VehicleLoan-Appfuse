package com.i2i.vehicleloan.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.VehicleModelDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.VehicleModel;

/**
 * Dao class which has methods for adding, removing, retrieving vehicle Model detail into database.
 * 
 * @author madhan
 *
 * @since 2016-09-06
 */
@Repository("vehicleModelDao")
@Transactional
public class VehicleModelDaoHibernate extends GenericDaoHibernate<VehicleModel, Long> implements VehicleModelDao {
    
    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public VehicleModelDaoHibernate() {
        super(VehicleModel.class);
    }
    
    /**
     * To add the vehicle detail into database by using session.
     * 
     * @param vehicle
     *     Its object from service method.It contains the vehicle detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */        
    public void saveVehicleModel(VehicleModel vehicleModel) throws DatabaseException {
        try {
            Session session = getSession();
            session.saveOrUpdate(vehicleModel);
            session.flush();
        } catch (HibernateException exp) {
            exp.printStackTrace();
            throw new DatabaseException("Error occured in add vehicle model");
        }
    }
    
    /**
     * To remove the vehicle detail from database by using session.
     * 
     * @param vehicleId
     *     Get vehicle id from service to fetch the vehicle detail want to remove.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */       
    public void removeVehicleModel(int vehicleModelId) throws DatabaseException {
        try {
            VehicleModel vehicleModel = (VehicleModel) getSession().load(VehicleModel.class, vehicleModelId);
            getSession().delete(vehicleModel);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in remove vehicle model");
        }
    }
    
    /**
     * Retrieve all vehicles from database and returns to service method. 
     * 
     * @return
     *        Returns vehicle list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application. 
     */     
    public List<VehicleModel> retrieveAllVehicleModel() throws DatabaseException {
        try {
            List<VehicleModel> vehicleModels = getSession().createQuery("from VehicleModel").list();
            return vehicleModels;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cant retrieve models Kindly check your input and try again...\n", exp);
        }
    }
    
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
    public VehicleModel getVehicleModelById(int vehicleModelId) throws DatabaseException {
        try {
            Session session = getSession();;
            VehicleModel vehicleModel = (VehicleModel)session.get(VehicleModel.class, vehicleModelId);
            return vehicleModel;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cant retrieve vehicelModel Kindly check your input and try again...", exp);
        }    
    }    
    
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
    public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws DatabaseException {
        try {
            Session session = getSession();
            List<VehicleModel> vehicleModels = session.createQuery("from VehicleModel where vehicle_id = "+vehicleId).list();
            return vehicleModels;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cant retrieve vehicelModel Kindly check your input and try again...\n", exp);
        }
    }    
}
