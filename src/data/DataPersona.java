package data;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;
import java.util.ArrayList;
import entity.*;

public class DataPersona {
	public ArrayList<Persona> getAll(){
			Statement stmt=null;
			ResultSet rs=null;
			ArrayList<Persona> pers= new ArrayList<Persona>();
			
			try {
				stmt = FactoryConexion.getInstancia().getConn().createStatement();
				rs = stmt.executeQuery("select * from persona");
				if(rs!=null){
					while(rs.next()){
					Persona p=new Persona();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					pers.add(p);
					
					}
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			try {
				if(rs!=null) rs.close(); 
				if(stmt!=null) stmt.close(); 
				FactoryConexion.getInstancia().releaseConn();  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return pers;		
			}
	
	public Persona getByDni(Persona per){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Persona p = null;
		
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select id, nombre, apellido, dni, habilitado from persona where dni=?");
		stmt.setString(1, per.getDni());
		rs = stmt.executeQuery();
		if(rs!=null && ){
			
			
		}
}
			
		
		
		
		
		
		
	}

		}
	

