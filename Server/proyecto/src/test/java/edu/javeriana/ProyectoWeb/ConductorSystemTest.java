package edu.javeriana.proyectoWeb;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import edu.javeriana.ProyectoWeb.model.repository.ConductorRepository;
import edu.javeriana.ProyectoWeb.model.entity.Conductor;

@ActiveProfiles("systemtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT) // puerto definido en el perfil 
public class ConductorSystemTest {

    private ChromeDriver browser; // abre el navegador y simula el usuario
    private WebDriverWait wait; //maneja el timeing en la simulacion

    @Autowired
    ConductorRepository conductorRepository;

    private String baseUrl; //url que se va a conectar

    @BeforeEach
    void init() {
        conductorRepository.save(new Conductor("Sebastian Galeano", 123456, 890123, "Puente AV Boyaca"));
        conductorRepository.save(new Conductor("Anderson Alvarado", 234567, 901234, "Cra 50 #100-12"));
        conductorRepository.save(new Conductor("Jaime Pavlich", 456789, 234567, "Cra 164 #15-62"));

        ChromeOptions options = new ChromeOptions(); // abre una instancia de chrome
        options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
        // options.addArguments("--headless"); // To hide Chrome window,no abre la ventana de chrome
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-extensions"); // disabling extensions
        // options.setExperimentalOption("useAutomationExtension", false);
        // options.addArguments("start-maximized"); // open Browser in maximized mode
        // options.addArguments("disable-infobars"); // disabling infobars
        // options.addArguments("--disable-dev-shm-usage"); // overcome limited resource
        // problems
       // options.merge(DesiredCapabilities.chrome());// opciones por defecto del browser

        this.browser = new ChromeDriver(options);// instanciar browser con las opciones

        //this.wait = new WebDriverWait(browser, 5); // browser y le pasan los segundos

        this.baseUrl = "http://localhost:4200";
    }

    private void saldoDebeSer(String saldo) {
        String textoSaldoEsperado = String.format("Saldo: %s", saldo);
        WebElement liCuentaSaldo = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("liCuentaSaldo")));
        try {
            // comprueba que lo que está en la casilla liCuentaSaldo sea igual al textoSaldoEsperado, si no hay un timeout y salta excepcion
            wait.until(ExpectedConditions.textToBePresentInElement(liCuentaSaldo, textoSaldoEsperado));
        } catch (TimeoutException e) {
            fail("Could not find " + textoSaldoEsperado + ", instead found " + liCuentaSaldo.getText(), e);
        }
    }

    @AfterEach //despues de ejecutar las pruebas
    void end() {
        // driver.close();
        browser.quit(); //cerrar el browser
    }

    //comprobar que el conductor que se muestra es el indicado
    @Test 
    void verConductor() {
        long id = 1;
        Conductor conductor = conductorRepository.findById(id).orElseThrow();
        browser.get(baseUrl + "/conductor/view/" + id);
        
        WebElement nombreObtenido = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("conductorNombre")));
        WebElement cedulaObtenida = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("conductorCedula")));
        WebElement telefonoObtenido = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("conductorTelefono")));
        WebElement direccionObtenida = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("conductorDireccion")));
        try {
            // comprobar lo que está en cada casilla
            wait.until(ExpectedConditions.textToBePresentInElement(nombreObtenido, conductor.getNombre()));
            wait.until(ExpectedConditions.textToBePresentInElement(cedulaObtenida, String.valueOf(conductor.getCedula())));
            wait.until(ExpectedConditions.textToBePresentInElement(telefonoObtenido, String.valueOf(conductor.getTelefono())));
            wait.until(ExpectedConditions.textToBePresentInElement(direccionObtenida, conductor.getDireccion()));
        } catch (TimeoutException e) {
            fail("Valores no encontrados ", e);
        }
    }

    @Test
    void retirar() {
        browser.get(baseUrl + "/cuenta/1");
        //esperar a que se ejecute la condicion del expectedConditions, que exista el id txtCantidad en la plantilla
        WebElement txtCantidad = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtCantidad")));

        //si se cumple se ejecuta:
        //en la casilla de la plantilla txtCantidad:
        txtCantidad.sendKeys(Keys.BACK_SPACE); // borra lo que ya esté
        txtCantidad.sendKeys("500"); // enviar cualquier string

       // WebElement btnRetirar = browser.findElementById("btnRetirar"); // simular el botón retirar
       // btnRetirar.click(); //simular el click al boton

        saldoDebeSer("5,500.00");
    }

    @Test
    void abonar() {
        browser.get(baseUrl + "/cuenta/1");
        WebElement txtCantidad = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtCantidad")));
        txtCantidad.sendKeys(Keys.CONTROL + "a");
        txtCantidad.sendKeys("500");
      //  WebElement btnAbonar = browser.findElementById("btnAbonar");
      //  btnAbonar.click();
        saldoDebeSer("6,500.00");
    }
}
