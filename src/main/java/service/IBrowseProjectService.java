package service;

import models.ProjectStudentModel;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IBrowseProjectService {
    void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    List<ProjectStudentModel> getAllProjectStudentModels(String department);
}