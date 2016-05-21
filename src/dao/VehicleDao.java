/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Exceptions.DataAccessLayerException;
import abstractDao.AbstractDao;
import java.util.List;
import pojo.Vehicle;

/**
 *
 * @author Ehab
 */
public class VehicleDao extends AbstractDao<Vehicle>{
    
    public VehicleDao() {
        super(Vehicle.class);
    }

    @Override
    protected List<Vehicle> findAll(Class clazz)throws DataAccessLayerException{
        return super.findAll(clazz); //To change body of generated methods, choose Tools | Templates.
    }

    
    protected Vehicle find(Long id) throws DataAccessLayerException{
        return super.find(Vehicle.class, id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void delete(Vehicle t) throws DataAccessLayerException{
        super.delete(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void create(Vehicle t) throws DataAccessLayerException{
        super.create(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Vehicle> findByExample(Vehicle t) {
        return super.findByExample(t); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
