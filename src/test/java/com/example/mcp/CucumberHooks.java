package com.example.mcp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CucumberHooks {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        DRIVER.set(new ChromeDriver(options));
    }

    @After
    public void tearDown() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}
