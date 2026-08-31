package uy.edu.centrodeporte;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CentroDeporteTest {

    private CentroDeporte centroDeporte;

    @BeforeAll
    static void antesDeTodosLosTests() {
        System.out.println("Comienza la ejecucion de los tests de CentroDeporte");
    }

    @AfterAll
    static void despuesDeTodosLosTests() {
        System.out.println("Finaliza la ejecucion de los tests de CentroDeporte");
    }

    @BeforeEach
    void antesDeCadaTest() {
        centroDeporte = new CentroDeporte();
        centroDeporte.agregarSocio("12345678", "Ana Perez");
    }

    @AfterEach
    void despuesDeCadaTest() {
        centroDeporte = null;
    }

    @Test
    void agregarSocioCuandoNoExisteDebeRetornarTrue() {
        boolean resultado = centroDeporte.agregarSocio("87654321", "Luis Gomez");

        assertTrue(resultado);
        assertEquals(2, centroDeporte.obtenerCantidadSocios());
    }

    @Test
    void agregarSocioDuplicadoDebeRetornarFalse() {
        boolean resultado = centroDeporte.agregarSocio("12345678", "Ana Perez");

        assertFalse(resultado);
        assertEquals(1, centroDeporte.obtenerCantidadSocios());
    }

    @Test
    void agregarSocioConDatosVaciosDebeRetornarFalse() {
        boolean resultadoCedulaVacia = centroDeporte.agregarSocio(" ", "Pedro Suarez");
        boolean resultadoNombreVacio = centroDeporte.agregarSocio("44444444", "");

        assertFalse(resultadoCedulaVacia);
        assertFalse(resultadoNombreVacio);
        assertEquals(1, centroDeporte.obtenerCantidadSocios());
    }

    @Test
    void eliminarSocioCuandoExisteDebeRetornarTrue() {
        boolean resultado = centroDeporte.eliminarSocio("12345678");

        assertTrue(resultado);
        assertFalse(centroDeporte.existeSocio("12345678"));
    }

    @Test
    void eliminarSocioCuandoNoExisteDebeRetornarFalse() {
        boolean resultado = centroDeporte.eliminarSocio("99999999");

        assertFalse(resultado);
        assertEquals(1, centroDeporte.obtenerCantidadSocios());
    }

    @Test
    void existeSocioCuandoFueAgregadoDebeRetornarTrue() {
        boolean resultado = centroDeporte.existeSocio("12345678");

        assertTrue(resultado);
    }

    @Test
    void inscribirActividadConSocioExistenteDebeRetornarTrue() {
        boolean resultado = centroDeporte.inscribirActividad("12345678", "Natacion");

        assertTrue(resultado);
        assertTrue(centroDeporte.estaInscripto("12345678", "Natacion"));
    }

    @Test
    void inscribirActividadConSocioInexistenteDebeRetornarFalse() {
        boolean resultado = centroDeporte.inscribirActividad("99999999", "Natacion");

        assertFalse(resultado);
        assertEquals(0, centroDeporte.obtenerCantidadInscriptos("Natacion"));
    }

    @Test
    void inscribirActividadDuplicadaDebeRetornarFalse() {
        centroDeporte.inscribirActividad("12345678", "Natacion");

        boolean resultado = centroDeporte.inscribirActividad("12345678", "Natacion");

        assertFalse(resultado);
        assertEquals(1, centroDeporte.obtenerCantidadInscriptos("Natacion"));
    }

    @Test
    void cancelarInscripcionCuandoExisteDebeRetornarTrue() {
        centroDeporte.inscribirActividad("12345678", "Futbol");

        boolean resultado = centroDeporte.cancelarInscripcion("12345678", "Futbol");

        assertTrue(resultado);
        assertFalse(centroDeporte.estaInscripto("12345678", "Futbol"));
    }

    @Test
    void cancelarInscripcionCuandoNoExisteDebeRetornarFalse() {
        boolean resultado = centroDeporte.cancelarInscripcion("12345678", "Tenis");

        assertFalse(resultado);
    }

    @Test
    void estaInscriptoCuandoSocioEstaEnActividadDebeRetornarTrue() {
        centroDeporte.inscribirActividad("12345678", "Basquetbol");

        boolean resultado = centroDeporte.estaInscripto("12345678", "Basquetbol");

        assertTrue(resultado);
    }

    @Test
    void estaInscriptoCuandoActividadNoExisteDebeRetornarFalse() {
        boolean resultado = centroDeporte.estaInscripto("12345678", "Handball");

        assertFalse(resultado);
    }

    @Test
    void obtenerCantidadSociosDebeRetornarTotalDeSocios() {
        centroDeporte.agregarSocio("22222222", "Maria Rodriguez");
        centroDeporte.agregarSocio("33333333", "Carlos Silva");

        int cantidad = centroDeporte.obtenerCantidadSocios();

        assertEquals(3, cantidad);
    }

    @Test
    void obtenerCantidadInscriptosDebeRetornarTotalPorActividad() {
        centroDeporte.agregarSocio("22222222", "Maria Rodriguez");
        centroDeporte.inscribirActividad("12345678", "Yoga");
        centroDeporte.inscribirActividad("22222222", "Yoga");

        int cantidad = centroDeporte.obtenerCantidadInscriptos("Yoga");

        assertEquals(2, cantidad);
    }

    @Test
    void obtenerCantidadInscriptosDeActividadInexistenteDebeRetornarCero() {
        int cantidad = centroDeporte.obtenerCantidadInscriptos("Pilates");

        assertEquals(0, cantidad);
    }
}
