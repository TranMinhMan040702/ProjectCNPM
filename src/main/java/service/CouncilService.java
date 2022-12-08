package service;

import dao.CouncilDAO;
import models.CouncilModel;
import models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class CouncilService implements ICouncilService{
    public List<CouncilModel> ListCouncil(){
        List<CouncilModel> councilModels = new ArrayList<>();
        CouncilDAO councilDAO = new CouncilDAO();
        councilModels = councilDAO.getAll();
        return councilModels;
    }

    public void create(CouncilModel councilModel) {
        CouncilDAO councilDAO = new CouncilDAO();
        councilDAO.create(councilModel);
    }
}
