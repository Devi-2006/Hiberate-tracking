package com.scwellness.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.scwellness.bean.Senior;
import com.scwellness.util.HibernateUtil;

public class SeniorDAO {

    public Senior findSenior(String seniorID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Senior.class, seniorID);
        }
    }

    public List<Senior> viewAllSeniors() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Senior", Senior.class).list();
        }
    }

    public boolean insertSenior(Senior senior) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(senior);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSeniorStatus(String seniorID, String status) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Senior senior = session.get(Senior.class, seniorID);
            if (senior == null) return false;

            senior.setStatus(status);
            session.update(senior);

            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSenior(String seniorID) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Senior senior = session.get(Senior.class, seniorID);
            if (senior == null) return false;

            session.delete(senior);

            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
}