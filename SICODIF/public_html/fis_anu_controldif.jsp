<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>


<script language="JavaScript" type="text/JavaScript" src="js/datetimepicker_css.js"></script>
<script language="JavaScript" type="text/JavaScript" src="js/fis_anu_controldif.js"></script>

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

<html:form action="/FisAnulacioncontroldif" >
    <div id="formulario">
        <%
FisAnulControldifForm bean = (FisAnulControldifForm)request.getAttribute("FisAnulControldifForm");
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
         
          
         <h2>ANULACI&Oacute;N CONTROL DIFERIDO</h2>
         
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
                         if (bean.getEstado().equals("ASIGNADO")||bean.getEstado().equals("RESULTADOS")||bean.getEstado().equals("REGISTRADO")||bean.getEstado().equals("REGISTRADO-MIRA")||bean.getEstado().equals("NOTIFICADO"))
                        {                        
                        %>
                        
                        
                         <fieldset>
                         <table width="90%">
                            <tr><td width="7%">Fecha Anulaci&oacute;n:</td>
                                <td colspan="3" >  
                                 <%=fhoy%>
                                </td>
                            </tr>
                       
                            <tr><td width="7%">Oservaci&oacute;n:</td>
                                <td colspan="3">  
                                
                                    <html:textarea property="obsanulacion" style="width:93%"  styleId="obsanulacion"/>
                                
                                </td>
                            </tr>
                                                
                            <tr>
                               <td colspan="4" height="40px" width="60%">
                                    <center>
                                        <input type="button" name="boton"  value="Registrar Anulaci&oacute;n" onclick="guardaranul(1)"></input>                                        
                                    </center>
                                </td>
                            </tr>
                      
                        </table></fieldset>
                          <%                         
                        } else
                        {%><fieldset>
                         <table width="60%">
                            <tr>
                                <td><label style="color:red">EL CONTROL DIFERIDO NO SE ENCUENTRA HABILITADO PARA ANULACI&Oacute;N</label>
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