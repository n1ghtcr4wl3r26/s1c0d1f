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
        document.FisEnvioLegalForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar_enm');
      document.FisEnvioLegalForm.submit();
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
     
       if( ! fTrim( $('#fec_env_legal').val() ) ){
        Mensaje = Mensaje + "'Fecha de Remisi\363n' es obligatorio\n";
      }
       else{
          if( ! fFecha( $('#fec_env_legal').val() ) ){
            Mensaje = Mensaje + "'Fecha de Remisi\363n' no tiene el formato dd/mm/aaaa\n";
          } 
          else
          {
           if ( !ComparaFechas($('#fecha_not_doc_con').val(),$('#fec_env_legal').val()))
                 Mensaje = Mensaje + "'Fecha de Remisi\363n' no puede ser anterior a la 'Fecha de Notificaci\363n del Documento de Conlusi\363n'. \n";
            if ( !ComparaFechas($('#fec_env_legal').val(),diames + "/" + mes + "/" + ano))
                 Mensaje = Mensaje + "'Fecha de Remisi\363n' no puede ser mayor a la de hoy. \n";
          }
      }   
      
       if( ! fTrim( $('#nro_env_legal').val() ) ){
        Mensaje = Mensaje + "'N\372mero de Documento de remisi\363n' es obligatorio\n";
      }
    if(!fTrim($('#observacionenm').val())){
        Mensaje = Mensaje + "'Observaci\363n Enmienda' es obligatorio";
      }
      if( Mensaje == "" )
      {
        $('#boton').val('registrar_enm');
        document.FisEnvioLegalForm.submit();
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

<html:form action="/FisEnvioLegal" >
    <div id="formulario">
        <%
FisEnvioLegalForm bean = (FisEnvioLegalForm)request.getAttribute("FisEnvioLegalForm");
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
         
          
         <h2>ENMIENDA ENVIO A LA UNIDAD LEGAL</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
            <input type="hidden" name="boton" id="boton" />
            <html:hidden property="fecha_not_doc_con" styleId="fecha_not_doc_con" />
            
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
                         if (bean.getEstado().equals("ENVIO LEGAL"))
                        {                        
                        %>
                      
                        
                        <fieldset>
                         <table width="60%">
                           <tr>
                               <td >Registre Fecha de Remisi&oacute;n:
                                </td>
                            
                                <td >
                                   
                                         <table><tr><td><html:text property="fec_env_legal" style="width:100px" maxlength="10" styleId="fec_env_legal"/>
                                 
  </td><td><img src="img/calendar_1.png" id="imcal" style="cursor:pointer;" onclick="javascript:NewCssCal('fec_env_legal','ddMMyyyy')" />
                               </td></tr></table>
                                </td>
                            </tr>
                            
                            <tr>
                               <td >Registre N&uacute;mero de Documento de remisi&oacute;n:
                                </td>
                            
                                <td >
                                   
                                      <html:text property="nro_env_legal" style="width:100px" maxlength="10" styleId="nro_env_legal"/>
                                  
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Observaci&oacute;n Enmienda:
                                </td>
                                <td>
                                    <html:text property="observacionenm" style="width:300px" maxlength="200" styleId="observacionenm"/>
                                </td>
                            </tr>
                            <tr>
                               <td colspan="2" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar Finalizaci&oacute;n"
                                               onclick="registrar(1)"></input>
                                        <input type="button" value="Cancelar"  name="boton"   onclick="cancelar(1)"></input>
                                    </center>
                                </td>
                            </tr>
                        </table></fieldset>
                        
                        
                        
                        <% 
                         }  else
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