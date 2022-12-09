package dao;

import entity.MemberCouncil;
import entity.ProjectLecturers;
import entity.ProjectStudent;
import models.CouncilModel;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements IReviewDAO {
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
    @Override
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

    @Override
    public List<ProjectStudentModel> GetListProjectReview(String username) {
        Transaction transaction = null;
        List<ProjectStudentModel> projectStudentModels = new ArrayList<>();
        List<ProjectStudent> projectStudents = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
<<<<<<< Updated upstream
            String hql = "Select proj From ProjectStudent as proj Where proj.council.lead.user.username = :username";
=======
            String hql = "Select proj From ProjectStudent as proj Where proj.council..user.username = :username";
>>>>>>> Stashed changes
            projectStudents = session.createQuery(hql).setParameter("username", username).getResultList();
            for(ProjectStudent proj: projectStudents)
            {
                ProjectStudentModel projmodel = new ProjectStudentModel();
                BeanUtils.copyProperties(projmodel, proj);
                projectStudentModels.add(projmodel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectStudentModels;
    }
}
