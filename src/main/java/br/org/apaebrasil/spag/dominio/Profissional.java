/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Pc
 */
@ManagedBean
@RequestScoped
@Entity
public class Profissional implements Serializable {
    @Id
    @GeneratedValue
    private int codigo;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @Column
    private String registroMedico;
    
    @Column
    private String login;
    
    @Column
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private Especializacao especializacao;

    public Profissional() {
    }

    public Profissional(int codigo, String nome, String cpf, String registroMedico, String login, String senha, Especializacao especializacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.registroMedico = registroMedico;
        this.login = login;
        this.senha = senha;
        this.especializacao = especializacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }
    
    
}
