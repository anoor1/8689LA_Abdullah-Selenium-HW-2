package test_app;

import app.pom.homepage.CreateAccountPage;
import app.pom.homepage.Homepage;
import app.pom.homepage.LoginPage;
import app.pom.homepage.SearchResultPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelData;

import static utils.ExcelData.readString;

public class TestApp extends BasePage {

    Homepage homepage = new Homepage();
    @Test (priority = 0, groups = {"BAT"})
    public void testNavigationToApplication() {


        Assert.assertTrue(isElementVisible(homepage.logo));

        Assert.assertTrue(isElementVisible(homepage.search_bar));
    }
    
    
    
    @Test (priority = 1, groups = {"BAT"})
    public void createAccountinApplication() {
        CreateAccountPage accountpage = new CreateAccountPage();
        accountpage.createAccount();
        Assert.assertTrue(isElementVisible(accountpage.registeruservalidation));
    }
    
    
    
    @Test (priority = 2, groups = {"BAT"})
    public void login() {
        LoginPage loginpage = new LoginPage();
        loginpage.login();
        Assert.assertTrue(isElementVisible(loginpage.welcompagetext));
        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }
    
    
    @Test
    public void testDoSearch(){
        homepage = new Homepage();
        ExcelData.readString("testDoSearch")[0]
        String searchTerm ="OverNight Duffle";
       SearchResultPage searchResultPage = homepage.doSearch(searchTerm);

       Assert.assertEquals(searchResultPage.textSearchTerm.getText(), searchTerm);



    }
    
    
    
    
    
    
    
    

}
