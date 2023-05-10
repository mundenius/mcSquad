/**@author mundenius */
package cl.mundenius.mcsquad.modelo;

/**@category	Clase
 * @param	Administrativo
 * Clase Administrativo, contiene todos los atributos que se necesitan recibir en la base de datos */
public class Administrativo extends Usuario{

	private int idAdmin;
	private String area;
	
	public Administrativo() {
		
	}
	
	public Administrativo(int idUsuario, String username, String nombre, String apellido, String fechaNacimiento, String clave, String run, int idAdmin, String area) {
		super(idUsuario,username,nombre,apellido,fechaNacimiento,clave,run);
		this.idAdmin = idAdmin;
		this.area = area;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
