package stepDefinitions;

import Utill.BaseLibrary;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;

import java.net.MalformedURLException;

public class steps {
  static   WebDriver driver;
    public static LoginPage RHP;




    @Given("User hits Orange hrm website")
    public void user_hits_orange_hrm_website() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();

        // Initialize the LoginPage
        RHP = new LoginPage(driver);
    }

    @Then("Enters Username as {string}")
    public void enters_username_as(String user) throws InterruptedException {
        Thread.sleep(5000);
       RHP.getUsername().sendKeys(user);
    }
    @Then("Enters  password as {string}")
    public void enters_password_as(String pwd) {
        RHP.getPassword().sendKeys(pwd);

    }
    @Then("click on login Button {string}")
    public void click_on_login_button(String string) {
 RHP.getPassword().click();
    }

}
