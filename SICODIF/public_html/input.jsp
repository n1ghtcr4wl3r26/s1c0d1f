<%@ page contentType="text/html;charset=iso-8859-1" %>
<%@ page import="sicodif.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<title>SICODIF</title>
<script language="JavaScript" type="text/JavaScript" src="js/valida.js"></script>
<script language="JavaScript" type="text/JavaScript" src="js/usuario.js"></script>
 <link href="css/style_index.css" rel="stylesheet" type="text/css"  />

 <script type="text/javascript">
  function NoAtras(){
    history.go(1);
  }  
</script>

</head>
<body onLoad="NoAtras();">


<div id="body_wrap">
	<div id="header">
    	<div id="header_content">
            <div id="top">
            	<div class="blogname">
                	<h1 id="logo"></h1>
                </div>
             
            </div>
             
        </div>
	</div>
	<div id="page_wrap" class="clearfix">
       
       <%
inputActionForm me = (inputActionForm)request.getAttribute("inputActionForm");
try
{
    if(!(me.getFmensaje()== null))
    {
        if(!(me.getFmensaje()==""))
        {
        %><center><%=me.getFmensaje()%></center><%
        }
    }
}
catch(Exception ex)
{
}
%>
<div class="CentraLL">

	<html:form action="/ingreso" focus="usuario" onsubmit="return fEvalua()">
		<fieldset>
			<legend style="color: #5C8BA8">Ingreso</legend>
      <table>
      <tr><td width="95">Usuario:</td><td width="118"><html:text property="usuario" onkeyup="javascript:this.value=this.value.toUpperCase();" maxlength="15" size="20" /></td></tr>
      <tr><td width="95">Contraseña:</td><td width="118"><html:password property="clave" maxlength="15" size="20" redisplay="false" /></td></tr>
      
      <tr><td colspan="2" style="text-align:center"> 
				<html:submit styleClass="btnStyleOut" property="" style=" background-color:#5C8BA8; color:#fff;" value="Ingresar" />
               
			</td></tr>
      </table>
			
			
		</fieldset>
	</html:form>
<script type="text/javascript" language="JavaScript">
  <!--
  var focusControl = document.forms["inputActionForm"].elements["usuario"];

  if (focusControl.type != "hidden" && !focusControl.disabled) {
     focusControl.focus();
  }
  // -->
</script>

  
   	
</div>
       
        
        </div> <!-- close page_wrap --> 
        
        
	</div> <!-- close body_wrap -->

<div id="footer" style="position:absolute;display:block;bottom:0;left:0">
            <div id="footer_content">
            	<span>
               	&copy; 2016 Aduana Nacional de Bolivia - Todos los derechos reservados - ver 1.1 </span></div>
        </div>

</body>
</html>