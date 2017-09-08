package data;

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
					/*while(rs.next()){					Hay que mandarle que tipo de persona es
					Persona p=new Persona();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.setUsuario(rs.getString("usuario"));
					p.setContrase�a(rs.getString("contrase�a"));
					pers.add(p);
					
					}*/ 			
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
	
	public Persona getByDni(String docu){
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Persona p = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select id, nombre, apellido, dni, habilitado, usuario, contrase�a from persona where dni=?");
			stmt.setString(1, docu);
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){	
				/*p = new Persona();				iden a todos los otros
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setUsuario(rs.getString("usuario"));
				p.setContrase�a(rs.getString("contrase�a"));
										*/}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return p;
}
			
		public void add(Persona per){
				PreparedStatement stmt = null;
				ResultSet keyResultSet=null;

				
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into persona(nombre,apellido,dni,habilitado, usuario, contrase�a) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
					/*REvisar que esten en ese roden en la tabla*/
					stmt.setString(1, per.getNombre());
					stmt.setString(2, per.getApellido());
					stmt.setString(3, per.getDni());
					stmt.setBoolean(4, per.isHabilitado());
					stmt.setString(5, per.getUsuario());
					stmt.setString(6, per.getContrasena());
					stmt.executeUpdate();
					keyResultSet=stmt.getGeneratedKeys();
					if(keyResultSet!=null && keyResultSet.next()){
						per.setId(keyResultSet.getInt(1));  
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
		
		
		public void deleteByDni(String docu){
			
			PreparedStatement stmt = null;
			
			
			try {
				stmt =  FactoryConexion.getInstancia().getConn().prepareStatement("delete from persona where dni=?");
				stmt.setString(1, docu);
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public void update(Persona per){
			
			PreparedStatement stmt = null;
			
			
			try {
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update persona set dni = ?, nombre = ?, apellido = ?, habilitado = ?, usuario= ?, contrase�a= ? where dni = ?");
				stmt.setString(1, per.getDni());
				stmt.setString(2, per.getNombre());
				stmt.setString(3, per.getApellido());
				stmt.setBoolean(4, per.isHabilitado());
				stmt.setString(5, per.getUsuario());
				stmt.setString(6, per.getContrasena());
				stmt.setString(7, per.getDni());
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}		
}			

	

