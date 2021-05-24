package Conditions;

import Actions.CommonActions;
import Utilities.Utils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;

import static Utilities.Utils.androidDriver;
import static Utilities.Utils.objRep;

public class FlujoPrincipalConditions {

    public WebDriverWait wait;
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    Utils utils;

    public FlujoPrincipalConditions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
    }

    /**
     * <p> Método para comprobar que el Login Uno está rellando correctamente </p>
     * @param user
     * @throws AssertionError
     * @throws Exception
     */
    public void RellenadoLoginUno(String user) {
        try {
            // Comprobar nombre rellenado
            Assert.assertEquals(utils.SearchAndroidElement("LoginUno.Input").getText(), user);
            commonActions.PrintReportMessage("Valor Rellenado correcto en LoginUno");

        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("RellenadoLoginUno.png", "Valor Rellenado incorrecto en LoginUno");
            throw e;

        }catch(Exception e){
            CommonActions.CapturadorExcepcion("RellenadoLoginUno.png", "No se encuentra input LoginUno");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que el Codigo de Confirmación está rellando correctamente</p>
     * @param codConfir
     * @throws AssertionError
     * @throws Exception
     */
    public void RellenadoCodigoConfirmacion(String codConfir){
        try{
            Assert.assertEquals(Utils.SearchAndroidElement("LoginUno.Input").getText(), codConfir);
            commonActions.PrintReportMessage("Valor Rellenado correcto en Codigo confirmacion");
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("RellenadoCodigoConfirmacion.png", "Valor Rellenado incorrecto en Codigo Confirmacion");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("RellenadoCodigoConfirmacion.png", "No se encuentra input Codigo Confirmacion");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que el input buscar se ha rellanado correctamente con el paciente que se quiere buscar</p>
     * @param buscarPaciente
     * @throws AssertionError
     * @throws Exception
     */
    public void RellenadoMapaBuscador(String buscarPaciente){
        try {
            Utils.SearchAndroidElement("Mapa.BorrarBuscar").isDisplayed();
            // Comprobar nombre rellenado
            Assert.assertEquals(Utils.SearchAndroidElement("Mapa.InputBuscar").getText(), buscarPaciente);
            commonActions.PrintReportMessage("P<ciente Rellenado correctamente en Buscar");
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("RellenadoMapaBuscador.png", "Paciente Rellenado incorrectamente en Buscar");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("RellenadoMapaBuscador.png", "Error con input buscar");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se ha rellanado correctamente el Login/Password Dos</p>
     * @param user
     * @param pass
     * @throws AssertionError
     * @throws Exception
     */
    public void RellenadoLoginDos(String user, String pass) {

        try {
            // Comprobar nombre rellenado
            Assert.assertEquals(Utils.SearchAndroidElement("LoginDos.InputUser").getText(), user);
            // Comprobar pass rellenado
            //1º - Click en ojo para ver pass
            Utils.SearchAndroidElement("LoginDos.InputPass").click();
            Utils.SearchAndroidElement("LoginDos.InputPass").click();

            Utils.SearchAndroidElement("LoginDos.VerPass").click();
            Utils.SearchAndroidElement("LoginDos.VerPass").click();
            //2º - Comprueba el pass
            while (Utils.SearchAndroidElement("LoginDos.InputPass").getText().equals("•••••••••••")) ;
            Assert.assertEquals(Utils.SearchAndroidElement("LoginDos.InputPass").getText(), pass);

            commonActions.PrintReportMessage("Login/Password Dos rellenado correctamente");
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("RellenadoLoginDos.png", "Login/Password Dos no está rellenado correctamente");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("RellenadoLoginDos.png", "No se encuentra imput Login/Password Dos");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se ha seleccionado el centro correcto en Login Dos</p>
     * @param centro
     * @throws AssertionError
     * @throws Exception
     */
    public void SeleccionadoCentro (String centro){
        try{
            //Muchas veces se queda parado con este valor mientras carga el correspondiente y puede dar lugar a dar la prueba erronea cuando en realidad no lo es
            while(Utils.SearchAndroidElement("LoginDos.ListCentroSelect").getText().equals("Cargando centros…"));

        Assert.assertEquals(Utils.SearchAndroidElement("LoginDos.ListCentroSelect").getText(),centro);
        commonActions.PrintReportMessage("Centro "+ centro +" seleccionado correctamente");

        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("SeleccionadoCentro.png", "Centro seleccionado incorrecto");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("SeleccionadoCentro.png", "No se encuentra el campo centro seleccionado");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que el botón Login Uno se ha pulsado </p>
     * @throws Exception
     */
    public void PulsadoBotonLoginUno(){
        try {
            //Se muestra la pantalla de introducir código
            Utils.SearchAndroidElement("LoginUno.TextoConfirmacion");
            commonActions.PrintReportMessage("Se muestra la pantalla de introducir código SMS");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoBotonLoginUno.png", "No se muestra la pantalla de introducir código SMS");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se ha desplegado con los valores correctos la lista de centros del login </p>
     * @param listaCentros
     * @throws Exception
     */
    public void PulsadaListaCentros(String listaCentros){

        try {
            String[] listaCentrosArray = commonActions.SplitString(listaCentros, ",");
            commonConditions.ComprobarListado(listaCentrosArray, objRep.ObjectID("LoginDos.ListCentroDesplegada"));
            commonActions.PrintReportMessage("Se muestra correctamente la lista desplegable de Centros con los centros asignados al usuario");
            //"/android.widget.TextView"
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadaListaCentros.png", "No se muestra la lista de centros correctamente");
            throw e;
        }

    }

    /**
     * <p> Método para comprobar que se muestra correctamente la pantalla 'Más' </p>
     * @param centroActual se pasa por parametro el hospital actual para comprobar que se muestra el correcto en el menú más
     * @throws AssertionError
     * @throws Exception
     */
    public void PulsadoMasFP(String centroActual){
        try {
            Assert.assertEquals(Utils.SearchAndroidElement("Mas.BarraTitulo").getText(), "Más");
            Assert.assertEquals(Utils.SearchAndroidElement("Mas.CambioCentro").getText(), centroActual);//Se comprueba centro actual por parametro
            Assert.assertEquals(Utils.SearchAndroidElement("Mas.LlamarASoporte").getText(), "Llamar a soporte");
            Assert.assertEquals(Utils.SearchAndroidElement("Mas.Desconectar").getText(), "DESCONECTARSE");

            commonActions.PrintReportMessage("Se muestra correctamente la pantalla 'Más' con las opciones correctas y el hospital actual");
        }catch(AssertionError e){
            CommonActions.CapturadorExcepcion("PulsadoMasFP.png", "Un menú o el hospital actual no se muestra correctamente");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoMasFP.png", "Error al mostrar la pantalla 'Más'");
            throw e;
        }
    }


    /**
     * <p> Método para comprobar que se muestra correctamente la pantalla 'Conversaciones' </p>
     * @throws AssertionError
     * @throws Exception
     */
    public void PulsadoConversaciones(){
        try {
            Utils.SearchAndroidElement("Conversaciones.Contenedor");
            commonActions.PrintReportMessage("Se muestra correctamente la pantalla 'Conversaciones'");
        }catch(AssertionError e){
            CommonActions.CapturadorExcepcion("PulsadoMasFP.png", "'Conversaciones' no se muestra correctamente");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoMasFP.png", "Error al mostrar la pantalla 'Conversaciones'");
            throw e;
        }
    }


    /**
     * <p> Método para comprobar que se muestra correctamente la lista de los centros disponibles para el cambio de centro</p>
     * @param listaCentros
     * @throws Exception
     */
    public void PulsadaListaCambioHospital(String listaCentros){
        try {
            String[] listaCentrosArray = commonActions.SplitString(listaCentros, ",");
            commonConditions.ComprobarListado(listaCentrosArray, objRep.ObjectID("Mas.ListCentroDesplegada"));
            commonActions.PrintReportMessage("Se muestra correctamente la lista desplegable de Centros con los centros disponibles para cambio de centro");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadaListaCambioHospital.png", "No se muestra la lista de centros de cambio de centro, correctamente");
            throw e;
        }

    }

    /**
     * <p> Método para comprobar que se muestra la pantalla Login Dos </p>
     * @throws Exception
     */
    public void MostradoLoginDos(){

        //Se comprueba si se muestra el pop-up de root
        String texto = "Se ha detectado que el dispositivo tiene root. Se recomienda usar la aplicación en dispositivos sin él para su seguridad. Si continúa, es bajo su propia responsabilidad.";
        commonActions.ComprobarErrorDialog(texto);
        try {
            //Se muestra la pantalla de login 2
            Utils.SearchAndroidElement("LoginDos.ListCentro");
            commonActions.PrintReportMessage("Se muestra correctamente la pantalla Login 2");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("MostrarPantallaLoginDos.png", "No se muestra la pantalla Login 2");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se muestra la version de APP correcta en Login Dos </p>
     * @param version
     * @throws AssertionError
     * @throws Exception
     */
    public void MostradoVersionCorrecta(String version){

        try {
            //Se muestra la pantalla de login 2
            Assert.assertEquals(Utils.SearchAndroidElement("Version.Texto").getText(), version);
            commonActions.PrintReportMessage("Se muestra correctamente la version de la APP: "+version);
        }catch(AssertionError e){
            CommonActions.CapturadorExcepcion("PulsadoMasFP.png", "No se muestra la version correcta: "+version);
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("MostrarPantallaLoginDos.png", "No se encuentra la version de la APP");
            throw e;
        }
    }

    /**
     * <p> Método para mostrar la versión actual de la APP </p>
     * @throws Exception
     */
    public void MostradoVersion(){

        try {
            commonActions.PrintReportMessage("Versión actual de Caiopea Mobility: "+Utils.SearchAndroidElement("Version.Texto").getText()+" ****************************");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("MostrarPantallaLoginDos.png", "ERROR al mostrar la versión actual de la APP");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se muestra correctamente la pantalla de INICIO </p>
     * @throws Exception
     */
    public void MostradoInicio(String estacionDefecto){
        commonActions.SaltarTutorial();
        //Comprobar que nos lleva al menú INICIO
        try {
            this.MostradoMapa();

            //Boton conversaciones con o sin nuevas notificaciones
            if(androidDriver.findElementsByAccessibilityId(objRep.ObjectID("Conversaciones.Boton")).size()>0) {
                Utils.SearchAndroidElement("Conversaciones.Boton");
            }else{
                Utils.SearchAndroidElement("Conversaciones.BotonNotificaciones");
            }

            Utils.SearchAndroidElement("Interconsultas.Boton");
            Utils.SearchAndroidElement("Notificaciones.Boton");
            Utils.SearchAndroidElement("Mas.Boton");

            commonConditions.AccesoEstacion(estacionDefecto);


            commonActions.PrintReportMessage("Se muestra correctamente la pantalla de inicio");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("MostradoInicio.png", "No se muestra correctamente la pantalla de inicio");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se muestra correctamente el menu mapa </p>
     * @throws Exception
     */
    public void MostradoMapa(){
        //Comprobar que se muestra correctamente el menú mapa
        try {
            Utils.SearchAndroidElement("Mapa.MenuEstaciones");
            Utils.SearchAndroidElement("Mapa.ListaPacientes");
            Utils.SearchAndroidElement("Mapa.MenuBuscar");
            //5 botones
            Utils.SearchAndroidElement("Mapa.Boton");//pacientes

            commonActions.PrintReportMessage("Se muestra correctamente el menú mapa");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("MostradoMapa.png", "No se muestra correctamente el menu mapa");
            throw e;
        }
    }

}
