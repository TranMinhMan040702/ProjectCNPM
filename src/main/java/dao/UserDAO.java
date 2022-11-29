package dao;

import entity.User;
import models.LoginModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    @Override
    public void create(UserModel userModel) {
        User user = new User();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(user, userModel);
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public UserModel get(String username) {
        UserModel userModel = new UserModel();
        User user = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            user = session.get(User.class, username);
            BeanUtils.copyProperties(userModel, user);
            return  userModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(UserModel user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.update(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
