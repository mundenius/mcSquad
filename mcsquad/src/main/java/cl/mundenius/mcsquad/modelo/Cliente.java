/**@author mundenius */
package cl.mundenius.mcsquad.modelo;


/**@category	Clase
 * @param	Cliente
 * Clase Cliente, contiene todos los atributos que se necesitan recibir en la base de datos */
public class Cliente extends Usuario{

	private int idCliente;
	private String telefono;
	private String email;
	
	public Cliente() {
		
	}
	
	public Cliente(int idUsuario, String username, String nombre, String apellido, String fechaNacimiento,String clave, String run, int idCliente, String telefono, String email) {
		super(idUsuario,username,nombre,apellido,fechaNacimiento,clave,run);
		this.idCliente = idCliente;
		this.telefono = telefono;
		this.email = email;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
