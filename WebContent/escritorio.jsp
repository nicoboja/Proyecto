<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="meta.jspf"%>

<title>S.Optica | Escritorio</title>
</head>
<body>
<%@ include file="nav.jspf" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Escritorio</h1>
        </div><!-- /.col-lg-12 -->
    </div><!-- /.row -->
        	
    <div class="row">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-tasks fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("nnuevos")%></div>
                            <div>Nuevas Entradas!</div>
                        </div>
                    </div><!--/row-->
                </div><!--/panel headings-->
                <%if((int)request.getAttribute("nnuevos")!=0){%>
                    <a href="#">
                    <div class="panel-footer">
                        <span class="pull-left">Ver detalle</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                    </a>
                <% } %>
            </div>
        </div><!--/terminados-->
        
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-yellow">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-wrench fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("ntaller")%></div>
                            <div>En Taller!</div>
                        </div>
                    </div>
                </div>
                <%if((int)request.getAttribute("ntaller")!=0){%>
                <a href="#">
                <div class="panel-footer">                
                    <span class="pull-left">Ver Detalles</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>                              
                </div>
                </a>
                <% } %>
            </div>
        </div>

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-red">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                        <i class="fa fa-exclamation-circle fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("nterminados")%></div>
                            <div>Terminados!</div>
                        </div>
                    </div>
                </div>
                <%if((int)request.getAttribute("nterminados")!=0){%>
                <a href="#">
                    <div class="panel-footer">
                        <span class="pull-left">Ver detalle</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
                <% } %>
            </div>
        </div>
        
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-thumbs-o-up fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge"><%=request.getAttribute("ncomunicados")%></div>
                            <div>Comunicados!</div>
                        </div>
                    </div>
                </div>
                 <%if((int)request.getAttribute("ncomunicados")!=0){%>
                <a href="#">
                <div class="panel-footer">
                    <span class="pull-left">Ver Detalles</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
                </a>
                <% } %>
            </div>
        </div>
    </div> <!-- ROW -->
   <!--  / ALERTAS -->   
   	<div class="row">
  	    <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bell fa-fw"></i> Notificaciones
                </div><!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="list-group">
                    	
                        <a href="#" class=" list-group-item">
                            <strong class="text-warning"><i class="fa fa-adjust fa-fw"></i> Lente Recetado Taller</strong> - Gomez Alberto -
                            <span class="pull-right text-muted small"><em>13/10/2017 10:26</em></span>
                        </a>
                        
                        <a href="#" class="list-group-item">
                            <strong class="text-success"><i class="fa fa-low-vision fa-fw"></i> Lente Contacto Nuevo</strong> - Pedro Perez
                            <span class="pull-right text-muted small"><em>13/10/2017 10:15</em></span>
                        </a>
                        <a href="#" class="list-group-item">
                            <strong class="text-danger"><i class="fa fa-adjust fa-fw"></i> Lente Recetado Terminado</strong> - Rawson Veronica
                            <span class="pull-right text-muted small"><em>13/10/2017 10:10</em></span>
                        </a>
                        <a href="#" class="list-group-item">
                            <strong class="text-primary"><i class="fa fa-adjust fa-fw"></i> Lente Recetado Comunicado</strong> - Mauricio Castro
                            <span class="pull-right text-muted small"><em>13/10/2017 10:05</em>
                            </span>
                        </a>
                        <a href="#" class="list-group-item">
                            <strong class="text-success"><i class="fa fa-assistive-listening-systems fa-fw"></i> Audiometria Nueva</strong> - Andrea Andina
                            <span class="pull-right text-muted small"><em>13/10/2017 10:00</em> 
                            </span>
                        </a>
                        <a href="#" class="list-group-item">
                        	<strong class="text-muted"><i class="fa fa-low-vision fa-fw"></i> Lente Contacto Entregado</strong> - Celeste Cisneros
                            <span class="pull-right text-muted small"><em>13/10/2017 09:01</em>
                            </span>
                        </a>
                        <a href="#" class="list-group-item">
                            <strong class="text-danger"><i class="fa fa-adjust fa-fw"></i> Lente Recetado Terminado</strong> - Mauricio Castro
                            <span class="pull-right text-muted small"><em>13/10/2017 09:00</em>
                            </span>
                        </a>
                        <a href="#" class="list-group-item">
                           <strong class="text-success"><i class="fa fa-adjust fa-fw"></i> Lente Recetado Nuevo</strong> - Rawson Veronica
                            <span class="pull-right text-muted small"><em>13/10/2017 08:05</em>
                            </span>
                        </a>
                        <a href="#" class="list-group-item">
                            <strong class="text-muted"><i class="fa fa-adjust fa-fw"></i> Lente Recetado Entregado</strong> - Hugo Ponce
                            <span class="pull-right text-muted small"><em>12/10/2017 19:05</em>
                            </span>
                        </a>
                    </div><!-- /.list-group -->
                    
                </div><!-- /.panel-body -->
            </div><!-- /.panel -->
        </div><!-- /col6 Panel Notificaciones-->
        
        <div class="col-lg-6">      
            <div class="chat-panel panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-comments fa-fw"></i> Chat Interno
                </div><!-- /.panel-heading -->
                    <div class="panel-body">
                        <ul class="chat">
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <strong class="primary-font">c.smerialdino</strong>
                                        <small class="pull-right text-muted">
                                            <i class="fa fa-clock-o fa-fw"></i> 12/10/2017 10:58
                                        </small>
                                    </div>
                                    <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                    </p>
                                </div>
                            </li>
                            <li class="right clearfix">
                                <span class="chat-img pull-right">
                                    <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <small class=" text-muted">
                                            <i class="fa fa-clock-o fa-fw"></i> 12/10/2017 10:30</small>
                                        <strong class="pull-right primary-font">p.bruch</strong>
                                    </div>
                                    <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                    </p>
                                </div>
                            </li>
                            <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <strong class="primary-font">c.smerialdino</strong>
                                            <small class="pull-right text-muted">
                                            <i class="fa fa-clock-o fa-fw"></i> 12/10/2017 9:00</small>
                                    </div>
                                    <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                    </p>
                                </div>
                            </li>
                            <li class="right clearfix">
                                <span class="chat-img pull-right">
                                    <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header">
                                        <small class=" text-muted">
                                            <i class="fa fa-clock-o fa-fw"></i> 11/10/2017 16:58</small>
                                            <strong class="pull-right primary-font">p.bruch</strong>
                                    </div>
                                    <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
                                    </p>
                                </div>
                            </li>
                        </ul>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <div class="input-group">
                                <input id="btn-input" type="text" class="form-control input-sm" placeholder="Escribe tu mensaje aqui...">
                                <span class="input-group-btn">
                                    <button class="btn btn-warning btn-sm" id="btn-chat">
                                        Enviar
                                    </button>
                                </span>
                            </div>
                        </div>
                        <!-- /.panel-footer -->
                    </div><!-- Chat Panel-->
                </div>
         </div><!--ROW--> 

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-pencil-square-o fa-fw"></i> Notas Personales
               		</div>  <!-- /.panel-heading -->
                	<div class="panel-body">
                    	<div class="form-group">
                        	<textarea class="form-control" rows="10" id="comment"></textarea>
                    	</div>
                    	<div>
                        	<button type="button" class="btn btn-outline btn-primary btn-lg btn-block">Guardar</button>
                    	</div>
                	</div>
            	</div>
        	</div>     
       </div><!-- /row -->
                    	
	</div><!-- /page-wrapeper -->

<%@ include file="foot.jspf" %>
</body>
</html>