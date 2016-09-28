package com.i2i.vehicleloan.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.vehicleloan.dao.VehicleDao;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Vehicle;

/**
 * Dao class which has methods for adding, removing, retrieving vehicle detail into database.
 * 
 * @author madhan
 *
 * @since 2016-09-06
 */
@Repository("vehicleDao")
@Transactional
public class VehicleDaoHibernate extends GenericDaoHibernate<Vehicle, Long> implements VehicleDao {
    
    /**
     * Constructor that sets the entity to Vehicle.class.
     */
    public VehicleDaoHibernate() {
        super(Vehicle.class);
    }	
    
    /**
     * Retrieve all vehicles from database and returns to service method. 
     * 
     * @return
     * 	   Returns vehicle list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Vehicle> retrieveVehicles() throws DatabaseException {
        try {
            Session session = getSession();
            List<Vehicle> vehicles = session.createQuery("from Vehicle").list();
            return vehicles;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cant retrieve vehicle list Kindly check your input and try again...", exp);
        }
    }
    
    /**
     * To add the vehicle detail into database by using session.
     * 
     * @param vehicle
     *     Its object from service method.It contains the vehicle detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addVehicle(Vehicle vehicle) throws DatabaseException {
        try {
            getSession().save(vehicle);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in vehicle", exp);
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
    public void removeVehicle(int vehicleId) throws DatabaseException {
        try {
            Session session = getSession();
            Vehicle vehicle = (Vehicle) session.load(Vehicle.class, vehicleId);
            session.delete(vehicle);
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in remove the vehicle details in vehicle", exp);
        } 
    }
}
