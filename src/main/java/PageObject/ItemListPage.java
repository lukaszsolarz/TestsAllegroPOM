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

    private By SearchedPhraseText = By.xpath("//input[@class='mr3m_1 mli2_1 mjyo_6x mse2_40 mqu1_40 mp4t_0 m3h2_0 mryx_0 munh_0 mg9e_0 mj7a_0 mh36_0 mvrt_8 mlkp_ag mefy_5r mldj_0 mm2b_0 _14uqc mgmw_q3 mh85_0 _535b5_1gH6X']");

    public ItemListPage WaitForResultsAfterSearching(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement searchedPhrase = driver.findElement(SearchedPhraseText);
        wait.until(ExpectedConditions.visibilityOf(searchedPhrase));
        return new ItemListPage(driver);
    }

}
