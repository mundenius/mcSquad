package cl.mundenius.mcsquad.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Usuario;
import cl.mundenius.mcsquad.dao.rowmappers.UsuarioRowMapper;

public class ImplUsuarioDao implements CRUD<Usuario>{

	private JdbcTemplate jdbcTemp;
	
	public ImplUsuarioDao(DataSource ds) {
		this.jdbcTemp = new JdbcTemplate(ds);
	}

	@Override
	public Usuario getUserPass(String username, String pass) {

		String sql = "SELECT * FROM usuario WHERE username = ? AND clave = ?;";
		Object[] keys = {username, pass};
		Usuario user = jdbcTemp.queryForObject(sql, keys, new UsuarioRowMapper());
		
		return user;
	}

	@Override
	public List<Usuario> mostrarUsuarios() {

		String sql = "SELECT * FROM usuario;";
		List<Usuario> user = jdbcTemp.query(sql, new UsuarioRowMapper());
		return user;
	}

	@Override
	public void crearUsuario(Usuario d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarUsuario(Usuario d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Usuario d) {
		// TODO Auto-generated method stub
		
	}
}
