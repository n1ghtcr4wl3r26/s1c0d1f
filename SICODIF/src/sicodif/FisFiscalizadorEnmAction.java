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


public class FisFiscalizadorEnmAction extends Action {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisFiscalizadorEnmForm bean = (FisFiscalizadorEnmForm)request.getAttribute("FisFiscalizadorEnmForm");
        FisDeclaracionForm dui = new FisDeclaracionForm();
        ActionMessages error = new ActionMessages();

        String usuario = (String)request.getSession().getAttribute("user.nick");
        bean.setUsuario((String)request.getSession().getAttribute("user.nick"));
        bean.setUsugerencia((String)request.getSession().getAttribute("user.codger"));
        bean.setKey_cuo(bean.getKey_cuo());
        
        String res;
        String link = "volver";

        if (usuario != null) {
                if (bean.getBoton().equals("consultar")) 
                {
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    if (dui.getMensaje().substring(0, 5).equals("ERROR")) {
                        bean.setMensaje(Util.creamensaje("2", dui.getMensaje().substring(5), "6"));
                    } else {
                        bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                        bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    }
                    
                    Util.DevuelveEnmFis(bean);
                    request.setAttribute("FisFiscalizadorEnmForm", bean);
                    link = "volver";
                }
                else if (bean.getBoton().equals("registrar")) 
                {
                    res = Util.FiscalizadorEnm(bean, usuario);
                    
                    if (res.substring(0, 5).equals("ERROR")) {
                        bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                    } else {
                        bean.setMensaje(Util.creamensaje("3",
                                                         "Se registr&oacute; exitosamente el Control Diferido " +
                                                         bean.getNrofis(), "6"));
                        /*
                        bean.setKey_year("");
                        bean.setKey_cuo("");
                        bean.setReg_serial("");
                        
                        */
                        bean.setEstado("-");
                        bean.setBoton("");
                        bean.setDeclaracion("");    
                        dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                        bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                        bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                        bean.setFiscalizador(dui.getFiscalizador());
                        
                    }
                    request.setAttribute("FisFiscalizadorEnmForm", bean);

                } 
            else if (bean.getBoton().equals("cancelar")) 
            {
                
                    bean.setKey_year("");
                    bean.setKey_cuo("");
                    bean.setReg_serial("");
                    
                    bean.setEstado("");
                    bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setFiscalizador("");
                    request.setAttribute("FisFiscalizadorEnmForm", bean);

            } 
                
                else {
                    link = "inicio";
                }
          
        }
        
        
        return mapping.findForward(link);
    }
}
