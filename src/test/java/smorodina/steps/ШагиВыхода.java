package smorodina.steps;

import com.codeborne.selenide.SelenideElement;
import net.thucydides.core.annotations.Steps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jbehave.core.annotations.Then;
import smorodina.pages.МОкноВыхода;

public class ШагиВыхода {

    private Logger log = LogManager.getLogger(ШагиВыхода.class);

    @Steps
    МОкноВыхода МОкноВыхода;


    @Then("check value in Login field is: \"$login\"")
    public void checkLoginField(SelenideElement element, String login) {

    }

    @Then("accept exit")
    public void acceptExit() {
        МОкноВыхода.pressQuitButtonPopUp();
    }
}
