package service;

import dao.ProjectLecturersDAO;
import models.ProjectLecturersModel;

public class ProjectLecturersService implements IProjectLecturersService{

    ProjectLecturersDAO projectLecturersDAO = new ProjectLecturersDAO();

    @Override
    public void create(ProjectLecturersModel projectLecturersModel)
    {
        projectLecturersDAO.create(projectLecturersModel);
    }
}
