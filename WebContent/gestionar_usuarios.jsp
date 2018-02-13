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
                                    
                                    
       						   </tr>
        					</thead>
       						<tfoot>
          					  <tr>
                					<th>Usuario</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                   
                            </tr>
        					</tfoot>
       					 <tbody>
           						<tr>
                                        <td><button type="button" onclick="document.location ='../pages/usuario_modificar.jsp'" class="btn btn-outline btn-warning text-right btn-block">n.bojanich</button></td>
                                        <td>Nicolas</td>
                                        <td>Bojanich</td>
                                        <td>nico.boja@gmail.com</td>
                                   		
                                       
                                    </tr>
                                    <tr >
                                        <td><button type="button" class="btn btn-outline btn-warning text-right btn-block">b.alessandri</button></td>
                                        <td>Bruno</td>
                                        <td>Alessandri</td>
                                        <td>bruno@gmail.com</td>
                                        
                                    </tr>
                                    <tr>
                                        <td><button type="button" class="btn btn-outline btn-warning text-right btn-block">c.smerialdino</button></td>
                                        <td>Claudia</td>
                                        <td>Smerialdino</td>
                                        <td>smerialdino@gmail.com</td>
                                       
              						</tr>
                                    <tr>
                                        <td><button type="button" class="btn btn-outline btn-warning text-right btn-block btn">p.bruch</button></td>
                                        <td>Pedro</td>
                                        <td>Bruch</td>
                                        <td>bruchpedro@hotmail.com</td>
                                        
                                    </tr>
                                    <tr>
                                        <td><button type="button" class="btn btn-outline btn-warning text-right btn-block">a.avendaño</button></td>
                                        <td>Alejandra</td>
                                        <td>Avendaño</td>
                                        <td>aleavendaño@hotmail.com</td>
                                    </tr>
                                    <tr >
                                        <td><button type="button" class="btn btn-outline btn-warning text-right btn-block">l.gomez</button></td>
                                        <td>Leticia</td>
                                        <td>Gomex</td>
                                        <td>leti002@hotmail.com</td>
                                       
                                    </tr>
                                    <tr >
                                        <td><button type="button" class="btn btn-outline btn-warning text-right btn-block">g.caprioti</button></td>
                                        <td>German</td>
                                        <td>Caprioti</td>
                                        <td>german.caprioti@hotmail.com
 									</td>
                                       
                                    </tr>
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