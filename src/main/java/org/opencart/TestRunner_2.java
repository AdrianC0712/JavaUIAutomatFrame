package org.opencart;

import org.opencart.managers.DriverManager;
import org.opencart.managers.FakeDataManager;
import org.opencart.managers.ScrollManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner_2 {
    public static void main (String[] args)
    {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        driver.manage().window().maximize();

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online");
        System.out.println("The current URL is: " + driver.getCurrentUrl());

        WebElement myAccountDropDown = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
        myAccountDropDown.click();
        System.out.println("The current URL is: " + driver.getCurrentUrl());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement registerButton = driver.findElement(By.cssSelector("body > nav:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
        registerButton.click();
        System.out.println("The current URL is: " + driver.getCurrentUrl());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        WebElement firsNameInput = driver.findElement(By.id("input-firstname"));
//        firsNameInput.sendKeys("Adrian");
//        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
//        lastNameInput.sendKeys(("Cirlig"));

        String firstName = FakeDataManager.getRandomName();
        System.out.println("The generate first name is: " +firstName);

        String lastName = FakeDataManager.getRandomName();
        System.out.println("The generate last name is: " +lastName);

        String randomEmail = FakeDataManager.getRandomEmail("ggalbur","@gmail.com");
        System.out.println("The generated email is: " + randomEmail);

        String password = FakeDataManager.getRandomPassword(21,22);
        System.out.println("The generated password is: " + password);

        WebElement firstNameInput =driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(firstName);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement lastNameInput =driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(lastName);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement emailImput = driver.findElement(By.id("input-email"));
        emailImput.sendKeys(randomEmail);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement passwordImput = driver.findElement(By.id("input-password"));
        passwordImput.sendKeys(password);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.scrollToElement( privacyToggle);
        privacyToggle.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButton.click();

        System.out.println(driver.getCurrentUrl());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement clickContinue = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        clickContinue.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement editAccount = driver.findElement(By.cssSelector("body > main:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
        editAccount.click();
        //driver.close();

        //driver.switchTo().window(currentWindowName);

       // driver.get("http://andreisecuqa.host/");
       // driver.quit();
        System.out.println("The execution was finished!");

    }

}
