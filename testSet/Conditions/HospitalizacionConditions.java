package Conditions;

import Actions.CommonActions;
import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Utilities.Utils.androidDriver;
import static Utilities.Utils.objRep;

public class HospitalizacionConditions {

    public WebDriverWait wait;
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    Utils utils;

    public HospitalizacionConditions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
    }

    /**
     * <p> Método para comprobar que el switch "Mis pacientes" está o no marcado </p>
     * @return desplegado TRUE pulsado FALSE NO pulsado
     * @throws Exception
     */
    public boolean PulsadoSwitchAsignacion() {

        Boolean pulsado = false;
        try {
            pulsado = Boolean.parseBoolean(Utils.SearchAndroidElement("H.Filtro.Asignacion.Switch").getAttribute("checked"));
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoSwitchAsignacion.png", "ERROR con el switch Mis pacientes. No se encuentra el elemento en la pantalla");
            throw e;
        }
        return pulsado;
    }


    /**
     * <p> Método para comprobar que el campo Asignacion está o no desplegado </p>
     * @return boolean desplegado TRUE desplegado FALSE plegado
     */
    public boolean PlegadaDesplegadaAsignacion() {
        Utils.CambiarTiempoDeEspera(2);
        Boolean desplegado = false;
        try {
            if(androidDriver.findElementsById(objRep.ObjectID("H.Filtro.Asignacion")).size()!=0){
                desplegado = true;
                commonActions.PrintReportMessage("Asignacion está desplegado");
            }else commonActions.PrintReportMessage("Asignacion está Plegado");

        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PlegadaDesplegadaAsignacion.png", "ERROR con el campo Asignación. No se encuentra el elemnto en la pantalla");
            throw e;
        }
        Utils.RestaurarTiempoDeEspera();
        return desplegado;
    }

    /**
     * <p> Método para comprobar que el campo servicio está o no desplegado </p>
     * @return boolean desplegado TRUE desplegado FALSE plegado
     */
    public boolean PlegadaDesplegadaServicio() {

        Utils.CambiarTiempoDeEspera(2);
        Boolean desplegado = false;
        try {
            if(androidDriver.findElementsByXPath("/android.widget.RelativeLayout[3]/android.widget.Switch").size()!=0 ||
                    androidDriver.findElementsByXPath("/android.widget.RelativeLayout[2]/android.widget.Switch").size()==0){
                desplegado = true;
                commonActions.PrintReportMessage("Servicio está desplegado");
            }else commonActions.PrintReportMessage("Servicio NO está desplegado");

        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PlegadaDesplegadaServicio.png", "ERROR con el campo Srvicio. No se encuentra el elemnto en la pantalla");
            throw e;
        }
        Utils.RestaurarTiempoDeEspera();
        return desplegado;
    }

    /**
     * <p> Método para comprobar que el campo unidad de enfermeria está o no desplegado </p>
     * @return boolean desplegado TRUE desplegado FALSE plegado
     */
    public boolean PlegadaDesplegadaUnidadEnfermeria() {

        Utils.CambiarTiempoDeEspera(2);
        Boolean desplegado = false;
        try {
            if(androidDriver.findElementsByXPath("/android.widget.RelativeLayout[4]/android.widget.Switch").size()!=0 ||
                    androidDriver.findElementsByXPath("/android.widget.RelativeLayout[3]/android.widget.Switch").size()==0){
                desplegado = true;
                commonActions.PrintReportMessage("Unidad de enfermeria está desplegado");
            }else commonActions.PrintReportMessage("Unidad de enfermeria NO está desplegado");

        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PlegadaDesplegadaAsignacion.png", "ERROR con el campo Unidad de enfermeria. No se encuentra el elemnto en la pantalla");
            throw e;
        }

        Utils.RestaurarTiempoDeEspera();
        return desplegado;
    }

    /**
     * <p> Método para comprobar que la lista de selección de médico está abierta</p>
     *
     */
    public void AbiertaListaMedico() {
        try{
            commonConditions.ComprobarBarraTitulo("Médico");
            commonActions.PrintReportMessage("La lsita selección médico está abierta");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("AbiertaListaMedico.png", "ERROR al abrir lista selección médico. No se encuentra el elemento en la pantalla");
            throw e;
        }
    }


}
