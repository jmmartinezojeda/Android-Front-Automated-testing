import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Conditions.CommonConditions;
import Conditions.FlujoPrincipalConditions;
import Utilities.ObjectRepositoryUtils;
import Utilities.TestDataUtils;
import Utilities.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FlujoPrincipalAndroid {
    Utils utils;

    public URL url;
    public DesiredCapabilities capabilities;
    public AndroidDriver<AndroidElement> androidDriver;
    public ObjectRepositoryUtils objRepo;
    public TestDataUtils dataRepo;
    //Instanciar aciones/condiciones
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public FlujoPrincipalActions flujoPrincipalActions;
    public FlujoPrincipalConditions flujoPrincipalConditions;
    //Variables
    public String usuario_login_uno = "delega6";
    public String usuario_login_dos = "delega6";
    public String password_login_dos = "Cambiar.2020";
    public String primer_centro_login_dos = "FUNDACION JIMENEZ DIAZ";
    public String[] lista_centros_login_dos = {"FUNDACION JIMENEZ DIAZ", "HOSPITAL INFANTA ELENA", "HOSPITAL REY JUAN CARLOS", "HOSPITAL GENERAL DE VILLALBA", "Hospital Quironsalud Cordoba", "Hospital QuironSalud del Valles", "Hospital Quironsalud Vitoria"};
    public String[] lista_centros_login_dos_cambio = {"FUNDACION JIMENEZ DIAZ", "HOSPITAL INFANTA ELENA", "HOSPITAL REY JUAN CARLOS", "HOSPITAL GENERAL DE VILLALBA", "Hospital Quironsalud Cordoba", "Hospital QuironSalud del Valles", "Hospital Quironsalud Vitoria"};
    public String buscar_paciente_nombre= "NO TOCAR PREUBAS AUTOMATICAS MOBILITY";
    public String buscar_paciente_nhc= "20012430";

    public String centro_login_dos = "FUNDACION JIMENEZ DIAZ";
    public String centro_cambio_hospital = "HOSPITAL INFANTA ELENA";
    //1-Hospitalizacion
    //2-Urgencias
    //3-Consultas
    //4-Quirófanos
    public String estacion = "Hospitalizacion";
    //Pacientes
    public String centroActual;


    public FlujoPrincipalAndroid (){
        utils = new Utils();
        commonActions = Utils.GetCommonActions();
        objRepo = Utils.GetObjRepo();
        dataRepo = Utils.GetDataRepo();

        //clases
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
        flujoPrincipalActions = Utils.GetFlujo_PrincipalActions();
        flujoPrincipalConditions = Utils.GetFlujo_PrincipalConditions();
        //Variables
    }




    /**
     * android-FP-001 - Flujo Principal - Login uno
     */
    public void Android_FP_001(){
        String testId = "Android_FP_001";
        //*****TEST
        //Step_1
        String usuarioLoginUno = dataRepo.getDataFromRepository(testId,"usuarioLoginUno");
        // Rellenar el campo "Login" con usuario_login_uno
        flujoPrincipalActions.RellenarInputLoginCodigo(usuarioLoginUno);
        // Campo "Login" relleno correctamente
        flujoPrincipalConditions.RellenadoLoginUno(usuarioLoginUno);

        //Step_2
        // Click en "Acceder"
        flujoPrincipalActions.PulsarBotonLogin();
        // Se muestra el mensaje "Código a SMS o email enviado" y un imput para introducir el código
        flujoPrincipalConditions.PulsadoBotonLoginUno();

        //Step_3
        // Rellenar el campo "Código" con el código recibido
        String codConfir = flujoPrincipalActions.RellenarCodigoConfirmacion();
        // Campo relleno correctamente
        flujoPrincipalConditions.RellenadoCodigoConfirmacion(codConfir);

        //Step_4
        //Click en Validar código
        flujoPrincipalActions.PulsarBotonLogin();
        // Se muestra la pantalla "Login dos" y la version correcta de la APP
        flujoPrincipalConditions.MostradoLoginDos();

        //Step_temporallity
        // Seleccionar el boton error root
        //flujoPrincipalActions.PulsarBotonRoot();
        // Campo relleno correctamente
        //flujoPrincipalConditions.PulsadoBotonRoot();

      //String versionApp= dataRepo.getDataFromRepository(testId,"versionApp");
        //flujoPrincipalConditions.MostradoVersionCorrecta(versionApp);
        flujoPrincipalConditions.MostradoVersion();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }


    /**
     * android-FP-002 - Flujo Principal - Login dos
     * @param id se pasa la id para identificarlo en el fichero
     */

    public void Android_FP_002(String id) {
        Android_FP_001();
        String testId = id;
        //*****TEST
        //Step_1
        String usuarioLoginDos = dataRepo.getDataFromRepository(testId, "usuarioLoginDos");
        String passwordLoginDos = dataRepo.getDataFromRepository(testId, "passwordLoginDos");
        // Rellenar los campos "Usuario" y "Contraseña" con usuarioLoginDos y passwordLoginDos
        flujoPrincipalActions.RellenarLoginDos(usuarioLoginDos, passwordLoginDos);
        //La lista desplegable de selección de centro selecciona automaticamente centroPorDefecto y
        // se comprueban que los campos se han rellenado correctamente
        String centroPorDefecto = dataRepo.getDataFromRepository(testId, "centroPorDefecto");
        centroActual = centroPorDefecto; //Selecciona como centro actual el centro por defecto del usuario

        flujoPrincipalConditions.SeleccionadoCentro(centroActual);
        flujoPrincipalConditions.RellenadoLoginDos(usuarioLoginDos, passwordLoginDos);
        //Step_2
        //Click en la lista desplegable de selección de centro
        flujoPrincipalActions.PulsarListaCentros();
        //La lista se despliega y muestra todos los centros (listaCentrosUsuario) asignados a usuarioLoginDos
        String listaCentrosUsuario = dataRepo.getDataFromRepository(testId,"listaCentrosUsuario");
        flujoPrincipalConditions.PulsadaListaCentros(listaCentrosUsuario);//***Repasar
        //Step_3
        //Selecciona centroCambio de listaCentrosUsuario
        String centroCambio = dataRepo.getDataFromRepository(testId,"centroCambio");
        flujoPrincipalActions.SeleccionarCentro(centroCambio);
        centroActual = centroCambio;
        // centroCambio se selecciona correctamente
        flujoPrincipalConditions.SeleccionadoCentro(centroActual);
        //Step_4
        //Click en "Entrar"
        flujoPrincipalActions.PulsarBotonLogin();
        //Se accede correctamente y se muestra la pantalla "Inicio" con la estación por defecto del usuario
        String estacionDefecto = dataRepo.getDataFromRepository(testId,"estacionDefecto");
        flujoPrincipalConditions.MostradoInicio(estacionDefecto);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-FP-003 - Flujo Principal - FP-Más
     * Precondition: android-FP-002
     */
    public void Android_FP_003(){
        Android_FP_002("Android_FP_002_1");
        String testId = "Android_FP_003";
        //*****TEST
        //Step_1
        //Click en el botón "Más", representado por "+"
        flujoPrincipalActions.PulsarMasFP();
        //Se despliega una lista con las distintas opciones disponibles
       //centroActual = "HOSPITAL INFANTA ELENA";//--------------------------------------------->BORRAR (Usar solo cuando no se haga login uno)
        flujoPrincipalConditions.PulsadoMasFP(centroActual);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-FP-004 - Flujo Principal - Llamar a soporte
     * Precondition: android-FP-003
     */
    public void Android_FP_004() {
        Android_FP_003();
        String testId = "Android_FP_004";
        //*****TEST
        //Step_1
        //Click en "Llamar a soporte"
        flujoPrincipalActions.PulsarLlamarSoporte();
        //Se abre correctamente la aplicación de Android "Teléfono" con el número marcado
        commonConditions.PulsadoLlamarSoporte();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-FP-005 - Flujo Principal - Desconectarse
     * Precondition: android-FP-003
     */
    public void Android_FP_005() {
        Android_FP_003();
        String testId = "Android_FP_005";
        //*****TEST
        //Step_1
        //Click en "Desconectarse"
        flujoPrincipalActions.PulsarDesconectarse();
        //Se desconecta correctamente y se muesta la pantalla "Login dos"
        flujoPrincipalConditions.MostradoLoginDos();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-FP-006 - Flujo Principal - Cambio hospital
     * Precondition: android-FP-003
     */

    public void Android_FP_006(){
        Android_FP_003();
        String testId = "Android_FP_006";
        //*****TEST
        //Step_1
        //Click en "Cambio Hospital"
        flujoPrincipalActions.PulsarListaCambioCentro();
        //Una lista se despliega y muestra todos los centros (lista_centros_login_dos) asignados a usuario_login_dos
        String listaCentrosUsuario = dataRepo.getDataFromRepository(testId,"listaCentrosUsuario");
        flujoPrincipalConditions.PulsadaListaCambioHospital(listaCentrosUsuario);

        //Step_2
        //Selecciona el centro centroCambio en la lista
        String centroCambio = dataRepo.getDataFromRepository(testId,"centroCambio");
        centroActual = centroCambio;
        flujoPrincipalActions.SeleccionarCentro(centroActual);
        //El centro se selecciona correctamente y se muestra la pantalla "Inicio"
        String estacionDefecto = dataRepo.getDataFromRepository(testId,"estacionDefecto");
        flujoPrincipalConditions.MostradoInicio(estacionDefecto);

        //Step_3
        // Hacemos click en el botón "Más"
        flujoPrincipalActions.PulsarMasFP();
        // Se despliega una lista con los siguientes elementos: centroActual y listaOpcionesFpMas
        flujoPrincipalConditions.PulsadoMasFP(centroActual);

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }

    /**
     * android-FP-007 - Flujo Principal - Mapa
     * Precondition: android-FP-002
     */
    public void Android_FP_007(){
        Android_FP_002("Android_FP_002_1");
        String testId = "Android_FP_007";
        //*****TEST
        //Step_1
        //Click en el botón "Mapa"
        flujoPrincipalActions.PulsarMapa();
        //Se muestra pantalla MAPA
        flujoPrincipalConditions.MostradoMapa();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");

    }


    /**
     * android-FP-008 - Flujo Principal - Mapa-Buscar Nombre
     * Precondition: android-FP-007
     */

  public void Android_FP_008(){
        Android_FP_007();
        String testId = "Android_FP_008";
        //*****TEST
        //Step_1
        //Rellenar el campo buscar con buscar_paciente
        String buscarPacienteNombre = dataRepo.getDataFromRepository(testId,"buscarPacienteNombre");
        flujoPrincipalActions.RellenarMapaBuscadorPacienteNombre(buscarPacienteNombre);
        //Campo buscar relleno correctamente con buscarPacienteNombre
        flujoPrincipalConditions.RellenadoMapaBuscador(buscarPacienteNombre);

        //Step_2
        //Pulsar "Enter" en el teclado numérico
        commonActions.TapEnterKeyboard();
        //flujoPrincipalActions.BuscarMapaBuscador();
        //Se muestra un listado de pacientes como resultado de la búsqueda. En cada paciente se muestra: Nombre del paciente, edad e icono.
        //flujoPrincipalConditions.BuscadoMapaBuscador(buscar_paciente);
        //--------------->VISUALIZAR PACIENTE

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }


    /**
     * android-FP-009 - Flujo Principal - Mapa-Buscar NHC
     * Precondition: android-FP-007
     */

    public void Android_FP_009(){
        Android_FP_007();
        String testId = "Android_FP_009";
        //*****TEST
        //Step_1
        //Rellenar el campo buscar con buscar_paciente
        String buscarPacienteNhc = dataRepo.getDataFromRepository(testId,"buscarPacienteNhc");
        flujoPrincipalActions.RellenarMapaBuscador(buscarPacienteNhc);
        //Campo buscar relleno correctamente con buscarPacienteNhc
        flujoPrincipalConditions.RellenadoMapaBuscador(buscarPacienteNhc);
        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-FP-010 - Flujo Principal - Notificaciones
     * Precondition: android-FP-002
     */
    public void Android_FP_010(){
        Android_FP_002("Android_FP_002_1");
        String testId = "Android_FP_010";
        //*****TEST
        //Step_1
        //Click en "Notificaciones", representado por el icono de la campana
        flujoPrincipalActions.PulsarNotificaciones();
        //Se abre la pantalla notificaciones correctamente con todos los elementos que debe mostrar

        commonConditions.ComprobarBarraTitulo("Notificaciones");

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-FP-011 - Flujo Principal - Conversaciones
     * Precondition: android-FP-002
     */
    public void Android_FP_011(){
        Android_FP_002("Android_FP_002_1");
        String testId = "Android_FP_011";
        //*****TEST
        //Step_1
        //Click en "Notificaciones", representado por el icono de la campana
        flujoPrincipalActions.PulsarConversaciones();
        //Se abre la pantalla notificaciones correctamente con todos los elementos que debe mostrar
        flujoPrincipalConditions.PulsadoConversaciones();
        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }

    /**
     * android-FP-011 - Flujo Principal - Conversaciones
     * Precondition: android-FP-002
     */
    /*
    public void Android_FP_012(){
        String testId = "Android_FP_011";
        //*****TEST
        //Step_1
        //Click en "Notificaciones", representado por el icono de la campana
        flujoPrincipalActions.PulsarConversaciones();
        //Se abre la pantalla notificaciones correctamente con todos los elementos que debe mostrar
        flujoPrincipalConditions.PulsadoConversaciones();

        //*Reporte del caso de prueba
        commonActions.CapturadorExcepcion(testId+".png", testId+" - OK");
    }
*/


/*
    @Test (description = "android_FP-023", enabled = true)
    public void android_FP_023() throws Exception {
        commonActions.AccederEstacion("Hospitalizacion");
        commonActions.BorrarFiltroInicial();


        //*Reporte del caso de prueba
        commonActions.ReporteEjecucion();


    }
*/

}