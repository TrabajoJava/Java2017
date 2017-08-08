package entity;

public class Libro extends TipoLibro {

	private int idlibro;
	private String nombrelibro;
	private String editorial;
	private String isbn;
	private String autor;
	private String genero;
	private float precio;
	
	
	public int getIdlibro() {
		return idlibro;
	}
	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}
	
	public String getNombrelibro() {
		return nombrelibro;
	}
	public void setNombrelibro(String nombrelibro) {
		this.nombrelibro = nombrelibro;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getTipoLibro(){ 		//ver si esta bien
		
		return super.getNombretipo();
		
	}
	
	public Libro(int idtipo, String nombretipo, int cantmaxreservaspendientes, int idlibro, String nombrelibro, String editorial, String isbn,
			String autor, String genero, float precio) {
		super(idtipo, nombretipo, cantmaxreservaspendientes);
		this.idlibro=idlibro;
		this.nombrelibro=nombrelibro;
		this.editorial= editorial;
		this.isbn= isbn;
		this.autor=autor;
		this.genero=genero;
		this.precio=precio;
		
		
	}
	
	public Libro() {}
	
}
