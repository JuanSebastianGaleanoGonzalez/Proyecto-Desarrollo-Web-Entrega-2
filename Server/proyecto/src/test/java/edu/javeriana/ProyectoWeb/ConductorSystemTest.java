package edu.javeriana.proyectoWeb;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
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

    private void conductorDebeSer(long id) {
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

    @AfterEach //despues de ejecutar las pruebas
    void end() {
        // driver.close();
        browser.quit(); //cerrar el browser
    }

    //comprobar que el conductor que se muestra es el indicado
    @Test 
    void verConductor() {
        long id = 1;
        conductorDebeSer(id);
    }  

    //editar conductor, nombre y cedula.
    @Test
    void editarConductor() {
        
        long id = 1;
        browser.get(baseUrl + "/conductor/update/" + id);
        
        //esperar a que se ejecute la condicion del expectedConditions, que exista el id nombre en la plantilla
        WebElement nombreObtenido = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombre")));
        //esperar a que se ejecute la condicion del expectedConditions, que exista el id cedula en la plantilla
        WebElement cedulaObtenida = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));

        //si se cumple se ejecuta:
        //en las casillas de la plantilla txtCantidad:

        // borra lo que ya esté
        nombreObtenido.sendKeys(Keys.BACK_SPACE); 
        cedulaObtenida.sendKeys(Keys.BACK_SPACE); 

        // enviar nuevos valores
        nombreObtenido.sendKeys("Darth Vader");
        cedulaObtenida.sendKeys("1003");  

        // simular el botón Actualizar
        WebElement btnActualizar = browser.findElementById("btnActualizar");

        //simular el click al boton
        btnActualizar.click(); 
        
        conductorDebeSer(id);
    }

    //crear conductor, nombre y cedula.
    @Test
    void crearConductor() {
        browser.get(baseUrl + "/conductor/create");
        
        //esperar a que se ejecute la condicion del expectedConditions, que existan los id's en la plantilla
        WebElement nombreCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombre")));
        WebElement cedulaCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
        WebElement telefonoCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("telefono")));
        WebElement direccionCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("direccion")));
        
        //si se cumple se ejecuta:
        //en las casillas de la plantilla txtCantidad:

        // enviar nuevos valores
        nombreCrear.sendKeys("Grogu");
        cedulaCrear.sendKeys("69");
        telefonoCrear.sendKeys("666"); 
        direccionCrear.sendKeys("Calle 19"); 

        // simular el botón Crear
        WebElement btnCrear = browser.findElementById("btnCrear");

        //simular el click al boton
        btnCrear.click();

        conductorDebeSer(4);
    }

    //Ver la lista de Conductores
    @Test
    void listConductores() {
        browser.get(baseUrl + "/conductor/list");

        //esperar hasta que haya 3 elementos
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("classCedula"), 3));
        List<Conductor> conductoresEsperados = (List<Conductor>) conductorRepository.findAll();
        List<WebElement> conductoresCedula = browser.findElementsByClassName("classCedula");
        assertEquals(conductoresEsperados.size(), conductoresCedula.size());
        
        for (int i = 0; i < conductoresEsperados.size(); i++) {
            assertEquals(String.valueOf(conductoresEsperados.get(i).getCedula()),
            conductoresCedula.get(i).getText());
        }
    }
}