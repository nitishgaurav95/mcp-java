package com.example.mcp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BrowserSmokeTest {

    @Test
    void opensExampleDotCom() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://example.com");
            assertTrue(driver.getTitle().contains("Example Domain"));
        } finally {
            driver.quit();
        }
    }
}
