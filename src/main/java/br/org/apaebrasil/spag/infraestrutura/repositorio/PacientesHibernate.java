/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.repositorio.Pacientes;
import java.util.List;
import java.util.Objects;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
public class PacientesHibernate extends RepositorioHibernate<Paciente, Integer> implements Pacientes {
    @Override
    public List<Paciente> porNome(String nome) {
        Objects.requireNonNull(nome, "nome inválido");

        Query query = manager.createQuery("FROM Paciente p WHERE p.nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

    @Override
    public List<Paciente> porCidade(String cidade) {
        Objects.requireNonNull(cidade, "cidade inválida");

        Query query = manager.createQuery("FROM Paciente p WHERE p.endereco.cidade = :cidade");
        query.setParameter("cidade", cidade);

        return query.getResultList();
    }

    @Override
    public List<Paciente> porCartaoSus(String cartaoSus) {
        Objects.requireNonNull(cartaoSus, "cartão do SUS inválido");

        Query query = manager.createQuery("FROM Paciente p WHERE p.cartaoSus = :cartaoSus");
        query.setParameter("cartaoSus", cartaoSus);
        
        return query.getResultList();
    }
}
