package dao;

import entity.ProjectLecturers;
import entity.ProjectStudent;
import entity.RegistrationPeriod;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import models.RegistrationPeriodModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.ProjectStudentService;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class ProjectStudentDAO implements IProjectStudentDAO{
    @Override
    public List<ProjectStudentModel> GetList(String department){
        return null;
    }

    public List<ProjectStudentModel> getAll() {
        List<ProjectStudentModel> projectStudentModelList = new ArrayList<>();
        List<ProjectStudent> projectStudentList = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProjectStudent> criteriaQuery = builder.createQuery(ProjectStudent.class);
            criteriaQuery.from(ProjectStudent.class);
            projectStudentList = session.createQuery(criteriaQuery).getResultList();
            for(ProjectStudent s: projectStudentList){
                ProjectStudentModel projectStudentModel = new ProjectStudentModel();
                BeanUtils.copyProperties(projectStudentModel, s);
                projectStudentModelList.add(projectStudentModel);
            }
            return projectStudentModelList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public void create(ProjectStudentModel projectStudentModel){
        ProjectStudent projectStudent = new ProjectStudent();
        Transaction transaction = null;

        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(projectStudent, projectStudentModel);
            transaction = session.beginTransaction();

            session.save(projectStudent);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public ProjectStudentModel Get(String user){
        ProjectStudentModel projectStudentModel = new ProjectStudentModel();
        List<ProjectStudent> projectStudents = null;
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select p From ProjectStudent as p Where p.user.username = :user";
            projectStudents = session.createQuery(hql, ProjectStudent.class).setParameter("user", user).getResultList();
            if(projectStudents != null){
                for(ProjectStudent projectStudent:projectStudents){
                BeanUtils.copyProperties(projectStudentModel, projectStudent);
                return projectStudentModel;}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ProjectStudent projectStudent = session.get(ProjectStudent.class, id);
            if (projectStudent != null) {
                session.delete(projectStudent);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public static void main(String[] args) {
        ProjectStudentService projectStudentService = new ProjectStudentService();
        ProjectStudentModel projectStudentModel = projectStudentService.Get("20110677");
        System.out.println(projectStudentModel);
    }
}
