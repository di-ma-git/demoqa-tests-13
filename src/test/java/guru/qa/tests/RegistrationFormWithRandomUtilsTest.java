package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class RegistrationFormWithRandomUtilsTest extends TestBase {

    //move to TestData
    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String email = getRandomEmail();

    @Test
    void successfulTest() {


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1231231230");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email),
                text("Some address 1"), text("20 July,2008"));
    }
}