package Conditions;

import Actions.CommonActions;
import Utilities.Utils;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utilities.Utils.androidDriver;

public class QuirofanosConditions {

    public WebDriverWait wait;
    public CommonActions commonActions;
    public CommonConditions commonConditions;
    Utils utils;

    public QuirofanosConditions(){
        utils = new Utils();
        wait = new WebDriverWait(androidDriver, 120);
        commonActions = Utils.GetCommonActions();
        commonConditions = Utils.GetCommonConditions();

    }

}
