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
    
    
      if( Mensaje == "" )
      {
        $('#boton').val('consultar_enm');
        document.FisResultadosForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar_enm');
      document.FisResultadosForm.submit();
  };
  function registrar(valor) {
      var Mensaje = "";
      
      
      var fecha=new Date();
    var diames=fecha.getDate();
    var mes=fecha.getMonth() +1 ;
    var ano=fecha.getFullYear();
    if (10 > diames) 
     diames = "0"+diames;
    if (10 > mes) 
     mes = "0"+mes;
    
   // var mascara = new RegExp("^[0-9]*(\.[0-9]+)?$","g");
     
      //var mascara = new RegExp("/^\d+(?:\.\d{0,2})$/;  [0-9]*(\.[0-9]+)?$","g");
     
      var regex = /^\d+(?:\.\d{0,2})$/;
     
      if( ! fTrim( $('#fobfinal').val() ) ){
        Mensaje = Mensaje + "'FOB Final es obligatorio\n";
      }
      else{
      
       if( ! foNumero( $('#fobfinal').val() ) ){
            
             if(! regex.test( $('#fobfinal').val() ) ){
            Mensaje = Mensaje + "FOB Final no tiene el formato correcto, n\372mero con punto decimal\n";
          } 
      
            
            
          } 
             
          //if( ! mascara.test( $('#fobfinal').val() ) ){
         
      }
    
       if( ! fTrim( $('#fec_liq').val() ) ){
        Mensaje = Mensaje + "'Fecha Liquidaci\363n' es obligatorio\n";
      }
      else{
          if( ! fFecha( $('#fec_liq').val() ) ){
            Mensaje = Mensaje + "'Fecha Liquidaci\363n' no tiene el formato dd/mm/aaaa\n";
          } 
          else
          {
                             
             if ( !ComparaFechas($('#fecha_notificacion').val(),$('#fec_liq').val()))
                 Mensaje = Mensaje + "'La Fecha de Liquidaci\363n' no puede ser anterior a la 'Fecha de Notificaci\363n'. \n";
            if ( !ComparaFechas($('#fec_liq').val(),diames + "/" + mes + "/" + ano))
                 Mensaje = Mensaje + "'La Fecha de Liquidaci\363n' no puede ser mayor a la de hoy. \n";
          }
      }
    
      if( ! fTrim( $('#tributo_ga').val() ) ){
        Mensaje = Mensaje + "'Tributo Omitido GA' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#tributo_ga').val() ) ){
            Mensaje = Mensaje + "'Tributo Omitido GA' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#tributo_iva').val() ) ){
        Mensaje = Mensaje + "'Tributo Omitido IVA' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#tributo_iva').val() ) ){
            Mensaje = Mensaje + "'Tributo Omitido IVA' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#tributo_ice').val() ) ){
        Mensaje = Mensaje + "'Tributo Omitido ICE' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#tributo_ice').val() ) ){
            Mensaje = Mensaje + "'Tributo Omitido ICE' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#tributo_iehd').val() ) ){
        Mensaje = Mensaje + "'Tributo Omitido IEHD' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#tributo_iehd').val() ) ){
            Mensaje = Mensaje + "'Tributo Omitido IEHD' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#sancion').val() ) ){
        Mensaje = Mensaje + "'Sancion por Omisi\363n de Pago' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#sancion').val() ) ){
            Mensaje = Mensaje + "'Sancion por Omisi\363n de Pago' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#multaca_ufv').val() ) ){
        Mensaje = Mensaje + "'Multa por Contravenci\363n Aduanera' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#multaca_ufv').val() ) ){
            Mensaje = Mensaje + "'Multa por Contravenci\363n Aduanera' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#multacc').val() ) ){
        Mensaje = Mensaje + "'Multa por Contravenci\363n Contravencional' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#multacc').val() ) ){
            Mensaje = Mensaje + "'Multa por Contravenci\363n Contravencional' debe ser un n\372mero\n";
          } 
      }
      if( ! fTrim( $('#multacd').val() ) ){
        Mensaje = Mensaje + "'Multa por Contrabando Delito' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#multacd').val() ) ){
            Mensaje = Mensaje + "'Multa por Contrabando Delito' debe ser un n\372mero\n";
          } 
      }           
      if(!fTrim($('#observacionenm').val())){
        Mensaje = Mensaje + "'Observaci\363n Enmienda' es obligatorio";
      }  
      if( Mensaje == "" )
      {
        $('#boton').val('registrar_enm');
        document.FisResultadosForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  };
   function ComparaFechas(fec0, fec1)
  {  
   var bRes = false;
   var sDia0 = fec0.substr(0, 2);
   var sMes0 = fec0.substr(3, 2);
   var sAno0 = fec0.substr(6, 4);
   var sDia1 = fec1.substr(0, 2);
   var sMes1 = fec1.substr(3, 2);
   var sAno1 = fec1.substr(6, 4);
    if (sAno1 > sAno0 ) bRes = true;
   else 
   {  if (sAno0 == sAno1)
      {  if (sMes1 > sMes0 ) bRes = true;
         else 
         {  if (sMes0 == sMes1)
               if (sDia1 >= sDia0 ) bRes = true;
         }
      }
      
   }
   return bRes;
  };  
  
  
  
function recupera_ufv() {

      var aux = Math.random();
      var fechaufv = $('#fec_liq').val();
      
      $.getJSON("json.do", 
      {
          parameter : 'devuelveUFV', fecha : fechaufv, vaux : aux
      },
      function (j) {
      if(j[0].value==0)
            {
             $('#valor_ufv').val('');
            }
            else
            {
            $('#valor_ufv').val(j[0].value);
            }
      
      });   
      
      /*
      $.get('JqueryServlet', { 
            fecha : fechaufv
      }, function(responseText) { 
            $('#valor_ufv').val(responseText);
      });
      */
     
      
  };
  function calcula_tributo() {
    var tributo_ga = new Number($('#tributo_ga').val());
    var tributo_iva = new Number($('#tributo_iva').val());
    var tributo_ice = new Number($('#tributo_ice').val());
    var tributo_iehd = new Number($('#tributo_iehd').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    var sancion = new Number($('#sancion').val());
    if(valor_ufv == "")
    {
        $('#tributo_ufv_ga').val("");
        $('#tributo_ufv_iva').val("");
        $('#tributo_ufv_ice').val("");
        $('#tributo_ufv_iehd').val("");
        $('#sancion').val("");
    }
    else
    {
        $('#tributo_ufv_ga').val(Math.round(tributo_ga/valor_ufv,0));
        $('#tributo_ufv_iva').val(Math.round(tributo_iva/valor_ufv,0));
        $('#tributo_ufv_ice').val(Math.round(tributo_ice/valor_ufv,0));
        $('#tributo_ufv_iehd').val(Math.round(tributo_iehd/valor_ufv,0));
        $('#sancion_ufv').val(Math.round(sancion/valor_ufv,0));
    }    
  };
  
  
  function calcula_multaca() {
    var tributo = new Number($('#multaca_ufv').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    if(valor_ufv == "")
    {
        $('#multaca').val("");
    }
    else
    {
        $('#multaca').val(Math.round(tributo*valor_ufv,0));
    }    
  };
  
  
  function calcula_multacc() {
    var tributo = new Number($('#multacc').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    if(valor_ufv == "")
    {
        $('#multacc_ufv').val("");
    }
    else
    {
        $('#multacc_ufv').val(Math.round(tributo/valor_ufv,0));
    }    
  };
  
  function calcula_multacd() {
    var tributo = new Number($('#multacd').val());
    var valor_ufv = new Number($('#valor_ufv').val().replace(',','.'));
    if(valor_ufv == "")
    {
        $('#multacd_ufv').val("");
    }
    else
    {
        $('#multacd_ufv').val(Math.round(tributo/valor_ufv,0));
    }    
  };
  
  
  
</script>

<html:form action="/FisResultados" >
    <div id="formulario">
        <%
FisResultadosForm bean = (FisResultadosForm)request.getAttribute("FisResultadosForm");
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
         
          
         <h2>ENMIENDA RESULTADOS CONTROL DIFERIDO</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
            <input type="hidden" name="boton" id="boton" />
            <html:hidden property="fecha_notificacion" styleId="fecha_notificacion" />
                <table >
                    <tr>
                        <td height="35" >
                            <label>
                                <strong>Gesti&oacute;n:</strong>
                            </label>
                        </td>
                        <td height="35">
                            <label>
                                <strong>Aduana:</strong>
                            </label>
                        </td>
                        <td height="35" >
                            <label>
                                <strong>N&uacute;mero:</strong>
                            </label>
                        </td>
                    </tr>
                    <tr>    
                       <td height="35" >
                            <html:text property="key_year" maxlength="4" style="width:50px" styleId="key_year"/>
                        </td>
                        <td height="35">
                       <%=Util.DevuelveAduanas(bean.getKey_cuo(),(String)request.getSession().getAttribute("user.gerencia"))%>
                             
                        </td>
                        <td height="35" >
                            <html:text property="reg_serial" maxlength="7" style="width:80px" styleId="reg_serial"/>
                        </td>
                    </tr>
                    <tr>    
                        <td height="35" colspan="3" >
                            <center>
                                <input type="button" name="boton"  value="Consultar" onclick="consultar(1)"></input>
                            </center>
                        </td>
                    </tr>
                </table>
                
                </fieldset>
                <%if(!(bean == null))
                    if(!(bean.getEstado()==null))
                    { 
                        %><fieldset><%=bean.getDeclaracion()%></fieldset>
                         <%
                         if (bean.getEstado().equals("CIERRE")||bean.getEstado().equals("RESULTADOS")||bean.getEstado().equals("FINALIZADO")||bean.getEstado().equals("NOTIFICADO CONCLUIDO")||bean.getEstado().equals("ENVIO LEGAL"))
                        {                        
                        %>
                        
                        
                         <fieldset>
                         <table width="90%">
                       
                         <tr><td>FOB Total (USD):</td><td>  <center>INICIAL<br/>
                         <html:text property="fobinicial" disabled="true" style="width:100px" maxlength="18" styleId="fobinicial"/>
                          </center></td><td>  <center>FINAL<br/><html:text property="fobfinal" style="width:100px" maxlength="18" styleId="fobfinal"/>  </center></td></tr>
                             
                       <tr><td colspan="3">&nbsp;</td></tr>
                       
                         
                       
                            <tr>
                               <td >Fecha de Liquidaci&oacute;n del documento de conclusi&oacute;n (VC-RD):
                                </td>
                           
                                <td  >
                                    <center>
                                    
                                    
                                        
<table><tr><td><html:text property="fec_liq" style="width:100px" onblur="recupera_ufv()" maxlength="10" styleId="fec_liq"/>
                                        
  </td><td><img src="img/calendar_1.png" id="imcal" style="cursor:pointer;" onclick="javascript:NewCssCal('fec_liq','ddMMyyyy')" />
                               </td></tr>
                               
                               
                               
                               
                               </table>
                                        
                                    </center>
                                </td>
                                <td >Valor UFV:  <html:text disabled="true" property="valor_ufv" style="width:100px" maxlength="18" styleId="valor_ufv"/>
                                </td>
                            </tr>
                            
                              
                            
                            
                            <tr>
                                <td ><center>CONCEPTO</center>
                                </td>
                           
                                <td ><center>IMPORTE BS</center>
                                </td>
                                
                                <td ><center>IMPORTE UFV</center>
                                </td>
                            </tr>
                            
                            
                            <tr>
                               <td>Tributo Omitido GA:
                                </td>
                         
                                <td>
                                    <center>
                                        <html:text property="tributo_ga" onblur="calcula_tributo()" style="width:100px" maxlength="18" styleId="tributo_ga"/>
                                    </center>
                                </td>
                                <td>
                                    <center>
                                        <html:text disabled="true" property="tributo_ufv_ga" style="width:100px" maxlength="18" styleId="tributo_ufv_ga"/>
                                    </center>
                                </td>
                            </tr>
                            <tr>
                               <td>Tributo Omitido IVA:
                                </td>
                         
                                <td>
                                    <center>
                                        <html:text property="tributo_iva" onblur="calcula_tributo()" style="width:100px" maxlength="18" styleId="tributo_iva"/>
                                    </center>
                                </td>
                                <td>
                                    <center>
                                        <html:text disabled="true" property="tributo_ufv_iva" style="width:100px" maxlength="18" styleId="tributo_ufv_iva"/>
                                    </center>
                                </td>
                            </tr>
                            <tr>
                               <td>Tributo Omitido ICE:
                                </td>
                         
                                <td>
                                    <center>
                                        <html:text property="tributo_ice" onblur="calcula_tributo()" style="width:100px" maxlength="18" styleId="tributo_ice"/>
                                    </center>
                                </td>
                                <td>
                                    <center>
                                        <html:text disabled="true" property="tributo_ufv_ice" style="width:100px" maxlength="18" styleId="tributo_ufv_ice"/>
                                    </center>
                                </td>
                            </tr>
                            <tr>
                               <td>Tributo Omitido IEHD:
                                </td>
                         
                                <td>
                                    <center>
                                        <html:text property="tributo_iehd" onblur="calcula_tributo()" style="width:100px" maxlength="18" styleId="tributo_iehd"/>
                                    </center>
                                </td>
                                <td>
                                    <center>
                                        <html:text disabled="true" property="tributo_ufv_iehd" style="width:100px" maxlength="18" styleId="tributo_ufv_iehd"/>
                                    </center>
                                </td>
                            </tr>
                            <tr>
                               <td >Sanci&oacute;n por Omisi&oacute;n de Pago:
                                </td>
                           
                                <td >
                                    <center>
                                        <html:text property="sancion" onblur="calcula_tributo()" style="width:100px" maxlength="18" styleId="sancion"/>
                                    </center>
                                </td>
                                <td >
                                    <center>
                                        <html:text disabled="true" property="sancion_ufv" style="width:100px" maxlength="18" styleId="sancion_ufv"/>
                                    </center>
                                </td>
                            </tr>
                            <tr>
                               <td >Multa por Contravenci&oacute;n Aduanera:
                                </td>
                           
                                <td >
                                    <center>
                                        <html:text disabled="true" property="multaca" style="width:100px" maxlength="18" styleId="multaca"/>
                                    </center>
                                </td>
                                <td >
                                    <center>
                                        <html:text property="multaca_ufv"  onblur="calcula_multaca()"  style="width:100px" maxlength="18" styleId="multaca_ufv"/>
                                    </center>
                                </td>
                            </tr>
                            <tr>
                               <td >Multa por Contrabando Contravencional:
                                </td>
                            
                                <td >
                                    <center>
                                        <html:text property="multacc" onblur="calcula_multacc()" style="width:100px" maxlength="18" styleId="multacc"/>
                                    </center>
                                </td>
                                <td >
                                    <center>
                                        <html:text disabled="true" property="multacc_ufv" style="width:100px" maxlength="18" styleId="multacc_ufv"/>
                                    </center>
                                </td>
                            </tr>
                            <tr>
                               <td >Multa por Contrabando Delito:
                                </td>
                           
                                <td >
                                    <center>
                                        <html:text property="multacd" onblur="calcula_multacd()" style="width:100px" maxlength="18" styleId="multacd"/>
                                    </center>
                                </td>
                                <td >
                                    <center>
                                        <html:text disabled="true" property="multacd_ufv" style="width:100px" maxlength="18" styleId="multacd_ufv"/>
                                    </center>
                                </td>
                            </tr>
                        
                            <tr>
                                <td colspan="2">
                                    Observaci&oacute;n Enmienda:
                                </td>
                                <td colspan="2">
                                    <html:text property="observacionenm" style="width:300px" maxlength="200" styleId="observacionenm"/>
                                </td>
                            </tr>
                            <tr>
                               <td colspan="4" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar Resultados"
                                               onclick="registrar(1)"></input>
                                        <input type="button" value="Cancelar"  name="boton"   onclick="cancelar(1)"></input>
                                    </center>
                                </td>
                            </tr>
                      
                        </table></fieldset>
                          <%                         
                        } else
                        {%><fieldset>
                         <table width="60%">
                            <tr>
                                <td><label style="color:red">TODAVIA NO SE REGISTRO ESTA ETAPA EN EL CONTROL DIFERIDO</label>
                                   </td>
                            </tr>
                        </table>
                         </fieldset>
                           <% 
                        }
                            }              
                       %>
                            
                        
                      
                
                
            
        </div>
         
         
         
        
        
    </div>
</html:form>