import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.util.ResultsUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class AllureCustomListener implements LogEventListener {

    private boolean saveScreenshots = false;

    private final AllureLifecycle lifecycle;

    public AllureCustomListener() {
        this(Allure.getLifecycle());
    }

    public AllureCustomListener(final AllureLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public AllureCustomListener setSaveScreenshots(boolean saveScreenshots) {
        this.saveScreenshots = saveScreenshots;
        return this;
    }

    public boolean isSaveScreenshotsEnabled() {
        return this.saveScreenshots;
    }


        @Override
    public void afterEvent(final LogEvent event) {
            lifecycle.getCurrentTestCase().ifPresent(uuid -> {
                final String stepUUID = UUID.randomUUID().toString();
                lifecycle.startStep(stepUUID, new StepResult()
                        .setName(event.toString())
                        .setStatus(Status.PASSED));

                lifecycle.updateStep(stepResult -> stepResult.setStart(stepResult.getStart() - event.getDuration()));

                if ((isSaveScreenshotsEnabled() && event.getSubject().contains("should")) || LogEvent.EventStatus.FAIL.equals(event.getStatus())) {
                    lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
                }
                if (LogEvent.EventStatus.FAIL.equals(event.getStatus())) {
                    lifecycle.updateStep(stepResult -> {
                        final StatusDetails details = ResultsUtils.getStatusDetails(event.getError())
                                .orElse(new StatusDetails());
                        stepResult.setStatus(Status.FAILED);
                        stepResult.setStatusDetails(details);
                    });
                }
                lifecycle.stopStep(stepUUID);
            });
    }


    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }


    @Override
    public void beforeEvent(LogEvent logEvent) {

    }
}