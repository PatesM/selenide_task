package unit;

import static org.example.configurations.Driver.configureWebDriver;
import static org.example.configurations.Properties.SEARCH_VALUE;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.example.flows.AddFirstProductIntoBagFlow.addToBagButtonXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.bagButtonXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.firstProductXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.productNameInBagXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.productNameXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.searchButtonId;
import static org.example.flows.AddFirstProductIntoBagFlow.searchInputId;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.example.steps.asserts.AssertAddFirstProductIntoBag;
import org.example.steps.selenium_steps.SeleniumMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddFirstProductIntoBag {

    private final AssertAddFirstProductIntoBag assertAddFirstProductIntoBag = new AssertAddFirstProductIntoBag();
    private final SeleniumMethods seleniumMethods = new SeleniumMethods();

    @BeforeEach
    void setUp() {
        configureWebDriver();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Adding the first product into the bag")
    @Description("Should save the first product into the bag")
    public void addingFirstProductIntoBag() {
        seleniumMethods.openPage(WB_MAIN_PAGE_URL);

        SelenideElement input = seleniumMethods.findElement(searchInputId);
        seleniumMethods.searchItem(input, SEARCH_VALUE);

        SelenideElement searchButton = seleniumMethods.findElement(searchButtonId);
        seleniumMethods.clickElement(searchButton);

        SelenideElement firstProduct = seleniumMethods.findElementByXpath(firstProductXpath);
        seleniumMethods.clickElement(firstProduct);

        SelenideElement addToBagButton = seleniumMethods.findElementByXpath(addToBagButtonXpath);
        seleniumMethods.clickElement(addToBagButton);

        SelenideElement firstProductName = seleniumMethods.findElementByXpath(productNameXpath);
        String firstProductNameText = seleniumMethods.getText(firstProductName);

        SelenideElement bagButton = seleniumMethods.findElementByXpath(bagButtonXpath);
        seleniumMethods.clickElement(bagButton);

        SelenideElement firstProductNameInBag = seleniumMethods.findElementByXpath(
            productNameInBagXpath);
        String firstProductNameInBagText = seleniumMethods.getText(firstProductNameInBag);

        assertAddFirstProductIntoBag.assertionFirstProductInBag(firstProductNameText,
            firstProductNameInBagText);
    }
}
