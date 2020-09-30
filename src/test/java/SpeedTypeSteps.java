import com.codeborne.selenide.Configuration;
import io.cucumber.java8.En;
import org.assertj.core.api.Assertions;
import org.example.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpeedTypeSteps implements En {

    private HomePage homePage;

    public SpeedTypeSteps() {

        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;


        Given("User opens page", () -> {
            open("https://www.speedtypingonline.com/typing-test");
        });

        Given("User clicks on textarea", () -> {
            homePage = new HomePage();
            homePage.clickTextArea();
        });

        When("User reads text sign by sign", () -> {
            while (homePage.hasNextLetter() && !homePage.isResultDivVisible()) {
                String nextLetter = homePage.getNextLetter();
                System.out.println(nextLetter);
                homePage.inputLetter(nextLetter);
            }
        });

        Then("Text is entered", () -> {
            Assertions.assertThat(homePage.getSpeed() > 200).isTrue();
            assertThat(homePage.getAccuracy()).isEqualTo(100);
        });
    }
}
