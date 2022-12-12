package service;

import dao.MemberCouncilDAO;
import entity.MemberCouncil;
import models.MemberCouncilModel;
import models.UserModel;

import java.util.List;

public class MemBerCouncilService {

    public void create(MemberCouncilModel memberCouncilModel) {
        MemberCouncilDAO memberCouncilDAO = new MemberCouncilDAO();
        memberCouncilDAO.create(memberCouncilModel);
    }

    public List<MemberCouncilModel> getList(int idCouncil){
        MemberCouncilDAO memberCouncilDAO = new MemberCouncilDAO();
        return memberCouncilDAO.getList(idCouncil);
    }

    public List<MemberCouncilModel> getListSearch(int idCouncil, String search){
        MemberCouncilDAO memberCouncilDAO = new MemberCouncilDAO();
        return memberCouncilDAO.getListSearch(idCouncil, search);
    }
    public int count(int id)
    {
        MemberCouncilDAO memberCouncilDAO = new MemberCouncilDAO();
        return memberCouncilDAO.count(id);
    }
    public void delete(int id)
    {
        MemberCouncilDAO memberCouncilDAO = new MemberCouncilDAO();
        memberCouncilDAO.delete(id);
    }
    public int check(int idCouncil, String username){
        MemberCouncilDAO memberCouncilDAO = new MemberCouncilDAO();
        return memberCouncilDAO.check(idCouncil, username);
    }
    public void deleteAll(int idCouncil)
    {
        MemberCouncilDAO memberCouncilDAO = new MemberCouncilDAO();
        memberCouncilDAO.deleteAll(idCouncil);
    }

}
