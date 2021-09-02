import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestClass extends TestBase {

    private final HomePage homePage = new HomePage();

    private final String TITLE = "//*[@class='rwaccent']";
    private final String CLOUD_FREE_TIER_LINK = "//*[@data-lbl='global-nav-products:cloud-free-tier']";
    private final String OCI_CLOUD_COMPUTE = "//*[@data-lbl='o-products-menu-infra/oci-cloud-compute']";

    @Test
    public void testContactSalesButton() {
        step("Verify a Contact sales Button", () -> {
            homePage.contactSales.shouldBe(visible);
            homePage.contactSales.shouldNotBe(visible);
            $(By.xpath("//*[@data-lbl='wrong-xpath']")).shouldNotBe(visible);
            $(By.xpath("//*[@data-lbl='wrong-xpath']")).click();
            homePage.contactSales.shouldBe(visible);
        });
    }

    @Test
    public void testOracleCloudFreeTier() {
        verifyAndClickProductsButton();

        step("Click the 'Oracle Cloud Free Tier' link", () -> {
            $(By.xpath((CLOUD_FREE_TIER_LINK))).click();
            $(By.xpath((TITLE))).shouldHave(text("Oracle Cloud Free Tier"));
        });
    }

    @Test
    public void testCompute() {
        verifyAndClickProductsButton();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((OCI_CLOUD_COMPUTE))).click();
            $(By.xpath((TITLE))).shouldHave(text("Oracle Cloud Infrastructure—Compute"));
        });
    }

    private void verifyAndClickProductsButton() {
        step("Verify a Products Button", () -> {
            homePage.productsButton.shouldBe(visible);
        });

        step("Click a Products Button", () -> {
            homePage.productsButton.click();
            homePage.productsGrid.shouldBe(visible);
        });
    }
}
