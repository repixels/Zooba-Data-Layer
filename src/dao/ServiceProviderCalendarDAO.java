/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import pojo.Coordinates;
import pojo.Days;
import pojo.ServiceProvider;
import pojo.ServiceProviderCalendar;

/**
 *
 * @author Ehab
 */
public class ServiceProviderCalendarDAO
{
    private static SessionFactory factory;

    public ServiceProviderCalendarDAO()
    {
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
    
    public ArrayList<ServiceProvider> getServiceProvidersByDay(Days day)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List serviceProviders = new ArrayList<ServiceProvider>();
        try
        {
           tx = session.beginTransaction();
           Criteria cr = session.createCriteria(ServiceProviderCalendar.class);
           // Add restriction.
           cr.add(Restrictions.eq("days", day));
           serviceProviders = cr.list();
           tx.commit();
        }
        catch (HibernateException e)
        {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }
        finally
        {
           session.close(); 
        }
        
        return (ArrayList<ServiceProvider>) serviceProviders;
    }
    
    public ArrayList<ServiceProvider> getServiceProvidersByStartingHours(Date startingHour)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List serviceProviders = new ArrayList<ServiceProvider>();
        try
        {
           tx = session.beginTransaction();
           Criteria cr = session.createCriteria(ServiceProviderCalendar.class);
           // Add restriction.
           cr.add(Restrictions.eq("startingHour", startingHour));
           serviceProviders = cr.list();
           tx.commit();
        }
        catch (HibernateException e)
        {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }
        finally
        {
           session.close(); 
        }
        
        return (ArrayList<ServiceProvider>) serviceProviders;
    }
    
    public ArrayList<ServiceProvider> getServiceProvidersByEndingHours(Date endingHour)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List serviceProviders = new ArrayList<ServiceProvider>();
        try
        {
           tx = session.beginTransaction();
           Criteria cr = session.createCriteria(ServiceProviderCalendar.class);
           // Add restriction.
           cr.add(Restrictions.eq("endingHour", endingHour));
           serviceProviders = cr.list();
           tx.commit();
        }
        catch (HibernateException e)
        {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }
        finally
        {
           session.close(); 
        }
        
        return (ArrayList<ServiceProvider>) serviceProviders;
    }
    
    public ArrayList<ServiceProvider> getServiceProviderByWorkingHours(Days day, Date startingHour, Date endingHour)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List serviceProviders = new ArrayList<ServiceProvider>();
        try
        {
           tx = session.beginTransaction();
           Criteria cr = session.createCriteria(ServiceProviderCalendar.class);
           // Add restriction.
           cr.add(Restrictions.eq("days", day));
           cr.add(Restrictions.eq("startingHour", startingHour));
           cr.add(Restrictions.eq("endingHour", endingHour));
           serviceProviders = cr.list();
           tx.commit();
        }
        catch (HibernateException e)
        {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }
        finally
        {
           session.close(); 
        }
        
        return (ArrayList<ServiceProvider>) serviceProviders;
    }
    
    public ArrayList<Days> getDaysForServiceProvider(ServiceProvider serviceProvider)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        List days = new ArrayList<ServiceProvider>();
        try
        {
           tx = session.beginTransaction();
           Criteria cr = session.createCriteria(ServiceProviderCalendar.class);
           // Add restriction.
           cr.add(Restrictions.eq("serviceProvider", serviceProvider));
           days = cr.list();
           tx.commit();
        }
        catch (HibernateException e)
        {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }
        finally
        {
           session.close(); 
        }
        
        return (ArrayList<Days>) days;
    }
    
}
