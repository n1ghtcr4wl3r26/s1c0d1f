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


public class FisFinalizaAction extends Action {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisFinalizaForm bean = (FisFinalizaForm)request.getAttribute("FisFinalizaForm");
        FisDeclaracionForm dui = new FisDeclaracionForm();
        ActionMessages error = new ActionMessages();

        bean.setFechavenc(Util.DevuelveFechaVenc("GRL","3"));

        String usuario = (String)request.getSession().getAttribute("user.nick");
        bean.setUsuario((String)request.getSession().getAttribute("user.nick"));
        
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
                        bean.setFiscalizador(dui.getFiscalizador());
                        bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                        bean.setFecha_liquidacion(dui.getFec_liquidacion());
                        
                        bean.setSw(Util.DevuelveAutCon(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                        
                        bean.setTip_doc_con(dui.getTip_doc_con());
                        bean.setNro_inf(dui.getNro_inf());
                        bean.setFec_inf(dui.getFec_inf());
                        bean.setNro_doc_con(dui.getNro_doc_con());
                        bean.setFec_doc_con(dui.getFec_doc_con());
                        bean.setOvalor(dui.getOvalor());
                        bean.setOpartida(dui.getOpartida());
                        bean.setOorigen(dui.getOorigen());
                        bean.setOsinobs(dui.getOsinobs());
                        bean.setComision(dui.getComision());
                        bean.setCcondel(dui.getCcondel());
                        bean.setCconcon(dui.getCconcon());
                        bean.setCconadu(dui.getCconadu());
                        
                    }
                    link = "volver";
                }
                else if (bean.getBoton().equals("registrar")) 
                {
                    res = Util.FinalizaControlDiferido(bean, usuario);
                    
                    if (res.substring(0, 5).equals("ERROR")) {
                        bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                    } else {
                        bean.setMensaje(Util.creamensaje("3",
                                                         "Se registr&oacute; exitosamente la Finalizaci&oacute;n del Control Diferido " +
                                                         bean.getNrofis(), "6"));
                        /*bean.setKey_year("");
                        bean.setKey_cuo("");
                        bean.setReg_serial("");
                        */bean.setBoton("");
                        bean.setDeclaracion("");    
                        bean.setEstado("-");
                        dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                        bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                        bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                        bean.setFiscalizador(dui.getFiscalizador());
                        bean.setFecha_liquidacion(dui.getFec_liquidacion());
                    }

                } 
            else if (bean.getBoton().equals("consultar_enm")) 
            {
                dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                if (dui.getMensaje().substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", dui.getMensaje().substring(5), "6"));
                } else {
                    bean.setDeclaracion(Util.TablaDeclaracion(dui)); 
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                    
                    bean.setSw(Util.DevuelveJustAutCon(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    
                    bean.setTip_doc_con(dui.getTip_doc_con());
                    bean.setNro_inf(dui.getNro_inf());
                    bean.setFec_inf(dui.getFec_inf());
                    bean.setNro_doc_con(dui.getNro_doc_con());
                    bean.setFec_doc_con(dui.getFec_doc_con());
                    bean.setOvalor(dui.getOvalor());
                    bean.setOpartida(dui.getOpartida());
                    bean.setOorigen(dui.getOorigen());
                    bean.setOsinobs(dui.getOsinobs());
                    bean.setComision(dui.getComision());
                    bean.setCcondel(dui.getCcondel());
                    bean.setCconcon(dui.getCconcon());
                    bean.setCconadu(dui.getCconadu());
                    
                    Util.DevuelveEnmFin(bean);
                    
                }
                link = "volver2";
            }
            else if (bean.getBoton().equals("registrar_enm")) 
            {
                res = Util.FinalizaControlDiferidoEnm(bean, usuario);
                
                if (res.substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                } else {
                    bean.setMensaje(Util.creamensaje("3",
                                                     "Se registr&oacute; exitosamente la Finalizaci&oacute;n del Control Diferido " +
                                                     bean.getNrofis(), "6"));
                    /*bean.setKey_year("");
                    bean.setKey_cuo("");
                    bean.setReg_serial("");
                    */bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setEstado("-");
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                }
                link = "volver2";
            } else if (bean.getBoton().equals("registrar_just")) 
            {
                res = Util.RegistraJustificativoAutCon(bean, usuario);
                
                if (res.substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                } else {
                    bean.setMensaje(Util.creamensaje("3",
                                                     "Se registr&oacute; exitosamente la Justificaci&oacute;n de la habilitaci&oacute;n del registro de fecha del documento de conclusi&oacute;n anterior a 3 dias" +
                                                     bean.getNrofis(), "6"));
                    bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setEstado("-");
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                }
                link = "volver2";
            }else if (bean.getBoton().equals("cancelar")) 
                {   
                    FisFinalizaForm bean2 = new FisFinalizaForm();
                    request.setAttribute("FisFinalizaForm",bean2);
                    link = "volver";
                }
                else if (bean.getBoton().equals("cancelar_enm")) 
                {   
                    FisFinalizaForm bean2 = new FisFinalizaForm();
                    request.setAttribute("FisFinalizaForm",bean2);
                    link = "volver2";
                }
                
                
                else {
                    link = "inicio";
                }
          
        }
        return mapping.findForward(link);
    }
}
