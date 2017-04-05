package sicodif;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;


public class FisDecFisAction extends Action {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisDecFisForm bean = (FisDecFisForm)request.getAttribute("FisDecFisForm");
        FisDeclaracionForm dui = new FisDeclaracionForm();
        FisConsultaForm con = new FisConsultaForm();
        ActionMessages error = new ActionMessages();  

        String usuario = (String)request.getSession().getAttribute("user.nick");
        bean.setUsuario((String)request.getSession().getAttribute("user.nick"));
        
        String res;
        String link = "volver";

        if (usuario != null) {
                if (bean.getBoton().equals("orden")) 
                {
                    res = Util.DevuelveConsulta(bean.getKey_year(),bean.getKey_cuo(), bean.getReg_serial(),  con);
                    
                    if (res.substring(0, 5).equals("ERROR")) {
                        link = "error";
                    } else {
                        request.setAttribute("FisConsultaForm", con);
                        link = "reporte";
                        
                    }

                } else {
                    link = "inicio";
                }
          
        }
        return mapping.findForward(link);
    }
}
