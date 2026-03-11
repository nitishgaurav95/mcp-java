package com.example.mcp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class BrowserLauncher {

    private BrowserLauncher() {
    }

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://example.com");
            System.out.println("Title: " + driver.getTitle());

            // Keep the browser open briefly so startup is visible.
            Thread.sleep(5000);
        } finally {
            driver.quit();
        }
    }
}
