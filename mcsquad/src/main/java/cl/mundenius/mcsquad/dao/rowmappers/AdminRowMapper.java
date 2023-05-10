/**@author mundenius */

package cl.mundenius.mcsquad.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.mundenius.mcsquad.modelo.Administrativo;

public class AdminRowMapper implements RowMapper<Administrativo>{

	/**@category RowMapper
	 * @param Administrativo
	 * Rowmapper para traer los datos de la base de datos de forma ordenada
	 *  */
	@Override
	public Administrativo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Administrativo admin = new Administrativo();
        admin.setIdUsuario(rs.getInt("idusuario"));
        admin.setUsername(rs.getString("username"));
        admin.setNombre(rs.getString("nombre"));
        admin.setApellido(rs.getString("apellido"));
        admin.setFechaNacimiento(rs.getString("fechanacimiento"));
        admin.setClave(rs.getString("clave"));
        admin.setRun(rs.getString("run"));
        admin.setIdAdmin(rs.getInt("idadministrativo"));
        admin.setArea(rs.getString("area"));
        
		return admin;
	}

}
