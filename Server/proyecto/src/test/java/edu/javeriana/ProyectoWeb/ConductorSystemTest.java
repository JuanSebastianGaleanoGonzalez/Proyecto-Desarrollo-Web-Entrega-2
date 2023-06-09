package edu.javeriana.ProyectoWeb;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.time.Duration;
import org.springframework.core.io.ClassPathResource;

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
        System.setProperty("webdriver.chrome.driver", new ClassPathResource("src/main/resources/chromedriver.exe").getPath());
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        
        this.browser = new ChromeDriver(options);// instanciar browser con las opciones
        this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        
        Conductor conductor1 = new Conductor("Sebastian Galeano", 123456, 890123, "Puente AV Boyaca");

        Conductor conductor2 = new Conductor("Anderson Alvarado", 234567, 901234, "Cra 50 #100-12");
        
        Conductor conductor3 = new Conductor("Jaime Pavlich", 456789, 234567, "Cra 164 #15-62");

        conductorRepository.save(conductor1);
        conductorRepository.save(conductor2);
        conductorRepository.save(conductor3);

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
        // browser.close();
        browser.quit(); //cerrar el browser
    }

    //mvn test -Dtest=ConductorSystemTest#verConductor
    //comprobar que el conductor que se muestra es el indicado
    @Test 
    void verConductor() {
        long id = 1;
        conductorDebeSer(id);
    }  

    //mvn test -Dtest=ConductorSystemTest#editarConductor
    //editar conductor, nombre y cedula.
    @Test
    void editarConductor() {
        JavascriptExecutor js = ((JavascriptExecutor) browser);
        long id = 1;
        browser.get(baseUrl + "/conductor/update/" + id);
        
            //esperar a que se ejecute la condicion del expectedConditions, que exista el id nombre en la plantilla
            WebElement nombreObtenido = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombre")));
            //esperar a que se ejecute la condicion del expectedConditions, que exista el id cedula en la plantilla
            WebElement cedulaObtenida = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnActualizar")));
            
            //si se cumple se ejecuta:
            //en las casillas de la plantilla:
            // borra lo que ya esté
            nombreObtenido.sendKeys(Keys.BACK_SPACE);
            cedulaObtenida.sendKeys(Keys.BACK_SPACE); 

            // enviar nuevos valores
            nombreObtenido.sendKeys("Darth Vader");
            cedulaObtenida.sendKeys("1003");  

            // simular el botón Actualizar 
            WebElement btnActualizar = browser.findElement(By.id("btnActualizar"));

            //simular el click al boton
            //btnActualizar.click(); 
            js.executeScript("arguments[0].scrollIntoView(true);", btnActualizar);
        
        conductorDebeSer(id);
    }

    //mvn test -Dtest=ConductorSystemTest#crearConductor
    //crear conductor, nombre y cedula.
    @Test
    void crearConductor() {
        
        browser.get(baseUrl + "/conductor/list/create");
        JavascriptExecutor js = ((JavascriptExecutor) browser);

        //esperar a que se ejecute la condicion del expectedConditions, que existan los id's en la plantilla
        WebElement nombreCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nombre")));
        WebElement cedulaCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cedula")));
        WebElement telefonoCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("telefono")));
        WebElement direccionCrear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("direccion")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCrear")));
        //si se cumple se ejecuta:
        //en las casillas de la plantilla:

        // enviar nuevos valores
        nombreCrear.sendKeys("Grogu");
        cedulaCrear.sendKeys("69");
        telefonoCrear.sendKeys("666"); 
        direccionCrear.sendKeys("Calle 19"); 

        // simular el botón Crear
        //WebElement btnCrear = browser.findElementById("btnCrear");
        WebElement btnCrear = browser.findElement(By.id("btnCrear"));

        //simular el click al boton
        js.executeScript("arguments[0].scrollIntoView(true);", btnCrear);
        //Conductor conductor = conductorRepository.findById((long)4).orElseThrow();
        
        conductorDebeSer((long)4);
    }

    //mvn test -Dtest=ConductorSystemTest#listConductores
    //Ver la lista de Conductores
    @Test
    void listConductores() {
        browser.get(baseUrl + "/conductor/list");

        //esperar hasta que haya 3 elementos
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("classCedula"), 3));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("classNombre"), 3));

        List<Conductor> conductoresEsperados = (List<Conductor>) conductorRepository.findAll();

        // Obtiene los elementos de nombre y cédula de los conductores en la página web
        List<WebElement> nombres = browser.findElements(By.className("classNombre"));
        List<WebElement> cedulas = browser.findElements(By.className("classCedula"));
        
        // Verifica que el número de elementos coincida
        assertEquals(conductoresEsperados.size(), nombres.size());
        assertEquals(conductoresEsperados.size(), cedulas.size());

        // Itera sobre los elementos y compara los nombres y cédulas con los conductores esperados
       for (int i = 0; i < conductoresEsperados.size(); i++) {
            Conductor conductorEsperado = conductoresEsperados.get(i);
            String nombreEsperado = conductorEsperado.getNombre();
            String cedulaEsperada = String.valueOf(conductorEsperado.getCedula());

            assertEquals(nombreEsperado, nombres.get(i).getText());
            assertEquals(cedulaEsperada, cedulas.get(i).getText());
        }
    }
}