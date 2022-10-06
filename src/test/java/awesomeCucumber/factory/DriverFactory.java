package awesomeCucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    // Khai bao 1 biến driver đại diện cho Selenium WebDriver
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        // Set chrome driver: giao tiếp giữa browser và code
        System.setProperty("webdriver.chrome.driver", "/Users/tnttuan/ThienCute/Meditation_SelfLearning/chromedriver");
        // Bật trình duyệt lên
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
