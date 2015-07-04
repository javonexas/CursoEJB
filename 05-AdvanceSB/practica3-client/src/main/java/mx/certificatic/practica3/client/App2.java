package mx.certificatic.practica3.client;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import mx.certificatic.ejb.practica3.model.Person;
import mx.certificatic.ejb.practica3.service.PersonAsyncRemote;
import mx.certificatic.ejb.practica3.service.PersonEJBRemote;

public class App2 {

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
            PersonAsyncRemote personAsyncRemote = (PersonAsyncRemote)ctx.lookup("java:global/jee-ear-1.0-SNAPSHOT/jee-ejb-1.0-SNAPSHOT/PersonEJB!mx.certificatic.ejb.practica3.service.PersonAsyncRemote");
            
            Future<String> msg = personAsyncRemote.longProcess();
            while(true){
            	if(msg.isDone() == false)
            		System.out.println(msg.isDone());
            	else
            		break;
            }
            System.out.println(msg.get());
        } catch (NamingException e) {
            System.err.println(e.getMessage());
        } catch (ExecutionException e){
        	System.err.println(e.getMessage());
        } catch (InterruptedException e){
        	System.err.println(e.getMessage());
        }
	}

}
