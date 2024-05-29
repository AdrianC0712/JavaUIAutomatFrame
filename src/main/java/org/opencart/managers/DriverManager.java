package org.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverManager {
    private static String webDriverType = "EDGE";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager()
    {
        switch (webDriverType.toUpperCase())
        {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The chrome direver was initiated!");
                break;
            case "OPERA":
                driver = new OperaDriver();
                System.out.println("The chrome direver was initiated!");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The chrome direver was initiated!");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The chrome direver was initiated!");
                break;
            default:
                System.out.println("There is not defined such a driver: " + webDriverType);
        }
    }
    public static DriverManager getInstance()
    {
        if (instance == null)
        {
        instance = new DriverManager();
        }
        return instance;
    }
    public WebDriver getDriver()
    {
        if (driver == null)
        {
            getInstance();
        }
        return driver;
    }

    public void quiteTheDriver()
    {
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("The browser is closed and session is set to null");
    }
}
