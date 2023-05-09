package cl.mundenius.mcsquad.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.mundenius.mcsquad.dao.rowmappers.AdminRowMapper;
import cl.mundenius.mcsquad.dao.rowmappers.UsuarioRowMapper;
import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Administrativo;
import cl.mundenius.mcsquad.modelo.Usuario;

@Repository
public class ImplAdminDao implements CRUD<Administrativo>{

	private JdbcTemplate jdbcTemp;
	
	public ImplAdminDao(DataSource ds) {
		this.jdbcTemp = new JdbcTemplate(ds);
	}
	
	/**@category Sentencias MySQL
	 * @param	Administrativo
	 * Sentencias de mySQL para tratar con los tipo de usuario que son administrativos */
	
	final String GETFORPASS 	= "SELECT * FROM usuario WHERE username = ? AND clave = ?;";
	final String GETALL 		= "SELECT u.idusuario, u.username, u.nombre, u.apellido, u.fechaNacimiento, u.clave, u.run, a.idadministrativo, a.area "
								+ "FROM usuario u "
								+ "INNER JOIN administrativo a "
								+ "ON u.run = a.rutadmin"
								+ "ORDER BY a.idadmin;";
	final String INSERT_USUARIO = "INSERT INTO usuario(username, nombre, apellido, fechanacimiento, clave, run) VALUES (?,?,?,?,?,?);";
	final String INSERT_ADMIN 	= "INSERT INTO administrativo(area, rutadmin) VALUES (?,?);";
	final String UPDATE_USUARIO = "UPDATE usuario SET username = ?, nombre = ?, apellido = ?, fechanacimiento = ?, clave = ? WHERE run = ?;";
	final String UPDATE_ADMIN 	="UPDATE administrativo SET area = ? WHERE rutadmin = ?";
	final String DELETE_ADMIN 	= "DELETE usuario, administrativo "
								+ "FROM usuario "
								+ "INNER JOIN administrativo "
								+ "ON usuario.run = administrativo.rutadmin "
								+ "WHERE usuario.run = ? AND usuario.clave = ?";
//	final String DELETE_USUARIO = "DELETE FROM usuario WHERE run = ?";

	/**@category	Metodo
	 * @param	getUserPass()
	 * Retorna un usuario, si esque la contraseña y el username son correctos
	 *  */
	@Override
	public Usuario getUserPass(String username, String pass) {
		Object[] keys = {username, pass};
		Usuario user = jdbcTemp.queryForObject(GETFORPASS, keys, new UsuarioRowMapper());
		
		return user;
	}

	/**@category	Metodo
	 * @param	mostrarUsuarios()
	 * Metodo que genera una lista de los usuarios del tipo administrativo
	 *  */
	@Override
	public List<Administrativo> mostrarUsuarios() {
		List<Administrativo> adminList = jdbcTemp.query(GETALL, new AdminRowMapper());
		return adminList;
	}

	/**@category	Metodo
	 * @param	crearUsuario()
	 * Este metodo permite crear administrativos dentro de la base de datos
	 *  */
	@Override
	public void crearUsuario(Administrativo admin) {
		Object[] usuarioParams = {admin.getUsername(), admin.getNombre(), admin.getApellido(), admin.getFechaNacimiento(), admin.getClave(), admin.getRun()};
	    jdbcTemp.update(INSERT_USUARIO, usuarioParams);
	    
	    Object[] adminParams = {admin.getArea(), admin.getRun()};
	    jdbcTemp.update(INSERT_ADMIN, adminParams);
		
	}

	/**@category	Metodo
	 * @param	editarUsuario()
	 * Con este metodo se puede actualizar o editar a los usuarios del tipo administrativo
	 *  */
	@Override
	public void editarUsuario(Administrativo admin) {
		Object[] usuarioParams = {admin.getUsername(), admin.getNombre(), admin.getApellido(), admin.getFechaNacimiento(), admin.getClave(), admin.getRun()};
	    jdbcTemp.update(UPDATE_USUARIO, usuarioParams);
	    
	    Object[] adminParams = {admin.getArea(), admin.getRun()};
	    jdbcTemp.update(UPDATE_ADMIN, adminParams);
		
	}

	
	/**@category	Metodo
	 * @param	eliminarUsuario()
	 * Permite la eliminacion del administrativo, con la condicion de que el run con la contraseña esten correctos
	 *  */
	@Override
	public void eliminarUsuario(Administrativo admin) {
		Object[] adminParams = {admin.getRun(), admin.getClave()};
		System.out.println(admin.getRun() + admin.getClave());
		jdbcTemp.update(DELETE_ADMIN, adminParams);

//		Object[] usuarioParams = {admin.getRun()};
//	    jdbcTemp.update(DELETE_USUARIO, usuarioParams);
	    
		
	}


}
