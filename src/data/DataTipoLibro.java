package data;

import java.sql.*;
import java.util.ArrayList;
import entity.*;



public class DataTipoLibro {

	public ArrayList<TipoLibro> getAllLibro(){
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoLibro> libros = new ArrayList<TipoLibro>();
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipolibro");
			if(rs!=null){
				while(rs.next()){
					TipoLibro tl = new TipoLibro();
					tl.setCantmaxreservaspendientes(rs.getInt("cantmaxreservaspendientes"));
					tl.setIdtipo(rs.getInt("idtipo"));
					tl.setNombretipo(rs.getString("nombretipo"));
					libros.add(tl);
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
		return libros;
		
		
		
		
		
	}
	
	
	
}
