package be.axxes.traineeship.java.testing.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutWidget extends AbstractPage {

    @FindBy(id = "order")
    private WebElement parent;

    public CheckoutWidget(WebDriver driver) {
        super(driver);
    }

    public boolean checkoutWidgetSummaryDisplayed(){
        return isDisplayed(parent, By.id("order-detail-content"));
    }

    public boolean checkoutWidgetAddressesDisplayed(){
        return isDisplayed(parent, By.className("addresses"));
    }

    public boolean checkoutWidgetCarrierDisplayed(){
        return isDisplayed(parent, By.className("order_carrier_content"));
    }

    public boolean verifyOrderData(String item, String amount, String size){
        String visibleItem = getAttributeValue(parent, By.xpath("//*[@class='cart_description']/p/a"), "innerHTML");
        String visibleAmount = getAttributeValue(parent, By.cssSelector("input[name='quantity_2_9_0_15219']"), "value");
        String visibleSize = getAttributeValue(parent, By.xpath("//*[@class='cart_description']/small[2]/a"), "innerHTML");

        return item.equals(visibleItem) &&
                amount.equals(visibleAmount) &&
                size.equals(visibleSize.substring(visibleSize.length()-1));
    }

    public void proceedToNextStep(){
        click(parent, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
    }

}
