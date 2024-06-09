package lt.techin.vm;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy (css = "li:nth-of-type(8)")
    WebElement mp3PlayersMenus;
    @FindBy (css = ".dropdown-menu.show > .see-all")
    WebElement showAllMp3Players;
    @FindBy(css = "div:nth-of-type(2) > .product-thumb h4 > a")
    WebElement ipodNanoPage;
    @FindBy(css="div#search > input[name='search']")
    WebElement searchInput;
    @FindBy(css=".product-thumb h4 > a")
    List<WebElement> items;



    // Buttons
    @FindBy(css = "#button-list > i")
    WebElement showAsList;
    @FindBy(css =".fa-magnifying-glass")
    WebElement searchButton;











    public void clickMp3PlayersMenus(){
        mp3PlayersMenus.click();
    }
    public void clickToChooseAllMp3Players(){
        showAllMp3Players.click();
    }
    public void clickToShowItemsAsList(){
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    showAsList.click();
                    return true;
                });





    }

    public void serchByName(String name){
        searchInput.clear();
        searchInput.sendKeys(name);
        searchButton.click();
    }

    public void clickRandomItem(){
        Random random = new Random();
        WebElement randomItem = items.get(random.nextInt(items.size()));

        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    randomItem.click();
                    return true;
                });

    }

//    public void clickSearchedElement() {
//
//        for (WebElement element : items) {
//            if (element.getText().contains(name)) {
//                element.click();
//                break;
//            }
//        }
//    }

    public  void goToIpodNanoPage(){
        ipodNanoPage.click();
    }














}
