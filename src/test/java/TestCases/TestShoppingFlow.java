package TestCases;

import Helpers.BrowserFactory;
import TestData.DataProviderSource;
import automationPracticePageObjects.Billing_Delivery_AddressesPage;
import automationPracticePageObjects.IFrameElementsPage;
import automationPracticePageObjects.LoginElements;
import automationPracticePageObjects.WomenDepartment;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestShoppingFlow {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
       driver = BrowserFactory.setBrowser("chrome", "http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void login() {
        LoginElements login = new LoginElements(driver);
        login.loginMethod("test+07@test.com", "Ab1234");

    }

    @Test(priority = 1)
    public void selectARandomListing(){
        WomenDepartment newItem = new WomenDepartment(driver);
        newItem.SelectARandomProduct();
    }

    @Test(priority = 2)
    public void addItemToShoppingCartAndProceedToCheckout(){
        IFrameElementsPage AddToCartAndProceedToCheckOutButton = new IFrameElementsPage(driver);
        AddToCartAndProceedToCheckOutButton.proceedToCheckOut();
    }


    @Test(dataProvider = "actualBillingInfo", dataProviderClass = DataProviderSource.class, priority = 3)
    public void verifyBillingAddress(String billingName, String billingAddress, String billingCityStateZipcode, String billingCountry, String billingPhone) {

        Billing_Delivery_AddressesPage addressesPage = new Billing_Delivery_AddressesPage(driver);

        Assert.assertEquals(billingName, addressesPage.getBillingName());
        Assert.assertEquals(billingAddress,addressesPage.getBillingAddress());
        Assert.assertEquals(billingCityStateZipcode, addressesPage.getBillingCityStateZipcode());
        Assert.assertEquals(billingCountry, addressesPage.getBillingCountry());
        Assert.assertEquals(billingPhone, addressesPage.getBillingPhone());

    }

    @Test(dataProvider = "actualDeliveryInfo", dataProviderClass = DataProviderSource.class, priority = 4)
    public void verifyDeliveryAddress(String deliveryName, String deliveryAddress, String deliveryCityStateZipcode, String deliveryCountry, String deliveryPhone) {
        Billing_Delivery_AddressesPage addressesPage = new Billing_Delivery_AddressesPage(driver);

        Assert.assertEquals(deliveryName, addressesPage.getActualDeliveryName());
        Assert.assertEquals(deliveryAddress, addressesPage.getActualDeliveryAddress());
        Assert.assertEquals(deliveryCityStateZipcode,addressesPage.getActualdeliveryCityStateZipcode());
        Assert.assertEquals(deliveryCountry, addressesPage.getDeliveryCountry() );
        Assert.assertEquals(deliveryPhone, addressesPage.getDeliveryPhone());
    }
    @Test(priority = 5)
    public void proceedToCheckOutOnConfirmAddressPage(){
        IFrameElementsPage proceedToCheckOutButton = new IFrameElementsPage(driver);
        proceedToCheckOutButton.proceedToCheckOutOnVerifyAddressPage();

    }

    @Test (priority = 6)
    public void agreement(){
        IFrameElementsPage checkbox = new IFrameElementsPage(driver);
        checkbox.agreementDisclosure();
    }
    @Test(priority = 7)
    public void proceedToCheckOutOnAgreementPage(){
        IFrameElementsPage checkoutButton = new IFrameElementsPage(driver);
        checkoutButton.proceedToCheckOutOnAgreementPage();
    }

    @Test (priority = 8)
    public void paymentByCheck(){
        IFrameElementsPage selectPaymentOption = new IFrameElementsPage(driver);
        selectPaymentOption.paymentMethod();
    }

    @Test(priority = 9)
    public void confirmOrder(){
        IFrameElementsPage confirmYourOrder = new IFrameElementsPage(driver);
        confirmYourOrder.orderConfirmation();
    }

    @Test (priority = 10)
    public void getConfirmationPrice(){
        IFrameElementsPage check =new IFrameElementsPage(driver);
        check.checkOrderPrice();
    }

    @Test (dataProvider  = "OrderSuccessMessage", dataProviderClass = DataProviderSource.class, priority = 11)
    public void checkIfOrderWasSubmittedSuccessfully (String expectedMessage){
        IFrameElementsPage check = new IFrameElementsPage(driver);
       Assert.assertEquals(expectedMessage, check.checkActualMessageAfterOrderSubmission());
    }

    @Test(priority = 12)
    public void proceedBackToOrders(){
        IFrameElementsPage check = new IFrameElementsPage(driver);
        check.setBackToOrders();
    }
    @Test(priority = 13, dependsOnMethods = {"getConfirmationPrice"})
    public void verifyingOrderedItemPrice(){
        IFrameElementsPage verify=new IFrameElementsPage(driver);
        verify.checkOrderPrice();
    }

    @AfterTest
    public void EndTest(){
        IFrameElementsPage logOut=new IFrameElementsPage(driver);
        logOut.setLogout();
        driver.quit();
    }
}
