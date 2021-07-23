package Conditions;

import Actions.CommonActions;
import Actions.FlujoPrincipalActions;
import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Utilities.Utils.androidDriver;

public class ConsultasConditions {

    public WebDriverWait wait;
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    Utils utils;

    public ConsultasConditions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();

    }

}
