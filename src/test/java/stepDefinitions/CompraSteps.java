package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompraSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }

    @Given("que el usuario abre la aplicación saucedemo")
    public void que_el_usuario_abre_la_aplicación_saucedemo() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("inicia sesión con usuario {string} y contraseña {string}")
    public void inicia_sesion_con_usuario_y_contrasena(String usuario, String contrasena) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(contrasena);
        driver.findElement(By.id("login-button")).click();
    }

    @When("valida que el usuario ve la lista de productos")
    public void valida_lista_productos() {
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        String titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))).getText();
        assertEquals("Products", titulo);
    }

    @And("selecciona el producto {string}")
    public void selecciona_el_producto(String nombreProducto) {
        WebElement producto = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[div[text()='" + nombreProducto + "']]")));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", producto);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", producto);
    }


    @And("lo agrega al carrito")
    public void lo_agrega_al_carrito() {
        WebElement botonAgregar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@id, 'add-to-cart')]")));
        botonAgregar.click();
    }


    @And("navega al carrito de compras")
    public void navega_al_carrito() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
    }

    @And("valida que el producto {string} está en el carrito")
    public void valida_producto_en_carrito(String productoEsperado) {
        String productoEnCarrito = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name"))).getText();
        assertEquals(productoEsperado, productoEnCarrito);
    }

    @When("procede al checkout")
    public void procede_al_checkout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();
    }

    @And("ingresa nombre {string}, apellido {string} y código postal {string}")
    public void ingresa_datos_personales(String nombre, String apellido, String codigoPostal) {
        driver.findElement(By.id("first-name")).sendKeys(nombre);
        driver.findElement(By.id("last-name")).sendKeys(apellido);
        driver.findElement(By.id("postal-code")).sendKeys(codigoPostal);

        WebElement botonContinuar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonContinuar);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(botonContinuar)).click();
    }


    @And("continúa con la compra")
    public void continua_con_la_compra() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
    }

    @And("finaliza la compra")
    public void finaliza_la_compra() {
        WebElement botonFinalizar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonFinalizar);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.elementToBeClickable(botonFinalizar)).click();
    }


    @Then("debería ver el mensaje {string}")
    public void deberia_ver_el_mensaje(String mensajeEsperado) {
        String mensajeFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))).getText();
        assertEquals(mensajeEsperado, mensajeFinal);
    }

}
