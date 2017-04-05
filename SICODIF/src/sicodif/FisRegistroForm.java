package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class FisRegistroForm extends ActionForm 
{
    private String nrofis;
    
    private String key_year;
    private String key_cuo;
    private String reg_serial;
    private String declaracion;
    private String estado;
    private String fiscalizador;
    
   
        
    private String usuario;
    private String boton;
    private String mensaje;
    private String cdgerencia;
    private String usugerencia;
    private String gerencia;

  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }


    public void setNrofis(String nrofis) {
        this.nrofis = nrofis;
    }

    public String getNrofis() {
        return nrofis;
    }

    public void setKey_year(String key_year) {
        this.key_year = key_year;
    }

    public String getKey_year() {
        return key_year;
    }

    public void setKey_cuo(String key_cuo) {
        this.key_cuo = key_cuo;
    }

    public String getKey_cuo() {
        return key_cuo;
    }

    public void setReg_serial(String reg_serial) {
        this.reg_serial = reg_serial;
    }

    public String getReg_serial() {
        return reg_serial;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setDeclaracion(String declaracion) {
        this.declaracion = declaracion;
    }

    public String getDeclaracion() {
        return declaracion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setFiscalizador(String fiscalizador) {
        this.fiscalizador = fiscalizador;
    }

    public String getFiscalizador() {
        return fiscalizador;
    }

    public void setCdgerencia(String cdgerencia) {
        this.cdgerencia = cdgerencia;
    }

    public String getCdgerencia() {
        return cdgerencia;
    }

    public void setUsugerencia(String usugerencia) {
        this.usugerencia = usugerencia;
    }

    public String getUsugerencia() {
        return usugerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }
}
