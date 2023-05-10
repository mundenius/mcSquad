package cl.mundenius.mcsquad.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class TestUsuario {

    @Test
    public void testUsuarioConstructorAndGetters() {
        // Crea un objeto Usuario de prueba
        int idUsuario = 1;
        String username = "test";
        String nombre = "John";
        String apellido = "Doe";
        String fechaNacimiento = "01/01/2000";
        String clave = "password";
        String run = "12345678-9";
        Usuario usuario = new Usuario(idUsuario, username, nombre, apellido, fechaNacimiento, clave, run);

        // Verifica que los valores se hayan establecido correctamente mediante los getters
        assertEquals(idUsuario, usuario.getIdUsuario());
        assertEquals(username, usuario.getUsername());
        assertEquals(nombre, usuario.getNombre());
        assertEquals(apellido, usuario.getApellido());
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
        assertEquals(clave, usuario.getClave());
        assertEquals(run, usuario.getRun());
    }

    @Test
    public void testUsuarioSetters() {
        // Crea un objeto Usuario de prueba
        Usuario usuario = new Usuario();

        // Establece valores de prueba mediante los setters
        int idUsuario = 1;
        String username = "test";
        String nombre = "John";
        String apellido = "Doe";
        String fechaNacimiento = "01/01/2000";
        String clave = "password";
        String run = "12345678-9";
        usuario.setIdUsuario(idUsuario);
        usuario.setUsername(username);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setClave(clave);
        usuario.setRun(run);

        // Verifica que los valores se hayan establecido correctamente mediante los getters
        assertEquals(idUsuario, usuario.getIdUsuario());
        assertEquals(username, usuario.getUsername());
        assertEquals(nombre, usuario.getNombre());
        assertEquals(apellido, usuario.getApellido());
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
        assertEquals(clave, usuario.getClave());
        assertEquals(run, usuario.getRun());
}


}
