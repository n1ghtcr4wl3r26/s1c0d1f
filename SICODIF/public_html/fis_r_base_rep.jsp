<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>


<link href="css/style.css" rel="stylesheet" type="text/css"  />
  <link href="css/menu.css" rel="stylesheet" type="text/css"  />

  <link href="css/tabla.css" rel="stylesheet" type="text/css"  />
    <div id="formulario">
  <div align="center">
    <%
    SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Calendar fecha = Calendar.getInstance();
    fecha.setTime( fecha.getTime() );
    String fhoy = fFecha.format( fecha.getTime() );

    String vgerencia= "";
    String vabrevgerencia= "";
    
FisRbaseForm bean = (FisRbaseForm)request.getAttribute("FisRbaseForm");

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
  </div><center>
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
            <p>&nbsp;</p>
            <div align="left">
            <%
                if(bean.getBoton().equals("consultar"))
                {
                    %>
                    <table>
                    <tr>
                        <td>
                            <strong>Gerencia:</strong>
                        </td>
                        <td>
                            <%=vgerencia %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <strong>	Fecha Registro Desde: </strong>
                        </td>
                        <td>
                            <%=bean.getFec_desde()%>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <strong>	Fecha Registro hasta:</strong>
                        </td>
                        <td>
                            <%=bean.getFec_hasta()%>
                        </td>
                    </tr>
                    <%
                    if(!(bean.getNit().equals("")))
                    {
                        %>
                        <tr>
                        <td>
                            <strong>	NIT:</strong>
                        </td>
                        <td>
                            <%=bean.getNit()%>
                        </td>
                    </tr>
                        <%
                    }
                    %>
                    </table>
                    <%
                }
                if(bean.getBoton().equals("consultar2"))
                {   
                    %>
                    <table>
                    <tr>
                        <td>
                            <strong>Declaraci&oacute;n:</strong>
                        </td>
                        <td>
                            <%=bean.getSad_reg_year() %>/<%=bean.getKey_cuo() %>/C-<%=bean.getSad_reg_nber() %>
                        </td>
                    </tr>
                    </table>
                    <%
                }
            
            %>
            
                
            </div>
            

       

    </p>
    <p>
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
            if(bean.getBoton().equals("consultar"))
            {
                call = con.prepareCall("{ ? = call pkg_reporte.reportebase (?,?,?,?,?) }");
                call.registerOutParameter(1, OracleTypes.VARCHAR);
                call.setString(2, bean.getGerencia());
                call.setString(3, bean.getFec_desde());
                call.setString(4, bean.getFec_hasta());
                call.setString(5, bean.getNit());
                call.registerOutParameter(6,-10);
            }
            if(bean.getBoton().equals("consultar2"))
            {
                call = con.prepareCall("{ ? = call pkg_reporte.reportebasedui (?,?,?,?) }");
                call.registerOutParameter(1, OracleTypes.VARCHAR);
                call.setString(2, bean.getSad_reg_year());
                call.setString(3, bean.getKey_cuo());
                call.setString(4, bean.getSad_reg_nber());
                call.registerOutParameter(5,-10);
            }
            call.execute();
            rs = (String)call.getObject(1);
            tb=""; 
            
            if(rs.equals("CORRECTO"))
            {     
                if(bean.getBoton().equals("consultar"))
                {
                    rss = (ResultSet)call.getObject(6);
                }
                if(bean.getBoton().equals("consultar2"))
                {   
                    rss = (ResultSet)call.getObject(5);
                }
 
            %>
    </p>
  </div>
      <table id='backgroun5' cellspacing="0" >
        <tr>
          <th colspan='4'>NUMERO DE CONTROL DIFERIDO</th>
          <th colspan='16'>DATOS DE LA DECLARACION</th>
          <th colspan='6'>NOTIFICACION</th>
          <th colspan='13'>RESULTADOS CONTROL DIFERIDO</th>
          <th colspan='2'>ACEPTACION DE PAGO</th>
          <th colspan='7'>CONCLUSION DEL CONTROL DIFERIDO</th>
          <th colspan='4'>OBSERVACIONES ENCONTRADAS</th>
          <th colspan='4'>OBSERVACIONES EN CONTRAVENCIONES ENCONTRADAS</th>
          <th colspan='3'>NOTIFICACION DEL DOCUMENTO DE CONCLUSION AL OPERADOR</th>
          <th colspan='3'>ENVIO A LA UNIDAD LEGAL</th>
          <th colspan='1' rowspan="2">ESTADO DEL CONTROL DIFERIDO (REGISTRADO - ASIGNADO - NOTIFICADO - RESULTADOS -
                                      CONCLUIDO - CONCLUIDO NOTIFICADO - ENVIO LEGAL)</th>
          <th colspan='12'>RECUPERACION - PAGO</th>
          <th colspan='3'>OTRAS DATOS</th>
        </tr>
         
        <tr>
          <th>GESTION</th>
          <th>GERENCIA</th>
          <th>NUMERO CORRELATIVO POR GESTION</th>
          <th>FECHA DE LA ORDEN DE CONTROL</th>
          
          <th>ADUANA</th>
          <th>DESCRIPCION ADUANA</th>
          <th>NUMERO DE DECLARACION</th>
          <th>CANAL</th>
          <th>Nº DE NIT/CI IMPORTADOR</th>
          <%//10%><th>NOMBRE IMPORTADOR</th>
          
          <th>Nº DE NIT/CI DECLARANTE</th>
          <th>NOMBRE DECLARANTE</th>
          <th>DIRECCION PROVEEDOR</th>
          <th>PROVEEDOR</th>
          <th>TOTAL VALOR FOB DECLARADO $us ULTIMA</th>
          <th>TRIBUTO DECLARADO GA Bs</th>
          <th>TRIBUTO DECLARADO IVA Bs</th>
          <th>TRIBUTO DECLARADO ICE Bs</th>
          <th>TRIBUTO DECLARADO IHD Bs</th>
          <%//20%><th>TOTAL TRIBUTO DECLARADOS Bs</th>
          
          <th>USUARIO FISCALIZADOR</th>
          <th>USUARIO QUE REGISTRO LA ASIGNACION</th>
                    
          <th>FECHA NOTIFICACION</th>
          <th>OBSERVACION NOTIFICACION</th>
          <th>TIPO NOTIFICACION (CEDULA - PERSONAL - TACITO - EDICTO)</th>
          <th>USUARIO QUE REALIZO LA NOTIFICACION</th>
               
          <th>VALOR FOB DETERMINADO POR FISCALIZACION</th>
                    
          <th>FECHA LIQUIDACION</th>
          <th>VALOR UFV DE LA FECHA DE LIQUIDACION</th>
          <%//30%><th>TRIBUTO OMITIDO GA Bs</th>
          <th>TRIBUTO OMITIDO IVA Bs</th>
          <th>TRIBUTO OMITIDO ICE Bs</th>
          <th>TRIBUTO OMITIDO IEHD Bs</th>
          <th>TOTAL TRIBUTO OMITIDO Bs</th>
          <th>SANCION OMISION Bs</th>
          <th>MULTA CONTRAVENCION Bs</th>
          <th>MULTA CONTRABANDO CONTRAVENCIONAL Bs</th>
          <th>MULTA CONTRABANDO DELITO Bs</th>
          <th>USUARIO QUE REGISTRO LOS RESULTADOS</th>
          <%//40%><th>FECHA ACEPTACION DE PAGO</th>
          <th>USUARIO QUE REGISTRO LA ACEPTACION</th>
          
          <th>TIPO DOCUMENTO DE CONCLUSION</th>
          <th>NUMERO INFORME</th>
          <th>FECHA DE INFORME</th>
          <th>NUMERO DE DOCUMENTO DE CONCLUSION</th>
          <th>FECHA DE DOCUMENTO DE CONCLUSION</th>
          <th>FECHA DE FINALIZACION DEL CONTROL DIFERIDO</th>
          <th>USUARIO QUE REGISTRO LA FINALIZACION</th>
          
          <th>VALOR</th>
          <%//50%><th>PARTIDA</th>
          <th>ORIGEN</th>
          <th>SIN OBSERVACION</th>
          
          <th>OMISION DE PAGO</th>
          <th>CONTRABANDO DELITO</th>
          <th>CONTRABANDO CONTRAVENCIONAL</th>
          <th>CONTRAVENCION ADUANERA</th>
          
          <th>FECHA DE NOTIFICACION</th>
          <th>TIPO DE NOTIFICACION (CEDULA - PERSONA - TACITO - EDICTO - SECRETARIA)</th>
          <th>USUARIO QUE REGISTRO LA NOTIFICACION DEL DOCUMENTO DE CONCLUSION</th>
          <%//60%><th>FECHA ENVIO</th>
          <th>NUMERO DE DOCUMENTO DE REMISION</th>
          <th>USUARIO QUE REALIZO LA REMISION A LA UNIDAD LEGAL</th>
          
          
          <th>TRIBUTO PAGADO GA Bs</th>
          <th>TRIBUTO PAGADO IVA Bs</th>
          <th>TRIBUTO PAGADO ICE Bs</th>
          <th>TRIBUTO PAGADO IHD Bs</th>
          <th>TOTAL TRIBUTO PAGADO</th>
          <th>SANCION OMISION Bs</th>
          <th>MULTA CONTRAVENCIONAL ADUANERA Bs</th>
          
          <th>MULTA CONTRABANDO CONTRAVENCIONAL Bs</th>
          <th>MULTA CONTRABANDO DELITO Bs</th>
          <th>USUARIO QUE REGISTRO LOS RESULTADOS</th>          
          <th>ORIGEN</th>
          <th>FECHA CONTROL</th>
          
          <th>PASE SALIDA SIDUNEA</th>
          
          <th>MERCANCIA</th>
          
          <th>CRITERIO NIVEL CABECERA</th>
          
        </tr>
         
        <%
                    while(rss != null && rss.next())
                    {
                    %><tr>
                      <td><%=rss.getString(1)%></td>
                      <td><%=rss.getString(2)%></td>
                      <td><%=rss.getString(3)%></td>
                      <td><%=rss.getString(4)%></td>
                      
                      <td><%=rss.getString(5)%></td>
                      <td><%=rss.getString(6)%></td>
                      <td><%=rss.getString(7)%></td>
                      <td><%=rss.getString(8)%></td>
                      <td><%=rss.getString(9)%></td>
                      <%//10%><td><%=rss.getString(10)%></td>
                      <td><%=rss.getString(11)%></td>
                      <td><%=rss.getString(12)%></td>
                      <td><%=rss.getString(13)%></td>
                      <td><%=rss.getString(14)%></td>
                      
                      <% if(rss.getString(15) == null) {%>
                      <td style='text-align:right'>0</td>
                      <%} else {%>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(15)).doubleValue())%></td>
                      <%}%>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(16)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(17)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(18)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(19)).doubleValue())%></td> 
                      <%//20%><td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(20)).doubleValue())%></td>
                      
                      
                      <td><%=rss.getString(21)%></td>
                      <td><%=rss.getString(22)%></td>
                                
                      <td><%=rss.getString(23)%></td>
                      <td><%=rss.getString(24)%></td>
                      <td><%=rss.getString(25)%></td>
                      <td><%=rss.getString(26)%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(27)).doubleValue())%></td>
                     
                    
                      <td><%=rss.getString(28)%></td>
                      
                      
                      <td style='text-align:right'><%=rss.getString(29).replace(".",",")%></td>
                      <%//30%><td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(30)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(31)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(32)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(33)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(34)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(35)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(36)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(37)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(38)).doubleValue())%></td>
                      
                      <td><%=rss.getString(39)%></td>
                      <%//40%><td><%=rss.getString(40)%></td>
                      <td><%=rss.getString(41)%></td>
                      
                      <td><%=rss.getString(42)%></td>
                      <td><%=rss.getString(43)%></td>
                      <td><%=rss.getString(44)%></td>
                      <td><%=rss.getString(45)%></td>
                      <td><%=rss.getString(46)%></td>
                      <td><%=rss.getString(47)%></td>
                      <td><%=rss.getString(48)%></td>
                      
                      <td><%=rss.getString(49)%></td>
                      <%//50%><td><%=rss.getString(50)%></td>
                      <td><%=rss.getString(51)%></td>
                      <td><%=rss.getString(52)%></td>
                     
                      <td><%=rss.getString(53)%></td>
                      <td><%=rss.getString(54)%></td>
                      <td><%=rss.getString(55)%></td>
                      <td><%=rss.getString(56)%></td>
                     
                      <td><%=rss.getString(57)%></td>
                      <td><%=rss.getString(58)%></td>
                      <td><%=rss.getString(59)%></td>
                      <%//60%><td><%=rss.getString(60)%></td>
                      <td><%=rss.getString(61)%></td>
                      <td><%=rss.getString(62)%></td>
                      
                      
                      <td><%=rss.getString(63)%></td>
                      
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(64)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(65)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(66)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(67)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(68)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(69)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(70)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(71)).doubleValue())%></td>
                      <td style='text-align:right'><%=df.format(Double.valueOf(rss.getString(78)).doubleValue())%></td>
                      
                      
                      <td><%=rss.getString(72)%></td>
                      <td><%=rss.getString(73)%></td>
                      
                      <td><%=rss.getString(74)%></td>
                      
                      <td><%=rss.getString(75)%></td>
                      
                      <td><%=rss.getString(76)%></td>
                      <td><%=rss.getString(77)%></td>
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
    </div>
    
    