package cl.mundenius.mcsquad.interfaces;

import java.util.List;

import cl.mundenius.mcsquad.modelo.Usuario;

public interface CRUD<D> {

	/**@category	Metodo
	 * @param	getUserPass
	 * Metetodo que retorna un obejeto de Usuario, y recibe un username y una contraseña.
	 *  */
	public Usuario getUserPass(String username, String pass);
	
	/**@category	Metodos
	 * @param	CRUD
	 * Metodos que tienen las funciones del CRUD: Create, Read, Update y Delete
	 *  */
	public List<D> mostrarUsuarios();
	public void crearUsuario(D d);
	public void editarUsuario(D d);
	public void eliminarUsuario(D d);
}
