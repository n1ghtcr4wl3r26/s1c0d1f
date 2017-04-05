package sicodif;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class FisRdetRecaudacionesAction extends Action {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisRdetRecaudacionesForm bean = (FisRdetRecaudacionesForm)request.getAttribute("FisRdetRecaudacionesForm");
        

        String usuario = (String)request.getSession().getAttribute("user.nick");
        bean.setUsuario((String)request.getSession().getAttribute("user.nick"));
        String gerencia = (String)request.getSession().getAttribute("user.gerencia");
        
        String res;
        
        request.setAttribute("FisRdetRecaudacionesForm", bean);
        //String link = "repDetrecaudaciones";
        String link= "";
        
        if(bean.getReporte().equals("regional"))
                    link = "volver2";

            if (usuario != null) {
                //reporte nacional
                    if (bean.getBoton().equals("consultar")) 
                    {
                            bean.setDeclaracion(Util.TablaDetrecaudaciones(bean.getGerencia(), bean.getFec_desde(), bean.getFec_hasta()));  
                        bean.setEstado("CORRECTO");
                            link = "volver";
                    }
                    else 
                //reporte regional
                if (bean.getBoton().equals("consultar2")) 
                {
                        bean.setDeclaracion(Util.TablaDetrecaudaciones(gerencia, bean.getFec_desde(), bean.getFec_hasta()));  
                    bean.setEstado("CORRECTO");
                        link = "volver2";
                }
                else 
                {
                    link = "inicio";
                }
            } 
        
        return mapping.findForward(link);
    }
}

