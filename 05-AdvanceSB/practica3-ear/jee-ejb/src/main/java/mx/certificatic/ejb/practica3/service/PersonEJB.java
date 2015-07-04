package mx.certificatic.ejb.practica3.service;

import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import mx.certificatic.ejb.practica3.model.Person;

/**
 * Session Bean implementation class PersonEJB
 */
@Stateless
@LocalBean
@Remote(PersonEJBRemote.class)
@Local(PersonEJBLocal.class)
public class PersonEJB implements PersonEJBRemote, PersonEJBLocal, PersonAsyncRemote{
	
	@Resource private SessionContext myContext;

    /**
     * Default constructor. 
     */
    public PersonEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    private void init(){
    	System.out.println("Se inicia PersonEJB");
    }
    
    public void addPerson(Person person){
    	person.setId(2);
    	System.out.println(person.getId());
    }
    
    @PreDestroy
    private void clean(){
    	System.out.println("Se finaliza PersonEJB");
    }
    
    @Asynchronous
    @Override
    public Future<String> longProcess(){
    	String msg = "Success";
    	try{
    		//while(myContext.wasCancelCalled() == false){
    			Thread.sleep(10000);
    			System.out.println("Working ...");
    		//}
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}
    	return new AsyncResult<String>(msg);
    }
	
    @Asynchronous
    @Override
	public void initial(){
		System.out.println("Begin initial");
	}

}
