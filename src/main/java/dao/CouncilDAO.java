package dao;

import entity.Council;
import entity.RegistrationPeriod;
import models.CouncilModel;
import models.RegistrationPeriodModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class CouncilDAO {
    public void create(CouncilModel councilModel){
        Council council = new Council();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(council, councilModel);
            transaction = session.beginTransaction();

            session.save(council);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
