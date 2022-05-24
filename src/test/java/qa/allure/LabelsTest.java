package qa.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("oksana a")
    @DisplayName("Хороший тест")
    @Severity(SeverityLevel.MINOR)
    @Feature("Задачи в репо")
    @Story("Работа с задачами репо")
    @Link(value = "Тестинг", url = "https://github.com")

    public void testAnnotated() {

    }
}
