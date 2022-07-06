package tests;

import org.junit.jupiter.api.*;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("== Something before All tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("==== Something before Every tests");
    }

    @Test
    void firstTest() {
        System.out.println("======= Started firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("======= Started secondTest");
    }

    @AfterEach
    void afterEach() {
        System.out.println("==== Something after Every tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("== Something after All tests");
    }
}