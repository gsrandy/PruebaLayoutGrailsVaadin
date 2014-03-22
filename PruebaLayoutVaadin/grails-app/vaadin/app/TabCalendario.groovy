package app

import com.vaadin.addon.calendar.event.CalendarEvent
import com.vaadin.addon.calendar.event.CalendarEventProvider
import com.vaadin.addon.calendar.ui.Calendar
import com.vaadin.addon.calendar.ui.CalendarComponentEvents
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick
import com.vaadin.grails.Grails
import com.vaadin.server.VaadinSession
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*

/**
 * Created with IntelliJ IDEA.
 * User: Sixto Nunez
 * Date: 07/27/13
 * Time: 02:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class TabCalendario extends Panel{

    VerticalLayout vlPanel
    HorizontalLayout controlesCalendarioLayout, hlControlesIzquierda, hlControlesDerecha
    Button btnVerMes, btnVerSemana
    Calendar calendar


    public TabCalendario(){

        calendar = new Calendar()
        calendar.setSizeFull()
        calendar.setEventProvider(new CalendarEventProvider() {
            @Override
            List<CalendarEvent> getEvents(Date fechaInicio, Date fechaFin) {
                println("Las fechas para el calendario son $fechaInicio y $fechaFin")
                List<CalendarEvent> lista=new ArrayList<>();
                def miEvento=new MiEvento();
                miEvento.fechaInicio=fechaInicio+1;
                miEvento.fechaFinal=fechaFin-1;
                miEvento.nombreEvento="Mi Evento";
                miEvento.descripcion="Descripción";
                lista.add(miEvento);
                return lista;
            }
        })

        java.util.Calendar startDate = java.util.Calendar.getInstance()
        startDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
        calendar.setStartDate(startDate.getTime());

        // Set end date to last day of this month
        java.util.Calendar endDate = java.util.Calendar.getInstance()
        endDate.set(java.util.Calendar.DATE, endDate.getActualMaximum(java.util.Calendar.DATE))
        calendar.setEndDate(endDate.getTime());

        //Anadir los eventos necesarios.
        calendar.setHandler(new CalendarComponentEvents.EventMoveHandler() {
            @Override
            void eventMove(CalendarComponentEvents.MoveEvent moveEvent) {
                println("Realizando Movimiento del evento: "+moveEvent.calendarEvent.caption);
            }
        })

        //Para  el evento Resize.
        calendar.setHandler(new CalendarComponentEvents.EventResizeHandler() {
            @Override
            void eventResize(CalendarComponentEvents.EventResize eventResize) {
                println("Realizando un Resize al evento: "+eventResize.calendarEvent.caption);
            }
        });

        //Para el evento Click
        calendar.setHandler(new CalendarComponentEvents.EventClickHandler() {
            @Override
            void eventClick(EventClick eventClick) {
                println("Realizado Click sobre el evento: "+eventClick.calendarEvent.caption);

            }
        })

        //
        vlPanel = new VerticalLayout()
        vlPanel.setSizeFull()
        vlPanel.setMargin(true)
        vlPanel.addComponent(construirControlesDeTabla())
        vlPanel.addComponent(calendar)
        setContent(vlPanel)
    }

    /**
     *
     * @return
     */
    private Component construirControlesDeTabla(){

        btnVerMes = new Button("Mes")
        //btnEditar.setIcon()
        btnVerMes.addClickListener(new Button.ClickListener() {
            @Override
            void buttonClick(Button.ClickEvent clickEvent) {
                java.util.Calendar startDate = java.util.Calendar.getInstance()
                startDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
                calendar.setStartDate(startDate.getTime());

                java.util.Calendar endDate = java.util.Calendar.getInstance()
                endDate.set(java.util.Calendar.DATE, endDate.getActualMaximum(java.util.Calendar.DATE))
                calendar.setEndDate(endDate.getTime());
            }
        })

        btnVerSemana = new Button("Semana")
        //btnVerSemana.setIcon()
        btnVerSemana.addClickListener(new Button.ClickListener() {
            @Override
            void buttonClick(Button.ClickEvent clickEvent) {
                java.util.Calendar date = java.util.Calendar.getInstance()
                calendar.setStartDate(date.getTime());

                date.add(java.util.Calendar.DAY_OF_MONTH, 6)
                calendar.setEndDate(date.getTime());
            }
        })

        hlControlesIzquierda = new HorizontalLayout()
        hlControlesIzquierda.setSpacing(true)
        hlControlesIzquierda.addComponent(btnVerMes)
        hlControlesIzquierda.addComponent(btnVerSemana)
        hlControlesIzquierda.setComponentAlignment(btnVerMes, Alignment.MIDDLE_CENTER)

/*        Label colorGris = new Label("PLANIFICADO")
        colorGris.setStyleName("leyenda-color1")*/

        Label colorVerde = new Label("PROCESO")
        colorVerde.setStyleName("leyenda-color2")

        Label colorRojo = new Label("PARADO")
        colorRojo.setStyleName("leyenda-color3")

        Label colorAzul= new Label("FINALIZADO")
        colorAzul.setStyleName("leyenda-color4")

        hlControlesDerecha = new HorizontalLayout()
        hlControlesDerecha.setSpacing(true)
        hlControlesDerecha.addComponent(new Label("Leyenda: "))
        //hlControlesDerecha.addComponent(colorGris)
        hlControlesDerecha.addComponent(colorVerde)
        hlControlesDerecha.addComponent(colorRojo)
        hlControlesDerecha.addComponent(colorAzul)


        controlesCalendarioLayout = new HorizontalLayout()
        controlesCalendarioLayout.setWidth("100%")
        controlesCalendarioLayout.addComponent(hlControlesIzquierda)
        controlesCalendarioLayout.addComponent(hlControlesDerecha)
        controlesCalendarioLayout.setSpacing(true)
        controlesCalendarioLayout.setExpandRatio(hlControlesIzquierda, 4)
        controlesCalendarioLayout.setExpandRatio(hlControlesDerecha, 1)
        controlesCalendarioLayout.setMargin(new MarginInfo(false,false,false,true))

        //aplicarSeguridad()

        return controlesCalendarioLayout
    }
}
