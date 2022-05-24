package qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LabelsTest {
    public static final String REPO = "junforpeace/HW7_AllureReports";

    @Test
    @Owner("oksana_oksana")
    @DisplayName("Хороший тест")
    @Severity(SeverityLevel.MINOR)
    @Feature("Задачи в репо")
    @Story("Работа с задачами репо")
    @Link(value = "Тестинг", url = "https://github.com")

    public void testAnnotated() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу github.com", () -> {
            open("https://github.com");
        });

        step("Ищем в поиске репозиторий " + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
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

