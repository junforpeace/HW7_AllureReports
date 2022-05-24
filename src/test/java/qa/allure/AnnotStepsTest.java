package qa.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotStepsTest {

    public static final String REPO = "junforpeace/HW7_AllureReports";


    @Test
    public void testGithubIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebStepsTest steps = new WebStepsTest();
        steps.openMainPage();
        steps.searchRepo(REPO);
        steps.clickOnRepositoryLink(REPO);
        steps.shouldSeeSomeIssue();
        steps.attachScreen();


    }

}