/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import java.util.List;
import br.org.apaebrasil.spag.dominio.Consulta;
import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.repositorio.Consultas;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
public class ConsultasHibernate extends RepositorioHibernate<Consulta, Integer> implements Consultas {

    @Override
    public List<Consulta> porPaciente(Paciente paciente) {
        Objects.requireNonNull(paciente, "paciente inválido");

        // Isto aqui é uma GAMBIARRA!!!
        // Por alguma razão o hibernate está acusando que os tipos são diferentes
        // e por isso não deixa utilizar o query.setParameter()
        Query query = manager.createQuery("FROM Consulta c WHERE c.paciente = " + paciente.getCodigo());

        return query.getResultList();
    }

    @Override
    public List<Consulta> porDataHora(Date dataHora) {
        return manager.createQuery("from Consulta c where c.dataHora = :dataHora").getResultList();
    }
}
