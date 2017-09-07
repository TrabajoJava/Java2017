package entity;

public class Persona extends Categoria {
	
	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private boolean habilitado;
	private String usuario;
	private String contrase�a;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
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
	public Persona(String nombrecat, int idcat) {
		super(nombrecat, idcat);
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nombrecat, int idcat, int id, String dni, String nombre, String apellido, boolean habilitado, String usuario,
			String contrase�a) {
		super(nombrecat, idcat);
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.habilitado = habilitado;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	
	
	
	
	

}
