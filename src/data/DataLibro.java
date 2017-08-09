package data;
import java.sql.*;
import java.util.ArrayList;
import entity.*;

public class DataLibro {
			public ArrayList <Libro> getAll(){
				Statement stmt=null;
				ResultSet rs=null;
				ArrayList<Libro> lib= new ArrayList<Libro>();
				
				try {
					stmt = FactoryConexion.getInstancia().getConn().createStatement();
					rs = stmt.executeQuery("selec * from libro");
					if(rs!=null){
						while(rs.next()){
						Libro l = new Libro();
						l.setAutor(rs.getString("autor"));
						l.setEditorial(rs.getString("editorial"));
						l.setGenero(rs.getString("genero"));
						l.setIdlibro(rs.getInt("idlibro"));
						l.setIsbn(rs.getString("isbn"));
						l.setNombrelibro(rs.getString("nombreLibro"));
						l.setPrecio(rs.getFloat("precio"));
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
			public Libro getByIsbn(String codigo) {
				
					PreparedStatement stmt=null;
					ResultSet rs=null;
					Libro l = null;
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select idLibro, nombreLibro, editorial, isbn, genero, precio from libro where isbn=?");
					//Revisar los elemtnos de la table
					stmt.setString(1, codigo);
					rs = stmt.executeQuery(); 
					if (rs!=null && rs.next()){
						l = new Libro();
						l.setAutor(rs.getString("autor"));
						l.setEditorial(rs.getString("editorial"));
						l.setGenero(rs.getString("genero"));
						l.setIdlibro(rs.getInt("id"));
						l.setIsbn(rs.getString("isbn"));
						l.setNombrelibro(rs.getString("nombreLibro"));
						l.setPrecio(rs.getFloat("precio"));
						
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
				return l;
				
			}
			public void add(Libro lib){
				PreparedStatement stmt = null;
				ResultSet keyResultSet=null;
				
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into libro(autor,editorial,genero,isbn,nombreLibro,precio) values(?,?,?,?,?,?)"
							,PreparedStatement.RETURN_GENERATED_KEYS);
					stmt.setString(1, lib.getAutor());
					stmt.setString(2, lib.getEditorial());
					stmt.setString(3, lib.getGenero());
					stmt.setString(4, lib.getIsbn());
					stmt.setString(5, lib.getNombrelibro());
					stmt.setFloat(6, lib.getPrecio());
					
					stmt.executeUpdate();
					keyResultSet=stmt.getGeneratedKeys();
					if(keyResultSet!=null && keyResultSet.next()){
						lib.setIdlibro(keyResultSet.getInt(1)); 
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
			public void deleteByIsbn(String codigo){
				PreparedStatement stmt = null;
				
				try {
					stmt =  FactoryConexion.getInstancia().getConn().prepareStatement("delete from libro where isbn=?");
					stmt.setString(1, codigo);
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
			public void update(Libro lib){
				PreparedStatement stmt = null;
			
				try {
					stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update libro set nombreLibro = ?, editorial = ?,isbn = ?, genero=?, precio=?");
					stmt.setString(1, lib.getAutor());
					stmt.setString(2, lib.getEditorial());
					stmt.setString(3, lib.getGenero());
					stmt.setString(4, lib.getIsbn());
					stmt.setString(5, lib.getNombrelibro());
					stmt.setFloat(6, lib.getPrecio());
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
