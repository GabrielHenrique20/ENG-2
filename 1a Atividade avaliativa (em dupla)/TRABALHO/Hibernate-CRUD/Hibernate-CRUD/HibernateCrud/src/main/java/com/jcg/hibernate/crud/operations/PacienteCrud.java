package com.jcg.hibernate.crud.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PacienteCrud {

    public void salvarPaciente(Paciente paciente) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(paciente);
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

    public Paciente buscarPacientePorCpf(String cpf) {
        Session session = null;
        Paciente paciente = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            paciente = (Paciente) session.get(Paciente.class, cpf);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return paciente;
    }

    @SuppressWarnings("unchecked")
    public List<Paciente> listarTodosPacientes() {
        Session session = null;
        List<Paciente> paciente = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            paciente = session.createQuery("from Medico").list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return paciente;
    }
    
  
    public void atualizarPaciente(Paciente paciente) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(paciente);
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

    public void deletarPaciente(String cpf) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Paciente paciente = (Paciente) session.get(Paciente.class, cpf);
            if (paciente != null) {
                session.delete(paciente);
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
