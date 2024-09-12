package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tratamento")
public class Tratamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne
    @JoinColumn(name="CPF_Paciente", referencedColumnName="CPF")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name="CRM_Medico", referencedColumnName="CRM")
    private Medico medico;

    @Column(name="Responsavel")
    private boolean responsavel;

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean isResponsavel() {
        return responsavel;
    }

    public void setResponsavel(boolean responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Tratamento [paciente=" + paciente + ", medico=" + medico + ", responsavel=" + responsavel + "]";
    }
}
