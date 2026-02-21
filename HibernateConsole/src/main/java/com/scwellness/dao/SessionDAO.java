package com.scwellness.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.scwellness.bean.Sessions;
import com.scwellness.util.HibernateUtil;

public class SessionDAO {

    // Generate Session ID using sequence
    public int generateSessionID() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Object result = session.createNativeQuery("SELECT sessionID_seq.NEXTVAL FROM dual")
                    .getSingleResult();
            return ((Number) result).intValue();
        }
    }

    // Insert Session
    public boolean insertSession(Sessions sessions) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            sessions.setStatus("SCHEDULED");
            session.save(sessions);

            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    // Update Outcome
    public boolean updateSessionOutcome(int sessionID, String status,
                                        String bloodPressure, java.math.BigDecimal sugarLevel,
                                        String sessionNotes) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Sessions s = session.get(Sessions.class, sessionID);
            if (s == null) return false;

            s.setStatus(status);
            s.setBloodPressure(bloodPressure);
            s.setSugarLevel(sugarLevel);
            s.setSessionNotes(sessionNotes);

            session.update(s);
            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    // Find Session
    public Sessions findSession(int sessionID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Sessions.class, sessionID);
        }
    }

    // By Senior
    public List<Sessions> findSessionsBySenior(String seniorID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from Sessions where seniorID = :sid order by sessionDate",
                    Sessions.class)
                    .setParameter("sid", seniorID)
                    .list();
        }
    }

    // By Program
    public List<Sessions> findSessionsByProgram(String programID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from Sessions where programID = :pid order by sessionDate",
                    Sessions.class)
                    .setParameter("pid", programID)
                    .list();
        }
    }

    // By Date
    public List<Sessions> findSessionsByDate(Date sessionDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from Sessions where sessionDate = :dt order by timeSlot",
                    Sessions.class)
                    .setParameter("dt", sessionDate)
                    .list();
        }
    }

    // Conflict Check
    public List<Sessions> findConflictingSessions(String seniorID, Date sessionDate, String timeSlot) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from Sessions where seniorID = :sid and sessionDate = :dt and timeSlot = :ts",
                    Sessions.class)
                    .setParameter("sid", seniorID)
                    .setParameter("dt", sessionDate)
                    .setParameter("ts", timeSlot)
                    .list();
        }
    }

    // Active Sessions for Senior
    public List<Sessions> findActiveSessionsForSenior(String seniorID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from Sessions where seniorID = :sid and status = 'SCHEDULED'",
                    Sessions.class)
                    .setParameter("sid", seniorID)
                    .list();
        }
    }

    // Active Sessions for Program
    public List<Sessions> findActiveSessionsForProgram(String programID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "from Sessions where programID = :pid and status = 'SCHEDULED'",
                    Sessions.class)
                    .setParameter("pid", programID)
                    .list();
        }
    }
}