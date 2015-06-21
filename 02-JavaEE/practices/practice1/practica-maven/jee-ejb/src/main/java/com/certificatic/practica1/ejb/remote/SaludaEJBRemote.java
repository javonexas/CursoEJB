package com.certificatic.practica1.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface SaludaEJBRemote {
	public String saludaMundo(String nombre);
}
