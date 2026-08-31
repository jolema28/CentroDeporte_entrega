package uy.edu.centrodeporte;

public interface ICentroDeporte {

    boolean agregarSocio(String cedula, String nombre);

    boolean eliminarSocio(String cedula);

    boolean existeSocio(String cedula);

    boolean inscribirActividad(String cedula, String actividad);

    boolean cancelarInscripcion(String cedula, String actividad);

    boolean estaInscripto(String cedula, String actividad);

    int obtenerCantidadSocios();

    int obtenerCantidadInscriptos(String actividad);
}
