package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    private static WebDriver driver;

    @FindBy(xpath = "//input[@id='name']")
    public static WebElement Camponome;

    @FindBy(xpath = "//input[@id='country']")
    public static WebElement CampoPais;

    @FindBy(xpath = "//input[@id='city']")
    public static WebElement CampoCidade;

    @FindBy(xpath = "//input[@id='card']")
    public static WebElement CartaoCredito;

    @FindBy(xpath = "//input[@id='month']")
    public static WebElement mes;

    @FindBy(xpath = "//input[@id='year']")
    public static WebElement ano;

    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    public static WebElement botaoComprar;

      public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void preencherFormularioCompra(String nome, String pais, String cidade, String cartao, String mesExpiracao, String anoExpiracao) {
        Camponome.sendKeys(nome);
        CampoPais.sendKeys(pais);
        CampoCidade.sendKeys(cidade);
        CartaoCredito.sendKeys(cartao);
        mes.sendKeys(mesExpiracao);
        ano.sendKeys(anoExpiracao);
    }

    public static void clicarComprar() {
       botaoComprar.click();
    }
}
