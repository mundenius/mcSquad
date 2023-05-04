package cl.mundenius.mcsquad.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Cliente;
import cl.mundenius.mcsquad.modelo.Usuario;

public class ImplClienteDao implements CRUD<Cliente>{

	private JdbcTemplate jdbcTemp;
	
	public ImplClienteDao(DataSource ds) {
		this.jdbcTemp = new JdbcTemplate(ds);
	}

	@Override
	public Usuario getUserPass(String username, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> mostrarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearUsuario(Cliente d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarUsuario(Cliente d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Cliente d) {
		// TODO Auto-generated method stub
		
	}

}
