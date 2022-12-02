package service;

import models.ProjectLecturersModel;

import java.util.List;

public interface IProjectLecturersService {
    void create(ProjectLecturersModel projectLecturersModel);
    List<ProjectLecturersModel> GetList(String username);
    List<ProjectLecturersModel> GetListDepartment(String department);
}
