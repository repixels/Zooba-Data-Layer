/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import abstractDao.AbstractDao;
import abstractDao.HibernateFactory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.Year;

/**
 *
 * @author yoka
 */
public class YearDao extends AbstractDao<Year> {

    Session session;

    public YearDao() {
        super(Year.class);
        session = HibernateFactory.openSession();
    }

    public List<Year> getYearByModel(String model) {
        Criteria crt = session.createCriteria(Year.class, "year").
                createAlias("year.vehicleModels", "vModel")
                .createAlias("vModel.model", "model")
                .add(Restrictions.like("model.name", "%" + model + "%"));
        List<Year> lst = crt.list();

        return lst;
    }

    public List<Year> getYearByTrim(String trim) {
        Criteria crt = session.createCriteria(Year.class, "year").
                createAlias("year.vehicleModels", "vModel")
                .createAlias("vModel.trim", "trim")
                .add(Restrictions.like("trim.name", "%" + trim + "%"));
        List<Year> lst = crt.list();

        return lst;
    }

    public List<Year> getYearBytrimAndModel(String trim, String model) {
        Criteria crt = session.createCriteria(Year.class, "year").
                createAlias("year.vehicleModels", "vModel")
                .createAlias("vModel.trim", "trim")
                .add(Restrictions.like("trim.name", "%" + trim + "%"))
                .createAlias("vModel.model", "model")
                .add(Restrictions.like("model.name", "%" + model + "%"));

        List<Year> lst = crt.list();

        return lst;
    }
}
