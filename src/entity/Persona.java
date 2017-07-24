package entity;

public class Persona {
	
	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private boolean habilitado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
		
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Persona(int id, String dni, String nombre, String apellido, boolean habilitado) {
		this.setDni(dni);     //this.dni = dni;
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setHabilitado(habilitado);
	}
	public Persona() {	}
	
	
	

}
