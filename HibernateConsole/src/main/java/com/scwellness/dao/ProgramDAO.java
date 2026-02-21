package com.scwellness.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.scwellness.bean.Program;
import com.scwellness.util.HibernateUtil;

public class ProgramDAO {

    public Program findProgram(String programID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Program.class, programID);
        }
    }

    public List<Program> viewAllPrograms() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Program", Program.class).list();
        }
    }

    public boolean insertProgram(Program program) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(program);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProgramStatus(String programID, String status) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Program program = session.get(Program.class, programID);
            if (program == null) return false;

            program.setStatus(status);
            session.update(program);

            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProgram(String programID) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Program program = session.get(Program.class, programID);
            if (program == null) return false;

            session.delete(program);

            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
}