package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class RandomData {

    public static String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        Random random = new Random();
        String randomGender = gender[random.nextInt(gender.length)];
        return randomGender;
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        Random random = new Random();
        String randomMonths = month[random.nextInt(month.length)];
        return randomMonths;
    }
    public static String getRandomSubjects() {
        String[] gender = {"Maths", "Economics", "English", "Biology", "Physics",
                "Chemistry", "Computer Science", "Accounting", "History"};
        Random random = new Random();
        String randomGender = gender[random.nextInt(gender.length)];
        return randomGender;
    }

    public static String getRandomHobbies() {
        String[] gender = {"Sports", "Reading", "Music"};
        Random random = new Random();
        String randomGender = gender[random.nextInt(gender.length)];
        return randomGender;
    }

    public  static String getRandomState() {
        Random generatorState = new Random();
        String[] stateArray = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int randomIndexState = generatorState.nextInt(stateArray.length);

        return stateArray[randomIndexState];
    }

    public static String getRandomCity(String state) {
        Random generatorState = new Random();
        String resultCity = getRandomState();
        int randomIndexCity;
        if (state == "NCR") {
            String[] cityArrayNCR = {"Delhi", "Gurgaon", "Noida"};
            randomIndexCity = generatorState.nextInt(cityArrayNCR.length);
            return cityArrayNCR[randomIndexCity];
        } else if (state == "Uttar Pradesh") {
            String[] cityArrayUttar = {"Agra", "Lucknow", "Merrut"};
            randomIndexCity = generatorState.nextInt(cityArrayUttar.length);
            return cityArrayUttar[randomIndexCity];
        } else if (state == "Haryana") {
            String[] cityArrayHaryana = {"Karnal", "Panipat"};
            randomIndexCity = generatorState.nextInt(cityArrayHaryana.length);
            return cityArrayHaryana[randomIndexCity];
        } else {
            String[] cityArrayRajasthan = {"Jaipur", "Jaiselmer"};
            randomIndexCity = generatorState.nextInt(cityArrayRajasthan.length);
            return cityArrayRajasthan[randomIndexCity];
        }
    }

}
