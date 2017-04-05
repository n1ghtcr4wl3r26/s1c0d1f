package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class FisRconcesionarioForm extends ActionForm 
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
    
    private String reporte;
    
    
    private String gerencia;
    private String fec_desde;
    private String fec_hasta;
    
    private String aduana;
    private String gestion;
    private String numero;
    private String nit;
    

    private String usuario;
    private String boton;
    private String mensaje;
    private String fiscalizador;
    
    private String etapa;

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

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setFec_desde(String fec_desde) {
        this.fec_desde = fec_desde;
    }

    public String getFec_desde() {
        return fec_desde;
    }

    public void setFec_hasta(String fec_hasta) {
        this.fec_hasta = fec_hasta;
    }

    public String getFec_hasta() {
        return fec_hasta;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getReporte() {
        return reporte;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setAduana(String aduana) {
        this.aduana = aduana;
    }

    public String getAduana() {
        return aduana;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getGestion() {
        return gestion;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }
}
