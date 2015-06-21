package mx.certificatic.practica3.client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import mx.certificatic.ejb.practica3.model.Person;
import mx.certificatic.ejb.practica3.service.PersonEJBRemote;

public class App {

	public static void main(String[] args) {
		Properties prop = new Properties();
        InitialContext ctx= null;
        prop.put("org.omg.CORBA.ORBInitialHost","localhost");
        prop.put("org.omg.CORBA.ORBInitialPort","3700");
        prop.put("java.naming.factory.initial","com.sun.enterprise.naming.SerialInitContextFactory");
        prop.put("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
        prop.put("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        
        try {
            ctx = new InitialContext(prop);
            PersonEJBRemote personEJBRemote=(PersonEJBRemote)ctx.lookup("java:global/jee-ear-1.0-SNAPSHOT/jee-ejb-1.0-SNAPSHOT/PersonEJB!mx.certificatic.ejb.practica3.service.PersonEJBRemote");
            Person person = new Person();
            person.setId(1);
            personEJBRemote.addPerson(person);
            System.out.println(person.getId());

        } catch (NamingException e) {
            System.err.println(e.getMessage());
        }
	}

}
