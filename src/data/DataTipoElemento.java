package data;

import java.sql.*;
import java.util.ArrayList;
import entity.*;



public class DataTipoElemento {

	public ArrayList<TipoElemento> getAllTipos(){
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoElemento> tipos = new ArrayList<TipoElemento>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoElemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tl = new TipoElemento();
					tl.setCantmaxreservaspendientes(rs.getInt("cantmaxreservaspendientes"));
					tl.setIdtipo(rs.getInt("idTipo"));
					tl.setNombretipo(rs.getString("nombreTipo"));
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
	
	
	
}
