package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemListPage {

    WebDriver driver;
    WebDriverWait wait;

    public ItemListPage(WebDriver driver){
        this.driver = driver;
    }

    private By SearchedPhraseText = By.xpath("//span[@class='_11fdd_1KRNF']");

    public ItemListPage WaitForSearchedPhrase(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement searchedPhrase = driver.findElement(SearchedPhraseText);
        wait.until(ExpectedConditions.visibilityOf(searchedPhrase));
        return new ItemListPage(driver);
    }

}
