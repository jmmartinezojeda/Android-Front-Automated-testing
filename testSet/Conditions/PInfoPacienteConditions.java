package Conditions;

import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Utilities.ObjectRepositoryUtils;
import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.rmi.CORBA.Util;
import java.util.NoSuchElementException;

import static Utilities.Utils.androidDriver;

public class PInfoPacienteConditions {

    public WebDriverWait wait;
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public FlujoPrincipalActions flujo_principalActions;
    public FlujoPrincipalConditions flujo_principalConditions;
    ObjectRepositoryUtils objRep;
    Utils utils;

    public PInfoPacienteConditions(){
        utils = new Utils();
        //wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
        flujo_principalActions = Utils.GetFlujo_PrincipalActions();
        flujo_principalConditions = Utils.GetFlujo_PrincipalConditions();
        objRep = Utils.GetObjRepo();
    }
/*
    public void PulsadoInfoPaciente(String nhc){
        try{
                Utils.SearchAndroidElement("Info.ExpandBoton");
                Assert.assertEquals(Utils.SearchAndroidElement("Info.NHC").getText(), "NHC: " + nhc);
                commonActions.PrintReportMessage("La información del paciente " + nhc + " se abre correctamente");
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("PulsadoInfoPaciente.png", "La información del paciente "+nhc+" no es correcta");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoInfoPaciente.png", "Error al abrir la nformación del paciente "+nhc);
            throw e;
        }
    }
*/
    /**
     * <p> Método para comprobar si se muestra correctamente Contraida/Expandida la información del paciente </p>
     * @throws AssertionError
     * @throws Exception
     */
    public void PulsadoExpandInfo(){
        Utils.CambiarTiempoDeEspera(3);
        try {
            if(androidDriver.findElementsById(objRep.ObjectID("Info.ExpandInfo")).size() != 0) {
                //Utils.SearchAndroidElement("Info.ExpandInfo");
                Assert.assertEquals(Utils.SearchAndroidElement("Info.ExpandBoton").getText(), "VER MENOS");
                commonActions.PrintReportMessage("'Ver más' información del paciente se muestra correctamente");
            }else{
                Assert.assertEquals(Utils.SearchAndroidElement("Info.ExpandBoton").getText(), "VER MÁS");
                commonActions.PrintReportMessage("'Ver menos' información del paciente se muestra correctamente");
            }
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("PulsadoVerMasInfo.png", "Error al desplegar información del pacient. No es correcta");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoVerMasInfo.png", "Error al desplegar información del paciente");
            throw e;
        }
        Utils.RestaurarTiempoDeEspera();
    }

    /**
     * <p> Método para comprobar si se muestra correctamente Contraida/Expandida la información del paciente </p>
     * @throws AssertionError
     * @throws Exception
     */
    public void PulsadoCerrarInfo() {
        Utils.CambiarTiempoDeEspera(3);
        try {
            if (androidDriver.findElementsById(objRep.ObjectID("Info.ExpandBoton")).size() == 0) {
                commonActions.PrintReportMessage("Información del paciente se cerró correctamente");
            } else throw new NullPointerException();

        } catch (Exception e) {
            CommonActions.CapturadorExcepcion("PulsadoCerrarInfo.png", "Error al cerrar la información del paciente");
            throw e;
        }
        Utils.RestaurarTiempoDeEspera();
    }
}
