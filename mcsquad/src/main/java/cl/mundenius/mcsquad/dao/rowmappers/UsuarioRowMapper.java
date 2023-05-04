package cl.mundenius.mcsquad.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.mundenius.mcsquad.modelo.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNr) throws SQLException{
		Usuario user = new Usuario();
		user.setIdUsuario(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setNombre(rs.getString(3));
		user.setApellido(rs.getString(4));
		user.setFechaNacimiento(String.valueOf(rs.getDate(5)));
		user.setClave(rs.getString(6));
		user.setRun(rs.getString(7));
		
		return user;
	}
	

}
