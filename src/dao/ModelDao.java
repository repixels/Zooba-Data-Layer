/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import abstractDao.HibernateFactory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Make;
import pojo.Model;

/**
 *
 * @author yoka
 */
public class ModelDao {
Session session;
    public ModelDao() {
     session=HibernateFactory.openSession();
    }
     public List<Model> getMakeByName(String name)
    {
;    Criteria crt=session.createCriteria(Model.class).add(Restrictions.like("name", "%"+name+"%"));
    List<Model> lst=crt.list();
 
    return lst;
    
    }
     public List<Model> getMakeByNiceName(String niceName)
    {
    Criteria crt=session.createCriteria(Model.class).add(Restrictions.like("nicename", "%"+niceName+"%"));
    List<Model> lst=crt.list();
   
    return lst;
    
    }
     public List<Model> getModelsByMake(String make)
     {
     Criteria crt=session.createCriteria(Model.class,"model").
             createAlias("model.make", "make")
            . add(Restrictions.like("make.name", "%"+make+"%"));
    List<Model> lst=crt.list();
    return lst;
     }
     
      public List<Model> getModelsByVechileModelYear(String year)
     {
     Criteria crt=session.createCriteria(Model.class,"model").
             createAlias("model.vehicleModels", "vModel")
            .createAlias("vModel.year", "year")
             . add(Restrictions.like("year.name", "%"+year+"%"));
    List<Model> lst=crt.list();
    return lst;
     }
       public List<Model> getModelsByVechileModelTrim(String trim)
     {
     Criteria crt=session.createCriteria(Model.class,"model").
             createAlias("model.vehicleModels", "vModel")
            .createAlias("vModel.trim", "trim")
             . add(Restrictions.like("trim.name", "%"+trim+"%"));
    List<Model> lst=crt.list();
    return lst;
     }
}
