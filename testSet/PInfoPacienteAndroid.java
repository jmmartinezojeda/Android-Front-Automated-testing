import Actions.CommonActions;
import Actions.PInfoPacienteActions;
import Conditions.CommonConditions;
import Conditions.PInfoPacienteConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class PInfoPacienteAndroid {
    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public PInfoPacienteActions pInfoPacienteActions;
    public PInfoPacienteConditions pInfoPacienteConditions;


    public PInfoPacienteAndroid(){

        utils = new Utils();
        commonActions = Utils.GetCommonActions();
        objRepo = Utils.GetObjRepo();
        dataRepo = Utils.GetDataRepo();

        //clases
        commonActions = Utils.GetCommonActions();
        pInfoPacienteActions = Utils.GetP_Info_PacienteActions();
        pInfoPacienteConditions = Utils.GetP_Info_PacienteConditions();
        //Variables

    }

    /**
     * android-PI-001 - P - Info Paciente - Acceso a Información de Paciente
     * Precondition: android-P-001
     */

    public void Android_PI_001(){
        PacienteAndroid pacientelAndroid = new PacienteAndroid();
        pacientelAndroid.Android_P_010();
        String testId = "Android_PI_001";
        //*****TEST
        //Step_1
        // Click sobre el nombre del paciente en la barrra azul.
        pInfoPacienteActions.PulsarInfoPaciente();
        // Se despliega la información del paciente.
        pInfoPacienteConditions.PulsadoExpandInfo();
        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PI-002 - P - Info Paciente - Ver Más
     * Precondition: android-PI-001
     */

    public void Android_PI_002(){
        Android_PI_001();
        String testId = "Android_PI_002";
        //*****TEST
        //Step_1
        // Click en Ver Más.
        pInfoPacienteActions.PulsarExpandInfo();
        // Se despliega la información completa del paciente.
        pInfoPacienteConditions.PulsadoExpandInfo();
        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PI-003 - P - Info Paciente - Llamar Paciente
     * Precondition: android-PI-002
     */

    public void Android_PI_003(){
        Android_PI_002();
        String testId = "Android_PI_003";
        //*****TEST
        //Step_1
        // Click en Llamar Paciente.
        pInfoPacienteActions.PulsarTelefono();
        // Se procede con la llamada al paciente
        String telefonoPaciente = dataRepo.getDataFromRepository(testId,"telefonoPaciente");
        commonConditions.PulsadoLlamarPaciente(telefonoPaciente);
        commonActions.TapCoordenadas(617, 1075);
        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PI-004 - P - Info Paciente - Ver Menos
     * Precondition: android-PI-002
     */
    public void Android_PI_004(){
        Android_PI_002();
        String testId = "Android_PI_004";
        //*****TEST
        //Step_1
        // Click sobre Ver Menos.
        pInfoPacienteActions.PulsarExpandInfo();
        // Se vuelve a la vista por defecto de la información de paciente
        pInfoPacienteConditions.PulsadoExpandInfo();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-PI-005 - P - Info Paciente - Cerrar información
     * Precondition: android-PI-001
     */

    public void Android_PI_005(){
        Android_PI_001();
        String testId = "Android_PI_005";
        //*****TEST
        //Step_1
        // Click sobre Ver Menos.
        pInfoPacienteActions.PulsarInfoPaciente();
        // Se vuelve a la vista por defecto de la información de paciente
        pInfoPacienteConditions.PulsadoCerrarInfo();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-PI-006 - P - Info Paciente - Acceso a Información de Paciente
     * Precondition: android-P-006
     */

    public void Android_PI_006(){
        Android_PI_001();
        String testId = "Android_PI_006";
        //*****TEST
        //Step_1
        // Click sobre el nombre del paciente en la barrra azul.

        // Se despliega la información del paciente.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-PI-007 - P - Info Paciente - Acceso a Información de Paciente
     * Precondition: android-P-007
     */

    public void Android_PI_007(){
        Android_PI_001();
        String testId = "Android_PI_007";
        //*****TEST
        //Step_1
        // Click sobre el nombre del paciente en la barrra azul.

        // Se despliega la información del paciente.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-PI-008 - P - Info Paciente - Acceso a Información de Paciente
     * Precondition: android-P-008
     */

    public void Android_PI_008(){
        Android_PI_001();
        String testId = "Android_PI_008";
        //*****TEST
        //Step_1
        // Click sobre el nombre del paciente en la barrra azul.

        // Se despliega la información del paciente.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }
    /**
     * android-PI-009 - P - Info Paciente - Acceso a Información de Paciente
     * Precondition: android-P-009
     */

    public void Android_PI_009(){
        Android_PI_001();
        String testId = "Android_PI_009";
        //*****TEST
        //Step_1
        // Click sobre el nombre del paciente en la barrra azul.

        // Se despliega la información del paciente.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-PI-010 - P - Info Paciente - Acceso a Información de Paciente
     * Precondition: android-P-010
     */

    public void Android_PI_010(){
        Android_PI_001();
        String testId = "Android_PI_010";
        //*****TEST
        //Step_1
        // Click sobre el nombre del paciente en la barrra azul.

        // Se despliega la información del paciente.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }
}