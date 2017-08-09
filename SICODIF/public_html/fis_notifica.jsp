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
        $('#boton').val('consultar');
        document.FisNotificaForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar');
      document.FisNotificaForm.submit();
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
  
  if( ! fTrim( $('#fecha_notificacion').val() ) ){
        Mensaje = Mensaje + "'Fecha de notificaci\363n' es obligatorio\n";
      }
       else{
          if( ! fFecha( $('#fecha_notificacion').val() ) ){
            Mensaje = Mensaje + "'Fecha de notificaci\363n' no tiene el formato dd/mm/aaaa\n";
          } 
          else
          {
            if ( !ComparaFechas($('#fecha_registro_control').val(),$('#fecha_notificacion').val()))
                 Mensaje = Mensaje + "'La Fecha de Notificaci\363n' no puede ser anterior a la 'Fecha de Registro'. \n";
            if ( !ComparaFechas($('#fecha_notificacion').val(),diames + "/" + mes + "/" + ano))
                 Mensaje = Mensaje + "'La Fecha de Notificaci\363n' no puede ser mayor a la de hoy. \n";
          }
      }
      
     
      
     if( ! fTrim( $('#observacion').val() ) ){
        Mensaje = Mensaje + "'Observaci\363n' es obligatorio\n";
      }
      
      if( ! fTrim( $('#tipo').val() ) ){
        Mensaje = Mensaje + "'Tipo Notificaci\363n' es obligatorio\n";
      }
    
      if( Mensaje == "" )
      {
        $('#boton').val('registrar');
        document.FisNotificaForm.submit();
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
</script>

<html:form action="/FisNotifica" >
    <div id="formulario">
        <%
FisNotificaForm bean = (FisNotificaForm)request.getAttribute("FisNotificaForm");
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
         
         <h2>NOTIFICACION</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
            <input type="hidden" name="boton" id="boton" />
            <html:hidden property="fecha_registro_control" styleId="fecha_registro_control" />
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
                        %><fieldset><%=bean.getDeclaracion()%></fieldset><%
                        if(bean.getUsuario().equals(bean.getFiscalizador()))
                        {
                        
                        if(bean.getEstado().equals("ASIGNADO"))
                        {                        
                        %>
                        <fieldset>
                         <table width="60%">
                            <tr>
                                <td>Fecha:
                                </td>
                                <td>Observaci&oacute;n:
                                </td>
                                <td>Tipo de Notificaci&oacute;n:
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <table><tr><td><html:text property="fecha_notificacion" maxlength="10" style="width:100px" styleId="fecha_notificacion"/>
                               </td><td><img src="img/calendar_1.png" id="imcal" style="cursor:pointer;" onclick="javascript:NewCssCal('fecha_notificacion','ddMMyyyy')" />
                               </td></tr></table>
                                </td>
                                <td><html:text property="observacion" maxlength="100" style="width:300px" styleId="observacion"/>
                                </td>
                                 <td>
                                 <html:select property="tipo" styleId="tipo">
                                 <html:option value="">-- Seleccione el Tipo --</html:option>
                                 <html:option value="PERSONAL">PERSONAL</html:option>
                                 <html:option value="CEDULA">CEDULA</html:option>
                                 <html:option value="EDICTO">EDICTO</html:option>
                                 <html:option value="TACITO">TACITO</html:option>
                                 <html:option value="ELECTRONICA">ELECTRONICA</html:option>
                                 </html:select>
                                </td>
                            </tr>
                            <tr>
                               <td colspan="3" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar Notificaci&oacute;n"
                                               onclick="registrar(1)"></input>
                                        <input type="button" value="Cancelar"  name="boton"   onclick="cancelar(1)"></input>
                                    </center>
                                </td>
                            </tr>
                        </table>
                        </fieldset>
                        <%
                         }
                         else
                         {
                         
                        if (bean.getEstado().equals("NOTIFICADO")||bean.getEstado().equals("RESULTADOS")||bean.getEstado().equals("FINALIZADO")||bean.getEstado().equals("NOTIFICADO CONCLUIDO")||bean.getEstado().equals("ENVIO LEGAL"))
                        {                        
                        %>
                        <fieldset>
                         <table width="60%">
                            <tr>
                                <td>Fecha:
                                </td>
                                <td>Observaci&oacute;n:
                                </td>
                                <td>Tipo de Notificaci&oacute;n:
                                </td>
                            </tr>
                            <tr>
                                <td>
                                <html:text property="fecha_notificacion" maxlength="10" disabled="true" style="width:100px" styleId="fecha_notificacion"/>
                                </td>
                                <td><html:text property="observacion" maxlength="100" disabled="true" style="width:300px" styleId="observacion"/>
                                </td>
                                 <td>
                                 <html:text property="tipo" maxlength="10" disabled="true" style="width:100px" styleId="tipo"/>
                                
                                </td>
                            </tr>
                        
                        </table>
                        </fieldset>
                        <%
                         }
                         
                         else
                        {%><fieldset>
                         <table width="60%">
                            <tr>
                                <td><label style="color:red">NO ESTA EN LA ETAPA CORRECTA PARA LLENAR ESTA INFORMACION</label>
                                   </td>
                            </tr>
                        </table>
                         </fieldset>
                           <% 
                        }
                         
                         
                         }
                         
                        } else
                        {%><fieldset>
                         <table width="60%">
                            <tr>
                                <td><label style="color:red">NO HA SIDO ASIGNADO A ESTA FISCALIZACION</label>
                                   </td>
                            </tr>
                        </table>
                         </fieldset>
                           <% 
                        }
                        
                        
                        %><%
                    }
                %>
                    
                
                
            
        </div>
         
         
         
        
    </div>
</html:form>