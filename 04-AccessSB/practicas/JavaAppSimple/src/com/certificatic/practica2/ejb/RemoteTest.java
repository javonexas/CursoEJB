package com.certificatic.practica2.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoteTest {
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
            CalculaMediaBeanRemote remoteEJB=(CalculaMediaBeanRemote)ctx.lookup("java:global/jee-ear/jee-ejb-1.0-SNAPSHOT/CalculaMediaBean!com.certificatic.practica2.ejb.CalculaMediaBeanLocal");
            
            
            List<Double> datos = new ArrayList<Double>();
            for (int i = 0; i < 10; i++) {

                datos.add((double)i);
            }
            
            System.out.println(remoteEJB.calculaMediaAritmetica(datos));

        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }
    }
}
