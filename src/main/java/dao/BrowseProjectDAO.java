package dao;

import entity.ProjectStudent;
import entity.User;
import models.ProjectStudentModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

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
    public List<ProjectStudentModel> getAll() {
        List<ProjectStudentModel> projectStudentModels = new ArrayList<>();
        List<ProjectStudent> projectStudents = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProjectStudent> criteriaQuery = builder.createQuery(ProjectStudent.class);
            criteriaQuery.from(ProjectStudent.class);
            projectStudents = session.createQuery(criteriaQuery).getResultList();
            for(ProjectStudent pro: projectStudents){
                ProjectStudentModel projectStudentModel = new ProjectStudentModel();
                BeanUtils.copyProperties(projectStudentModels, pro);
                projectStudentModels.add(projectStudentModel);
            }
            return projectStudentModels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}