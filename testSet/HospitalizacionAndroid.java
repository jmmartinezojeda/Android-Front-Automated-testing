import Actions.CommonActions;
import Actions.PInfoPacienteActions;
import Actions.HospitalizacionActions;
import Conditions.CommonConditions;
import Conditions.HospitalizacionConditions;
import Conditions.PInfoPacienteConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;


public class HospitalizacionAndroid {

    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public PInfoPacienteActions pInfoPacienteActions;
    public PInfoPacienteConditions pInfoPacienteConditions;
    public HospitalizacionActions hospitalizacionActions;
    public HospitalizacionConditions hospitalizacionConditions;
    //Instanciar clases de test
    //Variables
    public String estacion;


    public HospitalizacionAndroid(){

        utils = new Utils();
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
        objRepo = Utils.GetObjRepo();
        dataRepo = Utils.GetDataRepo();

        //clases
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
        pInfoPacienteActions = Utils.GetP_Info_PacienteActions();
        pInfoPacienteConditions = Utils.GetP_Info_PacienteConditions();
        hospitalizacionActions = Utils.GetHospitalizacionActions();
        hospitalizacionConditions = Utils.GetHospitalizacionConditions();
        //Variables
        estacion = "Hospitalizacion";

    }

    /**
     * android-H-001 - Hospitalización - Acceso a "Hospitalizacion"
     * Precondition: android-FP-002
    */

    public void Android_H_001(){
        FlujoPrincipalAndroid flujoPrincipalAndroid = new FlujoPrincipalAndroid();
        flujoPrincipalAndroid.Android_FP_002("Android_FP_002_1");
        String testId = "Android_H_001";
        //*****TEST
        //Step_1
        // Click en la pestaña "Hospitalizacion".
        commonActions.AccederEstacion(this.estacion);
        // Se muestra la pestaña como seleccionada.
        commonConditions.AccesoEstacion(this.estacion);
        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-H-002 - Hospitalización - Acceso a "Filtro Hospitalizacion"
     * Precondition: android-H-001
     */
    public void Android_H_002(){
        Android_H_001();
        String testId = "Android_H_002";
        //*****TEST
        //Step_1
        // Click en el icono de filtro
        commonActions.AbrirFiltroEstacion();
        // Se muestra la ventana "Filtros Hospitalizacion". Se comprueba que al menos un Servicio por defecto está seleccionando.
        commonConditions.AbriertoFiltroEstacion(this.estacion);
        //Comprobar cadaestacion---Métodos individuales

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-003 - Hospitalización - Filtro por defecto no eliminado
     * Precondition: android-H-001
     */
    public void Android_H_003(){
        Android_H_001();
        String testId = "Android_H_003_1";
        //*****TEST
        //Step_1
        // No se modifica el filtro por defecto

        // El icono del filtro se muestra sin un punto rojo

        String numResulH = dataRepo.getDataFromRepository(testId,"numResulH");
        commonConditions.ComprobarResultadosPacientes(numResulH);

        //Comprobar que el icono está con el punto rojo (Return False)
        Assert.assertTrue(!commonConditions.FiltroPorDefecto("Mapa.Filtro"));


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-004_1 - Hospitalización - Desplegar lista Servicios
     * Precondition: android-H-002
     */
    public void Android_H_004_1() {
        Android_H_002();
        String testId = "Android_H_004_1";
        //*****TEST
        //Step_1
        //Se hace clic en Desplegar lista de servicios
        hospitalizacionActions.PlegarDesplegarLista("Servicio");
        //La lista se despliega correctamente y se muestran lo distintos Servicios
        Assert.assertTrue(hospitalizacionConditions.PlegadaDesplegadaServicio());

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId + ".png", testId + " - OK");
    }

    /**
     * android-H-004_2 - Hospitalización - Seleccionar/Deseleccionar Servicio
     * Precondition: android-H-004_1
     * @param selecDeselec Se usa TRUE para seleccionar y FALSE para deseleccionar elemento de la lista
     */
 /*  public void Android_H_004_2(String id) {
        Android_H_004_1();
        String testId = id;

        String servicio = dataRepo.getDataFromRepository(testId,"ElementoListaSeleccion");
        //*****TEST
        //Step_1
        //Deseleccionar un SPOR HACERervicio
        hospitalizacionActions.SeleccionarDeseleccionarServicio(servicio);
        hospitalizacionConditions.SeleccionadoDeseleccionadoServicio(servicio, false);
        //Step_1
        //Seleccionar un Servicio
        hospitalizacionActions.SeleccionarDeseleccionarServicio(servicio);
        hospitalizacionConditions.SeleccionadoDeseleccionadoServicio(servicio, true);

        //**************

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }*/

    /**
     * android-H-004_4 - Hospitalización - Eliminar Servicios
     * Precondition: android-H-002
     */
    public void Android_H_004_4(String id) {
        Android_H_002();
        String testId = id;
        //*****TEST
        //Step_1
        //Pulsar sobre la "X" de un servicio
        String asignacionSeleccionada = dataRepo.getDataFromRepository(testId,"asignacionSeleccionada");
        hospitalizacionActions.EliminarSeleccionFiltro(asignacionSeleccionada, "Servicio");
        //Se comprueba que el servicio desaparece de la lista
        //habilitar el mismo método para qu devuleva mensaje de que no se encuentra el elemento


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-005_1 - Hospitalización - Desplegar lista UDE
     * Precondition: android-H-002
     */
    public void Android_H_005_1() {
        Android_H_002();
        String testId = "Android_H_005_1";
        //*****TEST
        //Step_1
        //Se hace clic en Desplegar lista de UDE
        hospitalizacionActions.PlegarDesplegarLista("Unidad de enfermeria");
        //La lista se despliega correctamente y se muestran los distintos UDE
        Assert.assertTrue(hospitalizacionConditions.PlegadaDesplegadaUnidadEnfermeria());

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId + ".png", testId + " - OK");

    }

    /**
     * android-H-005_2 - Hospitalización - Seleccionar/Deseleccionar UDE
     * Precondition: android-H-005_1
     * @param selecDeselec Se usa TRUE para seleccionar y FALSE para deseleccionar elemento de la lista
     */
    public void Android_H_005_2(String id, boolean selecDeselec) {
        Android_H_005_1();
        String testId = id;
        //*****TEST
        //Step_1
        //Seleccionar/Deseleccionar un UDE
        String elemento = dataRepo.getDataFromRepository(testId,"ElementoListaSeleccion");
        boolean estado = commonActions.SeleccionarDeseleccionarElementoLista(elemento, "Unidad de enfermeria");
        //El UDE se Selecciona/Deselecciona correctamente
        Assert.assertEquals(estado,selecDeselec);
        //**************

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-005_4 - Hospitalización - Eliminar UDE
     * Precondition: android-H-002
     */
    public void Android_H_005_4(String id) {
        Android_H_002();
        String testId = id;
        //*****TEST
        //Step_1
        //Se hace clic en la X de un UDE
        String asignacionSeleccionada = dataRepo.getDataFromRepository(testId,"asignacionSeleccionada");
        hospitalizacionActions.EliminarSeleccionFiltro(asignacionSeleccionada, "Unidad de enfermeria");
        //El UDE desaparece de la lista
        //habilitar el mismo método para que devuleva mensaje de que no se encuentra el elemento **************


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }


    /**
     * android-H-006_1 - Hospitalización - Desplegar lista Asignación
     * Precondition: android-H-002
     */
    public void Android_H_006_1() {
        Android_H_002();
        String testId = "Android_H_006_1";
        //*****TEST
        //Step_1
        //Se hace clic en Desplegar lista de Asignacion
        hospitalizacionActions.PlegarDesplegarLista("Asignación");
        //La lista se despliega correctamente y se muestran "Mis pacientes" y seleccionar medico
        Assert.assertTrue(hospitalizacionConditions.PlegadaDesplegadaAsignacion());

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId + ".png", testId + " - OK");

    }

    /**
     * android-H-006_2 - Hospitalización - Marcar/Desmarcar Mis pacientes
     * Precondition: android-H-006_2
     * @param estadoSwitch Se usa TRUE para seleccionar y FALSE para deseleccionar el switch Mis apcientesç
     */
    public void Android_H_006_2(boolean estadoSwitch) {
        String testId = "Android_H_006_2";
        //*****TEST
        //Step_1
        //Seleccionar/Deseleccionar un el switch "Mis pacientes"

        hospitalizacionActions.PulsarSwitchAsignacion();

        //"Mis pacientes" se Selecciona/Deselecciona correctamente
        Assert.assertEquals(hospitalizacionConditions.PulsadoSwitchAsignacion(),estadoSwitch);


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-006_3 - Hospitalización - Plegar lista Asignacion
     * Precondition: android-H-002
     */
    public void Android_H_006_3() {
        Android_H_002();
        String testId = "Android_H_006_3";
        //*****TEST
        //Step_1
        //Se hace clic en Plegar lista de Asignacion
        hospitalizacionActions.PlegarDesplegarLista("Asignación");
        hospitalizacionActions.PlegarDesplegarLista("Asignación");
        //La lista se pliega correctamente y deja de mostrarse. Se muestran los elementos seleccionados en la lista
        Assert.assertTrue(!hospitalizacionConditions.PlegadaDesplegadaAsignacion());

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId + ".png", testId + " - OK");

    }

    /**
     * android-H-006_4 - Hospitalización - Eliminar Asignacion
     * Precondition: android-H-002
     */
    public void Android_H_006_4(String id) {
        Android_H_002();
        String testId = id;
        //*****TEST
        //Step_1
        //Pulsar sobre la "X" de la asignación.
        String asignacionSeleccionada = dataRepo.getDataFromRepository(testId,"asignacionSeleccionada");

        hospitalizacionActions.EliminarSeleccionFiltro(asignacionSeleccionada, "Asignación");
        //Se comprueba que la asignación está vacía.
            //habilitar el mismo método para qu devuleva mensaje de que no se encuentra el elemento


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }


    /**
     * android-H-006_5 - Hospitalización - Abrir lista medico
     * Precondition: android-H-006_1
     */
    public void Android_H_006_5() {
        Android_H_006_1();
        String testId = "Android_H_006_5";
        //*****TEST
        //Step_1
        //Se hace clic en Abrir lista seleccion de medíco
        hospitalizacionActions.AbrirListaMedico();
        //La lista se abre correctamente en otra ventana y se muestran los elementos a seleccionarseleccion de medico
        hospitalizacionConditions.AbiertaListaMedico();
        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-006_6 - Hospitalización - Seleccionar/Deseleccionar medico
     * Precondition: android-H-006_5
     * @param selecDeselec Se usa TRUE para seleccionar y FALSE para deseleccionar elemento de la lista
     */
    public void Android_H_006_6(String id, boolean selecDeselec) {
        Android_H_006_5();
        String testId = id;
        //*****TEST
        //Step_1
        //Seleccionar/Deseleccionar un medico
        String elemento = dataRepo.getDataFromRepository(testId,"ElementoListaSeleccion");
        boolean estado = commonActions.SeleccionarDeseleccionarElementoLista(elemento,"Asignación");
        //una medico se Selecciona/Deselecciona correctamente
        Assert.assertEquals(estado,selecDeselec);
        //**************

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-006_7 - Hospitalización - Volver atrás
     * Precondition: android-H-006_5
     */
    public void Android_H_006_7() {
        Android_H_006_5();
        String testId = "Android_H_006_7";
        //*****TEST
        //Step_1
        //Click en símobolo de Atrás
        commonActions.Volver(1);
        //Se vuelve a la lista desplegada de Asignación
        Assert.assertTrue(hospitalizacionConditions.PlegadaDesplegadaAsignacion());

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-006_8 - Hospitalización - Volver atrás
     * Precondition: android-H-006_5
     */
    public void Android_H_006_8() {
        Android_H_006_5();
        String testId = "Android_H_006_8";
        //*****TEST
        //Step_1
        //Se hace clic en Abrir lista seleccion de medíco
        hospitalizacionActions.AbrirListaMedico();
        //Se muestra un mensaje de error. Se cierra el mensaje y volvemos a las opciones de filtro
        String textoError = "No puedes tener el filtro por servicio vacío. Debes añadir un servicio.";
        commonActions.ComprobarErrorDialog(textoError);
        //Se vuelve a la lista desplegada de Asignación
        Assert.assertTrue(hospitalizacionConditions.PlegadaDesplegadaAsignacion());

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-007 - Hospitalización - Volver atrás
     * Precondition: android-H-002
     */
    public void Android_H_007() {
        Android_H_002();
        String testId = "Android_H_007";
        //*****TEST
        //Step_1
        //Click en símbolo de Atrás
        commonActions.Volver(1);
        //Se vuelve a la estación y se muestra un contador con todos los pacientes del listado
        commonConditions.AccesoEstacion(this.estacion);


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-008 - Hospitalización - NO Volver atrás
     * Precondition: android-H-002
     */
    public void  Android_H_008() {
        Android_H_002();
        String testId = "Android_H_008";
        //*****TEST
        //Step_1
        //Click en símbolo de Atrás
        commonActions.Volver(1);
        //Se muestra un pop-up de que no se puede volver porque un servicio o una UDE no estan seleccionados. Tras aceptar se vuelve a la ventana filtros
        commonActions.ComprobarErrorDialog("No puedes tener el filtro por servicio y unidad de enfermeria vacío. Debes añadir un servicio o una unidad de enfermeria.");
        commonConditions.AbriertoFiltroEstacion(this.estacion);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-008 - Hospitalización - Eliminar seleccion
     * Precondition: android-H-002
     */
   /* public void Android_H_008() {
        String testId = "Android_H_008";
        //*****TEST
        //Step_1
        //Click en símbolo de Atrás
        commonActions.Volver(1);
        //Se vuelve a la estación y se muestra un contador con todos los pacientes del listado
        commonConditions.AccesoEstacion(this.estacion);


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }
*/
    /**
     * android-H-009 - Hospitalización - Filtro por defecto eliminado
     * Precondition: android-H-007
     */
    public void Android_H_009(String id){
        Android_H_007();
        String testId = id;
        //*****TEST
        //Step_1
        // Se modifica el filtro por defecto

        // El icono del filtro se muestra con el punto rojo
        String numResulH = dataRepo.getDataFromRepository(testId,"numResulH");
        commonConditions.ComprobarResultadosPacientes(numResulH);

        //Comprobar que el icono está con el punto rojo (Return False)
        Assert.assertTrue(commonConditions.FiltroPorDefecto("Mapa.Filtro"));


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-H-010 - Hospitalización - Listado pacientes vacío
     * Precondition: android-H-003 - android-H-009
     */
    public void Android_H_010(String id){
        String testId = id;
        //*****TEST
        //Step_1
        // En el listado de pacientes no tiene ningún paciente

        // Se muestra un mensaje de que no hay pacientes con el filtro actual

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }
    /**
     * android-H-011 - Hospitalización - Listado pacientes
     * Precondition: android-H-003 - android-H-009
     */
    public void Android_H_011(String id){
        String testId = id;
        //*****TEST
        //Step_1
        // En el listado de pacientes se muestra una lista de pacientes

        // Cada paciente debe mostrar:
        //Nombre del paciente
        //Motivo de ingreso
        //Recurso
        //Servicio en el que está ingresado el paciente
        //Edad del paciente
        //Tiempo que lleva ingresado el paciente


        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

}