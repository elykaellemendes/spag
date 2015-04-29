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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Pc
 */
@ManagedBean
@RequestScoped
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private int codigo;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String coordenacao;
    @Column
    private String login;
    @Column
    private String senha;


    public Usuario() {
    }

    public Usuario(int codigo, String nome, String cpf, String cordenacao, String login, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.coordenacao = cordenacao;
        this.login = login;
        this.senha = senha;
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

    public String getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
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
    
}
