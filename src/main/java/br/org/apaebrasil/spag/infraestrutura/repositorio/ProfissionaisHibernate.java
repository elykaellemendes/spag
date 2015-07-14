/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.repositorio.Profissionais;
import java.util.List;
import java.util.Objects;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
public class ProfissionaisHibernate extends RepositorioHibernate<Profissional, Integer> implements Profissionais {

    @Override
    public List<Profissional> porProfissional(String nome) {
        Objects.requireNonNull(nome, "nome inválido");

        Query query = manager.createQuery("FROM Profissional p WHERE p.nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

    @Override
    public List<Profissional> porCpf(String cpf) {
        Objects.requireNonNull(cpf, "cpf inválido");

        Query query = manager.createQuery("FROM Profissional p WHERE p.nome LIKE :cpf");
        query.setParameter("cpf", "%" + cpf + "%");

        return query.getResultList();
    }

    @Override
    public List<Profissional> porEspecializacao(String especializacao) {
        Objects.requireNonNull(especializacao, "cpf especializacao");

        Query query = manager.createQuery("FROM Profissional p WHERE p.especializacao LIKE :especializacao");
        query.setParameter("especializacao", "%" + especializacao + "%");

        return query.getResultList();
    }
}
