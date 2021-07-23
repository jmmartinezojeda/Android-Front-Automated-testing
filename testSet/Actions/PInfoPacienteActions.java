package Actions;

import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utilities.Utils.androidDriver;

public class PInfoPacienteActions {

    public WebDriverWait wait;
    Utils utils;
    public CommonActions commonActions;

    public PInfoPacienteActions(){
        utils = new Utils();
        //wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
    }

    /**
     * <p> Método para visualizar/contraer la información del paciente</p>
     * @throws Exception
     */
    public void PulsarInfoPaciente(){
        try {
            Utils.SearchAndroidElement("Paciente.BarraTitulo").click();
            commonActions.PrintReportMessage("La información del paciente se abre/cierra correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("RellenadoMapaBuscador.png", "Error al intentar abrir/contraer la información del paciente");
            throw e;
        }

    }

    /**
     * <p> Método para pulsar sobre expandir/contraer información del paciente</p>
     *
     * @throws Exception
     */
    public void PulsarExpandInfo(){
        try {
            Utils.SearchAndroidElement("Info.ExpandBoton").click();
            commonActions.PrintReportMessage("El botón 'Ver más/menos' se pulsa correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarVerMasInfo.png", "Error al intentar pulsar el botón 'Ver más/menos'");
            throw e;
        }
    }

    /**
     * <p> Método para llamar al número de teléfono del paciente</p>
     * @throws Exception
     */
    public void PulsarTelefono(){
        try {
            Utils.SearchAndroidElement("Info.Telefono").click();
            commonActions.PrintReportMessage("El botón 'Teléfono paciente' se pulsa correctamente");
        }catch(Exception e){
            commonActions.CapturadorExcepcion("PulsarTelefono.png", "Error al intentar pulsar el teléfono del paciente");
            throw e;
        }
    }

}
