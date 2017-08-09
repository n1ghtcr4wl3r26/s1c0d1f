package sicodif;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class FisRconblockAction extends Action {
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisRconblockForm bean = (FisRconblockForm)request.getAttribute("FisRconblockForm");
        bean.setUsuario((String)request.getSession().getAttribute("user.nick"));
        request.setAttribute("FisRconblockForm", bean);
        return mapping.findForward("reporte");
    }
}
