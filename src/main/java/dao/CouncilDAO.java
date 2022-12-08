package dao;

import entity.Council;
import entity.RegistrationPeriod;
import entity.User;
import models.CouncilModel;
import models.RegistrationPeriodModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
    public List<CouncilModel> getAll() {
        List<CouncilModel> councilModels = new ArrayList<>();
        List<Council> councils = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Council> criteriaQuery = builder.createQuery(Council.class);
            criteriaQuery.from(Council.class);
            councils = session.createQuery(criteriaQuery).getResultList();
            for(Council s: councils){
                CouncilModel councilModel = new CouncilModel();
                BeanUtils.copyProperties(councilModel, s);
                councilModels.add(councilModel);
            }

            return councilModels;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
