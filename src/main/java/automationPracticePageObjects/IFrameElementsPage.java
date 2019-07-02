package automationPracticePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class IFrameElementsPage {
    WebDriver driver;

    public IFrameElementsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCartItem;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedToCheckOutButton;

    @FindBy(how = How.XPATH, using = "//button[@name='processAddress']")
    WebElement checkOutOnVerifyAddressPageButton;

    // Agreement box check
    @FindBy(how = How.XPATH, using = "//div[@id='uniform-cgv']//input[@id='cgv']")
    WebElement agreementCheckBox;

    // Proceed to checkout on agreement page
    @FindBy(how = How.XPATH, using = "//button[@name='processCarrier']")
    WebElement proceedToCheckOutOnAgreementPageButton;
    // payment method by check
    @FindBy(how = How.CSS, using = "p.payment_module > a.cheque")
    WebElement payByCheck;

    // Confirm Order
    @FindBy(how = How.XPATH, using = "//p[@id='cart_navigation']// button[@class='button btn btn-default button-medium']")
    WebElement confirmOrder;

    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    WebElement checkOrderSuccess;
    @FindBy(how = How.XPATH, using = "//div[@class='box order-confirmation']//span[@class='price']")
    WebElement checkItemPrice;

    @FindBy(how = How.XPATH, using = "//a[@class='button-exclusive btn btn-default']")
    WebElement backToOrders;

    @FindBy(how = How.CSS, using = "a.logout")
    WebElement logout;

    @FindBys(@FindBy(how = How.XPATH, using = "//tr//td[@class='history_price']"))
    List<WebElement> orderHistoryPrice;

    public void proceedToCheckOut() {
        driver.switchTo().frame(0);
        addToCartItem.submit();
        proceedToCheckOutButton.click();

    }

    public void proceedToCheckOutOnVerifyAddressPage() {

        checkOutOnVerifyAddressPageButton.submit();
    }

    public void agreementDisclosure() {
        agreementCheckBox.click();
    }

    public void proceedToCheckOutOnAgreementPage() {
        proceedToCheckOutOnAgreementPageButton.click();
    }

    public void paymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(payByCheck));
        payByCheck.click();
    }

    public void orderConfirmation() {
        confirmOrder.click();
    }

    public String getConfirmationItemPrice() {

        String confirmationPrice = checkItemPrice.getText();
        System.out.println("Confirmation Price is " + confirmationPrice);
        return confirmationPrice;

    }
    public String checkActualMessageAfterOrderSubmission() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(checkOrderSuccess));
        String actualMessage = checkOrderSuccess.getText();
        return actualMessage;
    }


    public void setBackToOrders() {
        backToOrders.click();
    }

    public void checkOrderPrice() {
        System.out.println("Total order history " + orderHistoryPrice.size());
        String confirmationPrice = getConfirmationItemPrice();
        String dollar = "$";
        for (int i = 0; i < orderHistoryPrice.size(); i++) {

            if ((dollar + orderHistoryPrice.get(i).getAttribute("data-value")).equals(confirmationPrice)) {
                System.out.println("your order is in the list");
                break;
            }
            else {
                System.out.println("Please check again");
            }
        }
    }
        public void setLogout () {
            logout.click();



    }
}
