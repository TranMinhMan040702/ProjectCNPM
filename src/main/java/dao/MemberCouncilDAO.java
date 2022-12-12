package dao;

import entity.MemberCouncil;
import entity.User;
import models.MemberCouncilModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class MemberCouncilDAO {
    public void create(MemberCouncilModel memberCouncilModel) {
        MemberCouncil memberCouncil = new MemberCouncil();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(memberCouncil, memberCouncilModel);
            transaction = session.beginTransaction();

            session.save(memberCouncil);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<MemberCouncilModel> getList(int idCouncil) {
        Transaction transaction = null;
        List<MemberCouncilModel> memberCouncilModels = new ArrayList<>();
        List<MemberCouncil> memberCouncils = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select m From MemberCouncil as m Where m.council.id = :idCouncil ";
            memberCouncils = session.createQuery(hql).setParameter("idCouncil", idCouncil).getResultList();
            for(MemberCouncil memberCouncil: memberCouncils)
            {
                MemberCouncilModel m = new MemberCouncilModel();
                BeanUtils.copyProperties(m, memberCouncil);
                memberCouncilModels.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberCouncilModels;
    }
    public List<MemberCouncilModel> getListSearch(int idCouncil, String search) {
        Transaction transaction = null;
        List<MemberCouncilModel> memberCouncilModels = new ArrayList<>();
        List<MemberCouncil> memberCouncils = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select m From MemberCouncil as m Where m.council.id = :idCouncil and m.user.fullname like :search";
            memberCouncils = session.createQuery(hql).setParameter("idCouncil", idCouncil).setParameter("search","'%"+search +"%'").getResultList();
            for(MemberCouncil memberCouncil: memberCouncils)
            {
                MemberCouncilModel m = new MemberCouncilModel();
                BeanUtils.copyProperties(m, memberCouncil);
                memberCouncilModels.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberCouncilModels;
    }

    public int count(int id) {
        Transaction transaction = null;
        int count =0;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select m From MemberCouncil as m where m.council.id= :id";
            count = (int) session.createQuery(hql).setParameter("id",id).stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int check(int id, String username) {
        Transaction transaction = null;
        int count =0;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "Select m From MemberCouncil as m where m.council.id= :id and m.user.username= :username";
            count = (int) session.createQuery(hql).setParameter("id",id).setParameter("username", username).stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            MemberCouncil memberCouncil = session.get(MemberCouncil.class, id);
            if (memberCouncil != null) {
                session.delete(memberCouncil);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void deleteAll(int idCouncil) {
        Transaction transaction = null;
        List<MemberCouncil>memberCouncils = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "Select m From MemberCouncil as m Where m.council.id = :idCouncil ";
            memberCouncils = session.createQuery(hql).setParameter("idCouncil", idCouncil).getResultList();
            for(MemberCouncil memberCouncil: memberCouncils)
            {
                MemberCouncil memberCouncil1 = session.get(MemberCouncil.class, memberCouncil.getId());
                if (memberCouncil1 != null) {
                    session.delete(memberCouncil1);
                }
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
