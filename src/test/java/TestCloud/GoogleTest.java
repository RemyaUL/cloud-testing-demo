package TestCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {

    @Test
    public void verifyGoogleLogo() {

        ChromeOptions options = new ChromeOptions();

        // Tell Selenium where Chromium is installed
       // options.setBinary("/usr/bin/chromium-browser");

        // Recommended for Linux / CI
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Set ChromeDriver path (important on Ubuntu)
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver = new ChromeDriver(options);
          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com");   // FIXED URL

        WebElement logo = driver.findElement(By.cssSelector("img[alt='Google']")
);

        Assert.assertTrue(logo.isDisplayed(), "Google logo is not displayed");

        driver.quit();
    }
}

