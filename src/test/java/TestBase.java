import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;
import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.AssertionMode.STRICT;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Listeners(SoftAsserts.class)
public class TestBase {

    private final String ACCEPT_ALL = "//*[@class='call']";

    @BeforeClass
    public void init() {
        Object assertionMode = System.getenv("assertionMode");
        if ((assertionMode != null) && assertionMode.equals("SOFT")) {
            Configuration.assertionMode = SOFT;
            System.out.println("Assertion Mode is SOFT");
        } else {
            Configuration.assertionMode = STRICT;
            System.out.println("Assertion Mode is HARD");
        }
        Configuration.headless = Boolean.parseBoolean(System.getenv("headless"));
        System.out.println("Headless Mode is " + Boolean.parseBoolean(System.getenv("headless")));
    }

    @BeforeMethod
    public void before() {
        addListener("AllureCustomListener", new AllureCustomListener());
        System.out.println("BaseUrl is " + System.getenv("baseUrl"));
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
