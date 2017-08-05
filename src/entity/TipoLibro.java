package entity;

public class TipoLibro {

	private int idtipo;
	private String nombretipo;  //seria por ejemplo: novela, manual, cuento
	private int cantmaxreservaspendientes;    //es la cantidad máxima de elementos de este tipo que cada usuario puede tener pendiente a futuro. 
	
	
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getNombretipo() {
		return nombretipo;
	}
	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	public int getCantmaxreservaspendientes() {
		return cantmaxreservaspendientes;
	}
	public void setCantmaxreservaspendientes(int cantmaxreservaspendientes) {
		this.cantmaxreservaspendientes = cantmaxreservaspendientes;
	}
	
	public TipoLibro(int idtipo, String nombretipo, int cantmaxreservaspendientes) {
		this.idtipo = idtipo;
		this.nombretipo = nombretipo;
		this.cantmaxreservaspendientes = cantmaxreservaspendientes;
	}
	
	public TipoLibro(){};
	
}
