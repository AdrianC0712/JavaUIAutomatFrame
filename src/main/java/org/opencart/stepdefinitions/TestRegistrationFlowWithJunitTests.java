package org.opencart.stepdefinitions;

import org.junit.jupiter.api.*;
import org.opencart.managers.DriverManager;
import org.opencart.managers.FakeDataManager;
import org.opencart.pageobjects.HomePage;
import org.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunitTests {
    static WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void beforeAll() {System.out.println("The execution starts!");}

    @BeforeEach
    public void beforeEach(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }
    @Test
    @DisplayName("The registration af a new user with valid data  is succesful!")
    public void registerUserWithValidData() throws InterruptedException{
        driver = DriverManager.getInstance().getDriver();
        homePage.navigateToLoginPage();

        String firstName = FakeDataManager.getRandomName();
        String lastName = FakeDataManager.getRandomName();
        String randomEmail = FakeDataManager.getRandomEmail("Adrian","@gmail.com");
        String password = FakeDataManager.getRandomPassword(21,22);

        registerPage.completeTheRegisterForm(firstName,lastName,randomEmail,password);
        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        Thread.sleep(500);
        boolean urlContainsSuccessKeyWord = driver.getCurrentUrl().contains("Success");
        Assertions.assertTrue(urlContainsSuccessKeyWord, "The URL contains success within it");
    }

    @Test
    @DisplayName("User remains on Register Page when he/she uses invalid password for register flow")
    public void registerUserWithInvalidPasswordData()throws InterruptedException{
        driver = DriverManager.getInstance().getDriver();
        homePage.navigateToRegisterPage();

        String firstName = FakeDataManager.getRandomName();
        String lastName = FakeDataManager.getRandomName();
        String randomEmail = FakeDataManager.getRandomEmail("Adrian","@gmail.com");
        String password = FakeDataManager.getRandomPassword(21,22);

        registerPage.completeTheRegisterForm(firstName,lastName,randomEmail,password);
        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        Thread.sleep(500);
        boolean urlContainsSuccessKeyWord = driver.getCurrentUrl().contains("Success");
        Assertions.assertFalse(urlContainsSuccessKeyWord, "The URL contains success within it");
    }

    @AfterEach
    public void afterEachTestExecution(){
        DriverManager.getInstance().quiteTheDriver();
        System.out.println("The test case is terminated");
    }

    @AfterAll
    public static void afterExecution(){System.out.println("The execute is terminated");}
}
