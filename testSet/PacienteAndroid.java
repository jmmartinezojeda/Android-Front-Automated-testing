import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Actions.PacienteActions;
import Conditions.CommonConditions;
import Conditions.FlujoPrincipalConditions;
import Conditions.PacienteConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;

public class PacienteAndroid {
    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public PacienteActions pacienteActions;
    public PacienteConditions pacienteConditions;

    public PacienteAndroid(){

        utils = new Utils();
        commonActions = Utils.GetCommonActions();
        objRepo = Utils.GetObjRepo();
        dataRepo = Utils.GetDataRepo();

        //clases
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
        pacienteActions = Utils.GetPacienteActions();
        pacienteConditions = Utils.GetPacienteConditions();
        //Variables

    }

    /**
     * android-P-002 - Paciente - P - Otros
     * Precondition: android-FP-001
     */

    public void Android_P_002(){
        FlujoPrincipalAndroid flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        flujoPrincipalAndroid.Android_FP_009();
        String testId = "Android_P_002";
        //*****TEST
        //Step_1
        //Preconditions
        commonActions.TapEnterKeyboard();
        commonActions.SaltarTutorial();
        // Click sobre Otros (tres puntos verticales)
        pacienteActions.PulsarOtros();
        // Se muestra un desplegable con las siguientes opciones:
        //*Glosario
        //*Llamar a Soporte
        pacienteConditions.PulsadoOtros();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-003_1 - Paciente - Acceso a Glosario
     * Precondition: android-FP-002
     */

    public void Android_P_003_1(){
        FlujoPrincipalAndroid flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        flujoPrincipalAndroid.Android_FP_009();
        String testId = "Android_P_003_1";
        //*****TEST
        //Step_1
        //Preconditions
        commonActions.TapEnterKeyboard();
        commonActions.SaltarTutorial();
        pacienteActions.PulsarOtros();
        // Click sobre Glosario
        pacienteActions.PulsarGlosario();
        // Se muestra el Glosario correspondiente al ámbito del usuario
        String ambitoGlosario = dataRepo.getDataFromRepository(testId,"ambitoGlosario");
        pacienteConditions.PulsadoGlosario(ambitoGlosario);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-003_2 - Paciente - Glosario Atrás
     * Precondition: android-FP-003_1
     */

    public void Android_P_003_2(){
        FlujoPrincipalAndroid flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        flujoPrincipalAndroid.Android_FP_009();
        String testId = "Android_P_003_2";
        //*****TEST
        //Step_1
        //Preconditions
        commonActions.TapEnterKeyboard();
        commonActions.SaltarTutorial();
        pacienteActions.PulsarOtros();
        pacienteActions.PulsarGlosario();
        // Pulsar "Volver"
        commonActions.Volver(1);
        // Se muestra "Historia" del paciente
        String buscarPacienteNombre = dataRepo.getDataFromRepository(testId,"buscarPacienteNombre");
        pacienteConditions.MostradaHistoriaPaciente(buscarPacienteNombre);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-004 - Paciente - Llamar a soporte
     * Precondition: android-P-002
     */
    public void Android_P_004() {
        FlujoPrincipalAndroid flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        flujoPrincipalAndroid.Android_FP_009();
        String testId = "Android_P_004";
        //*****TEST
        //PRECONDITION
        commonActions.TapEnterKeyboard();
        commonActions.SaltarTutorial();
        pacienteActions.PulsarOtros();
        //Step_1
        //Click en "Llamar a soporte"
        pacienteActions.PulsarLlamarSoporte();
        //Se abre correctamente la aplicación de Android "Teléfono" con el número de telefono correcto marcado
        commonConditions.PulsadoLlamarSoporte();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-005 - Paciente - Atrás
     * Precondition: android-P-001
     */
    public void Android_P_005() {
        FlujoPrincipalAndroid flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        flujoPrincipalAndroid.Android_FP_009();
        String testId = "Android_P_005";
        //*****TEST
        //Step_1
        //PRECONDITION
        commonActions.TapEnterKeyboard();
        commonActions.SaltarTutorial();
        pacienteActions.PulsarOtros();
        //Pulsar "Volver"
        commonActions.Volver(1);
        //Se vuelve a la sección anterior (Menu principal)
        commonConditions.MostradoMenuPrincipal();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-006 - Paciente - Acceso a Paciente
     * Precondition: android-U-008
     */
    public void Android_P_006() {
        String testId = "Android_P_006";
        //*****TEST
        //Step_1
        //Se hace click sobre uno de los pacientes de la lista

        //Se muestra "Historia" del paciente

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-P-007 - Paciente - Acceso a Paciente
     * Precondition: android-C-009
     */
    public void Android_P_007() {
        String testId = "Android_P_007";
        //*****TEST
        //Step_1
        //Se hace click sobre uno de los pacientes de la lista

        //Se muestra "Historia" del paciente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-008 - Paciente - Acceso a Paciente
     * Precondition: android-Q-010
     */
    public void Android_P_008() {
        String testId = "Android_P_008";
        //*****TEST
        //Step_1
        //Se hace click sobre uno de los pacientes de la lista

        //Se muestra "Historia" del paciente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-009 - Paciente - Acceso a Paciente
     * Precondition: android-FP-008
     */
    public void Android_P_009(){
        String testId = "Android_P_009";
        //*****TEST
        //Step_1
        //Se hace click sobre uno de los pacientes de la lista

        //Se muestra "Historia" del paciente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-010 - Paciente - Acceso a Paciente
     * Precondition: android-FP-009
     */

    public void Android_P_010(){
        FlujoPrincipalAndroid flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        flujoPrincipalAndroid.Android_FP_009();
        String testId = "Android_P_010";
        //*****TEST
        //Step_1
        //Preconditions
        // Pulsar "Enter" en el teclado numérico
        pacienteActions.BuscarPaciente();
        // Se muestra "Historia" del paciente
        String buscarPacienteNombre = dataRepo.getDataFromRepository(testId,"buscarPacienteNombre");
        pacienteConditions.MostradaHistoriaPaciente(buscarPacienteNombre);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-011 - Paciente - Acceso a Paciente
     * Precondition: android-FP-008
     */
    public void Android_P_011(){
        String testId = "Android_IC_005";
        //*****TEST
        //Step_1
        //Se hace click sobre acceso a paciente, representado por el icono de un libro

        //Se muestra "Historia" del paciente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


}