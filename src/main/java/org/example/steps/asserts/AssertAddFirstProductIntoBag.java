package org.example.steps.asserts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertAddFirstProductIntoBag {

    public void assertionFirstProductInBag(String expectedProductName, String actualProductName) {
        assertTrue(expectedProductName.contains(actualProductName));
    }

    public void assertionTextIsCorrect(String expectedText, String actualText) {
        assertEquals(expectedText, actualText);
    }

    public void assertionTextExists(boolean condition) {
        assertTrue(condition);
    }

    public void assertionElementNotExists(boolean condition) {
        assertFalse(condition);
    }

    public void assertionElementExists(boolean condition) {
        assertTrue(condition);
    }
}
