package lt.techin.vm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class IpodNanoPage extends BasePage{

    public IpodNanoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#input-quantity")
    WebElement inputQuantityOfIpodNano;
    @FindBy(css = "div#alert > .alert.alert-dismissible.alert-success")
    WebElement succedAddToCartMessage;
    @FindBy(css = ".btn-inverse")
    WebElement cartPreviewButton;
    @FindBy(css = "button#button-cart")
    WebElement addToCart;
    @FindBy(css = ".price-new")
    WebElement itemPrice;







public int itemsInKart = 0;

    public void setInputQuantityOfIpodNano(){
        Random random = new Random();
        int randomQty = random.nextInt(20)+1;
        inputQuantityOfIpodNano.clear();
        inputQuantityOfIpodNano.sendKeys(String.valueOf(randomQty));
        itemsInKart = itemsInKart + randomQty;
    }

    public void clickAddToCartButton(){
        addToCart.click();
    }

    public String isItemAddedToCartQty(){
        String s = cartPreviewButton.getText();
        String[] parts = s.split(" ");
        String itemCount = parts[0];
        return itemCount;
    }

//    public double isItemAddedToCartPrice(){
//        String s = cartPreviewButton.getText();
//        String[] parts = s.split("\\$");
//        String price = parts[1].trim();
//        price = price.replace(",", "");
//        return Double.parseDouble(price);
   // }
    public String isItemAddedToCartPrice(){
        String s = cartPreviewButton.getText();
        String[] parts = s.split("\\$");
        String price = parts[1].trim();
        price = price.replace(",", "");
        return price;
    }


    public double getItemPrice(){
        String s = itemPrice.getText();
        String price = s.replace("$", "").trim();
        return Double.parseDouble(price);
    }

    //public double totalPriceOfItems = *getItemPrice();








}
