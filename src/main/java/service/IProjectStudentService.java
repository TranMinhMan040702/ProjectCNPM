package service;

import models.ProjectLecturersModel;
import models.ProjectStudentModel;

import java.util.List;

public interface IProjectStudentService {
    List<ProjectStudentModel> GetList(String department);
}
