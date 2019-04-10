package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NatalFramework2Page {
    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")
    private WebElement botonComponentes;
    WebDriver driver;


    public NatalFramework2Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void HacerClickEnElBotonComponentes(){
        botonComponentes.click();
    }

}
