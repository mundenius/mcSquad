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

@Repository
public class ImplClienteDao implements CRUD<Cliente>{

	private JdbcTemplate jdbcTemp;
	
	public ImplClienteDao(DataSource ds) {
		this.jdbcTemp = new JdbcTemplate(ds);
	}

	final String GETFORPASS = "SELECT * FROM usuario WHERE username = ? AND clave = ?;";
	final String GETALL = "SELECT u.idusuario, u.username, u.nombre, u.apellido, u.fechaNacimiento, u.clave, u.run, c.idcliente, c.telefono, c.email FROM usuario u INNER JOIN cliente c ON u.run = c.rutcliente";
	final String INSERT_USUARIO = "INSERT INTO usuario(username, nombre, apellido, fechanacimiento, clave, run) VALUES (?,?,?,?,?,?);";
	final String INSERT_CLIENTE = "INSERT INTO cliente(telefono, email, rutcliente) VALUES (?,?,?);";
	final String UPDATE_USUARIO = "UPDATE usuario SET username = ?, nombre = ?, apellido = ?, fechanacimiento = ?, clave = ? WHERE run = ?;";
	final String UPDATE_CLIENTE = "UPDATE cliente SET telefono = ?, email = ? WHERE rutcliente = ?";
	final String DELETE_CLIENTE = "DELETE FROM cliente WHERE rutcliente = ?;";
	final String DELETE_USUARIO = "DELETE FROM usuario WHERE run = ?";
	
	@Override
	public Usuario getUserPass(String username, String pass) {
		String sql = "SELECT * FROM usuario WHERE username = ? AND clave = ?;";
		Object[] keys = {username, pass};
		Usuario user = jdbcTemp.queryForObject(sql, keys, new UsuarioRowMapper());
		
		return user;
	}

	@Override
	public List<Cliente> mostrarUsuarios() {
		List<Cliente> cliList = jdbcTemp.query(GETALL, new ClienteRowMapper());
		return cliList;
	}

	@Override
	public void crearUsuario(Cliente cli) {
		Object[] usuarioParams = {cli.getUsername(), cli.getNombre(), cli.getApellido(), cli.getFechaNacimiento(), cli.getClave(), cli.getRun()};
	    jdbcTemp.update(INSERT_USUARIO, usuarioParams);
	    
	    Object[] cliparams = {cli.getTelefono(), cli.getEmail(), cli.getRun()};
	    jdbcTemp.update(INSERT_CLIENTE, cliparams);
		
	}

	@Override
	public void editarUsuario(Cliente cli) {
		Object[] usuarioParams = {cli.getUsername(), cli.getNombre(), cli.getApellido(), cli.getFechaNacimiento(), cli.getClave(), cli.getRun()};
	    jdbcTemp.update(UPDATE_USUARIO, usuarioParams);
	    
	    Object[] cliparams = {cli.getTelefono(), cli.getEmail(), cli.getRun()};
	    jdbcTemp.update(UPDATE_CLIENTE, cliparams);
		
	}

	@Override
	public void eliminarUsuario(Cliente cli) {
		Object[] cliparams = {cli.getRun()};
		jdbcTemp.update(DELETE_CLIENTE, cliparams);
		
		Object[] usuarioParams = {cli.getRun()};
	    jdbcTemp.update(DELETE_USUARIO, usuarioParams);
		
	}

}
