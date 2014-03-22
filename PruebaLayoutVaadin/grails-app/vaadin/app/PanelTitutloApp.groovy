package app

import com.vaadin.server.VaadinSession
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.Alignment
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Image
import com.vaadin.ui.Label
import com.vaadin.ui.Panel
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.Reindeer

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 03/21/14
 * Time: 08:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class PanelTitutloApp extends Panel{
    VerticalLayout verticalIzquierda, verticalCentro, verticalDerecha
    HorizontalLayout horizontalContenedor

    public PanelTitutloApp(){


        Image image = new Image("", MyUI.imagenLogo);

        Label lblTitulo = new Label("Proyecto Prueba Layout")
        lblTitulo.setStyleName(Reindeer.LABEL_H1)

        Label lblEmpresa =  new Label("Empresa...")
        lblEmpresa.setStyleName(Reindeer.LABEL_H2)

        Label lblTaller =  new Label("Otra Información...")
        lblTaller.setStyleName(Reindeer.LABEL_H2)

        Label lblUsuario =  new Label("Bienvenido, Usuario....")
        lblUsuario.setStyleName(Reindeer.LABEL_H2)

        verticalIzquierda = new VerticalLayout()
        verticalIzquierda.addComponent(image)

        verticalCentro = new VerticalLayout()
        verticalCentro.setSizeFull()
        verticalCentro.addComponent(lblTitulo)
        verticalCentro.setComponentAlignment(lblTitulo, Alignment.MIDDLE_CENTER)

        verticalDerecha = new VerticalLayout()
        verticalDerecha.setSizeUndefined()
        verticalDerecha.addComponent(lblEmpresa)
        verticalDerecha.addComponent(lblTaller)
        verticalDerecha.addComponent(lblUsuario)
        verticalDerecha.setComponentAlignment(lblEmpresa, Alignment.BOTTOM_RIGHT)
        verticalDerecha.setComponentAlignment(lblTaller, Alignment.BOTTOM_RIGHT)
        verticalDerecha.setComponentAlignment(lblUsuario, Alignment.BOTTOM_RIGHT)

        //setSpacing(true)
        horizontalContenedor = new HorizontalLayout()
        horizontalContenedor.setMargin(new MarginInfo(false,false,false,true))
        horizontalContenedor.setWidth("100%")
        horizontalContenedor.setStyleName(Reindeer.LAYOUT_BLUE)
        horizontalContenedor.addComponent(verticalIzquierda)
        horizontalContenedor.addComponent(verticalCentro)
        horizontalContenedor.addComponent(verticalDerecha)
        horizontalContenedor.setExpandRatio(verticalIzquierda, 1.0)
        horizontalContenedor.setExpandRatio(verticalCentro, 4.0)
        horizontalContenedor.setExpandRatio(verticalDerecha, 1.0)

        setContent(horizontalContenedor)
    }
}

