<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%
  response.setHeader("Cache-control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
  //response.setHeader("Content-Disposition", "attachment; filename=\"tmp.xls\"");
  response.setHeader("Content-Disposition", "attachment; filename=\"Reporte.xls\"");
%>
<html>
<head>
  <meta name="description" content="REGPAD">
  <meta name="Author" content="Edgar Joaquin Arteaga Gutierrez" lang="es"> 
  <meta name="copyright" content="� 2013, Aduana Nacional de Bolivia" lang="es">   
   
  <title>REGPAD</title>

</head>
<body>

    <tiles:insert attribute="content" />

</body>
</html>

