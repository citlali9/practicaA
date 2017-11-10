/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import ProcesoDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author citlalli
 */
@WebServlet(name = "utlSuperPro", urlPatterns = {"/utlSuperPro"})
public class utilComunicacion extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String materno = request.getParameter("materno");
        String paterno = request.getParameter("paterno");
        String telefono = request.getParameter("telefono");
        
        //logs impresiones en consola de servidor
        System.out.println("Hey nombre es: " + nombre);
        System.out.println("Hey nombre es: " + materno);
        System.out.println("Hey nombre es: " + paterno);
        System.out.println("Hey nombre es: " + telefono);
        
        
        PersonaDAO pers=new PersonaDAO();
        pers.savePersona(nombre, materno, paterno, telefono, 1);
       
        // crea un objeto json  
        JSONObject json=new JSONObject();
        
        //le doy valores al objeto json clave y valor.
        json.put("resultado", true);
        
        response.setContentType("application/json utf-8");
        //Declaro un printwrite para enviar contenido al cliente
        PrintWriter out=response.getWriter();
        //Lo envio pero antes lo convierto a String
        out.print(json.toString());
                
        destroy();
    } 
}

