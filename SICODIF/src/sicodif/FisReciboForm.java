package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class FisReciboForm extends ActionForm 
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

    private String gestion;
    private String gerencia;
    private String nro_control;
    
    private String cd_gestion;
    private String cd_gerencia;
    private String cd_numero;
    
    private String fecha_aceptacion;
    
    private String fecha_aceptacion_valid;
    
    private String fecha_liquidacion;
    
    private String rec_gestion;
    private String rec_aduana;
    private String rec_numero;
    
    private String tipo_deuda;
        private String monto;
        private String nro_recibo;
        private String fecha_pago;
        private String id;

    private String usuario;
    private String boton;
    private String mensaje;
    private String fiscalizador;
    
    
    private String etapa;
    private String cdgerencia;
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

    public void setFecha_aceptacion(String fecha_aceptacion) {
        this.fecha_aceptacion = fecha_aceptacion;
    }

    public String getFecha_aceptacion() {
        return fecha_aceptacion;
    }

    public void setTipo_deuda(String tipo_deuda) {
        this.tipo_deuda = tipo_deuda;
    }

    public String getTipo_deuda() {
        return tipo_deuda;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonto() {
        return monto;
    }

    public void setNro_recibo(String nro_recibo) {
        this.nro_recibo = nro_recibo;
    }

    public String getNro_recibo() {
        return nro_recibo;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setNro_control(String nro_control) {
        this.nro_control = nro_control;
    }

    public String getNro_control() {
        return nro_control;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setRec_gestion(String rec_gestion) {
        this.rec_gestion = rec_gestion;
    }

    public String getRec_gestion() {
        return rec_gestion;
    }

    public void setRec_aduana(String rec_aduana) {
        this.rec_aduana = rec_aduana;
    }

    public String getRec_aduana() {
        return rec_aduana;
    }

    public void setRec_numero(String rec_numero) {
        this.rec_numero = rec_numero;
    }

    public String getRec_numero() {
        return rec_numero;
    }

    public void setFecha_liquidacion(String fecha_liquidacion) {
        this.fecha_liquidacion = fecha_liquidacion;
    }

    public String getFecha_liquidacion() {
        return fecha_liquidacion;
    }

    public void setFecha_aceptacion_valid(String fecha_aceptacion_valid) {
        this.fecha_aceptacion_valid = fecha_aceptacion_valid;
    }

    public String getFecha_aceptacion_valid() {
        return fecha_aceptacion_valid;
    }

    public void setCd_gestion(String cd_gestion) {
        this.cd_gestion = cd_gestion;
    }

    public String getCd_gestion() {
        return cd_gestion;
    }

    public void setCd_gerencia(String cd_gerencia) {
        this.cd_gerencia = cd_gerencia;
    }

    public String getCd_gerencia() {
        return cd_gerencia;
    }

    public void setCd_numero(String cd_numero) {
        this.cd_numero = cd_numero;
    }

    public String getCd_numero() {
        return cd_numero;
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
}
