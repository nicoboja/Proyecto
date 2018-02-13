<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="meta.jspf"%>

<title>S.Optica | Gestinar Usuarios</title>
</head>
<body>
<%@ include file="nav.jspf" %>

	<div id="page-wrapper">
    	<div class="row">
        	<div class="col-lg-12">
            	<h1 class="page-header">Gestionar Usuarios</h1>
            </div><!-- /.col-lg-12 -->
       	</div><!-- /.row -->
        
         <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Listado de Usuarios
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
						 <table width="80%" class="table table-striped table-bordered table-hover" id="example">
                         <thead>
            					<tr>
                					<th>Usuario</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                    <th>Fecha Alta</th>
                                    <th>Estado</th>
                                    
                                    
       						   </tr>
        					</thead>
       						<tfoot>
          					  <tr>
                					<th>Usuario</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                    <th>Fecha Alta</th>
                                    <th>Estado</th>
                                    
                                   
                            </tr>
        					</tfoot>
       					 <tbody>
       					 <%if(request.getAttribute("listUss") !=null){ 
       					 
       					 
       					 
       					 %>
       					 		<tr>
                                        <td><button type="button" onclick="document.location ='ModificarUsuario'" class="btn btn-outline btn-warning text-right btn-block">n.bojanich</button></td>
                                        <td>Nicolas</td>
                                        <td>Bojanich</td>
                                        <td>nico.boja@gmail.com</td>
                                        <td>r</td>
                                        <td>r</td>
                                       
                                </tr>
                         <%} %>
        				</tbody>
   				 	</table>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            	
        	
	</div><!-- /page-wrapeper -->

<%@ include file="foot.jspf" %>

	
<script src="config/js/tablas.js"></script>
    

</body>
</html>