Feature: Browser smoke test

  Scenario: Open the example page in Chrome
    Given I open the example page
    Then the page title should mention Example Domain
