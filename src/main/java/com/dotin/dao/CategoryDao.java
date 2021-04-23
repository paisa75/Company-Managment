package com.dotin.dao;

import com.dotin.model.CategoryElement;
import com.dotin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao {

    ///getRoles
    public List<CategoryElement> getAllRoles() {

        Transaction transaction = null;
        List<CategoryElement> roles = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            roles = session.createNativeQuery("select * from categorianelement where dType=1", CategoryElement.class).list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return roles;
    }


    ///getCategoryElement
    public CategoryElement getCategoryElement(Long id) {

        Transaction transaction = null;
        CategoryElement categoryElement = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an CategoryElement object
            categoryElement = session.get(CategoryElement.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return categoryElement;
    }


}
