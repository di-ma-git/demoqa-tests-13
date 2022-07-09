package guru.qa.tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormTest extends TestBase {


    @Test
    void successfulTest() {
        String firstName = "Dima";
        String lastName = "Egorov";
        String email = "dima@gmail.com";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
//        $("#gender-radio-1").parent().click();
//        $("#gender-radio-1").click(); // WRONG
//        $(byText("Male")).click();  // WRONG
//        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1231231230");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();


//<div class="react-datepicker__day react-datepicker__day--030 react-datepicker__day--outside-month" aria-label="Choose Monday, June 30th, 2008">30</div>
//<div class="react-datepicker__day react-datepicker__day--030"                                      aria-label="Choose Wednesday, July 30th, 2008">30</div>



        //$("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));



//        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email),
//                text("Some address 1"), text("Another address 2"));

//        $(".table-responsive").$(byText("Date of Birth")).parent()
//                .shouldHave(text("30 July,2008"));


        checkTable("Date of Birth", "30 July,2008");

    }

    void checkTable(String key, String value) {

        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}



