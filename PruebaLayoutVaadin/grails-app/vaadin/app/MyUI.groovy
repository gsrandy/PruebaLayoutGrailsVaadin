package app

import com.vaadin.event.ShortcutAction
import com.vaadin.server.FileResource
import com.vaadin.server.Resource
import com.vaadin.server.VaadinService
import com.vaadin.server.VaadinSession
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.FormLayout
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Image
import com.vaadin.ui.Notification
import com.vaadin.ui.Panel
import com.vaadin.ui.PasswordField
import com.vaadin.ui.TextField
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.grails.Grails
import com.vaadin.ui.themes.Reindeer

/**
 *
 *
 * @author
 */
class MyUI extends UI {

    private TextField tfUsuario
    private PasswordField pfContrasena
    private Button btnAceptar, btnSalir

    @Override
    protected void init(VaadinRequest vaadinRequest) {

		construirEntradaSistema();
    }

    /**
     *
     */
    public void construirEntradaSistema(){

        tfUsuario=new TextField("Usuario:")
        tfUsuario.setId("usuarioTextFieldID")
        tfUsuario.setRequired(true)
        tfUsuario.focus()

        pfContrasena=new PasswordField("Contraseña:")
        pfContrasena.setId("passwordTextFieldID")
        pfContrasena.setRequired(true)

        btnAceptar=new Button("Aceptar")
        btnAceptar.setClickShortcut(ShortcutAction.KeyCode.ENTER)
        btnAceptar.addClickListener(new Button.ClickListener() {
            @Override
            void buttonClick(Button.ClickEvent clickEvent) {
                println("Click con exito...")
                construirMenuPrincipal();
            }
        });

        //formulario login
        FormLayout formLayout = new FormLayout()
        formLayout.addComponent(tfUsuario)
        formLayout.addComponent(pfContrasena)
        formLayout.addComponent(btnAceptar)
        formLayout.setSizeUndefined()
        formLayout.setMargin(true)

        Image image = new Image("",getImagenLogo())

        HorizontalLayout horizontalLayout = new HorizontalLayout()
        horizontalLayout.addComponent(image); //imagen al lado del panel de formulario.
        horizontalLayout.addComponent(formLayout)
        horizontalLayout.setSpacing(true)
        horizontalLayout.setMargin(true)

        //Panel del login.
        Panel panelInferior = new Panel("Entrada al sistema")
        panelInferior.setSizeUndefined()
        panelInferior.setContent(horizontalLayout)

        //Panel que representan el color negro
        VerticalLayout layoutSuperior = new VerticalLayout()
        layoutSuperior.setStyleName(Reindeer.LAYOUT_BLACK)
        layoutSuperior.setSizeFull()

        Panel panelSuperior = new Panel()
        panelSuperior.setHeight("60px")
        panelSuperior.setContent(layoutSuperior)


        VerticalLayout vertical=new VerticalLayout()
        vertical.setSizeFull()
        vertical.addComponent(panelSuperior)
        vertical.addComponent(panelInferior)
        vertical.setComponentAlignment(panelInferior, Alignment.MIDDLE_CENTER)
        vertical.setExpandRatio(panelInferior, 1)

        setContent(vertical)
        setSizeFull()
    }

    /**
     *
     */
    public void construirMenuPrincipal(){

        //Menu superior
        PanelMenuPrincipal pnMenuPrincipal = new PanelMenuPrincipal()

        //Titulo
        PanelTitutloApp pnTituloApp = new PanelTitutloApp()

        //Tabs
        PnTabs pnTabs = new PnTabs()
        pnMenuPrincipal.addMainTab(pnTabs)

        VerticalLayout content = new VerticalLayout()
        content.addComponent(pnMenuPrincipal)
        content.addComponent(pnTituloApp)
        content.addComponent(pnTabs)

        content.setSizeFull()
        content.setExpandRatio(pnTabs, 1)
        setContent(content)
    }

    /**
     * Lo ideal es tener una clase para estos fines...
     * @return
     */
    public static Resource getImagenLogo(){
        String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        return new FileResource(new File(basepath +"/images/grails_logo.png"))
    }

}
