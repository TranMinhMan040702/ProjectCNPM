package dao;

import com.fasterxml.jackson.databind.util.BeanUtil;
import entity.User;
import models.LoginModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtils;

public class UserDAO implements IUserDAO{
    @Override
    public LoginModel login(String username, String password) {
        LoginModel loginModel = new LoginModel();
        User user = new User();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query q1 = session.createQuery("from User where username like :s1 and password like :s2");
            q1.setParameter("s1",  username );
            q1.setParameter("s2", password);
            user = (User) q1.getSingleResult();
            BeanUtils.copyProperties(loginModel, user);
            return loginModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
