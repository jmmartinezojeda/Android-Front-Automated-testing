import Actions.CommonActions;
import Actions.UrgenciasActions;
import Conditions.CommonConditions;
import Conditions.ConsultasConditions;
import Conditions.UrgenciasConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UrgenciasAndroid {
    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public UrgenciasActions urgenciasActions;
    public UrgenciasConditions urgenciasConditions;

    public UrgenciasAndroid(){

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
     * android-U-001 - Urgencias - Acceso a "Urgencias"
     * Precondition: android-FP-002
     */

    public void Android_U_001(){
        String testId = "Android_U_001";
        //*****TEST
        //Step_1
        // Click en la pestaña "Urgencias".

        // Se muestra la pestaña como seleccionada.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-U-002 - Urgencias - Acceso a "Filtro Urgencias"
     * Precondition: Android_U_001
     */

    public void Android_U_002(){
        String testId = "Android_C_002";
        //*****TEST
        //Step_1
        // Click en el icono de filtro

        // Se muestra la ventana "Filtros Urgencias". Se comprueba que al menos un Servicio por defecto está seleccionando.


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-U-003 - Urgencias - Asignación
     * Precondition: Android_U_002
     */

    public void Android_U_003(){
        String testId = "Android_U_003";
        //*****TEST
        //Step_1
        // Clickar sobre el símbolo de despliegue de la sección.

        // Se muestra contenido de las sección Asignación.

        //Step_2
        //Preconditions
        // asignacion_seleccionada
        // Seleccionar una de las opciones disponibles (asignacion_seleccionada). Cerrar el deplegable de sección.

        // Se muestra la asignación seleccionada en una burbuja que presenta una "X"

        //Step_3
        // Pulsar sobre la "X" de la asignación.

        // Se comprueba que la asignación está vacía.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-U-004 - Urgencias - Sección por defecto no puede ser eliminado
     * Precondition: Android_U_003
     */
    public void Android_U_004() {
        String testId = "Android_U_004";
        //*****TEST
        //Step_1
        // Click en el "X" de la sección por defecto.

        // Se muestra una advertencia diciendo que debe haber al menos una Sección seleccionado.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-U-005 - Urgencias - Circuito
     * Precondition: Android_U_004
     */
    public void Android_U_005() {
        String testId = "Android_U_005";
        //*****TEST
        //Step_1
        // Seleccionar un circuito disponible

        // Se muestra el Circuito seleccionado con una "X"

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-U-006 - Urgencias - Servicio de Ingreso
     * Precondition:  Android_U_005
     */
    public void Android_U_006(){
        String testId = "Android_U_006";
        //*****TEST
        //Step_1
        // Seleccionar un Servicio de Ingreso

        // Se muestra el Servicio seleccionado con una "X"


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-U-007 - Urgencias - Valoración Médica
     * Precondition:  Android_U_002
     */
    public void Android_U_007(){
        String testId = "Android_U_007";
        //*****TEST
        //Step_1
        // Clickar sobre el símbolo de despliegue de la sección.

        // Se muestra contenido de las sección Asignación.

        //Step_2
        //Preconditions
        // asignacion_seleccionada
        // Seleccionar una de las opciones disponibles (asignacion_seleccionada). Cerrar el deplegable de sección.

        // Se muestra la asignación seleccionada en una burbuja que presenta una "X"

        //Step_3
        // Pulsar sobre la "X" de la asignación.

        // Se comprueba que la asignación está vacía.

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-U-008 - Urgencias - Acceder a prestaciones
     * Precondition:  Android_U_002
     */

    public void Android_U_008(){
        String testId = "Android_U_008";
        //*****TEST
        //Step_1
        // Click en símobolo de Atrás

        // Se vuelve al inicio de la app

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

}

