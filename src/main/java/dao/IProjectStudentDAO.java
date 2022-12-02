package dao;

import models.ProjectStudentModel;

import java.util.List;

public interface IProjectStudentDAO {
    List<ProjectStudentModel> GetList(String department);
}
