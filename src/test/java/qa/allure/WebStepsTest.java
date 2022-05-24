package qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebStepsTest {

    @Step("Открываем страницу github.com")
    public void openMainPage() {
        open("https://github.com");

    }
    @Step("Ищем в поиске репозиторий {repo}")
    public void searchRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();

    }
    @Step("Переходим по ссылке репозитория {repo}")

    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();

    }
    @Step("Открываем вкладку issue")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();

    }
    @Step("Проверяем, что есть Issue под номером {number}")
    public void shouldSeeSomeIssue(int number) {
        $(withText("#" + number)).should(Condition.visible);

    }
    @Attachment(value = "My screen", type = "image/png", fileExtension =".png")
    public byte[] attachScreen() {
        return((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
