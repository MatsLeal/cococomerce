/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import jpa.entities.Productos;
import jpa.entities.Usuario;

import org.primefaces.model.UploadedFile;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet{
    
    @EJB
    private facade.ProductosFacade ejbFacade;
    
    
    @Inject
    private Productos productos;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String imageId = String.valueOf(request.getPathInfo().substring(1)); // Gets string that goes after "/images/".
        
        
        UploadedFile image = getImage(imageId); // Get Image from DB.

        response.setHeader("Content-Type", getServletContext().getMimeType(image.getFileName() ));
        response.setHeader("Content-Disposition", "inline; filename=\"" + image.getFileName() + "\"");

        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            input = new BufferedInputStream(image.getInputstream() ); // Creates buffered input stream.
            output = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[8192];
            for (int length = 0; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
        } finally {
            if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
            if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
        }
    }
    
    
    private UploadedFile getImage(String id){
        
        
        TypedQuery<Productos> query = this.ejbFacade.getEm().createNamedQuery("findImageById",Productos.class);
        
        Integer imageid= Integer.parseInt(id);
        
        query.setParameter("id", imageid);
        
        //UploadedFile file = new UploadedFile();
        
        
        
        return (UploadedFile) query.getSingleResult();
        
        
        
        
    }
    
}
