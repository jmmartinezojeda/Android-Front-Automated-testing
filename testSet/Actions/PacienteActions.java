package Actions;

import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static Utilities.Utils.androidDriver;

public class PacienteActions {

    public WebDriverWait wait;
    Utils utils;
    public CommonActions commonActions;

    public PacienteActions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
    }

    /**
     * <p> Método para comenzar la búsqueda de pacientes en el input buscar </p>
     * @throws Exception
     */
    public void BuscarPaciente(){
        try {
            Utils.SearchAndroidElement("Mapa.InputBuscar").click();
            Utils.SearchAndroidElement("Mapa.InputBuscar").click();
            commonActions.TapEnterKeyboard();
            commonActions.PrintReportMessage("Se inicia la búsqueda de paciente correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("BuscarPaciente.png", "Error al intentar buscar paciente");
            throw e;
        }

    }

    /**
     * <p> Método hacer click en el boton OTROS</p>
     * @throws Exception
     */
    public void PulsarOtros(){
        try {
            Utils.SearchAndroidElement("Paciente.Otros").click();
            commonActions.PrintReportMessage("Se pulsa el botón OTROS");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarOtros.png", "ERROR al pulsar el botón OTROS");
            throw e;
        }

    }

    /**
     * <p> Método hacer click en Glosario</p>
     * @throws Exception
     */
    public void PulsarGlosario(){
        try {
            Utils.SearchAndroidElement("Paciente.Otros.Glosario").click();
            commonActions.PrintReportMessage("Se pulsa el botón OTROS->Glosario");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarGlosario.png", "ERROR al pulsar el botón OTROS->Glosario");
            throw e;
        }

    }

    /**
     * <p> Método para hacer click en llamar a soporte en Paciente - OTROS</p>
     * @throws Exception
     */
    public void PulsarLlamarSoporte(){
        try {
            Utils.SearchAndroidElement("Paciente.Otros.Llamar").click();
            commonActions.PrintReportMessage("Click en Llamar a soporte correcto");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarLlamarSoporte.png", "No se pudo pulsar en 'Llamar a soporte'");
            throw e;
        }
    }





}
