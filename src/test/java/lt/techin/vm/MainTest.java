package lt.techin.vm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Locale;

public class MainTest extends BaseTest{

    @Test
    void chooseAllMp3Player(){
MainPage page = new MainPage(driver);
page.clickMp3PlayersMenus();
page.clickToChooseAllMp3Players();
    }

    @Test
    void showAllMp3PlayersAslist(){
        MainPage page = new MainPage(driver);
        page.clickMp3PlayersMenus();
        page.clickToChooseAllMp3Players();
        page.clickToShowItemsAsList();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/opencart.csv", numLinesToSkip = 1)
    void searchFromFile(String name){
        MainPage page = new MainPage(driver);
        IpodNanoPage item = new IpodNanoPage(driver);
       // page.clickMp3PlayersMenus();
       // page.clickToChooseAllMp3Players();
       // page.clickToShowItemsAsList();
        page.serchByName(name);
        page.clickToShowItemsAsList();
        for (WebElement element : page.items) {
            if (element.getText().contains(name)) {
                Wait<WebDriver> wait =
                        new FluentWait<>(driver)
                                .withTimeout(Duration.ofSeconds(3))
                                .pollingEvery(Duration.ofMillis(300))
                                .ignoring(ElementNotInteractableException.class);

                wait.until(
                        d -> {
                            element.click();;
                            return true;
                        });


                break;
            }
        }
       // page.clickRandomItem();
        item.setInputQuantityOfIpodNano();
        item.clickAddToCartButton();
        item.succedAddToCartMessage.isDisplayed();
        Assertions.assertEquals(item.itemsInKart,Integer.parseInt(item.isItemAddedToCartQty()),"Qty not match");
        Assertions.assertEquals(item.isItemAddedToCartPrice(),String.format(Locale.US,"%.2f",item.getItemPrice()* item.itemsInKart));
    }

    @Test
    void isIpodNanoDisplayed(){
        MainPage page = new MainPage(driver);
        page.clickMp3PlayersMenus();
        page.clickToChooseAllMp3Players();
        page.clickToShowItemsAsList();
        Assertions.assertTrue(page.ipodNanoPage.isDisplayed());
        System.out.println(page.ipodNanoPage.getText());
        Assertions.assertEquals("iPod Nano",page.ipodNanoPage.getText(),"Item names not match");
    }

    @Test
    void goIpodNanoPage(){
        MainPage page = new MainPage(driver);
        page.clickMp3PlayersMenus();
        page.clickToChooseAllMp3Players();
        page.clickToShowItemsAsList();
        page.goToIpodNanoPage();
    }

    @Test
    void chooseHowManyIpodNano(){
        MainPage page = new MainPage(driver);
        IpodNanoPage ipodNanoPage = new IpodNanoPage(driver);
        page.clickMp3PlayersMenus();
        page.clickToChooseAllMp3Players();
        page.clickToShowItemsAsList();
        page.goToIpodNanoPage();
        ipodNanoPage.setInputQuantityOfIpodNano();
        ipodNanoPage.clickAddToCartButton();
        ipodNanoPage.succedAddToCartMessage.isDisplayed();
//        System.out.println(ipodNanoPage.isItemAddedToCartQty());
//        System.out.println(ipodNanoPage.itemsInKart);
//        System.out.println(ipodNanoPage.isItemAddedToCartPrice());
//        System.out.println(ipodNanoPage.getItemPrice());
//        System.out.println(ipodNanoPage.getItemPrice()* ipodNanoPage.itemsInKart);
        Assertions.assertEquals(ipodNanoPage.itemsInKart,Integer.parseInt(ipodNanoPage.isItemAddedToCartQty()),"Qty not match");
       // Assertions.assertEquals(ipodNanoPage.isItemAddedToCartPrice(),ipodNanoPage.getItemPrice()* ipodNanoPage.itemsInKart);
        Assertions.assertEquals(ipodNanoPage.isItemAddedToCartPrice(),String.format(Locale.US,"%.2f",ipodNanoPage.getItemPrice()* ipodNanoPage.itemsInKart));

       // System.out.println(ipodNanoPage.cartPreviewButton.getText());
    }












}
