package automationPracticePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Billing_Delivery_AddressesPage {
    WebDriver driver;

    public Billing_Delivery_AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
    WebElement deliveryName;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2']")
    WebElement deliveryAdress;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']")
    WebElement deliveryCityStateZipcode;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_country_name']")
    WebElement deliveryCountry;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_delivery']//li[@class='address_phone']")
    WebElement deliveryPhone;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']")
    WebElement billingName;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_invoice']//li[@class='address_address1 address_address2']")
    WebElement billingAddress;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']")
    WebElement billingCityStateZipcode;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_invoice']//li[@class='address_country_name']")
    WebElement billingCountry;

    @FindBy(how = How.XPATH, using = "//ul[@id='address_invoice']//li[@class='address_phone']")
    WebElement billingPhone;

    @FindBy(how = How.XPATH, using = "//button[@name='processAddress']")
    WebElement checkoutButton;


    public String getActualDeliveryName() {
        String actualDeliveryName = deliveryName.getText();
        return actualDeliveryName;
    }

    public String getActualDeliveryAddress() {
        String actualDeliveryAdress = deliveryAdress.getText();
        return actualDeliveryAdress;
    }

    public String getActualdeliveryCityStateZipcode() {
        String actualdeliveryCityStateZipcode = deliveryCityStateZipcode.getText();
        return actualdeliveryCityStateZipcode;
    }

    public String getDeliveryCountry() {
        String actualDeliveryCountry = deliveryCountry.getText();
        return actualDeliveryCountry;

    }

    public String getDeliveryPhone() {
        String actualDeliveryPhone = deliveryPhone.getText();
        return actualDeliveryPhone;
    }

    public String getBillingName() {
        String actualBillingName = billingName.getText();
        return actualBillingName;
    }

    public String getBillingAddress() {

        String actualBillingAddress = billingAddress.getText();
        return actualBillingAddress;

    }

    public String getBillingCityStateZipcode() {
        String actualBillingCityStateZipcode = billingCityStateZipcode.getText();
        return actualBillingCityStateZipcode;
    }

    public String getBillingCountry() {
        String actualBillingCountry = billingCountry.getText();
        return actualBillingCountry;
    }

    public String getBillingPhone() {
        String actualBillingPhone = billingPhone.getText();
        return actualBillingPhone;
    }

    public void proceedToCheckoutButton() {
        checkoutButton.submit();
    }

}
