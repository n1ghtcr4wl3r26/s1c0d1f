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
<%
    SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar fecha = Calendar.getInstance();
    fecha.setTime( fecha.getTime() );
    String fhoy = fFecha.format( fecha.getTime() );
%>

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
        document.FisCierreContDifForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar');
      document.FisFinalizaForm.submit();
  };
  function registrar(valor) {
      var Mensaje = "";
      
    var check = 0;  
var fecha=new Date();
    var diames=fecha.getDate();
    var mes=fecha.getMonth() +1 ;
    var ano=fecha.getFullYear();
    
    if (10 > diames) 
     diames = "0"+diames;
    if (10 > mes) 
     mes = "0"+mes;
     
      if( ! fTrim( $('#tip_doc_con').val() ) ){
        Mensaje = Mensaje + "'Tipo Documento Conclusi\363n' es obligatorio\n";
      }
      
      if( ! fTrim( $('#nro_inf').val() ) ){
        Mensaje = Mensaje + "'N\372mero de Informe' es obligatorio\n";
      }
      
      if($('#ovalor').attr('checked'))
        check = 1;  
      if($('#opartida').attr('checked'))
        check = 1;  
      if($('#oorigen').attr('checked'))
        check = 1;  
      if($('#osinobs').attr('checked'))
        check = 1;  
      
      if(check == 0)
      {
        Mensaje = Mensaje + "'Observaciones encontradas' es obligatorio, debe seleccionar al menos una.\n";
      }
      
       if( ! fTrim( $('#fec_inf').val() ) ){
        Mensaje = Mensaje + "'Fecha Informe' es obligatorio\n";
      }
       else{
          if( ! fFecha( $('#fec_inf').val() ) ){
            Mensaje = Mensaje + "'Fecha Informe' no tiene el formato dd/mm/aaaa\n";
          } 
          else
          {
          
          if ( !ComparaFechas($('#fecha_liquidacion').val(),$('#fec_inf').val()))
                 Mensaje = Mensaje + "'La Fecha Informe' no puede ser anterior a la 'Fecha de Liquidaci\363n'. \n";
            if ( !ComparaFechas($('#fec_inf').val(),diames + "/" + mes + "/" + ano))
                 Mensaje = Mensaje + "'La Fecha Informe' no puede ser mayor a la de hoy. \n";
          }
          
      }
            
       
      if( ! fTrim( $('#nro_doc_con').val() ) ){
        Mensaje = Mensaje + "'N\372mero Documento Conclusi\363n' es obligatorio\n";
      }
      
      
       if( ! fTrim( $('#fec_doc_con').val() ) ){
        Mensaje = Mensaje + "'Fecha Documento Conclusi\363n' es obligatorio\n";
      }
       else{
          if( ! fFecha( $('#fec_doc_con').val() ) ){
            Mensaje = Mensaje + "'Fecha Documento Conclusi\363n' no tiene el formato dd/mm/aaaa\n";
          } 
           else
          {
          
          if ( !ComparaFechas($('#fecha_liquidacion').val(),$('#fec_doc_con').val()))
                 Mensaje = Mensaje + "'Fecha Documento Conclusi\363n' no puede ser anterior a la 'Fecha de Liquidaci\363n'. \n";
            if ( !ComparaFechas($('#fec_doc_con').val(),diames + "/" + mes + "/" + ano))
                 Mensaje = Mensaje + "'Fecha Documento Conclusi\363n' no puede ser mayor a la de hoy. \n";
          }
      }
      
      
      
      
     
      if( Mensaje == "" )
      {
        $('#boton').val('registrar');
        document.FisFinalizaForm.submit();
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
  
  function guardarcierre(valor) {
  
      var Mensaje = "";            
      var regex = /^\d+(?:\.\d{0,2})$/;  
      var o = /\b.+/.test($('#cierreobservacion').val());
     
   if (!o) Mensaje = Mensaje +"Observaci\363n, es obligatorio.\n";
   
   if($('#cierreobservacion').val().length>=600){
                Mensaje = Mensaje + "Observaci\363n, solo es permitido 600 caracteres.\n";                    
                } 
   
    
      if( Mensaje == "" )
      {
        $('#boton').val('guardar_cierre');
        document.FisCierreContDifForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  };  
</script>

<html:form action="/FisCierreContDif">
    <div id="formulario">
        <%
FisCierreContDifForm bean = (FisCierreContDifForm)request.getAttribute("FisCierreContDifForm");
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
         
          
         <h2>CIERRE CONTROL DIFERIDO</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
            <input type="hidden" name="boton" id="boton" />
            <html:hidden property="fecha_liquidacion" styleId="fecha_liquidacion" />
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
                        
                                                
                        if (bean.getEstado().equals("FINALIZADO"))
                        {  
                        
                       
                        %><fieldset>
                         <table width="100%">
                            <tr><td width="7%">Fecha Anulaci&oacute;n:</td>
                                <td colspan="3" >  
                                 <%=fhoy%>
                                </td>
                            </tr>
                       
                            <tr><td width="7%">Oservaci&oacute;n:</td>
                                <td colspan="3">  
                                
                                    <html:textarea property="cierreobservacion" style="width:93%"  styleId="cierreobservacion"/>
                                
                                </td>
                            </tr> 
                            <tr>
                               <td colspan="2" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar Cierre"
                                               onclick="guardarcierre(1)"></input>
                                        
                                    </center>
                                </td>
                            </tr>
                              </table></fieldset>
                            <% 
                        
                        }else
                        {%>
                       <!-- <fieldset>
                         <table width="60%">
                            <tr>
                                <td><label style="color:red">EL CONTROL DIFERIDO NO SE ENCUENTRA HABILITADO PARA CIERRE</label>
                                   </td>
                            </tr>
                        </table>
                         </fieldset> -->
                           <% 
                        } 
                        
                        } else
                        {%><fieldset>
                         <table width="60%">
                            <tr>
                                <td><label style="color:red">NO HA SIDO ASIGNADO A ESTA FISCALIZACI&Oacute;N</label>
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