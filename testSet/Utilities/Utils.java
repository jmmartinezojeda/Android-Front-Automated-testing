package Utilities;

import Actions.*;
import Conditions.*;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static URL url;
    public static String sistemaOperativo;
    public static DesiredCapabilities capabilities;
    public static IOSDriver<IOSElement> iOSdriver;
    public static AndroidDriver<AndroidElement> androidDriver;
    public static ObjectRepositoryUtils objRep;
    public static TestDataUtils dataRep;
    public static SQLDatabaseConnection sqlDBC;
    private static String rowIdentifier;
    //Clases
    //private static FlujoPrincipalAndroid
    private static CommonActions commonActions;
    private static CommonConditions commonConditions;
    private static FlujoPrincipalActions flujo_principalActions;
    private static FlujoPrincipalConditions flujo_principalConditions;
    private static PacienteActions pacienteActions;
    private static PacienteConditions pacienteConditions;
    private static PInfoPacienteActions p_info_pacienteActions;
    private static PInfoPacienteConditions p_info_pacienteConditions;
    private static HospitalizacionActions hospitalizacionActions;
    private static HospitalizacionConditions hospitalizacionConditions;

    private static PHistoriaActions pHistoriaActions;
    private static PHistoriaConditions pHistoriaConditions;

    //TODO: Añadir instanciador de Android
    public void Instanciador_iOS(){
        try
        {
            //Maquina Windows local
            //final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
            //Maquina MAC PRE
            final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
            url = new URL(URL_STRING);

            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.APP, "/Users/diegobetabel/Desktop/IntegrationApp.app");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

            //objRep = new ObjectRepositoryUtils("ObjectRepository.properties");

            iOSdriver = new IOSDriver<>(capabilities);

            iOSdriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

         //   Allure.addAttachment("Historico", "Instanciador iniciado correctamente")
            // Allure.addAttachment("Historico", "-------------------- - ");
        } catch(Exception e) {
         //   Allure.addAttachment("Error", "Error al iniciar el instaciador : " + e);
        }
    }

    public void Instanciador_Android(){
        try
        {
            //capabilities
            final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
            url = new URL(URL_STRING);
            sistemaOperativo = "ANDROID";

            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");


            ///-> Seleccionar uno de los 2 métodos:

            ///->1. Inicio de APP instalada en el dispositivo emulado
/*
            capabilities.setCapability("appPackage", "com.radmas.iycp.casiopea.pre");
            capabilities.setCapability("automationName","UiAutomator2");
            capabilities.setCapability("appActivity", "com.radmas.iycp.presentation.launcher.LauncherActivity");
            ///Sentencia Reiniciar(false)/No Reiniciar(true) la APP
            capabilities.setCapability("noReset", false);
*/

            ///->2. Inicio para instalar APP desde un directorio
            ///Local
            //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\temporal\\Documents\\GitHub\\quiron-app-automation\\apk\\app-casiopeaPre-debug.apk");
            ///Maquina MAC-PRE
            capabilities.setCapability(MobileCapabilityType.APP, "Users\\casiopea.mobility\\app-casiopeaPre-debug.apk");

            ///Appium logs
            //capabilities.setCapability("browserstack.appiumLogs", "true");
            //capabilities.setCapability("browserstack.deviceLogs", "true");

            //Lectura de ficheros CSV
            objRep = new ObjectRepositoryUtils();
            objRep.TestDataReader("ObjectRepository.csv");
            dataRep = new TestDataUtils();
            dataRep.TestDataReader("DataRepository.csv");


            androidDriver = new AndroidDriver<>(capabilities);
            androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            //Instanciador clases
            commonActions = new CommonActions();
            commonConditions = new CommonConditions();
            flujo_principalActions = new FlujoPrincipalActions();
            flujo_principalConditions = new FlujoPrincipalConditions();
            pacienteActions = new PacienteActions();
            pacienteConditions = new PacienteConditions();
            p_info_pacienteActions = new PInfoPacienteActions();
            p_info_pacienteConditions = new PInfoPacienteConditions();
            hospitalizacionActions = new HospitalizacionActions();
            hospitalizacionConditions = new HospitalizacionConditions();

            pHistoriaActions = new PHistoriaActions();
            pHistoriaConditions = new PHistoriaConditions();

            rowIdentifier = "TESTID";


            sqlDBC = new SQLDatabaseConnection();

            //Allure
            commonActions.PrintReportMessage("Instanciador iniciado correctamente");

            //csv
            /*
            objRep = new ObjectRepositoryUtils("ObjectRepository.properties");
            objRep.TestDataReader("ObjectRepository.csv");

            dataRep = new TestDataUtils();
            dataRep.testDataReader("DataRepository.csv");
            */


        } catch (MalformedURLException malformedURLException) {
                commonActions.PrintReportMessage("Error al iniciar instaciador");
                malformedURLException.printStackTrace();
        }

    }

    public boolean EncontrarElemento(By by)
    {
        AndroidElement element;
        element = androidDriver.findElement(by);
        return true;
    }


//Metodos para cambiar el tiempo de espera de la aplicación
    public static void RestaurarTiempoDeEspera(){
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void CambiarTiempoDeEspera(int time){
        androidDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    public static AndroidElement SearchAndroidElement(String identificador)
    {
        try
        {
            AndroidElement valor;

            switch (objRep.TypeObjectID(identificador)){
                case "XPATH":
                    valor = androidDriver.findElementByXPath(objRep.ObjectID(identificador));
                    break;
                case "ID":
                    valor = androidDriver.findElementById(objRep.ObjectID(identificador));
                    break;
                case "A_ID":
                    valor = androidDriver.findElementByAccessibilityId(objRep.ObjectID(identificador));
                    break;
                default:
                    valor = null;
            }

            return valor;
            /*
            return switch (objRep.TypeObjectID(identificador))
            {
                case "XPATH" -> androidDriver.findElementByXPath(objRep.ObjectID(identificador));
                case "ID" -> androidDriver.findElementById(objRep.ObjectID(identificador));
                case "A_ID" -> androidDriver.findElementByAccessibilityId(objRep.ObjectID(identificador));
                default -> null;
            };*/
        } catch (NullPointerException npe) {
            commonActions.PrintReportMessage("Excepción NULL. Devuelve un NULL del repositorio");
            throw npe;
        }
        catch(NoSuchElementException e)
        {
            commonActions.PrintReportMessage("No se pudo interactuar con el elemento " + identificador + " de tipo " + objRep.TypeObjectID(identificador));
            throw e;
        }
    }
//Get clases Actions/conditios
    public static CommonActions GetCommonActions()
    {
        return commonActions;
    }
    public static CommonConditions GetCommonConditions()
    {
        return commonConditions;
    }

    public static FlujoPrincipalActions GetFlujo_PrincipalActions()
    {
        return flujo_principalActions;
    }
    public static FlujoPrincipalConditions GetFlujo_PrincipalConditions()
    {
        return flujo_principalConditions;
    }

    public static PacienteActions GetPacienteActions()
    {
        return pacienteActions;
    }
    public static PacienteConditions GetPacienteConditions() { return pacienteConditions; }

    public static PInfoPacienteActions GetP_Info_PacienteActions(){
        return p_info_pacienteActions;
    }
    public static PInfoPacienteConditions GetP_Info_PacienteConditions(){
        return p_info_pacienteConditions;
    }

    public static HospitalizacionActions GetHospitalizacionActions(){
        return hospitalizacionActions;
    }
    public static HospitalizacionConditions GetHospitalizacionConditions(){
        return hospitalizacionConditions;
    }

    public static PHistoriaActions GetPHistoriaActions(){
        return pHistoriaActions;
    }
    public static PHistoriaConditions GetPHistoriaConditions(){
        return pHistoriaConditions;
    }

//Get clases de recuersos
    public static String GetRowIdentifier(){return rowIdentifier;}

    public static URL GetUrl() {
        return url;
    }

    public static DesiredCapabilities GetCapabilities() {
        return capabilities;
    }

    public static IOSDriver<IOSElement> GetiOSdriver() {
        return iOSdriver;
    }

    public static ObjectRepositoryUtils GetObjRepo() {
        return objRep;
    }

    public static TestDataUtils GetDataRepo() { return dataRep; }

    public static AndroidDriver<AndroidElement> GetAndroidDriver() {
        return androidDriver;
    }

    public static SQLDatabaseConnection GetSQLDatabaseConnection() {
        return sqlDBC;
    }
}
