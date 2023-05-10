package cl.mundenius.mcsquad.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class TestUsuario {

    @Test
    public void testUsuarioConstructorAndGetters() {
        int idUsuario = 1;
        String username = "test";
        String nombre = "William";
        String apellido = "Shakespeare";
        String fechaNacimiento = "23/04/1564";
        String clave = "password";
        String run = "12345678-9";
        Usuario usuario = new Usuario(idUsuario, username, nombre, apellido, fechaNacimiento, clave, run);

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
        Usuario usuario = new Usuario();

        int idUsuario = 1;
        String username = "test";
        String nombre = "William";
        String apellido = "Shakespeare";
        String fechaNacimiento = "23/04/1564";
        String clave = "password";
        String run = "12345678-9";
        usuario.setIdUsuario(idUsuario);
        usuario.setUsername(username);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setClave(clave);
        usuario.setRun(run);

        assertEquals(idUsuario, usuario.getIdUsuario());
        assertEquals(username, usuario.getUsername());
        assertEquals(nombre, usuario.getNombre());
        assertEquals(apellido, usuario.getApellido());
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
        assertEquals(clave, usuario.getClave());
        assertEquals(run, usuario.getRun());
}


}
