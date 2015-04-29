/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio.repositorio;

import br.org.apaebrasil.spag.dominio.Paciente;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface Pacientes extends Repositorio<Paciente, Integer> {
    public List<Paciente> porPaciente(String nome);
    public List<Paciente> porCidade(String cidade);
    public List<Paciente> porCartaoSus(String cartaoSus);
    
}
