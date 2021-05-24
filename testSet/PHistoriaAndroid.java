import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Actions.PHistoriaActions;
import Actions.PacienteActions;
import Conditions.CommonConditions;
import Conditions.FlujoPrincipalConditions;
import Conditions.PHistoriaConditions;
import Conditions.PacienteConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class PHistoriaAndroid {
    Utils utils;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public PHistoriaActions pHistoriaActions;
    public PHistoriaConditions pHistoriaConditions;
    public PacienteConditions pacienteConditions;



    public PHistoriaAndroid(){

        utils = new Utils();
        objRepo = Utils.GetObjRepo();
        dataRepo = Utils.GetDataRepo();

        //clases
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();

        pHistoriaActions = Utils.GetPHistoriaActions();
        pHistoriaConditions = Utils.GetPHistoriaConditions();
        pacienteConditions = Utils.GetPacienteConditions();
        //Variables

    }


    /**
     * android-PH-001_1 - PHistoria - Historia Covid19
     * Precondition: android-P-001
     */

    public void Android_PH_001_1(){
        String testId = "Android_PH_001_1";
        //*****TEST
        //Step_1
        //Preconditions
        // Click sobre el símbolo de Covid19 de color verde.
        pHistoriaActions.PulsarCovid();
        // Se muestra Historia Covid19
        pHistoriaConditions.PulsadoCovid();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PH-002 - PHistoria - Historia Alergias
     * Precondition: android-P-001
     */

    public void Android_PH_002(){
        String testId = "Android_PH_002";
        //*****TEST
        //Step_1
        //Preconditions
        // Click sobre el símbolo de Alergias de color rojo.
        pHistoriaActions.PulsarAlergias();
        // Se muestran las alergias del paciente
        pHistoriaConditions.PulsadoAlergias();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PH-009 - PHistoria - Evolución
     * Precondition: -
     */

    public void Android_PH_009(){
        String testId = "Android_PH_009";
        //*****TEST
        //Step_1
        //Preconditions
        // Click sobre el símbolo de Evolución (ojo)
        pHistoriaActions.PulsarEvolucion();
        // Se muestran las alergias del paciente
        pHistoriaConditions.PulsadoEvolucion();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-PH-001_2 - PHistoria - Salir Historia Covid19
     * Precondition: android-PH-001_1
     */

    public void Android_PH_001_2(){
        String testId = "Android_PH_001_2";
        //*****TEST
        //Step_1
        //Preconditions
        // Click para salir de Covid19
        //commonActions.TapCoordenadas(396, 181);
        commonActions.PulsarBotonBack();
        // Se cierra Historia Covid19
        pHistoriaConditions.CerradoCuadro("Historial Covid");

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PH-005 - PHistoria - Salir Alergias
     * Precondition: android-PH-002
     */

    public void Android_PH_005(){
        String testId = "Android_PH_005";
        //*****TEST
        //Step_1
        //Preconditions
        // Click para salir de Alergias
        commonActions.PulsarBotonBack();
        // Se regresa la Historia de Paciente.
        pHistoriaConditions.CerradoCuadro("Alergias");

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-PH-010 - PHistoria - Volver - Evolución
     * Precondition: android-PH-009
     */

    public void Android_PH_010(){
        String testId = "Android_PH_010";
        //*****TEST
        //Step_1
        //Preconditions
        // Click sobre el símbolo de volver hacia atrás.
        commonActions.Volver(1);
        // Se regresa la Historia de Paciente.
        String buscarPacienteNombre = dataRepo.getDataFromRepository(testId,"buscarPacienteNombre");
        pacienteConditions.MostradaHistoriaPaciente(buscarPacienteNombre);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PH-012_1 - PHistoria - Filtro - Historia
     * Precondition: android-P-001
     */

    public void Android_PH_012_1(){
        String testId = "Android_PH_012_1";
        //*****TEST
        //Step_1
        //Preconditions
        // Click sobre el símbolo de Filtros historia.
        pHistoriaActions.PulsarFiltroHistoria();
        // Se muestra una lista de filtros, por defecto desactivados:
        //*Informe
        //*Formulario
        //*Nota
        //*Petición
        //*Foto
        pHistoriaConditions.PulsadoFiltroHistoria();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }
    /**
     * android-PH-012_2 - PHistoria - Filtro - Historial Seleccionar opciones
     * Precondition: android-PH-012_1
     * //Valor del parametros:
     *         //* 1º Informe = SI/NO
     *         //* 2º Formulario = SI/NO
     *         //* 3º Nota = SI/NO
     *         //* 4º Petición = SI/NO
     *         //* 5º Foto  = SI/NO
     *
     * Ejemplo de parametro para todo no: "NO,NO,NO,NO,NO"
     * Ejemplo de parametro para todo si: "SI,SI,SI,SI,SI"
     * Ejemplo de parametro para si y no: "SI,NO,NO,SI,SI"
     */

    public void Android_PH_012_2(String id){
        String testId = id;
        //*****TEST
        //Step_1
        //Preconditions
        // Click sobre los checkbox que se desean pulsar.
        String opciones = dataRepo.getDataFromRepository(testId,"opcionesFiltroHistoria");
        pHistoriaActions.SeleccionarOpcionesFiltroHistoria(opciones);
        // Los checkbox seleccionados se pulsan correctamente
        pHistoriaConditions.SeleccionadasOpcionesFiltroHistoria(opciones);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-PH-012_3 - PHistoria - Volver - Filtro
     * Precondition: android-PH-012_1
     */

    public void Android_PH_012_3(String id){
        String testId = id;
        //*****TEST
        //Step_1
        //Preconditions
        // Click sobre Volver
        commonActions.Volver(1);
        // Vuelve al menú Historia del paciente y se aplica el filtro seleccionado
        String numResultados = dataRepo.getDataFromRepository(testId,"resultadoFiltroHistoria");
        pHistoriaConditions.HistoriaPacienteFiltrada(numResultados);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-PH-014 - Hospitalización - Filtro por defecto eliminado
     * Precondition: android-P-001
     */
    public void Android_PH_014(){
        String testId = "Android_PH_014";
        //*****TEST
        //Step_1
        // Se modifica el filtro por defecto
        //Comprobar que el icono está con el punto rojo (Return False)
        Assert.assertTrue(commonConditions.FiltroPorDefecto("Historia.Filtro"));

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }
    /**
     * android-PH-015 - Hospitalización - Filtro por defecto NO eliminado
     * Precondition: android-P-001
     */
    public void Android_PH_015(){
        String testId = "Android_PH_015";
        //*****TEST
        //Step_1
        // Se modifica el filtro por defecto
        //Comprobar que el icono está SIN el punto rojo (Return False)
        Assert.assertTrue(!commonConditions.FiltroPorDefecto("Historia.Filtro"));

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

}
