import java.net.URL;

import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Actions.PInfoPacienteActions;
import Actions.PacienteActions;
import Conditions.CommonConditions;
import Conditions.FlujoPrincipalConditions;
import Conditions.PInfoPacienteConditions;
import Conditions.PacienteConditions;
import Utilities.TestDataUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import Utilities.ObjectRepositoryUtils;
import Utilities.Utils;
import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class AppTestAndroid {
    Utils utils = new Utils();

    public URL url;
    public DesiredCapabilities capabilities;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public FlujoPrincipalActions flujo_principalActions;
    public FlujoPrincipalConditions flujo_principalConditions;
    public PacienteActions pacienteActions;
    public PacienteConditions pacienteConditions;
    public PInfoPacienteActions pInfoPacienteActions;
    public PInfoPacienteConditions pInfoPacienteConditions;
    //Instanciar clases de test
    public FlujoPrincipalAndroid flujoPrincipalAndroid;
    public PacienteAndroid pacienteAndroid;
    public PInfoPacienteAndroid pInfoPacienteAndroid;
    public HospitalizacionAndroid hospitalizacionAndroid;


    @BeforeSuite
    public void setup_Appium() throws Exception {


        utils.Instanciador_Android();
        //Clases
        url = Utils.GetUrl();
        capabilities = Utils.GetCapabilities();
        objRepo = Utils.GetObjRepo();
        dataRepo = Utils.GetDataRepo();
        androidDriver = Utils.GetAndroidDriver();
        commonActions = Utils.GetCommonActions();
        flujo_principalActions = Utils.GetFlujo_PrincipalActions();
        flujo_principalConditions = Utils.GetFlujo_PrincipalConditions();
        pacienteActions = Utils.GetPacienteActions();
        pacienteConditions = Utils.GetPacienteConditions();
        //p_info_pacienteActions = Utils.GetP_Info_PacienteActions();
        //p_info_pacienteConditions = Utils.GetP_Info_PacienteConditions();
        //Clases Tests
        flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        pacienteAndroid = new PacienteAndroid();
        pInfoPacienteAndroid = new PInfoPacienteAndroid();
        hospitalizacionAndroid = new HospitalizacionAndroid();
        //Variables

    }

    @AfterSuite
    public void Close_App(){
        // Se obtiene con el comando -> aapt dump badging /direccionApp/ContactManager.apk | grep package:\ name
        //androidDriver.navigate().back();
    }


  @Test (description = "Android-FP-001 - Login uno", enabled = true, priority = 1)
  public void Android_FP_001(){
      flujoPrincipalAndroid.Android_FP_001();
  }

  @Test (description = "Android-FP-002 - Login dos", enabled = true, priority = 2)
  public void Android_FP_002(){
      flujoPrincipalAndroid.Android_FP_002("Android_FP_002_1");
  }

  @Test (description = "Android-FP-003 - FP-Más", enabled = true, priority = 4)
  public void Android_FP_003(){
      flujoPrincipalAndroid.Android_FP_003();
  }

  @Test (description = "Android-FP-006 - Cambio hospital", enabled = true, priority = 5)
  public void Android_FP_006(){
        flujoPrincipalAndroid.Android_FP_006();
    }


    @Test (description = "Android-FP-0010 - Notificaciones", enabled = true, priority = 3)
    public void Android_FP_010(){
        flujoPrincipalAndroid.Android_FP_010();
    }

    /*
      @Test (description = "Android-FP-004 - Llamar a soporte", enabled = true, priority = 3)
      public void Android_FP_004(){
            flujoPrincipalAndroid.Android_FP_004();
        }

        @Test (description = "Android-FP-005 - Desconectarse", enabled = true, priority = 3)
        public void Android_FP_005(){
            flujoPrincipalAndroid.Android_FP_005();
        }
 */


  @Test (description = "Android-FP-007 - Mapa", enabled = true, priority = 6)
  public void Android_FP_007(){
      flujoPrincipalAndroid.Android_FP_007();
  }
/*

  @Test (description = "Android-FP-008 - Mapa-Buscar Nombre", enabled = true, priority = 2)
  public void Android_FP_008(){
      flujoPrincipalAndroid.Android_FP_008();
  }
*/
  @Test (description = "Android-FP-009 - Mapa-Buscar NHC", enabled = true, priority = 7)
  public void Android_FP_009(){
      flujoPrincipalAndroid.Android_FP_009();
  }


/*
  @Test (description = "Android-FP-0011 - Conversaciones", enabled = true, priority = 3)
  public void Android_FP_011(){
      flujoPrincipalAndroid.Android_FP_011();
  }
*/

  @Test (description = "Android-P-010 - Acceso a Paciente", enabled = true, priority = 8)
  public void Android_P_010(){
      pacienteAndroid.Android_P_010();
  }

  @Test (description = "Android-PI-001 - Acceso a Información de Paciente", enabled = true, priority = 9)
  public void Android_PI_001() {
      pInfoPacienteAndroid.Android_PI_001();
  }

  @Test (description = "Android-PI-002 - Ver Más", enabled = true, priority = 10)
  public void Android_PI_002() {
      pInfoPacienteAndroid.Android_PI_002();
  }
/*
  @Test (description = "Android-PI-003 - Llamar Paciente", enabled = true, priority = 9)
  public void Android_PI_003() {
    pInfoPacienteAndroid.Android_PI_003();
  }
*/
  @Test (description = "Android-PI-004 - Ver Menos", enabled = true, priority = 11)
  public void Android_PI_004() {
    pInfoPacienteAndroid.Android_PI_004();
  }

  @Test (description = "Android-PI-005 - Cerrar información", enabled = true, priority = 12)
  public void Android_PI_005() {
      pInfoPacienteAndroid.Android_PI_005();
  }

///*************************************HOSPITALIZACION

    @Test (description = "Android-H-001 - Acceso a 'Hospitalizacion'", enabled = true, priority = 13)
    public void Android_H_001() {
        hospitalizacionAndroid.Android_H_001();
    }

    @Test (description = "Android-H-002 - Acceso a 'Filtro Hospitalizacion'", enabled = true, priority = 14)
    public void Android_H_002() {
        hospitalizacionAndroid.Android_H_002();
    }
}