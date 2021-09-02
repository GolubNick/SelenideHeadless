package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final String CONTACT_SALES = "//*[@data-lbl='contact-sales']";
    private final String PRODUCTS = "//*[@data-target='products']";
    private final String PRODUCTS_GRID = "//*[@data-type='products']";

    public SelenideElement contactSales = $(By.xpath(CONTACT_SALES));
    public SelenideElement productsButton = $(By.xpath(PRODUCTS));
    public SelenideElement productsGrid = $(By.xpath(PRODUCTS_GRID));
}
