package smorodina;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.ScenarioType;
import smorodina.pages.ОкноАвторизации;

public class Hooks {
    @BeforeScenario
    public void beforeEachScenario() {
        ОкноАвторизации page = new ОкноАвторизации();
        page.enterWithTestUserAcc("9128553333","Qwerty123");
    }

//    @BeforeScenario(uponType=ScenarioType.EXAMPLE)
//    public void beforeEachExampleScenario() {
//        // ...
//    }
//
//    @AfterScenario // equivalent to  @AfterScenario(uponOutcome=AfterScenario.Outcome.ANY)
//    public void afterAnyScenario() {
//        // ...
//    }
//
//    @AfterScenario(uponType= ScenarioType.EXAMPLE)
//    public void afterEachExampleScenario() {
//        // ...
//    }
//
//    @AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
//    public void afterSuccessfulScenario() {
//        // ...
//    }
//
//    @AfterScenario(uponOutcome= AfterScenario.Outcome.FAILURE)
//    public void afterFailedScenario() {
//        // ...
//    }
}
