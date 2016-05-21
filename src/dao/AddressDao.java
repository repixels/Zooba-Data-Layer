/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Exceptions.DataAccessLayerException;
import abstractDao.AbstractDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.Address;


/**
 *
 * @author Riham
 */
public class AddressDao extends AbstractDao{
     private static SessionFactory factory;
    public AddressDao() {
        super(Address.class);
        try
        {
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex)
        { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
        }
    }
   
    public void create(Address a) throws DataAccessLayerException {
        super.create(a);
    }
    
    public void delete(Address a) {
        super.delete(a); 
    }
     
    public List<Address> findAll() {
        return super.findAll(Address.class); 
    }
    
    public Address find(Long id) {
        return (Address) super.find(Address.class, id); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void saveOrUpdate(Address a) {
        super.saveOrUpdate(a); 
    }
    
    public Address findByServiceprovider(String name)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        String hql = "FROM Address A join A.serviceProvider S where A.id=S.address.id and S.name=?";
        Query query=session.createQuery(hql).setString(0,name);
        Address address= new Address();
        Iterator itr=query.list().iterator();
        while(itr.hasNext())
        {
            Object[] p=(Object[])itr.next();
             address=(Address)p[0];
        }
        return address;
    }
    
    public List<Address> findAddressByCountry(String country)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Address> address=new ArrayList();
        String hql="From Address A  where A.country=?";
        Query query=session.createQuery(hql).setString(0, country);
        address=query.list();
        return address;
    }
    public List<Address> findAddressByCity(String city)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Address> address=new ArrayList();
        String hql="From Address A  where A.city=?";
        Query query=session.createQuery(hql).setString(0, city);
        address=query.list();
        return address;
    }
    public List<Address> findAddressByStreet(String street)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Address> address=new ArrayList();
        String hql="From Address A  where A.street=?";
        Query query=session.createQuery(hql).setString(0, street);
        address=query.list();
        return address;
    }
    
    public List<Address> findAddressByLandmark(String landmark)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Address> address=new ArrayList();
        String hql="From Address A  where A.landmark=?";
        Query query=session.createQuery(hql).setString(0, landmark);
        address=query.list();
        return address;
    }
    
    public Address findAddressByPostalcode(String postalcode)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        Address address=new Address();
        String hql="From Address A  where A.postalCode=?";
        Query query=session.createQuery(hql).setString(0, postalcode);
        address=(Address) query.uniqueResult();
        return address;
    }
}
