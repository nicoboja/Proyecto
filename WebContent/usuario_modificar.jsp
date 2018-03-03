<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.Usuario"%>
    <%@page import="entity.Nivel"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="meta.jspf"%>

<title>S.Optica | Modificar Usuario</title>
</head>
<body>
<%@ include file="nav.jspf" %>

	<div id="page-wrapper">
            <div class="row">
            
                <div class="col-lg-12">
                    <h1 class="page-header">Modificar Usuario</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        Datos de <b><%=((Usuario)request.getAttribute("ussM")).getUser() %></b> -  Fecha Alta: <%=((Usuario)request.getAttribute("ussM")).getFecAlta() %>
                       
                   </div>
                   <div class="panel-body">
                   <%if(request.getAttribute("infoText") !=null){ %>
                    <div class="alert alert-<%=request.getAttribute("infoTipo")%>">
                	<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
                              <big><i class="fa fa-exclamation-circle" aria-hidden="true"></i></big>
                               <%=request.getAttribute("infoText")%> 
            		 </div> 
            		 <%} %>
                   <form name="modifica" action="ModificarUsuario" method="post">
                        <div class="row">
                        	<input id="id" hidden type="text" name="id" value="<%=((Usuario)request.getAttribute("ussM")).getIdU() %>">
                        		 <div class="col-lg-6">
                         	        <div class="form-group">
                                    	<label>Usuario</label>
                                        <input class="form-control" name="usuario" id="usuario" disabled="disabled" value="<%=((Usuario)request.getAttribute("ussM")).getUser() %>">
                                    </div>
                                    <div class="form-group">
                                 	   <label>Apellido</label>
                                       <input class="form-control" autofocus name="apellido" id="apellido" value="<%=((Usuario)request.getAttribute("ussM")).getApellido() %>" >
                                    </div>
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input class="form-control" name="nombre" id="nombre" value="<%=((Usuario)request.getAttribute("ussM")).getNombre() %>" >
                                    </div>
                                    <div class="form-group">
                                            <label>Correo</label>
                                            <input class="form-control" name="correo" id="correo" value="<%=((Usuario)request.getAttribute("ussM")).getCorreo() %>" >
                                    </div>
                                    <div class="form-group">
                                            <label>Contraseña: <%=((Usuario)request.getAttribute("ussM")).getPass() %></label>
                                            <input class="form-control" type="password" name="pass" id="pass" value="<%=((Usuario)request.getAttribute("ussM")).getPass() %>" >
                                    </div>
                                 </div><!-- /col6 -->
                                 
                                 <div class="col-lg-6">
                                 
                                
                                   	
                                        <div class="form-group">
                                            <label>Roles</label>
                                            <div class="checkbox">
                                                
                                                 <% if(request.getAttribute("nivBD") !=null){ 
                                                	 ArrayList<Nivel> listNivBD = (ArrayList<Nivel>)request.getAttribute("nivBD");
                                                	 for(Nivel n : listNivBD){
                                                 %>
                                                 	<label>
                                                	<input type="checkbox" name="<%=n.getDescripcion()%>" id="<%=n.getDescripcion()%>" value="<%=n.getDescripcion()%>" 
                                                	<%
                                                	ArrayList<Nivel> listNivUss = ((Usuario)request.getAttribute("ussM")).getNivel();
                                                	for(Nivel u: listNivUss){if(u.getDescripcion().equals(n.getDescripcion())){
                                                		
                                                		%>
                                                		checked
                                                		<% 
                                                	}}
                                                	%>><%=n.getDescripcion() %>
                                                	</label>
                                                <%}} %>
                                                
                                                
                                            </div>
                                            
                                            <input value="<%=((Usuario)request.getAttribute("ussM")).getFecEstado() %>" id="fecEstado" name="fecEstado" hidden>
                                            
                                            <div class="form-group">
                                           		<label>Estado: <%=((Usuario)request.getAttribute("ussM")).getEstado() %></label> el día <%=((Usuario)request.getAttribute("ussM")).getFecEstado() %>
                                            	<select id="estado" name="estado"  class="form-control ">
                                            		<option <%if(((Usuario)request.getAttribute("ussM")).getEstado().equals("Habilitado")){ %>selected<%} %> value="Habilitado">Habilitado</option>
                                            		<option <%if(((Usuario)request.getAttribute("ussM")).getEstado().equals("Inhabilitado")){ %>selected<%} %> value="Inhabilitado">Inhabilitado</option>
                                               	</select>
									      	</div>
									      	<div class="form-group">
                                            	<label>Notas Internas</label>
                                            	<textarea id="notas" name="notas" class="form-control" rows="5"><%=((Usuario)request.getAttribute("ussM")).getNotas() %></textarea>
                                        	</div>
                                       		 
                                			
                                	</div><!-- /form group -->
									      	
									      	
                                    </div><!-- /col6 -->
                              		</div><!-- /row -->	
                              		<div class="col-lg-12">
                                   <button type="submit" class="btn btn-warning btn-lg btn-block ">Modificar</button>   
                                </form>
                                </div>	 
                         </div><!-- /panel body -->
                    </div><!--  /panel default -->
                </div><!-- /col12 -->
        </div>   <!-- /row -->
   	</div><!-- /page-wrapeper -->                                   
                                       
                          
<%@ include file="foot.jspf" %>
</body>
</html>