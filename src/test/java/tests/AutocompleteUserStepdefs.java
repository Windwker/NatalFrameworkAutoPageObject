package tests;

import cucumber.api.java.After;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Autocomplete;

public class AutocompleteUserStepdefs {
    WebDriver driver = new ChromeDriver();
    Autocomplete autocomplete = new Autocomplete(driver);

    @Dado("me encuentro en la website de autocomplete seleccion simple")
    public void meEncuentroEnLaWebsiteDeAutocompleteSeleccionSimple() {
        driver.get("http://ux.gruposancorseguros.com/?date=22%2F03%2F2019&sexo=Masculino&sexo=Femenino#/nf2/components/autocomplete/seleccion-multiple/demo");
        Assert.assertEquals("Natal Framework", autocomplete.TituloDeLaPagina());
    }

    @Cuando("comienzo a ingresar {string} en el input")
    public void comienzoAIngresarEnElInput(String arg0) {
        autocomplete.IngresarValorInputFarmacia(arg0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Entonces("deberia poder visualizar cada opcion disponible por criterio de busqueda")
    public void deberiaPoderVisualizarCadaOpcionDisponiblePorCriterioDeBusqueda() {

        Assert.assertTrue(autocomplete.ListaDeElementos().contains("26 - NEOFARMA"));
    }

    @Y("al seleccionar alguna opcion")
    public void alSeleccionarAlgunaOpcion() {

        autocomplete.ClickearAlgunaOpcion();

    }

    @Entonces("deberia visualizar la opcion seleccionada")
    public void deberiaVisualizarLaOpcionSeleccionada() {
        Assert.assertEquals("×98 - FARMASUR", autocomplete.ValorCampoBusqueda());
    }

    @Dado("me encuentro en la website de autocomplete seleccion multiple")
    public void meEncuentroEnLaWebsiteDeAutocompleteSeleccionMultiple() {

    }

    @Cuando("ingreso el valor {string} en el input")
    public void ingresoElValorEnElInput(String arg0) {

    }

    @Entonces("deberia poder visualizar cada opcion disponible que contiene el criterio de busqueda")
    public void deberiaPoderVisualizarCadaOpcionDisponibleQueContieneElCriterioDeBusqueda() {

    }

    @Y("al seleccionar alguna opcion del selector")
    public void alSeleccionarAlgunaOpcionDelSelector() {

    }

    @Entonces("deberia poder visualizar la opcion seleccionada")
    public void deberiaPoderVisualizarLaOpcionSeleccionada() {

    }

    @Y("deberia poder ingresar el valor {string} en el input")
    public void deberiaPoderIngresarElValorEnElInput(String arg0) {

    }

    @Y("deberia poder seleccionar un segundo valor de la lista")
    public void deberiaPoderSeleccionarUnSegundoValorDeLaLista() {

    }

    @Y("deberia poder visualizar los valores previamente seleccionados")
    public void deberiaPoderVisualizarLosValoresPreviamenteSeleccionados() {

    }

    @Y("al presionar la cruz para eliminar la opcion")
    public void alPresionarLaCruzParaEliminarLaOpcion() {

    }

    @Entonces("la opcion se elimina del selector")
    public void laOpcionSeEliminaDelSelector() {
    }


    @After
    public void tearDown(){
        driver.close();
    }
}
