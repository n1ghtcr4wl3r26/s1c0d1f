
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
        <div align="center">
            <%
    SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar fecha = Calendar.getInstance();
    fecha.setTime( fecha.getTime() );
    String fhoy = fFecha.format( fecha.getTime() );    
    String vgerencia= "";
    String vabrevgerencia= "";
    
FisRdetRecaudacionesForm bean = (FisRdetRecaudacionesForm)request.getAttribute("FisRdetRecaudacionesForm");

vabrevgerencia = bean.getGerencia();


if(vabrevgerencia.equals("%")) {
    vgerencia = "Todas las gerencias";
} else if(vabrevgerencia.equals("GRLP")){
    vgerencia = "GERENCIA REGIONAL LA PAZ";
} else if(vabrevgerencia.equals("GRCB")){
    vgerencia = "GERENCIA REGIONAL COCHABAMBA";
} else if(vabrevgerencia.equals("GRSC")){
    vgerencia = "GERENCIA REGIONAL SANTA CRUZ";
} else if(vabrevgerencia.equals("GROR")){
    vgerencia = "GERENCIA REGIONAL ORURO";
} else if(vabrevgerencia.equals("GRTJ")){
    vgerencia = "GERENCIA REGIONAL TARIJA";
} else if(vabrevgerencia.equals("GRPT")){
    vgerencia = "GERENCIA REGIONAL POTOSI";
}


try
{
    if(!(bean.getMensaje()== null))
    {
        if(!(bean.getMensaje()==""))
        {
        %>
        </div>
        <center>
            <%=bean.getMensaje()%>
        </center>
        <div align="center">
            <p>
                <%
        }
    }
}
catch(Exception ex)
{
}
%>
                 
                <strong>RESULTADOS DEUDA DETERMINADA</strong>
            </p>
            <p>&nbsp;</p>
            <div align="left">
                <table>
                    <tr>
                        <td>
                            <strong>Gerencia:</strong>
                        </td>
                        <td>
                            <%=vgerencia %>
                        </td>
                    </tr><tr>
                        <td>
                            <strong>Fecha conclusi&oacute;n desde:</strong>
                        </td>
                        <td>
                            <%=bean.getFec_desde()%>
                        </td>
                    </tr><tr>
                        <td>
                            <strong>Fecha conclusi&oacute;n hasta:</strong>
                        </td>
                        <td>
                            <%=bean.getFec_hasta()%>
                        </td>
                    </tr>
                </table>
            </div>
            <%   
    if(!(bean.getFec_desde()== null))
    {
        if(!(bean.getFec_desde()==""))
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
            call = con.prepareCall("{ ? = call pkg_reporte.reporte_det_recauda (?,?,?,?) }");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getGerencia());
            call.setString(3, bean.getFec_desde());
            call.setString(4, bean.getFec_hasta());
            call.registerOutParameter(5,-10);
            call.execute();
            rs = (String)call.getObject(1);
            tb=""; 
            
            if(rs.equals("CORRECTO"))
            {     
                    rss = (ResultSet)call.getObject(5);
 
                    %>
        </div>
        <table id='backgroun4'>
            <tr>
                <th colspan='4'>DATOS DE LA DECLARACI&Oacute;N</th>
                <th colspan='5'>MONTO DETERMINADO</th>
                <th colspan='5'>MONTO COBRADO A LA FECHA</th>
            </tr>
             
            <tr>
                <th>GERENCIA</th>
                <th>ADUANA</th>
                <th>DESCRIPCI&Oacute;N ADUANA</th>
                <th>N&Uacute;MERO DE DECLARACI&Oacute;N</th>
                <th>TRIBUTO OMITIDO GA Bs</th>
                <th>TRIBUTO OMITIDO IVA Bs</th>
                <th>TRIBUTO OMITIDO ICE Bs</th>
                <th>TRIBUTO OMITIDO IEHD Bs</th>
                <th>TOTAL TRIBUTO OMITIDO Bs</th>
                <th>TRIBUTO PAGADO GA Bs</th>
                <th>TRIBUTO PAGADO IVA Bs</th>
                <th>TRIBUTO PAGADO ICE Bs</th>
                <th>TRIBUTO PAGADO IHD Bs</th>
                <th>TOTAL TRIBUTO PAGADO</th>
            </tr>
             
            <%
                    while(rss != null && rss.next())
                    {
                    %><tr>
                <td>
                    <%=rss.getString(2)%>
                </td>
                <td>
                    <%=rss.getString(5)%>
                </td>
                <td>
                    <%=rss.getString(6)%>
                </td>
                <td>
                    <%=rss.getString(7)%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(30)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(31)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(32)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(33)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(34)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(64)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(65)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(66)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(67)).doubleValue())%>
                </td>
                <td style='text-align:right'>
                    <%=df.format(Double.valueOf(rss.getString(68)).doubleValue())%>
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
              
        }
    }
                  %>
    </div>

