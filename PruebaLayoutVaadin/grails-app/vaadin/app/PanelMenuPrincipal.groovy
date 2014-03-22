package app

import com.vaadin.server.Page
import com.vaadin.server.VaadinServlet
import com.vaadin.server.VaadinSession
import com.vaadin.ui.MenuBar

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 03/21/14
 * Time: 08:29 PM
 * To change this template use File | Settings | File Templates.
 */
class PanelMenuPrincipal extends MenuBar{

    private PnTabs mainTab;


    public PanelMenuPrincipal(){

        MenuBar.Command cmdSalir = new MenuBar.Command() {
            @Override
            void menuSelected(MenuBar.MenuItem menuItem) {
                VaadinSession.current.session.invalidate()
                Page.getCurrent().setLocation(VaadinServlet.getCurrent().getServletContext().getContextPath())
            }
        }

        MenuBar.MenuItem menuMantenimiento = addItem("Mantenimiento", null, null)
        MenuBar.MenuItem menuSesion = addItem("Sesión", null, null)
        menuSesion.addItem("Cambiar Contraseña", null, null);
        menuSesion.addItem("Salir", null, cmdSalir);

        setWidth("100%")
    }

    /**
     * Metodo para registrar el objeto que representa el maintab del proyecto.
     * @param mainTab
     */
    public void addMainTab(PnTabs mainTab){
        this.mainTab=mainTab;
    }


}
