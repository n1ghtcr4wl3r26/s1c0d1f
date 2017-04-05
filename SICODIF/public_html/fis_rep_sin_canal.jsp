<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<script language="JavaScript" type="text/JavaScript" src="js/datetimepicker_css.js"></script>
    <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
      <link href="css/style.css" rel="stylesheet" type="text/css"/>
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
              Mensaje = Mensaje + "'La Fecha Desde' de la consulta no puede ser mayor a la de hoy. \n";
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
          document.FisRsincanalForm.submit();
      }
      else {
          alert(Mensaje);
          return false;
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
      document.FisRrecaudacionesForm.submit();
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
<html:form action="/FisSinCanal">
    <div id="formulario">
        <html:hidden property="reporte"/>
         
        <%
    SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar fecha = Calendar.getInstance();
    fecha.setTime( fecha.getTime() );
    String fhoy = fFecha.format( fecha.getTime() );
    
FisRsincanalForm bean = (FisRsincanalForm)request.getAttribute("FisRsincanalForm");
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
         
        <!-- <h2>REPORTE DE RECUPERACION POR CONTROLES DIFERIDOS CONCLUIDOS - PAGADOS </h2> -->
         
        <h2>REPORTE DE ESTADO DE ASIGNACION DE CANAL</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
                <input type="hidden" name="boton" id="boton"/>
                <table width="100%">
                    <tr>
                        <td height="35">
                            <label>
                                <strong>Gerencia:</strong>
                            </label>
                        </td>
                        <td height="35">
                            <label>
                                <strong>Fecha registro CD Desde:</strong>
                            </label>
                        </td>
                        <td height="35">
                            <label>
                                <strong>Fecha registro CD Hasta:</strong>
                            </label>
                        </td>
                    </tr>
                     
                    <tr>
                        <td height="35">
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
                        <td height="35" colspan="3">
                            <center>
                                <input type="button" name="boton" value="Consultar" onclick="consultar(1)"></input>
                            </center>
                        </td>
                    </tr>
                </table>
            </fieldset>
             
            <%if(!(bean.getFec_hasta() == null))
                    { 
                        %><fieldset>
                <div>
                    <%
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_reporte.reporte_sin_canal (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getGerencia());
            call.setString(3, bean.getFec_desde());
            call.setString(4, bean.getFec_hasta());
            call.registerOutParameter(5,-10);
            call.execute();
            rs = (String)call.getObject(1);
            tb=""; 
            int num = 0;
            if(rs.equals("CORRECTO"))
            {     
                    rss = (ResultSet)call.getObject(5);
 
                    %><table id='backgroun3'><%
                    while(rss != null && rss.next())
                    {
                        if(num==0)
                        { 
                        %>  <tr>
                                <th>NRO.</th>
                                <th>GERENCIA</th>
                                <th>ADUANA</th>
                                <th>N&Uacute;MERO DE CONTROL DIFERIDO</th>
                                <th>FECHA REGISTRO CONTROL DIFERIDO</th>
                                <th>N&Uacute;MERO DE DECLARACI&Oacute;N</th>
                                <th>ESTADO DEL CANAL</th>
                                <th>FECHA LEVANTE</th>
                                <th>ESTADO CONTROL DIFERIDO</th>
                            </tr>
                             
                            <%
                            num=num+1;    
                        }
                    %><tr>
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
                        </tr>
                         
                        <%      }   
                        if(num == 0){
                            %>
                            <tr>
                                <th>NO EXISTE INFORMACION PARA EL REPORTE</th>
                            </tr>
                            <% 
                        }
                        %></table><%
            }
            else
            {
                    %>NO EXISTE INFORMACION PARA EL REPORTE<% 
                
                }
                
            
            
        } catch (Exception er) {
           
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
              
        
                  %>
                </div>
                <p>&nbsp;</p>
                <div align="left" style="font-size:11px">
                    Fecha y hora de generaci&oacute;n del reporte: 
                    <%=fhoy%>
                </div>
            </fieldset><%                       
                    }
                %>
        </div>
    </div>
</html:form>