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

<title>S.Optica | Nuevo Usuario</title>
</head>
<body>
<%@ include file="nav.jspf" %>

	<div id="page-wrapper">
            <div class="row">
            
                <div class="col-lg-12">
                    <h1 class="page-header">Nuevo Usuario</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        Alta de <b>Usuario </b> - 
                       
                   </div>
                   <div class="panel-body">
                   <%if(request.getAttribute("infoText") !=null){ %>
                    <div class="alert alert-<%=request.getAttribute("infoTipo")%>">
                	<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
                              <big><i class="fa fa-exclamation-circle" aria-hidden="true"></i></big>
                               <%=request.getAttribute("infoText")%> : <a href="ModificarUsuario?id=<%=request.getAttribute("idmodificar")%>">modificar</a>
            		 </div> 
            		 <%} %>
                   <form name="modifica" action="NuevoUsuario" method="post">
                        <div class="row">
                        	
                        		 <div class="col-lg-6">
                         	        <div class="form-group">
                                    	<label>Usuario</label>
                                        <input class="form-control" autofocus name="usuario" id="usuario" value="">
                                    </div>
                                    <div class="form-group">
                                 	   <label>Apellido</label>
                                       <input class="form-control"  name="apellido" id="apellido" value="" >
                                    </div>
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input class="form-control" name="nombre" id="nombre" value="" >
                                    </div>
                                    <div class="form-group">
                                            <label>Correo</label>
                                            <input class="form-control" name="correon" id="correon" value="" >
                                    </div>
                                    <div class="form-group">
                                            <label>Contraseña</label>
                                            <input class="form-control" type="password" name="passn" id="passn" value="" >
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
                                                	<input type="checkbox" name="<%=n.getDescripcion()%>" id="<%=n.getDescripcion()%>" value="<%=n.getDescripcion()%>"><%=n.getDescripcion() %>
                                                	</label>
                                                <%}} %>
                                                
                                                
                                            </div>
                                            
                                            
                                            <div class="form-group">
                                           		<label>Estado:</label> 
                                            	<select id="estado" name="estado"  class="form-control ">
                                            		<option  value="Habilitado">Habilitado</option>
                                            		<option  value="Inhabilitado">Inhabilitado</option>
                                               	</select>
									      	</div>
									      	<div class="form-group">
                                            	<label>Notas Internas</label>
                                            	<textarea id="notas" name="notas" class="form-control" rows="5"></textarea>
                                        	</div>
                                       		 
                                			
                                	</div><!-- /form group -->
									      	
									      	
                                    </div><!-- /col6 -->
                              		</div><!-- /row -->	
                              		<div class="col-lg-12">
                                   <button type="submit" class="btn btn-success btn-lg btn-block ">Nuevo Usuario</button>   
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