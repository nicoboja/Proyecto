<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.Paciente"%>

    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="meta.jspf"%>

<title>S.Optica | Modificar Paciente</title>
</head>
<body>
<%@ include file="nav.jspf" %>

	<div id="page-wrapper">
            <div class="row">
            
                <div class="col-lg-12">
                    <h1 class="page-header">Modificar datos de Paciente</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        Ficha de paciente: <b><%=((Paciente)request.getAttribute("pacM")).getApellido() %> <%=((Paciente)request.getAttribute("pacM")).getNombre()%>"</b> - 
                       
                   </div>
                   <div class="panel-body">
                   <%if(request.getAttribute("infoText") !=null){ %>
                    <div class="alert alert-<%=request.getAttribute("infoTipo")%>">
                	<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
                              <big><i class="fa fa-exclamation-circle" aria-hidden="true"></i></big>
                               <%=request.getAttribute("infoText")%>
            		 </div> 
            		 <%} %>
                   <form name="modificarPaciente" action="ModificarPaciente" method="post">
                        <div class="row">
                         <input class="form-control" type="hidden" name="id" id="id" value="<%=((Paciente)request.getAttribute("pacM")).getIdPac()%>">
                        	
                        		 <div class="col-lg-6">
                         	        <div class="form-group">
                                    	<label>DNI</label>
                                        <input class="form-control" autofocus name="dni" id="dni" maxlength="10" id="dni" required value="<%=((Paciente)request.getAttribute("pacM")).getNroDoc()%>">
                                    </div>
                                    <div class="form-group">
                                 	   <label>Apellido</label>
                                       <input class="form-control"  name="apellido" id="apellido" maxlength="25" required value="<%=((Paciente)request.getAttribute("pacM")).getApellido()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input class="form-control" name="nombre" id="nombre" maxlength="25" required value="<%=((Paciente)request.getAttribute("pacM")).getNombre()%>">
                                    </div>
                                    <div class="form-group">
                                            <label>Correo</label>
                                            <input class="form-control" name="correo" id="correo" type="email" maxlength="30" required value="<%=((Paciente)request.getAttribute("pacM")).getCorreo()%>">
                                    </div>
                                    <div class="form-group">
                                            <label>Direccion</label>
                                            <input class="form-control" type="text" name="dir" id="dir" maxlength="30" required value="<%=((Paciente)request.getAttribute("pacM")).getDireccion()%>">
                                    </div>
                                    <div class="form-group">
                                            <label>Ciudad</label>
                                            <input class="form-control" type="text" name="ciudad" id="ciudad" maxlength="25" required value="<%=((Paciente)request.getAttribute("pacM")).getCiudad()%>">
                                    </div>
                                 </div><!-- /col6 -->
                                 
                                 <div class="col-lg-6">
                                	 <div class="form-group">
                                            <label>Celular</label>
                                            <input class="form-control" type="number" name="cel" id="cel" maxlength="15" required value="<%=((Paciente)request.getAttribute("pacM")).getCelular()%>">
                                    </div>
                                 	<div class="form-group">
                                            <label>Telefono fijo</label>
                                            <input class="form-control" name="tel" id="tel" maxlength="15" required value="<%=((Paciente)request.getAttribute("pacM")).getTelefono()%>">
                                    </div>
                                
                                   	<div class="form-group">
                                    	<label>Obra Social</label>
                                        <input class="form-control" autofocus name="osocial" id="osocial" maxlength="25" value="<%=((Paciente)request.getAttribute("pacM")).getOs()%>">
                                    </div>
                                    <div class="form-group">
                                 	   <label>Nº Afiliado</label>
                                       <input class="form-control"  name="nroaf" id="nroaf" maxlength="25" value="<%=((Paciente)request.getAttribute("pacM")).getNroOs()%>">
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha Nacimiento</label>
                                        <input class="form-control" type="date" name="fecnac" id="fecnac" value="<%=((Paciente)request.getAttribute("pacM")).getFecNac()%>">
                                    </div>
                                    
                                    </div><!-- /form group -->
									      	
									      	
                                    </div><!-- /col6 -->
                              		<!-- /row -->	
                              		<div class="col-lg-12">
                              			<div class="form-group">
                                            	<label>Notas Internas</label>
                                            	<textarea id="notas" name="notas" class="form-control" rows="5" value="<%=((Paciente)request.getAttribute("pacM")).getNota()%>"><%=((Paciente)request.getAttribute("pacM")).getNota()%></textarea>
                                     	</div>
                                     	</div>
                                     	
                              		<div class="col-lg-12">
                              		
                                   <button type="submit" class="btn btn-warning btn-lg btn-block ">Modificar ficha de Paciente</button>   
                                
                                </div>	
                                </div>
                                </form> 
                         </div><!-- /panel body -->
                    </div><!--  /panel default -->
                </div><!-- /col12 -->
        </div>   <!-- /row -->
   	</div><!-- /page-wrapeper -->                                   
                                       
                          
<%@ include file="foot.jspf" %>
</body>
</html>