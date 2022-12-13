package dao;

import entity.ProjectStudent;
import models.ProjectStudentModel;
import models.UserModel;

import java.util.List;

public interface IBrowseProjectDAO {
    void update(ProjectStudent projectStudent);
    ProjectStudentModel get(int Id);
    List<ProjectStudentModel> getAll(String department);
}