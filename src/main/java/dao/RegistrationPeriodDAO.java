package dao;

import entity.RegistrationPeriod;
import models.RegistrationPeriodModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.apache.commons.beanutils.BeanUtils;

import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistrationPeriodDAO implements IRegistrationPeriodDAO{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public void create(RegistrationPeriodModel registrationPeriodModel){
        RegistrationPeriod registrationPeriod = new RegistrationPeriod();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(registrationPeriod, registrationPeriodModel);
            transaction = session.beginTransaction();

            session.save(registrationPeriod);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public RegistrationPeriodModel get(int Id) {
        RegistrationPeriodModel registrationPeriodModel = new RegistrationPeriodModel();
        RegistrationPeriod registrationPeriod = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            registrationPeriod = session.get(RegistrationPeriod.class, Id);
            BeanUtils.copyProperties(registrationPeriodModel, registrationPeriod);
            return  registrationPeriodModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(RegistrationPeriod registrationPeriod) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(registrationPeriod);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(int Id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query query = session.createQuery("DELETE FROM RegistrationPeriod c where c.id = :Id");
            query.setParameter("Id", Id);
            int rowsDeleted = query.executeUpdate();
            System.out.println("entities deleted: " + rowsDeleted);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
