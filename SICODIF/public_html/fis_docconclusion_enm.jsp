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
        document.FisDocConclusionForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar_enm');
      document.FisDocConclusionForm.submit();
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
      
       if( ! fTrim( $('#fec_not_doc').val() ) ){
        Mensaje = Mensaje + "'Fecha Notificaci\363n' es obligatorio\n";
      }
       else{
          if( ! fFecha( $('#fec_not_doc').val() ) ){
            Mensaje = Mensaje + "'Fecha Notificaci\363n' no tiene el formato dd/mm/aaaa\n";
          } 
          else
          {
           if ( !ComparaFechas($('#fecha_doc_con').val(),$('#fec_not_doc').val()))
                 Mensaje = Mensaje + "'La Fecha de Notificaci\363n' no puede ser anterior a la 'Fecha de Documento de Conlusi\363n'. \n";
            if ( !ComparaFechas($('#fec_not_doc').val(),diames + "/" + mes + "/" + ano))
                 Mensaje = Mensaje + "'La Fecha de Notificaci\363n' no puede ser mayor a la de hoy. \n";
          }
      }
            
      
       if( ! fTrim( $('#tip_not_doc').val() ) ){
        Mensaje = Mensaje + "'Tipo de Notificaci\363n' es obligatorio\n";
      }
    
      if( Mensaje == "" )
      {
        $('#boton').val('registrar_enm');
        document.FisDocConclusionForm.submit();
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

<html:form action="/FisDocConclusion" >
    <div id="formulario">
        <%
FisDocConclusionForm bean = (FisDocConclusionForm)request.getAttribute("FisDocConclusionForm");
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
         
          
         <h2>ENMIENDA FECHA DE NOTIFICACION DOCUMENTO DE CONCLUSION</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
            <input type="hidden" name="boton" id="boton" />
            
            
             <html:hidden property="fecha_doc_con" styleId="fecha_doc_con" />
            
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
                         if (bean.getEstado().equals("NOTIFICADO CONCLUIDO")||bean.getEstado().equals("ENVIO LEGAL"))
                        {                        
                        %>
                      
                        
                        <fieldset>
                         <table width="60%">
                            <tr>
                               <td >Registre Fecha de Notificaci&oacute;n:
                                </td>
                            
                                <td >
                                   
                                        
<table><tr><td><html:text property="fec_not_doc" style="width:100px" maxlength="10" styleId="fec_not_doc"/>
                                  
  </td><td><img src="img/calendar_1.png" id="imcal" style="cursor:pointer;" onclick="javascript:NewCssCal('fec_not_doc','ddMMyyyy')" />
                               </td></tr></table>
                                </td>
                            </tr>
                            
                            <tr>
                               <td >Registre Tipo de Notificaci&oacute;n:
                                </td>
                            
                                <td >
                                   
                                        <html:select property="tip_not_doc" styleId="tip_not_doc">
                                 <html:option value="">-- Seleccione el Tipo --</html:option>
                                 <html:option value="PERSONAL">PERSONAL</html:option>
                                 <html:option value="EDICTO">EDICTO</html:option>
                                 <html:option value="CEDULA">CEDULA</html:option>
                                 <html:option value="TACITO">TACITO</html:option>
                                 <html:option value="SECRETARIA">SECRETARIA</html:option>
                                 </html:select>
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
                        } 
                        else
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