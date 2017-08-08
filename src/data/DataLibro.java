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
			}

}
