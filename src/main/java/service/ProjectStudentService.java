package service;

import dao.ProjectStudentDAO;
import entity.ProjectStudent;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import utils.HibernateUtils;


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

    public List<ProjectStudentModel> GetListByStatusArgument(String StatusArgument, String status){
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        return projectStudentDAO.GetListByStatusArgument(StatusArgument, status);
    }
    public ProjectStudentModel getStudent(int id) {
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        return projectStudentDAO.getById(id);
    }
    public void update(ProjectStudentModel projectStudentModel) {
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        projectStudentDAO.update(projectStudentModel);
    }
}
