import java.io.ByteArrayInputStream;
import java.net.URL;


import Utilities.ObjectRepositoryUtils;
import Utilities.Utils;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class AppTest_iOS {
    Utils utils = new Utils();

    public URL url;
    public DesiredCapabilities capabilities;
    public IOSDriver<IOSElement> iOSdriver;
    public ObjectRepositoryUtils objRepo;

    @BeforeSuite
    public void setupAppium(){
        utils.Instanciador_iOS();
        url = Utils.GetUrl();
        capabilities = Utils.GetCapabilities();
        objRepo = Utils.GetObjRepo();
        iOSdriver = Utils.GetiOSdriver();
    }

    @AfterSuite
    public void uninstallApp(){
        System.out.println(iOSdriver.getCapabilities());
        iOSdriver.removeApp("myTestApp");
    }

    /**
     * iOS-AL0001 - Acceso a Alerts
     */
    @Test (description = "iOS-AL0001 - Acceso a Alerts", enabled = true)
    public void iOS_AL0001() throws Exception {
        System.out.println(iOSdriver.getCapabilities());
        iOSdriver.findElementByName("Alerts").click();
        Allure.addAttachment("captura", new ByteArrayInputStream(((TakesScreenshot) iOSdriver).getScreenshotAs(OutputType.BYTES)));
        iOSdriver.navigate().back();
    }

    /**
     * iOS-AL0002 - Generación de alerta y aceptar
     */
    @Test(description = "iOS-AL0002 - Generacion de alerta y aceptar", enabled = true)
    public void iOS_AL0002(){
        iOSdriver.findElementByName("Alerts").click();
        iOSdriver.findElementByName("Create App Alert").click();
        Allure.addAttachment("captura", new ByteArrayInputStream(((TakesScreenshot) iOSdriver).getScreenshotAs(OutputType.BYTES)));
        iOSdriver.findElementByName("Will do").click();
        iOSdriver.navigate().back();
    }

    /**
     * iOS-AT0002 - Campos de texto en Attributes
     */
    @Test (description = "iOS-AT0002 - Campos de texto en Attributes", enabled=true)
    public void iOS_AT0002(){
        // Paso 1 - Pulsar en Atributtes
        iOSdriver.findElementByName("Attributes").click();

        // Paso 2 - Escribir "HELLO" en el primer campo de texto estático
        iOSdriver.findElementByXPath("//XCUIElementTypeTextField[1]").clear();
        iOSdriver.findElementByXPath("//XCUIElementTypeTextField[1]").sendKeys("HELLO");
        String campo1 = iOSdriver.findElementByXPath("//XCUIElementTypeTextField[1]").getText();


        // Paso 3 - Escribir "WORLD" en el segundo campo de texto
        iOSdriver.findElementByName("aIdentifier").click();
        iOSdriver.findElementByName("aIdentifier").sendKeys("WORLD");
        String campo2 = iOSdriver.findElementByName("aIdentifier").getText();

        // Paso 4 - Escribir los valores del campo 1 y 2 en el text area
        iOSdriver.findElementByXPath("//XCUIElementTypeTextView").clear();
        iOSdriver.findElementByXPath("//XCUIElementTypeTextView").sendKeys(campo1 + " " + campo2);

        // Paso 5 - verificar estado del switch, pulsar y volver a verificar
        Assert.assertEquals(iOSdriver.findElementByXPath("//XCUIElementTypeSwitch").getAttribute("value"), "1");
        iOSdriver.findElementByXPath("//XCUIElementTypeSwitch").click();
        Assert.assertEquals(iOSdriver.findElementByXPath("//XCUIElementTypeSwitch").getAttribute("value"), "0");
        Allure.addAttachment("captura", new ByteArrayInputStream(((TakesScreenshot) iOSdriver).getScreenshotAs(OutputType.BYTES)));

        iOSdriver.navigate().back();
    }
}