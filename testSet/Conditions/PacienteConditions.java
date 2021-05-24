package Conditions;

import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Utilities.Utils.androidDriver;

public class PacienteConditions {

    public WebDriverWait wait;
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    public FlujoPrincipalActions flujo_principalActions;
    public FlujoPrincipalConditions flujo_principalConditions;
    Utils utils;

    public PacienteConditions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();
        flujo_principalActions = Utils.GetFlujo_PrincipalActions();
        flujo_principalConditions = Utils.GetFlujo_PrincipalConditions();
    }

    public void MostradaHistoriaPaciente(String nombre){

        commonActions.SaltarTutorial();
        try{
            Assert.assertEquals(Utils.SearchAndroidElement("Paciente.BarraTitulo").getText(),nombre);
            Utils.SearchAndroidElement("Historia.Boton");
            Utils.SearchAndroidElement("Prescripciones.Boton");
            Utils.SearchAndroidElement("Peticiones.Boton");
            Utils.SearchAndroidElement("Acciones.Boton");
            commonActions.PrintReportMessage("La historia del paciente "+nombre+" se muestra correctamente");
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("MostradaHistoriaPaciente.png", "La historia del paciente "+nombre+" no se encuentra");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("MostradaHistoriaPaciente.png", "Error al abrir la historia del paciente "+nombre);
            throw e;
        }
    }

    public void PulsadoOtros(){

        try{
            Utils.SearchAndroidElement("Paciente.Otros.Glosario");
            Utils.SearchAndroidElement("Paciente.Otros.Llamar");

            commonActions.PrintReportMessage("Menú OTROS se despliega correctamente");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoOtros.png", "ERROR al abrirse el menú OTROS");
            throw e;
        }
    }

    public void PulsadoGlosario(String ambito){

        try{
            commonConditions.ComprobarBarraTitulo("Glosario "+ambito);

            commonActions.PrintReportMessage("Glosario del ambito: "+ambito+" se abre correctamente");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoGlosario.png", "ERROR al abrir glosario");
            throw e;
        }
    }
}
