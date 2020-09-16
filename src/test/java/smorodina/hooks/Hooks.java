package smorodina.hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import smorodina.pages.БоковаяПанель;
import smorodina.steps.ОбщиеШаги;
import smorodina.steps.ШагиАвторизации;

public class Hooks {
    БоковаяПанель page = new БоковаяПанель();

    //    @Before
//    public void openStartPageBefore() {
////        new ШагиАвторизации().avtologIn("9128553333", "Qwerty123");
//      new ШагиАвторизации().openPage();
//    }
//
    @After
    public void screenShotAfterTest(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) WebDriverRunner.getWebDriver();
        byte[] sourcePath = ts.getScreenshotAs(OutputType.BYTES);
        scenario.embed(sourcePath, "image/png");
        if (page.sideBarIsVisible()) {
            new ОбщиеШаги().exit();
        }

    }
//
//    @AfterStep
//    public void screenShotAfterStep(Scenario scenario) {
//        TakesScreenshot ts = (TakesScreenshot) WebDriverRunner.getWebDriver();
//        byte[] sourcePath = ts.getScreenshotAs(OutputType.BYTES);
//        scenario.embed(sourcePath, "imageStep/jpeg");
//    }
}
