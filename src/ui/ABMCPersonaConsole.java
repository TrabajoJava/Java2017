package ui;

import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlPersona;
import entity.Persona;

public class ABMCPersonaConsole {
	
	private Scanner s;
	private CtrlPersona ctrl;
	public ABMCPersonaConsole(){
		s=new Scanner(System.in);
		ctrl= new CtrlPersona();
		
	}
	
	public void menu(){
		String rta="";
		boolean continua=true;
		do {
			System.out.println("\n\n 					\n");
			System.out.println("¿Qué acción desea realizar? (Ingrese la letra indicada)");
			System.out.println("A - Alta");
			System.out.println("B - Baja");
			System.out.println("M - Modificación");
			System.out.println("C - Consulta");
			System.out.println("S - Salir");
			rta=s.nextLine();
			switch (rta.toLowerCase()) {
			case "a":
				this.alta();
				break;
			case "b":
				this.baja();
				break;
			case "m":
				this.modificacion();
				break;
			case "c":
				this.consulta();
				break;
			case "s":
				continua=false;
			}
		} while (continua);
		
		s.close();
	}
	
	private void alta(){
		System.out.println("\n\nNueva persona");
		System.out.println("						");
		Persona p=new Persona();
		System.out.println("Ingrese DNI:");
		p.setDni(s.nextLine());
		System.out.println("Ingrese Nombre");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese Apellido");
		p.setApellido(s.nextLine());
		System.out.println("¿Está habilitado? (S/N)");
		String h=s.nextLine();
		if(h.equalsIgnoreCase("S")){
			p.setHabilitado(true);
		}else if (h.equalsIgnoreCase("N")) {
			p.setHabilitado(false);
		}
		ctrl.add(p);
	}
	
	private void baja(){
		System.out.println("\n\nEliminar persona");
		System.out.println("					");
		//Persona p=new Persona();
		System.out.println("Ingrese DNI:");
		//p.setDni(s.nextLine());
		ctrl.deletebydni(s.next());

	}
	
	private void modificacion(){
		Persona p=new Persona();
		System.out.println("\n\nModificar persona");
		System.out.println("#############");
		System.out.println("Ingrese DNI:");
		p.setDni(s.nextLine());
		this.mostrar(ctrl.getbydni(p.getDni()));
		
		System.out.println("\nIngrese Nuevo Nombre");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese Nuevo Apellido");
		p.setApellido(s.nextLine());
		System.out.println("¿Está habilitado? (S/N)");
		String h=s.nextLine();
		if(h.equalsIgnoreCase("S")){
			p.setHabilitado(true);
		}else if (h.equalsIgnoreCase("N")) {
			p.setHabilitado(false);
		}
		ctrl.update(p);
	}
	
	private void consulta(){
		Persona p=new Persona();
		System.out.println("\n\nConsultar personas");
		System.out.println("#############");
		System.out.println("Ingrese Opción:");
		System.out.println("1 - Listar todos");
		System.out.println("2 - Buscar por DNI");
		
		String rta=s.nextLine();
		switch (rta) {
		case "1":
			this.mostrar(ctrl.getall());
			break;
		case "2":
			System.out.println("Ingrese DNI:");
			p.setDni(s.nextLine());
			this.mostrar(ctrl.getbydni(p.getDni()));
			
			break;

		default:
			break;
		}
		
	}
	
	public void mostrar(ArrayList<Persona>personas){
		for(Persona p: personas){
			mostrar(p);
		}
	}
	
	public void mostrar(Persona p){
		String h="";
		if(p.isHabilitado()){
			h="Habilitado";
		}else{
			h="Deshabilitado";
		}
		System.out.println(p.getDni()+" - "+p.getApellido()+", "+
						 p.getNombre()+": "+h);
	}

}