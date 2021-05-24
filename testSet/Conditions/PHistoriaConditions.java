package Conditions;

import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Utilities.Utils.androidDriver;

public class PHistoriaConditions {
    public WebDriverWait wait;
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public FlujoPrincipalActions flujo_principalActions;
    public FlujoPrincipalConditions flujo_principalConditions;
    Utils utils;

    public PHistoriaConditions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
        flujo_principalActions = Utils.GetFlujo_PrincipalActions();
        flujo_principalConditions = Utils.GetFlujo_PrincipalConditions();
    }


            /**
             * <p> Método para comprobar que se abre el historial Covid</p>
             * @throws Exception
             * @throws AssertionError
             */
        public void PulsadoCovid() {

            try {

                Utils.SearchAndroidElement("Historia.Covid.Historial");

                commonActions.PrintReportMessage("Se abre correctamente el historial Covid");
            }catch(Exception e){
                CommonActions.CapturadorExcepcion("PulsadoCovid.png", "ERROR al abrir el historial Covid");
                throw e;
            }

        }

    /**
     * <p> Método para comprobar que se abre Alergias</p>
     * @throws Exception
     * @throws AssertionError
     */
    public void PulsadoAlergias() {

        try {

            Utils.SearchAndroidElement("Historia.Alergias.Titulo");

            commonActions.PrintReportMessage("Se abre correctamente Alergias");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoAlergias.png", "ERROR al abrir Alergias");
            throw e;
        }

    }

    /**
     * <p> Método para comprobar que se abre Evolucion</p>
     * @throws Exception
     * @throws AssertionError
     */
    public void PulsadoEvolucion() {

        try {
            Utils.SearchAndroidElement("Historia.Evolucion.Titulo");

            commonActions.PrintReportMessage("Se abre correctamente Evolucion");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoEvolucion.png", "ERROR al abrir Evolucion");
            throw e;
        }

    }

    /**
     * <p> Método para comprobar que se cierra el historial Covid</p>
     * @throws Exception
     * @throws AssertionError
     */
    public void CerradoCuadro(String texto) {
        Utils.CambiarTiempoDeEspera(3);
        try {

            Utils.SearchAndroidElement("Historia.Covid.Historial");

            commonActions.PrintReportMessage("No se cierra correctamente "+texto);

        }catch(Exception e){
            commonActions.PrintReportMessage("Se cierra correctamente "+ texto);
        }
        Utils.RestaurarTiempoDeEspera();

    }



    /**
     * <p> Método para comprobar que se abre el filtro de historia de paciente </p>
     * @throws Exception
     * @throws AssertionError
     */
    public void PulsadoFiltroHistoria() {

        try {
            commonConditions.ComprobarBarraTitulo("Filtros historia");

            Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout["+1+"]/android.widget.TextView").getText(), "Informe");
            Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout["+2+"]/android.widget.TextView").getText(), "Formulario");
            Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout["+3+"]/android.widget.TextView").getText(), "Nota");
            Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout["+4+"]/android.widget.TextView").getText(), "Petición");
            Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout["+5+"]/android.widget.TextView").getText(), "Foto");

            commonActions.PrintReportMessage("Se abre correctamente filtro de historia de paciente");
        }catch(AssertionError e){
            CommonActions.CapturadorExcepcion("PulsadoFiltroHistoria.png", "ERROR con los switchs de filtro historia");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoFiltroHistoria.png", "ERROR al abrir el filtro de historia de paciente");
            throw e;
        }

    }

    /**
     * <p> Método para comprobar la selección de las opciones de filtrado de historia pacientes según parametro</p>
     * @param opciones
     * @throws Exception
     */
    public void SeleccionadasOpcionesFiltroHistoria(String opciones) {

        try {
            String[] opcionesSeparadas = commonActions.SplitString(opciones, ",");

            String [] opcionesSeparadasBool = new String[opcionesSeparadas.length];
            //TRansforma en el tipo de respuesta (true/false) en string del string del parametro
            for (int i=0; i<opcionesSeparadas.length;i++) {
                if (opcionesSeparadas[i].equals("SI")) opcionesSeparadasBool[i] = "true";
                else opcionesSeparadasBool[i] = "false";
            }

            for (int i=1; i<=opcionesSeparadas.length;i++) {
                Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout[" + i + "]/android.widget.Switch").getAttribute("checked"),opcionesSeparadasBool[i-1]);
            }
            commonActions.PrintReportMessage("Se han seleccionado las opciones correctas");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("SeleccionadasOpcionesFiltroHistoria.png", "ERROR al seleccionar las opciones de filtrado de filtro historia de paciente");
            throw e;
        }

    }

    /**
     * <p> Método para comprobar que se abre el filtro de historia de paciente </p>
     * @throws Exception
     * @throws AssertionError
     */
    public void HistoriaPacienteFiltrada(String num) {

        int numInt = Integer.parseInt(num);
        try {
            //Compara cuantos elementos hay (Siempre suma 1 porque isempre hayun elemento con el mismo XPATH que no pertenece al listado de historia)
            Assert.assertEquals(androidDriver.findElementsByXPath("//android.widget.FrameLayout/android.widget.RelativeLayout").size(),numInt+1);

            commonActions.PrintReportMessage("El resultado de Historia es correcto");
        }catch(AssertionError e){
            CommonActions.CapturadorExcepcion("HistoriaPacienteFiltrada.png", "El resultado del filtrado no es correcto");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("HistoriaPacienteFiltrada.png", "ERROR al mostrar el menú historia de paciente");
            throw e;
        }

    }
}
