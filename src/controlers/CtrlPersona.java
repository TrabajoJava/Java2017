
package controlers;

import java.util.ArrayList;

import data.DataPersona;
import entity.Persona;

public class CtrlPersona {

	
	private DataPersona dataPer;
	private ArrayList<Persona> pers;
	
	public CtrlPersona(){
		dataPer = new DataPersona();
		pers= new ArrayList<Persona>();	
		
	
	}

	public void add(Persona per){
		dataPer.add(per);
	}
	
	public void deletebydni(String dni){
		
		dataPer.deleteByDni(dni);
		
	}
	
	public ArrayList<Persona> getall(){
		
		pers = dataPer.getAll();
		return pers;
		
	}
	
	public Persona getbydni(String dni){
		
		return dataPer.getByDni(dni);
	}
	
	public void update(Persona per){
		
		dataPer.update(per);
	}
	
	
}
