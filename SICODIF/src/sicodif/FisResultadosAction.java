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


public class FisResultadosAction extends Action {
    /**
     * This is the main action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        FisResultadosForm bean = (FisResultadosForm)request.getAttribute("FisResultadosForm");
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
                            bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                            bean.setFecha_notificacion(dui.getFecha_notificacion());
                            
                            bean.setFec_liq(dui.getFec_liq());
                            bean.setValor_ufv(dui.getValor_ufv());
                            bean.setTributo_ga(dui.getTributo_ga());
                            bean.setTributo_iva(dui.getTributo_iva());
                            bean.setTributo_ice(dui.getTributo_ice());
                            bean.setTributo_iehd(dui.getTributo_iehd());
                            bean.setSancion(dui.getSancion());
                            bean.setMultaca(dui.getMultaca());
                            bean.setMultacc(dui.getMultacc());
                            bean.setMultacd(dui.getMultacd());
                            
                            bean.setTributo_ufv_ga(dui.getTributo_ufv_ga());
                            bean.setTributo_ufv_iva(dui.getTributo_ufv_iva());
                            bean.setTributo_ufv_ice(dui.getTributo_ufv_ice());
                            bean.setTributo_ufv_iehd(dui.getTributo_ufv_iehd());
                            bean.setSancion_ufv(dui.getSancion_ufv());
                            bean.setMultaca_ufv(dui.getMultaca_ufv());
                            bean.setMultacc_ufv(dui.getMultacc_ufv());
                            bean.setMultacd_ufv(dui.getMultacd_ufv());
                            
                            bean.setFobinicial(dui.getFobinicial());
                            bean.setFobfinal(dui.getFobfinal());
                        }
                        link = "volver";
                }
                else if (bean.getBoton().equals("registrar")) 
                {
                    res = Util.ResultadosControlDiferido(bean, usuario);
                    
                    if (res.substring(0, 5).equals("ERROR")) {
                        bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                    } else {
                        bean.setMensaje(Util.creamensaje("3",
                                                         "Se registr&oacute; exitosamente los Resultados del Control Diferido " +
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
                        bean.setFecha_notificacion(dui.getFecha_notificacion());
                        
                        bean.setFec_liq(dui.getFec_liq());
                        bean.setValor_ufv(dui.getValor_ufv());
                        bean.setTributo_ga(dui.getTributo_ga());
                        bean.setTributo_iva(dui.getTributo_iva());
                        bean.setTributo_ice(dui.getTributo_ice());
                        bean.setTributo_iehd(dui.getTributo_iehd());
                        
                        bean.setSancion(dui.getSancion());
                        bean.setMultaca(dui.getMultaca());
                        bean.setMultacc(dui.getMultacc());
                        bean.setMultacd(dui.getMultacd());
                        
                        bean.setTributo_ufv_ga(dui.getTributo_ufv_ga());
                        bean.setTributo_ufv_iva(dui.getTributo_ufv_iva());
                        bean.setTributo_ufv_ice(dui.getTributo_ufv_ice());
                        bean.setTributo_ufv_iehd(dui.getTributo_ufv_iehd());
                        bean.setSancion_ufv(dui.getSancion_ufv());
                        bean.setMultaca_ufv(dui.getMultaca_ufv());
                        bean.setMultacc_ufv(dui.getMultacc_ufv());
                        bean.setMultacd_ufv(dui.getMultacd_ufv());
                        
                        bean.setFobinicial(dui.getFobinicial());
                        bean.setFobfinal(dui.getFobfinal());
                    }

                } else if (bean.getBoton().equals("consultar_enm")) 
                {
                    dui = Util.DevuelveDUI(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial());
                        if (dui.getMensaje().substring(0, 5).equals("ERROR")) {
                            bean.setMensaje(Util.creamensaje("2", dui.getMensaje().substring(5), "6"));
                        } else {
                            bean.setDeclaracion(Util.TablaDeclaracion(dui));  
                            bean.setFiscalizador(dui.getFiscalizador());
                            bean.setEstado(Util.DevuelveEstado(bean.getKey_year(),bean.getKey_cuo(),bean.getReg_serial()));
                            bean.setFecha_notificacion(dui.getFecha_notificacion());
                            
                            bean.setFec_liq(dui.getFec_liq());
                            bean.setValor_ufv(dui.getValor_ufv());
                            bean.setTributo_ga(dui.getTributo_ga());
                            bean.setTributo_iva(dui.getTributo_iva());
                            bean.setTributo_ice(dui.getTributo_ice());
                            bean.setTributo_iehd(dui.getTributo_iehd());
                            bean.setSancion(dui.getSancion());
                            bean.setMultaca(dui.getMultaca());
                            bean.setMultacc(dui.getMultacc());
                            bean.setMultacd(dui.getMultacd());
                            
                            bean.setTributo_ufv_ga(dui.getTributo_ufv_ga());
                            bean.setTributo_ufv_iva(dui.getTributo_ufv_iva());
                            bean.setTributo_ufv_ice(dui.getTributo_ufv_ice());
                            bean.setTributo_ufv_iehd(dui.getTributo_ufv_iehd());
                            bean.setSancion_ufv(dui.getSancion_ufv());
                            bean.setMultaca_ufv(dui.getMultaca_ufv());
                            bean.setMultacc_ufv(dui.getMultacc_ufv());
                            bean.setMultacd_ufv(dui.getMultacd_ufv());
                            
                            bean.setFobinicial(dui.getFobinicial());
                            bean.setFobfinal(dui.getFobfinal());
                                                        
                            Util.DevuelveEnmRes(bean);
                            
                        }
                        link = "volver2";
                }
                else if (bean.getBoton().equals("registrar_enm")) 
                {
                    res = Util.ResultadosControlDiferidoEnm(bean, usuario);
                    
                    if (res.substring(0, 5).equals("ERROR")) {
                        bean.setMensaje(Util.creamensaje("2", res.substring(5), "6"));
                    } else {
                        bean.setMensaje(Util.creamensaje("3",
                                                         "Se registr&oacute; exitosamente los Resultados del Control Diferido " +
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
                        bean.setFecha_notificacion(dui.getFecha_notificacion());
                        
                        bean.setFec_liq(dui.getFec_liq());
                        bean.setValor_ufv(dui.getValor_ufv());
                        bean.setTributo_ga(dui.getTributo_ga());
                        bean.setTributo_iva(dui.getTributo_iva());
                        bean.setTributo_ice(dui.getTributo_ice());
                        bean.setTributo_iehd(dui.getTributo_iehd());
                        
                        bean.setSancion(dui.getSancion());
                        bean.setMultaca(dui.getMultaca());
                        bean.setMultacc(dui.getMultacc());
                        bean.setMultacd(dui.getMultacd());
                        
                        bean.setTributo_ufv_ga(dui.getTributo_ufv_ga());
                        bean.setTributo_ufv_iva(dui.getTributo_ufv_iva());
                        bean.setTributo_ufv_ice(dui.getTributo_ufv_ice());
                        bean.setTributo_ufv_iehd(dui.getTributo_ufv_iehd());
                        bean.setSancion_ufv(dui.getSancion_ufv());
                        bean.setMultaca_ufv(dui.getMultaca_ufv());
                        bean.setMultacc_ufv(dui.getMultacc_ufv());
                        bean.setMultacd_ufv(dui.getMultacd_ufv());
                        
                        bean.setFobinicial(dui.getFobinicial());
                        bean.setFobfinal(dui.getFobfinal());
                        
                        Util.DevuelveEnmRes(bean);
                    }
                    link = "volver2";
                }else if (bean.getBoton().equals("cancelar")) 
                {   
                    FisResultadosForm bean2 = new FisResultadosForm();
                    request.setAttribute("FisResultadosForm",bean2);
                    link = "volver";
                }
                else if (bean.getBoton().equals("cancelar_enm")) 
                {   
                    FisResultadosForm bean2 = new FisResultadosForm();
                    request.setAttribute("FisResultadosForm",bean2);
                    link = "volver2";
                }
                
                
                else {
                    link = "inicio";
                }
          
        }
        return mapping.findForward(link);
    }
}
