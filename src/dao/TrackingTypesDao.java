/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.TrackingData;
import pojo.TrackingTypes;
import pojo.Type;

/**
 *
 * @author Mohammed
 */



public class TrackingTypesDao {
    private final SessionFactory factory;

    public TrackingTypesDao(SessionFactory factory) {
        this.factory = factory ;
    }
 
    
    
    public TrackingTypes getById(int id){
        Session session=factory.openSession();
        
         TrackingTypes t = (TrackingTypes) session.createQuery("SELECT t FROM TrackingTypes t WHERE t.id = :id").setInteger("id", id).uniqueResult();
         session.close();
        return t;
    }
    
    public TrackingTypes getByValue(String value){
        Session session=factory.openSession();
        return  (TrackingTypes) session.createQuery("SELECT t FROM TrackingTypes t WHERE t.value = :value").setString("value", value).uniqueResult();
        
    }

    public TrackingTypes getByType(Type type){
        Session session=factory.openSession();
        TrackingTypes t = (TrackingTypes) session.createQuery("SELECT  tt FROM TrackingTypes tt ,Type t WHERE tt.type.id = :id").setInteger("id", type.getId()).uniqueResult();
        session.close();
        return t;
    }

    public TrackingTypes getByTrackingData(TrackingData trackingData){
   
         Session session=factory.openSession();
        
         TrackingTypes t = (TrackingTypes) session.createQuery("SELECT  tt FROM TrackingTypes tt ,TrackingData td WHERE tt.trackingData.id = :id").setInteger("id", trackingData.getId()).uniqueResult();
         session.close();
        return t;
    }

}
