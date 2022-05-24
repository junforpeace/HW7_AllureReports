package qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {

    public static final String REPO = "junforpeace/HW7_AllureReports";


    @Test
    public void testGithubIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу github.com", () -> {
                    open("https://github.com");
                });

        step("Ищем в поиске репозиторий " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPO);
            $(".header-search-input").submit();
        });

        step("Переходим в пункт меню issue", () -> {
            $(linkText(REPO)).click();
            $(partialLinkText("Issues")).click();
        });
        step("Находим Issue", () -> {
            $("#issues-tab").should(Condition.visible);
            Allure.getLifecycle().addAttachment(
                    "PageSource",
                    "text/html",
                    ".html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        });


    }
}
