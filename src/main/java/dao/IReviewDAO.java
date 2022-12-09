package dao;

import entity.ProjectStudent;
import models.CouncilModel;
import models.ProjectStudentModel;

import java.util.List;

public interface IReviewDAO {
    void update(ProjectStudent projectStudent);

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
    ProjectStudentModel getProjectbyUserName(String username); // Lấy nhung model Hoi dong có lead này

    List<CouncilModel> GetListProjectReview(String username);
}
