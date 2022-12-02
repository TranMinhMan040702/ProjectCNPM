package dao;

import entity.RegistrationPeriod;
import entity.User;
import models.RegistrationPeriodModel;
import models.UserModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.apache.commons.beanutils.BeanUtils;

import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class RegistrationPeriodDAO implements IRegistrationPeriodDAO{

    public List<RegistrationPeriodModel> getAll() {
        List<RegistrationPeriodModel> registrationPeriodModelList = new ArrayList<>();
        List<RegistrationPeriod> registrationPeriodList = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<RegistrationPeriod> criteriaQuery = builder.createQuery(RegistrationPeriod.class);
            criteriaQuery.from(RegistrationPeriod.class);
            registrationPeriodList = session.createQuery(criteriaQuery).getResultList();
            for(RegistrationPeriod s: registrationPeriodList){
                RegistrationPeriodModel registrationPeriodModel = new RegistrationPeriodModel();
                BeanUtils.copyProperties(registrationPeriodModel, s);
                registrationPeriodModelList.add(registrationPeriodModel);
            }
            return registrationPeriodModelList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public void create(RegistrationPeriodModel registrationPeriodModel){
        RegistrationPeriod registrationPeriod = new RegistrationPeriod();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(registrationPeriod, registrationPeriodModel);
            transaction = session.beginTransaction();

            session.save(registrationPeriod);
            System.out.println("aaa");
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
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            RegistrationPeriod registrationPeriod = session.get(RegistrationPeriod.class, Id);
            if (registrationPeriod != null) {
                session.delete(registrationPeriod);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


}