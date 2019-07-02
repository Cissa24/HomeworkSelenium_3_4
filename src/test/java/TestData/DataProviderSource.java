package TestData;

import org.testng.annotations.DataProvider;

public class DataProviderSource {
    @org.testng.annotations.DataProvider(name = "actualBillingInfo")
    public Object[][] actualBillingInfo() {
        Object[][] billingInfo = new Object[1][5];


        billingInfo[0][0] = "Test Olga";
        billingInfo[0][1] = "123 Test ave";
        billingInfo[0][2] = "chicago, Illinois 60602";
        billingInfo[0][3] = "United States";
        billingInfo[0][4] = "3453453465";
        return billingInfo;
    }


    @org.testng.annotations.DataProvider(name = "actualDeliveryInfo")
    public Object[][] actualDeliveryInfo() {
        Object[][] deliveryInfo = new Object[1][5];

        deliveryInfo[0][0] = "Test Olga";
        deliveryInfo[0][1] = "123 Test ave";
        deliveryInfo[0][2] = "chicago, Illinois 60602";
        deliveryInfo[0][3] = "United States";
        deliveryInfo[0][4] = "3453453465";
        return deliveryInfo;

    }
    @DataProvider (name = "OrderSuccessMessage")
    public Object [] orderSuccessMessage(){
       String [] ExpectedMessage = {"Your order on My Store is complete."};
return ExpectedMessage;
    }
}
