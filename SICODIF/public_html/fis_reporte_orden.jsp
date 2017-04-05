<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="sicodif.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>

<script type="text/javascript" charset="utf-8">

function imprSelec(muestra)
{
var f = document.FisConsultaForm;
var textd = document.getElementById("direccion");

if(textd != null){
document.getElementById("direc").innerHTML=document.getElementById("direccion").value;
document.getElementById("activ").innerHTML=document.getElementById("actividad").value;
}
var ficha=document.getElementById(muestra); 
var ventimp=window.open('','popimpr');
ventimp.document.write(ficha.innerHTML);
ventimp.document.close();
ventimp.print();
ventimp.close();
}
</script>
 <input type="button" value="Imprimir" onclick="javascript:imprSelec('formulario')" />

    <div id="formulario">
    
    
    
        <%
FisConsultaForm bean = (FisConsultaForm)request.getAttribute("FisConsultaForm");
try
{
    if(!(bean.getCodfis()== null))
    {
       
        %>
      
    <table width="710px" style="font-family:'Times New Roman', 'Arial Black', times, Serif;border-color:Black ;border-style:solid;font-size:10px;border-width: 0 0 1px 1px;border-spacing: 0px;border-collapse: collapse;">
      <tr><td style="border-color:Black;border-style:solid;margin:0;border-width: 1px 1px 0 0;background-color: White;width:30px;height:0px; padding:0px"></td>
          <td style="border-color:Black;border-style:solid;margin:0;border-width: 1px 1px 0 0;background-color: White;width:100px;height:0px; padding:0px"></td>
          <td style="border-color:Black;border-style:solid;margin:0;border-width: 1px 1px 0 0;background-color: White;width:100px;height:0px; padding:0px"></td>
          <td style="border-color:Black;border-style:solid;margin:0;border-width: 1px 1px 0 0;background-color: White;width:300px;height:0px; padding:0px"></td>
          <td style="border-color:Black;border-style:solid;margin:0;border-width: 1px 1px 0 0;background-color: White;width:50px;height:0px; padding:0px"></td>
          <td style="border-color:Black;border-style:solid;margin:0;border-width: 1px 1px 0 0;background-color: White;width:130px;height:0px; padding:0px"></td>
      </tr>
      <tr><td align="center" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;width:130px; height:100px" colspan="1" ><img src="image/logo_adu_s.jpg" /></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;width:450px; height:100px" colspan="4" >
                <center><label style="font-size:16px;"><strong>ORDEN DE<br/>CONTROL DIFERIDO<br/><%=bean.getCodfis()%></strong></label></center></td>


          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;width:130px; height:100px">
                <label style="font-size:12px;"><strong>FECHA<br/><%=bean.getFecval()%></strong></label></td>
      </tr>
      <tr><td colspan="6"  style="border-color:Black;border-style:solid;margin:0;border-width: 1px 1px 0 0;background-color: White;height:10px; padding:0px; ">&nbsp;</td></tr>
      <tr><td colspan="6" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;text-align:justify">
            En aplicación del numeral I del artículo 66° y el artículo 100° de la Ley 2492 de 02 de agosto de 2003, Código Tributario Boliviano la Aduana Nacional de Bolivia ha dispuesto la verificación del cumplimiento de la normativa legal aplicable.
            </td></tr>

      <tr><td colspan="2" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><strong>I. GERENCIA</strong></td>
          <td colspan="4" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getGerencia()%></td></tr>

      <tr><td colspan="6" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><strong>II. INFORMACION DEL OPERADOR</strong></td></tr>

      <tr><td colspan="2" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">Número del NIT/C.I.:</td>
          <td colspan="4" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getNit()%></td></tr>
      <tr><td colspan="2" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">Nombre o Razón Social:</td>
          <td colspan="4" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getNombre()%></td></tr>
      <tr><td colspan="2" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">Dirección:</td>
          <td colspan="4" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getDireccion()%></td></tr>
      <tr><td colspan="2" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">Actividad Principal:</td>
          <td colspan="4" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=(bean.getActividad()!=null && bean.getActividad().trim().length()>0)   ?   bean.getActividad().substring(0, bean.getActividad().trim().length() -1)   :   ""%></td></tr>

      <tr><td colspan="6" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><strong>III. OPERACION SUJETA A FISCALIZACION</strong></td></tr>
      <tr><td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">DUI</td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getEsdui()%></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">DUE</td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getEsdue()%></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">OTRO (ESPECIFICAR)</td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">&nbsp;</td></tr>
      <tr><td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">Número:</td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getDeclaracion()%></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;">Fecha:</td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="3"><%=bean.getFecdeclaracion()%></td>

      <tr><td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="6"><strong>IV. EQUIPO DE TRABAJO ASIGNADO</strong></td></tr>

      <tr><td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="2"><strong>Cargo del Funcionario</strong></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="3"><strong>Nombres y Apellidos</strong></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><strong>C.I.</strong></td></tr>
      <tr><td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="2">JEFE UNIDAD DE FISCALIZACION/SUPERVISOR</td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="3">LIC. <%=bean.getFres_nombre()%></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" ><%=bean.getFres_ci()%></td></tr>
      <tr><td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="2">FISCALIZADOR - G.N.F.</td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;" colspan="3">LIC. <%=bean.getFfis_nombre()%></td>
          <td style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;"><%=bean.getFfis_ci()%></td></tr>
      <tr><td colspan="6" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;height:80px"></td></tr>

      <tr><td align="center" style="border-color:Black;border-style:solid;margin:0;padding:7px;border-width: 1px 1px 0 0;background-color: White;width:130px; height:100px" colspan="2" ><center>
                &nbsp;<br/>
                &nbsp;<br/>
                &nbsp;<br/>
                VºBº<br/>
                Jefe DFO/UFR
                </center>
                </td>
          <td colspan="4" style="border-color:Black;border-style:solid;margin:0;padding:7px;background-color: White;border-width: 0 1px 1px 1px;"  ><center><label style="font-size:13px;">
                &nbsp;<br/>
                &nbsp;<br/>
                
                <strong>Firma y Sello<br/>Gerente</strong></label></center></td>
      </tr>

    </table>   
        <br/><br/>
    <table width="710px"  style="font-family:'Times New Roman', 'Arial Black', times, Serif;font-size:10px;border-width:0px;border-style:none;">
      <tr><td width="33%" style="margin:0;padding:7px;background-color: White;border-width:0px;"><center>Ejemplar 1: Operador</center></td>
          <td width="33%"  style="margin:0;padding:7px;background-color: White;border-width:0px;"><center>Ejemplar 2: Expediente</center></td></tr></table>
        
        
      <%}
      
      }catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {}%> 
    </div>