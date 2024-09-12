package com.jcg.hibernate.crud.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MedicoCrud {

    public void salvarMedico(Medico medico) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(medico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Medico buscarMedicoPorCrm(String crm) {
        Session session = null;
        Medico medico = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // Casting explícito para evitar erro de incompatibilidade de tipo
            medico = (Medico) session.get(Medico.class, crm);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medico;
    }

    @SuppressWarnings("unchecked")
    public List<Medico> listarTodosMedicos() {
        Session session = null;
        List<Medico> medicos = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            medicos = session.createQuery("from Medico").list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return medicos;
    }
    

    public void atualizarMedico(Medico medico) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(medico);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deletarMedico(String crm) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Medico medico = (Medico) session.get(Medico.class, crm); 
            if (medico != null) {
                session.delete(medico);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
