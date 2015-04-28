/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio.repositorio;

import br.org.apaebrasil.spag.dominio.Consulta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface Consultas extends Repositorio<Consulta, Integer>{
    public List<Consulta> porPaciente(String nome);
    public List<Consulta> porDataHora(Date dataHora);
}
