package org.example.steps.selenide_steps;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class SelenideMethods {

    public void openPage(String URL) {
        open(URL);
    }

    public SelenideElement findElement(String element) {
        return $(element).shouldBe(visible);
    }

    public SelenideElement findElementByXpath(String elementXpath) {
        return $(By.xpath(elementXpath)).shouldBe(visible);
    }

    public void searchItem(SelenideElement selenideElement, String searchValue) {
        selenideElement.shouldBe(visible, interactable).sendKeys(searchValue);
    }

    public void clickElement(SelenideElement selenideElement) {
        selenideElement.should(visible, interactable).click();
    }

    public String getText(SelenideElement selenideElement) {
        return selenideElement.shouldBe(visible).text();
    }

    public void scrollToElement(String element) {
        findElementByXpath(element).scrollTo().shouldBe(visible);
    }
}
