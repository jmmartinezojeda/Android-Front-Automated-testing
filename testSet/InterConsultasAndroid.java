import Actions.CommonActions;
import Actions.ConsultasActions;
import Actions.FlujoPrincipalActions;
import Actions.InterConsultasActions;
import Conditions.CommonConditions;
import Conditions.ConsultasConditions;
import Conditions.InterConsultasConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class InterConsultasAndroid {
    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public InterConsultasActions interConsultasActions;
    public InterConsultasConditions interConsultasConditions;
    public FlujoPrincipalAndroid flujoPrincipalAndroid;
    public FlujoPrincipalActions flujoPrincipalActions;
    public InterConsultasAndroid(){

        utils = new Utils();
        commonActions = Utils.GetCommonActions();
        objRepo = Utils.GetObjRepo();
        dataRepo = Utils.GetDataRepo();

        //clases
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();

        //Variables

    }

    /**
     * android-IC-001 - Interconsultas - Menu Interconsultas
     * Precondition: android-FP-003
     */
    public void Android_IC_001(){
        String testId = "Android_IC_001";
        //*****TEST
        //Step_1
        //Click en "Interconsultas", representado por el icono de la campana
        flujoPrincipalActions.PulsarInterconsultas();
        //Se abre la pantalla interconsultas correctamente con todos los elementos que debe mostrar
        commonConditions.ComprobarBarraTitulo("Interconsultas");

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }


    /**
     * android-IC-002 - Interconsultas - Filtro interconsultas
     * Precondition: Android_IC_001
     */

    public void Android_IC_002(){
        String testId = "Android_IC_002";
        //*****TEST
        //Step_1
        //Preconditions
        // Servicio_defecto
        // Click en "Filtro interconsultas"

        // Se abre la pantalla "Filtro interconsultas" correctamente. Se comprueba que servicio_defecto por defecto está seleccionando.


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-IC-003 - Interconsultas - Quitar servicio
     * Precondition: Android_IC_003
     */

    public void Android_IC_003(){
        String testId = "Android_IC_003";
        //*****TEST
        //Step_1
        //PRECONDITION
        // servicio_defecto
        // Click en "X"

        //servicio_defecto se elimina de servicio

        //Step_2
        //PRECONDITION
        // lista_servicios
        // Click en la lista desplegable servicio

        // Un lista desplegable se abre con los valores lista_servicios

        //Step_3
        //PRECONDITION
        // seleccion_servicio
        // Click en seleccion_servicio

        // El servicio selección_servicio se añade al imput "Servicio" con el icono "X"

        //Step_4
        //PRECONDITION
        // selección_servicio
        // Click en "Volver"

        // Se muestra el listado de interconsultas con el filtro aplicado en el servicio selección_servicio

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-IC-004 - Interconsultas - volver de interconsultas
     * Precondition: Android_IC_001
     */
    public void Android_IC_004() {
        String testId = "Android_IC_004";
        //*****TEST
        //Step_1
        // Click en "Volver"

        //Se muestra la pantalla "Inicio"

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-IC-005 - Interconsultas - consultar interconsulta SI
     * Precondition: Android_IC_003
     */
    public void Android_IC_005() {
        String testId = "Android_IC_005";
        //*****TEST
        //Step_1
        //Preconditions
        // seleccion_interconsulta
        // datos_interconsulta
        // Click en la interconsulta selección_interconsulta

        // La interconsulta se abre correctamente. Muestra los datos correctos (datos_interconsulta) de la interconsulta seleccionada (seleccion_interconsulta)

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-IC-006 - Interconsultas - Volver de la interconsulta
     * Precondition:  Android_IC_005
     */

    public void Android_IC_006(){
        String testId = "Android_IC_006";
        //*****TEST
        //Step_1
        // Click en "Volver"

        // Se muestra la pantalla "Interconsultas"


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-IC-007 - Interconsultas - Pantalla responder interconsulta
     * Precondition:  Android_IC_005
     */

    public void Android_IC_007(){
        String testId = "Android_IC_007";
        //*****TEST
        //Step_1
        // Campos_responder_interconsulta
        // Click en "Responder interconsulta"

        // Se abre la pantalla "Responder interconsulta" correctamente con los campos correspondientes rellenos correctamente (Campos_responder_interconsulta)


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-IC-008 - Interconsultas - Volver de responder interconsulta
     * Precondition:  Android_IC_007
     */

    public void Android_IC_008(){
        String testId = "Android_IC_008";
        //*****TEST
        //Step_1
        //Preconditions
        // Campos_responder_interconsulta

        // Click en "Volver"

        // Se muestra la pantalla "Responder interconsulta"


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-IC-009 - Interconsultas - Enviar petición para responder interconsulta
     * Precondition: Android_IC_007
     */

    public void Android_IC_009(){
        String testId = "Android_IC_009";
        //*****TEST
        //Step_1
        // Click en "Enviar petición"

        // La petición se envía correctamente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

}

