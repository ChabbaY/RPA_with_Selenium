import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PasswordGenerator {
    private static final String URL = "https://www.rpasamples.com/passwordgenerator";
    private static final String LENGTH_FIELD = "txt-length";
    private static final String UPPER_BOX = "chkUpper";
    private static final String LOWER_BOX = "chkLower";
    private static final String NUMBER_BOX = "chkNumbers";
    private static final String SYMBOL_BOX = "chkSymbols";
    private static final String RESULT = "generated-password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length: ");
        int length = scanner.nextInt();
        System.out.print("Upper Case (y/n): ");
        boolean upper = scanner.next().equals("y");
        System.out.print("Lower Case (y/n): ");
        boolean lower = scanner.next().equals("y");
        System.out.print("Numbers (y/n): ");
        boolean numbers = scanner.next().equals("y");
        System.out.print("Symbols (y/n): ");
        boolean symbols = scanner.next().equals("y");

        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);

        WebElement lengthField = driver.findElement(By.id(LENGTH_FIELD));
        lengthField.clear();
        lengthField.sendKeys(length + "");

        WebElement upperBox = driver.findElement(By.id(UPPER_BOX));
        upperBox.click();
        if (upper) upperBox.click();

        WebElement lowerBox = driver.findElement(By.id(LOWER_BOX));
        if (!lower) lowerBox.click();

        WebElement numbersBox = driver.findElement(By.id(NUMBER_BOX));
        if (!numbers) numbersBox.click();

        WebElement symbolsBox = driver.findElement(By.id(SYMBOL_BOX));
        if (!symbols) symbolsBox.click();

        System.out.println(driver.findElement(By.id(RESULT)).getText());

        driver.close();
    }
}