import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGCustomListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failure Status is " + result.getStatus());
    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Status is " + result.getStatus());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Status is " + result.getStatus());
    }
}
