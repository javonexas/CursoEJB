package mx.certificatic.practica;

import javax.ejb.Stateless;

@Stateless
public class Saluda {
	public String saludar(String nombre){
		if(nombre == null)
			return null;
		return "Hola "+nombre;
	}
}
