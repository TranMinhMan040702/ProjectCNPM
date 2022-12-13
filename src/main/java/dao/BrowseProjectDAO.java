package dao;

import entity.MemberCouncil;
import entity.ProjectStudent;
import entity.User;
import models.MemberCouncilModel;
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
    public List<ProjectStudentModel> getAll(String department) {
        Transaction transaction = null;
        List<ProjectStudentModel> projectStudentModels = new ArrayList<>();
        List<ProjectStudent> projectStudents = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select p From ProjectStudent as p Where p.projectLecturers.department = :department ";
            projectStudents = session.createQuery(hql).setParameter("department", department).getResultList();
            for(ProjectStudent projectStudent: projectStudents)
            {
                ProjectStudentModel p = new ProjectStudentModel();
                BeanUtils.copyProperties(p, projectStudent);
                projectStudentModels.add(p);
            }
            return projectStudentModels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        BrowseProjectDAO browseProjectDAO = new BrowseProjectDAO();
        List<ProjectStudentModel> projectStudentModels = browseProjectDAO.getAll("Công nghệ thông tin");
        for(ProjectStudentModel projectStudentModel : projectStudentModels){
            System.out.println(projectStudentModel.getUser().getFullname());
        }
    }
}