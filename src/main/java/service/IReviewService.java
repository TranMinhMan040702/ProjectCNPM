package service;

import entity.ProjectStudent;

import models.CouncilModel;

import models.ProjectStudentModel;

import java.util.List;

public interface IReviewService {

    void update(ProjectStudent projectStudent);

    ProjectStudentModel getByProject(String username);

    List<CouncilModel> GetListCouncil(String username);
}
