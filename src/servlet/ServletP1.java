package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletP1
 */
@WebServlet("/ServletP1")
public class ServletP1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletP1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 Metodos que atienden las peticiones POST y GET de la p�gina, respectivamente.
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		requestHeader(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//Creamos un m�todo que nos permita obtener las cabeceras de petici�n HTTP
		public void requestHeader(HttpServletRequest req, HttpServletResponse res) throws IOException {
					//Definimos una variable out de tipo Printwriter.
					//Esta clase imprime representaciones formateadas de objetos en una secuencia de salida de texto.
			        PrintWriter out = res.getWriter();
			        
			        out.write("\n\nCabeceras de petici�n: ");
			        //Interfaz Enumeration: Un objeto que implementa la interfaz Enumeration permite generar series de elementos
			        //Enumeraci�n llamada headerNames a la que le asignamos las distintas cabeceras sin su valor
			        Enumeration<String> headerNames = req.getHeaderNames();
			        
			        while (headerNames.hasMoreElements()) { //hasMoreElements()-> prueba si esta enumeraci�n contiene m�s elementos
			        	//Definimos una variable headerName de tipo String y le asignamos el valor siguiente de headerNames (contiene
			        	//los nombres de las cabeceras)
			            String headerName = headerNames.nextElement();
			            //En nuestra salida, escribe un salto de l�nea + el nombre de la cabecera
			            out.write("\n"+headerName);
			            
			            //Enumeracion de tipo string llamada header a la que le asignamos el valor de las distintas cabeceras
			            //req.getHeaders(headerName) -> Obtiene el valor de las cabeceras de la petici�n
			            Enumeration<String> headers = req.getHeaders(headerName);
			            
			            while (headers.hasMoreElements()) { //prueba si esta enumeraci�n contiene m�s elementos
		
			            	//Definimos una variable que contendra el valor de nuestra cabecera y se lo asignamos
			                String headerValue = headers.nextElement();
			                //Escribe en nuestra p�gina web : y el valor de la cabecera
			                out.write(":"+headerValue);
			            }

			        }
			        
			        //********************* PARTE OPCIONAL ****************************+
			        out.write("\n\nM�todos adicionales: \n");
			        //Metodo empleado
			        String metodo = req.getMethod();
			        out.write("Tipo de petici�n: " + metodo);
			        
			        //URL
			        StringBuffer metodo2 = req.getRequestURL();
			        out.write("\nURL: " + metodo2);
			       
			        //Nombre del servidor
			        String metodo3 = req.getServerName();
			        out.write("\nNombre del servidor: " + metodo3);
			     
			        
			        //Cerramos salida.
			        out.close();

			    }

}
