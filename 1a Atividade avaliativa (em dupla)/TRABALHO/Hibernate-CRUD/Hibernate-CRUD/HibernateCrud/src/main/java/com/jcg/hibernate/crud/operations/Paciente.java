package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paciente_761531")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="CPF")
    private String cpf;

    @Column(name="Nome")
    private String nome;

    @Column(name="Endereco")
    private String endereco;

    @Column(name="Telefone")
    private String telefone;

    @Column(name="Data_Nasc")
    private String dataNasc;

    @Column(name="Quarto")
    private int quarto;

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    @Override
    public String toString() {
        return "Paciente [cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", dataNasc=" + dataNasc + ", quarto=" + quarto + "]";
    }
}
