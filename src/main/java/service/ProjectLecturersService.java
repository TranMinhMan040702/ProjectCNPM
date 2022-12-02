package service;

import dao.ProjectLecturersDAO;
import entity.ProjectLecturers;
import models.ProjectLecturersModel;
import models.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProjectLecturersService implements IProjectLecturersService{

    ProjectLecturersDAO projectLecturersDAO = new ProjectLecturersDAO();

    @Override
    public void create(ProjectLecturersModel projectLecturersModel)
    {
        projectLecturersDAO.create(projectLecturersModel);
    }
    @Override
    public List<ProjectLecturersModel> GetList(String username){
         return projectLecturersDAO.GetList(username);
    }
    @Override
    public List<ProjectLecturersModel> GetListDepartment(String department){
        return projectLecturersDAO.GetListDepartment(department);
    }
    public ProjectLecturersModel getUser(int user)
    {
        return projectLecturersDAO.get(user);
    }
    public void update(ProjectLecturersModel projectLecturersModel){
        projectLecturersDAO.update(projectLecturersModel);
    }
}
