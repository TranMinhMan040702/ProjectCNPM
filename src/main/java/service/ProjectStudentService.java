package service;

import dao.ProjectStudentDAO;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;

import java.util.List;

public class ProjectStudentService implements IProjectStudentService {
    @Override
    public List<ProjectStudentModel> GetList(String department){
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        return projectStudentDAO.GetList(department);
    }
    public void create(ProjectStudentModel projectStudentModel)
    {
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        projectStudentDAO.create(projectStudentModel);
    }
    public ProjectStudentModel Get(String user){
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        return projectStudentDAO.Get(user);
    }
}
