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
        document.FisReciboForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar_enm');
      document.FisReciboForm.submit();
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
     
  
  if( ! fTrim( $('#fecha_aceptacion').val() ) ){
        Mensaje = Mensaje + "'Fecha Aceptaci\363n' es obligatorio\n";
      }
       else{
          if( ! fFecha( $('#fecha_aceptacion').val() ) ){
            Mensaje = Mensaje + "'Fecha Aceptaci\363n' no tiene el formato dd/mm/aaaa\n";
          } 
          else
          {
          if ( !ComparaFechas($('#fecha_liquidacion').val(),$('#fecha_aceptacion').val()))
                 Mensaje = Mensaje + "'La Fecha de Aceptaci\363n' no puede ser anterior a la 'Fecha de Liquidaci\363n'. \n";
            if ( !ComparaFechas($('#fecha_aceptacion').val(),diames + "/" + mes + "/" + ano))
                 Mensaje = Mensaje + "'La Fecha de Aceptaci\363n' no puede ser mayor a la de hoy. \n";
          }
      }
      
      
      
      if( Mensaje == "" )
      {
        $('#boton').val('registrar_enm');
        document.FisReciboForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
  
  };
  
  
  
  function eliminafec(valor) {
  var Mensaje = "";
  
  
  
  
      
      
      if( Mensaje == "" )
      {
        $('#boton').val('eliminafec_enm');
        document.FisReciboForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
  
  };
  
  function registrar2(valor) {
  var Mensaje = "";
  
      
      if( ! fTrim( $('#tipo_deuda').val() ) ){
        Mensaje = Mensaje + "'Tipo Deuda' es obligatorio\n";
      }
      
      if( ! fTrim( $('#monto').val() ) ){
        Mensaje = Mensaje + "'Monto' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#monto').val() ) ){
            Mensaje = Mensaje + "'Monto' debe ser un n\372mero\n";
          } 
      }
      
     if( ! fTrim( $('#rec_gestion').val() ) ){
        Mensaje = Mensaje + "'Gesti\363n' es obligatorio\n";
      }
      else{
          if( ! foNumero( $('#rec_gestion').val() ) ){
            Mensaje = Mensaje + "'Gesti\363n' debe ser un n\372mero\n";
          } 
      }
      
      if( ! fTrim( $('#rec_aduana').val() ) ){
        Mensaje = Mensaje + "'Aduana' es obligatorio\n";
      }
      
      if( ! fTrim( $('#rec_numero').val() ) ){
        Mensaje = Mensaje + "'N\372mero' es obligatorio\n";
      }
       else{
          if( ! foNumero( $('#rec_numero').val() ) ){
            Mensaje = Mensaje + "'N\372mero de Recibo' debe ser un n\372mero\n";
          } 
      }
      
     
      
      if( Mensaje == "" )
      {
        $('#boton').val('registrar2_enm');
        document.FisReciboForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
  
  };
  
  
  
   function eliminar(valor) {
      $('#boton').val('eliminar_enm');
      $('#id').val(valor);
      document.FisReciboForm.submit();
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

<html:form action="/FisRecibo" >
    <div id="formulario">
        <%
FisReciboForm bean = (FisReciboForm)request.getAttribute("FisReciboForm");
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
         
         <h2>ENMIENDA REGISTRO DE PAGOS</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
              <input type="hidden" name="boton" id="boton" />
              <input type="hidden" name="id" id="id" />
              
            <html:hidden property="fecha_liquidacion" styleId="fecha_liquidacion" />
            <html:hidden property="fecha_aceptacion_valid" styleId="fecha_aceptacion_valid" />
            <html:hidden property="cd_gestion" styleId="cd_gestion" />
            <html:hidden property="cd_gerencia" styleId="cd_gerencia" />
            <html:hidden property="cd_numero" styleId="cd_numero" />
            
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
                        
                        if (bean.getEstado().equals("CIERRE")||bean.getEstado().equals("RESULTADOS")||bean.getEstado().equals("FINALIZADO")||bean.getEstado().equals("NOTIFICADO CONCLUIDO")||bean.getEstado().equals("ENVIO LEGAL"))
                        {   
                        
                       
                        %>
                        <fieldset>
                         <table width="60%">
                            <tr>
                               <td >Registre Fecha de Aceptaci&oacute;n:
                                </td>
                            
                                <td >
                                   
                                        
<table><tr><td><html:text property="fecha_aceptacion" style="width:100px" maxlength="10" styleId="fecha_aceptacion"/>
                                       
  </td><td><img src="img/calendar_1.png" id="imcal" style="cursor:pointer;" onclick="javascript:NewCssCal('fecha_aceptacion','ddMMyyyy')" />
                               </td></tr>
                               </table>
                               
                               
                                </td>
                            </tr>
                          
                            
                            
                            <tr>
                               <td colspan="2" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar"
                                               onclick="registrar(1)"></input>
                                        <input type="button" name="boton"  value="Eliminar"
                                               onclick="eliminafec(1)"></input>
                                        <input type="button" value="Cancelar"  name="boton"   onclick="cancelar(1)"></input>
                                    </center>
                                </td>
                            </tr>
                        </table>
                        </fieldset>
                        
                        <%
                       
                        
                        
                        
                        
                        %>
                        
                        
                        
                        
                        <fieldset>
              <table width="60%">
                            <tr>
                               <td >Tipo de Deuda Pagada:
                                </td>
                            
                                <td >
                                <html:select property="tipo_deuda" styleId="tipo_deuda">
                                 <html:option value="">-- Seleccione el Tipo --</html:option>
                                 <html:option value="TRIBUTO OMITIDO GA">TRIBUTO OMITIDO GA</html:option>
                                 <html:option value="TRIBUTO OMITIDO IVA">TRIBUTO OMITIDO IVA</html:option>
                                 <html:option value="TRIBUTO OMITIDO ICE">TRIBUTO OMITIDO ICE</html:option>
                                 <html:option value="TRIBUTO OMITIDO IEHD">TRIBUTO OMITIDO IEHD</html:option>
                                 <html:option value="SANCION OP">SANCION OP</html:option>
                                 <html:option value="CONTRAVENCION ADUANERA">CONTRAVENCION ADUANERA</html:option>
                                 <html:option value="CONTRABANDO CONTRAVENCIONAL">CONTRABANDO CONTRAVENCIONAL</html:option>
                                 <html:option value="CONTRABANDO DELITO">CONTRABANDO DELITO</html:option>
                                 <html:option value="MULTA POR ABANDONO">MULTA POR ABANDONO</html:option>
                                 </html:select>
                            </td></tr>
                            
                            <tr>
                               <td >Monto Pagado en Bs:
                                </td>
                            
                                <td >
                                <html:text property="monto" style="width:100px" maxlength="20" styleId="monto"/>
                            </td></tr>
                            
                            <tr>
                               <td >Gesti&oacute;n:
                                </td>
                            
                                <td >
                                <html:text property="rec_gestion" style="width:100px" maxlength="4" styleId="rec_gestion"/>
                            </td></tr>
                             <tr>
                               <td >Aduana:
                                </td>
                            <td>
                        <%=Util.DevuelveRecAduanas(bean.getRec_aduana())%>
                           
                        </td></tr>
                            
                            <tr>
                               <td >N&uacute;mero de Recibo Unico Pago:
                                </td>
                            
                                <td >
                                <table><tr><td>R-</td><td><html:text property="rec_numero" style="width:100px" maxlength="10" styleId="rec_numero"/></td></tr></table>
                                
                            </td></tr>  
                            
                             <tr>
                               <td colspan="2" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar"
                                               onclick="registrar2(1)"></input>
                                        <input type="button" value="Cancelar"  name="boton"   onclick="cancelar2(1)"></input>
                                    </center>
                                </td>
                            </tr>
              
              </table>
               </fieldset>
            <%
        if(1==1)
        {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        Connection cn =null;
        ResultSet rs= null;
        String res = "";
        
        
        int c = 1;
        try
        {
        cn = dc.abrirConexion();
        call = cn.prepareCall("{? = call pkg_sicodif.lista_recibos( ?,?,?,?) }");
        call.registerOutParameter(1, OracleTypes.VARCHAR);
        call.setString(2, bean.getCd_gestion());
        call.setString(3, bean.getCd_gerencia());
        call.setString(4, bean.getCd_numero());
        call.registerOutParameter(5,-10);
        call.execute();
        res = (String)call.getObject(1);
               
            if(res.equals("CORRECTO"))
            {
                    rs = (ResultSet)call.getObject(5);
        
        
        
        if( ! ( rs == null || !rs.next() ) )
        {%>
      
        </br>
         <fieldset>
         <table id='backgroun2'  >
         <caption>LISTA DE RECIBOS</caption>
         <tr>
          
          
          <th>Nro</th>
          <th>Tipo Deuda</th>
          <th>Monto</th>
          <th>Nro. de Recibo</th>
          <th>Fecha de Pago</th>
          <th>&nbsp;</th> 
          </tr><%
          do{  %>         
          <tr>
          <td><%=c%></td>
          <td><%=rs.getString(2)%></td>
          <td><%=rs.getString(3)%></td>
          <td><%=rs.getString(4)%></td>
          <td><%=rs.getString(5)%></td>
          <td><input type="button" value="Eliminar" onclick="eliminar('<%=rs.getString(1)%>')" class="boton" ></input></td>
          </tr>
         
<% 
c = c+1;

} while( rs.next()  );

}

%></table> </fieldset><%
        }
  }
   catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {
    try 
    {  
      if (con != null) con.close();
          dc.Cierra(cn,rs);
    }
    catch (SQLException er) 
    {
      ;
    }
  }
 }
%>
            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        <%
                        
                      
                            }
                            
                            else
                            {
                            
                            
                            %><fieldset>
                         <table width="60%">
                            <tr>
                                <td><label style="color:red">DEBE HABERSE REGISTRADO POR LO MENOS LA ETAPA DE REGISTRO DE RESULTADOS EN EL CONTROL DIFERIDO, PARA REALIZAR LA ENMIENDA DE LA INFORMACION</label>
                                </td>
                            </tr>
                        </table>
                         </fieldset>
                           <% 
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
        if(1==1)
        {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        Connection cn =null;
        ResultSet rs= null;
        String res = "";
        
        
        int c = 1;
        try
        {
        cn = dc.abrirConexion();
        call = cn.prepareCall("{? = call pkg_sicodif.lista_recibos( ?,?,?,?) }");
        call.registerOutParameter(1, OracleTypes.VARCHAR);
        call.setString(2, bean.getCd_gestion());
        call.setString(3, bean.getCd_gerencia());
        call.setString(4, bean.getCd_numero());
        call.registerOutParameter(5,-10);
        call.execute();
        res = (String)call.getObject(1);
               
            if(res.equals("CORRECTO"))
            {
                    rs = (ResultSet)call.getObject(5);
        
        
        
        if( ! ( rs == null || !rs.next() ) )
        {%>
      
        </br>
         <fieldset>
         <table id='backgroun2'  >
         <caption>LISTA DE RECIBOS</caption>
         <tr>
          
          
          <th>Nro</th>
          <th>Tipo Deuda</th>
          <th>Monto</th>
          <th>Nro. de Recibo</th>
          <th>Fecha de Pago</th>
         
          </tr><%
          do{  %>         
          <tr>
          <td><%=c%></td>
          <td><%=rs.getString(2)%></td>
          <td><%=rs.getString(3)%></td>
          <td><%=rs.getString(4)%></td>
          <td><%=rs.getString(5)%></td>
         
          </tr>
         
<% 
c = c+1;

} while( rs.next()  );

}

%></table> </fieldset><%
        }
  }
   catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {
    try 
    {  
      if (con != null) con.close();
          dc.Cierra(cn,rs);
    }
    catch (SQLException er) 
    {
      ;
    }
  }
 }
                        
                            
                            
                            }
                            
                            
                            
                            
                           
                        
                        
                        %><%
                    }
                %>
                    
                
              
            
            
        </div>
         
         
         
        
    </div>
</html:form>