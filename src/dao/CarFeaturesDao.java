/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.CarFeatures;
import pojo.ModelFeaturesValues;
import pojo.VehicleModel;
import pojo.Year;

/**
 *
 * @author Mohammed
 */
public class CarFeaturesDao {
    private final SessionFactory factory;
    
        public CarFeaturesDao(SessionFactory factory) {
        this.factory = factory;
    }
    public CarFeatures  getById(int id) {
        Session session = factory.openSession();

        CarFeatures cf = (CarFeatures) session.createQuery("SELECT cf FROM CarFeatures cf WHERE cf.id = :id").setInteger("id", id).uniqueResult();
        session.close();
        return cf;
    }

    public CarFeatures getByName(String name) {
        Session session = factory.openSession();

        CarFeatures cf = (CarFeatures) session.createQuery("SELECT cf FROM CarFeatures cf WHERE cf.name = :name").setString("name", name).uniqueResult();
        session.close();
        return cf;
    }
    
    public CarFeatures getByModelFeaturesValues(ModelFeaturesValues modelFeaturesValues) {
        Session session = factory.openSession();

        CarFeatures cf = (CarFeatures) session.createQuery("SELECT cf FROM CarFeatures cf ,ModelFeaturesValues mfv WHERE mfv.id = :id and mfv.carFeatures = cf").setInteger("id", modelFeaturesValues.getId()).uniqueResult();
        session.close();
        return cf;
    }

}
