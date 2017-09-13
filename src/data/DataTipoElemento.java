package data;

import java.sql.*;
import java.util.ArrayList;
import entity.*;

/*y este tambien*/

public class DataTipoElemento {

	public ArrayList<TipoElemento> getAllTipos(){
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoElemento> tipos = new ArrayList<TipoElemento>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelementos");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tl = new TipoElemento();
					tl.setCantmaxreservaspendientes(rs.getInt("cantmaxreservaspendientes"));
					tl.setIdtipo(rs.getInt("id_tipo"));
					tl.setNombretipo(rs.getString("nombre_tipo"));
					tipos.add(tl);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipos;
		
		
	}
	public void add(TipoElemento lib){
		PreparedStatement stmt = null;
		ResultSet keyResultSet=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into tipoelementos(id_tipo,nombre_tipo,cantmaxreservaspendientes) values(?,?,?)"
					,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, lib.getIdtipo());
			stmt.setString(2, lib.getNombretipo());
			stmt.setInt(3,lib.getCantmaxreservaspendientes());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				lib.setIdtipo(keyResultSet.getInt(1)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
