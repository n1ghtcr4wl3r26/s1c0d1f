package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class FisResultadosForm extends ActionForm 
{
    private String nrofis;
    
    private String key_year;
    private String key_cuo;
    private String reg_serial;
    private String fecha_notificacion;
    private String observacion;
    private String declaracion;
    private String estado;
    private String tipo;
    
    private String fec_liq;
    
    private String tributo_ga;
    private String tributo_iva;
    private String tributo_ice;
    private String tributo_iehd;
    private String sancion;
    private String multaca;
    private String multacc;
    private String multacd;
    
    private String tributo_ufv_ga;
    private String tributo_ufv_iva;
    private String tributo_ufv_ice;
    private String tributo_ufv_iehd;
    private String sancion_ufv;
    private String multaca_ufv;
    private String multacc_ufv;
    private String multacd_ufv;
    
    private String valor_ufv; 

    private String usuario;
    private String boton;
    private String mensaje;
    private String fiscalizador;
    
    private String etapa;
    private String cdgerencia;
    
    private String fobinicial;
    private String fobfinal;
    
    private String observacionenm;
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

    public void setFecha_notificacion(String fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    public String getFecha_notificacion() {
        return fecha_notificacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setFiscalizador(String fiscalizador) {
        this.fiscalizador = fiscalizador;
    }

    public String getFiscalizador() {
        return fiscalizador;
    }

    public void setFec_liq(String fec_liq) {
        this.fec_liq = fec_liq;
    }

    public String getFec_liq() {
        return fec_liq;
    }


    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

    public String getSancion() {
        return sancion;
    }

    public void setMultaca(String multaca) {
        this.multaca = multaca;
    }

    public String getMultaca() {
        return multaca;
    }

    public void setMultacc(String multacc) {
        this.multacc = multacc;
    }

    public String getMultacc() {
        return multacc;
    }

    public void setMultacd(String multacd) {
        this.multacd = multacd;
    }

    public String getMultacd() {
        return multacd;
    }

   
    public void setSancion_ufv(String sancion_ufv) {
        this.sancion_ufv = sancion_ufv;
    }

    public String getSancion_ufv() {
        return sancion_ufv;
    }

    public void setMultaca_ufv(String multaca_ufv) {
        this.multaca_ufv = multaca_ufv;
    }

    public String getMultaca_ufv() {
        return multaca_ufv;
    }

    public void setMultacc_ufv(String multacc_ufv) {
        this.multacc_ufv = multacc_ufv;
    }

    public String getMultacc_ufv() {
        return multacc_ufv;
    }

    public void setMultacd_ufv(String multacd_ufv) {
        this.multacd_ufv = multacd_ufv;
    }

    public String getMultacd_ufv() {
        return multacd_ufv;
    }

    public void setValor_ufv(String valor_ufv) {
        this.valor_ufv = valor_ufv;
    }

    public String getValor_ufv() {
        return valor_ufv;
    }

    public void setTributo_ga(String tributo_ga) {
        this.tributo_ga = tributo_ga;
    }

    public String getTributo_ga() {
        return tributo_ga;
    }

    public void setTributo_iva(String tributo_iva) {
        this.tributo_iva = tributo_iva;
    }

    public String getTributo_iva() {
        return tributo_iva;
    }

    public void setTributo_ice(String tributo_ice) {
        this.tributo_ice = tributo_ice;
    }

    public String getTributo_ice() {
        return tributo_ice;
    }

    public void setTributo_iehd(String tributo_iehd) {
        this.tributo_iehd = tributo_iehd;
    }

    public String getTributo_iehd() {
        return tributo_iehd;
    }

    public void setTributo_ufv_ga(String tributo_ufv_ga) {
        this.tributo_ufv_ga = tributo_ufv_ga;
    }

    public String getTributo_ufv_ga() {
        return tributo_ufv_ga;
    }

    public void setTributo_ufv_iva(String tributo_ufv_iva) {
        this.tributo_ufv_iva = tributo_ufv_iva;
    }

    public String getTributo_ufv_iva() {
        return tributo_ufv_iva;
    }

    public void setTributo_ufv_ice(String tributo_ufv_ice) {
        this.tributo_ufv_ice = tributo_ufv_ice;
    }

    public String getTributo_ufv_ice() {
        return tributo_ufv_ice;
    }

    public void setTributo_ufv_iehd(String tributo_ufv_iehd) {
        this.tributo_ufv_iehd = tributo_ufv_iehd;
    }

    public String getTributo_ufv_iehd() {
        return tributo_ufv_iehd;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setCdgerencia(String cdgerencia) {
        this.cdgerencia = cdgerencia;
    }

    public String getCdgerencia() {
        return cdgerencia;
    }

    public void setFobinicial(String fobinicial) {
        this.fobinicial = fobinicial;
    }

    public String getFobinicial() {
        return fobinicial;
    }

    public void setFobfinal(String fobfinal) {
        this.fobfinal = fobfinal;
    }

    public String getFobfinal() {
        return fobfinal;
    }

    public void setObservacionenm(String observacionenm) {
        this.observacionenm = observacionenm;
    }

    public String getObservacionenm() {
        return observacionenm;
    }
}
