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
        String testId = "Android_P_002";
        //*****TEST
        //Step_1
        //Preconditions
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
        String testId = "Android_P_003_1";
        //*****TEST
        //Step_1
        //Preconditions
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
        String testId = "Android_P_003_2";
        //*****TEST
        //Step_1
        //Preconditions
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
        String testId = "Android_P_004";
        //*****TEST
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
        String testId = "Android_P_005";
        //*****TEST
        //Step_1
        //Pulsar "Volver"
        commonActions.Volver(1);
        //Se vuelve a la sección anterior (Menu principal)
        commonConditions.MostradoMenuPrincipal();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-P-010 - Paciente - Acceso a Paciente
     * Precondition: android-FP-009
     */

    public void Android_P_010(){
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



}