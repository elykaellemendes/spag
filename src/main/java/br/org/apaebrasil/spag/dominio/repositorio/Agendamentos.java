/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio.repositorio;

import br.org.apaebrasil.spag.dominio.Agendamento;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface Agendamentos extends Repositorio<Agendamento, Integer> {
    public List<Agendamento> porDataHora(Date dataHora);
}
