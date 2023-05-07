package cl.mundenius.mcsquad.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.mundenius.mcsquad.modelo.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cli = new Cliente();
        cli.setIdUsuario(rs.getInt("idusuario"));
        cli.setUsername(rs.getString("username"));
        cli.setNombre(rs.getString("nombre"));
        cli.setApellido(rs.getString("apellido"));
        cli.setFechaNacimiento(rs.getString("fechanacimiento"));
        cli.setClave(rs.getString("clave"));
        cli.setRun(rs.getString("run"));
        cli.setIdCliente(rs.getInt("idcliente"));
        cli.setTelefono(rs.getString("telefono"));
        cli.setEmail(rs.getString("email"));
        
		return cli;
	}

}
