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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ProjectLecturers projectLecturers = session.get(ProjectLecturers.class, id);
            if (projectLecturers != null) {
                session.delete(projectLecturers);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public ProjectLecturersModel get(int user) {
        ProjectLecturersModel projectLecturersModel = new ProjectLecturersModel();
        ProjectLecturers projectLecturers = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            projectLecturers = session.get(ProjectLecturers.class, user);
            BeanUtils.copyProperties(projectLecturersModel, projectLecturers);
            return  projectLecturersModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(ProjectLecturersModel projectLecturersModel) {
        Transaction transaction = null;
        ProjectLecturers projectLecturers = new ProjectLecturers();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BeanUtils.copyProperties(projectLecturers, projectLecturersModel);
            session.update(projectLecturers);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<ProjectLecturersModel> GetList(String username) {
        Transaction transaction = null;
        List<ProjectLecturersModel> projectLecturersModels = new ArrayList<>();
        List<ProjectLecturers> projectLecturers = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select p From ProjectLecturers as p Where p.user.username = :username";
            projectLecturers = session.createQuery(hql).setParameter("username", username).getResultList();
            for(ProjectLecturers projectLecturers1: projectLecturers)
            {
                ProjectLecturersModel p = new ProjectLecturersModel();
                BeanUtils.copyProperties(p, projectLecturers1);
                projectLecturersModels.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectLecturersModels;
    }

    public List<ProjectLecturersModel> GetListDepartment(String department) {
        Transaction transaction = null;
        List<ProjectLecturersModel> projectLecturersModels = new ArrayList<>();
        List<ProjectLecturers> projectLecturers = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select p From ProjectLecturers as p Where p.department = :department";
            projectLecturers = session.createQuery(hql).setParameter("department", department).getResultList();
            for(ProjectLecturers projectLecturers1: projectLecturers)
            {
                ProjectLecturersModel p = new ProjectLecturersModel();
                BeanUtils.copyProperties(p, projectLecturers1);
                projectLecturersModels.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectLecturersModels;
    }

    public static void main(String[] args) {
        ProjectLecturersDAO projectLecturersDAO = new ProjectLecturersDAO();
        List<ProjectLecturersModel> projectLecturersModel = projectLecturersDAO.GetListDepartment("Công nghệ thông tin");
        for(ProjectLecturersModel p : projectLecturersModel){
            System.out.println(p.getUser().getFullname());
        }

    }
}
