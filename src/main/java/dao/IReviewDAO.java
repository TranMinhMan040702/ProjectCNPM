package dao;

import entity.ProjectStudent;
import models.CouncilModel;

import models.ProjectStudentModel;

import java.util.List;

public interface IReviewDAO {
    void update(ProjectStudent projectStudent);
    ProjectStudentModel getProjectbyUserName(String username); // Lấy nhung model Hoi dong có lead này

    List<CouncilModel> GetListProjectReview(String username);
    ProjectStudentModel get(int Id);
}
