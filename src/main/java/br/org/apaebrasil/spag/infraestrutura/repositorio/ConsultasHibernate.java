/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import java.util.List;
import br.org.apaebrasil.spag.dominio.Consulta;
import br.org.apaebrasil.spag.dominio.repositorio.Consultas;
import java.util.Date;

/**
 *
 * @author Pc
 */
public class ConsultasHibernate extends RepositorioHibernate<Consulta, Integer> implements Consultas {
    @Override
    public List<Consulta> porPaciente(String nome) {
        return manager.createQuery("from Consulta c where c.nome = :nome").getResultList();
    }

    @Override
    public List<Consulta> porDataHora(Date dataHora) {
        return manager.createQuery("from Consulta c where c.dataHora = :dataHora").getResultList();
    }
}
