<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<link href="css/menu.css" rel="stylesheet" type="text/css"/>
<link href="css/tabla.css" rel="stylesheet" type="text/css"/>
<div id="formulario">
    <%
    SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar fecha = Calendar.getInstance();
    fecha.setTime( fecha.getTime() );
    String fhoy = fFecha.format( fecha.getTime() );
    String vgerencia= "";
    String vabrevgerencia= "";
    FisRconcierreForm bean = (FisRconcierreForm)request.getAttribute("FisRconcierreForm");
    try
    {
        if(!(bean.getMensaje()== null))
        {
            if(!(bean.getMensaje()==""))
            {
                %>
     
    <center>
        <%=bean.getMensaje()%>
    </center>
     
    <%
            }
        }
    }
    catch(Exception ex)
    {
    }
    %>
    <div align="center">
        <h2>REPORTE DE CONTROLES DIFERIDOS CONCLUIDOS CON CIERRE</h2>
        <div align="left">
            <%
                if(bean.getBoton().equals("consultar"))
                {
                    %>
            <table>
                <tr>
                    <td>
                        <strong>Fecha Registro Desde:</strong>
                    </td>
                    <td>
                        <%=bean.getFec_desde()%>
                    </td>
                </tr>
                 
                <tr>
                    <td>
                        <strong>Fecha Registro hasta:</strong>
                    </td>
                    <td>
                        <%=bean.getFec_hasta()%>
                    </td>
                </tr>
            </table>
            <%
                }
            %>
        </div>
    </div>
    <%   
    if(!(bean.getBoton()== null))
    {
        if(!(bean.getBoton()=="consultar") || !(bean.getBoton()=="consultar2"))
        {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        DecimalFormat d = new DecimalFormat("#,###,###.##", simbolos);
        d.setMaximumFractionDigits(2);
        d.setMinimumFractionDigits(2);
        DecimalFormat df = new DecimalFormat("#,###,###.##", simbolos);
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        DecimalFormat ufv = new DecimalFormat("###.#####", simbolos);
        d.setMaximumFractionDigits(4);
        d.setMinimumFractionDigits(4);
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String rs = "OK";
        String tb = "";
        ResultSet rss = null;
        try {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_reporte.reporteconcierre (?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getFec_desde());
            call.setString(3, bean.getFec_hasta());
            call.registerOutParameter(4,-10);
            call.execute();
            rs = (String)call.getObject(1);
            tb=""; 
            if(rs.equals("CORRECTO"))
            {     
                rss = (ResultSet)call.getObject(4);
            %>
    <table id='backgroun5' cellspacing="0">
        <tr>
            <th>ADUANA</th>
            <th>N&Uacute;MERO DECLARACI&Oacute;N</th>
            <th>N&Uacute;MERO ORDEN DE CONTROL</th>
            <th>FECHA CIERRE</th>
            <th>FISCALIZADOR QUE EFECTU&Oacute; EL CIERRE</th>
            <th>FISCALIZADOR ASIGNADO</th>
            <th>JUSTIFICATIVO</th>
        </tr>
        <%
        while(rss != null && rss.next())
        {
        %>
        <tr>
            <td>
                <%=rss.getString(1)%>
            </td>
            <td>
                <%=rss.getString(2)%>
            </td>
            <td>
                <%=rss.getString(3)%>
            </td>
            <td>
                <%=rss.getString(4)%>
            </td>
            <td>
                <%=rss.getString(5)%>
            </td>
            <td>
                <%=rss.getString(6)%>&nbsp;
            </td>
            <td>
                <%=rss.getString(7)%>&nbsp;
            </td>
        </tr>
         
        <%
        }       
        %>
    </table>
    <div align="left" style="font-size:11px">
        Fecha y hora de generaci&oacute;n del reporte: 
        <%=fhoy%>
    </div>
    <% 
            }
            else
            {
                %>NO EXISTE INFORMACION PARA EL REPORTE<% 
            }
        } catch (Exception er) {
            tb = "ERROR: "+er.toString();
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
        }
    }
    %>
</div>