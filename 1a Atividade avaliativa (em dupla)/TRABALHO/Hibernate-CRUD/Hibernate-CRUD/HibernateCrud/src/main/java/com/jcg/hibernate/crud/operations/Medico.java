package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medico_761531")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="CRM")
    private String crm;

    @Column(name="Nome")
    private String nome;

    @Column(name="Salario")
    private float salario;

    @Column(name="Especialidade")
    private String especialidade;

    // Getters e Setters
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico [crm=" + crm + ", nome=" + nome + ", salario=" + salario + ", especialidade=" + especialidade + "]";
    }
}
