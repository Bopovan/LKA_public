package smorodina.steps;

import cucumber.api.java.en.Given;
import smorodina.pages.ОкноАвторизации;

public class ШагиАвторизации {
    ОкноАвторизации окноАвторизации = new ОкноАвторизации();

    @Given("Открыть тестовый стенд")
    public void openPage() {
        окноАвторизации.openStartPage();
    }

    @Given("авторизоваться под Тестовым пользователем с логином {string} и паролем {string}")
    public void avtologIn(String login, String password) {
        окноАвторизации.enterWithTestUserAcc(login, password);
    }
}
