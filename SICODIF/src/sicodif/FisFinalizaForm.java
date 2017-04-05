package sicodif;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class FisFinalizaForm extends ActionForm {
    private String nrofis;

    private String key_year;
    private String key_cuo;
    private String reg_serial;

    private String declaracion;
    private String estado;

    private String tip_doc_con;
    private String nro_inf;
    private String fec_inf;
    private String nro_doc_con;
    private String fec_doc_con;

    private String observacion;
    private String contravencion;


    private String fecha_liquidacion;

    private String ovalor;
    private String opartida;
    private String oorigen;
    private String osinobs;
    private String comision;
    private String ccondel;
    private String cconcon;
    private String cconadu;

    private String usuario;
    private String boton;
    private String mensaje;
    private String fiscalizador;

    private String etapa;
    private String cdgerencia;

    private String sw;
    private String justificativo;
    
    private String observacionenm;

    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

    /**
     * Validate all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return ActionErrors A list of all errors found.
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
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

    public void setContravencion(String contravencion) {
        this.contravencion = contravencion;
    }

    public String getContravencion() {
        return contravencion;
    }

    public void setFiscalizador(String fiscalizador) {
        this.fiscalizador = fiscalizador;
    }

    public String getFiscalizador() {
        return fiscalizador;
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

    public void setFecha_liquidacion(String fecha_liquidacion) {
        this.fecha_liquidacion = fecha_liquidacion;
    }

    public String getFecha_liquidacion() {
        return fecha_liquidacion;
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

    public void setSw(String sw) {
        this.sw = sw;
    }

    public String getSw() {
        return sw;
    }

    public void setJustificativo(String justificativo) {
        this.justificativo = justificativo;
    }

    public String getJustificativo() {
        return justificativo;
    }

    public void setObservacionenm(String observacionenm) {
        this.observacionenm = observacionenm;
    }

    public String getObservacionenm() {
        return observacionenm;
    }
}
