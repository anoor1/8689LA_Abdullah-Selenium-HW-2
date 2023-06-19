package app.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    
    @FindBy(id="email")
    public WebElement email;
    
    @FindBy(id="pass")
    public WebElement pass;
    
    
    @FindBy(name="send")
    public WebElement signin;
    
   
    
    @FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
    public WebElement signinheaderLink;
    
    @FindBy(xpath = "(//li[@class='greet welcome'])[1]")
    public WebElement welcompagetext;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    
    
    public void login()
    {
    	clickOnElement(signinheaderLink);
    	sendKeysToElement(email, "abcdtest1@gmail.com");
    	sendKeysToElement(pass, "QqwertyQ@123");
    	clickOnElement(signin);
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
