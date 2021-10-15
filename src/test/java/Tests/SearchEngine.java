package Tests;

import PageObject.Header;
import PageObject.ItemListPage;
import PageObject.Other;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchEngine<phrase> {

    WebDriver driver;
    By SearchedPhraseText = By.xpath("//input[@class='mr3m_1 mli2_1 mjyo_6x mse2_40 mqu1_40 mp4t_0 m3h2_0 mryx_0 munh_0 mg9e_0 mj7a_0 mh36_0 mvrt_8 mlkp_ag mefy_5r mldj_0 mm2b_0 _14uqc mgmw_q3 mh85_0 _535b5_1gH6X']");  // szukasz " "
    By SearchedCategory = By.xpath("//a[@class='_1liky _w7z6o _uj8z7 _jmjqf _d2756_1wB6R _15tw4 _d2756_3KVjZ']/span");
    String phrase = "promocja";
    String categoryHouseAndGarden = "Dom i Ogród";

    @BeforeEach
    public void DriverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://allegro.pl");
        Other other = new Other(driver);
        other.AcceptRole();
    }

    @Test
    public void TypePhrase(){
        Header header = new Header(driver);
        ItemListPage itemListPage = new ItemListPage(driver);
        header.TypePhrase(phrase);
        header.Search();
        itemListPage.WaitForResultsAfterSearching();
        assertTrue(driver.findElement(SearchedPhraseText).getAttribute("value").contains(phrase),"Szukana fraza nie zgadza się  wpisaną w wyszukiwarkę");
    }

    @Test
    public void Category(){
        Header header = new Header(driver);
        ItemListPage itemListPage = new ItemListPage(driver);
        header.TypePhrase(phrase);
        header.ChooseCategory(categoryHouseAndGarden);
        header.Search();
        itemListPage.WaitForResultsAfterSearching();
        assertTrue(driver.findElement(SearchedCategory).getText().contains(categoryHouseAndGarden),"Wybrana została zła lub inna  kategoria");
    }

}