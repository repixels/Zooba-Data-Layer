/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Type;
import pojo.VehicleModel;
import pojo.Year;

/**
 *
 * @author Mohammed
 */
public class YearDao {
    
        private final SessionFactory factory;

    public YearDao(SessionFactory factory) {
        this.factory = factory;
    }
    public Year getById(int id) {
        Session session = factory.openSession();

        Year y = (Year) session.createQuery("SELECT y FROM Year y WHERE y.id = :id").setInteger("id", id).uniqueResult();
        session.close();
        return y;
    }

    public Year getByName(String name) {
        Session session = factory.openSession();

        Year y = (Year) session.createQuery("SELECT y FROM Year y WHERE y.name = :name").setString("name", name).uniqueResult();
        session.close();
        return y;
    }
    
    public Year getByVehicleModel(VehicleModel vehicleModel) {
        Session session = factory.openSession();

        Year y = (Year) session.createQuery("SELECT y FROM Year y ,VehicleModel vm WHERE VM.id = :id and vm.year = y").setInteger("id", vehicleModel.getId()).uniqueResult();
        session.close();
        return y;
    }

    
}
