<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="entity.Paciente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../meta.jspf"%>

<title>S.Optica | Buscar Paciente</title>
</head>
<body>
<%@ include file="../nav.jspf" %>

	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Buscar Paciente</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
        	<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        Inicio de busqueda de Paciente
                   		</div>
                   <div class="panel-body">
                        <div class="row">
                        	
                        <%if(request.getAttribute("infoText") !=null){ %>
                  		  <div class="alert alert-<%=request.getAttribute("infoTipo")%>">
               				 	<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>
                              <big><i class="fa fa-exclamation-circle" aria-hidden="true"></i></big>
                               <%=request.getAttribute("infoText")%>
            			 </div> 
            		 <%} %>
                        
                        <form name="buscarPaciente" action="Pacientes" method="get">
                        	 <div class="col-lg-4">
                        		 <div class="form-group">
                        		 	<label>Buscar por DNI <small>(minimo 3 caracteres)</small></label>
                                    <input class="form-control" name="dni" id="dni" autofocus type="number" maxlength=10 minlength=3>
                                 </div>
                             </div><!-- /col4 -->
                             <div class="col-lg-4">
                        		 <div class="form-group">
                        		 	<label>Buscar por Apellido <small>(minimo 3 caracteres)</small></label>
                                    <input class="form-control" name="ape" id="ape"  type="text" maxlength=20 minlength=3>
                                 </div>
                             </div><!-- /col4 -->    
                             
                                 <div class="col-lg-4">
                        		 <div class="form-group">
                        		 	<label>Busqcar por HC </label>
                                    <input class="form-control" name="hc" id="hc"  type="number" maxlength=10 >
                                 </div>
                             </div><!-- /col4 -->	
                                 <div class="col-lg-12">
                                 <button type="submit" class="btn btn-info btn-lg btn-block" >Buscar Paciente</button>  	
                                 </div><!-- /row -->	
                             </form>
                          </div>	 
                         
                         </div><!-- /panel body -->
                         
                    </div><!--  /panel default -->
                    <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Listado de Pacientes
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <div class="table-responsive">
						 <table id="example" cellspacing="0" class="table table-striped table-bordered table-hover" width="90%">
						 <!-- class="table table-striped table-bordered table-hover"    -->
                         <thead>
            					<tr>
                					<th>HC</th>
                					<th>Doc.</th>
                					<th>Apellido</th>
                                    <th>Nombre</th>
                                    <th>Correo</th>
                                    <th>Direccion</th>
                                   	<th>Ciudad</th>
                                   	<th>Celular</th>
                                   	<th>Telefono</th>
                                   	<th>Obra Social</th>
                                   	<th>N° Afiliado</th>
                                   	<th>Nacimiento</th>
                               </tr>
        					</thead>
       						<tfoot>
          					  <tr>
                					<th>HC</th>
                					<th>Doc.</th>
                					<th>Apellido</th>
                                    <th>Nombre</th>
                                    <th>Correo</th>
                                    <th>Direccion</th>
                                   	<th>Ciudad</th>
                                   	<th>Celular</th>
                                   	<th>Telefono</th>
                                   	<th>Obra Social</th>
                                   	<th>N° Afiliado</th>
                                   	<th>Nacimiento</th>
                            </tr>
        					</tfoot>
       					 <tbody>
       					 <%if(request.getAttribute("listPac") != null){
       						ArrayList<Paciente> listPac = (ArrayList<Paciente>)request.getAttribute("listPac");
       	            		for(Paciente p: listPac){
       						 %>
           							<tr>
                                        <td><button title="Historia Clinica" type="button" onclick="document.location ='Atenciones?hc=<%=p.getIdPac()%>'" class="btn btn-outline btn-primary text-right btn-block"><%=p.getIdPac() %></button></td>
                                        <td><button title="Datos del Paciente" type="button" onclick="document.location ='ModificarPaciente?id=<%=p.getIdPac()%>'" class="btn btn-outline btn-info text-right btn-block"><%=p.getNroDoc() %></button></td>
                                        <td><%=p.getApellido()%></td>
                                        <td><%=p.getNombre() %></td>
                                        <td><a href="mailto:nico.boja@gmail.com"><%=p.getCorreo() %></a></td>
                                        <td><%=p.getDireccion() %></td>
                                   		<td><%=p.getCiudad() %></td>
                                   		<td><%=p.getCelular() %></td>
                                   		<td><%=p.getTelefono()%></td>
                                   		<td><%=p.getOs() %></td>
                                   		<td><%=p.getNroOs() %></td>
                                   		<td><%=p.getFecNac() %></td>
                                	</tr>
                           <%} }%>        
 							  </tbody>
    					</table>
                            <!-- /.table-responsive -->
                          </div>  
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
         
                </div><!-- /col12 -->
        </div>   <!-- /row -->
	</div><!-- /page-wrapeper -->

<%@ include file="../foot.jspf" %>
<script src="config/js/tablas.js"></script>
</body>
</html>