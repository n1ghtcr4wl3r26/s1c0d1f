package sicodif;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JqueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fecha = request.getParameter("fecha");
        String ufv;
        if(fecha.equals("")) {
            ufv = "";
            }
        else
        {
            ufv = Util.DevuelveUFV(fecha);
            }
        response.setContentType("text/plain");
        response.getWriter().write(ufv);
        }
}
