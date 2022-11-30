package dao;

import entity.ProjectStudent;
import models.ProjectStudentModel;
import models.RegistrationPeriodModel;

public interface IBrowseProjectDAO {
    void update(ProjectStudent projectStudent);
    ProjectStudentModel get(int Id);
}
