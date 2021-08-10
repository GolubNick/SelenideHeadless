import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestClass {
    private final String ORACLE_URL = "https://www.oracle.com";
    private final String CONTACT_SALES = "//*[@data-lbl='contact-sales']";

    @BeforeClass
    public void init() {
        System.out.println("This is init method");
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

    @AfterClass
    public void tearDown() throws IOException {
        saveScreenshot(WebDriverRunner.getWebDriver());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
