package service;

import entity.ProjectStudent;

import models.CouncilModel;

import models.ProjectStudentModel;

import java.util.List;

public interface IReviewService {
    List<CouncilModel> GetListCouncil(String username);

    void update(ProjectStudent projectStudent);

    ProjectStudentModel getByProject(String username);
    List<ProjectStudentModel> GetList(String username);
}
