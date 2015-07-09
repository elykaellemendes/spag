/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio.util;

import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.repositorio.Pacientes;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fbc
 */

@Named
public class PacienteConverter implements Converter {

    @Inject
    private Pacientes pacientes;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.trim().length() < 0) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão ", "Nome de paciente inválido."));
        }
        
        try {
            int codigo = Integer.parseInt(value.trim());

            return pacientes.recuperar(codigo);
        } catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão ", e.getMessage()));
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            Paciente paciente = (Paciente) object;

            return String.valueOf(paciente.getCodigo());
        } else {
            return null;
        }
    }
}
