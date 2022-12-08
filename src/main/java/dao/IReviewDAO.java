package dao;

import entity.ProjectStudent;
import models.ProjectStudentModel;

import java.util.List;

public interface IReviewDAO {
    void update(ProjectStudent projectStudent);

    ProjectStudentModel get(int Id);

    List<ProjectStudentModel> GetListProjectReview(String username);
}
