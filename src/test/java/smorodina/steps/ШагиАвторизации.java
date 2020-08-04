package smorodina.steps;

import io.cucumber.java.en.Given;
import smorodina.pages.ОкноАвторизации;

public class ШагиАвторизации {
    ОкноАвторизации окноАвторизации = new ОкноАвторизации();

    @Given("открыть тестовый стенд")
    public void openPage() {
        окноАвторизации.openStartPage();
    }

    @Given("авторизоваться под Тестовым пользователем с логином {string} и паролем {string}")
    public void avtologIn(String login, String password) {
        окноАвторизации.enterWithTestUserAcc(login, password);
    }


}
