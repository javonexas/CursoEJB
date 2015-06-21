package mx.certificatic.ejb.practica3.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import mx.certificatic.ejb.practica3.model.Person;

/**
 * Session Bean implementation class PersonEJB
 */
@Stateless
@LocalBean
@Remote(PersonEJBRemote.class)
@Local(PersonEJBLocal.class)
public class PersonEJB implements PersonEJBRemote, PersonEJBLocal {

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

}
