package smorodina.steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import smorodina.pages.МОкноВыхода;

public class ШагиВыхода {

    private Logger log = LogManager.getLogger(ШагиВыхода.class);

    МОкноВыхода МОкноВыхода;


    @Then("check value in Login field is: {string}")
    public void checkLoginField(SelenideElement element, String login) {

    }

    @Then("accept exit")
    public void acceptExit() {
        МОкноВыхода.pressQuitButtonPopUp();
    }
}
