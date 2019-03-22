package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Autocomplete {

    WebDriver driver;
    @FindBy(className = "select2-search__field")
    private WebElement search_field;
    @FindBy(xpath = "//*[@class=\"select2-results__option\"]")
    private List<WebElement> listado;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/form/div/div/span/span/span[1]/span/ul/li[1]")
    private WebElement selected_option_search_field;
    private ArrayList<String> listadoDeStrings = new ArrayList<>();


    public Autocomplete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String TituloDeLaPagina() {
        return driver.getTitle();

    }


    public void IngresarValorInputFarmacia(String text) {
        search_field.sendKeys(text);

    }

    public ArrayList<String> ListaDeElementos() {


        for (WebElement elemento : listado
        ) {
            listadoDeStrings.add(elemento.getText());
        }

        return listadoDeStrings;
    }

    public void ClickearAlgunaOpcion(){

        listado.get(4).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String ValorCampoBusqueda(){
        return selected_option_search_field.getText();
    }
}
