package smorodina.steps;

import io.cucumber.java.en.When;
import smorodina.pages.ОкноТехПоддержки;

public class ШагиТехПоддержки {
    ОкноТехПоддержки page = new ОкноТехПоддержки();

    @When("и прикрепить файлы для тех-поддержки с именем {string}")
    public void addFile(String fileName){
        page.addFileForSupport(fileName);
    }
}
