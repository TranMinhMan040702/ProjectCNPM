package dao;

import entity.*;
import models.*;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IUserService;
import service.UserService;
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
    //@Override
//    public ProjectStudentModel get(String username) {
//        ProjectStudentModel projectStudentModel = new ProjectStudentModel();
//        ProjectStudent projectStudent = new ProjectStudent();
//        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//
//            projectStudent = session.get(ProjectStudent.class, username);
//            BeanUtils.copyProperties(projectStudentModel, projectStudent);
//            return  projectStudentModel;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @Override
    public ProjectStudentModel getProjectbyUserName(String username) {
        IUserService userService = new UserService();
        ProjectStudentModel projectStudentModel = new ProjectStudentModel();
        ProjectStudent projectStudent = new ProjectStudent();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query q1 = session.createQuery("from ProjectStudent where user.username like :username ");
            q1.setParameter("username",  username );
            projectStudent = (ProjectStudent) q1.getSingleResult();

            BeanUtils.copyProperties(projectStudentModel, projectStudent);
            UserModel userModel = userService.getUser(username);
            User user = new User();
            BeanUtils.copyProperties(user, userModel);
            projectStudentModel.setUser(user);
            return projectStudentModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // Lấy nhung model Hoi dong có lead này
    public List<CouncilModel> GetListProjectReview(String username) {
        Transaction transaction = null;
        List<CouncilModel> councilModels = new ArrayList<>();
        List<Council> councils = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select proj From Council as proj Where proj.leader.username = :username";
            councils = session.createQuery(hql).setParameter("username", username).getResultList();
            for(Council coun: councils)
            {
                CouncilModel councilModel = new CouncilModel();
                BeanUtils.copyProperties(councilModel, coun);
                councilModels.add(councilModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return councilModels;
    }
}
