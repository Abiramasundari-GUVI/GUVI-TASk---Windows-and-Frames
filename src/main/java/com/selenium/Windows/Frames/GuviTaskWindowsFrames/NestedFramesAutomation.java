package com.selenium.Windows.Frames.GuviTaskWindowsFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesAutomation {
    public static void main(String[] args) {
        // Set up the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "E:\\ne guvi java\\chrome-win64\\chromedriver.exe");

        // Initialize WebDriver for Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the target URL
            driver.get("http://the-internet.herokuapp.com/nested_frames");

            // Switch to the top frame
            driver.switchTo().frame("frame-top");

            // Verify that there are three frames on the page
            int frameCount = driver.findElements(By.cssSelector("frame")).size();
            if (frameCount == 3) {
                System.out.println("Verified: Three frames are present in the top frame.");
            } else {
                System.out.println("Verification failed: Expected 3 frames, found " + frameCount);
            }

            // Switch to the left frame and verify its text
            driver.switchTo().frame("frame-left");
            String leftText = driver.findElement(By.xpath("/html/body"))
                                    .getText();
            if ("LEFT".equals(leftText)) {
                System.out.println("Verified: Left frame contains the text 'LEFT'.");
            } else {
                System.out.println("Verification failed: Left frame text mismatch. Found: " + leftText);
            }

            // Switch back to the top frame
            driver.switchTo().parentFrame();

            // Switch to the middle frame and verify its text
            driver.switchTo().frame("frame-middle");
            String middleText = driver.findElement(By.id("content")).getText();
            if ("MIDDLE".equals(middleText)) {
                System.out.println("Verified: Middle frame contains the text 'MIDDLE'.");
            } else {
                System.out.println("Verification failed: Middle frame text mismatch. Found: " + middleText);
            }

            // Switch back to the top frame
            driver.switchTo().parentFrame();

            // Switch to the right frame and verify its text
            driver.switchTo().frame("frame-right");
            String rightText = driver.findElement(By.xpath("/html/body"))
                                     .getText();
            if ("RIGHT".equals(rightText)) {
                System.out.println("Verified: Right frame contains the text 'RIGHT'.");
            } else {
                System.out.println("Verification failed: Right frame text mismatch. Found: " + rightText);
            }

            // Switch back to the top frame
            driver.switchTo().parentFrame();

            // Switch to the bottom frame and verify its text
            driver.switchTo().defaultContent();
            driver.switchTo().frame("frame-bottom");
            String bottomText = driver.findElement(By.xpath("/html/body"))
                                       .getText();
            if ("BOTTOM".equals(bottomText)) {
                System.out.println("Verified: Bottom frame contains the text 'BOTTOM'.");
            } else {
                System.out.println("Verification failed: Bottom frame text mismatch. Found: " + bottomText);
            }

            // Switch back to the top frame
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
            System.out.println("Browser Closed");
        }
    }
}
