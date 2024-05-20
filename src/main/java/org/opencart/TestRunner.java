package org.opencart;

import org.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main (String[] args)
    {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://sfs.md");
        //driver.close();

        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://scitl.sfs.md");

        //driver.quit();

        System.out.println("The driver is closed!");

    }
}
