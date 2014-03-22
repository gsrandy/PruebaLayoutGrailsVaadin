package app

import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.Component
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.TabSheet
import com.vaadin.ui.themes.Reindeer

/**
 * Created with IntelliJ IDEA.
 * User: vacax
 * Date: 03/21/14
 * Time: 08:32 PM
 * To change this template use File | Settings | File Templates.
 */
class PnTabs extends HorizontalLayout{

    TabSheet tabSheet

    public PnTabs(){

        tabSheet = new TabSheet()
        tabSheet.setSizeFull()

        //creamos el primer tab
        tabSheet.addTab(new TabCalendario(), "Calendario");

        tabSheet.addSelectedTabChangeListener(new TabSheet.SelectedTabChangeListener() {
            @Override
            void selectedTabChange(TabSheet.SelectedTabChangeEvent selectedTabChangeEvent) {
                Component component=selectedTabChangeEvent.tabSheet.getSelectedTab();
            }
        })

        this.setSizeFull()
        addComponent(tabSheet)
        //setMargin(new MarginInfo(false, true, false, true));
        setExpandRatio(tabSheet, 1)
        setStyleName(Reindeer.LAYOUT_BLUE)
    }

    /**
     * Metodo para agregar los tab de manera automatica
     * @param nombre
     * @param componente
     */
    public void addTabPanel(String nombre, Component componente){
        int cantidaTab=tabSheet.getComponentCount();
        println("Cantidad de tab registrados: "+cantidaTab);

        //SI EL TAB YA EXISTE ABIERTO, LO VOLVEMOS A SELECCIONAR
        boolean existe=false;
        (0..<cantidaTab).each { tabIndex->
            def tab=tabSheet.getTab(tabIndex);
            if(tab.getCaption() == nombre){
                existe=true;
                tabSheet.setSelectedTab(tabIndex);
            }
        }

        //SI EL TAB NO EXISTE, LO AGREGAMOS AL TABSHEET
        if(!existe){
            def tab=tabSheet.addTab(componente, nombre);
            tab.setClosable(true);
            tabSheet.setSelectedTab(tab);
        }
    }
}
