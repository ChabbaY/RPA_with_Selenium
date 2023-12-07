import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindYourUnicornName {
    private static final String URL = "https://www.rpasamples.com/findunicornname";
    private static final String NAME_FIELD = "txtName";
    private static final String MONTH_FIELD = "selMonth";
    private static final String SUBMIT_BUTTON = "getNameButton";
    private static final String RESULT_TEXT = "lblUnicornName";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your Name: ");
        String name = scanner.next();
        System.out.print("Your month of birth: ");
        String month = scanner.next();

        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);

        WebElement textbox = driver.findElement(By.id(NAME_FIELD));
        textbox.click();
        textbox.sendKeys(name);

        WebElement dropdown = driver.findElement(By.id(MONTH_FIELD));
        dropdown.click();
        dropdown.sendKeys(month);

        driver.findElement(By.id(SUBMIT_BUTTON)).click();

        WebElement result = driver.findElement(By.id(RESULT_TEXT));
        System.out.println(result.getText());

        driver.close();
    }
}