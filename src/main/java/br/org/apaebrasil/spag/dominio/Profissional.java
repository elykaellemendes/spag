/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Pc
 */
@Entity
public class Profissional implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;

    private String nome;

    private String cpf;

    private String registroMedico;

    @Embedded
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Especializacao especializacao;

    public Profissional() {
    }

    public Profissional(String nome, String cpf, String registroMedico, Usuario usuario,Especializacao especializacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.registroMedico = registroMedico;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }
    
    @Override
    public String toString() {
        return nome + " (CRM: " + registroMedico + ")";
    }
}
