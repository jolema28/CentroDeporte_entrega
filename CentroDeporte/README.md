# Centro de Deporte - Tests JUnit

Proyecto Java de nivel principiante para practicar pruebas unitarias con JUnit 5 y cobertura con JaCoCo.

## Como crear una prueba JUnit

1. Crear una clase dentro de `src/test/java`.
2. Importar `org.junit.jupiter.api.Test`.
3. Crear un metodo con la anotacion `@Test`.
4. Preparar los datos, ejecutar el metodo que se quiere probar y verificar el resultado con un `assert`.

Ejemplo:

```java
@Test
void agregarSocioCuandoNoExisteDebeRetornarTrue() {
    boolean resultado = centroDeporte.agregarSocio("87654321", "Luis Gomez");

    assertTrue(resultado);
}
```

## Anotaciones usadas

- `@Test`: marca un metodo como caso de prueba.
- `@BeforeAll`: se ejecuta una sola vez antes de todos los tests.
- `@AfterAll`: se ejecuta una sola vez despues de todos los tests.
- `@BeforeEach`: se ejecuta antes de cada test. En este proyecto crea un centro deportivo nuevo y agrega un socio base.
- `@AfterEach`: se ejecuta despues de cada test. En este proyecto limpia la variable usada por el test.

## Metodos probados

La clase `CentroDeporteTest` tiene un caso de prueba para cada metodo de la interfaz `ICentroDeporte`:

- `agregarSocio`
- `eliminarSocio`
- `existeSocio`
- `inscribirActividad`
- `cancelarInscripcion`
- `estaInscripto`
- `obtenerCantidadSocios`
- `obtenerCantidadInscriptos`

## Como ejecutar las pruebas

Desde la carpeta del proyecto:

```bash
mvn test
```

## Como ver la cobertura JaCoCo

Luego de ejecutar los tests, abrir este archivo en el navegador:

```text
target/site/jacoco/index.html
```

Tambien se puede generar con:

```bash
mvn test jacoco:report
```

## Resultado obtenido

Se ejecuto el comando:

```bash
mvn test jacoco:report
```

Resultado:

- Tests ejecutados: 16
- Fallas: 0
- Errores: 0
- Tests omitidos: 0
- Cobertura de lineas JaCoCo: 28 de 30 lineas, aproximadamente 93%
