package dao;

import entity.ProjectStudent;
import entity.RegistrationPeriod;
import models.ProjectStudentModel;
import models.RegistrationPeriodModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class BrowseProjectDAO implements IBrowseProjectDAO {
    @Override
    public void update(ProjectStudent projectStudent) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(projectStudent);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public ProjectStudentModel get(int Id) {
        ProjectStudentModel projectStudentModel = new ProjectStudentModel();
        ProjectStudent projectStudent = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            projectStudent = session.get(ProjectStudent.class, Id);
            BeanUtils.copyProperties(projectStudentModel, projectStudent);
            return  projectStudentModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
