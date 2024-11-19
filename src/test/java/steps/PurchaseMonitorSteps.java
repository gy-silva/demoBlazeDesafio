package steps;

import io.cucumber.java.After;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.E;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.MonitorPage;
import java.time.Duration;


public class PurchaseMonitorSteps {
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    MonitorPage monitorsPage = new MonitorPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);

    @Dado("que o usuário está na Home Page")
    public void usuarioNaPaginaInicial() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

    }

    @Quando("o usuário seleciona a categoria de Monitor")
    public void selecionarCategoriaMonitor() throws InterruptedException {
        homePage.clicarNaCategoriaMonitor();
        Thread.sleep(1000);
    }

    @E("adiciona um monitor para o carrinho")
    public void adicionarMonitorAoCarrinho() throws InterruptedException {
        monitorsPage.adicionarMonitorAoCarrinho();
        Thread.sleep(1000);
    }

    @E("usuário vai até o carrinho")
    public void irParaOCarrinho() throws InterruptedException {
        driver.get("https://www.demoblaze.com/cart.html");
        Thread.sleep(1000);
    }

    @E("faz o processo de checkout")
    public void prosseguirParaCheckout() throws InterruptedException {
        cartPage.clicarFinalizarPedido();
        Thread.sleep(1000);
    }

    @E("completa o formulário de compra")
    public void completaOFormularioDeCompra() throws InterruptedException {
        checkOutPage.preencherFormularioCompra(
                "Gisele Silva",
                "Brasil",
                "Porto Alegre",
                "1234 5678 9012 3456",
                "12",
                "2024"
        );
       Thread.sleep(1000);
       checkOutPage.clicarComprar();
       Thread.sleep(1000);
    }


    @Então("compra será bem sucedida")
    public void validarCompra() throws InterruptedException {
        Thread.sleep(2000);
        try {
            boolean compraBemSucedida = driver.getPageSource().contains("Thank you for your purchase!");
            Assertions.assertTrue(compraBemSucedida, "A compra foi bem-sucedida, a mensagem foi encontrada.");
            System.out.println("A compra foi validada com sucesso.");
        } catch (AssertionError e) {
            System.err.println("Erro de validação: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado ao validar a compra: " + e.getMessage());
            throw new RuntimeException("Erro durante a validação da compra", e);
        }

    }

    @After
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }

}
}
