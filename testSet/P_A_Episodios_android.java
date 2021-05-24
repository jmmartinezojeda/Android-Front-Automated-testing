import Actions.CommonActions;
import Utilities.ObjectRepositoryUtils;
import Utilities.Utils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.net.URL;

public class P_A_Episodios_android {
    Utils utils = new Utils();

    public URL url;
    public DesiredCapabilities capabilities;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public String user = "delega3";
    public String pass = "efron20141";
    public String hospital = "HOSPITAL INFANTA ELENA";
    //1-Hospitalizacion
    //2-Urgencias
    //3-Consultas
    //4-Quirófanos
    public String estacion = "Hospitalizacion";
    //Pacientes
    //
    public String paciente = "EMMA VICTORIA FL MP";

    @BeforeSuite
    public void setupAppium() throws Exception {
        utils.Instanciador_Android();
        url = Utils.GetUrl();
        capabilities = Utils.GetCapabilities();
        objRepo = Utils.GetObjRepo();
        androidDriver = Utils.GetAndroidDriver();
        //Login1, Login2 y borrar filtro
        //commonActions.Login1(this.user);
        //commonActions.Login2(this.user,this.pass,this.hospital);
        //commonActions.BorrarFiltroInicial();

    }

    @AfterSuite
    public void uninstallApp(){
        System.out.println(androidDriver.getCapabilities());
        // Se obtiene con el comando -> aapt dump badging /direccionApp/ContactManager.apk | grep package:\ name

        //androidDriver.navigate().back();
    }

    /*
     * android-INICIO001 - Login 1 y 2 (¿Separar?)
     */
 /*
    @Test (description = "android-INICIO001 - Login 1 y 2", enabled = true)
    public void android_INICIO001() throws Exception {

        System.out.println(androidDriver.getCapabilities());

        //Login 1
        // Añadir nombre

        // Nombre
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/user_name_edit_text").click(); //Necesario?
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/user_name_edit_text").sendKeys("delega3");
        // Pulsar botón
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/log_in_button").click();

        //Se muestra la pantalla de introducir código, se espera a introducirlo manualmente y que aparezca el mensaje de error de root
        WebDriverWait wait = new WebDriverWait(androidDriver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.radmas.iycp.casiopea.pre:id/error_dialog_ok_button")));
        // Pulsar ok pop-up root
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/error_dialog_ok_button").click();

        // Login 2 (Problemas)
        //USER
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/nickname_edit_text").sendKeys("delega3");
        //PASS
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/password_edit_text").sendKeys("efron20141");
        //Hospital - OPCION 1: Dejar por defecto y no seleccionar nada / OPCION 2: Seleccionar otra opción con las 2 líneas
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/hospital_spinner").click();
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView").click();
        //Boton entrar (No funciona el tap directamente en botón, hay que hacer tap de coodenadas en el ojo del password y después botón)
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.tap(PointOption.point(989,910)).perform();

        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/show_password").click();
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/log_in_button").click();

        //APP - Saltar tutoriales por coordenadas. 4 pasos
        for(int i=0; i<4;i++){
            touchAction.tap(PointOption.point(950, 1570)).perform();
        }

        //Reporte del caso de prueba
        Allure.addAttachment("captura", new ByteArrayInputStream(((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES)));


       // Mértodo para volver a la página principal


    }
*/
/*

    /**
     * android-EPISODIOS01 - EPISODIOS - Episodio activo
     */
    @Test (description = "android-EPISODIOS01 - Episodio activo", enabled = true)
    public void android_EPISODIOS01() throws Exception {

        System.out.println(androidDriver.getCapabilities());

        //*****TEST
        //*Desde el listado de pacientes de una estación (ej: Hospitalización) y seleccionar un paciente

        //Acceso listado pacientes estación
        commonActions.AccederEstacion(this.estacion);
        //commonConditions.AccesoEstación??

        //Buscar paciente
        commonActions.BuscarPaciente(this.paciente);
        //Seleccionar Primer paciente de la lista
        androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]").click();

        //
       //androidDriver.findElementByAccessibilityId("Desplazarse hacia arriba").getText();

        /*

        if(androidDriver.findElementsByAccessibilityId("ID tutorial").size()!=0){

        }else{

        }
        Metodo ejemplo

 */
/*
        episodiosActions.buscarEpisodios("Hospitalizaciones","Nombre"

                public (String)){
            androidDriver.findElementById(seccion);

        }
*/
        //APP - Saltar tutoriales por coordenadas. 3 pasos -> Comon con parametro y luego verificar que desaparece
        TouchAction touchAction = new TouchAction(androidDriver);
        for(int i=0; i<4;i++){
            touchAction.tap(PointOption.point(950, 1570)).perform();
        }

        //*Acceder a Acciones (+) y pinchar en la Opción Episódios en Otras Acciones
        androidDriver.findElementByAccessibilityId("Acciones").click();
        androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/episodes_text_view").click();

        //Codition: Se muestra una lista de los episodios de la Historia del Paciente indicando el estado de los mismos
        androidDriver.findElementByXPath ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.RelativeLayout").isDisplayed();
        androidDriver.findElementByXPath ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[2]").isDisplayed();

        //*Reporte del caso de prueba
        Allure.addAttachment("captura", new ByteArrayInputStream(((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES)));

        /*
        Método para volver a la página principal
         */
        androidDriver.findElementByAccessibilityId("Desplazarse hacia arriba").click();
        androidDriver.findElementByAccessibilityId("Desplazarse hacia arriba").click();
    }

    /**
     * android-EPISODIOS02 - EPISODIOS - Episodio NO Activo
     */
    @Test (description = "android-EPISODIOS02 - Episodio NO Activo", enabled = true)
    public void android_EPISODIOS02() throws Exception {

        System.out.println(androidDriver.getCapabilities());

        //*****TEST


        //Reporte del caso de prueba
        Allure.addAttachment("captura", new ByteArrayInputStream(((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES)));

        /*
        Mértodo para volver a la página principal
         */
        //androidDriver.navigate().back();
    }
    /**
     * android-CON0004 - EPISODIOS - CEX Cerrado
     */
    @Test (description = "android-EPISODIOS03- CEX Cerrado", enabled = true)
    public void android_EPISODIOS03() throws Exception {

        System.out.println(androidDriver.getCapabilities());

        //*****TEST


        //Reporte del caso de prueba
        Allure.addAttachment("captura", new ByteArrayInputStream(((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES)));

        /*
        Mértodo para volver a la página principal
         */

        //androidDriver.navigate().back();
    }

}