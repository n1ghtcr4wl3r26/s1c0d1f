<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
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
        document.FisRegistroForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
  
        
  };
  
  function cancelar(valor) {
        $('#boton').val('cancelar');
      document.FisRegistroForm.submit();
  };
  function registrar(valor) {
      var Mensaje = "";
     if( ! fTrim( $('#fiscalizador').val() ) ){
        Mensaje = Mensaje + "'Fiscalizador' es obligatorio\n";
        }
      
     
    
      if( Mensaje == "" )
      {
        $('#boton').val('registrar');
      document.FisRegistroForm.submit();
      }
      else
      {
        alert( Mensaje );
        return false;
      }
      
       
  };
</script>

<html:form action="/FisRegistro" >
    <div id="formulario">
        <%
FisRegistroForm bean = (FisRegistroForm)request.getAttribute("FisRegistroForm");
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
         
        <h2>INICIO CONTROL DIFERIDO</h2>
         
        <br/>
        <div id="form_registro">
            <fieldset>
            <input type="hidden" name="boton" id="boton" />
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
                        if(bean.getEstado().equals("VACIO"))
                        {%>
                        <fieldset><table width="60%">
                        <tr><td colspan="2" height="40px">Fiscalizador:</td><td colspan="2" height="40px"><%=Util.DevuelveFiscalizadores(bean.getUsugerencia())%></td></tr>
                            <tr>
                                <td colspan="4" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar Control Diferido"
                                               onclick="registrar(1)"></input>
                                        <input type="button" value="Cancelar"  name="boton"   onclick="cancelar(1)"></input>
                                    </center>
                                </td>
                            </tr>
                        </table></fieldset>
                        <%    
                        } 
                        %><%
                    }
                %>
                    
                
                
            
        </div>
        
        
    </div>
</html:form>