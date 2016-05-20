/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Exceptions.DataAccessLayerException;
import abstractDao.AbstractDao;
import java.util.List;
import pojo.User;

/**
 *
 * @author Ehab
 */
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }

    @Override
    public void create(User u) throws DataAccessLayerException {
        super.create(u);
    }

    public List<User> findAll() {
        return super.findAll(User.class); //To change body of generated methods, choose Tools | Templates.
    }

    public User find(Long id) {
        return super.find(User.class, id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User t) {
        super.delete(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrUpdate(User t) {
        super.saveOrUpdate(t); //To change body of generated methods, choose Tools | Templates.
    }

}
