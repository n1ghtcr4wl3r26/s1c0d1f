
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta name="description" content="RegPad" />
  <meta name="Author" content="Edgar Joaquin Arteaga Gutierrez" lang="es"/> 
  <title>Registro de Fiscalizacion Aduanera Posterior</title>
  <link href="css/style.css" rel="stylesheet" type="text/css"  />
  <link href="css/menu.css" rel="stylesheet" type="text/css"  />
 <script type="text/javascript">
  function NoAtras(){
    history.go(1);
  }  
</script>
</head>

<body onLoad="NoAtras();">
<div id="body_wrap">
	<div id="header">
		<tiles:insert attribute="header" />
	</div>
    
	<div id="page_wrap" class="clearfix">
    
		<div id="content_holder" class="clearfix">
            <div id="main_content_right_side">
            	<tiles:insert attribute="content" />
           
			</div>    
		</div>
	</div>
	
</div>

<div id="footer">
     <tiles:insert attribute="footer" />       
</div>

</body>
</html>