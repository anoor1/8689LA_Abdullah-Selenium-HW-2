package app.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy (xpath = "//a[@href='https://magento.softwaretestingboard.com/']")
    public WebElement logo;

    @FindBy (xpath = "//span[.='Women']")
    public WebElement womanDropdown;

    @FindBy (xpath = "//a[@href='https://magento.softwaretestingboard.com/women/tops-women.html']")
    public WebElement topsButton;

    @FindBy (xpath = "//div[@data-role='title']")
    public WebElement categoryButton;

    @FindBy (xpath = "//*[@id='narrow-by-list']/div[1]/div[2]/ol/li[1]/a")
    public WebElement jacketButton;

    @FindBy (xpath = "//div[@class='filter-current']//li[@class='item']")
    public WebElement categoryJacketResult;

    @FindBy (xpath = "//input[@id='newsletter']")
    public WebElement emailSubscribeInput;

    @FindBy (xpath = "//span[normalize-space()='Subscribe']")
    public WebElement emailSubscribeButton;

    @FindBy (xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement confirmSubscriptionMessage;




    public void clickWomanDropdown(){
        hoverOverElement(womanDropdown);

    }

    public void clickOnTopsButton(){
        safeClickOnElement(topsButton);
    }

    public void clickOnCategory(){
        safeClickOnElement(categoryButton);
    }

    public void clickOnJacket(){
        safeClickOnElement(jacketButton);

    }
    public void doFilterTo(){
        clickWomanDropdown();
        clickOnTopsButton();
        clickOnCategory();
        clickOnJacket();

    }


    public Homepage(){
        PageFactory.initElements(driver, this);
    }

    public void subscribeWithEmail(String emailAddress) {
        sendKeysToElement(emailSubscribeInput, emailAddress);
        safeClickOnElement(emailSubscribeButton);
    }
    
   
  
    
    
    
    

}
