package dao;

import entity.ProjectLecturers;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class ProjectLecturersDAO implements IProjectLecturersDAO{
    @Override
    public void create(){
        ProjectLecturers projectLecturers = new ProjectLecturers();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            //BeanUtils.copyProperties(projectLecturers, projectLecturersModel);
            transaction = session.beginTransaction();

            session.save(projectLecturers);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
