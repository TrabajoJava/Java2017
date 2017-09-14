package controlers;

import java.util.ArrayList;

import data.DataElemento;
import entity.Elemento;




public class CtrlElemento {

	private DataElemento dataElemento;
	private ArrayList<Elemento> elemento;
	
	public CtrlElemento(){
		dataElemento = new DataElemento();
		elemento= new ArrayList<Elemento>();	
	
	}

	public void add(Elemento elemento){
		dataElemento.add(elemento);
	}
	
	public ArrayList<Elemento> getAll()
	{
		return dataElemento.getAll();
		
	}
	
	
	/*public ArrayList<Elemento> getAllbytipo(int idTipo){
		
		return dataElemento.getAllbyTipo(idTipo);
				
	}*/
	
}