import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Actions.PInfoPacienteActions;
import Actions.PacienteActions;
import Conditions.CommonConditions;
import Conditions.FlujoPrincipalConditions;
import Conditions.PInfoPacienteConditions;
import Conditions.PacienteConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;

public class PlanPruebasRetrocompatibilidad {
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
    public PHistoriaAndroid pHistoriaAndroid;


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
        pHistoriaAndroid = new PHistoriaAndroid();
        //Variables

    }

    @AfterSuite
    public void Close_App(){
        //androidDriver.removeApp("com.radmas.iycp.casiopea.pre");
        androidDriver.navigate().back();
    }

    /**
     * <p> Bloque Inicio </p>
     */

    /**
     ** <p> Inicio-01 </p>
     *
     *** Pantalla de Login
     *** Carga de Centros
     */
  @Test (description = "Inicio-01 [Pantalla de Login / Carga de Centros]", enabled = true, priority = 1)
      public void Android_Inicio_01(){
      flujoPrincipalAndroid.Android_FP_001();
      flujoPrincipalAndroid.Android_FP_002("Android_FP_002_1");
  }

    /**
     ** <p> Inicio-02 </p>
     *
     *** Pantalla de Inicio
     *** Barra inferior de tareas
     */

  @Test (description = "Inicio-02 Pantalla de Inicio / Barra inferior de tareas", enabled = true, priority = 2)
  public void Android_Inicio_02(){

      flujoPrincipalAndroid.Android_FP_011();
      flujoPrincipalAndroid.Android_FP_010();
      flujoPrincipalAndroid.Android_FP_003();
      flujoPrincipalAndroid.Android_FP_006();
      flujoPrincipalAndroid.Android_FP_005();

  }


    /**
     * <p> Bloque Hospitalizacion </p>
     */

    /**
     ** <p> Hospitalizacion-01 </p>
     *
     *** Login
     */


    @Test (description = "Hospitalizacion-01 Login", enabled = true, priority = 3)
    public void Android_Hospitalizacion_01(){
        flujoPrincipalAndroid.Android_FP_002("Android_FP_002_2");
    }

    /**
     ** <p> Hospitalizacion-03 </p>
     *
     *** Filtro_04
     */

        @Test(description = "Hospitalizacion-03 Filtro_04", enabled = true, priority = 4)
        public void Android_Hospitalizacion_02 () {

            hospitalizacionAndroid.Android_H_001();
            hospitalizacionAndroid.Android_H_003();
            hospitalizacionAndroid.Android_H_002();
            hospitalizacionAndroid.Android_H_006_4("Android_H_006_4_1");
            hospitalizacionAndroid.Android_H_006_1();
            hospitalizacionAndroid.Android_H_006_2(true);
            hospitalizacionAndroid.Android_H_006_5();
            hospitalizacionAndroid.Android_H_006_6("Android_H_006_6_1", true);
            hospitalizacionAndroid.Android_H_006_7();
            hospitalizacionAndroid.Android_H_007();
            hospitalizacionAndroid.Android_H_009("Android_H_009_1");
/////1.4
            hospitalizacionAndroid.Android_H_002();
            hospitalizacionAndroid.Android_H_004_4("Android_H_004_4_1");
            hospitalizacionAndroid.Android_H_006_1();
            hospitalizacionAndroid.Android_H_006_8();
            hospitalizacionAndroid.Android_H_005_1();
            hospitalizacionAndroid.Android_H_005_2("Android_H_005_2_1", true);

            hospitalizacionAndroid.Android_H_006_3();
            hospitalizacionAndroid.Android_H_006_4("Android_H_006_4_2");

            hospitalizacionAndroid.Android_H_005_2("Android_H_005_2_2", true);
            hospitalizacionAndroid.Android_H_007();
            hospitalizacionAndroid.Android_H_009("Android_H_009_2");

            //9
            hospitalizacionAndroid.Android_H_002();
            hospitalizacionAndroid.Android_H_005_4("Android_H_005_4_1");
            hospitalizacionAndroid.Android_H_004_1();
        //    hospitalizacionAndroid.Android_H_004_2("Android_H_004_2_1", true);
            //MEDICO
            hospitalizacionAndroid.Android_H_006_1();
            hospitalizacionAndroid.Android_H_006_5();
            hospitalizacionAndroid.Android_H_006_6("Android_H_006_6_2", true);
            hospitalizacionAndroid.Android_H_006_7();
            hospitalizacionAndroid.Android_H_007();
            hospitalizacionAndroid.Android_H_009("Android_H_009_3");

            //10
            hospitalizacionAndroid.Android_H_002();
            hospitalizacionAndroid.Android_H_004_1();
        //    hospitalizacionAndroid.Android_H_004_2("Android_H_004_2_2",true);
            hospitalizacionAndroid.Android_H_006_4("Android_H_006_4_2");
            hospitalizacionAndroid.Android_H_007();
            hospitalizacionAndroid.Android_H_009("Android_H_009_4");

            //11
            hospitalizacionAndroid.Android_H_002();
            hospitalizacionAndroid.Android_H_004_4("Android_H_004_4_2");
            hospitalizacionAndroid.Android_H_005_1();
            hospitalizacionAndroid.Android_H_005_2("Android_H_005_2_3", true);
            hospitalizacionAndroid.Android_H_007();
            hospitalizacionAndroid.Android_H_009("Android_H_009_5");
            //12
            hospitalizacionAndroid.Android_H_002();
            hospitalizacionAndroid.Android_H_005_4("Android_H_005_4_1");
            hospitalizacionAndroid.Android_H_008();
            //Extra Poner por defecto
            hospitalizacionAndroid.Android_H_006_1();
            hospitalizacionAndroid.Android_H_006_2(true);
            hospitalizacionAndroid.Android_H_004_1();
          //  hospitalizacionAndroid.Android_H_004_2("Android_H_004_2_1",true);
            hospitalizacionAndroid.Android_H_007();
            hospitalizacionAndroid.Android_H_003();

        //hospitalizacionAndroid.Android_H_006_4();
        //hospitalizacionAndroid.Android_H_007();
        //hospitalizacionAndroid.Android_H_009("Android_H_009_1");
        }


    @Test(description = "Hospitalizacion-03 Acceso Pacientes", enabled = true, priority = 5)
    public void Android_Hospitalizacion_03 () {
        flujoPrincipalAndroid.Android_FP_009();
        pacienteAndroid.Android_P_010();
        pInfoPacienteAndroid.Android_PI_001();
        pInfoPacienteAndroid.Android_PI_002();
        pInfoPacienteAndroid.Android_PI_003();
        pInfoPacienteAndroid.Android_PI_004();
        pInfoPacienteAndroid.Android_PI_005();
        pacienteAndroid.Android_P_002();
        pacienteAndroid.Android_P_003_1();
        pacienteAndroid.Android_P_003_2();
        pacienteAndroid.Android_P_002();
        pacienteAndroid.Android_P_004();
        pacienteAndroid.Android_P_005();

    }

    @Test(description = "Hospitalizacion-04 Pestaña Historia", enabled = true, priority = 5)
    public void Android_Hospitalizacion_04 () {
        flujoPrincipalAndroid.Android_FP_009();
        pacienteAndroid.Android_P_010();

        pHistoriaAndroid.Android_PH_012_1();
        pHistoriaAndroid.Android_PH_012_2("Android_PH_012_2_1");
        pHistoriaAndroid.Android_PH_012_3("Android_PH_012_3_1");
        pHistoriaAndroid.Android_PH_014();
        pHistoriaAndroid.Android_PH_012_1();
        pHistoriaAndroid.Android_PH_012_2("Android_PH_012_2_2");
        pHistoriaAndroid.Android_PH_012_3("Android_PH_012_3_2");
        pHistoriaAndroid.Android_PH_014();

        //access directos ->> AQUÍ
        pHistoriaAndroid.Android_PH_001_1();
        pHistoriaAndroid.Android_PH_001_2();
        pHistoriaAndroid.Android_PH_002();
        pHistoriaAndroid.Android_PH_005();
        pHistoriaAndroid.Android_PH_009();
        pHistoriaAndroid.Android_PH_010();


        pHistoriaAndroid.Android_PH_012_1();
        pHistoriaAndroid.Android_PH_012_2("Android_PH_012_2_3");
        pHistoriaAndroid.Android_PH_012_3("Android_PH_012_3_3");
        pHistoriaAndroid.Android_PH_015();

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


  @Test (description = "Android-FP-007 - Mapa", enabled = true, priority = 6)
  public void Android_FP_007(){
      flujoPrincipalAndroid.Android_FP_007();
  }



  @Test (description = "Android-FP-008 - Mapa-Buscar Nombre", enabled = true, priority = 2)
  public void Android_FP_008(){
      flujoPrincipalAndroid.Android_FP_008();
  }

  @Test (description = "Android-FP-009 - Mapa-Buscar NHC", enabled = true, priority = 7)
  public void Android_FP_009(){
      flujoPrincipalAndroid.Android_FP_009();
  }


  @Test (description = "Android-FP-0011 - Conversaciones", enabled = true, priority = 3)
  public void Android_FP_011(){
      flujoPrincipalAndroid.Android_FP_011();
  }


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

  @Test (description = "Android-PI-003 - Llamar Paciente", enabled = true, priority = 9)
  public void Android_PI_003() {
    pInfoPacienteAndroid.Android_PI_003();
  }

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

     */
}