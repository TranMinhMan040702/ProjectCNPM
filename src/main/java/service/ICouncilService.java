package service;

import dao.CouncilDAO;
import models.CouncilModel;

import java.util.List;

public interface ICouncilService {
    List<CouncilModel> ListCouncil();
}
