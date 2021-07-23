import Actions.CommonActions;
import Actions.ConsultasActions;
import Actions.PacienteActions;
import Conditions.CommonConditions;
import Conditions.ConsultasConditions;
import Conditions.PacienteConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ConsultasAndroid {
    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public ConsultasActions consultasActions;
    public ConsultasConditions consultasConditions;

    public ConsultasAndroid(){

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
     * android-C-001 - Consultas - Acceso Consultas
     * Precondition: android-FP-007
     */

    public void Android_C_001(){
        String testId = "Android_C_001";
        //*****TEST
        //Step_1
        //Preconditions
        // Hospital con consultas disponibles

        // Hacer click en consultas

        // Muestra listado de pacientes


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-002 - Consultas - Filtros de fechas (dias)
     * Precondition: Android_C_001
     */

    public void Android_C_002(){
        String testId = "Android_C_002";
        //*****TEST
        //Step_1
        //Preconditions
        // Pulsar sobre la flecha dedicada a mañana

        // Muestra los resultados


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-003 - Consultas - Filtro Consultas
     * Precondition: Android_C_001
     */

    public void Android_C_003(){
        String testId = "Android_C_003";
        //*****TEST
        //Step_1
        // Hacer click en filtro

        // Muestra el filtro de consultas


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-004 - Consultas - Filtro  Consultas borrado de asignacion de pacientes
     * Precondition: Android_C_002
     */
    public void Android_C_004() {
        String testId = "Android_C_004";
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
     * android-C-005 - Consultas - Filtro  Consultas borrado de fecha
     * Precondition: Android_C_002
     */
    public void Android_C_005() {
        String testId = "Android_C_005";
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
     * android-C-006 - Consultas - Filtro  Consultas borrado de servicio
     * Precondition:  Android_C_002
     */

    public void Android_C_006(){
        String testId = "Android_C_006";
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
     * android-C-007 - Consultas - Minimizar filtro
     * Precondition:  Android_C_002
     */

    public void Android_C_007(){
        String testId = "Android_C_007";
        //*****TEST
        //Step_1
        // Minimizar tipo de filtro - pulsar la flecha para contraerlo

        // El filtro del tipo correspondiente se minimiza


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-008 - Consultas - Acceder a prestaciones
     * Precondition:  Android_C_002
     */

    public void Android_C_008(){
        String testId = "Android_C_008";
        //*****TEST
        //Step_1
        //Preconditions
        // Prestaciones

        // Hacer click en seleccionar prestacion

        // Se accede a las prestaciones


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-009 - Consultas - Regresar a la home desde el filtro
     * Precondition: Android_C_002
     */

    public void Android_C_009(){
        String testId = "Android_C_009";
        //*****TEST
        //Step_1
       // Hacer click en la flecha de volver

        // Se regresa a la pantalla home


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-010 - Consultas - Filtro  asinaciones: Selección de medico
     * Precondition: Android_C_002
     */

    public void Android_C_010(){
        String testId = "Android_C_010";
        //*****TEST
        //Step_1
        // Pulsar sobre la flecha del filtro

        // Se despliegan mas opciones

        //Step_2
        //Preconditions
        // Prestaciones
        // Pulsar sobre opcion selecccion de medico

        // Se despliega el listado de medicos

        //Step_3
        // Seleccionar medico conel swich

        // El medico queda seleccionado

        //Step_4
        // Pulsar volver

        // Regresamos a pantalla anterior

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-C-011 - Consultas - Filtro asinaciones: Selección swich mis pacientes
     * Precondition: Android_C_002
     */

    public void Android_C_011(){
        String testId = "Android_C_011";
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
     * android-C-012 - Consultas - Filtro fecha: seleccionar fecha
     * Precondition: Android_C_002
     */

    public void Android_C_012(){
        String testId = "Android_C_012";
        //*****TEST
        //Step_1
        // Pulsar sobre la flecha del filtro-desplegable

        // Se despliegan mas opciones

        //Step_2
        // Hacer click en la fecha y ACEPTAR

        // Se muestra calendario para elegir fecha

        //Step_3
        // Seleccionar una fecha

        // La fecha se incorpora

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-013 - Consultas - Filtro  servicio: Selección de tipo
     * Precondition: Android_C_002
     */
    public void Android_C_013(){
        String testId = "Android_C_013";
        //*****TEST
        //Step_1
        //Preconditions
        // Listado de tipos de servicios
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
     * android-C-014 - Consultas - Filtro  prestaciones: Selección de tipo
     * Precondition: Android_C_002
     */
    public void Android_C_014(){
        String testId = "Android_C_014";
        //*****TEST
        //Step_1
        //Preconditions
        // Listado de prestaciones
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
     * android-C-015 - Consultas - Filtro  prestaciones: Selección de tipo
     * Precondition: Android_C_002
     */
    public void Android_C_015(){
        String testId = "Android_C_015";
        //*****TEST
        //Step_1
        //Preconditions
        // Listado de prestaciones
        // Pulsar sobre la flecha del filtro-desplegable

        // Se despliegan mas opciones

        //Step_2
        // Borrar filtros tipo de servicio

        // El swich se actualiza

        //Step_3
        // Acceder a prestaciones

        // Muestra mensaje informativo indicando tipo de servicio no puede estar vacio

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-C-016 - Consultas - Consulta de pacientes con filtros
     * Precondition: Android_C_002
     */
    public void Android_C_016(){
        String testId = "Android_C_016";
        //*****TEST
        //Step_1
        //Preconditions
        // Listado de tipos de servicios
        // Pulsar sobre la flecha del filtro-desplegable

        // Se despliegan mas opciones

        //Step_2
        // Seleccionamos los filtros que necesitemos

        // Los filtros se actualizan

        //Step_3
        // Pulsamos sobre la flecha volver

        // Muestra el listado de pacientes con los filtros, ademas de una indicacion en numero, en la pestaña consultas

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

}

