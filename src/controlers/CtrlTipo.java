package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
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
	
	/*quiero que me aparezca este*/
}
