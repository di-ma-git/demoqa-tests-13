package guru.qa.docs;

import static utils.RandomUtils.*;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        System.out.println("Random string 10: " + getRandomString(10));
        System.out.println("Random message 100-200: " + getRandomMessage(100, 200));
        System.out.println("Random int 20-30: " + getRandomInt(20, 30));
        System.out.println("Random phone: " + getRandomPhone());
        System.out.println("Random email: " + getRandomEmail());
    }
}
