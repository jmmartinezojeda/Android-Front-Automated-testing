import Actions.CommonActions;
import Actions.ConsultasActions;
import Actions.QuirofanosActions;
import Conditions.CommonConditions;
import Conditions.ConsultasConditions;
import Conditions.QuirofanosConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class QuirofanosAndroid {
    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public QuirofanosActions quirofanosActions;
    public QuirofanosConditions quirofanosConditions;

    public QuirofanosAndroid(){

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
     * android-Q-001 - Quirófanos - Acceso Quirofano
     * Precondition: android-FP-002
     */

    public void Android_Q_001(){
        String testId = "Android_Q_001";
        //*****TEST
        //Step_1
        //Preconditions
        // Hospital con Quirofano disponibles

        // Hacer click en Quirofano

        // Muestra listado de pacientes


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-002 - Quirófanos - Filtros de fechas de dia
     * Precondition: Android_Q_001
     */

    public void Android_Q_002(){
        String testId = "Android_Q_002";
        //*****TEST
        //Step_1
        // Pulsar sobre la flecha dedicada a mañana

        // Muestra los resultados


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-003 - Quirófanos - Filtro Consultas
     * Precondition: Android_Q_002
     */

    public void Android_Q_003(){
        String testId = "Android_Q_003";
        //*****TEST
        //Step_1
        // Hacer click en filtro

        // Muestra el filtro de Quirofano


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-004 - Quirófanos - Filtro  Consultas borrado de asignacion de pacientes
     * Precondition: Android_Q_002
     */
    public void Android_Q_004() {
        String testId = "Android_Q_004";
        //*****TEST
        //Step_1
        //Preconditions
        // Tener algun filtro precargado

        // Borrar filtro tipo asignacion

        // El filtro se borra correctamente

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-005 - Quirófanos - Filtro  Quirofano borrado de fecha
     * Precondition: Android_Q_002
     */
    public void Android_Q_005() {
        String testId = "Android_Q_005";
        //*****TEST
        //Step_1
        //Preconditions
        // Tener algun filtro precargado

        // Borrar filtro tipo fecha

        // El filtro se borra correctamente

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-006 - Quirófanos - Filtro  Quirofano borrado de servicio
     * Precondition:  Android_Q_002
     */

    public void Android_Q_006(){
        String testId = "Android_Q_006";
        //*****TEST
        //Step_1
        //Preconditions
        // Tener algun filtro precargado

        // Borrar filtro tipo servicio

        // El filtro se borra correctamente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-Q-007 - Quirófanos - Filtro  Quirofano borrado de quirofanos
     * Precondition:  Android_Q_002
     */

    public void Android_Q_007(){
        String testId = "Android_Q_007";
        //*****TEST
        //Step_1
        //Preconditions
        // Tener algun filtro precargado
        // Borrar filtro quirofanos

        // El filtro se borra correctamente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-008 - Quirófanos - Filtro  Quirofano borrado de Riesgo Asa
     * Precondition:  Android_Q_002
     */

    public void Android_Q_008(){
        String testId = "Android_Q_008";
        //*****TEST
        //Step_1
        //Preconditions
        // Tener algun filtro precargado

        // Borrar filtro riesgo Asa

        // El filtro se borra correctamente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-009 - Quirófanos - Minimizar filtro
     * Precondition: Android_Q_002
     */

    public void Android_Q_009(){
        String testId = "Android_Q_009";
        //*****TEST
        //Step_1
        // Minimizar tipo de filtro

        // El filtro del tipo correspondiente se minimiza


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-010 - Quirófanos - Filtro  asinaciones: Selección de medico
     * Precondition: Android_Q_002
     */

    public void Android_Q_010(){
        String testId = "Android_Q_010";
        //*****TEST
        //Step_1
        // Hacer click en la flecha de volver

        // Se regresa a la pantalla home

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-Q-0011 - Quirófanos - Filtro  asignacion: Selección swich mis pacientes
     * Precondition: Android_Q_002
     */

    public void Android_Q_0011(){
        String testId = "Android_Q_0011";
        //*****TEST
        //Step_1
        // Pulsar sobre la flecha del filtro-desplebable

        // Se despliegan mas opciones

        //Step_2
        // Pulsar sobre el swich mis pacientes

        // El swich se actualiza

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-0012 - Quirófanos - Filtro  servicio: Selección de tipo
     * Precondition: Android_Q_002
     */

    public void Android_Q_0012(){
        String testId = "Android_Q_0012";
        //*****TEST
        //Step_1
        //PRECONDICION
        //Listado de tipos de servicios
        //Pulsar sobre la flecha del filtro-desplegable

        //Se despliegan mas opciones

        //Step_2
        //Seleccionar uno o varios tipos de listado mediante el swich

        //El swich se actualiza

        //Step_3
        //Pulsar volver

        //Regresamos a pantalla anterior

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-0013 - Quirófanos - Filtro  quiroranos: Selección de tipo
     * Precondition: Android_Q_002
     */
    public void Android_Q_0013(){
        String testId = "Android_Q_0013";
        //*****TEST
        //Step_1
        //Preconditions
        // Listado de tipos de quirofona
        // Pulsar sobre la flecha del filtro-desplegable

        // Se despliegan mas opciones

        //Step_2
        // Seleccionar uno o varios tipos de listado mediante el swich

        // El swich se actualiza

        //Step_3
        // Pulsar volver

        // Regresamos a pantalla anterior

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-0014 - Quirófanos - Filtro  Riesgo ASA: Selección de tipo
     * Precondition: Android_Q_002
     */
    public void Android_Q_0014(){
        String testId = "Android_Q_0014";
        //*****TEST
        //Step_1
        //Preconditions
        //Listado de tipos de riesgos ASA
        //Pulsar sobre la flecha del filtro-desplegable

        //Se despliegan mas opciones

        //Step_2
        //Seleccionar uno o varios tipos de listado mediante el swich

        //El swich se actualiza

        //Step_3
        //Pulsar volver

        //Regresamos a pantalla anterior

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-0015 - Quirófanos -  Filtro fecha: seleccionar fecha
     * Precondition: Android_Q_002
     */
    public void Android_Q_0015(){
        String testId = "Android_Q_0015";
        //*****TEST
        //Step_1
        //Pulsar sobre la flecha del filtro-desplegable

        //Se despliegan mas opciones

        //Step_2
        //Hacer click en la fecha

        //Se muestra calendario para elegir fecha

        //Step_3
        //Seleccionar una fecha

        //La fecha se incorpora

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-Q-0016 - Quirófanos - Consulta de pacientes con filtros
     * Precondition: Android_Q_002
     */
    public void Android_Q_0016(){
        String testId = "Android_Q_0016";
        //*****TEST
        //Step_1
        //Preconditions
        //Listado de tipos de servicios
        //Pulsar sobre la flecha del filtro-desplegable

        //Se despliegan mas opciones

        //Step_2
        //Seleccionamos los filtros que necesitemos

        //Los filtros se actualizan

        //Step_3
        //Pulsamos sobre la flecha volver

        //Muestra el listado de pacientes con los filtros, ademas de una indicacion en numero, en la pestaña consultas

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

}

