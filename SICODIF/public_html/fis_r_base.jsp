
    
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<script language="JavaScript" type="text/JavaScript" src="js/datetimepicker_css.js"></script>
<script type="text/javascript" charset="utf-8">
  $(document).ready(function () {

  });
</script>
<script type="text/javascript" charset="utf-8">
  function consultar(valor) {
      var Mensaje = "";
      var aux = 0;
      var aux2 = 0;
      var fecha = new Date();
      var diames = fecha.getDate();
      var mes = fecha.getMonth() + 1;
      var ano = fecha.getFullYear();
      var cantDias;
      var fecinicio;
      var fecfin;

      if (valor == 1) {
          if (10 > diames)
              diames = "0" + diames;
          if (10 > mes)
              mes = "0" + mes;
          if (!fTrim($('#gerencia').val())) {
              Mensaje = Mensaje + "'Gerencia' es obligatorio\n";
          }
          if (!fTrim($('#fec_desde').val())) {
              Mensaje = Mensaje + "'Fecha Desde' es obligatorio\n";
              aux = 1;
          }
          else {
              if (!fFecha($('#fec_desde').val())) {
                  Mensaje = Mensaje + "'Fecha Desde' no tiene el formato dd/mm/aaaa\n";
                  aux = 1;
              }
          }
          if (!fTrim($('#fec_hasta').val())) {
              Mensaje = Mensaje + "'Fecha Hasta' es obligatorio\n";
              aux2 = 1;
          }
          else {
              if (!fFecha($('#fec_hasta').val())) {
                  Mensaje = Mensaje + "'Fecha Hasta' no tiene el formato dd/mm/aaaa\n";
                  aux2 = 1;
              }
          }
          if (aux == 0 && aux2 == 0) {
              if (!ComparaFechas($('#fec_desde').val(), $('#fec_hasta').val()))
                  Mensaje = Mensaje + "El rango del periodo de la consulta es incorrecto. \n";
              if (!ComparaFechas($('#fec_desde').val(), diames + "/" + mes + "/" + ano))
                  Mensaje = Mensaje + "'La Fecha Desde' de la consulta no puede ser mayor a la de hoy ddddddd. \n";
              if (!ComparaFechas($('#fec_hasta').val(), diames + "/" + mes + "/" + ano))
                  Mensaje = Mensaje + "'La Fecha Hasta' de la consulta no puede ser mayor a la de hoy. \n";
          }
          fecinicio = $('#fec_desde').val();
          fecfin = $('#fec_hasta').val();
          //alert(fecinicio);
          var di = fecinicio.substr(0, 2);
          var mi = fecinicio.substr(3, 2);
          var ai = fecinicio.substr(6, 9);
          var rfecinicio = ai + '/' + mi + '/' + di;
          var df = fecfin.substr(0, 2);
          var mf = fecfin.substr(3, 2);
          var af = fecfin.substr(6, 9);
          var rfecfin = af + '/' + mf + '/' + df;
          cantDias = daysBetween(rfecinicio, rfecfin);
          //alert(cantDias);
          if (cantDias > 365) {
              Mensaje = Mensaje + "El rango de fechas debe ser menor a 1 a\u00f1o";
          }
          if (Mensaje == "") {
              $('#boton').val('consultar');
              document.FisRbaseForm.submit();
          }
          else {
              alert(Mensaje);
              return false;
          }

      }
      else {
          if (valor == 2) {
              if (!fTrim($('#sad_reg_year').val())) {
                  Mensaje = Mensaje + "'Gesti\363n' es obligatorio\n";
              }
              if (!fTrim($('#key_cuo').val())) {
                  Mensaje = Mensaje + "'Aduana' es obligatorio\n";
              }
              if (!fTrim($('#sad_reg_nber').val())) {
                  Mensaje = Mensaje + "'N\372mero de Declaraci\363n' es obligatorio\n";
              }
              if (Mensaje == "") {
                  $('#boton').val('consultar2');
                  document.FisRbaseForm.submit();
              }
              else {
                  alert(Mensaje);
                  return false;
              }
          }
          else {
              return false;
          }
      }
  };

  function ComparaFechas(fec0, fec1) {
      var bRes = false;
      var sDia0 = fec0.substr(0, 2);
      var sMes0 = fec0.substr(3, 2);
      var sAno0 = fec0.substr(6, 4);
      var sDia1 = fec1.substr(0, 2);
      var sMes1 = fec1.substr(3, 2);
      var sAno1 = fec1.substr(6, 4);
      if (sAno1 > sAno0)
          bRes = true;
      else {
          if (sAno0 == sAno1) {
              if (sMes1 > sMes0)
                  bRes = true;
              else {
                  if (sMes0 == sMes1)
                      if (sDia1 >= sDia0)
                          bRes = true;
              }
          }

      }
      return bRes;
  };

  function cancelar(valor) {
      $('#boton').val('cancelar');
      document.FisRbaseForm.submit();
  };

  function daysBetween(date1, date2) {
      if (date1.indexOf("-") !=  - 1) {
          date1 = date1.split("-");
      }
      else if (date1.indexOf("/") !=  - 1) {
          date1 = date1.split("/");
      }
      else {
          return 0;
      }
      if (date2.indexOf("-") !=  - 1) {
          date2 = date2.split("-");
      }
      else if (date2.indexOf("/") !=  - 1) {
          date2 = date2.split("/");
      }
      else {
          return 0;
      }
      if (parseInt(date1[0], 10) >= 1000) {
          var sDate = new Date(date1[0] + "/" + date1[1] + "/" + date1[2]);
      }
      else if (parseInt(date1[2], 10) >= 1000) {
          var sDate = new Date(date1[2] + "/" + date1[0] + "/" + date1[1]);
      }
      else {
          return 0;
      }
      if (parseInt(date2[0], 10) >= 1000) {
          var eDate = new Date(date2[0] + "/" + date2[1] + "/" + date2[2]);
      }
      else if (parseInt(date2[2], 10) >= 1000) {
          var eDate = new Date(date2[2] + "/" + date2[0] + "/" + date2[1]);
      }
      else {
          return 0;
      }
      var one_day = 1000 * 60 * 60 * 24;
      var daysApart = Math.abs(Math.ceil((sDate.getTime() - eDate.getTime()) / one_day));
      return daysApart;
  }
</script>
<html:form action="/FisRbase" target="_blank">
    <div id="formulario">
        <html:hidden property="reporte"/>
         
        <%
                FisRbaseForm bean = (FisRbaseForm)request.getAttribute("FisRbaseForm");
                try
                {
                    if(!(bean.getMensaje()== null))
                    {
                        if(!(bean.getMensaje()==""))
                        {
                        %><center>
            <%=bean.getMensaje()%>
        </center><%
                        }
                    }
                }
                catch(Exception ex)
                {
                }
            %>
         
        <h2>REPORTES SICODIF</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
                <input type="hidden" name="boton" id="boton"/>
                <table width="100%">
                    <tr>
                        <td height="35" colspan="2" width="350px">
                            <label>
                                <strong>Gerencia:</strong>
                            </label>
                        </td>
                        <td height="35">
                            <label>
                                <strong>Fecha Registro Desde:</strong>
                            </label>
                        </td>
                        <td height="35">
                            <label>
                                <strong>Fecha Registro Hasta:</strong>
                            </label>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35" colspan="2">
                            <html:select property="gerencia" styleId="gerencia">
                                <html:option value="%">-- Todas las Gerencias --</html:option>
                                <html:option value="GNF">GERENCIA NACIONAL DE FISCALIZACION</html:option>
                                <html:option value="GRLP">GERENCIA REGIONAL LA PAZ</html:option>
                                <html:option value="GRCB">GERENCIA REGIONAL COCHABAMBA</html:option>
                                <html:option value="GRSC">GERENCIA REGIONAL SANTA CRUZ</html:option>
                                <html:option value="GROR">GERENCIA REGIONAL ORURO</html:option>
                                <html:option value="GRTJ">GERENCIA REGIONAL TARIJA</html:option>
                                <html:option value="GRPT">GERENCIA REGIONAL POTOSI</html:option>
                            </html:select>
                        </td>
                        <td height="35">
                            <table>
                                <tr>
                                    <td>
                                        <html:text property="fec_desde" style="width:100px" maxlength="10"
                                                   styleId="fec_desde"/>
                                    </td>
                                    <td>
                                        <img src="img/calendar_1.png" id="imcal" style="cursor:pointer;"
                                             onclick="javascript:NewCssCal('fec_desde','ddMMyyyy')"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td height="35">
                            <table>
                                <tr>
                                    <td>
                                        <html:text property="fec_hasta" style="width:100px" maxlength="10"
                                                   styleId="fec_hasta"/>
                                    </td>
                                    <td>
                                        <img src="img/calendar_1.png" id="imcal" style="cursor:pointer;"
                                             onclick="javascript:NewCssCal('fec_hasta','ddMMyyyy')"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35">
                            <label>
                                <strong>NIT:</strong>
                            </label>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35">
                            <html:text property="nit" style="width:200px" maxlength="12" styleId="nit"/>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35" colspan="4">
                            <center>
                                <input type="button" name="boton" value="Consultar por Parametros"
                                       onclick="consultar(1)"></input>
                            </center>
                        </td>
                    </tr>
                     
                    <tr>
                        <td>
                            &nbsp; 
                            <br></br>
                             
                            <br></br>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35" width="100px">
                            <label>
                                <strong>Gesti&oacute;n:</strong>
                            </label>
                        </td>
                        <td height="35">
                            <label>
                                <strong>Aduana:</strong>
                            </label>
                        </td>
                        <td height="35">
                            <label>
                                <strong>N&uacute;mero:</strong>
                            </label>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35" width="100px">
                            <html:text property="sad_reg_year" style="width:100px" maxlength="4"
                                       styleId="sad_reg_year"/>
                        </td>
                        <td height="35">
                            <%=Util.DevuelveAduanas("-","GNF")%>
                        </td>
                        <td height="35">
                            C-&nbsp; 
                            <html:text property="sad_reg_nber" style="width:100px" maxlength="10"
                                       styleId="sad_reg_nber"/>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35" colspan="4">
                            <center>
                                <input type="button" name="boton" value="Consultar por DUI" onclick="consultar(2)"></input>
                            </center>
                        </td>
                    </tr>
                </table>
            </fieldset>
             
            <%   
                if(!(bean.getBoton()== null))
                {
                    if(!(bean.getBoton()=="consultar") || !(bean.getBoton()=="consultar2"))
                    {
                    conexion dc = new conexion();
                    Connection con = null;
                    CallableStatement call = null;
                    String rs = "OK";
                    String tb = "";
                    ResultSet rss = null;
                    try {
                        con = dc.abrirConexion();
                        if(!(bean.getBoton()=="consultar"))
                        {
                            call = con.prepareCall("{ ? = call pkg_reporte.reportebase (?,?,?,?,?) }");
                            call.registerOutParameter(1, OracleTypes.VARCHAR);
                            call.setString(2, bean.getGerencia());
                            call.setString(3, bean.getFec_desde());
                            call.setString(4, bean.getFec_hasta());
                            call.setString(5, bean.getNit());
                            call.registerOutParameter(5,-10);
                        }
                        if(!(bean.getBoton()=="consultar2"))
                        {
                            call = con.prepareCall("{ ? = call pkg_reporte.reportebasedui (?,?,?,?) }");
                            call.registerOutParameter(1, OracleTypes.VARCHAR);
                            call.setString(2, bean.getKey_cuo());
                            call.setString(3, bean.getKey_cuo());
                            call.setString(4, bean.getFec_hasta());
                            call.registerOutParameter(5,-10);
                        }
                        call.execute();
                        rs = (String)call.getObject(1);
                        tb=""; 
                        if(rs.equals("CORRECTO"))
                        {     
                            rss = (ResultSet)call.getObject(5);
                            %>
                            <table id='backgroun3'>
                                <tr>
                                    <th colspan='4'>NUMERO DE CONTROL DIFERIDO</th>
                                    <th colspan='16'>DATOS DE LA DECLARACION</th>
                                    <th colspan='6'>NOTIFICACION</th>
                                    <th colspan='13'>RESULTADOS CONTROL DIFERIDO</th>
                                    <th colspan='2'>ACEPTACION DE PAGO</th>
                                    <th colspan='7'>CONCLUSION DEL CONTROL DIFERIDO</th>
                                    <th colspan='4'>OBSERVACIONES ENCONTRADAS</th>
                                    <th colspan='4'>OBSERVACIONES EN CONTRAVENCIONES ENCONTRADAS</th>
                                    <th colspan='3'>NOTIFICACION DEL DOCUMENTO DE CONCLUSION AL OPERADOR</th>
                                    <th colspan='3'>ENVIO A LA UNIDAD LEGAL</th>
                                    <th colspan='1' rowspan="2">ESTADO DEL CONTROL DIFERIDO (REGISTRADO - ASIGNADO - NOTIFICADO -
                                                                RESULTADOS - CONCLUIDO - CONCLUIDO NOTIFICADO - ENVIO LEGAL)</th>
                                    <th colspan='11'>RECUPERACION - PAGO</th>
                                    <th colspan='3'>OTRAS DATOS</th>
                                </tr>
                                 
                                <tr>
                                    <th>GESTION</th>
                                    <th>GERENCIA</th>
                                    <th>NUMERO CORRELATIVO POR GESTION</th>
                                    <th>FECHA DE LA ORDEN DE CONTROL</th>
                                    <th>ADUANA</th>
                                    <th>DESCRIPCION ADUANA</th>
                                    <th>NUMERO DE DECLARACION</th>
                                    <th>CANAL</th>
                                    <th>N&ordm; DE NIT/CI IMPORTADOR</th>
                                    <th>NOMBRE IMPORTADOR</th>
                                    <th>N&ordm; DE NIT/CI DECLARANTE</th>
                                    <th>NOMBRE DECLARANTE</th>
                                    <th>DIRECCION PROVEEDOR</th>
                                    <th>PROVEEDOR</th>
                                    <th>TOTAL VALOR FOB DECLARADO $us ULTIMA</th>
                                    <th>TRIBUTO DECLARADO GA Bs</th>
                                    <th>TRIBUTO DECLARADO IVA Bs</th>
                                    <th>TRIBUTO DECLARADO ICE Bs</th>
                                    <th>TRIBUTO DECLARADO IHD Bs</th>
                                    <th>TOTAL TRIBUTO DECLARADOS Bs</th>
                                    <th>USUARIO FISCALIZADOR</th>
                                    <th>USUARIO QUE REGISTRO LA ASIGNACION</th>
                                    <th>FECHA NOTIFICACION</th>
                                    <th>OBSERVACION NOTIFICACION</th>
                                    <th>TIPO NOTIFICACION (CEDULA - PERSONAL - TACITO - EDICTO)</th>
                                    <th>USUARIO QUE REALIZO LA NOTIFICACION</th>
                                    <th>VALOR FOB DETERMINADO POR FISCALIZACION</th>
                                    <th>FECHA LIQUIDACION</th>
                                    <th>VALOR UFV DE LA FECHA DE LIQUIDACION</th>
                                    <th>TRIBUTO OMITIDO GA Bs</th>
                                    <th>TRIBUTO OMITIDO IVA Bs</th>
                                    <th>TRIBUTO OMITIDO ICE Bs</th>
                                    <th>TRIBUTO OMITIDO IEHD Bs</th>
                                    <th>TOTAL TRIBUTO OMITIDO Bs</th>
                                    <th>SANCION OMISION Bs</th>
                                    <th>MULTA CONTRAVENCION Bs</th>
                                    <th>MULTA CONTRA_CONTRA Bs</th>
                                    <th>MULTA CONTRABANDO DELITO Bs</th>
                                    <th>USUARIO QUE REGISTRO LOS RESULTADOS</th>
                                    <th>FECHA ACEPTACION DE PAGO</th>
                                    <th>USUARIO QUE REGISTRO LA ACEPTACION</th>
                                    <th>TIPO DOCUMENTO DE CONCLUSION</th>
                                    <th>NUMERO INFORME</th>
                                    <th>FECHA DE INFORME</th>
                                    <th>NUMERO DE DOCUMENTO DE CONCLUSION</th>
                                    <th>FECHA DE DOCUMENTO DE CONCLUSION</th>
                                    <th>FECHA DE FINALIZACION DEL CONTROL DIFERIDO</th>
                                    <th>USUARIO QUE REGISTRO LA FINALIZACION</th>
                                    <th>VALOR</th>
                                    <th>PARTIDA</th>
                                    <th>ORIGEN</th>
                                    <th>SIN OBSERVACION</th>
                                    <th>OMISION DE PAGO</th>
                                    <th>CONTRABANDO DELITO</th>
                                    <th>CONTRABANDO CONTRAVENCIONAL</th>
                                    <th>CONTRAVENCION ADUANERA</th>
                                    <th>FECHA DE NOTIFICACION</th>
                                    <th>TIPO DE NOTIFICACION (CEDULA - PERSONA - TACITO - EDICTO - SECRETARIA)</th>
                                    <th>USUARIO QUE REGISTRO LA NOTIFICACION DEL DOCUMENTO DE CONCLUSION</th>
                                    <th>FECHA ENVIO</th>
                                    <th>NUMERO DE DOCUMENTO DE REMISION</th>
                                    <th>USUARIO QUE REALIZO LA REMISION A LA UNIDAD LEGAL</th>
                                    <th>TRIBUTO PAGADO GA Bs</th>
                                    <th>TRIBUTO PAGADO IVA Bs</th>
                                    <th>TRIBUTO PAGADO ICE Bs</th>
                                    <th>TRIBUTO PAGADO IHD Bs</th>
                                    <th>TOTAL TRIBUTO PAGADO</th>
                                    <th>SANCION OMISION Bs</th>
                                    <th>MULTA CONTRAVENCIONAL ADUANERA Bs</th>
                                    <th>MULTA CONTRABANDO CONTRAVENCIONAL Bs</th>
                                    <th>USUARIO QUE REGISTRO LOS RESULTADOS</th>
                                    <th>ORIGEN</th>
                                    <th>FECHA CONTROL</th>
                                    <th>PASE SALIDA SIDUNEA</th>
                                    <th>MERCANCIA</th>
                                    <th>CRITERIO NIVEL CABECERA</th>
                                </tr>
                                 
                                <%
                                                while(rss != null && rss.next())
                                                {
                                                    %>
                                 
                                <tr>
                                    <td>
                                        <%=rss.getString(1)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(2)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(3)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(4)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(5)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(6)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(7)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(8)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(9)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(10)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(11)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(12)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(13)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(14)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(15)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(16)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(17)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(18)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(19)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(20)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(21)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(22)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(23)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(24)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(25)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(26)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(27)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(28)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(29)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(30)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(31)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(32)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(33)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(34)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(35)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(36)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(37)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(38)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(39)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(40)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(41)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(42)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(43)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(44)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(45)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(46)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(47)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(48)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(49)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(50)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(51)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(52)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(53)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(54)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(55)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(56)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(57)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(58)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(59)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(60)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(61)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(62)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(63)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(64)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(65)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(66)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(67)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(68)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(69)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(70)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(71)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(72)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(73)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(74)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(75)%>
                                    </td>
                                    <td>
                                        <%=rss.getString(76)%>
                                    </td>
                                </tr>
                                 
                                <%
                                                }       
                                                %>
                            </table>
                            <% 
                            }
                        else
                        {
                            %>NO EXISTE INFORMACION PARA EL REPORTE<% 
                        }
                    } catch (Exception er) {
                        tb= "ERROR: "+er.toString();
                    } finally {
                        try {
                            if (con != null)
                                con.close();
                                call.close();
                            if (rss != null)
                                rss.close();
                        } catch (SQLException er) {
                            ;
                        }
                    }     
                }
            }
            %>
        </div>
    </div>
</html:form>