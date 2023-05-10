/**@author mundenius */
package cl.mundenius.mcsquad.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.mundenius.mcsquad.dao.rowmappers.UsuarioRowMapper;
import cl.mundenius.mcsquad.dao.rowmappers.ClienteRowMapper;
import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Cliente;
import cl.mundenius.mcsquad.modelo.Usuario;


/**@category	Implementacion DAO
 * @param	Cliente */
@Repository
public class ImplClienteDao implements CRUD<Cliente> {

	private JdbcTemplate jdbcTemp;

	public ImplClienteDao(DataSource ds) {
		this.jdbcTemp = new JdbcTemplate(ds);
	}

	/**@category Sentencias MySQL
	 * @param	CLIENTE
	 * Sentencias necesarias para tratar con los usuarios del tipo cliente*/
	final String GETFORPASS 	= "SELECT * FROM usuario WHERE username = ? AND clave = ?;";
	final String GETALL 		= "SELECT u.idusuario, u.username, u.nombre, u.apellido, u.fechaNacimiento, u.clave, u.run, c.idcliente, c.telefono, c.email "
								+ "FROM usuario u "
								+ "INNER JOIN cliente c "
								+ "ON u.run = c.rutcliente";
	final String INSERT_USUARIO = "INSERT INTO usuario(username, nombre, apellido, fechanacimiento, clave, run) VALUES (?,?,?,?,?,?);";
	final String INSERT_CLIENTE = "INSERT INTO cliente(telefono, email, rutcliente) VALUES (?,?,?);";
	final String UPDATE_USUARIO = "UPDATE usuario SET username = ?, nombre = ?, apellido = ?, fechanacimiento = ?, clave = ? WHERE run = ?;";
	final String UPDATE_CLIENTE = "UPDATE cliente SET telefono = ?, email = ? WHERE rutcliente = ?";
	final String DELETE_CLIENTE = "DELETE usuario, cliente " 
								+ "FROM usuario " 
								+ "INNER JOIN cliente "
								+ "ON usuario.run = cliente.rutcliente " 
								+ "WHERE usuario.run = ? AND usuario.clave = ?;";
	// final String DELETE_USUARIO = "DELETE FROM usuario WHERE run = ?";

	/**@category	Metodo
	 * @param	getUSerPass()
	 * Metodo que retorna un usuario, si esque la contraseña y el nombre de usuario son correctos.
	 *  */
	@Override
	public Usuario getUserPass(String username, String pass) {
		String sql = "SELECT * FROM usuario WHERE username = ? AND clave = ?;";
		Object[] keys = { username, pass };
		Usuario user = jdbcTemp.queryForObject(sql, keys, new UsuarioRowMapper());

		return user;
	}

	/**@category	Metodo
	 * @param	mostrarUsuarios()
	 * Retorna una lista de Clientes
	 *  */
	@Override
	public List<Cliente> mostrarUsuarios() {
		List<Cliente> cliList = jdbcTemp.query(GETALL, new ClienteRowMapper());
		return cliList;
	}

	/**@category	Metodo
	 * @param	crearUsuario()
	 * Con este metodo se crear usuarios del tipo cliente en la base de datos
	 *  */
	@Override
	public void crearUsuario(Cliente cli) {
		Object[] usuarioParams = { cli.getUsername(), cli.getNombre(), cli.getApellido(), cli.getFechaNacimiento(),
				cli.getClave(), cli.getRun() };
		jdbcTemp.update(INSERT_USUARIO, usuarioParams);

		Object[] cliparams = { cli.getTelefono(), cli.getEmail(), cli.getRun() };
		jdbcTemp.update(INSERT_CLIENTE, cliparams);

	}

	/**@category	Metodos
	 * @param	editarUsuario()
	 * Este metodo sirve para editar los datos dentro de la base de datos, utilizando el RUN como el identificador para ambas tablas
	 *  */
	@Override
	public void editarUsuario(Cliente cli) {
		Object[] usuarioParams = { cli.getUsername(), cli.getNombre(), cli.getApellido(), cli.getFechaNacimiento(),
				cli.getClave(), cli.getRun() };
		jdbcTemp.update(UPDATE_USUARIO, usuarioParams);

		Object[] cliparams = { cli.getTelefono(), cli.getEmail(), cli.getRun() };
		jdbcTemp.update(UPDATE_CLIENTE, cliparams);

	}

	/**@category	Metodo
	 * @param	eliminarUsuario()
	 * Se eliminan los datos de la base de datos, utilizando la clave y el run como parametros para confirmar la eliminacion de la fila. 
	 *  */
	@Override
	public void eliminarUsuario(Cliente cli) {
		Object[] cliparams = {cli.getRun(), cli.getClave() };
		System.out.println(cli.getRun() + cli.getClave());
		jdbcTemp.update(DELETE_CLIENTE, cliparams);

//		Object[] usuarioParams = {cli.getRun()};
//	    jdbcTemp.update(DELETE_USUARIO, usuarioParams);

	}

}
