/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import java.util.List;
import br.org.apaebrasil.spag.dominio.Paciente;

/**
 *
 * @author Pc
 */
public class PacientesHibernate implements br.org.apaebrasil.spag.dominio.repositorio.Repositorio<Paciente, Integer>{

    @Override
    public void inserir(Paciente t) {
        br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Paciente t) {
        br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.update(t);
    }

    @Override
    public Paciente recuperar(Integer g) {
        try {
            return (Paciente) br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.recover("from Paciente where codigo='"+g+"'").get(0);
        }catch(IndexOutOfBoundsException i){
            return null;
        }
    }

    @Override
    public List<Paciente> recuperarTodos() {
        return br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber.recover("from Paciente");
    }
    
}
