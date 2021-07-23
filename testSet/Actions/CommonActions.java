package Actions;

import Conditions.CommonConditions;
import Utilities.Utils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static Utilities.Utils.androidDriver;
import static Utilities.Utils.objRep;
import static org.testng.internal.Utils.log;

public class CommonActions {

    public CommonConditions commonConditions;
    public CommonActions commonActions;
    public int captura;
    TouchAction touchAction;
    Utils utils;
    public int[] enterKeyCoor;

    public CommonActions (){
        utils = new Utils();
        captura = 0;
        touchAction = new TouchAction(androidDriver);
        commonConditions = Utils.GetCommonConditions();
        enterKeyCoor = new int[]{644, 1374};
    }
              // cordenadas del finalizar para llamar paciente
              // (new TouchAction(driver)).tap(617, 1075).perform()
    /**
     * <p> Método para comprobar si se muestra el pop-up de error y lo cierra </p>
     * @throws NoSuchElementException
     */
    public void ComprobarErrorDialog(String texto){
        Utils.CambiarTiempoDeEspera(6);
        try {
            Utils.SearchAndroidElement("ErrorDialogo.Texto").isDisplayed();
            commonActions.PrintReportMessage("Se muestra pop-up de error");
            Assert.assertEquals(Utils.SearchAndroidElement("ErrorDialogo.Texto").getText(),texto);
            commonActions.PrintReportMessage("Con el texto correcto: "+texto);
            Utils.SearchAndroidElement("ErrorDialogo.Boton").click();
            commonActions.PrintReportMessage("Se cierra pop-up de error");

            /*
            if(androidDriver.findElementsById("com.radmas.iycp.casiopea.pre:id/error_dialog_text").size()!=0){
                androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/error_dialog_ok_button").click();
            }*/
        }catch(AssertionError e){
            CommonActions.CapturadorExcepcion("ComprobarErrorDialog.png", "El textod el mensaje de error no es correcto: "+texto);
            throw e;
        }catch(Exception e){
            commonActions.PrintReportMessage("No se muestra pop-up de error");
        }
        Utils.RestaurarTiempoDeEspera();

    }

    /**
     * <p> Método para hacer split de un string</p>
     * @param beforeSplit
     * @param separador
     */
    public String[] SplitString (String beforeSplit, String separador){

        String[] afterSplit = beforeSplit.split(separador);
        return afterSplit;
    }

    /**
     * <p> Método para hacer click sobre el filtro de cualquier estación </p>
     * @throws Exception
     */
    public void AbrirFiltroEstacion(){
        try {
            //Acceso
            Utils.SearchAndroidElement("Mapa.Filtro").click();
            commonActions.PrintReportMessage("Se hace click sobre el filtro correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("AbrirFiltroEstacion.png", "No se pudo hacer click sobre el filtro");
            throw e;
        }

    }

    /**
     * <p> Método para hacer click en la pestaña de la estación deseada </p>
     * @param estacion
     * @throws Exception
     */
    public void AccederEstacion(String estacion){
        //Acceder a la estación con el nombre indicado
        try {
            androidDriver.findElementByXPath("//*[@text='" + estacion + "']").click();
            commonActions.PrintReportMessage("Se hace click correctamente en "+estacion);
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("AccederEstacion.png", "No se pudo hacer click en "+estacion);
            throw e;
        }

    }


    public void BuscarPaciente(String paciente) throws Exception{
        //Escribe paciente en el buscador
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/text_search_edit_text").sendKeys(paciente);
        //Click enter del teclado
        //androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER );
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        //Comprueba que se ha encontrado el usuario buscado
        Assert.assertEquals(androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/patient_name_text_view").getText(),paciente);
        //click en paciente correcto
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/patient_name_text_view").click();
    }

    /**
     * <p> Método para comprobar si se muestra el tutorial y lo cierra en caso de que si se muestre</p>
     * @throws Exception
     */
    public void SaltarTutorial(){
        //APP - Saltar tutoriales por coordenadas. 4 pasos

        //if(Utils.SearchAndroidElement("Tutorial.Texto").isDisplayed()){
        Utils.CambiarTiempoDeEspera(7);
        try {



            if (androidDriver.findElementsById(objRep.ObjectID("Tutorial.Texto")).size() != 0) {
                commonActions.PrintReportMessage("Se muestra tutorial");
                Boolean boton = true;
                do {
                    if (!Utils.SearchAndroidElement("Tutorial.Boton").getText().equals("FINALIZAR")) {
                        Utils.SearchAndroidElement("Tutorial.Boton").click();
                    } else {
                        Utils.SearchAndroidElement("Tutorial.Boton").click();
                        boton = false;
                    }
                } while (boton);
                commonActions.PrintReportMessage("Se cierra el tutorial");
            }else commonActions.PrintReportMessage("No se muestra tutorial");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("SaltarTutorial.png", "Error al mostrar o cerrar tutorial");
            throw e;
        }
        Utils.RestaurarTiempoDeEspera();
    }

    /**
     * <p> Método para hacer tap en ENTER del tecldo numérico </p>
     */
    public void TapEnterKeyboard(){
        TapCoordenadas(this.enterKeyCoor[0],this.enterKeyCoor[1]);
    }

    /**
     * <p> Método para hacer tap en las coordenadas indicadas por parámetro </p>
     * @param x
     * @param y
     */
    public void TapCoordenadas(int x, int y){
        try {
            touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
        }catch(Exception e){
            commonActions.PrintReportMessage("Error al hacer TAP en las coordenadas "+x+" , "+y);
            throw e;
        }
    }

    /**
     * <p> Método para pulsar botón back del dispositivo </p>
     * @throws IOException
     */
    public void PulsarBotonBack(){
        try {
            androidDriver.navigate().back();
            commonActions.PrintReportMessage("Botón Back del dispositivo se pulsó correctamente");
        }catch(Exception e){
            commonActions.PrintReportMessage("No se pudo pulsar el botón Back del dispositivo");
            throw e;
        }
    }


    public void ReporteEjecucion() throws Exception{
        //Reporte del caso de prueba
        Allure.addAttachment("captura_"+(captura++)+"_", new ByteArrayInputStream(((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES)));
    }



    public void Volver(int pasos){
        try {
            for (int i = 0; i < pasos; i++) {
                Utils.SearchAndroidElement("Volver.Boton").click();
            }
            commonActions.PrintReportMessage("Se pudo pulsar correctamente el botón 'Volver' ["+pasos+"] veces");
        }catch(Exception e){
            commonActions.PrintReportMessage("No se pudo pulsar el botón 'Volver' ["+pasos+"] veces");
            throw e;
        }
    }


    /**
     * <p> Método capturador de excepciones, extensible a toda la aplicación </p>
     * @param fileName
     * @param message
     * @throws IOException
     */
    public static void CapturadorExcepcion(String fileName, String message) {
        try {
            //Captura de pantalla
            File scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("capturas/" + fileName));
            Allure.addAttachment(fileName, new ByteArrayInputStream(((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES)));
            //Mensaje de excepción
            PrintReportMessage(message);

        } catch (IOException e) {
            PrintReportMessage( "Error al capturar excepción");
            e.printStackTrace();
        }
    }

    /**
     * <p> Método que imprime por consola y en el report de allure mensajes de OK/KO </p>
     * @param message
     */
    public static void PrintReportMessage (String message){

        String guion = "\n-----------------------------------------------";
        System.out.println(message + guion);
        Allure.addAttachment("Step", message + guion);

    }

    /**
     * <p> Método para seleccioanr o deseleccionar un elemento de una lista </p>
     * @param elemento
     * @throws Exception
     */
    public static boolean SeleccionarDeseleccionarElementoLista (String elemento, String campo)
    {
        Utils.CambiarTiempoDeEspera(2);
        boolean estado = false;
        try{
            int numCampo;

            switch(campo){
                case "Asignación":
                    numCampo = 1;
                    break;
                case "Servicio":
                    numCampo = 3;
                    break;
                case "Unidad de enfermeria":
                    numCampo = 4;
                    break;
                default:
                    numCampo = 0;
            }

            for(int i=numCampo;i!=0;i++){
                //System.out.println("//android.widget.RelativeLayout["+i+"]/android.widget.TextView[2]");
                if(androidDriver.findElementsByXPath("//android.widget.RelativeLayout["+i+"]/android.widget.TextView[2]").size()!=0){
                    if(androidDriver.findElementByXPath("//android.widget.RelativeLayout["+i+"]/android.widget.TextView[2]").getText().equals(elemento)){
                        androidDriver.findElementByXPath("//android.widget.RelativeLayout["+i+"]/android.widget.Switch").click();
                        CommonActions.PrintReportMessage("Se seleciona correcrtamente el elemento: "+elemento);
                        estado = Boolean.parseBoolean(androidDriver.findElementByXPath("//android.widget.RelativeLayout["+i+"]/android.widget.Switch").getAttribute("checked"));
                        break;
                    }

                }else {
                    CommonActions.PrintReportMessage("No se encontró el elemento: "+elemento);
                    throw new EmptyStackException();
                    //break;
                }
            }
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("SeleccionarElementoLista.png", "No se pudo seleccionar el elemento de la lista: "+elemento);
            throw e;
        }
        Utils.RestaurarTiempoDeEspera();
        return estado;

    }



/*
    /// <summary>
    /// Método capturador de excepciones, extensible a toda la aplicación
    /// </summary>
    /// <param name="e"></param>
    /// <param name="fileName"></param>
    /// <param name="message"></param>
    public static void CapturadorExcepcion(Exception e, String fileName, String message)
    {
        ((ITakesScreenshot)driver).GetScreenshot().SaveAsFile(fileName);
        AllureLifecycle.Instance.AddAttachment(fileName);

        Console.WriteLine(message);

        Console.WriteLine("---------------------");
        Console.WriteLine("---------------------");
        Console.WriteLine("Excepción: " + e);
    }

 */
}
