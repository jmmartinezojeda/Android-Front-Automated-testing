package Actions;

import Utilities.Utils;
import com.sun.corba.se.impl.encoding.EncapsInputStream;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;

import javafx.scene.input.KeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.ByteArrayInputStream;
import java.security.Key;

import static Utilities.Utils.androidDriver;

public class FlujoPrincipalActions {

    public WebDriverWait wait;
    Utils utils;
    public CommonActions commonActions;

    public FlujoPrincipalActions(){

            utils = new Utils();
            wait = new WebDriverWait(androidDriver, 120);
            commonActions = Utils.GetCommonActions();

    }

    /**
     * <p> Método para rellenar los input de Login y código de confirmación </p>
     * @param user
     * @throws Exception
     */
    public void RellenarInputLoginCodigo(String user) {

        try
        {

            // Rellenar Nombre
            utils.SearchAndroidElement("LoginUno.Input").click();
            utils.SearchAndroidElement("LoginUno.Input").sendKeys(user);

            commonActions.PrintReportMessage("Se rellenó correctamente el input Login/Codgio confirmación con el valor: "+user);

        }catch(Exception e){
            commonActions.CapturadorExcepcion("RellenarInputLogin-Codigo.png", "No se pudo Rellenar el input Login/Codgio confirmación");
            throw e;
        }
    }

    /**
     * <p> Método para rellenar el codigo de confirmación enviado por SMS </p>
     * @return El código de confirmación que recupera de la BD
     * @throws Exception
     *
     */
    public String RellenarCodigoConfirmacion()  {
        // Rellenar Código de confirmacion
        Utils.GetSQLDatabaseConnection().ConexionBD(); //Conecxión BBDD para recueprar código
        String codConfir = Utils.GetSQLDatabaseConnection().getCodigoConfirmacion();
        try {
            RellenarInputLoginCodigo(codConfir);
            commonActions.PrintReportMessage("Se rellenó correctamente el código de confirmación");
            return codConfir;
        }catch (Exception e){
            CommonActions.CapturadorExcepcion("RellenadoLoginUno.png", "No se encuentra input Código de confirmación");
            throw e;
        }
    }


    /**
     * <p> Método para rellenar el input buscar </p>
     * @throws Exception
     */
        public void RellenarMapaBuscador(String buscarPaciente){
        Utils.RestaurarTiempoDeEspera();
        try {
            Utils.SearchAndroidElement("Mapa.InputBuscar").click();
            while(!androidDriver.isKeyboardShown()){}
            androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
            androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
            androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
            androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
            androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
            androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            //Utils.EscribeTeclado(buscarPaciente);
            //Utils.SearchAndroidElement("Mapa.InputBuscar").sendKeys(buscarPaciente);
            commonActions.PrintReportMessage("Se rellenó correctamente el input Buscar con el valor: "+buscarPaciente);
            }catch(Exception e){
            CommonActions.CapturadorExcepcion("RellenarMapaBuscador.png", "No se encuentra el input Buscar");
            throw e;
        }
        }


    /**
     * <p> Método para rellenar el input buscar Paciente Nombre</p>
     * @throws Exception
     */
    public void RellenarMapaBuscadorPacienteNombre(String buscarPaciente){
        Utils.RestaurarTiempoDeEspera();
        try {
            Utils.SearchAndroidElement("Mapa.InputBuscar").click();
            while(!androidDriver.isKeyboardShown()){}
            androidDriver.pressKey(new KeyEvent(AndroidKey.CAPS_LOCK));
            androidDriver.pressKey(new KeyEvent(AndroidKey.CAPS_LOCK));
            androidDriver.pressKey(new KeyEvent(AndroidKey.P));
            androidDriver.pressKey(new KeyEvent(AndroidKey.R));
            androidDriver.pressKey(new KeyEvent(AndroidKey.U));
            androidDriver.pressKey(new KeyEvent(AndroidKey.E));
            androidDriver.pressKey(new KeyEvent(AndroidKey.B));
            androidDriver.pressKey(new KeyEvent(AndroidKey.A));
            androidDriver.pressKey(new KeyEvent(AndroidKey.SPACE));
            androidDriver.pressKey(new KeyEvent(AndroidKey.A));
            androidDriver.pressKey(new KeyEvent(AndroidKey.U));
            androidDriver.pressKey(new KeyEvent(AndroidKey.T));
            androidDriver.pressKey(new KeyEvent(AndroidKey.O));
            androidDriver.pressKey(new KeyEvent(AndroidKey.M));
            androidDriver.pressKey(new KeyEvent(AndroidKey.A));
            androidDriver.pressKey(new KeyEvent(AndroidKey.T));
            androidDriver.pressKey(new KeyEvent(AndroidKey.I));
            androidDriver.pressKey(new KeyEvent(AndroidKey.Z));
            androidDriver.pressKey(new KeyEvent(AndroidKey.A));
            androidDriver.pressKey(new KeyEvent(AndroidKey.C));
            androidDriver.pressKey(new KeyEvent(AndroidKey.I));
            androidDriver.pressKey(new KeyEvent(AndroidKey.O));
            androidDriver.pressKey(new KeyEvent(AndroidKey.N));
            androidDriver.pressKey(new KeyEvent(AndroidKey.SPACE));
            androidDriver.pressKey(new KeyEvent(AndroidKey.A));
            androidDriver.pressKey(new KeyEvent(AndroidKey.U));
            //Utils.EscribeTeclado(buscarPaciente);
            //Utils.SearchAndroidElement("Mapa.InputBuscar").sendKeys(buscarPaciente);
            commonActions.PrintReportMessage("Se rellenó correctamente el input Buscar con el valor: "+buscarPaciente);
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("RellenarMapaBuscador.png", "No se encuentra el input Buscar");
            throw e;
        }
    }

    /**
     * <p> Método para comenzar la búsqueda de pacientes en el input buscar </p>
     * @throws Exception
     */
    public void BuscarPaciente(){
        try {
            Utils.SearchAndroidElement("Mapa.InputBuscar").click();
            Utils.SearchAndroidElement("Mapa.InputBuscar").click();
            commonActions.TapEnterKeyboard();
            commonActions.PrintReportMessage("Se inicia la búsqueda de paciente correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("BuscarPaciente.png", "Error al intentar buscar paciente");
            throw e;
        }

    }

     /**
     * <p> Método para pulsa botón login </p>
     * @throws Exception
     */
    public void PulsarBotonLogin(){
        try {
            utils.SearchAndroidElement("Login.Boton").click();
            commonActions.PrintReportMessage("Se pulsó botón Login correctamente");

        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarBotonLogin.png", "No se pudo pulsar botón Login");
            throw e;
        }
    }

    /**
     * <p> Método para pulsa botón root </p>
     * @throws Exception
     */
    public void PulsarBotonRoot(){
        try {
            utils.SearchAndroidElement("LoginUno.BotonRoot").click();
            commonActions.PrintReportMessage("Se pulsó botón root correctamente");

        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarBotonRoot.png", "No se pudo pulsar botón Root");
            throw e;
        }
    }

    /**
     * <p> Método para desplegar la lista de centros disponibles para el usuario </p>
     * @throws Exception
     */
    public void PulsarListaCentros(){
        try {
            Utils.SearchAndroidElement("LoginDos.ListCentro").click();
            commonActions.PrintReportMessage("Se pulsa lista de centros");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarListaCentros.png", "No se pudo pulsar la lista de centros");
            throw e;
        }
    }

    /**
     * <p> Método para hacer click sobre el botón 'Más' del flujo principal </p>
     * @throws Exception
     */
    public void PulsarMasFP(){
        try {
            Utils.SearchAndroidElement("Mas.Boton").click();
            commonActions.PrintReportMessage("Botón 'Más' pulsado correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarMasFP.png", "No se pudo pulsar sobre el botón 'Más'");
            throw e;
        }
    }

    /**
     * <p> Método para hacer click sobre el botón 'Notificaciones' del flujo principal </p>
     * @throws Exception
     */
    public void PulsarNotificaciones(){
        try {
            Utils.SearchAndroidElement("Notificaciones.Boton").click();
            commonActions.PrintReportMessage("Botón 'Notificaciones' pulsado correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarNotificaciones.png", "No se pudo pulsar sobre el botón 'Notificaciones'");
            throw e;
        }
    }

    /**
     * <p> Método para hacer click sobre el botón 'Interconsultas' del flujo principal </p>
     * @throws Exception
     */
    public void PulsarConversaciones(){
        try {
            Utils.SearchAndroidElement("Conversaciones.Boton").click();
            commonActions.PrintReportMessage("Botón 'Conversaciones' pulsado correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarConversaciones.png", "No se pudo pulsar sobre el botón 'Conversaciones'");
            throw e;
        }
    }

    /**
     * <p> Método para hacer click sobre el botón 'Notificaciones' del flujo principal </p>
     * @throws Exception
     */
    public void PulsarInterconsultas(){
        try {
            Utils.SearchAndroidElement("Interconsultas.Boton").click();
            commonActions.PrintReportMessage("Botón 'Interconsultas' pulsado correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarInterconsultas.png", "No se pudo pulsar sobre el botón 'Interconsultas'");
            throw e;
        }
    }

    /**
     * <p> Método para desplegar la lista de cambio de centro</p>
     * @throws Exception
     */
    public void PulsarListaCambioCentro(){
        try {
            Utils.SearchAndroidElement("Mas.CambioCentro").click();
            commonActions.PrintReportMessage("Se abre la lista de centros disponibles para cambio de centro");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarListaCambioCentro.png", "No puede abrir la lista de cambio de centro");
            throw e;
        }
    }

    /**
     * <p> Método para hacer click en el menú Mapa</p>
     * @throws Exception
     */
    public void PulsarMapa(){
        try {
            Utils.SearchAndroidElement("Mapa.Boton").click();
            commonActions.PrintReportMessage("Menú 'Mapa' pulsado correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarMapa.png", "No puede pulsar el menú 'Mapa'");
            throw e;
        }
    }
    /**
     * <p> Método para hacer click en llamar a soporte en FJ</p>
     * @throws Exception
     */
    public void PulsarLlamarSoporte(){
        try {
            Utils.SearchAndroidElement("Mas.LlamarASoporte").click();
            commonActions.PrintReportMessage("Click en Llamar a soporte correcto");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarLlamarSoporte.png", "No pudo pulsar en 'Llamar a soporte'");
            throw e;
        }
    }

    /**
     * <p> Método para hacer click en Desconectarse</p>
     * @throws Exception
     */
    public void PulsarDesconectarse(){
        try {
            Utils.SearchAndroidElement("Mas.Desconectar").click();
            commonActions.PrintReportMessage("Click en Desconectarse correcto");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarDesconectarse.png", "No puedo pulsar en 'Desconectarse'");
            throw e;
        }
    }

    /**
     * <p> Método para rellenar los imputs login y password del usuario con los valores pasados por parametro </p>
     * @param user
     * @param pass
     * @throws Exception
     */
    public void RellenarLoginDos(String user, String pass){
        try {
            // Rellenar Nombre
            Utils.SearchAndroidElement("LoginDos.InputUser").click();
            Utils.SearchAndroidElement("LoginDos.InputUser").sendKeys(user);
            // Rellenar Password
            Utils.SearchAndroidElement("LoginDos.InputPass").click();
            Utils.SearchAndroidElement("LoginDos.InputPass").sendKeys(pass);

            commonActions.PrintReportMessage("Se rellenaron correctamente los input Login/Password");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("RellenarLoginDos.png", "No se pudieron Rellenar los input Login/Password");
            throw e;
        }
    }

    //Nota: Tener en cuenta para adaptar a la selección de cualquier elemento en dropdown list
    /**
     * <p> Método para seleccionar un centro disponible para el usuario en la lista desplegable de centros </p>
     * @param centro centro que se desea seleccionar
     * @throws Exception
     */
    public void SeleccionarCentro(String centro){
        try {
            androidDriver.findElementByXPath("//*[@text='"+centro+"']").click();
            commonActions.PrintReportMessage("Se seleccionó correctamente el centro: "+centro);
        }catch(Exception e){
            commonActions.CapturadorExcepcion("SeleccionarCentro.png", "No se pudo seleccionar el centro "+centro);
        }
    }


}
