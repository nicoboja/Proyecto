<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <h1 class="page-header">Historial Clinica Paciente</h1>
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
                        	 <div class="col-lg-4">
                        		 <div class="form-group">
                        		 	<label>Busqueda <small>(minimo 3 caracteres)</small></label>
                                    <input class="form-control" name="busqueda" id="busqueda" autofocus>
                                 </div>
                             </div><!-- /col4 -->
                                 
                             <div class="col-lg-4">
                                  <p><label>Filtro de busqueda:  </label></p>
                                  <span class="form-inline">
                                  		<div class="checkbox">
                                                <label>
                                                    <input type="checkbox" value="" checked >      Ambos  
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" value="" >      DNI
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" value="" >     Apellido y Nombre
                                                </label>
                                            </div>
                                            
                                       </span>  
                                   	
                                 </div><!-- /col 4 -->
                                 <div class="col-lg-4">
                        		 <div class="form-group">
                        		 	<label>Busqueda por HC <small>(minimo 3 numeros)</small></label>
                                    <input class="form-control" name="busquedaHC" id="busquedaHC" >
                                 </div>
                             </div><!-- /col4 -->	
                                 <div class="col-lg-12">
                                 <button type="button" class="btn btn-info btn-lg btn-block">Buscar</button>  	
                                 </div><!-- /row -->	
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
                					<th >HC</th>
                					<th  >Doc.</th>
                					<th >Nombre</th>
                                    <th >Apellido</th>
                                    <th >Correo</th>
                                    <th >Telefono</th>
                                   	<th >Direccion</th>
                                   	<th >Ciudad</th>
                                   	<th >Prov.</th>
                                   	<th >Pais</th>
                               </tr>
        					</thead>
       						<tfoot>
          					  <tr>
                					<th >HC</th>
                					<th >Documento</th>
                					<th >Nombre</th>
                                    <th >Apellido</th>
                                    <th >Correo</th>
                                    <th >Telefono</th>
                                   	<th >Direccion</th>
                                   	<th >Ciudad</th>
                                   	<th >Provincia</th>
                                   	<th >Pais</th>
                            </tr>
        					</tfoot>
       					 <tbody>
           							<tr>
                                        <td><button type="button" onclick="document.location ='../pages/usuario_modificar.jsp'" class="btn btn-outline btn-primary text-right btn-block">2001</button></td>
                                        <td><button type="button" onclick="document.location ='../pages/usuario_modificar.jsp'" class="btn btn-outline btn-info text-right btn-block">32658293</button></td>
                                        <td>Nicolas</td>
                                        <td>Bojanich</td>
                                        <td><a href="mailto:nico.boja@gmail.com">nico.boja@gmail.com</a></td>
                                        <td>(3461) 154670874 </td>
                                   		<td>Rivadavia 189 Dpto 2</td>
                                   		<td>San Nicolas</td>
                                   		<td>Buenos Aires</td>
                                   		<td>Argentina</td>
                                	</tr>
                                   
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
<script src="../config/js/tablas.js"></script>
</body>
</html>