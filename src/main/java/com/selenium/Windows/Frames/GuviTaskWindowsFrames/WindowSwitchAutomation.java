package com.selenium.Windows.Frames.GuviTaskWindowsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class WindowSwitchAutomation {
    public static void main(String[] args) {
        // Set up the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "E:\\ne guvi java\\chrome-win64\\chromedriver.exe");

        // Initialize WebDriver for Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the target URL
            driver.get("https://the-internet.herokuapp.com/windows");

            // Store the original window handle
            String originalWindow = driver.getWindowHandle();

            // Click the "Click Here" button to open a new window
            WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
            clickHereButton.click();

            // Wait for the new window and switch to it
            Set<String> allWindows = driver.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Verify that the text "New Window" is present on the page
            WebElement newWindowText = driver.findElement(By.tagName("h3"));
            if (newWindowText.getText().equals("New Window")) {
                System.out.println("New window verification successful: 'New Window' text is present.");
            } else {
                System.out.println("New window verification failed.");
            }

            // Close the new window
            driver.close();

            // Switch back to the original window
            driver.switchTo().window(originalWindow);

            // Verify that the original window is active
            if (driver.getTitle().contains("The Internet")) {
                System.out.println("Original window verification successful.");
            } else {
                System.out.println("Original window verification failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
}
