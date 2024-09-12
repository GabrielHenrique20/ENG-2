package com.jcg.hibernate.crud.operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TratamentoCrud {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void salvarTratamento(Tratamento tratamento) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(tratamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Tratamento buscarTratamentoPorPacienteCpf(String cpf) {
        EntityManager em = null;
        Tratamento tratamento = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("from Tratamento where paciente.cpf = :cpf");
            query.setParameter("cpf", cpf);
            tratamento = (Tratamento) query.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tratamento;
    }

    @SuppressWarnings("unchecked")
    public List<Tratamento> listarTodosTratamentos() {
        EntityManager em = null;
        List<Tratamento> tratamentos = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("from Tratamento");
            tratamentos = query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tratamentos;
    }

    public void atualizarTratamento(Tratamento tratamento) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(tratamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deletarTratamento(String cpf) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            Query query = em.createQuery("from Tratamento where paciente.cpf = :cpf");
            query.setParameter("cpf", cpf);
            Tratamento tratamento = (Tratamento) query.getSingleResult();
            if (tratamento != null) {
                em.remove(tratamento);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
