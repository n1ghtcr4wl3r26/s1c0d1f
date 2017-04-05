package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class FisConsultaForm extends ActionForm 
{
    private String nrofis;
    private String usuario;
    private String unidad;
    private String boton;
    private String mensaje;

    private String estado;
    
    private String tipo_orden;
    private String orden_padre;
    private String gerencia;
    
    
    private String esdui;    
    private String esdue;
    private String esotro;
    
    private String declaracion;
    private String fecdeclaracion;
    

    private String fres_nombre;
    private String ffis_nombre;
    
        
    private String nroarf;
    private String fec_arf;
    private String ant_arf;
    private String hoja_ruta;
    
    private String nit;
    private String nombre;
    private String direccion;
    private String actividad;
    private String trib_ga;
    private String trib_iva;
    private String trib_iehd;
    private String trib_ice;
    private String trib_icd;
    private String trib_na;
        
    private String fantecedentes;
    private String fobjetivo;
    private String falcance;
    private String ffecordini;
    private String ffecordfin;
    private String ffecrelini;
    private String ffecrelfin;
    private String ffecanaini;
    private String ffecanafin;
    private String ffecresini;
    private String ffecresfin;
    private String ffecinfini;
    private String ffecinffin;
    private String ffecvisini;
    private String ffecvisfin;
    
    
    private String ffis_usu;
    private String ffis_fecha;
    private String ffis_ci;
    
    
    private String fres_usu;
    private String fres_cargo;
    private String fres_cargo2;
    private String fres_fecha;
    private String fres_ci;

    private String sw;
    private String fecval;

    private String vertip;
    private String verest;
    private String fecha_actual;
    private String fechahora_actual;
    
    private String codfis;
    

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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setTipo_orden(String tipo_orden) {
        this.tipo_orden = tipo_orden;
    }

    public String getTipo_orden() {
        return tipo_orden;
    }

    public void setOrden_padre(String orden_padre) {
        this.orden_padre = orden_padre;
    }

    public String getOrden_padre() {
        return orden_padre;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setNroarf(String nroarf) {
        this.nroarf = nroarf;
    }

    public String getNroarf() {
        return nroarf;
    }

    public void setFec_arf(String fec_arf) {
        this.fec_arf = fec_arf;
    }

    public String getFec_arf() {
        return fec_arf;
    }

    public void setAnt_arf(String ant_arf) {
        this.ant_arf = ant_arf;
    }

    public String getAnt_arf() {
        return ant_arf;
    }

    public void setHoja_ruta(String hoja_ruta) {
        this.hoja_ruta = hoja_ruta;
    }

    public String getHoja_ruta() {
        return hoja_ruta;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setTrib_ga(String trib_ga) {
        this.trib_ga = trib_ga;
    }

    public String getTrib_ga() {
        return trib_ga;
    }

    public void setTrib_iva(String trib_iva) {
        this.trib_iva = trib_iva;
    }

    public String getTrib_iva() {
        return trib_iva;
    }

    public void setTrib_iehd(String trib_iehd) {
        this.trib_iehd = trib_iehd;
    }

    public String getTrib_iehd() {
        return trib_iehd;
    }

    public void setTrib_ice(String trib_ice) {
        this.trib_ice = trib_ice;
    }

    public String getTrib_ice() {
        return trib_ice;
    }

    public void setTrib_icd(String trib_icd) {
        this.trib_icd = trib_icd;
    }

    public String getTrib_icd() {
        return trib_icd;
    }

    public void setTrib_na(String trib_na) {
        this.trib_na = trib_na;
    }

    public String getTrib_na() {
        return trib_na;
    }

    public void setFantecedentes(String fantecedentes) {
        this.fantecedentes = fantecedentes;
    }

    public String getFantecedentes() {
        return fantecedentes;
    }

    public void setFobjetivo(String fobjetivo) {
        this.fobjetivo = fobjetivo;
    }

    public String getFobjetivo() {
        return fobjetivo;
    }

    public void setFalcance(String falcance) {
        this.falcance = falcance;
    }

    public String getFalcance() {
        return falcance;
    }

    public void setFfecordini(String ffecordini) {
        this.ffecordini = ffecordini;
    }

    public String getFfecordini() {
        return ffecordini;
    }

    public void setFfecordfin(String ffecordfin) {
        this.ffecordfin = ffecordfin;
    }

    public String getFfecordfin() {
        return ffecordfin;
    }

    public void setFfecrelini(String ffecrelini) {
        this.ffecrelini = ffecrelini;
    }

    public String getFfecrelini() {
        return ffecrelini;
    }

    public void setFfecrelfin(String ffecrelfin) {
        this.ffecrelfin = ffecrelfin;
    }

    public String getFfecrelfin() {
        return ffecrelfin;
    }

    public void setFfecanaini(String ffecanaini) {
        this.ffecanaini = ffecanaini;
    }

    public String getFfecanaini() {
        return ffecanaini;
    }

    public void setFfecanafin(String ffecanafin) {
        this.ffecanafin = ffecanafin;
    }

    public String getFfecanafin() {
        return ffecanafin;
    }

    public void setFfecresini(String ffecresini) {
        this.ffecresini = ffecresini;
    }

    public String getFfecresini() {
        return ffecresini;
    }

    public void setFfecresfin(String ffecresfin) {
        this.ffecresfin = ffecresfin;
    }

    public String getFfecresfin() {
        return ffecresfin;
    }

    public void setFfecinfini(String ffecinfini) {
        this.ffecinfini = ffecinfini;
    }

    public String getFfecinfini() {
        return ffecinfini;
    }

    public void setFfecinffin(String ffecinffin) {
        this.ffecinffin = ffecinffin;
    }

    public String getFfecinffin() {
        return ffecinffin;
    }

    public void setFfecvisini(String ffecvisini) {
        this.ffecvisini = ffecvisini;
    }

    public String getFfecvisini() {
        return ffecvisini;
    }

    public void setFfecvisfin(String ffecvisfin) {
        this.ffecvisfin = ffecvisfin;
    }

    public String getFfecvisfin() {
        return ffecvisfin;
    }

    public void setFfis_usu(String ffis_usu) {
        this.ffis_usu = ffis_usu;
    }

    public String getFfis_usu() {
        return ffis_usu;
    }

    public void setFfis_nombre(String ffis_nombre) {
        this.ffis_nombre = ffis_nombre;
    }

    public String getFfis_nombre() {
        return ffis_nombre;
    }

    public void setFfis_fecha(String ffis_fecha) {
        this.ffis_fecha = ffis_fecha;
    }

    public String getFfis_fecha() {
        return ffis_fecha;
    }

    public void setFfis_ci(String ffis_ci) {
        this.ffis_ci = ffis_ci;
    }

    public String getFfis_ci() {
        return ffis_ci;
    }

    public void setFres_usu(String fres_usu) {
        this.fres_usu = fres_usu;
    }

    public String getFres_usu() {
        return fres_usu;
    }

    public void setFres_nombre(String fres_nombre) {
        this.fres_nombre = fres_nombre;
    }

    public String getFres_nombre() {
        return fres_nombre;
    }

    public void setFres_cargo(String fres_cargo) {
        this.fres_cargo = fres_cargo;
    }

    public String getFres_cargo() {
        return fres_cargo;
    }

    public void setFres_cargo2(String fres_cargo2) {
        this.fres_cargo2 = fres_cargo2;
    }

    public String getFres_cargo2() {
        return fres_cargo2;
    }

    public void setFres_fecha(String fres_fecha) {
        this.fres_fecha = fres_fecha;
    }

    public String getFres_fecha() {
        return fres_fecha;
    }

    public void setFres_ci(String fres_ci) {
        this.fres_ci = fres_ci;
    }

    public String getFres_ci() {
        return fres_ci;
    }

    public void setSw(String sw) {
        this.sw = sw;
    }

    public String getSw() {
        return sw;
    }

    public void setFecval(String fecval) {
        this.fecval = fecval;
    }

    public String getFecval() {
        return fecval;
    }

    public void setVertip(String vertip) {
        this.vertip = vertip;
    }

    public String getVertip() {
        return vertip;
    }

    public void setVerest(String verest) {
        this.verest = verest;
    }

    public String getVerest() {
        return verest;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFechahora_actual(String fechahora_actual) {
        this.fechahora_actual = fechahora_actual;
    }

    public String getFechahora_actual() {
        return fechahora_actual;
    }

    public void setCodfis(String codfis) {
        this.codfis = codfis;
    }

    public String getCodfis() {
        return codfis;
    }

    public void setEsdui(String esdui) {
        this.esdui = esdui;
    }

    public String getEsdui() {
        return esdui;
    }

    public void setEsdue(String esdue) {
        this.esdue = esdue;
    }

    public String getEsdue() {
        return esdue;
    }

    public void setEsotro(String esotro) {
        this.esotro = esotro;
    }

    public String getEsotro() {
        return esotro;
    }

    public void setDeclaracion(String declaracion) {
        this.declaracion = declaracion;
    }

    public String getDeclaracion() {
        return declaracion;
    }

    public void setFecdeclaracion(String fecdeclaracion) {
        this.fecdeclaracion = fecdeclaracion;
    }

    public String getFecdeclaracion() {
        return fecdeclaracion;
    }
}
