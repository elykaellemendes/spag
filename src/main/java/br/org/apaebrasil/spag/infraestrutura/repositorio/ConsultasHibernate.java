/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import java.util.List;
import br.org.apaebrasil.spag.dominio.Consulta;
import br.org.apaebrasil.spag.dominio.repositorio.Consultas;

/**
 *
 * @author Pc
 */
public class ConsultasHibernate extends RepositorioHibernate<Consulta, Integer> implements Consultas {
    @Override
    public List<Consulta> porPaciente(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
