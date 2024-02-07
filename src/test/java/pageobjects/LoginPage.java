package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver browser) {
        driver = browser;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // Locators
    // prueba subida

    @FindBy(id = "user")
    private WebElement txtUser;
    @FindBy(id = "digital-key")
    private WebElement txtPassword;
    @FindBy(css = "button[class='button__type--primary button__type--primary--fill button__size--md button__width--full']")
    private WebElement btnIniciar;
    @FindBy(css = "div[class='text --small --alert']")
    private WebElement lblMensajeValidacion;
    @FindBy(css = "h3[class='title-user-blocked']")
    private WebElement lblUsuarioBloqueado;
    @FindBy(css = "h2[class='user-name']")
    private WebElement lblUsariologueado;

    // Actions

    public void writeUsuario(String textoUsu) {
        wait.until(ExpectedConditions.elementToBeClickable(txtUser)).sendKeys(textoUsu);
    }
    public void writePassword(String letra){
        WebElement btnNumero = driver.findElement(By.xpath("//button[@class='button-number']//label[@class='label-button-number'][text()='"+ letra+"']"));
        wait.until(ExpectedConditions.elementToBeClickable(btnNumero)).click();
    }
    public void clickPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).click();
    }
    public void clickInicio() {
        wait.until(ExpectedConditions.elementToBeClickable(btnIniciar)).click();
    }
    public String getObtenerMensajeValidacion (){
        return wait.until(ExpectedConditions.elementToBeClickable(lblMensajeValidacion)).getText().trim();
    }
    public String getObtenerUsuarioLogueado (){
        return wait.until(ExpectedConditions.elementToBeClickable(lblUsariologueado)).getText().trim();
    }
    public String getObtenerUsuarioBloqueado(){
        return wait.until(ExpectedConditions.elementToBeClickable(lblUsuarioBloqueado)).getText().trim();
    }

}
