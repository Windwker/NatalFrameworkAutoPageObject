package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div[2]/div/a")
    private WebElement ver_framework_button;

    WebDriver driver;


    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void hacerClickEnElBotonVerFramework(){
        ver_framework_button.click();
    }



}
