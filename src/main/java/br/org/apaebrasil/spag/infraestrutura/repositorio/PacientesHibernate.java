/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.repositorio.Pacientes;
import java.util.List;

/**
 *
 * @author Pc
 */
public class PacientesHibernate extends RepositorioHibernate<Paciente, Integer> implements Pacientes {

    @Override
    public List<Paciente> porPaciente(String nome) {
        return manager.createQuery("from Paciente p where p.nome = :nome").getResultList();
    }

    @Override
    public List<Paciente> porCidade(String cidade) {
        return manager.createQuery("from Paciente p where p.cidade = :cidade").getResultList();
    }

    @Override
    public List<Paciente> porCartaoSus(String cartaoSus) {
        return manager.createQuery("from Paciente p where p.cartaosus = :cartaosus").getResultList();
    }

}
