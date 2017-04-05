<%@ page import="cliente.bean.ClaseUsuario" %>
<div id="header_content">
            <div id="top">
            	<div class="blogname">
                	<h1 id="logo">&nbsp;</h1>
                </div>
             
            </div>
            <div id="nav">
                <ul id="main-nav" class="clearfix">
                    <% ClaseUsuario cs = (ClaseUsuario) request.getSession().getAttribute("ClaseUsuario");
                       if(cs!=null) { %>
                          <li><img src="icouser.png" width="15" height="27"></li>
                          <li><label><strong>USUARIO:</strong><%=cs.getUsuario()%></label></li>
                          <li><label><strong>PERFIL:</strong><%=cs.getPerfil()%></label> </li>
                    <% } %>
                </ul>
            </div>
</div>


