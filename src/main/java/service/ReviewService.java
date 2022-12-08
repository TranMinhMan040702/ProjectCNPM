package service;

import dao.ProjectLecturersDAO;
import dao.ProjectStudentDAO;
import dao.ReviewDAO;
import entity.ProjectStudent;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;

import java.util.List;

public class ReviewService implements IReviewService {
    ReviewDAO reviewDAO = new ReviewDAO();
    @Override
    public List<ProjectStudentModel> GetList(String username){
        return reviewDAO.GetListProjectReview(username);
    }

    @Override
    public void update(ProjectStudent projectStudent){
        reviewDAO.update(projectStudent);
    }

    @Override
    public ProjectStudentModel get(int Id){
        ReviewDAO reviewDAO = new ReviewDAO();
        return reviewDAO.get(Id);
    }
}
