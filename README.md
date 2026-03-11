# mcp-java-browser

Minimal Java Selenium project for validating local browser startup alongside a VS Code MCP server setup.

## What this project does

- Starts Chrome using Selenium Java.
- Uses Selenium Manager, so you do not need to hardcode `chromedriver.exe`.
- Includes a JUnit browser smoke test.
- Includes a minimal Cucumber browser scenario.
- Includes a workspace MCP config for GitHub Copilot at `.vscode/mcp.json`.

## Prerequisites

- Java 17 or later
- Maven 3.9 or later
- Google Chrome installed
- Node.js with `npx` available
- VS Code with GitHub Copilot and MCP support enabled

## Run the Java browser test

From this folder:

```powershell
mvn compile exec:java
```

The app opens Chrome, navigates to `https://example.com`, waits 5 seconds, and closes the browser.

## Run the JUnit smoke test

```powershell
mvn -Dtest=BrowserSmokeTest test
```

## Run the Cucumber scenario

```powershell
mvn -Dtest=RunCucumberTest test
```

## MCP note

The MCP server does not run your Java code directly. It exposes browser automation tools to Copilot.

If you want Copilot to use MCP in this folder, open `mcp-java-browser` as the workspace root in VS Code so the file `.vscode/mcp.json` is discovered.

## Copilot MCP prompt flow

After opening this folder in VS Code, you can ask Copilot prompts such as:

- `List the available MCP tools in this workspace.`
- `Use the selenium MCP server to open https://example.com in a browser.`
- `Use the selenium MCP server to take a screenshot of the page title area.`

Use the Java entry point or tests when you want to validate your local Selenium setup. Use MCP when you want Copilot to drive the browser directly.
