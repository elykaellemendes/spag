/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@Entity
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int codigo;

    @Column
    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column
    private String filiacao;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column
    private String naturalidade;

    @Column
    private String procedencia;

    @Column
    private String cartaoSus;

    public Paciente() {
        this.endereco = new Endereco();
    }

    public Paciente(String nome, Sexo sexo, Date dataNascimento, String filiacao, Endereco endereco, EstadoCivil estadoCivil, String naturalidade, String procedencia, String cartaoSus) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(String filiacao) {
        this.filiacao = filiacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
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

    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", nome=" + nome + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", filiacao=" + filiacao + ", endereco=" + endereco + ", estadoCivil=" + estadoCivil + ", naturalidade=" + naturalidade + ", procedencia=" + procedencia + ", cartaoSus=" + cartaoSus + '}';
    }
}
