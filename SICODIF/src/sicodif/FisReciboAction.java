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


public class FisReciboAction extends Action {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisReciboForm bean = (FisReciboForm)request.getAttribute("FisReciboForm");
        FisDeclaracionForm dui = new FisDeclaracionForm();
        ActionMessages error = new ActionMessages();

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
                            bean.setFecha_aceptacion_valid(dui.getFecha_aceptacion());
                            bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                            bean.setFecha_liquidacion(dui.getFec_liquidacion());
                            
                            bean.setCd_gestion(dui.getCd_gestion());
                            bean.setCd_gerencia(dui.getCd_gerencia());
                            bean.setCd_numero(dui.getCd_numero());
                            
                           
                        }
                        
                    bean.setTipo_deuda("");
                    bean.setMonto("");
                    bean.setRec_gestion("");
                    bean.setRec_aduana("");
                    bean.setRec_numero("");
                    bean.setFecha_aceptacion("");
                        link = "volver";
                        
                   
                }
                else if (bean.getBoton().equals("registrar")) 
                {
                    res = Util.RegistroAceptacion(bean, usuario);
                    
                    if (res.substring(0, 5).equals("ERROR")) {
                        bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                    } else {
                        bean.setMensaje(Util.creamensaje("3",
                                                         "Se registr&oacute; exitosamente la Notificaci&oacute;n del Control Diferido " +
                                                         bean.getNrofis(), "6"));
                        /*
                        bean.setKey_year("");
                        bean.setKey_cuo("");
                        bean.setReg_serial("");
*/
                        
                        
                    }
                    
                    bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setEstado("-");
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                    bean.setFecha_aceptacion_valid(dui.getFecha_aceptacion());
                    
                   
                } 
            else if (bean.getBoton().equals("registrar2")) 
            {
                res = Util.RegistroRecibo(bean, usuario);
                
                if (res.substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                } else {
                    bean.setMensaje(Util.creamensaje("3",
                                                     "Se registr&oacute; exitosamente el Recibo de Pago del Control Diferido " +
                                                     bean.getNrofis(), "6"));
                    /*
                    bean.setKey_year("");
                    bean.setKey_cuo("");
                    bean.setReg_serial("");
            */
                    
                }
                bean.setBoton("");
                bean.setDeclaracion("");    
                bean.setEstado("-");
                dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                bean.setFiscalizador(dui.getFiscalizador());
                bean.setFecha_liquidacion(dui.getFec_liquidacion());
                
               
            }
            else if (bean.getBoton().equals("eliminar")) 
            {
                res = Util.EliminaRecibo(bean, usuario);
                
                if (res.substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                } else {
                    bean.setMensaje(Util.creamensaje("3",
                                                     "Se Elimin&oacute; exitosamente el Recibo de Pago del Control Diferido " +
                                                     bean.getNrofis(), "6"));
                    /*
                    bean.setKey_year("");
                    bean.setKey_cuo("");
                    bean.setReg_serial("");
            */
                    bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setEstado("-");
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                }
               
            } else                 
                
                
                if (bean.getBoton().equals("consultar_enm")) 
                {
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                        if (dui.getMensaje().substring(0, 5).equals("ERROR")) {
                            bean.setMensaje(Util.creamensaje("2", dui.getMensaje().substring(5), "6"));
                        } else {
                            bean.setDeclaracion(Util.TablaDeclaracion(dui));  
                            bean.setFiscalizador(dui.getFiscalizador());
                            bean.setFecha_aceptacion_valid(dui.getFecha_aceptacion());
                            bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                            bean.setFecha_liquidacion(dui.getFec_liquidacion());
                            
                            bean.setCd_gestion(dui.getCd_gestion());
                            bean.setCd_gerencia(dui.getCd_gerencia());
                            bean.setCd_numero(dui.getCd_numero());
                            
                           
                        }
                        
                    bean.setTipo_deuda("");
                    bean.setMonto("");
                    bean.setRec_gestion("");
                    bean.setRec_aduana("");
                    bean.setRec_numero("");
                    bean.setFecha_aceptacion("");
                    
                    Util.DevuelveEnmRec(bean);
                    
                    link = "volver2";
                }
                else if (bean.getBoton().equals("registrar_enm")) 
                {
                    res = Util.RegistroAceptacion(bean, usuario);
                    
                    if (res.substring(0, 5).equals("ERROR")) {
                        bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                    } else {
                        bean.setMensaje(Util.creamensaje("3",
                                                         "Se registr&oacute; exitosamente la Notificaci&oacute;n del Control Diferido " +
                                                         bean.getNrofis(), "6"));
                        /*
                        bean.setKey_year("");
                        bean.setKey_cuo("");
                        bean.setReg_serial("");
*/
                        
                        
                    }
                    
                    bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setEstado("-");
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                    bean.setFecha_aceptacion_valid(dui.getFecha_aceptacion());
                    
                    Util.DevuelveEnmRec(bean);
                    link = "volver2";
                   
                } 
            else if (bean.getBoton().equals("registrar2_enm")) 
            {
                res = Util.RegistroRecibo(bean, usuario);
                
                if (res.substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                } else {
                    bean.setMensaje(Util.creamensaje("3",
                                                     "Se registr&oacute; exitosamente el Recibo de Pago del Control Diferido " +
                                                     bean.getNrofis(), "6"));
                    /*
                    bean.setKey_year("");
                    bean.setKey_cuo("");
                    bean.setReg_serial("");
            */
                    
                }
                bean.setBoton("");
                bean.setDeclaracion("");    
                bean.setEstado("-");
                dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                bean.setFiscalizador(dui.getFiscalizador());
                bean.setFecha_liquidacion(dui.getFec_liquidacion());
                Util.DevuelveEnmRec(bean);
                link = "volver2";
            }
            else if (bean.getBoton().equals("eliminar_enm")) 
            {
                res = Util.EliminaRecibo(bean, usuario);
                
                if (res.substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                } else {
                    bean.setMensaje(Util.creamensaje("3",
                                                     "Se Elimin&oacute; exitosamente el Recibo de Pago del Control Diferido " +
                                                     bean.getNrofis(), "6"));
                    /*
                    bean.setKey_year("");
                    bean.setKey_cuo("");
                    bean.setReg_serial("");
            */
                    bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setEstado("-");
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                    Util.DevuelveEnmRec(bean);
                }
                
                link = "volver2";

            } else if (bean.getBoton().equals("eliminafec_enm")) 
            {
                res = Util.EliminaFechaAceptacion(bean, usuario);
                
                if (res.substring(0, 5).equals("ERROR")) {
                    bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                } else {
                    bean.setMensaje(Util.creamensaje("3",
                                                     "Se Elimin\363 exitosamente la fecha de aceptaci\363n de pago del Control Diferido " +
                                                     bean.getNrofis(), "6"));
                    /*
                    bean.setKey_year("");
                    bean.setKey_cuo("");
                    bean.setReg_serial("");
            */
                    bean.setBoton("");
                    bean.setDeclaracion("");    
                    bean.setEstado("-");
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                    bean.setDeclaracion(Util.TablaDeclaracion(dui));    
                    bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                    bean.setFiscalizador(dui.getFiscalizador());
                    bean.setFecha_liquidacion(dui.getFec_liquidacion());
                }
                Util.DevuelveEnmRec(bean);
                link = "volver2";

            } else 
                
                
                if (bean.getBoton().equals("cancelar")) 
                {   
                    FisReciboForm bean2 = new FisReciboForm();
                    request.setAttribute("FisReciboForm",bean2);
                    link = "volver";
                }
                else if (bean.getBoton().equals("cancelar_enm")) 
                {   
                    FisReciboForm bean2 = new FisReciboForm();
                    request.setAttribute("FisReciboForm",bean2);
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
