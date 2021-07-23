package Actions;

import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Utilities.Utils.androidDriver;

public class HospitalizacionActions {

    public WebDriverWait wait;
    Utils utils;
    public CommonActions commonActions;

    public HospitalizacionActions(){

            utils = new Utils();
            wait = new WebDriverWait(androidDriver, 120);
            commonActions = Utils.GetCommonActions();

    }

    /**
     * <p> Método para pulsar o dejar de pulsar el switch Asignación -> "Mis pacientes" </p>
     * @throws Exception
     */

    public void PulsarSwitchAsignacion() {
        try{
            Utils.SearchAndroidElement("H.Filtro.Asignacion.Switch").click();
            commonActions.PrintReportMessage("El Switch 'Mis pacientes' se pulsó correctamente");
        } catch (Exception e) {
            commonActions.CapturadorExcepcion("PulsarSwitchAsignacion.png", "ERROR el Switch 'Mis pacientes' no se encuentra");
            throw e;
        }
    }

    /**
     * <p> Método para pulsar el botón que abre la lista de selección de médico" </p>
     * @throws Exception
     */

    public void AbrirListaMedico() {
        try{
            Utils.SearchAndroidElement("H.Filtro.Medico").click();
            commonActions.PrintReportMessage("Se pulsa sobre abrir lista médico correctamente");
        } catch (Exception e) {
            commonActions.CapturadorExcepcion("AbrirListaMedico.png", "ERROR al intentar pulsar abrir lista médico");
            throw e;
        }
    }

    /**
     * <p> Método para Plegar / desplegar el campo de un elemento del filtro Hospitalización </p>
     * @param campoFiltro
     * @throws Exception
     */

    public void PlegarDesplegarLista(String campoFiltro) {
        //Utils.CambiarTiempoDeEspera(5);
        try {

            int numCampoFiltro;

            switch(campoFiltro){
                case "Asignación":
                    numCampoFiltro = 1;
                    break;
                case "Servicio":
                    numCampoFiltro = 2;
                    break;
                case "Unidad de enfermeria":
                    numCampoFiltro = 3;
                    break;
                default:
                    numCampoFiltro = 0;
            }
            androidDriver.findElementByXPath("//android.widget.RelativeLayout["+numCampoFiltro+"]/android.widget.ImageView").click();
            commonActions.PrintReportMessage("El campo: " + campoFiltro + " - Se desplegó correctamente");

        } catch (Exception e) {
            commonActions.CapturadorExcepcion("DesplegarLista.png", "No se pudo desplegar el campo: " + campoFiltro);
            throw e;
        }
    }

    /**
     * <p> Método para eliminar un elemento del filtro Hospitalización </p>
     * @param asignacion
     * @throws Exception
     */
    public void EliminarSeleccionFiltro(String asignacion, String campo) {
        Utils.CambiarTiempoDeEspera(2);
        try
        {
            commonActions.PrintReportMessage("INICIO proceso eliminar elementos");
            int i=0; //Asigna el valor de cada campo en el xpath
            switch(campo){
                case "Asignación":  i=1;
                    break;
                case "Servicio":  i=2;
                    break;
                case "Unidad de enfermeria":  i=3;
                    break;
            }
                int j = 1;//recorre el campo seleccionado en busca de el elemento a borrar
                while (j != 0) {
                    System.out.println("//android.widget.RelativeLayout[" + i + "]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + j + "]/android.widget.TextView");
                    if(!asignacion.equals("TODO")) { //Si el valor es TODO pasa al else y lo borra todo
                        if (androidDriver.findElementsByXPath("//android.widget.RelativeLayout[" + i + "]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + j + "]/android.widget.TextView").size() != 0) {
                            System.out.println("Entar 1");
                            String seleccion = androidDriver.findElementByXPath("//android.widget.RelativeLayout[" + i + "]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + j + "]/android.widget.TextView").getText();
                                if (seleccion.equals(asignacion)) {
                                    commonActions.PrintReportMessage("Se encontró el elemento: " + asignacion);
                                    //do {
                                    androidDriver.findElementByXPath("//android.widget.RelativeLayout[" + i + "]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + j + "]/android.widget.ImageView").click();
                                 //}while(androidDriver.findElementsByXPath("//android.widget.RelativeLayout[" + i + "]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + j + "]/android.widget.TextView").size()!=0);
                                    j = 0;
                                    commonActions.PrintReportMessage("Se eliminó el elemento: " + asignacion);
                                } else j++;
                        } else {
                            System.out.println("Entar 4");
                            j = 0;
                        }
                    }else{
                        System.out.println("Entar 3");
                            int k = 0;
                            while(androidDriver.findElementsByXPath("//android.widget.RelativeLayout[" + i + "]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView").size() != 0) {
                                androidDriver.findElementByXPath("//android.widget.RelativeLayout[" + i + "]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView").click();
                                k++;
                            }
                            commonActions.PrintReportMessage("Se eliminaron ["+k+"] elementos");
                            break;
                    }
                }
            commonActions.PrintReportMessage("FIN proceso eliminar elementos");

        }catch(Exception e){
            commonActions.CapturadorExcepcion("EliminarSeleccionFiltro.png", "No se pudo eliminar el elemento: "+asignacion);
            throw e;
        }
        Utils.RestaurarTiempoDeEspera();
    }


    /**
     * <p> Método para pulsar el botón que abre la lista de selección de médico" </p>
     * @throws Exception
     */

 /*   public void SeleccionarDeseleccionarServicio(String servicio) {
        try{
            // Deseleccionamos CARDIOLOGÍA
            Utils.SearchAndroidElement("H.Filtro.Medico").click();
            commonActions.PrintReportMessage("Se pulsa sobre abrir lista médico correctamente");
            EliminarSeleccionFiltro(String asignacion, ElementoListaSeleccion);
            // Seleccionamos CARDIOLOGÍA

        } catch (Exception e) {
            commonActions.CapturadorExcepcion("AbrirListaMedico.png", "ERROR al intentar pulsar abrir lista médico");
            throw e;
        }
    }*/

}
