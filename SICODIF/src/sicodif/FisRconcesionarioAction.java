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


public class FisRconcesionarioAction extends Action {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisRconcesionarioForm bean = (FisRconcesionarioForm)request.getAttribute("FisRconcesionarioForm");
        FisDeclaracionForm dui = new FisDeclaracionForm();
        ActionMessages error = new ActionMessages();

        String usuario = (String)request.getSession().getAttribute("user.nick");
        bean.setUsuario((String)request.getSession().getAttribute("user.nick"));
        String gerencia = (String)request.getSession().getAttribute("user.gerencia");
        String res;
        
        request.setAttribute("FisRconcesionarioForm", bean);
        
        String link = "fis.rep.concesionario";
       /* if(bean.getReporte().equals("regional"))
            link = "volver2";*/
        
/*
        if (usuario != null) {
                if (bean.getBoton().equals("consultar")) 
                {
                        bean.setDeclaracion(Util.TablaReporte1(bean.getGerencia(), bean.getFec_desde(), bean.getFec_hasta()));  
                        bean.setEstado("CORRECTO");
                        link = "volver";
                }
                else 
                
            if (bean.getBoton().equals("consultar2")) 
            {
                    bean.setDeclaracion(Util.TablaReporte1(gerencia, bean.getFec_desde(), bean.getFec_hasta()));  
                    bean.setEstado("CORRECTO");
                    link = "volver2";
            }
            else 
            {
                link = "inicio";
            }
        }
*/       
        
        
        return mapping.findForward(link);
    }
}
