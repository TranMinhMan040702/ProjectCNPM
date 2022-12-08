package service;

import entity.ProjectStudent;
import models.ProjectStudentModel;

import java.util.List;

public interface IReviewService {
    List<ProjectStudentModel> GetList(String username);

    void update(ProjectStudent projectStudent);

    ProjectStudentModel get(int Id);
}
