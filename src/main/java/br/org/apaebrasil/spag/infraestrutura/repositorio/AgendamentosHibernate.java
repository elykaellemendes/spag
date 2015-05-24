/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Agendamento;
import br.org.apaebrasil.spag.dominio.repositorio.Agendamentos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pc
 */
public class AgendamentosHibernate extends RepositorioHibernate<Agendamento, Integer> implements Agendamentos {

    @Override
    public List<Agendamento> porDataHora(Date dataHora) {
        return manager.createQuery("from Agendamento a where a.dataHora = :dataHora").getResultList();
    }

    @Override
    public List<Agendamento> porPaciente(String nome) {
        return manager.createQuery("from Agendamento a where a.nome = :nome").getResultList();
    }

    @Override
    public List<Agendamento> porEspecializacao(String especializacao) {
        return manager.createQuery("from Agendamento a where a.especializacao = :especializacao").getResultList();
    }
}
