package mx.certificatic.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.certificatic.practica.Saluda;

/**
 * Servlet implementation class HolaServlet
 */
@WebServlet(name="holaServlet",urlPatterns="/hola",
			initParams={ @WebInitParam(name="simpleParam", value="paramValue") })
public class HolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	Saluda saluda;

    /**
     * Default constructor. 
     */
    public HolaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saluda.saludar("Javier");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
