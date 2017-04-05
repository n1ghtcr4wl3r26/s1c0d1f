package sicodif;

/*import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;*/
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class JSONAction extends DispatchAction 
{
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */
   
    public ActionForward importadores(ActionMapping mapping, ActionForm form, 
                                 HttpServletRequest request, 
                                 HttpServletResponse response)
                          throws IOException, ServletException {
        JsonDB json = null;
        String cod = request.getParameter("p_cod");
        String aux = request.getParameter("vaux");
        

        try {
            json = new JsonDB();
            response.setContentType("text/json");
            response.getWriter().write(json.getimportadores(cod));
        } catch (Exception e) {
        } finally {
            if (json != null) {
                // json.dispose();
            }
        }

        return null;
    }
  
    public ActionForward devuelveUFV(ActionMapping mapping, ActionForm form, 
                                 HttpServletRequest request, 
                                 HttpServletResponse response)
                          throws IOException, ServletException {
        JsonDB json = null;
        String fecha = request.getParameter("fecha");
        String aux = request.getParameter("vaux");
        

        try {
            json = new JsonDB();
            response.setContentType("text/json");
            response.getWriter().write(json.getufv(fecha));
        } catch (Exception e) {
        } finally {
            if (json != null) {
                // json.dispose();
            }
        }

        return null;
    }

    

}