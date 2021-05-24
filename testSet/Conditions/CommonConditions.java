package Conditions;

import Actions.CommonActions;
import Utilities.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import static Utilities.Utils.androidDriver;
import static Utilities.Utils.objRep;

public class CommonConditions {

    Utils utils;
    public CommonActions commonActions;

    public CommonConditions (){
        utils = new Utils();
        commonActions = Utils.GetCommonActions();
    }
/*
    public void Logueado1(String user) throws Exception {
        WebDriverWait wait = new WebDriverWait(androidDriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.radmas.iycp.casiopea.pre:id / login_inner_root")));
    }

    public void Logueado2(String user) throws Exception {
        WebDriverWait wait = new WebDriverWait(androidDriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.radmas.iycp.casiopea.pre:id / login_inner_root")));
    }
*/
/*
    public void ComprobadoErrorDialog() throws Exception {
        do {
            androidDriver.findElementById("com.radmas.iycp.casiopea.pre:id/error_dialog_ok_button").click();
        }
        while (commonActions.ComprobarErrorDialog());
    }
    */
    /**
     * <p> Método para comprobar que un listado pasado por parametro se corresponde con el que muestra la aplicación</p>
     * @param listado
     * @param xpath
     * @throws Exception
     */
    public void ComprobarListado(String[] listado, String xpath){

        try {
            while (androidDriver.findElementsByXPath("/" + xpath).size() == 0) ;

            /*
            for (int i = 1; i <= listado.length; i++) {
                //Assert.assertEquals(listadoAPP[i-1].equals(androidDriver.findElementByXPath("//android.widget.LinearLayout[" + i + "]" + xpath).getText()), listado[i - 1]);
                Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout[" + i + "]" + xpath).getText(), listado[i - 1]);
            }*/
            int listaCompleta = 0;
            System.out.println("APP: "+androidDriver.findElementsByXPath("/" + xpath).size()+" LIS: "+listado.length);

            if(androidDriver.findElementsByXPath("/" + xpath).size()==listado.length) {
                for (int i = 1; i <= listado.length; i++) {
                    int j=0;
                    while (j<listado.length){

                        System.out.println(androidDriver.findElementByXPath("//android.widget.LinearLayout[" + i + "]" + xpath).getText());
                        System.out.println(listado[j]);
                        if (androidDriver.findElementByXPath("//android.widget.LinearLayout[" + i + "]" + xpath).getText().equals(listado[j])) {
                            listaCompleta++;
                            j = listado.length;
                            System.out.println(listaCompleta);
                        }else j++;
                    }
                    //Assert.assertEquals(listadoAPP[i-1].equals(androidDriver.findElementByXPath("//android.widget.LinearLayout[" + i + "]" + xpath).getText()), listado[i - 1]);
                    //Assert.assertEquals(androidDriver.findElementByXPath("//android.widget.LinearLayout[" + i + "]" + xpath).getText(), listado[i - 1]);
                }
            }
            System.out.println(listaCompleta);
            if (listaCompleta != listado.length){
                commonActions.CapturadorExcepcion("ListadoDiferente.png", "Listado de datos diferente a listado de APP");
                throw new NullPointerException();
            }
       /* }catch(AssertionError e){
            commonActions.CapturadorExcepcion("ListadoDiferente.png", "Listado de datos diferente a listado de APP");
            throw e;*/
        }catch(Exception e){
            commonActions.CapturadorExcepcion("ListadoErroneo.png", "Error al procesar listados");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se abre la aplicación de llamadas del dispositivo con el número de Soporte marcado </p>
     * @throws Exception
     */
    public void PulsadoLlamarSoporte(){

        String num1 = "(900) 701-161";
        String num2 = "900701161";
        String activityCasiopea = "com.radmas.iycp.presentation.";

        try {
            if(androidDriver.currentActivity().indexOf(activityCasiopea)==-1) { //Comprueba si se produce el cambio de Casiopea a otra APP
                //Comprueba si está marcado el número en ambos formatos
                commonActions.PrintReportMessage("Se abre 'Llamar' correctamente");
                if (androidDriver.findElementsByXPath(objRep.ObjectID("Numero.Soporte1")).size() != 0){
                    commonActions.PrintReportMessage("El número de soporte marcado es correcto: " + num1);
                }else if (androidDriver.findElementsByXPath(objRep.ObjectID("Numero.Soporte2")).size() != 0){
                    commonActions.PrintReportMessage("El número de soporte marcado es correcto: " + num2);
                }else throw new NullPointerException();

            }else throw new NullPointerException();
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoLlamarSoporte.png", "Error al llamar a soporte al numero: "+num1+" // "+num2);
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se meustran o no pacientes en los distintos ambitos y que cantidad en concreto </p>
     * @param num
     * @throws AssertionError
     * @throws Exception
     */
    public void ComprobarResultadosPacientes(String num){
        try {

            if (num.equals("0")) {
                Utils.SearchAndroidElement("Mapa.SinPacientes");
            } else {
                Assert.assertEquals(Utils.SearchAndroidElement("Mapa.ContadorPacientes").getText(),num);
            }
            commonActions.PrintReportMessage("Se muestra correctamente el numero de pacientes: "+ num);
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("ComprobarResultadosPacientes.png", "NO se muestra correctamente el numero de pacientes: "+ num);
            throw e;
        }catch(Exception e){
            commonActions.CapturadorExcepcion("ComprobarResultadosPacientes.png", "ERROR al mostrar los pacientes");
            throw e;
        }
    }
    /**
     * <p> Método para comprobar que se abre la aplicación de llamadas del dispositivo con el número de Paciente </p>
     * @throws Exception
     */
    public void PulsadoLlamarPaciente(String num){

        commonActions.SaltarTutorial();

        String numero = "#31#"+num;
        String activityCasiopea = "com.radmas.iycp.presentation.";

        try {
            if(androidDriver.currentActivity().indexOf(activityCasiopea)==-1) { //Comprueba si se produce el cambio de Casiopea a otra APP
                //Comprueba si está marcado el número en ambos formatos
                commonActions.PrintReportMessage("Se abre 'Llamar' correctamente");
                if (androidDriver.findElementsByXPath("//*[@text='"+numero+"']").size() != 0){
                    commonActions.PrintReportMessage("El número del paciente marcado es correcto: " + num);
                }else throw new NullPointerException();

            }else throw new NullPointerException();
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("PulsadoLlamarSoporte.png", "Error al llamar al paciente al numero: "+numero);
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se ha accedido correctamente a la estación deseada </p>
     * @param estacion
     * @throws Exception
     */
    public void AccesoEstacion(String estacion) {
        //Acceder a la estación con el nombre indicado
        try {
            if (estacion == "Consultas" || estacion == "Quirófanos") Utils.SearchAndroidElement("Mapa.BarraFecha");
            //-> Como saber el color que cambia?? Otro metodo
            ///------------------------------------------------------ también el metodo color poner mas bonico lo que se imprime por consola
            int numEstacion;

            switch(estacion){
                case "Hospitalizacion":
                    numEstacion = 1;
                    break;
                case "Urgencias":
                    numEstacion = 2;
                    break;
                case "Consultas":
                    numEstacion = 3;
                    break;
                case "Quirófanos":
                    numEstacion = 4;
                    break;
                default:
                    numEstacion = 0;
            }
            AndroidElement elem = androidDriver.findElementByXPath("//android.widget.LinearLayout[" + numEstacion + "]/android.view.View");
            int[] rgbRecibido = this.ColorElemento(elem, "Estacion seleccionada");
            int[] rgbSeleccion = new int[]{255,255,255};
            Assert.assertEquals(rgbRecibido,rgbSeleccion);
            commonActions.PrintReportMessage("Se muestra correctamente la estación: "+ estacion);
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("AccesoEstacion.png", "La estación "+estacion+" no está seleccionada");
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("AccesoEstacion.png", "ERROR al intentar acceder a la estación "+estacion);
            throw e;
        }

    }


    /**
     * <p> Método que devulve el código RGB de un elemento visual de la APP </p>
     * @param elem Elemento de donde extraer el color
     * @param descripcion Descripción del elem
     * @throws Exception
     */
    public int[] ColorElemento(AndroidElement elem, String descripcion) {

            org.openqa.selenium.Point point = elem.getCenter();
            int centerx = point.getX();
            int centerY = point.getY();

            File scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);

        BufferedImage image = null;

        try {
            image = ImageIO.read(scrFile);
        } catch (IOException ioException) {
            commonActions.CapturadorExcepcion("ColorElemento.png", "ERROR al recuperar la imagen de extracción de color de un elemento");
            ioException.printStackTrace();
        }
        // Getting pixel color by position x and y
            int clr = image.getRGB(centerx, centerY);
            int red = (clr & 0x00ff0000) >> 16;
            int green = (clr & 0x0000ff00) >> 8;
            int blue = clr & 0x000000ff;
            commonActions.PrintReportMessage("Color elemento "+descripcion+" -> R: " + red +" G: "+green+" B: "+blue);

            int[] rgb = new int[]{red,green,blue};

            return rgb;
    }

    /**
     * <p> Método que comprueba si el icono de filtro es el icono por defecto (Sin punto rojo) o no es el icono de filtro por defecto (Con punto Rojo)  </p>
     * @return boolean Devuelve False (Filtro por defecto), (True) filtro no defecto
     * @param element Elemento sobre el que analizar el punto rojo del filtro
     * @throws Exception
     */
    public boolean FiltroPorDefecto(String element) {

        boolean filtroDefecto = false;
        AndroidElement elem = Utils.SearchAndroidElement(element);
        int[] colorReferencia= new int[]{227,0,0};

        org.openqa.selenium.Point point = elem.getCenter();
        int centerx = point.getX();
        int centerY = point.getY();
        int width = elem.getSize().getWidth();
        int height = elem.getSize().getHeight();
        int pixelInicialX = centerx-(width/2);
        int pixelFinalX = centerx+(width/2);
        int pixelInicialY = centerY-(height/2);
        int pixelFinalY = centerY+(height/2);

        File scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);

        BufferedImage image = null;

        try {
            image = ImageIO.read(scrFile);
        } catch (IOException ioException) {
            commonActions.CapturadorExcepcion("FiltroPorDefecto.png", "ERROR al recuperar la imagen de extracción de color del icono filtro");
            ioException.printStackTrace();
        }

        for (int x=pixelInicialX;x<=pixelFinalX;x++){
            if(!filtroDefecto) {
                for (int y = pixelInicialY; y <= pixelFinalY; y++) {
                    int clr = image.getRGB(x, y);
                    int red = (clr & 0x00ff0000) >> 16;
                    int green = (clr & 0x0000ff00) >> 8;
                    int blue = clr & 0x000000ff;
                    //System.out.println("C: "+x+" , "+y+" // R:" + red +" G: "+green+" B: "+blue);
                    if (red == colorReferencia[0] && green == colorReferencia[1] && blue == colorReferencia[2]) {
                        System.out.println("NO DEFECTO: "+x+" , "+y+" // R:" + red +" G: "+green+" B: "+blue);
                        filtroDefecto = true;
                        commonActions.PrintReportMessage("El filtro por defecto está desactivado");
                        break;
                    }
                }
            }
        }
        if(!filtroDefecto) commonActions.PrintReportMessage("El filtro por defecto está activado");
        return filtroDefecto;
    }

    /**
     * <p> Método para comprobar si está abierto el filtro de cualquier estación </p>
     * @throws Exception
     */
    public void AbriertoFiltroEstacion(String estacion){
        String tituloCabecera = "Filtros "+estacion;
        try {
            Assert.assertEquals(Utils.SearchAndroidElement("General.BarraTitulo").getText(),tituloCabecera);
            commonActions.PrintReportMessage("Se ha abierto el filtro: "+estacion+" correctamente");
        }catch(AssertionError e){
            commonActions.CapturadorExcepcion("AbriertoFiltroEstacion.png", "El filtro abierto no es correcto: "+ tituloCabecera);
            throw e;
        }catch(Exception e){
            commonActions.CapturadorExcepcion("AbriertoFiltroEstacion.png", "No se pudo abrir el filtro: "+ tituloCabecera);
            throw e;
        }

    }

    /**
     * <p> Método que comrpueba que se meustra el menú principal sin ningún tipo de condicion </p>
     */
    public void MostradoMenuPrincipal(){

        commonActions.SaltarTutorial();
        //Comprobar que nos lleva al menú INICIO
        try {
            //Boton conversaciones con o sin nuevas notificaciones
            if(androidDriver.findElementsByAccessibilityId(objRep.ObjectID("Conversaciones.Boton")).size()>0) {
                Utils.SearchAndroidElement("Conversaciones.Boton");
            }else{
                Utils.SearchAndroidElement("Conversaciones.BotonNotificaciones");
            }

            Utils.SearchAndroidElement("Interconsultas.Boton");
            Utils.SearchAndroidElement("Notificaciones.Boton");
            Utils.SearchAndroidElement("Mas.Boton");

            commonActions.PrintReportMessage("Se muestra correctamente la pantalla de inicio");
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("MostradoInicio.png", "No se muestra correctamente la pantalla de inicio");
            throw e;
        }
    }

    /**
     * <p> Método para comprobar que se abre correctamente una pantalla comprobando la barra de titulo</p>
     * @param titulo
     * @throws AssertionError
     * @throws Exception
     */
    public void ComprobarBarraTitulo(String titulo){
        try {
            Utils.SearchAndroidElement("General.BarraTitulo");
            Assert.assertEquals(Utils.SearchAndroidElement("General.BarraTitulo").getText(), titulo);
            commonActions.PrintReportMessage("Se muestra correctamente la pantalla '"+titulo+"'");
        }catch(AssertionError e){
            CommonActions.CapturadorExcepcion("ComprobarBarraTitulo"+titulo+".png", "La pantalla "+titulo+" NO coincide con la barra de título: "+Utils.SearchAndroidElement("General.BarraTitulo").getText());
            throw e;
        }catch(Exception e){
            CommonActions.CapturadorExcepcion("ComprobarBarraTitulo"+titulo+".png", "Error al mostrar la pantalla '"+titulo+"'");
            throw e;
        }
    }

}

