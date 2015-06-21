package com.certificatic.practica1.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.certificatic.practica1.ejb.local.SaludaEJBLocal;
import com.certificatic.practica1.ejb.remote.SaludaEJBRemote;

@Stateless
@LocalBean
public class SaludaEJB implements SaludaEJBRemote, SaludaEJBLocal{
	@Override
	public String saludaMundo(String nombre){
		return "Hola "+nombre+ " blah blah";
	}
}
