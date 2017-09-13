package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entity.Persona;
import entity.TipoElemento;



public class CtrlTipo {

	private DataTipoElemento dataTipo;
	private ArrayList<TipoElemento> tipo;
	
	public CtrlTipo(){
		dataTipo = new DataTipoElemento();
		tipo= new ArrayList<TipoElemento>();	
	
	}

	public void add(TipoElemento tipo){
		dataTipo.add(tipo);
	}
	

	public TipoElemento getbyId(TipoElemento te){
		
		return dataTipo.getbyId(te);
	}
	


}
