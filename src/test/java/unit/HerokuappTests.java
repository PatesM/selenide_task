package unit;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.example.configurations.Driver.configureWebDriver;
import static org.example.configurations.Properties.HEROKUAPP_URL;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.example.steps.asserts.AssertAddFirstProductIntoBag;
import org.example.steps.selenide_steps.SelenideMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HerokuappTests {

    private final SelenideMethods selenideMethods = new SelenideMethods();
    private final AssertAddFirstProductIntoBag assertions = new AssertAddFirstProductIntoBag();

    @BeforeEach
    void setUp() {
        configureWebDriver();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Нажатие кнопки 'Add element'")
    @Description("Ожидание появления элемента")
    public void test1() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Add/Remove Elements']").shouldBe(visible, interactable).click();
        $x("//div[@class='example']/button").shouldBe(visible).click();
        String deleteButtonText = $x("//div[@class='example']/div[@id='elements']/button").text();
        assertions.assertionTextIsCorrect("Delete", deleteButtonText);
    }

    @Test
    @DisplayName("Проверка наличия текста")
    @Description("Ожидание определенного текста")
    public void test2() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='A/B Testing']").shouldBe(visible, interactable).click();
        $x("//div[@class='example']/h3").shouldHave(text("A/B Test Variation 1"));
        String titleText = $x("//div[@class='example']/h3").text();
        assertions.assertionTextIsCorrect("A/B Test Variation 1", titleText);
    }

    @Test
    @DisplayName("Проверка отсутствия элемента")
    @Description("Ожидание исчезновения элемента")
    public void test3() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Dynamic Controls']").shouldBe(visible, interactable).click();
        $x("//form[@id='checkbox-example']/button").shouldBe(interactable).click();
        $x("//input[@type='checkbox']").should(disappear);
        boolean elementNotExist = $x("//input[@type='checkbox']").exists();
        assertions.assertionElementNotExists(elementNotExist);
    }

    @Test
    @DisplayName("Проверка наличия атрибута")
    @Description("Ожидание атрибута")
    public void test4() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Dropdown']").shouldBe(visible, interactable).click();
        $x("//select[@id='dropdown']").shouldBe(interactable).click();
        $x("//select[@id='dropdown']/option[@value='1']").setSelected(true);
        $x("//select[@id='dropdown']/option[@value='1']").shouldHave(attribute("selected", "true"));
        boolean attributeExists = true;
        assertions.assertionElementExists(attributeExists);
    }

    @Test
    @DisplayName("Проверка наличия значения")
    @Description("Ожидание определенного значения")
    public void test5() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Inputs']").shouldBe(visible, interactable).click();
        $x("//div[@class='example']/input").shouldBe(visible, interactable).sendKeys("123");
        $x("//div[@class='example']/input").shouldHave(value("123"));
        boolean attributeExists = true;
        assertions.assertionElementExists(attributeExists);
    }

    @Test
    @DisplayName("Проверка отсутствия элемента")
    @Description("Ожидание таймаутом")
    public void test6() {
        Configuration.timeout = 10000;
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Dynamic Controls']").shouldBe(visible, interactable).click();
        $x("//form[@id='checkbox-example']/button").shouldBe(interactable).click();
        $x("//input[@type='checkbox']").should(disappear);
        boolean elementNotExist = $x("//input[@type='checkbox']").exists();
        assertions.assertionElementNotExists(elementNotExist);
    }

    @Test
    @DisplayName("Проверка отсутствия элемента")
    @Description("Ожидание со слипом")
    public void test7() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Dynamic Controls']").shouldBe(visible, interactable).click();
        $x("//form[@id='checkbox-example']/button").shouldBe(interactable).click();
        $x("//input[@type='checkbox']").should(disappear);
        Selenide.sleep(10000);
        boolean elementNotExist = $x("//input[@type='checkbox']").exists();
        assertions.assertionElementNotExists(elementNotExist);
    }

    @Test
    @DisplayName("Проверка наличия текста")
    @Description("Ожидание определенного текста")
    public void test8() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Hovers']").shouldBe(visible, interactable).click();
        Selenide.actions().moveToElement($x("//div[@class='figure']")).perform();
        String userName = $x("//div[@class='figure']/div[@class='figcaption'][1]/h5").text();
        assertions.assertionTextIsCorrect("name: user1", userName);
    }

    @Test
    @DisplayName("Проверка наличия значения")
    @Description("Ожидание определенного значения")
    public void test9() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Horizontal Slider']").shouldBe(visible, interactable).click();
        $x("//div[@class='sliderContainer']/input").shouldBe(visible).setValue("2.5");
        $x("//div[@class='sliderContainer']/input").shouldHave(value("2.5"));
        String inputValue = $x("//div[@class='sliderContainer']/input").getValue();
        assertions.assertionTextIsCorrect("2.5", inputValue);
    }

    @Test
    @DisplayName("Нажатие ")
    @Description("Ожидание появления элемента")
    public void test10() {
        selenideMethods.openPage(HEROKUAPP_URL);
        $x("//ul/li/a[text()='Dynamic Loading']").shouldBe(visible, interactable).click();
        $x("//div[@class='example']/a[@href='/dynamic_loading/1']").shouldBe(visible).click();
        $x("//div[@id='start']/button").shouldBe(visible).click();
        $x("//div[@id='finish']").shouldHave(text("Hello World!"));
        String finishText = $x("//div[@id='finish']/h4").text();
        assertions.assertionTextIsCorrect("Hello World!", finishText);
    }
}
