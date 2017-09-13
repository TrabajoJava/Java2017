package tablas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controlers.CtrlPersona;
import entity.Persona;

public class tablaPersonas extends AbstractTableModel {

	CtrlPersona ctrlper = new CtrlPersona();
	
	ArrayList<Persona> personas = ctrlper.getall();
	
	String [] encabezados = {"ID", "Nombre", "Apellido", "DNI", "Habilitado", "Usuario", "Contraseña"};
	
	public int getColumnCount() {
	
		return 0;
	}
	
	public int getRowCount() {
		return personas.size(); 
	}
	
	@Override
	public String getColumnName(int x) {
		
		return encabezados[x];
	}

	public Object getValueAt(int x, int y) {
		String retorno = "";
		Persona p = personas.get(x);
		
		switch(y){
		case 0: retorno= String.valueOf(p.getId());
		break;
		case 1: retorno = p.getNombre();
		break;
		case 2: retorno = p.getApellido();
		break;
		case 3: retorno = p.getDni();
		break;
		case 4: retorno = String.valueOf(p.isHabilitado());
		break;
		case 5: retorno = p.getUsuario();
		break;
		case 6: retorno = p.getContrasena();
		break;


		}
		
		return retorno;
	}

} 	 	
