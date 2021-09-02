import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.TestConfig;
import org.apache.commons.text.StringSubstitutor;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Listeners(SoftAsserts.class)
public class TestBase {

    private static final TestConfig config = loadTestConfig("config.yaml", TestConfig.class);
    private final String BASE_URL = config.selenideConfig.baseUrl;

    @BeforeClass
    public void init() {
        configureSelenide();
    }

    private static void configureSelenide() {
        Configuration.assertionMode = config.selenideConfig.assertionMode;
        Configuration.headless = config.selenideConfig.headless;
        Configuration.remote = config.selenideConfig.remote;
    }

    private static TestConfig loadTestConfig(String yaml, Class<TestConfig> configClass) {
        TestConfig config = null;
        try {
            String templateYaml = Files.readString(Path.of(yaml));
            Map<String, String> envs = System.getenv();
            StringSubstitutor sub = new StringSubstitutor(envs);
            String resolvedYaml = sub.replace(templateYaml);
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            config = mapper.readValue(resolvedYaml, configClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

    @BeforeMethod
    public void before() {
        addListener("AllureCustomListener", new AllureCustomListener());
        open(BASE_URL);
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
