package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class HwTestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // Name
        $("#firstName").setValue("Dima");
        $("#lastName").setValue("Maltsev");
        // Email
        $("#userEmail").setValue("dimamaltsev@gmail.com");
        // Gender
        $(By.name("Male")).click();
        // Mobile
        $("#userNumber").setValue("9229612908");
        // Date of Birth
        $("#dateOfBirthInput").setValue("05 Feb 1999");
        // Subjects
        //$.click()
        $("#subjectsInput").setValue("Arts");
        // Hobbies

        // Picture
        //$("#uploadPicture").uploadFile("/Screenshot.png");
        //$("#uploadPicture").u
        // Current Address
        $("#currentAddress").setValue("Centralnaya Street");

        // State and City
        $("#state").click();
        $(byText("Uttah Pradesh")).click();
        //$x("//div[text()='Uttah Pradesh']").click();
        $("#city").click();
        $(byText("Lucknow")).click();
        //$x("//div[text()='Lucknow']").click();

        $("#submit").click();


        $(".modal-content .table-responsive").shouldHave(
                text("Dima"),
                text("Maltsev"),
                text("dimamaltsev@gmail.com"),
                text("9229612908"),
                text("Male"),
                text("05 Feb 1999"),
                text("Arts"),
                text("Sport"),
                text("Reading"),
//                text("Screenshot.png"),
                text("Centralnaya Street"),
                text("Uttah Pradesh"),
                text("Lucknow")

        );
    }
}
