/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Agendamento;
import br.org.apaebrasil.spag.dominio.Especializacao;
import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.repositorio.Agendamentos;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author fbc
 */
@Named
@ViewScoped
public class ControladorAgenda implements Serializable {

    @Inject
    private Agendamentos agendamentos;

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();

    private static final long HORA = 3600*1000; 
    
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();

        for (Agendamento a : agendamentos.recuperarTodos()) {
            Paciente paciente = a.getPaciente();
            Especializacao especializacao = a.getEspecializacao();
            Date dataHora = a.getDataHora();
            
            eventModel.addEvent(new DefaultScheduleEvent(paciente.getNome() + " (" + especializacao + ")",
                    dataHora, new Date(dataHora.getTime() + HORA)));
        }
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Event resized", "Day delta:"
                + event.getDayDelta()
                + ", Minute delta:"
                + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
