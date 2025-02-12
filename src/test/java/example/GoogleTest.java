package example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GoogleTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // 自动管理 ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals(true, title.contains("Google"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
