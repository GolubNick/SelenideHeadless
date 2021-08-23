import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestClass extends TestBase {

    private final String CONTACT_SALES = "//*[@data-lbl='contact-sales']";
    private final String PRODUCTS = "//*[@data-target='products']";
    private final String PRODUCTS_GRID = "//*[@data-type='products']";
    private final String TITLE = "//*[@class='rwaccent']";

    private final String CLOUD_FREE_TIER_LINK = "//*[@data-lbl='global-nav-products:cloud-free-tier']";
    private final String OCI_CLOUD_COMPUTE = "//*[@data-lbl='o-products-menu-infra/oci-cloud-compute']";
    private final String OCI_CLOUD_STORAGE = "//*[@data-lbl='o-products-menu-infra/oci-cloud-storage']";
    private final String NETWORKING = "//*[@data-lbl='o-products-menu-infra/oci-cloud-networking']";
    private final String ANALYTICS = "//*[@data-lbl='o-products-menu-infra/oci-bus-analyt']";
    private final String APPLICATION_DEVELOPMENT = "//*[@data-lbl='o-products-menu-infra/oci-app-dev']";
    private final String CLOUD_DATABASE_SERVICES = "//*[@data-lbl='o-products-menu-infra/oci-database']";
    private final String CONTENT_MANAGEMENT = "//*[@data-lbl='o-products-menu-infra/oci-mktg-cloud-prods-cont-exp']";
    private final String INTEGRATION = "//*[@data-lbl='o-products-menu-infra/oci-mware-data-int']";
    private final String OBSERVABILITY_MANAGEMENT = "//*[@data-lbl='o-products-menu-infra/oci-cloud-sys-mgt-cloud-svces']";
    private final String SECURITY_IDENTITY_COMPLIANCE = "//*[@data-lbl='o-products-menu-infra/oci-cloud-security']";
    private final String CLOUD_MARKETPLACE = "//*[@id='pt1:listResults:ociProductCategories:ot1ddd']";
    private final String CLOUD_CUSTOMER = "//*[@data-lbl='o-products-menu-infra/oci-eng-sys-exadata-cloud@cust']";

    private final String CLOUD_FREE_TIER_LINK_LABEL = "Oracle Cloud Free Tier";
    private final String OCI_CLOUD_COMPUTE_LABEL = "Oracle Cloud Infrastructure—Compute";
    private final String OCI_CLOUD_STORAGE_LABEL = "Oracle Cloud Infrastructure—Cloud Storage";
    private final String NETWORKING_LABEL = "Oracle Cloud Infrastructure—Networking and Connectivity";
    private final String ANALYTICS_LABEL = "Analytics";
    private final String APPLICATION_DEVELOPMENT_LABEL = "Oracle Application Development";
    private final String CLOUD_DATABASE_SERVICES_LABEL = "Oracle Database";
    private final String CONTENT_MANAGEMENT_LABEL = "Oracle Content Management Cloud Service";
    private final String INTEGRATION_LABEL = "Oracle Integration and Migration";
    private final String OBSERVABILITY_MANAGEMENT_LABEL = "Oracle Cloud Observability and Management Platform";
    private final String SECURITY_IDENTITY_COMPLIANCE_LABEL = "Security, Identity, and Compliance";
    private final String CLOUD_MARKETPLACE_LABEL = "Oracle Cloud Infrastructure App Categories";
    private final String CLOUD_CUSTOMER_LABEL = "Oracle Cloud@Customer";

    @Test
    public void testContactSalesButton() {
        step("Verify a Contact sales Button", () -> {
            $(By.xpath(CONTACT_SALES)).shouldBe(visible);
            $(By.xpath(CONTACT_SALES)).shouldNotBe(visible);
            $(By.xpath("//*[@data-lbl='contact-salesss']")).shouldNotBe(visible);
            $(By.xpath("//*[@data-lbl='contact-salesss']")).click();
            $(By.xpath(CONTACT_SALES)).shouldBe(visible);
        });
    }

    @Test
    public void testOracleCloudFreeTier() {
        workflow();

        step("Click the 'Oracle Cloud Free Tier' link", () -> {
            $(By.xpath((CLOUD_FREE_TIER_LINK))).click();
            $(By.xpath((TITLE))).shouldHave(text(CLOUD_FREE_TIER_LINK_LABEL));
        });
    }

    @Test
    public void testCompute() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((OCI_CLOUD_COMPUTE))).click();
            $(By.xpath((TITLE))).shouldHave(text(OCI_CLOUD_COMPUTE_LABEL));
        });
    }

    @Test
    public void testCloudStorage() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((OCI_CLOUD_STORAGE))).click();
            $(By.xpath((TITLE))).shouldHave(text(OCI_CLOUD_STORAGE_LABEL));
        });
    }

    @Test
    public void testAnalytics() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((ANALYTICS))).click();
            $(By.xpath((TITLE))).shouldHave(text(ANALYTICS_LABEL));
        });
    }

    @Test
    public void testNetworking() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((NETWORKING))).click();
            $(By.xpath((TITLE))).shouldHave(text(NETWORKING_LABEL));
        });
    }

    @Test
    public void testApplicationDevelopment() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((APPLICATION_DEVELOPMENT))).click();
            $(By.xpath((TITLE))).shouldHave(text(APPLICATION_DEVELOPMENT_LABEL));
        });
    }

    @Test
    public void testCloudDatabaseServices() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((CLOUD_DATABASE_SERVICES))).click();
            $(By.xpath((TITLE))).shouldHave(text("1"+CLOUD_DATABASE_SERVICES_LABEL));
            $(By.xpath((TITLE))).shouldHave(text(CLOUD_DATABASE_SERVICES_LABEL));
        });
    }

    @Test
    public void testContentManagement() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((CONTENT_MANAGEMENT))).click();
            $(By.xpath((TITLE))).shouldHave(text(CONTENT_MANAGEMENT_LABEL));
        });
    }

    @Test
    public void testIntegration() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((INTEGRATION))).click();
            $(By.xpath((TITLE))).shouldHave(text(INTEGRATION_LABEL));
        });
    }

    @Test
    public void testObservabilityManagement() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((OBSERVABILITY_MANAGEMENT))).click();
            $(By.xpath((TITLE))).shouldHave(text(OBSERVABILITY_MANAGEMENT_LABEL));
        });
    }

    @Test
    public void testSecurityIdentityCompliance() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((SECURITY_IDENTITY_COMPLIANCE))).click();
            $(By.xpath((TITLE))).shouldHave(text(SECURITY_IDENTITY_COMPLIANCE_LABEL));
        });
    }

    @Test
    public void testCloudMarketplace() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((CLOUD_MARKETPLACE))).click();
            $(By.xpath((TITLE))).shouldHave(text(CLOUD_MARKETPLACE_LABEL));
        });
    }

    @Test
    public void testCloudCustomer() {
        workflow();

        step("Click the 'Compute' link", () -> {
            $(By.xpath((CLOUD_CUSTOMER))).click();
            $(By.xpath((TITLE))).shouldHave(text(CLOUD_CUSTOMER_LABEL));
        });
    }



    private void workflow() {
        step("Verify a Products Button", () -> {
            $(By.xpath(PRODUCTS)).shouldBe(visible);
        });

        step("Click a Products Button", () -> {
            $(By.xpath(PRODUCTS)).click();
            $(By.xpath(PRODUCTS_GRID)).shouldBe(visible);
        });
    }
}
