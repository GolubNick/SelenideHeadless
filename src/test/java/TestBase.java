import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Listeners(SoftAsserts.class)
public class TestBase {

    private String baseUrl = null;
    private final String MAIN_CONTENT = "//*[@class='gwt-Frame']";
    private final String ACCEPT_ALL = "//*[@class='call']";

    @BeforeClass
    public void init() {
        Properties props = loadPropertiesFile("env.properties");
        baseUrl = props.getProperty("baseUrl");
        boolean isHeadless = Boolean.parseBoolean(props.getProperty("headless"));
        if (props.get("assertionMode").equals("SOFT")) {
            Configuration.assertionMode = SOFT;
        }
        Configuration.headless = isHeadless;
        addListener("AllureCustomListener", new AllureCustomListener());

    }

    @BeforeMethod
    public void before() {
        open(baseUrl);
        if ($(By.xpath((ACCEPT_ALL))).exists()) {
            $(By.xpath((ACCEPT_ALL))).click();
        }
    }

    @AfterMethod
    public void tearDownMethod() {
        Selenide.closeWebDriver();
    }

    @AfterTest
    public void tearDownTest() {
        Selenide.closeWebDriver();
    }

    private Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }
}
