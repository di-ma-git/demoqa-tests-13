package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObjectsTest extends TestBase {

    @Test
    void successfulTest() {
        String firstName = "Dima";
        String lastName = "Egorov";
        String email = "dima@gmail.com";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setPhoneNumber("1231231230")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("Maths")
                .setHobbies("Sports")
                .uploadPicture("img/1.png")
                .setAddress("Some street 1")
                .selectState("NCR")
                .selectCity("Delhi")
                .pressSubmit()
                .checkModalWindow("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "dima@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1231231230")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Some street 1")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void successfulDateWithKeysTest() {
        String firstName = "Dima";
        String lastName = "Egorov";
        String email = "dima@gmail.com";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male");

        $("#userNumber").setValue("1231231230");
        registrationFormPage.setDateOfBirthWithKeys("30", "July", "2008");
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

    @Test
    void unsuccessfulTest() {
        String firstName = "Dima";
        String lastName = "Egorov";
        String email = "dima@gmail.com";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male");

        $("#userNumber").setValue("1231231230");
        registrationFormPage.setDateOfBirth("30", "July", "2008");
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


    }
}
