package data;
import java.sql.*;
import java.util.ArrayList;
import entity.*;

public class DataElemento {
			public ArrayList <Elemento> getAll(){
				Statement stmt=null;
				ResultSet rs=null;
				ArrayList<Elemento> lib= new ArrayList<Elemento>();
				
				try {
					stmt = FactoryConexion.getInstancia().getConn().createStatement();
					rs = stmt.executeQuery("select * from elemento"); 
					if(rs!=null){
						while(rs.next()){
						int idtipo = 0;
						String nombretipo = null;
						int cantmaxreservaspendientes = 0;
						
						Elemento l = new Elemento(idtipo,nombretipo,cantmaxreservaspendientes);
						l.setIdtipo(rs.getInt("idTipo"));
						l.setIdElemento(rs.getInt("idElemento"));
						l.setNombreElemento(rs.getString("nombreElemento"));
						lib.add(l);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (rs!=null) {rs.close();}
					if (stmt!=null) {stmt.close();}
					FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lib;
			}
			public Elemento getById(Elemento el) {
				
					PreparedStatement stmt=null;
					ResultSet rs=null;
					int codigo = el.getIdElemento();
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from elemento where id=?");
					stmt.setInt(1, codigo);
					rs = stmt.executeQuery(); 
					if (rs!=null && rs.next()){
						
						//ver si hace falta crear el elemento
						el.setIdtipo(rs.getInt("idTipo"));
						el.setIdElemento(rs.getInt("idElemento"));
						el.setNombreElemento(rs.getString("nombreElemento"));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					if(rs!=null) rs.close();
					if(stmt!=null)stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				return el;
				
			}
			public void add(Elemento lib){
				PreparedStatement stmt = null;
				ResultSet keyResultSet=null;
				
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into elemento(nombreElemento,idTipo) values(?,?)"
							,PreparedStatement.RETURN_GENERATED_KEYS);
					stmt.setInt(2, lib.getIdtipo());
					stmt.setString(1, lib.getNombreElemento());
					//Aca revisar, le mando o no le mando el id? (Autoincremental)
					stmt.executeUpdate();
					keyResultSet=stmt.getGeneratedKeys();
					if(keyResultSet!=null && keyResultSet.next()){
						lib.setIdElemento(keyResultSet.getInt(1)); 
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
			public void deleteById(Elemento el){
				PreparedStatement stmt = null;
				int codigo = el.getIdElemento();
				try {
					stmt =  FactoryConexion.getInstancia().getConn().prepareStatement("delete from elemento where idElemento=?");
					stmt.setInt(1, codigo);
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
			public void update(Elemento lib){
				PreparedStatement stmt = null;
			
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update elemento set nombreElemento=?, idTipo=?");
					stmt.setString(1, lib.getNombreElemento());
					stmt.setInt(2, lib.getIdtipo());
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
