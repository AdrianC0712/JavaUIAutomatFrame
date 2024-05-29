package org.opencart;

import org.opencart.managers.DriverManager;
import org.opencart.managers.FakeDataManager;
import org.opencart.pageobjects.AccountPage;
import org.opencart.pageobjects.HomePage;
import org.opencart.pageobjects.LoginPage;
import org.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRunner_3 {
    public static void main (String[] agrs) throws InterruptedException{
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickOnContinueButton();
        String randomEmail = FakeDataManager.getRandomEmail();
        Thread.sleep(2000);

        registerPage.completeTheRegisterForm("Adrian", "Cirlig", randomEmail,"password1234!");
        Thread.sleep(2000);

        registerPage.enablePrivacyToggle();
        Thread.sleep(2000);

        registerPage.clickOnContinueButton();
        Thread.sleep(2000);

        WebElement clickContinue = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        clickContinue.click();
        Thread.sleep(2000);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.navigateToDropDown();
        accountPage.clickOnLogOutButton();
        Thread.sleep(2000);

        homePage.navigateToLoginPage();
        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeTheLoginForm(randomEmail, "password1234!");
        loginPage.clickOnContinueButton();
        Thread.sleep(2000);

//        driver.quit();
//        System.out.println("The test is finished and the driver is closed");
    }
}
