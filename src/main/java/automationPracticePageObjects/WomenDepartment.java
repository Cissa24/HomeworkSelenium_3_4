package automationPracticePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class WomenDepartment {
    WebDriver driver;
    public WomenDepartment(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.CSS,using = "a.sf-with-ul")
    WebElement navigateToWomenDepartment;

    @FindBy(how = How.CSS, using = ".product_img_link")
    WebElement productImageLink;

   @FindBys(@FindBy (css = "ul.product_list.grid.row > li"))
     List<WebElement>  countingAllListingsOnthePage;

    public void SelectARandomProduct(){
        navigateToWomenDepartment.click();
        System.out.println(countingAllListingsOnthePage.size());
        Random random = new Random();
        int randomListing = random.nextInt(countingAllListingsOnthePage.size());
        WebElement randomProduct = countingAllListingsOnthePage.get(randomListing);
       //need to clarify how should it be written in the page factory
        randomProduct.findElement(By.cssSelector(".product_img_link")).click();

    }

}
