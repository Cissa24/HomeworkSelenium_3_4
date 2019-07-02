package stepDefinitions;

import Helpers.BrowserFactory;
import TestCases.TestShoppingFlow;
import automationPracticePageObjects.Billing_Delivery_AddressesPage;
import automationPracticePageObjects.IFrameElementsPage;
import automationPracticePageObjects.LoginElements;
import automationPracticePageObjects.WomenDepartment;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class ShoppingFlowStepdefs {
    WebDriver driver;
    Billing_Delivery_AddressesPage addressesPage;
    LoginElements login;
    WomenDepartment womenDepartment;
    IFrameElementsPage iframe;


    @Before
    public void setUp(){
        driver = BrowserFactory.setBrowser("chrome", "http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        addressesPage = new Billing_Delivery_AddressesPage(driver);
        login = new LoginElements(driver);
        womenDepartment = new WomenDepartment(driver);
        iframe = new IFrameElementsPage(driver);


    }

    @Given("^User is logged in$")
    public void userIsLoggedIn() {
        login.loginMethod("test+07@test.com", "Ab1234");
    }

    @Given("^user navigates to Women Department and selects a listing item$")
    public void userNavigatesToWomenDepartmentAndSelectsAListingItem() {
        womenDepartment.SelectARandomProduct();

    }

    @When("^user adds it to the shopping cart$")
    public void addsItToTheShoppingCart() {
        iframe.proceedToCheckOut();

    }

    @And("^user verifies billing address$")
    public void userVerifiesBillingAddress() {
        System.out.println("Billing info");
        System.out.println(addressesPage.getBillingName());
        System.out.println(addressesPage.getBillingAddress());
        System.out.println(addressesPage.getBillingCityStateZipcode());
        System.out.println(addressesPage.getBillingCountry());
        System.out.println(addressesPage.getBillingPhone());

    }

    @And("^user verifies delivery address$")
    public void userVerifiedDeliveryAddress() {
        System.out.println("Delivery info");
        System.out.println( addressesPage.getActualDeliveryName());
        System.out.println(addressesPage.getActualDeliveryAddress());
        System.out.println(addressesPage.getActualdeliveryCityStateZipcode());
        System.out.println(addressesPage.getDeliveryCountry());
        System.out.println( addressesPage.getDeliveryPhone());



    }

    @And("^user clicks on proceed to checkout button$")
    public void userClicksOnProceedToCheckoutButton() {
        addressesPage.proceedToCheckoutButton();

    }

    @And("^user checks agreement disclosure$")
    public void userChecksAgreementDisclosure() {
        iframe.agreementDisclosure();

    }

    @And("^user clicks on proceed to checkout on Agreement page$")
    public void userClicksOnProceedToCheckoutOnAgreementPage() {
        iframe.proceedToCheckOutOnAgreementPage();

    }

    @And("^user selects check as a payment method$")
    public void userSelectsCheckAsAPaymentMethod() {
        iframe.paymentMethod();

    }

    @And("^user confirms order$")
    public void userConfirmsOrder() {
        iframe.orderConfirmation();

    }

    @And("^user verifies the price$")
    public void userVerifiesThePrice() {
        iframe.getConfirmationItemPrice();

    }

    @Then("^user verifies that order was successfully submitted$")
    public void userVerifiesThatOrderWasSuccessfullySubmitted() {
        iframe.checkActualMessageAfterOrderSubmission();

    }

    @And("^user goes back to orders$")
    public void userGoesBackToOrders() {
        iframe.setBackToOrders();

    }

    @And("^verifies that placed order is in order history$")
    public void verifiesThatPlacedOrderIsInOrderHistory() {
        iframe.checkOrderPrice();
    }

    @After
    public void EndTest(){
        iframe.setLogout();
        driver.quit();
    }
}
