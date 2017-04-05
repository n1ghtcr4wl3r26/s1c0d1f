<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<style TYPE="text/css">
    a:active {
            outline: none;
    }
    a:focus {
            -moz-outline-style: none;
    }
    #tabs_container {
            width: 600px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
    }
    #tabs_container ul.tabs {
            list-style: none;
            border-bottom: 1px solid #ccc;
            height: 21px;
            margin: 0;
    }
    #tabs_container ul.tabs li {
            float: left;
    }
    #tabs_container ul.tabs li a {
            padding: 3px 10px;
            display: block;
            border-left: 1px solid #ccc;
            border-top: 1px solid #ccc;
            border-right: 1px solid #ccc;
            margin-right: 2px;
            text-decoration: none;
            background-color: #5C8BA8;
            color:White;
    }
    #tabs_container ul.tabs li.active a {
            background-color: #fff;
            padding-top: 4px;
            color:#666666;
    }
    div.tab_contents_container {
            border: 1px solid #ccc;
            border-top: none;
            padding: 10px;
    }
    div.tab_contents {
            display: none;
    }
    div.tab_contents_active {
            display: block;
    }
    div.clear {
            clear: both;
    }

</style>
<script language="JavaScript" type="text/JavaScript" src="js/datetimepicker_css.js"></script>
<script type="text/javascript" charset="utf-8">
    // Load this script when page loads
    $(document).ready(function(){
    
         // Set up a listener so that when anything with a class of 'tab' 
         // is clicked, this function is run.
         $('.tab').click(function () {
        
          // Remove the 'active' class from the active tab.
          $('#tabs_container > .tabs > li.active')
                  .removeClass('active');
                  
          // Add the 'active' class to the clicked tab.
          $(this).parent().addClass('active');
        
          // Remove the 'tab_contents_active' class from the visible tab contents.
          $('#tabs_container > .tab_contents_container > div.tab_contents_active')
                  .removeClass('tab_contents_active');
        
          // Add the 'tab_contents_active' class to the associated tab contents.
          $(this.rel).addClass('tab_contents_active');
    
     });
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
      
      $('#tipo').val(valor);
      
      if (10 > diames)
          diames = "0" + diames;
      if (10 > mes)
          mes = "0" + mes;
        
      if($('#tipo').val() == "dui"){
          if( ! fTrim( $('#key_year').val() ) ){
              Mensaje = Mensaje + "'Gesti\363n' es obligatorio\n";
          }
          else{
              if( ! foNumero( $('#key_year').val() ) ){
                Mensaje = Mensaje + "'Gesti\363n' debe ser un n\372mero\n";
              } 
          }
          if( ! fTrim( $('#key_cuo').val() ) ){
            Mensaje = Mensaje + "'Aduana' es obligatorio\n";
          }
          else{
              if( ! foNumero( $('#key_cuo').val() ) ){
                Mensaje = Mensaje + "'Aduana' debe ser un n\372mero\n";
              } 
          }
          if( ! fTrim( $('#reg_serial').val() ) ){
            Mensaje = Mensaje + "'N\372mero' es obligatorio\n";
          }
          else{
              if( ! foNumero( $('#reg_serial').val() ) ){
                Mensaje = Mensaje + "'N\372mero' debe ser un n\372mero\n";
              } 
          }
          
          if (Mensaje == "") {
              $('#boton').val('consultar');
              document.FisRconcesionarioForm.submit();
          }
          else {
              alert(Mensaje);
              return false;
          }
          
          
      }
      if($('#tipo').val() == "nit"){
          if (!fTrim($('#nit').val())) {
              Mensaje = Mensaje + "'NIT' es obligatorio\n";
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
           
           var di= fecinicio.substr(0,2);
           var mi= fecinicio.substr(3,2);
           var ai= fecinicio.substr(6,9);
           var rfecinicio = ai+'/'+mi+'/'+di;
           
           var df= fecfin.substr(0,2);
           var mf= fecfin.substr(3,2);
           var af= fecfin.substr(6,9);
           var rfecfin = af+'/'+mf+'/'+df;
                       
           cantDias = daysBetween(rfecinicio , rfecfin);   

           //alert(cantDias);
          
           if (cantDias > 365){
              Mensaje = Mensaje + "El rango de fechas debe ser menor a 1 a\u00f1o";
           } 
           
           if (Mensaje == "") {
              $('#boton').val('consultar');
              document.FisRconcesionarioForm.submit();
           }
           else {
              alert(Mensaje);
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
      document.FisRconcesionarioForm.submit();
  };
  
function daysBetween(date1, date2){ 
   if (date1.indexOf("-") != -1) { date1 = date1.split("-"); } else if (date1.indexOf("/") != -1) { date1 = date1.split("/"); } else { return 0; } 
   if (date2.indexOf("-") != -1) { date2 = date2.split("-"); } else if (date2.indexOf("/") != -1) { date2 = date2.split("/"); } else { return 0; } 
   if (parseInt(date1[0], 10) >= 1000) { 
       var sDate = new Date(date1[0]+"/"+date1[1]+"/"+date1[2]);
   } else if (parseInt(date1[2], 10) >= 1000) { 
       var sDate = new Date(date1[2]+"/"+date1[0]+"/"+date1[1]);
   } else { 
       return 0; 
   } 
   if (parseInt(date2[0], 10) >= 1000) { 
       var eDate = new Date(date2[0]+"/"+date2[1]+"/"+date2[2]);
   } else if (parseInt(date2[2], 10) >= 1000) { 
       var eDate = new Date(date2[2]+"/"+date2[0]+"/"+date2[1]);
   } else { 
       return 0; 
   } 
   var one_day = 1000*60*60*24; 
   var daysApart = Math.abs(Math.ceil((sDate.getTime()-eDate.getTime())/one_day)); 
   return daysApart; 
}  
</script>

<html:form action="/FisRconcesionario">
    <div id="formulario">
        <html:hidden property="reporte"/>
         
        <%
FisRconcesionarioForm bean = (FisRconcesionarioForm)request.getAttribute("FisRconcesionarioForm");
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

String tab_dui;
String tab_nit;
String tab_dui_c;
String tab_nit_c;
try
{
 if(bean.getTipo().equals("dui")){
       tab_nit = "";
       tab_dui = "class='active'";
       
       tab_nit_c = "class='tab_contents'";
       tab_dui_c = "class='tab_contents tab_contents_active'";
       
 }else{
       tab_nit = "class='active'";
       tab_dui = ""; 
       
       tab_nit_c = "class='tab_contents tab_contents_active'";
       tab_dui_c = "class='tab_contents'";
 } 
}
catch(Exception ex)
{
    tab_nit = "class='active'";
    tab_dui = ""; 
    tab_nit_c = "class='tab_contents tab_contents_active'";
    tab_dui_c = "class='tab_contents'";
}
%>
         

     
    
        <h2>REPORTE CONCESIONARIO</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
                <input type="hidden" name="boton" id="boton"/>
                <input type="hidden" name="tipo" id="tipo"/>
                <div id="tabs_container">

                  <!-- These are the tabs -->
                  <ul class="tabs">
                    <li <%=tab_nit%>>
                        <a href="#" rel="#tab_1_contents" class="tab">NIT Importador</a>
                    </li>
                    <li <%=tab_dui%>>
                        <a href="#" rel="#tab_2_contents" class="tab">N&uacute;mero de DUI</a>
                    </li>
                  </ul>
            
                  <!-- This is used so the contents don't appear to the 
                       right of the tabs -->
                  <div class="clear"></div>
            
                  <!-- This is a div that hold all the tabbed contents -->
                  <div class="tab_contents_container">
            
                    <!-- Tab 1 Contents -->
                    <div id="tab_1_contents" <%=tab_nit_c%>>
                        <table width="100%">
                            <tr>
                                <td height="35">
                                    <label>
                                        <strong>NIT Operador:</strong>
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
                                <td height="35">
                                    <html:text property="nit" style="width:100px" maxlength="15" styleId="nit"/>
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
                                        <input type="button" name="boton" value="Consultar" onclick="consultar('nit')"></input>
                                    </center>
                                </td>
                            </tr>
                        </table>
                    </div>
            
                    <!-- Tab 2 Contents -->
                    <div id="tab_2_contents" <%=tab_dui_c%>>
                        <table width="100%">
                            <tr>
                                <td height="35">
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
                                <td height="35">
                                    <html:text property="key_year" style="width:100px" maxlength="4" styleId="key_year"/>
                                </td>
                                <td height="35">    
                                    <%=Util.DevuelveAduanas(bean.getKey_cuo())%> 
                                </td>
                                <td height="35">
                                    <html:text property="reg_serial" style="width:100px" maxlength="10" styleId="reg_serial"/>
                                </td>
                            </tr>
                             
                            <tr>
                                <td height="35" colspan="3">
                                    <center>
                                        <input type="button" name="boton" value="Consultar" onclick="consultar('dui')"></input>
                                    </center>
                                </td>
                            </tr>
                        </table>
                    </div>
            
                   
                  </div>
                </div>

                
                
                
                
                
                
            </fieldset>
             
            <%   
    if(!(bean.getTipo()== null))
    {
        if(!(bean.getTipo()==""))
        {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;
        int sw = 0;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_reporte.reporte_concesionario (?,?,?,?, ?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getNit());
            call.setString(3, bean.getFec_desde());
            call.setString(4, bean.getFec_hasta());
            call.setString(5, bean.getKey_year());
            call.setString(6, bean.getKey_cuo());
            call.setString(7, bean.getReg_serial());
            call.setString(8, bean.getTipo());
            call.registerOutParameter(9,-10);
            call.execute();
            rs = (String)call.getObject(1);
            tb=""; 
            
            if(rs.equals("CORRECTO"))
            {     
                    rss = (ResultSet)call.getObject(9);
 
                    
                    while(rss != null && rss.next())
                    {
                    
                        if(sw==0 ){
                        %>
                        <br/>
                        <table id='backgroun7'>
                            <tr>
                              <th>NUMERO DE LA DUI</th>
                              <th>FECHA DE REGISTRO DE LA DUI</th>
                              <th>Nº DE NIT/CI IMPORTADOR</th>
                              <th>NOMBRE IMPORTADOR</th>
                              <th>NUMERO DE CONTROL DIFERIDO</th>
                              <th>FECHA DE CONTROL DIFERIDO</th>
                              <th>VALOR CIF DECLARADO</th>
                              <th>NÚMERO DE RESOLUCIÓN O DOCUMENTO DE CONCLUSIÓN</th>
                              <th>TIPO DE DOCUMENTO DE CONCLUSIÓN</th>
                              <th>FECHA DE DOCUMENTO DE CONCLUSIÓN</th>
                              <th>VALOR CIF DETERMINADO</th>
                              <th>FECHA DE PASE DE SALIDA</th>
                            </tr>
                        <%
                        sw=1;
                        }                    
                        %><tr>
                              <td><%=rss.getString(1)%></td>
                              <td><%=rss.getString(2)%></td>
                              <td><%=rss.getString(3)%></td>
                              <td><%=rss.getString(4)%></td>
                              <td><%=rss.getString(5)%></td>
                              <td><%=rss.getString(6)%></td>
                              <td><%=rss.getString(7)%></td>
                              <td><%=rss.getString(8)%></td>
                              <td><%=rss.getString(9)%></td>
                              <td><%=rss.getString(10)%></td>
                              <td><%=rss.getString(11)%></td>
                              <td><%=rss.getString(12)%></td>
                          </tr>
                        <%
                    }   
                    if(sw==1){
                          %>
                          </table>
                          
                          <table id='backgroun7'>
                            <tr>
                                <th style="text-align:left">
                                    <label >El VALOR CIF DETERMINADO presentado en el presente reporte es de carácter preliminar, por lo que se sugiere contrastar dicho valor con lo manifestado en el Documento de Conclusión emitido por la Unidad de Fiscalización.</label>
                                </th>
                            </tr>
                          </table>
                          <%
                    } else {
                        %>
                        <br/>
                        <table id='backgroun7'>
                            <tr>
                                <th>
                                    <label >NO EXISTE INFORMACION PARA EL REPORTE</label>
                                </th>
                            </tr>
                        </table>
                        <% 
                    }
                }
            else
            {
                    %>
                    <br/>
                    <table id='backgroun7'>
                        <tr>
                            <th>
                                <label >NO EXISTE INFORMACION PARA EL REPORTE</label>
                            </th>
                        </tr>
                    </table>
                    <% 
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