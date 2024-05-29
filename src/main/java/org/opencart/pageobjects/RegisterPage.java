package org.opencart.pageobjects;

import org.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;

    @FindBy(css = "input[value='1'][name='agree']")
    private WebElement privacyToggleBar;
    @FindBy(css = "button[type='submit']")
    private WebElement continueButton;

    public void completeTheRegisterForm(String firstName, String lastName, String email, String password)
    {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        System.out.println("The form was populated for user " + email + " width password " + password);
    }
    public void enablePrivacyToggle()
    {
        ScrollManager.scrollToElement(privacyToggleBar);
        privacyToggleBar.click();
        System.out.println("The Privacy Rules are accepted");
    }
    public void clickOnContinueButton()
    {
        ScrollManager.scrollToElement(continueButton);
        continueButton.click();
        System.out.println("The continue button is clicked");
    }
}
