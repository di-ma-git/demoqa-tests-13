package guru.qa.tests;

import com.github.javafaker.Faker;
import utils.RandomData;

import java.util.Locale;

import static utils.RandomData.getRandomMonth;
import static utils.RandomUtils.getRandomInt;

public class TestData {

//    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    String firstName = fakerRu.address().firstName();
    String lastName = fakerRu.address().lastName();
    String email = fakerEn.internet().emailAddress();
    String gender = RandomData.getRandomGender();
    String phone = String.valueOf(fakerRu.number().randomNumber(10, true));
    String dayOfBirth = String.valueOf(getRandomInt(10, 28));
    String monthOfBirth = getRandomMonth();
    String yearOfBirth = String.valueOf(fakerEn.number().numberBetween(1900, 2100));
    String subject = RandomData.getRandomSubjects();
    String hobbies = RandomData.getRandomHobbies();
    String uploadFile = "img/1.png";
    String currentAddress = fakerRu.address().fullAddress();
    String state = RandomData.getRandomState();
    String city = RandomData.getRandomCity(RandomData.getRandomState());
    String modalText = "Thanks for submitting the form";

}
