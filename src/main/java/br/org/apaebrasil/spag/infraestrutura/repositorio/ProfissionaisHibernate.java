/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.repositorio.Profissionais;
import java.util.List;

/**
 *
 * @author Pc
 */
public class ProfissionaisHibernate extends RepositorioHibernate<Profissional, Integer> implements Profissionais{

    @Override
    public List<Profissional> porProfissional(String nome) {
        return manager.createQuery("from Profissional p where p.nome = :nome").getResultList();
    }

    @Override
    public List<Profissional> porCpf(String cpf) {
        return manager.createQuery("from Profissional p where p.cpf = :cpf").getResultList();
    }

    @Override
    public List<Profissional> porEspecializacao(String especializacao) {
        return manager.createQuery("from Profissional p where p.especializacao = :especializacao").getResultList();
    }
}
