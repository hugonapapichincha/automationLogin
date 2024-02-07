package steps;

import bookstores.ReadExcelFile;
import bookstores.WriteExcelFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pageobjects.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class InicioSesionSteps {

    private WebDriver driver;
    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;


    @Before
    public void setUp() throws MalformedURLException {
        //Codigo para ejecucion en navegador local//
        //System.setProperty("webdriver.firefox.driver","D:\\PICHINCHA\\ProyectoAutomatizacion\\PryAutomationLogin\\Driver\\geckodriver.exe");
        //driver = new FirefoxDriver();
        //fin de codigo navegador local//

        //Codigo para ejecucion en navegador remoto//
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),new FirefoxOptions());
        //fin de codigo navegador remoto//
        writeFile = new WriteExcelFile();
        readFile = new ReadExcelFile();
    }
    @Given("El cliente abre la pagina de HBK")
    public void el_cliente_abre_la_pagina_de_hbk() {
        driver.get("https://cal-bancadigital.pichincha.pe/login");
    }
    @When("Se ingresa el usuario {string} y password {string}")
    public void se_ingresa_el_usuario_y_password(String usuario, String pass) throws IOException {
        LoginPage loginp = new LoginPage(driver);
        String filepath = "D:\\PICHINCHA\\AUTOMATIZACION\\data\\DataLogin.xlsx";
        String searchUsuario = String.valueOf(readFile.getCellValue(filepath, "Login", Integer.parseInt(usuario),0));
        String searchPassword = String.valueOf(readFile.getCellValue(filepath, "Login", Integer.parseInt(pass),1));
        Integer longitud = searchPassword.length();
        loginp.writeUsuario(searchUsuario);
        loginp.clickPassword();
        for (int i = 0; i < longitud; i++)
        {
            loginp.writePassword(String.valueOf(searchPassword.charAt(i)));
        }
    }
    @Then("Clic en boton iniciar sesion e ingresa al Home")
    public void clic_en_boton_iniciar_sesion_e_ingresa_al_home() throws InterruptedException, IOException {
        LoginPage loginp = new LoginPage(driver);
        String filepath = "D:\\PICHINCHA\\AUTOMATIZACION\\data\\DataLogin.xlsx";
        String searchMensaje = String.valueOf(readFile.getCellValue(filepath, "Login", 1,2));
        loginp.clickInicio();
        Assert.assertEquals(loginp.getObtenerUsuarioLogueado(),searchMensaje);
        Thread.sleep(10000);
    }
    @Then("Clic en boton iniciar sesion y muestra mensaje {string}")
    public void clic_en_boton_iniciar_sesion_y_muestra_mensaje(String mensaje) throws InterruptedException, IOException {
        LoginPage loginp = new LoginPage(driver);
        String filepath = "D:\\PICHINCHA\\AUTOMATIZACION\\data\\DataLogin.xlsx";
        String searchMensaje = String.valueOf(readFile.getCellValue(filepath, "Login", Integer.parseInt(mensaje),2));
        loginp.clickInicio();
        Assert.assertEquals(loginp.getObtenerMensajeValidacion(),searchMensaje);
        Thread.sleep(4000);
    }
    @Then("Clic en boton iniciar sesion y muestra mensaje bloqueado {string}")
    public void clic_en_boton_iniciar_sesion_y_muestra_mensaje_bloqueado(String mensaje) throws InterruptedException, IOException {
        LoginPage loginp = new LoginPage(driver);
        String filepath = "D:\\PICHINCHA\\AUTOMATIZACION\\data\\DataLogin.xlsx";
        String searchMensaje = String.valueOf(readFile.getCellValue(filepath, "Login", Integer.parseInt(mensaje),2));
        loginp.clickInicio();
        //System.out.println("Texto usuario: " + loginp.getObtenerMensajeUsuario());
        Assert.assertEquals(loginp.getObtenerUsuarioBloqueado(),searchMensaje);
        Thread.sleep(10000);
    }

    @Then("Clic en boton iniciar sesion y muestra tarjeta bloqueado {string}")
    public void clic_en_boton_iniciar_sesion_y_muestra_tarjeta_bloqueado(String mensaje) throws InterruptedException, IOException {
        LoginPage loginp = new LoginPage(driver);
        String filepath = "D:\\PICHINCHA\\AUTOMATIZACION\\data\\DataLogin.xlsx";
        String searchMensaje = String.valueOf(readFile.getCellValue(filepath, "Login", Integer.parseInt(mensaje),2));
        loginp.clickInicio();
        //System.out.println("Texto usuario: " + loginp.getObtenerMensajeUsuario());
        Thread.sleep(10000);
    }

    @After
    public void tearDown(Scenario scenario){
        //if (scenario.isFailed())
        takeScreenshot(scenario);
        driver.quit();
    }

    private void takeScreenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png","Evidencia");
    }

}
