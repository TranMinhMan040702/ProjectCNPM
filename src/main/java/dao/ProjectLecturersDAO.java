package dao;

import entity.ProjectLecturers;
import entity.User;
import models.ProjectLecturersModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectLecturersDAO implements IProjectLecturersDAO{
    @Override
    public void create(ProjectLecturersModel projectLecturersModel){
        ProjectLecturers projectLecturers = new ProjectLecturers();
        Transaction transaction = null;

        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(projectLecturers, projectLecturersModel);
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

    public ProjectLecturersModel get() {
        int user = 2;
        ProjectLecturersModel projectLecturersModel = new ProjectLecturersModel();
        ProjectLecturers projectLecturers = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            projectLecturers = session.get(ProjectLecturers.class, user);
            BeanUtils.copyProperties(projectLecturersModel, projectLecturers);
            System.out.println("111111");
            return  projectLecturersModel;

        } catch (Exception e) {
            System.out.println("222222");
            e.printStackTrace();
        }
        return null;
    }
}
