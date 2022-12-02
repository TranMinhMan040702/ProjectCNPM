package service;

import dao.ProjectStudentDAO;
import entity.ProjectStudent;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import models.RegistrationPeriodModel;
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

    public List<ProjectStudentModel> getAll() {
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        return projectStudentDAO.getAll();
    }
    public ProjectStudentModel getStudent(int ID) {
        ProjectStudentModel projectStudentModel = new ProjectStudentModel();
        ProjectStudent projectStudent = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            projectStudent = session.get(ProjectStudent.class, ID);
            BeanUtils.copyProperties(projectStudentModel, projectStudent);
            return  projectStudentModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
