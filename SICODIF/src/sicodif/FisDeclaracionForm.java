package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class FisDeclaracionForm extends ActionForm 
{
    private String nrofis;
    
    private String key_year;
    private String key_cuo;
    private String reg_serial;
    
    private String administracion_aduana;
    private String vista;
    private String importador;
    private String despachante;
    private String fecha_registro;
    private String canal;
    private String fecha_pasedesalida;
    
    private String fecha_registro_control;
    private String usuario_registro;
    private String fecha_notificacion;
    private String obs_notificacion;
    private String usuario_notificacion;
    
    private String fec_liquidacion;
    private String monto_total;
    private String usuario_resultados;
    
    private String fec_not_doc;
    private String tip_not_doc;
    
    private String fec_env_legal;
    private String nro_env_legal;
    
    
    private String fecha_finalizacion;
    private String obs_finalizacion;
    private String usuario_finalizacion;
    
    private String fecha_aceptacion;
    
    
    private String fiscalizador;
    
    private String fecha_doc_con;
    
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
    
    private String usuario_aceptacion;
    private String usuario_not_doc_con;
    private String usuario_env_legal;
    
    private String estado;
    private String usuario;
    private String boton;
    private String mensaje;
    
    private String cd_gestion;
    private String cd_gerencia;
    private String cd_numero;
    
    
    
    
    private String tip_doc_con;
    private String nro_inf;
    private String fec_inf;
    private String nro_doc_con;
    private String fec_doc_con;
     private String ovalor;
     private String opartida;
     private String oorigen;
     private String osinobs;
     private String comision;
     private String ccondel;
     private String cconcon;
     private String cconadu;
     
     private String pagina;
     
    private String origen;
    
    private String usuariolog;
    private String fechalog;
    private String fobinicial;
    private String fobfinal;

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

    public void setAdministracion_aduana(String administracion_aduana) {
        this.administracion_aduana = administracion_aduana;
    }

    public String getAdministracion_aduana() {
        return administracion_aduana;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getVista() {
        return vista;
    }

    public void setImportador(String importador) {
        this.importador = importador;
    }

    public String getImportador() {
        return importador;
    }

    public void setDespachante(String despachante) {
        this.despachante = despachante;
    }

    public String getDespachante() {
        return despachante;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }

    public void setFecha_pasedesalida(String fecha_pasedesalida) {
        this.fecha_pasedesalida = fecha_pasedesalida;
    }

    public String getFecha_pasedesalida() {
        return fecha_pasedesalida;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setFecha_registro_control(String fecha_registro_control) {
        this.fecha_registro_control = fecha_registro_control;
    }

    public String getFecha_registro_control() {
        return fecha_registro_control;
    }

    public void setUsuario_registro(String usuario_registro) {
        this.usuario_registro = usuario_registro;
    }

    public String getUsuario_registro() {
        return usuario_registro;
    }

    public void setFecha_notificacion(String fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    public String getFecha_notificacion() {
        return fecha_notificacion;
    }

    public void setObs_notificacion(String obs_notificacion) {
        this.obs_notificacion = obs_notificacion;
    }

    public String getObs_notificacion() {
        return obs_notificacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setObs_finalizacion(String obs_finalizacion) {
        this.obs_finalizacion = obs_finalizacion;
    }

    public String getObs_finalizacion() {
        return obs_finalizacion;
    }

    public void setUsuario_notificacion(String usuario_notificacion) {
        this.usuario_notificacion = usuario_notificacion;
    }

    public String getUsuario_notificacion() {
        return usuario_notificacion;
    }

    public void setUsuario_finalizacion(String usuario_finalizacion) {
        this.usuario_finalizacion = usuario_finalizacion;
    }

    public String getUsuario_finalizacion() {
        return usuario_finalizacion;
    }

    public void setFiscalizador(String fiscalizador) {
        this.fiscalizador = fiscalizador;
    }

    public String getFiscalizador() {
        return fiscalizador;
    }

    public void setFec_liquidacion(String fec_liquidacion) {
        this.fec_liquidacion = fec_liquidacion;
    }

    public String getFec_liquidacion() {
        return fec_liquidacion;
    }

    public void setMonto_total(String monto_total) {
        this.monto_total = monto_total;
    }

    public String getMonto_total() {
        return monto_total;
    }

    public void setUsuario_resultados(String usuario_resultados) {
        this.usuario_resultados = usuario_resultados;
    }

    public String getUsuario_resultados() {
        return usuario_resultados;
    }

    public void setFec_not_doc(String fec_not_doc) {
        this.fec_not_doc = fec_not_doc;
    }

    public String getFec_not_doc() {
        return fec_not_doc;
    }

    public void setTip_not_doc(String tip_not_doc) {
        this.tip_not_doc = tip_not_doc;
    }

    public String getTip_not_doc() {
        return tip_not_doc;
    }

    public void setFec_env_legal(String fec_env_legal) {
        this.fec_env_legal = fec_env_legal;
    }

    public String getFec_env_legal() {
        return fec_env_legal;
    }

    public void setNro_env_legal(String nro_env_legal) {
        this.nro_env_legal = nro_env_legal;
    }

    public String getNro_env_legal() {
        return nro_env_legal;
    }

    public void setFecha_aceptacion(String fecha_aceptacion) {
        this.fecha_aceptacion = fecha_aceptacion;
    }

    public String getFecha_aceptacion() {
        return fecha_aceptacion;
    }

    public void setFecha_doc_con(String fecha_doc_con) {
        this.fecha_doc_con = fecha_doc_con;
    }

    public String getFecha_doc_con() {
        return fecha_doc_con;
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

    public void setUsuario_aceptacion(String usuario_aceptacion) {
        this.usuario_aceptacion = usuario_aceptacion;
    }

    public String getUsuario_aceptacion() {
        return usuario_aceptacion;
    }

    public void setUsuario_not_doc_con(String usuario_not_doc_con) {
        this.usuario_not_doc_con = usuario_not_doc_con;
    }

    public String getUsuario_not_doc_con() {
        return usuario_not_doc_con;
    }

    public void setUsuario_env_legal(String usuario_env_legal) {
        this.usuario_env_legal = usuario_env_legal;
    }

    public String getUsuario_env_legal() {
        return usuario_env_legal;
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

    public void setTip_doc_con(String tip_doc_con) {
        this.tip_doc_con = tip_doc_con;
    }

    public String getTip_doc_con() {
        return tip_doc_con;
    }

    public void setNro_inf(String nro_inf) {
        this.nro_inf = nro_inf;
    }

    public String getNro_inf() {
        return nro_inf;
    }

    public void setFec_inf(String fec_inf) {
        this.fec_inf = fec_inf;
    }

    public String getFec_inf() {
        return fec_inf;
    }

    public void setNro_doc_con(String nro_doc_con) {
        this.nro_doc_con = nro_doc_con;
    }

    public String getNro_doc_con() {
        return nro_doc_con;
    }

    public void setFec_doc_con(String fec_doc_con) {
        this.fec_doc_con = fec_doc_con;
    }

    public String getFec_doc_con() {
        return fec_doc_con;
    }

    public void setOvalor(String ovalor) {
        this.ovalor = ovalor;
    }

    public String getOvalor() {
        return ovalor;
    }

    public void setOpartida(String opartida) {
        this.opartida = opartida;
    }

    public String getOpartida() {
        return opartida;
    }

    public void setOorigen(String oorigen) {
        this.oorigen = oorigen;
    }

    public String getOorigen() {
        return oorigen;
    }

    public void setOsinobs(String osinobs) {
        this.osinobs = osinobs;
    }

    public String getOsinobs() {
        return osinobs;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getComision() {
        return comision;
    }

    public void setCcondel(String ccondel) {
        this.ccondel = ccondel;
    }

    public String getCcondel() {
        return ccondel;
    }

    public void setCconcon(String cconcon) {
        this.cconcon = cconcon;
    }

    public String getCconcon() {
        return cconcon;
    }

    public void setCconadu(String cconadu) {
        this.cconadu = cconadu;
    }

    public String getCconadu() {
        return cconadu;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getPagina() {
        return pagina;
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

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setUsuariolog(String usuariolog) {
        this.usuariolog = usuariolog;
    }

    public String getUsuariolog() {
        return usuariolog;
    }

    public void setFechalog(String fechalog) {
        this.fechalog = fechalog;
    }

    public String getFechalog() {
        return fechalog;
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
}
