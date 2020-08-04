package smorodina;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/stories/signUp",
        glue = {"smorodina.steps", "smorodina.hooks"})
public class AcceptanceTest {
}
