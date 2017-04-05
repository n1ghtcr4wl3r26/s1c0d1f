<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page import="javax.sql.PooledConnection"%>
<%@ page import="oracle.jdbc.pool.OracleConnectionPoolDataSource"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<script type="text/javascript" charset="utf-8">
  $(document).ready(function () {

  });
</script>
<script type="text/javascript" charset="utf-8">
  function cancelar(valor) {
      $('#boton').val('cancelar');
      document.FisDecAsigForm.submit();
  };

  function dui(valor1, valor2, valor3) {
      var Mensaje = "";
      var f = document.forms["FisDecAsigForm"];
      f.key_year.value = valor1;
      f.key_cuo.value = valor2;
      f.reg_serial.value = valor3;

      if (Mensaje == "") {
          $('#boton').val('registrar');
          document.FisDecAsigForm.submit();
      }
      else {
          alert(Mensaje);
          return false;
      }

  };

  function rechazar(valor1, valor2, valor3) {
      var Mensaje = "";
      var f = document.forms["FisDecAsigForm"];
      f.key_year.value = valor1;
      f.key_cuo.value = valor2;
      f.reg_serial.value = valor3;

      if (Mensaje == "") {
          $('#boton').val('rechazar');
          document.FisDecAsigForm.submit();
      }
      else {
          alert(Mensaje);
          return false;
      }

  };

  function orden(valor1, valor2, valor3) {
      var Mensaje = "";
      var f = document.forms["FisDecAsigForm"];
      f.key_year.value = valor1;
      f.key_cuo.value = valor2;
      f.reg_serial.value = valor3;

      if (Mensaje == "") {
          $('#boton').val('orden');
          document.FisDecAsigForm.submit();
      }
      else {
          alert(Mensaje);
          return false;
      }

  };
</script>
<html:form action="/FisDecAsig">
    <div id="formulario">
        <html:hidden property="key_year" value=""/>
         
        <html:hidden property="key_cuo" value=""/>
         
        <html:hidden property="reg_serial" value=""/>
         
        <html:hidden property="boton" styleId="boton"/>
         
        <html:hidden property="gerencia" styleId="gerencia"/>
         
        <%
FisDecAsigForm bean = (FisDecAsigForm)request.getAttribute("FisDecAsigForm");
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
         
        <h2>DECLARACIONES PARA ASIGNAR</h2>
         
        <br/>
        <div id="form_registro">
            <%if(!(bean == null))
                    { 
                        %><fieldset>
                <%
                                
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;
        String link;
        
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_sicodif.bandeja_supervisor (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getGerencia());
            call.setString(3, "estado");
            call.registerOutParameter(4,-10);
            call.execute();
            rs = (String)call.getObject(1);
            tb=""; 
            
            if(rs.equals("CORRECTO"))
            {     
                
                
                    rss = (ResultSet)call.getObject(4);

                   
                     %>
                <table id='backgroun3'>
                    <caption>LISTADO DE DECLARACIONES PARA ASIGNAR</caption>
                     
                    <tr>
                        <th>No.</th>
                        <th width='15%'>Declaraci&oacute;n</th>
                        <th>Patr&oacute;n</th>
                        <th>&Iacute;tems</th>
                        <th>Importador</th>
                        <th>NIT Importador</th>
                        <th>Fecha Levante</th>
                        <th>Orden de CD</th>
                        <th>Fiscalizador</th>
                        <th>Fecha Registro</th>
                        <th>Origen</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                     
                    <%
                    String ia;
                    String rechazar;
                    String orden;
                    int c=1;
                    while(rss != null && rss.next())
                    {
                        ia="javascript:dui("+rss.getString(1)+","+rss.getString(2)+","+rss.getString(3)+");";
                        rechazar="javascript:rechazar("+rss.getString(1)+","+rss.getString(2)+","+rss.getString(3)+");";
                        
                        orden="javascript:orden("+rss.getString(1)+","+rss.getString(2)+","+rss.getString(3)+");";
                       if(rss.getString(13) == null)
                       {
                       
                        link = "<a onclick=window.open('"+rss.getString(14)+"/repduiform.jsp?gestion="+rss.getString(1)+"&aduana="+rss.getString(2)+"&registro="+rss.getString(3)+"&bandera=0','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >";
                        link = link + rss.getString(1)+"/"+rss.getString(2)+"/C-"+rss.getString(3)+"</a></td>";
                                              
                        %><tr>
                        <td>
                            <%=c%>
                        </td>
                        <td>
                            <%=link%>
                        </td>
                        <td>
                            <%=rss.getString(4)%>
                        </td>
                        <td>
                            <%=rss.getString(5)%>
                        </td>
                        <td>
                            <%=rss.getString(7)%>
                        </td>
                        <td>
                            <%=rss.getString(6)%>
                        </td>
                        <td>
                            <%=rss.getString(8)%>
                        </td>
                        <td>
                            <%=rss.getString(9)%>
                        </td>
                        <td>
                            <%=rss.getString(10)%>
                        </td>
                        <td>
                            <%=rss.getString(11)%>
                        </td>
                        <td>
                            <%=rss.getString(12)%>
                        </td>
                        <td>
                            <a href='<%=ia%>' style='color:#0f69b4; font-weight:900;'>Procesar</a>
                        </td>
                        <td>
                            <a href='<%=rechazar%>' style='color:#0f69b4; font-weight:900;'>Rechazar</a>
                        </td>
                    </tr><%
                   
                       }
                       else
                       {
                       
                       link = "<a onclick=window.open('"+rss.getString(14)+"/repduiform.jsp?gestion="+rss.getString(1)+"&aduana="+rss.getString(2)+"&registro="+rss.getString(3)+"&bandera=0','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >";
                        link = link + rss.getString(1)+"/"+rss.getString(2)+"/C-"+rss.getString(3)+"</a></td>";
                                              
                        %><tr>
                        <td>
                            <%=c%>
                        </td>
                        <td>
                            <%=link%>
                        </td>
                        <td>
                            <%=rss.getString(4)%>
                        </td>
                        <td>
                            <%=rss.getString(5)%>
                        </td>
                        <td>
                            <%=rss.getString(7)%>
                        </td>
                        <td>
                            <%=rss.getString(6)%>
                        </td>
                        <td>
                            <%=rss.getString(8)%>
                        </td>
                        <td>
                            <a href='<%=orden%>' style='color:#0f69b4; font-weight:900;'>
                                <%=rss.getString(9)%></a>
                        </td>
                        <td>
                            <%=rss.getString(10)%>
                        </td>
                        <td>
                            <%=rss.getString(11)%>
                        </td>
                        <td>
                            <%=rss.getString(12)%>
                        </td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr><%
                        }
                    
                        c=c+1;      
                    }
                    
                    
                    
                    %>
                </table>
                <%
                    
                
                   
                }
            else
            {
                    %>
                NO EXISTEN DECLARACIONES PARA ASIGNAR
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
                        
                        %>
            </fieldset><%
                    }
                %>
        </div>
    </div>
</html:form>