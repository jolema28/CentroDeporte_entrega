package uy.edu.centrodeporte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CentroDeporte implements ICentroDeporte {

    private final Map<String, String> socios = new HashMap<>();
    private final Map<String, Set<String>> inscripcionesPorActividad = new HashMap<>();

    @Override
    public boolean agregarSocio(String cedula, String nombre) {
        if (esTextoVacio(cedula) || esTextoVacio(nombre) || socios.containsKey(cedula)) {
            return false;
        }

        socios.put(cedula, nombre);
        return true;
    }

    @Override
    public boolean eliminarSocio(String cedula) {
        if (!socios.containsKey(cedula)) {
            return false;
        }

        socios.remove(cedula);
        for (Set<String> inscriptos : inscripcionesPorActividad.values()) {
            inscriptos.remove(cedula);
        }
        return true;
    }

    @Override
    public boolean existeSocio(String cedula) {
        return socios.containsKey(cedula);
    }

    @Override
    public boolean inscribirActividad(String cedula, String actividad) {
        if (!socios.containsKey(cedula) || esTextoVacio(actividad)) {
            return false;
        }

        Set<String> inscriptos = inscripcionesPorActividad.computeIfAbsent(actividad, clave -> new HashSet<>());
        return inscriptos.add(cedula);
    }

    @Override
    public boolean cancelarInscripcion(String cedula, String actividad) {
        if (esTextoVacio(actividad) || !inscripcionesPorActividad.containsKey(actividad)) {
            return false;
        }

        return inscripcionesPorActividad.get(actividad).remove(cedula);
    }

    @Override
    public boolean estaInscripto(String cedula, String actividad) {
        if (esTextoVacio(actividad) || !inscripcionesPorActividad.containsKey(actividad)) {
            return false;
        }

        return inscripcionesPorActividad.get(actividad).contains(cedula);
    }

    @Override
    public int obtenerCantidadSocios() {
        return socios.size();
    }

    @Override
    public int obtenerCantidadInscriptos(String actividad) {
        if (esTextoVacio(actividad) || !inscripcionesPorActividad.containsKey(actividad)) {
            return 0;
        }

        return inscripcionesPorActividad.get(actividad).size();
    }

    private boolean esTextoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
