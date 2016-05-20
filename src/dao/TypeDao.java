/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.MeasuringUnit;
import pojo.Service;
import pojo.TrackingTypes;
import pojo.Type;

/**
 *
 * @author Mohammed
 */
public class TypeDao {

    private final SessionFactory factory;

    public TypeDao(SessionFactory factory) {
        this.factory = factory;
    }

    public Type getById(int id) {
        Session session = factory.openSession();

        Type t = (Type) session.createQuery("SELECT t FROM Type t WHERE t.id = :id").setInteger("id", id).uniqueResult();
        session.close();
        return t;
    }

    public List<Type> getByMeasuringUnit(MeasuringUnit measuringUnit) {
        Session session = factory.openSession();

        List<Type> list = session.createQuery("SELECT t FROM Type t WHERE t.measuringUnit.id = :id").setInteger("id", measuringUnit.getId()).list();
        session.close();
        return list;
    }

    public List<Type> getByService(Service service) {
        Session session = factory.openSession();

        List<Type> list = session.createQuery("SELECT t FROM Type t WHERE t.service = :id").setInteger("id", service.getId()).list();
        session.close();
        return list;
    }

    public Type getByTrackingType(TrackingTypes trackingType) {
        Session session = factory.openSession();

        Type t = (Type) session.createQuery("SELECT t FROM Type t,TrackingTypes tt WHERE tt.id = :id and tt.type = t").setInteger("id", trackingType.getId()).uniqueResult();
        session.close();
        return t;
    }

}
