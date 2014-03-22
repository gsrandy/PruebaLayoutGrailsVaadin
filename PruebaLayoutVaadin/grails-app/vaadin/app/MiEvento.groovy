package app

import com.vaadin.addon.calendar.event.CalendarEvent
import com.vaadin.addon.calendar.event.CalendarEventEditor

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 03/21/14
 * Time: 09:44 PM
 * To change this template use File | Settings | File Templates.
 */
class MiEvento implements CalendarEventEditor, CalendarEvent.EventChangeNotifier {

    Date fechaInicio;
    Date fechaFinal;
    String nombreEvento;
    String descripcion;

    @Override
    void setCaption(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
        nombreEvento=s;
    }

    @Override
    void setDescription(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
        descripcion=s;
    }

    @Override
    void setEnd(Date date) {
        //To change body of implemented methods use File | Settings | File Templates.
        fechaFinal=date;
    }

    @Override
    void setStart(Date date) {
        //To change body of implemented methods use File | Settings | File Templates.
        fechaInicio=date;
    }

    @Override
    void setStyleName(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    void setAllDay(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    Date getStart() {
        return fechaInicio  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    Date getEnd() {
        return fechaFinal  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    String getCaption() {
        return nombreEvento  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    String getDescription() {
        return descripcion  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    String getStyleName() {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    boolean isAllDay() {
        return false  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    void addListener(CalendarEvent.EventChangeListener eventChangeListener) {
        println("Agregando evento...");
    }

    @Override
    void removeListener(CalendarEvent.EventChangeListener eventChangeListener) {
        println("Eliminando evento..")
    }
}
