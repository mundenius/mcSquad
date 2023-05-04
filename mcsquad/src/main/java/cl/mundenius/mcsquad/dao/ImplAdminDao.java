package cl.mundenius.mcsquad.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Administrativo;
import cl.mundenius.mcsquad.modelo.Usuario;

public class ImplAdminDao implements CRUD<Administrativo>{

	private JdbcTemplate jdbcTemp;
	
	public ImplAdminDao(DataSource ds) {
		this.jdbcTemp = new JdbcTemplate(ds);
	}

	@Override
	public Usuario getUserPass(String username, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrativo> mostrarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearUsuario(Administrativo d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarUsuario(Administrativo d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Administrativo d) {
		// TODO Auto-generated method stub
		
	}


}
