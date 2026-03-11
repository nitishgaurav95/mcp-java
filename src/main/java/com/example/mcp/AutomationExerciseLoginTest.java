package com.example.mcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AutomationExerciseLoginTest {

    private static final List<String> capturedLocators = new ArrayList<>();

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1. Navigate to https://automationexercise.com/login
            driver.get("https://automationexercise.com/login");
            capturedLocators.add("Navigate to: URL - https://automationexercise.com/login");
            System.out.println("1. Navigated to login page");

            // 2. Enter email Address as 'edamakanti@ficusroot.com'
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-qa='login-email']")));
            emailField.sendKeys("edamakanti@ficusroot.com");
            capturedLocators.add("Email Field: XPath - //input[@data-qa='login-email']");
            System.out.println("2. Entered email");

            // 3. Enter the password as 'Havefun@456'
            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-qa='login-password']")));
            passwordField.sendKeys("Havefun@456");
            capturedLocators.add("Password Field: XPath - //input[@data-qa='login-password']");
            System.out.println("3. Entered password");

            // 4. Click on Login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='login-button']")));
            loginButton.click();
            capturedLocators.add("Login Button: XPath - //button[@data-qa='login-button']");
            System.out.println("4. Clicked login button");

            // 5. Validate that user navigated to the home page and logout link is displayed
            WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]")));
            if (logoutLink.isDisplayed()) {
                capturedLocators.add("Logout Link: XPath - //a[contains(text(),'Logout')]");
                System.out.println("5. Validation passed: Logout link is displayed");
            } else {
                System.out.println("5. Validation failed: Logout link not found");
            }

            // 6. Logout from the application and close the browser
            logoutLink.click();
            capturedLocators.add("Logout Action: XPath - //a[contains(text(),'Logout')]");
            System.out.println("6. Logged out");

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed");

            // Print all captured locators
            System.out.println("\n=== Captured Object Locators ===");
            for (String locator : capturedLocators) {
                System.out.println(locator);
            }
        }
    }
}