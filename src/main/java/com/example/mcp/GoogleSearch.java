package com.example.mcp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;

public class GoogleSearch {
    public static void main(String[] args) {
        // Start Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Google
            driver.get("https://www.google.com/");

            // Enter "Rajnikanth" in the search bar and submit
            driver.findElement(By.name("q")).sendKeys("Rajnikanth" + Keys.RETURN);

            // Wait for a moment to see results (optional)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}