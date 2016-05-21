/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Make;
import pojo.Model;
import pojo.ServiceProvider;
import pojo.TrackingTypes;
import pojo.Trim;
import pojo.Type;
import pojo.VehicleModel;

/**
 *
 * @author Mohammed
 */
public class TrimDao {
        private final SessionFactory factory;

    public TrimDao(SessionFactory factory) {
        this.factory = factory;
    }

    public Trim getById(int id) {
        Session session = factory.openSession();

        Trim t = (Trim) session.createQuery("SELECT t FROM Trim t WHERE t.id = :id").setInteger("id", id).uniqueResult();
        session.close();
        return t;
    }
    
    public Trim getByName(String name) {
        Session session = factory.openSession();

        Trim t = (Trim) session.createQuery("SELECT t FROM Trim t WHERE t.name = :name").setString("name", name).uniqueResult();
        session.close();
        return t;
    }
    

  
           public Trim getByVehicleModel(VehicleModel vehicleModel) {
        Session session = factory.openSession();

            Trim t =  (Trim) session.createQuery("SELECT t FROM VehicleModel vm ,Trim t WHERE vm.id = :id and vm.trim = t ").setInteger("id", vehicleModel.getId()).uniqueResult();
        session.close();
        return  t;
    }
}
