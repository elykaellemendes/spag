/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@ManagedBean
@RequestScoped
@Entity
@Table
public class Paciente implements Serializable{
   
    @Id
    @GeneratedValue
    private int codigo;
    
    @Column
    private String nome;
    
    @Column
    private String sexo;
    
    @Temporal(TemporalType.DATE)
    private Date dataNasciemnto;
    
    @Column
    private String filiacao;
    
    @Column
    private String endereco;
    
    @Column
    private String estadoCivil;
    
    @Column
    private String naturalidade;
    
    @Column
    private String procedencia;
    
    @Column
    private String cartaoSus;

    public Paciente() {
    }

    public Paciente(int codigo, String nome, String sexo, Date dataNasciemnto, String filiacao, String endereco, String estadoCivil, String naturalidade, String procedencia, String cartaoSus) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasciemnto = dataNasciemnto;
        this.filiacao = filiacao;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.naturalidade = naturalidade;
        this.procedencia = procedencia;
        this.cartaoSus = cartaoSus;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasciemnto() {
        return dataNasciemnto;
    }

    public void setDataNasciemnto(Date dataNasciemnto) {
        this.dataNasciemnto = dataNasciemnto;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    
    
}
