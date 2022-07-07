package guru.qa.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class CssXpathExamples {
    void CssXpathExamples() {

        // пример
        // <input type="email" class="inputtext login_from_input_box" name="email" id="email" data-testid="email">

        // если есть специальный атрибут для тетсировщика data-testid="email"
        $("[data-testid=email]").setValue("123");
        // или
        $(by("data-testid", "email")).setValue("123");

        // <input type="email" class="inputtext login_from_input_box" name="email" id="email">
        // варианты елси нет специального атрибута для тетсировщика
        $("[id=email]").setValue("123");
        $("#=email").setValue("123"); // # заменяет id
        $(byId("email")).setValue("123");
        $(By.id("email")).setValue("123");

        // через xPath
        $x("//*[@id='email']")).setValue("123");
        $(byXpath("//*[@id='email']")).setValue("123");

        // <input type="email" class="inputtext login_from_input_box" name="email">
        // если нет id, можно через name
        $("[name=email]").setValue("123");
        $(byName("email")).setValue("123");

        // <input type="email" class="inputtext login_from_input_box">
        // через class
        $("[class*=login_from_input_box]").setValue("123");
        $(".login_from_input_box").setValue("123"); // . является сокращение class
        $(".inputtext.login_from_input_box").setValue("123");
        $("input.inputtext.login_from_input_box").setValue("123");
        $x("//input[@class='login_from_input_box']")).setValue("123");
        $x("//input[@class='inputtext'][@class='login_from_input_box']")).setValue("123");

        // <div class="inputtext">
        //      <input type="email" class="login_from_input_box">
        // </div>
        $(".inputtext .login_from_input_box").setValue("123"); // пробел между искомыми классами

        // <input type="email" class="inputtext login_from_input_box" name="email" id="email" data-testid="email">
        // "супер"локатор
        $("input.inputtext.login_from_input_box#email[name=email][data-testid=email]").setValue("123");

        // <div>Hello qa.guru</div>
        // поиск по тексту через xPath
        $x("//*[text()='Hello qa.guru']"); // посик по тексту по точному совпадению
        $x("//*[contains(text(), 'qa.guru')]"); // содержит слово или часть текста
        $x("//*[text()[contains(.,'ello qa.gur')]]"); // содержит слово или часть текста
        // найти текст средствами selenide
        $(byText("Hello qa.guru"));
        $(withText("ello qa.gur")); // поиск подстроки


    }


}
