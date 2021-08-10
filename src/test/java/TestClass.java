import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestClass {
    private final String ORACLE_URL = "https://www.oracle.com";
    private final String CONTACT_SALES = "//*[@data-lbl='contact-sales']";

    @BeforeClass
    public void init() {
        Configuration.headless = true;
        SelenideLogger.addListener("AllureCustomListener", new AllureCustomListener());
    }


    @Test
    public void FirstTest() {

        step("Open www.oracle.com", () -> {
            open(ORACLE_URL);
//            Assert.assertTrue($(By.xpath(CONTACT_SALES)).isDisplayed(), "Tha main page is opened");
            $(By.xpath(CONTACT_SALES)).shouldBe(Condition.visible);
        });
    }
}
