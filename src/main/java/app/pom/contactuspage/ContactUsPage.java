package app.pom.contactuspage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

    public ContactUsPage(){PageFactory.initElements(driver, this);}

       @FindBy(xpath = "//a[normalize-space()='Contact Us']")
       public WebElement contactUsButton;

       @FindBy(xpath = "//input[@id='name']")
       public WebElement myNameInput;

       @FindBy(xpath = "//input[@id='email']")
       public WebElement myEmailInput;

       @FindBy(xpath = "//input[@id='telephone']")
       public WebElement myTelephoneNumberInput;

       @FindBy(xpath = "//textarea[@id='comment']")
       public WebElement whatsOnYourMindInput;

       @FindBy(xpath = "//button[@title='Submit']")
       public WebElement contactSubmitButton;

       @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
       public WebElement thankYouForContactMessage;

       public void doContactUs(String name, String email, String phoneNumber, String whatsOnYourMind){
           safeClickOnElement(contactUsButton);
           sendKeysToElement(myNameInput, name);
           sendKeysToElement(myEmailInput, email);
           sendKeysToElement(myTelephoneNumberInput, phoneNumber);
           sendKeysToElement(whatsOnYourMindInput, whatsOnYourMind);
           safeClickOnElement(contactSubmitButton);

       }



}
