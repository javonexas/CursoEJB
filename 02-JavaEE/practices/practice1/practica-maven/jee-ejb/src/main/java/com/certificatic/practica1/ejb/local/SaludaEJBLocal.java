package com.certificatic.practica1.ejb.local;

import javax.ejb.Local;

@Local
public interface SaludaEJBLocal {
	public String saludaMundo(String nombre);
}
