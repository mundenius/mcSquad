/**@author mundenius */
package cl.mundenius.mcsquad.modelo;

/**@category	Clase
 * @param	Usuario
 * Clase Usuario, contiene todos los atributos que se necesitan recibir en la base de datos
 *  */
public class Usuario {
	
	private int idUsuario;
	private String username;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String clave;
	private String run;
	
	public Usuario() {
		
	}
	
	public Usuario(int idUsuario, String username, String nombre, String apellido, String fechaNacimiento, String clave, String run) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.clave = clave;
		this.run = run;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}
	
	
	
}
