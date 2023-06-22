package app.pom.addmodifycartpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddModifyCartPage extends BasePage {
    public AddModifyCartPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='action showcart']")
    public WebElement cartButton;

    //@FindBy(id="top-cart-btn-checkout")
    //public WebElement checkOutButton;

    @FindBy(xpath = "//span[contains(text(),'Remove')]")
    public WebElement removeButton;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement modifyButton;

    @FindBy(xpath = "(//a[@class='product-item-link'])[1]")
    public WebElement productitemlink;

    @FindBy(xpath = "//button[@title='Update']")
    public WebElement updatebutton;

    @FindBy(xpath = "//button[@class='action-primary action-accept']")
    public WebElement okbutton;


    public void addtoCartItem()
    {
        hoverElement(productitemlink);
        clickOnElement(addToCartButton);
        clickOnElement(addToCartButton);

    }

    public void modifyItem()
    {
     clickOnElement(cartButton);
   clearSendKeysToElement(modifyButton,"1");
   clickOnElement(updatebutton);
    }

    public void removeCartItem()
    {
  clickOnElement(removeButton);
  clickOnElement(okbutton);

    }




}
