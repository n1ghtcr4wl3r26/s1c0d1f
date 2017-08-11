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
        document.FisFinalizaForm.submit();
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
    var fecha = new Date();
    var fecha3 = new Date();
    tiempo = fecha.getTime();
    milisegundos = parseInt((-3)*24*60*60*1000);
    total = fecha3.setTime(tiempo+milisegundos);
    
    var diames=fecha.getDate();
    var mes=fecha.getMonth() +1 ;
    var ano=fecha.getFullYear();

    var diames3=fecha3.getDate();
    var mes3=fecha3.getMonth() +1 ;
    var ano3=fecha3.getFullYear();
    
    if (10 > diames) 
     diames = "0"+diames;
    if (10 > mes) 
     mes = "0"+mes;
     
    if (10 > diames3) 
     diames3 = "0"+diames3;
    if (10 > mes3) 
     mes3 = "0"+mes3;
     
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
            if ( $('#sw').val()== "0")
                if ( !ComparaFechas($('#fechavenc').val(), $('#fec_doc_con').val()))
                    Mensaje = Mensaje + "'Fecha Documento Conclusi\363n' no puede ser mayor a 3 d\355as h\341biles a partir del d\355a siguiente de la fecha del documento de conclusi\363n, respecto a la fecha actual, la menor fecha de registro v\341lida es: "+$('#fechavenc').val()+". \n";
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
</script>

<html:form action="/FisFinaliza" >
    <div id="formulario">
        <%
FisFinalizaForm bean = (FisFinalizaForm)request.getAttribute("FisFinalizaForm");
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
         
          
         <h2>FINALIZAR CONTROL DIFERIDO</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
            <input type="hidden" name="boton" id="boton" />
            <html:hidden property="fecha_liquidacion" styleId="fecha_liquidacion" />
            <html:hidden property="fechavenc" styleId="fechavenc" />
            <html:hidden property="sw" styleId="sw" />
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
                        
                        %>
                          <fieldset>
                         <table width="100%">
                        <%
                        
                        if(bean.getEstado().equals("RESULTADOS"))
                        {
                        
                       
                        %>
                             <tr>
                               <td >Documento de Conclusi&oacute;n:
                                </td>
                                <td >
                                    <html:select property="tip_doc_con" styleId="tip_doc_con">
                                 <html:option value="">-- Seleccione el Tipo --</html:option>
                                 <html:option value="RESOLUCION DETERMINATIVA">RESOLUCION DETERMINATIVA</html:option>
                                 <html:option value="VISTA DE CARGO">VISTA DE CARGO</html:option>
                                 <html:option value="ACTA DE INTERVENCION">ACTA DE INTERVENCION</html:option>
                                 <html:option value="AUTO INICIAL DE SUMARIO CONTRAVENCIONAL">AUTO INICIAL DE SUMARIO CONTRAVENCIONAL</html:option>
                                 </html:select>
                                </td>
                            </tr>
                            
                            <tr>
                               <td >N&uacute;mero de Informe:
                                </td>
                                <td >
                                     <html:text property="nro_inf" style="width:100px" maxlength="30" styleId="nro_inf"/>
                                   
                                </td>
                            </tr>
                            <tr>
                               <td >Fecha de Informe:
                                </td>
                                <td >
                                    <table><tr><td>  <html:text property="fec_inf" style="width:100px" maxlength="10" styleId="fec_inf"/>
                                  
  </td><td><img src="img/calendar_1.png" id="imcal" style="cursor:pointer;" onclick="javascript:NewCssCal('fec_inf','ddMMyyyy')" />
                               </td></tr></table>
                                </td>
                            </tr>
                            <tr>
                               <td >N&uacute;mero de Documento de Conclusi&oacute;n:
                                </td>
                                <td >
                                     <html:text property="nro_doc_con" style="width:100px" maxlength="30" styleId="nro_doc_con"/>
                                   
                                </td>
                            </tr>
                            <tr>
                               <td >Fecha de Documento de Conclusi&oacute;n:
                                </td>
                                <td >
                                     <table><tr><td> <html:text property="fec_doc_con" style="width:100px" maxlength="10" styleId="fec_doc_con"/>
                                  
  </td><td><img src="img/calendar_1.png" id="imcal" style="cursor:pointer;" onclick="javascript:NewCssCal('fec_doc_con','ddMMyyyy')" />
                               </td></tr></table>
                                </td>
                            </tr>
                            
                            
                            
                            <tr>
                               <td >Observaciones encontradas:
                                </td>
                           
                            <td >Contravenciones encontradas:
                                </td>
                                </tr>
                                
                           <tr>
                               <td >
                                   <table>
<tr>
	    <td height="25"><html:checkbox styleId="ovalor" property="ovalor"/></td>
            <td height="25" width="300px"><label><strong>VALOR</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox styleId="opartida" property="opartida"/></td>
            <td height="25" width="300px"><label><strong>PARTIDA</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox styleId="oorigen" property="oorigen"/></td>
            <td height="25" width="300px"><label><strong>ORIGEN</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox styleId="osinobs" property="osinobs"/></td>
            <td height="25" width="300px"><label><strong>S/OBSERVACION</strong></label></td>
          </tr>

</table>
                                </td>
                                <td >
<table>
<tr>
	    <td height="25"><html:checkbox styleId="comision" property="comision"/></td>
            <td height="25" width="300px"><label><strong>OMISION DE PAGO</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox styleId="ccondel" property="ccondel"/></td>
            <td height="25" width="300px"><label><strong>CONTRABANDO DELITO</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox styleId="cconcon" property="cconcon"/></td>
            <td height="25" width="300px"><label><strong>CONTRABANDO CONTRAVENCIONAL</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox styleId="cconadu" property="cconadu"/></td>
            <td height="25" width="300px"><label><strong>CONTRAVENCION ADUANERA</strong></label></td>
          </tr>

</table>
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
                            <% 
                        
                        }
                        else
                        {
                        //if(bean.getEstado().equals("RESULTADOS") || bean.getNro_inf() != null )
                        if (bean.getEstado().equals("FINALIZADO")||bean.getEstado().equals("NOTIFICADO CONCLUIDO")||bean.getEstado().equals("ENVIO LEGAL"))
                        {
                        
                       
                        %>
                            
                            <tr>
                               <td >Tipo de Documento de Conclusi&oacute;n:
                                </td>
                                <td >
                                <html:text disabled="true"  property="tip_doc_con" style="width:250px" maxlength="40" styleId="tip_doc_con"/>
                                   
                                </td>
                            </tr>
                            
                            <tr>
                               <td >Registre N&uacute;mero de Informe:
                                </td>
                                <td >
                                     <html:text disabled="true" property="nro_inf" style="width:100px" maxlength="30" styleId="nro_inf"/>
                                   
                                </td>
                            </tr>
                            <tr>
                               <td >Registre Fecha de Informe:
                                </td>
                                <td >
                                   <html:text disabled="true" property="fec_inf" style="width:100px" maxlength="10" styleId="fec_inf"/>
                                   
                                </td>
                            </tr>
                            <tr>
                               <td >Registre N&uacute;mero de Documento de Conclusi&oacute;n:
                                </td>
                                <td >
                                     <html:text disabled="true" property="nro_doc_con" style="width:100px" maxlength="30" styleId="nro_doc_con"/>
                                   
                                </td>
                            </tr>
                            <tr>
                               <td >Registre Fecha de Documento de Conclusi&oacute;n:
                                </td>
                                <td >
                                     <html:text disabled="true" property="fec_doc_con" style="width:100px" maxlength="10" styleId="fec_doc_con"/>

                                </td>
                            </tr>
                            
                            
                            
                            <tr>
                               <td >Observaciones encontradas:
                                </td>
                           
                            <td >Contravenciones encontradas:
                                </td>
                                </tr>
                                
                           <tr>
                               <td >
                                   <table>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="ovalor" property="ovalor"/></td>
            <td height="25" width="300px"><label><strong>VALOR</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="opartida" property="opartida"/></td>
            <td height="25" width="300px"><label><strong>PARTIDA</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="oorigen" property="oorigen"/></td>
            <td height="25" width="300px"><label><strong>ORIGEN</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="osinobs" property="osinobs"/></td>
            <td height="25" width="300px"><label><strong>S/OBSERVACION</strong></label></td>
          </tr>

</table>
                                </td>
                                <td >
<table>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="comision" property="comision"/></td>
            <td height="25" width="300px"><label><strong>OMISION DE PAGO</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="ccondel" property="ccondel"/></td>
            <td height="25" width="300px"><label><strong>CONTRABANDO DELITO</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="cconcon" property="cconcon"/></td>
            <td height="25" width="300px"><label><strong>CONTRABANDO CONTRAVENCIONAL</strong></label></td>
          </tr>
<tr>
	    <td height="25"><html:checkbox disabled="true" styleId="cconadu" property="cconadu"/></td>
            <td height="25" width="300px"><label><strong>CONTRAVENCION ADUANERA</strong></label></td>
          </tr>

</table>
                                </td>
                            </tr>
                            
                            <%
                        }
                         else
                        {%>
                            <tr>
                                <td><label style="color:red">NO ESTA EN LA ETAPA CORRECTA PARA LLENAR ESTA INFORMACION</label>
                                   </td>
                            </tr>
                       
                           <% 
                        }
                        
                        
                        }
                        
                        %>
                            
                        </table></fieldset>
                        
                        
                        
                        <%
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