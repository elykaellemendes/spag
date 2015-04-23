/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import java.util.List;
import br.org.apaebrasil.spag.dominio.Profissional;

/**
 *
 * @author Pc
 */
public class ProfissionaisHibernate implements br.org.apaebrasil.spag.dominio.repositorio.Repositorio<Profissional, Integer>{

    @Override
    public void inserir(Profissional t) {
        br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Profissional t) {
        br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.update(t);
    }

    @Override
    public Profissional recuperar(Integer g) {
        try {
            return (Profissional) br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.recover("from Profissional where codigo='"+g+"'").get(0);
        }catch(IndexOutOfBoundsException i){
            return null;
        }
    }

    @Override
    public List<Profissional> recuperarTodos() {
        return br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.recover("from Profissional");
    }
    
}
