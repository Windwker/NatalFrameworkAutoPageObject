package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Autocomplete {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div/div/span/span/span[1]/span")
    private WebElement selector_de_farmacias;
    @FindBy(className = "select2-search__field")
    private WebElement search_field;
    @FindBy(xpath = "//*[@class=\"select2-results__option\"]")
    private List<WebElement> listado;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div/div/span/span/span[1]/span/ul/li[1]")
    private WebElement selected_option_search_field;
    @FindBy(xpath = "/html/body/span/span/span[2]/ul/li[@class=\"select2-results__option loading-results\"]")
    private WebElement label_buscando;

    WebDriverWait wait;
    private ArrayList<String> listadoDeStrings = new ArrayList<>();


    public Autocomplete(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String TituloDeLaPagina() {
        return driver.getTitle();

    }


    public void HacerClickEnElSelectorDeFarmacias() {
        wait.until(visibilityOf(selector_de_farmacias));
        selector_de_farmacias.click();
    }

    public void IngresarValorInputFarmacia(String text) {
        wait.until(visibilityOf(search_field));
        search_field.sendKeys(text);
        wait.until(not(visibilityOf(label_buscando)));

    }

    public ArrayList<String> ListaDeElementos() {


        for (WebElement elemento : listado
        ) {
            listadoDeStrings.add(elemento.getText());
        }

        return listadoDeStrings;
    }

    public void ClickearAlgunaOpcion() {
        wait.until(ExpectedConditions.elementToBeClickable(listado.get(1)));
        listado.get(4).click();

    }


    public String ValorCampoBusqueda() {
        return selected_option_search_field.getText();
    }
}
