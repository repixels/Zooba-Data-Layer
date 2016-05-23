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
import pojo.ModelFeaturesValues;
import pojo.VehicleModel;

/**
 *
 * @author yoka
 */
public class ModelFeatureValueDao extends AbstractDao<ModelFeaturesValues> {

    Session session;

    public ModelFeatureValueDao() {
        super(ModelFeaturesValues.class);
        session = HibernateFactory.openSession();
    }

    public List<ModelFeaturesValues> getMFValuesByCarFeature(String carFeatureName) {
        Criteria crt = session.createCriteria(ModelFeaturesValues.class, "modelf").
                createAlias("modelf.carFeatures", "carFeatures")
                .add(Restrictions.like("carFeatures.name", "%" + carFeatureName + "%"));
        List<ModelFeaturesValues> lst = crt.list();

        return lst;
    }

    public List<ModelFeaturesValues> getMFValuesByByVehicleModel(VehicleModel vModel) {
        Criteria crt = session.createCriteria(ModelFeaturesValues.class, "modelf").
                createAlias("modelf.vehicleModels", "vModel")
                .add(Restrictions.eq("vModel.model", vModel));
        List<ModelFeaturesValues> lst = crt.list();

        return lst;
    }

    public List<ModelFeaturesValues> getMFValuesByByCarFeatureAndVehicleModel(VehicleModel vmodel, String carFeatureName) {
        Criteria crt = session.createCriteria(ModelFeaturesValues.class, "modelf").
                createAlias("modelf.vehicleModels", "vModel")
                .add(Restrictions.eq("vModel.model", vmodel))
                .createAlias("modelf.carFeatures", "carFeatures")
                .add(Restrictions.like("carFeatures.name", "%" + carFeatureName + "%"));;
        List<ModelFeaturesValues> lst = crt.list();

        return lst;
    }
}
