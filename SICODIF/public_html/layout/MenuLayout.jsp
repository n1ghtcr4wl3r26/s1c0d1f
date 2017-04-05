<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cliente.bean.ClaseOpcion"%>
<%@ page import="sicodif.*"%>
<script language="JavaScript" type="text/javascript">
function env(opcion) {
  var f=document.forms["beanMenu"];
  f.opcion.value=opcion;
  f.submit();
}
</script>
<html:form action="/MenuAction">
<html:hidden property="opcion"/>
</html:form>
<tiles:importAttribute />
<%
    inputActionForm iform = (inputActionForm) request.getSession().getAttribute("inputActionForm");
    Iterator i=iform.getOpciones().iterator();
%>
<div id='cssmenu'>
    <ul>
<%
while(i.hasNext()){        
    ClaseOpcion bean = (ClaseOpcion) i.next();    
    if(bean.getAccion()==null || bean.getAccion().equals("-")){
%>
    <li><label><%=bean.getDesc()%></label></li>    
<%
    }else{
%>
    <li><a href="javascript:env('<%=bean.getAccion()%>')"><span><%=bean.getDesc()%></span></a></li>    
<%
    }
}
%>  
<li><label>&nbsp;</label></li>
  </ul>    
</div>
