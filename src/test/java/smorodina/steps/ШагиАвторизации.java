package smorodina.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import smorodina.pages.ОкноАвторизации;

public class ШагиАвторизации {
    @Steps
    ОкноАвторизации окноАвторизации;

    @Given("Открыть тестовый стенд")
    public void openPage() {
        окноАвторизации.openStartPage();
    }

    @Given("авторизоваться под Тестовым пользователем с логином $логин и паролем $пароль")
    @When("авторизоваться под Тестовым пользователем с логином $логин и паролем $пароль")
    public void avtologIn(String login, String password) {
        окноАвторизации.enterWithTestUserAcc(login, password);
    }
}
