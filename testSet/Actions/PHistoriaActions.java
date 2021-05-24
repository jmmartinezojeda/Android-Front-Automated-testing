package Actions;

import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Utilities.Utils.androidDriver;

public class PHistoriaActions {

    public WebDriverWait wait;
    Utils utils;
    public CommonActions commonActions;

    public PHistoriaActions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
    }

    /**
     * <p> Método para hacer click en filtro historia</p>
     * @throws Exception
     */
    public void PulsarFiltroHistoria() {

        try {
            Utils.SearchAndroidElement("Historia.Filtro").click();
            commonActions.PrintReportMessage("El botón filtro de Historia se pulsa correctamente");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsarFiltroHistoria.png", "ERROR al pulsar el filtro de Historia de paciente");
            throw e;
        }

    }

    /**
     * <p> Método para hacer click en Historial Covid</p>
     * @throws Exception
     */
    public void PulsarCovid() {

        try {
            Utils.SearchAndroidElement("Historia.Covid").click();
            commonActions.PrintReportMessage("Se pulsa Historial Covid");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsarCovid.png", "ERROR al pulsar historial Covid");
            throw e;
        }

    }
    /**
     * <p> Método para hacer click en Alergias</p>
     * @throws Exception
     */
    public void PulsarAlergias() {

        try {
            Utils.SearchAndroidElement("Historia.Alergias").click();
            commonActions.PrintReportMessage("Se pulsa Alergias");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsarAlergias.png", "ERROR al pulsar Alergias");
            throw e;
        }

    }

    /**
     * <p> Método para hacer click en Evolucion</p>
     * @throws Exception
     */
    public void PulsarEvolucion() {
        try {
            Utils.SearchAndroidElement("Historia.Evolucion").click();
            commonActions.PrintReportMessage("Se pulsa Evolucion");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsarEvolucion.png", "ERROR al pulsar Evolucion");
            throw e;
        }
    }


    /**
     * <p> Método para hacer Seleccionar las opciones de filtrado de historia pacientes según parametro</p>
     * @param opciones
     * @throws Exception
     */
    public void SeleccionarOpcionesFiltroHistoria(String opciones) {

        try {
            String[] opcionesSeparadas = commonActions.SplitString(opciones, ",");

            String [] opcionesSeparadasBool = new String[opcionesSeparadas.length];
            //TRansforma en el tipo de respuesta (true/false) en string del string del parametro
            for (int i=0; i<opcionesSeparadas.length;i++) {
                if (opcionesSeparadas[i].equals("SI")) opcionesSeparadasBool[i] = "true";
                else opcionesSeparadasBool[i] = "false";
            }

            for (int i=1; i<=opcionesSeparadas.length;i++) {
                System.out.println(i+" Iteracion");
                System.out.println("Variable: "+ opcionesSeparadasBool[i-1]);
                System.out.println("Ckeck valor: "+ androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout[" + i + "]/android.widget.Switch").getAttribute("checked"));
                if(!(androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout[" + i + "]/android.widget.Switch").getAttribute("checked").equals(opcionesSeparadasBool[i-1]))) {
                    System.out.println("Entra dentro 1");
                    androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout[" + i + "]/android.widget.Switch").click();
                    System.out.println("Saleee 2");
                }else System.out.println("No pasa nada");
            }
            commonActions.PrintReportMessage("Las opciones se seleccionan correctamente");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("SeleccionarOpcionesFiltroHistoria.png", "ERROR al seleccionar las opciones de filtrado de filtro historia");
            throw e;
        }

    }

}
