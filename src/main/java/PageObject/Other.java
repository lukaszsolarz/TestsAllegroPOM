package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Other {

    WebDriver driver;
    WebDriverWait wait;

    public Other(WebDriver driver){
        this.driver = driver;
    }

    private By dateRoleAccept = By.xpath("//button[@data-role='accept-consent']");

    public Other AcceptRole(){
    WebElement acceptRole = driver.findElement(dateRoleAccept);
    WebDriverWait wait = new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.visibilityOf(acceptRole));
    acceptRole.click();
        return new Other(driver);
    }

}
