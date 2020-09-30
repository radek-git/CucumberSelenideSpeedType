package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class HomePage {

    public void clickTextArea() {
        $(Selectors.byId("blockDivContainer")).waitUntil(Condition.visible, 3000).click();
    }

    public boolean hasNextLetter() {
        return $(Selectors.byXpath("(//span[@class='nxtLetter'])[2]")).exists();
    }

    public String getNextLetter() {
        return  $(Selectors.byXpath("(//span[@class='nxtLetter'])[2]")).getText();

    }

    public void inputLetter(String letter) {
        actions().sendKeys(letter).build().perform();
    }

    public boolean isResultDivVisible() {
        return $(Selectors.byId("resultDiv")).is(Condition.visible);
    }

    public int getSpeed() {
        return Integer.parseInt($(Selectors.byId("WPM_Result")).getText().replace(" ", ""));
    }

    public double getAccuracy() {
        return Double.parseDouble($(Selectors.byId("Accur_Result")).getText().replace(" ", ""));
    }
}
