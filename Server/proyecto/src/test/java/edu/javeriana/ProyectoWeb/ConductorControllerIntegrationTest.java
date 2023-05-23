package edu.javeriana.ProyectoWeb;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertNotNull; 
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import edu.javeriana.ProyectoWeb.model.entity.Conductor;
import edu.javeriana.ProyectoWeb.model.repository.ConductorRepository;


// mvn test -Dtest=ConductorControllerIntegrationTest
@ActiveProfiles("integrationtest") // perfil que se activa a la hora de ejecutar la prueba
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)//limpia la base de datos antes de ejectuar alguna prueba, para que otra prueba no afecte otra prueba
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // no hayan problemas de puerto
public class ConductorControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    ConductorRepository conductorRepository;

    @BeforeEach
    void init() {
        conductorRepository.save(new Conductor("Sebastian Galeano", 123456, 890123, "Puente AV Boyaca"));
        conductorRepository.save(new Conductor("Anderson Alvarado", 234567, 901234, "Cra 50 #100-12"));
        conductorRepository.save(new Conductor("Jaime Pavlich", 456789, 234567, "Cra 164 #15-62"));
    }

    @Autowired
    private TestRestTemplate rest;

    // mvn test -Dtest=ConductorControllerIntegrationTest#verConductor
    //Prueba Get
    @Test
    void verConductor() throws Exception {
        //getforObject parametros: url, tipo de dato que se espera recibir como resultado
        Conductor conductorExistente = rest.getForObject("http://localhost:" + port + "/conductor/read/1", Conductor.class);
        //System.out.println(conductorExistente.toString());

        // comparar lo que esperamos recibir con lo que recibimos.
        Conductor conductorEsperado = new Conductor("Sebastian Galeano", 123456, 890123, "Puente AV Boyaca");
        assertTrue(conductorEsperado.equals(conductorExistente));
        //assertEquals(conductorExistente, conductorEsperado);
    }

    // mvn test -Dtest=ConductorControllerIntegrationTest#crearConductor
    //Prueba Post
    @Test
    void crearConductor() throws Exception {
        // Crear un objeto Conductor para la nueva entidad
        Conductor nuevoConductor = new Conductor("Kenan Jarrus", 124223, 85454,"Cra 1 Lothal");

        // Hacer la solicitud POST al endpoint correspondiente
        String url = "http://localhost:" + port + "/conductor/create";
        ResponseEntity<Conductor> response = rest.postForEntity(url, nuevoConductor, Conductor.class);

        // Verificar el código de respuesta y obtener el cuerpo de la respuesta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Conductor conductorCreado = response.getBody();

        // Verificar que el conductor haya sido creado correctamente
        assertNotNull(conductorCreado);
        assertNotNull(conductorCreado.getId());
        assertTrue(nuevoConductor.equals(conductorCreado));
    }

    // mvn test -Dtest=ConductorControllerIntegrationTest#actualizarConductor
    //Prueba Put
    @Test
    void actualizarConductor() throws Exception{
        //conductor Existente en la base de datos
        Conductor conductorExistente = rest.getForObject("http://localhost:" + port + "/conductor/read/3", Conductor.class);
        
        // Crear un objeto Conductor con los datos actualizados
        Conductor conductorActualizado = new Conductor();
        conductorActualizado.setId(conductorExistente.getId());
        conductorActualizado.setNombre("Jaime Pavlich Actualizado");
        conductorActualizado.setCedula(123456);
        conductorActualizado.setTelefono(987654);
        conductorActualizado.setDireccion("Avenida 456");

        rest.put("http://localhost:" + port + "/conductor/update/", 
                 conductorActualizado);
        
        // Obtener el objeto Conductor actualizado de la base de datos
        Conductor conductorActual = rest.getForObject("http://localhost:" + port + "/conductor/read/3", Conductor.class);

        // Verificar que los datos se hayan actualizado correctamente
        //assertNotNull(conductorActualizado);
        assertTrue(conductorActualizado.equals(conductorActual));
    }
    
    // mvn test -Dtest=ConductorControllerIntegrationTest#eliminarConductor
    //Prueba Delete
    @Test
    void eliminarConductor() throws Exception{
         
        Conductor conductorEliminado = rest.getForObject("http://localhost:" + port + "/conductor/read/1", Conductor.class);
        rest.delete("http://localhost:" + port + "/conductor/delete/1"); 

        // Verificar que el conductor haya sido eliminado correctamente
        assertFalse(conductorRepository.existsById(conductorEliminado.getId()));
    }
}