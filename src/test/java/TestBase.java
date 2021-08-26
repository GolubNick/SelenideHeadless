import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;
import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Listeners(SoftAsserts.class)
public class TestBase {

    @BeforeClass
    public void init() {
        if (System.getenv("assertionMode").equals("SOFT")) {
            Configuration.assertionMode = SOFT;
        }
        Configuration.headless = Boolean.parseBoolean(System.getenv("headless"));
    }

    @BeforeMethod
    public void before() {
        addListener("AllureCustomListener", new AllureCustomListener());
        open(System.getenv("baseUrl"));
    }

    @AfterMethod
    public void tearDownMethod() {
        Selenide.closeWebDriver();
    }

    @AfterTest
    public void tearDownTest() {
        Selenide.closeWebDriver();
    }
}
