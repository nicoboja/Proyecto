<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../meta.jspf"%>

<title>S.Optica | Nueva Ficha</title>
</head>
<body>
<%@ include file="../nav.jspf" %>

	<div id="page-wrapper">
            <div class="row">
            
                <div class="col-lg-12">
                    <h1 class="page-header">Nueva Ficha</h1>
                </div><!-- /.col-lg-12 -->
        	</div><!-- /.row -->
			<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
<!--                        	<label>Documento</label> -->
<!--                        	<span class="form-inline"> -->
                         	        		
<!--                                   				<div class="checkbox"> -->
<!--                                                 	<label> -->
<!--                                                     	<input type="checkbox" value="" checked >      DNI   -->
<!--                                                 	</label> -->
<!--                                             	</div> -->
<!--                                             	<div class="checkbox"> -->
<!--                                                 	<label> -->
<!--                                                     	<input type="checkbox" value="" >      LE -->
<!--                                                 	</label> -->
<!--                                             	</div> -->
<!--                                             	<div class="checkbox"> -->
<!--                                                 	<label> -->
<!--                                                     	<input type="checkbox" value="" >     PAS -->
<!--                                                 	</label> -->
<!--                                             	</div> -->
<!--                                             	<div class="checkbox"> -->
<!--                                                 	<label> -->
<!--                                                     	<input type="checkbox" value="" >     NV -->
<!--                                                 	</label> -->
<!--                                             	</div> -->
                                            
<!--                                        </span>   -->
<!--                            <form class="form-inline"> -->
<!--  								<div class="form-group"> -->
<!--    									<input type="text" class="form-control lg input-sm" id="exampleInputName2" placeholder="Ingrese documento a validar"> -->
<!--   								</div> -->
  
<!--  								<button class="btn btn-info btn-sm" id="btn-chat"> -->
<!--                                 	<i class="fa fa-check" aria-hidden="true"></i> -->
<!--                                         Validar Usuario -->
<!--                                 </button> -->
<!-- 							</form> -->

<div class="row">
  <div class="col-xs-10">
    
    	<span class="form-inline">
    	<label>Tipo de Documento: </label>
                         	        		
                                  				<div class="checkbox">
                                                	<label>
                                                    	<input type="checkbox" value="" checked >      DNI  
                                                	</label>
                                            	</div>
                                            	<div class="checkbox">
                                                	<label>
                                                    	<input type="checkbox" value="" >      LE
                                                	</label>
                                            	</div>
                                            	<div class="checkbox">
                                                	<label>
                                                    	<input type="checkbox" value="" >     PAS
                                                	</label>
                                            	</div>
                                            	
                                       
                                        <input type="text" class="form-control lg input-sm" autofocus id="exampleInputName2" placeholder="Ingrese documento">
   <button class="btn btn-info btn-sm" id="btn-chat">
   <i class="fa fa-check" aria-hidden="true"></i>
Validar Usuario 
                                </button>
                                          


                                	
  <button type="button" class="btn btn-outline btn-danger btn-sm"> <i class="fa fa-times" aria-hidden="true"></i>  No validar</button>
   </div>
  </span>
  
</div>
                           
                        </div>
                     <div class="panel-body">
                        <div class="row">
                        <div class="col-lg-12">
                        <div class="alert alert-success alert-dismissable">
                	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                               <i class="fa fa-lg fa-exclamation-circle" aria-hidden="true"></i>
                               Nueva ficha creada con exito!
                		</div>
                        </div>
                        		 <div class="col-lg-4">
                         	        <div class="form-group">
                         	        	<label>Documento</label>
                                        <input class="form-control" name="usuario" id="usuario" >
                                        
                                    </div>
                                    <div class="form-group">
                                 	   <label>Apellido</label>
                                       <input class="form-control" name="apellido" id="apellido" >
                                    </div>
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input class="form-control" name="nombre" id="nombre" >
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha Nacimiento</label>
                                        <input class="form-control" type="date" name="nombre" id="nombre" >
                                    </div>
                                    
                                 </div><!-- /col4 -->
                                 
                                 <div class="col-lg-4">
                                   	
                                        
                                            <div class="form-group">
                                            <label>Correo</label>
                                            <input class="form-control" name="correo" id="correo" >
                                    </div>
                                    <div class="form-group">
                                            <label>Celular</label>
                                            <input class="form-control" name="correo" id="correo" >
                                    </div>
                                    <div class="form-group">
                                            <label>Telefono</label>
                                            <input class="form-control" name="correo" id="correo" >
                                    </div>
                                    <div class="form-group">
                                            <label>Domicilio</label>
                                            <input class="form-control" name="correo" id="correo" >
                                    </div>
									 	
                                    </div><!-- /col4 -->
                                    <div class="col-lg-4">
                                    
                                    
                                    <div class="form-group">
                                            <label>Ciudad</label>
                                            <input class="form-control" name="correo" id="correo" >
                                    </div>
                                    <div class="form-group">
                                            <label>Provincia</label>
                                            <input class="form-control" name="correo" id="correo" >
                                    </div>
                                    <div class="form-group">
                                            <label>Pais</label>
                                            <input class="form-control" name="correo" id="correo" >
                                    </div>
                                    </div><!-- /col4 -->
                              		</div><!-- /row -->	
                              		<div class="col-lg-12">
                                   <div class="form-group">
                                            	<label>Notas Internas </label>
                                            	<small>maximo 360 caracteres</small>
                                            	<textarea class="form-control" rows="3" maxlength="360"></textarea>
                                        	</div>
                                       		<button type="button" class="btn btn-success  btn-lg btn-block">Crear Usuario</button>    
                                				
                                	</div><!-- /form group -->
                                </div>	 
                         </div><!-- /panel body -->
                   </div><!--  /panel default -->
                </div><!-- /col12 -->
        </div>   <!-- /row -->
   	</div><!-- /page-wrapeper -->                                   
                                       
                          
<%@ include file="../foot.jspf" %>
</body>
</html>