package com.dotin.dao;

import com.dotin.model.Employee;
import com.dotin.model.Vacation;
import com.dotin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VacationDAo {

    ///saveVacation

    public void saveVacation(Vacation vacation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(vacation);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
