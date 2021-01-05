package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    WebDriver driver;
    WebDriverWait wait;

    public Header (WebDriver driver){
        this.driver = driver;
    }

    private By SearchEngineInput = By.xpath("//input[@placeholder='czego szukasz?']");
    private By SearchButton = By.xpath("//button[text()='szukaj']");
    private By CategoryListOpen= By.xpath(("//div[@class='mp7g_oh mr3m_1 _r65gb']"));
    private By HouseAndGarden= By.xpath("//option[text()='Dom i ogród']");


    public Header TypePhrase(String phrase){
        WebElement searchEngineInput = driver.findElement(SearchEngineInput);
        WebDriverWait wait = new WebDriverWait(driver ,5);
        wait.until(ExpectedConditions.visibilityOf(searchEngineInput));
        searchEngineInput.clear();
        searchEngineInput.sendKeys(phrase);
        return new Header(driver);
    }
    public Header Search(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchButton));
        WebElement search =driver.findElement(SearchButton);
        search.click();
        return  new Header(driver);
    }

    public Header ChooseCategory(String category){
       WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(CategoryListOpen));
        WebElement categoryList = driver .findElement(CategoryListOpen);
        categoryList.click();
        WebElement houseAndGarden = driver .findElement(HouseAndGarden);
        houseAndGarden.click();
        return  new Header(driver);

    }


}
