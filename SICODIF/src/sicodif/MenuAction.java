package sicodif;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class MenuAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        MenuForm bMenu = (MenuForm)form;
        ClaseSession cs = new ClaseSession();
        request.getSession().setAttribute("ClaseSession", cs);
        String direc = "0";

        if (bMenu.getOpcion().equals("reg.cdi")) {
            direc = "reg.cdi";

        } else if (bMenu.getOpcion().equals("reg.not")) {
            direc = "reg.not";

        } else if (bMenu.getOpcion().equals("reg.res")) {
            direc = "reg.res";

        } else if (bMenu.getOpcion().equals("reg.rec")) {
            direc = "reg.rec";

        } else if (bMenu.getOpcion().equals("reg.fin")) {
            direc = "reg.fin";

        } else if (bMenu.getOpcion().equals("reg.fnd")) {
            direc = "reg.fnd";

        } else if (bMenu.getOpcion().equals("reg.eul")) {
            direc = "reg.eul";

        } else if (bMenu.getOpcion().equals("rep.mer")) {
            FisRmercaderiaForm rep = new FisRmercaderiaForm();
            rep.setReporte("nacional");
            request.setAttribute("FisRmercaderiaForm", rep);
            direc = "rep.mer";
       
        } else if (bMenu.getOpcion().equals("rep.fis")) {
                FisRfiscalizadoresForm rep = new FisRfiscalizadoresForm();
                rep.setReporte("nacional");
                request.setAttribute("FisRfiscalizadoresForm", rep);
                direc = "rep.fis";

        } else if (bMenu.getOpcion().equals("rep.base")) {
            FisRbaseForm rep = new FisRbaseForm();
            rep.setReporte("nacional");
            request.setAttribute("FisRbaseForm", rep);
            direc = "rep.base";

        } else if (bMenu.getOpcion().equals("rep.pag")) {
            FisRpagadosForm rep = new FisRpagadosForm();
            rep.setReporte("nacional");
            request.setAttribute("FisRpagadosForm", rep);
            direc = "rep.pag";

        } else if (bMenu.getOpcion().equals("rep.rec")) {
                FisRrecaudacionesForm rep = new FisRrecaudacionesForm();
                rep.setReporte("nacional");
                request.setAttribute("FisRrecaudacionesForm", rep);
                direc = "rep.rec";


        } else if (bMenu.getOpcion().equals("rep.nop")) {
            FisRnopagadosForm rep = new FisRnopagadosForm();
            rep.setReporte("nacional");
            request.setAttribute("FisRnopagadosForm", rep);
            direc = "rep.nop";

        } else if (bMenu.getOpcion().equals("rep.mer2")) {
            FisRmercaderiaForm rep = new FisRmercaderiaForm();
            rep.setReporte("regional");
            request.setAttribute("FisRmercaderiaForm", rep);
            direc = "rep.mer2";

            } else if (bMenu.getOpcion().equals("rep.fis2")) {
                    FisRfiscalizadoresForm rep = new FisRfiscalizadoresForm();
                    rep.setReporte("regional");
                    request.setAttribute("FisRfiscalizadoresForm", rep);
                    direc = "rep.fis2";


        } else if (bMenu.getOpcion().equals("rep.pag2")) {
            FisRpagadosForm rep = new FisRpagadosForm();
            rep.setReporte("regional");
            request.setAttribute("FisRpagadosForm", rep);
            direc = "rep.pag2";

        } else if (bMenu.getOpcion().equals("rep.nop2")) {
            FisRnopagadosForm rep = new FisRnopagadosForm();
            rep.setReporte("regional");
            request.setAttribute("FisRnopagadosForm", rep);
            direc = "rep.nop2";

        } else if (bMenu.getOpcion().equals("dec.asi")) {
            FisDecAsigForm bean = new FisDecAsigForm();
            bean.setGerencia((String)request.getSession().getAttribute("user.gerencia"));
            request.setAttribute("FisDecAsigForm", bean);
            direc = "dec.asi";

        } else if (bMenu.getOpcion().equals("dec.fis")) {
            FisDecFisForm bean = new FisDecFisForm();
            bean.setUsuario((String)request.getSession().getAttribute("user.nick"));
            request.setAttribute("FisDecFisForm", bean);
            direc = "dec.fis";

        } else if (bMenu.getOpcion().equals("enm.not")) {
            direc = "enm.not";

        } else if (bMenu.getOpcion().equals("enm.res")) {
            direc = "enm.res";

        } else if (bMenu.getOpcion().equals("enm.rec")) {
            direc = "enm.rec";

        } else if (bMenu.getOpcion().equals("enm.fin")) {
            direc = "enm.fin";

        } else if (bMenu.getOpcion().equals("enm.fnd")) {
            direc = "enm.fnd";

        } else if (bMenu.getOpcion().equals("enm.eul")) {
            direc = "enm.eul";

        } else if (bMenu.getOpcion().equals("enm.fis")) {
            direc = "enm.fis";

        } else if (bMenu.getOpcion().equals("cam.usu")) {
            direc = "cam.usu";
        
        
        } else if (bMenu.getOpcion().equals("rep.con.cierre")) {
            direc = "rep.con.cierre";
            
        } else if (bMenu.getOpcion().equals("rep.bloq")) {
            direc = "rep.bloq";
            
        } else if (bMenu.getOpcion().equals("rep.pen")) {
            direc = "rep.pen";
            
        
        //reporte de Resultados Deuda Determinada   
        } else if (bMenu.getOpcion().equals("rep.deuda")) {
                FisRdetRecaudacionesForm rep = new FisRdetRecaudacionesForm();
                rep.setReporte("nacional");
                request.setAttribute("FisRdetRecaudacionesForm", rep);
                direc = "rep.deuda";
                
        //Anulacion de los controles diferidos 
        } else if (bMenu.getOpcion().equals("anu.contdif")) {                
                direc = "anu.contdif";              
        } 
        //Cierre de un control diferido  
         else if (bMenu.getOpcion().equals("reg.cierrecontdif")) {                
                direc = "reg.cierrecontdif";   
        }
        //reporte de estada de asignacion de canal  
         else if (bMenu.getOpcion().equals("fis.rep.sincanal")) {                
                direc = "fis.rep.sincanal";   
        } else if (bMenu.getOpcion().equals("rep.con")) {
            direc = "fis.rep.concesionario";
        }
        else if (bMenu.getOpcion().equals("rep.enm")) {
                    direc = "rep.enm";

                }
        
        else if (bMenu.getOpcion().equals("exit.ser")) {
            request.getSession().removeAttribute("ClaseUsuario");
            request.getSession().removeAttribute("inputActionForm");
            request.getSession().removeAttribute("user.nick");
            request.getSession().removeAttribute("ClaseSession");
            direc = "exit";

        } else {
            request.getSession().removeAttribute("ClaseUsuario");
            request.getSession().removeAttribute("inputActionForm");
            request.getSession().removeAttribute("user.nick");
            request.getSession().removeAttribute("ClaseSession");
            direc = "exit";
        }
        return mapping.findForward(direc);
    }

   
}
