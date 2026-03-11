package com.example.mcp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserSteps {

    @Given("I open the example page")
    public void iOpenTheExamplePage() {
        CucumberHooks.getDriver().get("https://example.com");
    }

    @Then("the page title should mention Example Domain")
    public void thePageTitleShouldMentionExampleDomain() {
        String title = CucumberHooks.getDriver().getTitle();
        assertTrue(title.contains("Example Domain"));
    }
}
